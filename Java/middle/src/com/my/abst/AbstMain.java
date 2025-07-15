package com.my.abst;
/*
    추상메서드는 몸체부분이 없는 메서드로 abstract 키워드를 붙인다.
    재정의 될 것을 약속한 클래스다.
    이런 메서드를 하나라도 가진 클래스를 추상 클래스라고 한다
    추상 클래스는 객체를 가질수없는 특징을 가지고 있다.
 */
abstract class Abs{
    public abstract void method() ;
    public abstract void absMethod(); //추상메서드
}

class AAA extends Abs{

    @Override
    public void method() {
        System.out.println("나는 AAA 메소드 재정의 입니다.");
    }
    @Override
    public void absMethod() {
        System.out.println("추상메서드 재정의");
    }
}
public class AbstMain {
    public static void main(String[] args) {
        AAA a1 = new AAA();
        a1.method();
        a1.absMethod();

    }
}
