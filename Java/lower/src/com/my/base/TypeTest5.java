package com.my.base;

public class TypeTest5 {
    public static void main (String[] args){
        String str = "let's learn Java";
        String str2 = "let's learn Java";

        System.out.println(System.identityHashCode(str));
        System.out.println(System.identityHashCode(str2));

        String str3 = new String("let's learn Java");
        String str4 = new String("let's learn Java");

        System.out.println(System.identityHashCode(str3));
        System.out.println(System.identityHashCode(str4));
    }
}
