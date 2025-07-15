package com.my.nested;
/*
    로컬클래스 - 메서드안에 정의된 클래스
 */
class AAA{

    void method() {                     //메서드 안에 클래스도 생성가능
        int localVal = 10;

        class Local {                   // 메서드 안에서만 사용하니까 (지역변수마냥) 지역 클래스
            int localField = 1;
            static int localStaticField = 2;

            void localMethod () {
                System.out.printf("localField %d, localVal %d \n",localField, localVal);

            }
            static void localStaticMethod () {
                System.out.printf("localStaticField %d\n",localStaticField);
            }
        }

        Local lo = new Local();
        lo.localMethod();
        Local.localStaticMethod();
    }


}

public class NestedMain3 {
    public static void main(String[] args) {
        AAA a = new AAA();
        a.method();
    }
}
