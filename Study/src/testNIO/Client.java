package testNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Client {

    public void start() throws IOException {
        // 连接服务器
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8888));

        // 向服务器请求数据
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String request = sc.nextLine();
            if (request != null && request.length() > 0) {
                channel.write(Charset.forName("utf-8").encode(request));
            }
        }

        // 接收服务器的响应
    }

    public static void main(String[] args) throws IOException {
        new Client().start();
    }
}
