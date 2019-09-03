package com.lee.july.day14;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/16 17:21
 * @Description 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *        例如：
 *             1^3=1
 *             2^3=3+5
 *             3^3=7+9+11
 *             4^3=13+15+17+19
 */
public class TestDemo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()){
            int N = sc.nextInt() ;
            String s = decompose(N) ;
            System.out.println(s);
        }
        sc.close();

    }

    private static String decompose(int n) {
        int [] array = new int[n] ;
        int mid = n / 2 ;
        if(n*n % 2 == 0)
            array[mid] = n*n + 1;
        else
            array[mid] = n*n ;
        for(int i = mid; i >= 1 ; i--){
            int temp = array[i] ;
            array[i - 1] = temp - 2 ;
        }
        for(int j = mid ; j < n - 1; j++){
            int temp = array[j] ;
            array[j + 1] = temp + 2 ;
        }
        StringBuffer sb = new StringBuffer() ;
        for(int k = 0 ; k < n ; k++){
            if(k != n - 1)
                sb.append(array[k] + "+") ;
        }
        sb.append(array[n - 1]) ;

        return sb.toString();
    }
}
