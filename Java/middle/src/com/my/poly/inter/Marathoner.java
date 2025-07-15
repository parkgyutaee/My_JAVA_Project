package com.my.poly.inter;

interface Walkable{
    void walk();
}
interface Runable {
    void run();
}
interface Athlete extends Walkable, Runable{
    void compete();
}

public class Marathoner implements Athlete {
    @Override
    public void walk() {
        System.out.println("마라토너가 걷는다");
    }
    @Override
    public void run() {
        System.out.println("마라토너가 달린다");
    }
    @Override
    public void compete() {
        System.out.println("마라토너가 완료했다");
    }
}
