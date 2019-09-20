package com.lee.july.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/16 14:54
 * @Description 输入10个非负整数用空格隔开分别代表数字0-9的个数，这10个数之和不超过50（意味着组成之后的数的位数不超过50位）。
 *              输出这些数字所组成的最小的数，0不能做首位。
 */
public class TestDemo1 {
    public static void main(String[] args) {
        System.out.println("Please enter ten numbers as number 0~9's times and each number split by space key: ");
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] a = new int[10];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        for(int i = 0;i < a.length;i++){
            for (int j = a[i]; j > 0; j--) {
                list.add(i);
            }
        }
        list.sort(Integer::compareTo);
        if(list.get(0) != 0){
            for (int i:list) {
                System.out.print(i);
            }
        }else{
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) != 0){
                    int temp = list.get(0);
                    list.set(0,list.get(i));
                    list.set(i,temp);
                    break;
                }
            }
            for (int i:list) {
                System.out.print(i);
            }
        }
    }
}
