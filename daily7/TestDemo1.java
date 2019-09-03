package com.lee.july.day13;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/16 19:18
 * @Description 美国总统奥巴马画正方形(行是列的50%,四舍五入取整)。
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String c = sc.next();
        int row = N / 2;
        if (N % 2 != 0) {
            row = N / 2 + 1;
        }
        if (row == 2) {
            for (int i = 0; i < N; i++) {
                System.out.print(c);
            }
            System.out.println();
            for (int i = 0; i < N; i++) {
                System.out.print(c);
            }
        } else {
            for (int i = 0; i < N; i++) {
                System.out.print(c);
            }
            System.out.println();
            for (int i = 0; i < row - 2; i++) {
                System.out.print(c);
                for (int j = 0; j < N - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print(c);
                System.out.println();
            }

            for (int i = 0; i < N; i++) {
                System.out.print(c);
            }
        }
    }
}
