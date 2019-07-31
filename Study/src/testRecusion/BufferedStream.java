package testRecusion;

import java.io.*;


public class BufferedStream {

    public static void main(String[] args) {

        try {
            //字节缓冲流
            File file = new File("");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read();

            //字符缓冲流
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();

            //对象流(高级流)
            //将对象直接记录在文件中永久保存，这个叫做对象的持久化/序列化
            Person p1 = new Person("css", 23);
            FileOutputStream fos = new FileOutputStream("要存入的文件路径");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p1);
            oos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
