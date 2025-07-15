package com.my.thread;

class MyClass{
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public void getCount() {
        System.out.println("count " + count);
    }

}
public class ThreadTest6 {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000000;i++){
                    obj.increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100000000; i++) {
                    obj.decrement();
                }
            }
        });

        obj.getCount();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        obj.getCount();
    }
}
