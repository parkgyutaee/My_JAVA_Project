package com.my.obj;
/*
    생성자 오버로딩
    this()는 반드시 생성자 첫줄에 위치하고 현재 클래스의 다른 생성자를 호출한다.
    중복코드를 제거하고 생성자간의 재사용을 가능하게 한다.

 */
class Personss {
    String name;
    int age;

    Personss() {
        this("unknown",0);                  //다른 생성자를 호출
        System.out.println("기본 생성자 호출 문장입니다");
    }
    Personss(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("매개변수2개의 생성자 호출 문장입니다");
    }

}
public class ConstructorTest2 {
    public static void main(String[] args) {
        Personss p = new Personss();

//        Personss p2 = new Personss("박규태",26);

    }
}
