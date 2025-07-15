package com.my.poly.abst;
/*
    매개변수 다형성
 */
class Animal2 {
    public void makeSound() {
        System.out.println("동물이 소리를 낸다");
    }
}
class Tarzen2 extends Animal2 {
    @Override
    public void makeSound() {
        System.out.println("타잔이 소리를 낸다");
    }
}
class Cheetah2 extends Animal2 {
    @Override
    public void makeSound() {
        System.out.println("치타가 소리를 낸다");
    }
}
class Jungle2 {
    void makeSound(Animal2 animal2) {
        animal2.makeSound();
    }

}
public class ParameterPoly {
    public static void main(String[] args) {
        Jungle2 jug2 = new Jungle2();

        Animal2 tarzan = new Tarzen2();
        Animal2 cheetah = new Cheetah2();

        jug2.makeSound(tarzan);
    }
}
