package com.lee.july.day15;

/**
 * @Author Lee
 * @Create 2019/7/16 23:03
 * @Description 不用+求两数之和。
 */
public class TestDemo1 {
    public int addAB(int A, int B) {
        while (B!=0) {
            int temp = A ^ B;
            B = (A & B) << 1;
            A = temp;
        }
        return A;
    }
}
