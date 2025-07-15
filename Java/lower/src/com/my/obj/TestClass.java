package com.my.obj;

class Human{
    String name;
}
public class TestClass {
    public static void main(String[] args) {

        Human h = new Human();          // new 연산자는 객체를 생성한 수 생성자를 호출하여 객채를 초기화하고 객체의 주소를 리턴시켜준다.
        System.out.println(System.identityHashCode(h));
        System.out.println(h.name);

    }
}
