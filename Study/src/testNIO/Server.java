package testNIO;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }

    //启动服务器方法
    public void start() throws IOException {
        //（1）创建Selector---抛IOException
        Selector selector = Selector.open();

        //（2）创建ServerSocketChannel，并绑定监听端口---抛IOException
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(8888));

        //（3）将Channel设置为非阻塞模式（最重要！）
        channel.configureBlocking(false);

        //（4）将Channel注册到Selector上，监听连接事件
        channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("----服务器启动成功----");

        //（5）循环调用Selector的select()方法，时刻检测就绪情况
        for (; ; ) {
            //获取可用channel的数量
            int readyChannels = selector.select();

            // 为什么要判断可用channel数量？---防止空轮询
            // 即使判断了，但是select方法仍在执行，还是会一直占用CPU资源
            if (readyChannels == 0) continue;

            //（6）调用selectedKeys()方法获取就绪channel集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                iterator.remove();

                //（7）判断就绪事件种类，调用业务处理方法
                // 如果是接入事件
                if (selectionKey.isAcceptable()) {
                    acceptHandler(channel, selector);
                }
                // 如果是可读事件
                if (selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
            }
        }
    }

    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {

        //创建SocketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 将channel设置为非阻塞模式
        socketChannel.configureBlocking(false);

        //将channel注册到selector上，监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);

        //响应客户端
        socketChannel.write(Charset.forName("utf-8").encode("你已进入多人聊天室！请注意隐私安全！"));
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {

        // 从SelectionKey中获取已就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        // 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 循环读取客户端请求信息
        String request = "";
        while (socketChannel.read(byteBuffer) > 0) {
            // 切换至读模式
            byteBuffer.flip();

            // 读取buffer中的内容
            request += Charset.forName("utf-8").decode(byteBuffer);
        }

        // 将channel再次注册到selector上，监听其他可读事件
        socketChannel.register(selector, selectionKey.OP_READ);

        // 将客户端发送的请求信息广播给其他客户端
        if (request.length() > 0) {
            broadCast(selector, socketChannel, request);
        }
    }

    /**
     * 广播给其他客户端
     */
    private void broadCast(Selector selector, SocketChannel socketChannel, String request) {

        // 获取所有已接入的客户端
        Set<SelectionKey> keys = selector.keys();
        //循环向所有channel广播信息
        keys.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();

            //剔除发信息的channel，将信息发送给其他channel客户端
            if (targetChannel instanceof SocketChannel && targetChannel != socketChannel) {
                try {
                    ((SocketChannel) targetChannel).write(Charset.forName("utf-8").encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
