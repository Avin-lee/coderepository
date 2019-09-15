package com.lee.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Avin lee
 * @Create 2019/9/15 16:12 by IntelliJ IDEA
 * @Description 试炼
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = scanner.nextInt();
        }
        Arrays.sort(b);
        int first = 0;
        int second = 0;
        for (int i = b.length - 1; i >= 0; i -= 2) {
            first += b[i];
        }
        for (int i = b.length - 2; i >= 0; i -= 2) {
            second += b[i];
        }
        System.out.println(first > second ? first : second);
    }
}
