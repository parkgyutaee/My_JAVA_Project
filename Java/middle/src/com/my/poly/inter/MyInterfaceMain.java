package com.my.poly.inter;

public class MyInterfaceMain {
    public static void main(String[] args) {
        MyInterface my = new MyClass();
        my.method();
        my.defaultMethod();
        MyInterface.staticMethod();
        System.out.println(MyInterface.MAX_COUNT);

    }

}
