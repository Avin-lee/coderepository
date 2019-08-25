package com.lee.july.day8;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @Author Lee
 * @Create 2019/7/9 10:39
 * @Description 输入的每组数据(整数)为一排（不超过1000），每组数据的数用空格隔开，最后一个数为k值
 * 输出该数组里面最小的k个数，升序排列。
 */
public class TestDemo2 {
    public static void main(String[] args) {
        System.out.println("Please enter your number split by space key:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(" ");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            int[] arr = new int[a.length - 1];
            for (int i = 0; i < a.length - 1; i++) {
                arr[i] = a[i];
            }
            int k = a[a.length - 1];
            if(k<=0){
                System.out.println();
            }else {
                Arrays.sort(arr);
                for (int i = 0; i < k - 1; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println(arr[k - 1]);
            }
        }
    }
}
