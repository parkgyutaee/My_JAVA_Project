package com.my.thread;
/*
    멀티프로세서는 프로그램 단위의 멀티태스킹이고, 멀티스레드는 프로그램 내부의 멀티태스킹이다.
 */

class MyThread extends Thread {
    public void run () {
        System.out.println("thread running");
    }

}
public class ThreadTest1 {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();                         // 이 코드가 있어야지만 run 메소드 실행이다
    }
}
