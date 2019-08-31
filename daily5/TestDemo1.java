package com.lee.july.day11;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/11 22:05
 * @Description 输入整数：1000121
 *              输出：0:3（每个数出现的次数）
 *                   1:3
 *                   2:1
 */
public class TestDemo1 {
    public static void counts(String s){
        int[] b = new int[10];
        for (int i = 0; i < s.length(); i++) {
            b[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < b.length; i++) {
            if(b[i] != 0){
                System.out.println(i+":"+b[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        counts(s);
    }
}
