package testRecusion;

import java.io.*;

//字节流
public class testIO_copy {

    public static void main(String[] args) {
        testIO_copy t = new testIO_copy();
        t.copyDirectory("C:\\testIO\\aaa\\aaa.txt","C:\\testIO\\bbb\\");
    }

    //文件夹复制
    public void copyDirectory(File file, String path) {
        //判断是文件夹还是文件：isFile()  isDirectory() listFileS()
        File[] files = file.listFiles();
        if (file == null) {
            System.out.println(file + "是一个文件");
        } else {
            if (files.length == 0) {
                System.out.println(file + "是一个空文件夹");
            } else {
                //复制路径：C://test//aaa--->D://test//aaa//bbb
                String oldPath = file.getAbsolutePath();
                String p = oldPath.split(":")[1];
                File newfile = new File(p);
                newfile.mkdir();
            }
        }

    }

    //文件加密和解密
    public void jiamiDirectory(String oldFile, String newFileName) {
        File file = new File(oldFile);
        //判断是否为文件
        File[] files = file.listFiles();
        if (files != null) {//不是文件
            System.out.println(oldFile + " 不是一个文件！现只能复制文件");
        } else {
            FileInputStream input = null;
            FileOutputStream output = null;
            try {
                input = new FileInputStream(oldFile);
                File newFile = new File(newFileName + file.getName());
                output = new FileOutputStream(newFile);

                byte[] content = new byte[1024];
                int i = input.read(content);
                byte flag;
                while (i != -1) {
                    //加密(第一个字节和第二个字节互换位置)
                    flag = content[0];
                    content[0] = content[1];
                    content[1] = flag;
                    output.write(content,0, i);
                    output.flush();
                    i = input.read(content);
                }
                System.out.println("使用字节流文件复制成功！");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (input != null) {
                        output.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //文件复制方法
    public void copyDirectory(String oldFile, String newFileName) {
        File file = new File(oldFile);
        //判断是否为文件
        File[] files = file.listFiles();
        if (files != null) {//不是文件
            System.out.println(oldFile + " 不是一个文件！现只能复制文件");
        } else {
            FileInputStream input = null;
            FileOutputStream output = null;
            try {
                input = new FileInputStream(oldFile);
                File newFile = new File(newFileName + file.getName());
                output = new FileOutputStream(newFile);

                byte[] content = new byte[1024];
                int i = input.read(content);
                while (i != -1) {
                    output.write(content,0, i);
                    output.flush();
                    i = input.read(content);
                }
                System.out.println("使用字节流文件复制成功！");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (input != null) {
                        output.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }








}
