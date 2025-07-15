package com.my.poly.inher;

public class InitMain {
    public static void main(String[] args) {
        SubInit obj = new SubInit("Korea","Seoul","+82");
        System.out.printf("%s, %s, %s \n ",obj.country, obj.city, obj.code);

    }
}
