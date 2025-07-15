package com.my.inher;

public class AnimalMain {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound();
        System.out.println("---------- 1 ----------");

        Animal a2 = new Dog();
        a2.sound();
        a2.supermethod();
        System.out.println("--------- 2 -----------");

        Dog a3 = new Dog();
        a3.sound();
        a3.subrmethod();
        System.out.println("--------- 3 -----------");

        Animal a4 = new Dog();
        a4.sound();
        System.out.println("--------- 4 -----------");

        Dog a5 = new Dog();
        a5.test1();

    }
}
