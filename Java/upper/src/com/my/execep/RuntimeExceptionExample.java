package com.my.execep;

public class RuntimeExceptionExample {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println("문자열길이" + str.length());
        } catch (NullPointerException e) {
            System.out.println("예외발생: 문자열이 Null입니다.");
        }

        String str2 = "12345";
        int res = 0;
        try {
            res = Integer.parseInt(str2);
            System.out.printf("변환된 숫자: + %d",res);
        } catch (NumberFormatException e) {
            System.out.println("예외발생: 숫자 형식이 올바르지 않습니다.");
        }



    }
}
