package com.lee.july.day8;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/9 9:43
 * @Description 输入一个数n（如果n>1000就计算a[999]）构成一个数组a[n]，该数组存放0~n-1，每个两个数删掉一个数，然后循环删除
 *              输出最后一个被删除的数的下标。
 */
public class TestDemo1 {
    public static int originalIndex(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int p = 0; //游标指针
        int count = 0;  //两个数之间的间隔
        int deleteCount = 0; //要删除的数的个数
        while(true){
            if(deleteCount == n){
                return p - 1;
            }
            if(p == n){
                p = 0;
            }
            if(arr[p] != -1){
                count++;
            }
            if (count == 3) {
                count=0;
                deleteCount++;
                arr[p] = -1;
            }
            p++;
        }
    }
    public static void main(String[] args) {
        System.out.println("Please enter a number for array's length:");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n > 1000) {
                System.out.println(originalIndex(999));
            } else {
                System.out.println(originalIndex(n));
            }
        }
    }
}
