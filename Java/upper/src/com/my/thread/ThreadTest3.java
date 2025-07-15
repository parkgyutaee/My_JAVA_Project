package com.my.thread;

// Runnable 인터페이스
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Running");
    }
}
public class ThreadTest3 {
    public static void main(String[] args) {
        Runnable Task = new Task();
        Task.run();

        Task task1 = new Task();
        Thread thread = new Thread(task1);
        thread.start();
    }
}
