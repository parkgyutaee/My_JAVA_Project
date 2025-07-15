package com.my.obj;

import java.lang.reflect.Method;

class MethodClass{

    //메소드는 객체별로 할당하지 않고 메서드 영역에 위치한 메서드를 공유한다.
    public void showMethod() {
        System.out.println("showMethod");
    }

}

public class TestClass4 {
    public static void main(String[] args) {
        MethodClass obj = new MethodClass();
        obj.showMethod();                       // obj객체는 showMethod를 읽어들인다.

        MethodClass obj2 = new MethodClass();
        obj2.showMethod();                      // obj2객체는 showMethod를 읽어들인다.

    }
}
