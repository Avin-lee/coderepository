package com.lee.july.day15;

/**
 * @Author Lee
 * @Create 2019/7/16 22:20
 * @Description
 */
class A{
    public A(String s){

    }
}

public class TestDemo {
    public static void main(String[] args) {

//        //命令为：java TestDemo1 a b c
//        String foo1 = args[1];
//        String foo2 = args[2];
//        String foo3 = args[3];

//        System.out.println(Arrays.toString(args));   // 运行结果为:[]


        A classa = new A("he");
        A classb = new A("he");
        System.out.println(classa == classb);
    }
}
