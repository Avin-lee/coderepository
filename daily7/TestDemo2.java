package com.lee.july.day13;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/16 21:08
 * @Description 两个超长字符串类型的数字相加，返回一个字符串类型的和。(利用math.BigInteger轻松完成)
 */
public class TestDemo2 {
    public static String addLongInteger(String addend,String augend){
        BigInteger b1 = new BigInteger(addend);
        BigInteger b2 = new BigInteger(augend);
        BigInteger result = b1.add(b2);
        return result+"";
    }

    public static void main(String[] args) {
        System.out.println("Please enter two big Integer numbers for plus:");
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(addLongInteger(s1,s2));
    }
}
