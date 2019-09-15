package com.lee.keep;

import java.util.Scanner;

/**
 * @Author Avin lee
 * @Create 2019/9/7 16:25 by IntelliJ IDEA
 * @Description
 */
public class TestDemo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n != 0) {
            String s = scanner.next();
            char[] arr = new char[s.length()];
            arr = s.toCharArray();
            int a = 0;
            int b = 0;
            int c = 0;
            if (s.length() < 8) {
                System.out.println("NO");
                n--;
                return;
            }
            if ('0' < arr[0] && arr[0] <= '9') {
                System.out.println("NO");
                n--;
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if ('0' < arr[i] && arr[i] <= '9') {
                    a++;
                }
                if ('a' < arr[i] && arr[i] <= 'z') {
                    b++;
                }
                if ('A' < arr[i] && arr[i] <= 'Z') {
                    c++;
                }
            }
            if (a > 0 && b > 0 || a > 0 && c > 0 || b > 0 && c > 0) {
                System.out.println("YES");
                n--;
            } else {
                System.out.println("NO");
                n--;
            }
        }
    }
}
