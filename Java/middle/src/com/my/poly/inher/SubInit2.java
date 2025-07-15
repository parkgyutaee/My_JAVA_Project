package com.my.poly.inher;

public class SubInit2 extends SuperInit2 {
    String code;

    public SubInit2(String country, String city, String code) {
        super(country, city);
        this.code = code;
        System.out.println("SubClass Constructor");
    }

}
