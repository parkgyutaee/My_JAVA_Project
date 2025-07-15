package com.my.nested;

class A{
    class B{
        B() {
            System.out.println("B() 호출");
        }
        public void methodB() {
            System.out.println("Hello from B");
        }
    }
    int field;                              // 필드에서 내부 객체 사용
    B fieldB = new B();

    A () {
        System.out.println("A() 호출");
        B b = new B();
        b.methodB();
    }

    void methodA() {
        System.out.println("methodA() 호출");
    }
}
public class NestedMain {
    public static void main(String[] args) {
//        A a = new A();          // 외부 클래스 A의 인스턴스 생성 : 필드초기화로 B() 호출된다.
//
//        a.methodA();

        // 내부 클래스의 객체 생성 방법
        A.B b = new A().new B();

        b.methodB();
    }
}
