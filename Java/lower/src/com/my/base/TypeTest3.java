package com.my.base;

public class TypeTest3 {
    public static void main(String[] args) {
        int val = Integer.parseInt("100"); // 문자열을 정수로 변환
        double val2 = Double.parseDouble("3.14"); // 문자열을 실수로 변환

        System.out.println(val);
        System.out.println(val2);

        String str = String.valueOf(100); // 숫자형을 문자형으로 변환
        String str2 = String.valueOf(3.14); // 실수형을 문자형으로 변환

        System.out.println(str);
        System.out.println(str2);
    }
}
