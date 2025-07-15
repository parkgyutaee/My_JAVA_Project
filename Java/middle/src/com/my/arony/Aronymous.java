package com.my.arony;
/*
    부모 생성자 호출시 몸체 부분을 만들고 그안에 자식 객체를 만든다

 */
class AAA{
    public void instanceMethod() {
        System.out.println("instanceMethod");
    }
}
public class Aronymous {
    public static void main(String[] args) {
        AAA a = new AAA() {
//            @Override
//            public void instanceMethod () {
//                System.out.println("InstanceMethod Override");
//            }

            @Override
            public void instanceMethod() {
                super.instanceMethod();
                System.out.println("InstanceMethod Override");
            }
        };

        a.instanceMethod();
        System.out.println(a.toString());
    }
}
