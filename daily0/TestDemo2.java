package com.lee.july.day6;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/6 0:05
 * @Description 输入：连续的四个数[-30 ~30]并用“，”隔开，分别代表A-B，B-C，A+B，B+C。
 *              输出：如果满足ABC请输出用”，“隔开，如果不满足请输出No；
 */
public class TestDemo3 {
    public static void isTrue(String[] s){
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int d = Integer.parseInt(s[3]);

        int A = (a+c)/2;
        int B1 = (b+d)/2;
        int B2 = (c-a)/2;
        int C = (d-b)/2;

        if(B1 != B2){
            System.out.println("No");
        }else{
            System.out.print(A + "," + B1 + "," + C);
        }

    }

    public static void main(String[] args) {
        System.out.println("Please enter the number split by your space key:");
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        isTrue(s);

    }
}
