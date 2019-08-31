package com.lee.july.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/11 10:30
 * @Description 输入一个整数n（n < 1000000），每一步可以使当前数x变为x+1或x-1，使得其成为一个斐波那契数，输出其最少的步数。
 */
public class TestDemo1 {

    public static int minCount(int n){

        int[] a = new int[40];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i-1] + a[i-2];
            if(n == a[i]){
                return 0;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length;i++) {
            list.add(n - a[i]);
            if(list.get(i) < 0){
                list.set(i,Math.abs(list.get(i)));
            }
        }
        list.sort(Integer::compareTo);
        return list.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(minCount(n));
    }
}
