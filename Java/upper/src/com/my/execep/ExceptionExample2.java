package com.my.execep;
/*
    
 */
class AgeUnder18Exception extends Exception{
    public AgeUnder18Exception(String message) {
        super(message);             // 부모생성자 호출
    }
}
public class ExceptionExample2 {
    // throws는 호출한 곳으로 예외를 던진다.(AgeUnder18Exception 예외 클래스로 던진다.)
    public static void checkAge(int age) throws AgeUnder18Exception {
        if(age < 18) {
            throw new AgeUnder18Exception("미성년자입니다");
        } else {
            System.out.println("통과");
        }
    }

    public static void main(String[] args) {
        int useAge = 28;

        try{
            checkAge(useAge);
        } catch (AgeUnder18Exception e) {
            System.out.println("예외처리:" + e.getMessage());
        }
    }
}
