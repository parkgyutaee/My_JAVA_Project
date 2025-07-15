package com.my.obj;
/*
필드
생성자는 초기화 기능
클래스는 컴파일을 통해서 바이트코드로 변환 (클래스 파일)되고, JVM은 클래스 로더를 통해 클래스 파일을 읽고
*/
class FieldClass{
    String str = "MyClass";
}
public class TestClass3 {

    public static void main(String[] args) {
        FieldClass obj = new FieldClass();

        System.out.println(obj.str);
    }
}
