package com.my.nested;

class MyClass{
    String str = "This is MyClass";
    void show() {
        System.out.println(str);
    }
    class Inner {
        String str = "This is Inner Class";
        void show () {
            System.out.println(str);
        }
        void show2 () {
            this.show();                //this란 동일한 이름일 때 바깥 멤버의 접근법
            MyClass.this.show();
        }
    }
}
public class NestedMain4 {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
//      obj.show();
        MyClass.Inner in = obj.new Inner();
        in.show();
        in.show2();

    }
}
