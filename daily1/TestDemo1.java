package com.lee.july.day1_5;

import java.util.*;

/**
 * Author       Lee
 * Create Date  2019/7/1 13:06
 */


/*
   给定两个字符串a，b，将b串插入a串中，统计有多少种插法使得插入后的串为回文字符串。
 */
public class TestDemo1{
    public static void isPalindromeTimes(){
        System.out.println("A:");
        Scanner scanner = new Scanner(System.in);
        char[] A = scanner.nextLine().toCharArray();

        System.out.println("B:");
        String B = scanner.nextLine();

        List<Character> list = new ArrayList<>();

        int count = 0;
        for(int i = 0;i <= A.length;i++){
            list.clear();
            for(char ch : A) {
                list.add(ch);
            }
            for(int j = 0;j < B.length();j++){
                list.add(i+j,B.charAt(j));
            }

            int p = 0;
            int q = list.size()-1;
            while(p<=q){
                if(list.get(p).equals(list.get(q))){
                    p++;
                    q--;
                }else{
                    break;
                }
            }
            if(p>=q){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        TestDemo1.isPalindromeTimes();
    }
}


