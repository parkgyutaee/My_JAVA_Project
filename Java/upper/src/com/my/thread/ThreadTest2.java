package com.my.thread;

/*


 */
public class ThreadTest2 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
          @Override
          public void run() {
              System.out.println("Thread Running");
          }
        };
    }
}
