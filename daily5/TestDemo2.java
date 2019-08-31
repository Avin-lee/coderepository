package com.lee.july.day11;

import java.util.Arrays;

/**
 * @Author Lee
 * @Create 2019/7/11 23:27
 * @Description 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class TestDemo2 {
    public static int[] multiply(int[] A) {
        int[] left = new int[A.length];
        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = A[i-1]*left[i-1];
        }

        int[] right = new int[A.length];
        right[right.length-1] = 1;
        for (int i = right.length-2; i >=0; i--) {
            right[i] = A[i+1]*right[i+1];
        }

        int[] arr = new int[A.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = left[i]*right[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiply(new int[]{1,2,3,4,5,6,7,8,9,0})));
    }
}
