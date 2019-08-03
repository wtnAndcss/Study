package test.train;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 键盘读取一行输入,去掉其中重复字符, 打印出不同的那些字符。
 */
public class TrainString {

    public static void main(String[] args) {

        System.out.println("请输入字符串：");
        Scanner sc = new Scanner(System.in);
        String info = sc.nextLine();
        sc.close();
        char[] charInfo = info.toCharArray();
        Set<Character> s = new HashSet<>();
        for (char c : charInfo) {
            s.add(c);
        }
        System.out.println(s);
    }

    /**
     *  总结：
     *      利用Set中原生equals方法，对于基本数据类型，未重写的equals方法与==功能相同，
     *      比较的是基本类型数据的值。
     *  注意：
     *      在Set集合中Set<char>会报错，只能使用引用类型Character
     */
}
