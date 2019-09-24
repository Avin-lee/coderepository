package com.lee.july.day16;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/17 22:33
 * @Description 读入N名学生的成绩，将获得某一给定分数的学生人数输出。
 */
public class TestDemo2 {
    public static void main(String[] args) {
        System.out.println("Please enter n,grade and the target grade:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i]= sc.nextInt();
        }
        int count = 0;
        int grade = sc.nextInt();
        for(int i = 0; i < n; i++){
            if(a[i] == grade){
                count++;
            }
        }
        System.out.println(count);
    }
}
