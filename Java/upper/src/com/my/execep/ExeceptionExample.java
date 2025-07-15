package com.my.execep;
/*
    일반예외(Exception) - 컴파일러가 예외 처리 코드 여부를 검사
 */
public class ExeceptionExample {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 2;
            int result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }   finally {
            System.out.println("프로그램 정상 종료");
        }

    }
}
