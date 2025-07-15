package com.my.obj;
// 오버로딩(다중정의) 생성자의 타입 크기 순서가 다르면 다중정의 가능
class Persons {
    String name;
    int age;

    Persons() {
    }
    Persons(String name) {
        this.name = name;
    }
    Persons(String name, int age){
        this.name = name;
        this.age = age;
    }
}
public class ConstructorTest {
    public static void main(String[] args) {
        Persons p = new Persons();
        System.out.println(p.name + " " + p.age);

        Persons p1 = new Persons("홍길동");
        System.out.println(p1.name + " " + p1.age);


        Persons p2 = new Persons("홍길동",3);
        System.out.println(p2.name + " " + p2.age);

    }


}
