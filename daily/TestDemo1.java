package com.lee.july.day6;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/5 19:50
 * @Description 输出出现次数大于等于n/2的数（n为这串数的个数）
 */
public class TestDemo2 {
    public static int theMostTimesNumber(String[] arr){
        int num = Integer.parseInt(arr[0]);
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            int temp = Integer.parseInt(arr[i]);
            if(temp == num) {
                count++;
            }else if(count > 0) {
                count--;
            }else {
                num = temp;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("Please enter the number split by your space key:");
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        System.out.println(theMostTimesNumber(s));
    }
}
