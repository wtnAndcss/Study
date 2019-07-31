package test;

import java.util.*;

/**
 * 数组排序
 */
public class Test1_arraySort {

    public static void main(String[] args) {
        Test1_arraySort test1 = new Test1_arraySort();
        test1.sort1();
        test1.sort2();
        test1.sort3();
        test1.sort4();
        test1.sort5();
    }

    /**
     * 1.定义一个数组，数组中元素为：{24,69,80,57,13}，
     * 将数组中的元素按照从小到大的顺序进行排序。
     */

    //1.从两端到中间进行比较
    public void sort1() {

        int[] array = {24,69,80,57,13};
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    flag = array[i];
                    array[i] = array[j];
                    array[j] = flag;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //2.利用Arrays提供的sort()方法，底层使用的是双向快速排序
    public void sort2() {

        int[] array = {24,69,80,57,13};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    //3.冒泡排序
    public void sort3() {

        int[] array = {24,69,80,57,13};
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    flag = array[i];
                    array[i] = array[j];
                    array[j] = flag;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //4.选择排序：找出比当前数更小的，然后交换，即minIndex永远记录最小值下标
    public void sort4() {

        int[] array = {24,69,80,57,13};
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int flag = array[i];
            array[i] = array[minIndex];
            array[minIndex] = flag;
        }
        System.out.println(Arrays.toString(array));
    }

    //5.插入排序
    public void sort5() {

        int[] array = {24,69,80,57,13};
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int flag = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = flag;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
