package com.my.nested;
/*
    내부클레스에서는 외부 클래스의 모든 멤버를 사용할 수 있다.
 */
class Outer{

    class Inner{
        int innerField = 11;
        static int innerStaticField = 22;         //  내부 정적 멤버

        void innerMethod() {
            System.out.printf("innerField %d \n",innerField);
        }
        static void innerStaticMethod() {           //  내부 정적 메소드
            System.out.printf("innerStaticField %d \n",innerStaticField);
        }
        void innerToOuter (){                       // 내부 클래스에서 외부 클래스멤버 접근
            OuterField = 100;
            outStaticField = 200;
            outerMethod();
            outerStaticMethod();
        }
    }

    int OuterField = 1;
    static int outStaticField = 2;

    void outerMethod() {
        System.out.printf("outerField %d \n",OuterField);
    }
    static void outerStaticMethod() {
        System.out.printf("outerStaticField %d \n",outStaticField);
    }
}

public class NestedMain2 {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.outerMethod();
        Outer.outerStaticMethod();

        Outer.Inner in = new Outer().new Inner();
        in.innerMethod();
        in.innerToOuter();

        Outer.outerStaticMethod();
        // Outer.Inner.innerStaticMethod();


    }
}
