package com.my.poly.inter;
/*
    인터페이스
    추상매서드, 상수 필드, 디폴트메서드, 정적메서드, 메서드를 선언할 수 있다.
    이 멤버는 모드 public 접근 제한으로 구현하는데 생략가능하다.
    private 접근자로 선언 가능하다.
 */
public interface MyInterface {
    //상수 필드를 만들기 위해선 반드시 (public static final이건 생략 가능 디폴트 값임)
    int MAX_COUNT = 100;

    // 추상 메서드 (public abstract)
    void method() ;

    // 디폴트 메서드
    default void defaultMethod() {
        System.out.println("defaultMethod");
        privateMethod();
    }

    // 정적 메서드
    static void staticMethod() {            // 정적메서드는 객체를 생성안해도 된다.
        System.out.println("staticMethod 호출");
    }
    private void privateMethod() {
        System.out.println("privateMethod 호출");
    }

}

class MyClass implements MyInterface {
    @Override
    public void method() {
        System.out.println("Myclass 재정의");
    }

}
