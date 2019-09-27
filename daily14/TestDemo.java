package com.lee.july.day18;

/**
 * @Author Lee
 * @Create 2019/7/20 11:20
 * @Description
 */
public class TestDemo {

    private static int x = 100;

    public static void main(String[] args) {

        /*Integer i1 = 50;
        int i2 = 50;
        Integer i3 = Integer.valueOf(50);
        Integer i4 = new Integer(50);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i3 == i4);
        System.out.println(i2 == i4);*/


        TestDemo hs1 = new TestDemo();
        hs1.x++;
        TestDemo hs2 = new TestDemo();
        hs2.x++;
        hs1 = new TestDemo();
        hs1.x++;
        TestDemo.x--;
        System.out.println("x=" + x);

    }


}
