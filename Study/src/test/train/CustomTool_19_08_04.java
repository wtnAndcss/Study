package test.train;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 自定义工具类
 *
 */
public class CustomTool_19_08_04 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(32);
        list.add(56);
        list.add(99);
        CustomTool_19_08_04.reverse(list);
    }

    /**
     * 1.对list集合中的元素进行反转（类似第一个和最后一个互换）
     */
    public static void reverse(List<Integer> list) {

        try {
            if (list == null || list.size() == 0) {
                throw new Exception("list为空！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("反转前：");
        for (Integer i : list) {
            System.out.println(i);
        }

        Integer a, b;
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            a = list.get(i);
            b = list.get(j);
            list.set(i, b);
            list.set(j, a);
        }

        System.out.println("反转后：");
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
