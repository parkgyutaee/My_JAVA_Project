package com.my.lambda;
/*  람다식 - 함수를 하나의 식으로 나타낸 것(익명함수 = 람다식 = 람다함수) */

interface MyFunction{
    int calc(int x, int y);
}
/*람다식은 함수형 인터페이스(추상메서드가 한개인 인터페이스)를 구현한 객체이다. */
public class LambdaTest {
    public static void main(String[] args) {
        MyFunction add = (x, y) -> {return x + y;};         //함수형 인터페이스를 구현한 객체
        MyFunction minus = (x, y) -> x - y;;
        System.out.println(minus.calc(10,40));
        System.out.println(add.calc(10,20));
    }
}
