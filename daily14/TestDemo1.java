package com.lee.july.day18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/20 11:59
 * @Description 输入一个String型的基因序列和一个int型的字串长度
 *              输出找出GC比例最高的字串，如果有多个输出第一个的字串
 */
public class TestDemo1 {
    public static void main(String[] args) {
        System.out.println("Please enter a String and a number for the subStirng's length:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        int[] a = new int[s.length() - n + 1];
        for(int i = 0;i < (s.length() - n + 1);i++){
            String s1 = s.substring(i,i + n);
            for(int j = 0;j < n;j++){
                if(s1.charAt(j) == 'G'||s1.charAt(j) == 'C'){
                    a[i]++;
                }
            }
        }
        int[] b = Arrays.copyOf(a,s.length() - n + 1);
        Arrays.sort(a);
        String s2 = null;
        int count = a[a.length-1];
        for (int i = 0; i < a.length; i++) {
            if(b[i] == count){
                s2 = s.substring(i,i + n);
                break;
            }
        }
        System.out.println(s2);
    }
}
