package com.my.obj;
/*
    싱글토
    애플리케이션 전체에 오직 하나의 인스턴스만 존재하는 디자인 패턴이다.
    주로 전역상태 관리나 공유자원에 대한 접근을 제어할 때 사용한다.
 */
public class SingTon {
    // private static 로 셀프 인스턴스를 생성하여 인스턴스를 리턴시킨다.
    private static final SingTon instance = new SingTon();
    // 외부에서 객체 생성을 차단하게 private으로 선언한다.
    private SingTon(){
    }

    public static SingTon getinstance(){
        return instance;
    }
    public void showMessage() {
        System.out.println("Hello from SingTon");
    }

}
