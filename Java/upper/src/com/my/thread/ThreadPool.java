package com.my.thread;
/*
    스레드풀
    매번 스레드를 생성하면 비용가 자원 낭비가 크다. 또한 성능이 저하되기때문에
    미리 고정된 수의 스레드를 생성해서 사용 , 풀에보관하며 작업이 생기면 재 사용한다.
    자바는 ExecutorService 인터페이스로 스레드풀을 제공한다.
    nerFixedThreadPool(n) : 고정크기의 스레드 풀
    newCatchedThreadPool() : 필요시에 생성, 사용안하면 제거
    newSingleThreadExecutor() : 단일 스레드 순차 실행
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++ ){
            int taskid = i;
            executor.submit(() -> {
                System.out.printf("작업: %d 시작: %s \n",taskid,Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.printf("작업: %d 완료",taskid);
                }
            });
        }
        executor.shutdown();                    //작업 종료
    }
}
