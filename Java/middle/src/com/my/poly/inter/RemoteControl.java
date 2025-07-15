package com.my.poly.inter;
/*
    인터페이스
    또 다른 형태의 클래스이며 참조 변수형으로 사용된다.
    인터페이스의 추상 메서드를 재정의한 객체를 만든다.
 */
public interface RemoteControl {
    public void turnOn();                  //추상클래스
}
/*
    Implements 키워드는 인터페이스로 구현되었다를 뜻 한다.
    따라서 이 클래스는 인터페이스를 통해 사용할 수 있다.
 */

class Television implements RemoteControl{ //구현 클래스
    @Override
    public void turnOn() {
        System.out.println("TV ON");
    }
}

class Radio implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("Radio ON");
    }

}