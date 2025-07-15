package com.my.lambda;

interface MyFunction2 {
    void print();
}
public class LambdaTest2 {
    public static void main(String[] args) {
        // MyFunction2 fn = () -> {};
        MyFunction2 fn = () -> {
          System.out.println("Hello");
        };
        fn.print();
        fn = () -> {System.out.println("안녕하세요");};
        fn.print();
    }
}
