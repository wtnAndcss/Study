package testRecusion;

import java.io.File;

public class ShowFile {

    /**
     * 展示（遍历）文件夹
     * 注意：File--代表文件或文件夹
     * @param file
     */
    public void showFile(File file) {

        File[] files = file.listFiles();
        //判断File是否为文件
        if (files == null) {
            System.out.println(file + "是一个文件");
        } else {
            if (files.length == 0) {
                System.out.println(file + "是一个空文件夹");
            } else {
                //递归展示file文件夹中的东西
                for (File f : files) {
                    showFile(f);
                }
            }
        }
    }

    public static void main(String[] args) {
        ShowFile showFile = new ShowFile();
        File file = new File("D:\\KuGou");
        showFile.showFile(file);
    }
}
