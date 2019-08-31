package com.lee.july.day10;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/11 11:14
 * @Description 输入一个int X * int Y的网格，机器人只能走格点并且只能向下或者向右走，输出机器人从左上角走到右下角的所有走法。
 */
public class TestDemo2 {

    public static int countWays(int x, int y) {
        int total = x + y -2; //一共要走的步数
        int down = x - 1;  //向下要走的步数
        double res = 1;
        for(int i = 1 ; i <= down; i++){
            res =res * (total - down + i) / i;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(countWays(x,y));
    }
}
