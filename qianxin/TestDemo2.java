package com.lee.qianxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Avin lee
 * @Create 2019/9/16 19:55 by IntelliJ IDEA
 * @Description
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int min = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] < min) {
                min = a[i] - a[i - 1];
            }
        }
        System.out.println(min);
    }
}
