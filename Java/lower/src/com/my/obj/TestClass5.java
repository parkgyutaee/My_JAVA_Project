package com.my.obj;

class ConsClass{
    //필드
    private  String name ;  //필드 선언


    //생성자
    ConsClass () {

    }
    ConsClass (String name) {
        this.name = name ;       // 생성자를 만들때에는 필드의 이름과 매개변수의 이름이 같기때문에 필드쪽에 this라고 지정해줌
    }

    //메소드
    public void showDate(){
        System.out.println("이름은 " + this.name);
    }
    public void test1(){
        System.out.println("gu");
    }
}


public class TestClass5 {
    public static void main(String[] args) {
        ConsClass obj = new ConsClass("박규태");
        obj.showDate();

        ConsClass obj2 = new ConsClass();
        obj2.test1();
    }
}
