package com.my.abst;

class Animal {
    public void makeSound(){
        System.out.println("부모 동물이 소리를 낸다");
    }
//    public abstract void makeSound();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}

