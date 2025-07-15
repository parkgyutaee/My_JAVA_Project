package com.my.arony;

public class HomeMain {
    public static void main(String[] args) {
        Home home = new Home();
        home.use();
        home.use2();

        home.use3(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("Lamp on");
            }

            @Override
            public void turnOff() {
                System.out.println("Lamp off");
            }
        });
    }
}
