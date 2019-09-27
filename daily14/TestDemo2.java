package com.lee.july.day18;

/**
 * @Author Lee
 * @Create 2019/7/20 14:23
 * @Description 一位百万富翁遇到一个陌生人，陌生人找他谈一个换钱的计划，陌生人对百万富翁说：“我每天给你10万元，而你第一天只需给我1分钱，第二天我给你10万元，你给我2分钱，第三天我仍给你10万元，你给我4分钱，……。你每天给我的钱是前一天的2倍，直到满一个月（30天）为止”，百万富翁很高兴，欣然接受了这个契约。请编程计算在这一个月中，百万富翁总计给陌生人多少钱（分）,陌生人总计给百万富翁多少钱（万元）。
 */
public class TestDemo2 {
    public static void main(String[] args) {

        int[] a = new int[30];
        a[0] = 1;
        a[1] = 2;
        int theRich = 3;
        for(int i = 2;i < 30;i++){
            a[i] = 2*a[i - 1];
            theRich += a[i];
        }
        theRich /= 1000000;
        System.out.println(theRich);

        int thePoor = 30*10*1000000;
        System.out.println(thePoor);
    }
}
