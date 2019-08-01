package testNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        new Client().start("B");
    }

    public void start(String nickName) throws IOException {
        // 连接服务器
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8888));

        // 接收服务器的响应
        // 新建一个线程，专门负责来接收服务器响应的数据
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        new Thread(new ClientHandler(selector)).start();

        // 向服务器请求数据
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String request = sc.nextLine();
            if (request != null && request.length() > 0) {
                channel.write(Charset.forName("utf-8").encode(nickName + ":" + request));
            }
        }
    }
}
