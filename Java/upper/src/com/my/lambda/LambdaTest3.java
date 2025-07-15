package com.my.lambda;

interface MyFunction3 {
    int calc(int x,int y);
}

public class LambdaTest3 {
    public static void main(String[] args) {

        printCalc(10, 20, (x,y) -> x*y);            // 람다식을 인수로 저장한다.
    }

    static void printCalc(int x, int y, MyFunction3 function3) {
        System.out.println(function3.calc(x, y));
    }
}
