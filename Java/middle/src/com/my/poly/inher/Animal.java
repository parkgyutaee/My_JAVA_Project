package com.my.poly.inher;

public class Animal {

    public void sound() {
        System.out.println("동물이 소리를 낸다");
    }
    public void supermethod() {
        System.out.println("supermethod");
    }
    public void test1(){
        System.out.println("연습용");
    }
}

class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("멍멍");



    }
    public void subrmethod() {
        System.out.println("DogMethod");
    }
}