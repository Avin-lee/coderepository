package com.lee.july.day6;

/**
 * @Author Lee
 * @Create 2019/7/5 19:44
 * @Description 三目表达式从左向右依次判断（？前只能是布尔表达式）
 */
public class TestDemo1 {
    public static void main(String[] args) {
        boolean b = true?false:true == true?true:false;
        System.out.println(b);
    }
}
