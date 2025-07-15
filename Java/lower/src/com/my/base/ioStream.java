package com.my.base;

import java.util.Scanner;

public class ioStream {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // scanner 객체 생성
        System.out.println("입력하세요: ");
//
//        String str = sc.next();
//        System.out.println(str);

        int num = sc.nextInt();

        String n = String.valueOf(num);
        System.out.println(n);



    }
}
