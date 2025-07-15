package com.my.thread;

public class ThreadTest4 {
    public static void main(String[] args) {

        // 첫 번째 도우미
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("🍜 라면 끓이는 중");
            }
        });

        // 두 번째 도우미
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("🧹 청소하는 중");
            }
        });

        // 세 번째 도우미
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("📞 전화받는 중");
            }
        });

        // 네 번째 도우미
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("🎵 음악 재생 중");
            }
        });

        // 다 같이 일 시작!
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
