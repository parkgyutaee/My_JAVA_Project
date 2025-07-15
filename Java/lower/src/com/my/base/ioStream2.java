package com.my.base;

import java.util.Scanner;

public class ioStream2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("입력하세요: ");

        byte b = sc.nextByte();
        short s = sc.nextShort();
        int i = sc.nextInt();
        double d = sc.nextDouble();
        char c = sc.next().charAt(0);

        String str = sc.next(); //공백을 기준으로 읽어옴
        String str2 = sc.nextLine(); // 계행을 기준으로 읽어옴

        System.out.println(b);
    }
}