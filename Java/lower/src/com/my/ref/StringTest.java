package com.my.ref;

public class StringTest {
    public static void main(String[] args) {
        String str = "Hello-java";

        System.out.println(str.length()); // length 문자열의 길이 반환
        System.out.println(str.charAt(6));
        System.out.println(str.replace("j","J"));
        System.out.println(str.substring(0,4));

        String[] tokens = str.split("-");
        System.out.println(tokens[1]);
        System.out.println(tokens[0]);
    }

}
