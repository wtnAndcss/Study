package testNIO;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Server {

    //启动服务器方法
    public void start() throws IOException {
        //（1）创建Selector---抛IOException
        Selector selector = Selector.open();

        //（2）创建ServerSocketChannel，并绑定监听端口---抛IOException
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(8888));

        //（3）将Channel设置为非阻塞模式（最重要）
        channel.configureBlocking(false);

        //（4）将Channel注册到Selector上，监听连接事件
        channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("----服务器启动成功----");

        //（5）循环调用Selector的select()方法，检测就绪情况
        for (; ; ) {
            int readyChannel = selector.select();

            while (true) {

            }
        }
        //（6）调用selectedKeys()方法获取就绪channel集合

        //（7）判断就绪事件种类，调用业务处理方法

        //（8）根据业务需要决定是否再次注册监听事件，重复执行第（3）步操作
    }

    public static void main(String[] args){
        Server server = new Server();
    }



}
