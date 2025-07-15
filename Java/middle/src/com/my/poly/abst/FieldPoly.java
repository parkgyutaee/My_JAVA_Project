package com.my.poly.abst;

class Animal{
    void speak() {
        System.out.println("동물이 소리를 냄");
    }
}

class Cheetah extends Animal{
    @Override
    void speak() {
        System.out.println("치타가 운다~");
    }
}

class Tarzan extends Animal {
    @Override
    void speak() {
        System.out.println("타잔이 소리친다.아아아~~");
    }
}

class Jungle {
    Animal animal;

    void makeSound() {
        animal.speak();
    }
}
public class FieldPoly {
    public static void main(String[] args) {
        Jungle jungle = new Jungle();
        jungle.animal = new Cheetah();
        jungle.makeSound();

        jungle.animal = new Tarzan();
        jungle.makeSound();
    }
}
