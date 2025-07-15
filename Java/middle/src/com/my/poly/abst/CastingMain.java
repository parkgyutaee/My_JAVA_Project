package com.my.poly.abst;

class Base{
    void method1 () {
        System.out.println("Base Method!");
    }
    public void method3 () {
        System.out.println("override - Base");
    }
}

class Derived extends Base{
    public void method2() {
        System.out.println("Derived method");
    }
    @Override
    public void method3() {
        System.out.println("Override - Derived");
    }
}
public class CastingMain {
    public static void main(String[] args) {
        Base b = new Base();
        b.method1();
        b.method3();

        Derived d = new Derived();
        d.method2();
        d.method1();
        d.method3();

        Base obj = new Derived();   //UPCASTING(자동타입변환)
        obj.method3();
        obj.method1();

        /*
        Derived d2 = (Derived) obj;
        d2.method3();
        d2.method1();
        d2.method2();
         */

        if (obj instanceof Derived d2) {
            d2.method1();
            d2.method2();
            d2.method3();
        }
    }
}
