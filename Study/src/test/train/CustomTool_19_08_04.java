package test.train;

import java.util.*;

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
        System.out.println("==========================");
        CustomTool_19_08_04.max(list);
        System.out.println("==========================");
        CustomTool_19_08_04.min(list);
        System.out.println("==========================");
        CustomTool_19_08_04.indexOf(list, 23);
        System.out.println("==========================");
        CustomTool_19_08_04.replaceAll(list, 23, 20);
    }

    /**
     * 2019-08-04
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

        System.out.println("反转前：" + listToString(list));
        Integer a, b;
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            a = list.get(i);
            b = list.get(j);
            list.set(i, b);
            list.set(j, a);
        }
        System.out.println("反转后：" + listToString(list));
    }

    /**
     * 2019-08-05
     * 2.求出list集合对象中的最大值并返回
     * @param list
     * @return
     */
    public static void max(List<Integer> list) {

        // 方法一
        Integer max1 = Collections.max(list);
        // 方法二
        int max2 = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max2 < list.get(i)) {
                max2 = list.get(i);
            }
        }

        System.out.println("list中最大值为：" + max2);
    }

    /**
     * 2019-08-05
     * 3.求出list集合对象中的最小值并返回
     * @param list
     */
    public static void min(List<Integer> list) {

        // 方法一
        Integer min1 = Collections.min(list);
        // 方法二
        Integer min2 = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (min2 > list.get(i)) {
                min2 = list.get(i);
            }
        }

        System.out.println("list中最小值为：" + min2);
    }

    /**
     * 2019-08-05
     * 4.求出元素i在list集合中第一次出现的索引，如果没有返回-1
     * @param list
     * @param i
     */
    public static void indexOf(List<Integer> list, Integer i) {

        // 方法一
        List<Integer> list1 = new ArrayList<>();
        list1.add(i);
        Integer indexOfSubList = Collections.indexOfSubList(list, list1);
        // 方法二
        Integer index = null;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == i) {
                index = j;
                break;
            }
        }

        System.out.println(i + "在list中的下标为：" + index);
    }

    /**
     * 2019-08-05
     * 5.将list集合中的所有值为oldValue的元素替换为newValue
     * @param list
     * @param oldValue
     * @param newValue
     */
    public static void replaceAll(List<Integer> list, Integer oldValue, Integer newValue) {

        System.out.println("替换前list：" + listToString(list));
        // 方法一
        boolean b = Collections.replaceAll(list, oldValue, newValue);
        // 方法二
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == oldValue) {
                list.set(i, newValue);
            }
        }
        System.out.println("替换后list：" + listToString(list));
    }

    /**
     * 打印list<Integer>方法
     * @param list
     */
    public static String listToString(List<Integer> list) {

        if (list != null && list.size() != 0) {
            Integer[] array = new Integer[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            return Arrays.toString(array);
        }
        System.out.println("list为空！");
        return null;
    }
}
