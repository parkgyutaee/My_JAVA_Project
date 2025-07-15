package com.my.poly.inter;

interface Flyable{
    void fly();
}
interface Swimmable{
    void swim();

}
interface Movable{
    void move();
}

class Duck implements Flyable, Swimmable, Movable{
    @Override
    public void fly() {
        System.out.println("오리가 날다.");
    }
    @Override
    public void swim() {
        System.out.println("오리가 헤엄치다.");
    }
    @Override
    public void move() {
        System.out.println("오리가 움직이다.");
    }
}
public class MultiInterface {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
        duck.move();

        Flyable fly = new Duck();
        fly.fly();
    }
}
