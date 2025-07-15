package com.my.ref;


public class EnumTest {
    String a = "AMERICANO";

    enum CoffType{
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE
    }
    public static void main(String[] args) {
        System.out.println(CoffType.AMERICANO);
        System.out.println(CoffType.ICE_AMERICANO);
        System.out.println(CoffType.CAFE_LATTE);


    }
}
