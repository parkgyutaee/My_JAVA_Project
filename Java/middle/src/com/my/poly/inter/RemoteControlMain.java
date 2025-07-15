package com.my.poly.inter;

public class RemoteControlMain {
    public static void main(String[] args) {
        RemoteControl rc;// 리모트컨트롤을 선언하다.

        rc = new Television();
        rc.turnOn();

        rc = new Radio();
        rc.turnOn();

        System.out.println(rc instanceof RemoteControl);
    }
}
