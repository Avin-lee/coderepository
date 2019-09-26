package com.lee.july.day17;

/**
 * @Author Lee
 * @Create 2019/7/19 0:10
 * @Description
 */
public class TestDemo {
    private int count;
    public static void main(String[] args) {
        TestDemo test = new TestDemo(88);
        System.out.println(test.count);
    }
    TestDemo(int a){
        count = a;
    }


/*
public String name = "adc";
    public static void main(String[] args) {
        TestDemo1 test = new TestDemo1();
        TestDemo1 testB = new TestDemo1();
        System.out.println(test.equals(testB)+","+test.name.equals(testB.name));
    }
*/

}


/*
class X{
    Y y = new Y();
    public X(){
        System.out.print("X");
    }
}

class Y {
    public Y() {
        System.out.print("Y");
    }
}

public class TestDemo1 extends X{
    Y y = new Y();
    public TestDemo1(){
        System.out.print("Z");
    }

    public static void main(String[] args) {
        new TestDemo1();
    }
}*/
