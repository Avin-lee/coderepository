package com.lee.july.day7;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/7 21:24
 * @Description 两个数的最小公倍数
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int x = a;
        int y = b;
        int z = 0;
        if(a < b){
            int c = a;
            a = b;
            b = c;
        }
        while(b != 0){
            z = a % b;
            a = b;
            b = z;
        }
        System.out.println(x*y/a);
    }
}
