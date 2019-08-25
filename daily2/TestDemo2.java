package com.lee.july.day7;

import java.util.Scanner;

/**
 * @Author Lee
 * @Create 2019/7/7 21:29
 * @Description 输入w，h构成w*h的网格，每个网格之多放一个蛋糕，网格中每两个蛋糕的阿基米德距离（横纵坐标之差的平方和再开平方）不等于2，输出网格中能放的蛋糕数。
 */
public class TestDemo2 {
    public static void main(String[] args) {
        System.out.println("Please enter the width and the height split by \",\":");
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(",");
        int w = Integer.parseInt(s[0]);
        int h = Integer.parseInt(s[1]);
        int sum = (w / 4) * (h / 4) * 4 * 2;
        sum += (w % 4) * 2 * (h / 4);
        sum += (h % 4) * 2 * (w / 4);
        int tmp = (w % 4) * (h % 4);
        if (tmp <= 4) {
            if(tmp == 3){
                sum += 2;
            }else {
                sum += tmp;
            }
        } else if (tmp == 6) {
            sum += 4;
        } else if (tmp == 9) {
            sum += 5;
        }
        System.out.println(sum);
    }
}
