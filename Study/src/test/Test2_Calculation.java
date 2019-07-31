package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算
 */
public class Test2_Calculation {

    /**
     * 一、
     * ①从键盘录入一个日期字符串,格式为 xxxx-xx-xx,代表该人的出生日期；
     * ②利用人出生日期到当前日期所经过的毫秒值计算出这个人活了多少天。
     */

    public static void main(String[] args) throws ParseException {
        Test2_Calculation test2 = new Test2_Calculation();
        test2.calculation1();
    }

    public void calculation1() throws ParseException {
        System.out.println("请输入出生日期（yyyy-MM-dd）：");
        Scanner s = new Scanner(System.in);
        String date = s.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = format.parse(date);
        long timeDate = d.getTime();
        long timeMillis = System.currentTimeMillis();
        long days = ((timeMillis-timeDate)/1000/60/60/24);
        System.out.println("您从出生到现在一共活了 "+days+" 天~");
    }





}
