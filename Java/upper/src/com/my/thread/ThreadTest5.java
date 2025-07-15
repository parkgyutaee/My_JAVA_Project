package com.my.thread;


public class ThreadTest5 extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + "Thread start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName() + "thread stop");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new ThreadTest5();
            thread.start();
            /*
                join() 메서드는 실행 메서드가 끝날 때 까지 메인 메서드를 기다린다.
             */
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("MainThread Finish");
    }
}
