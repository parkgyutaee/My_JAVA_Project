package com.my.lambda;

interface MyFunction4<T>{
    void print(T x);
}
public class LambdaTest4 {
    public static void main(String[] args) {
        MyFunction4<String> f1 = x -> System.out.println(x);
        f1.print("ABC");
        MyFunction4<Integer> f2 = x -> System.out.println(x);
        f2.print(Integer.valueOf("11111"));

    }
}
