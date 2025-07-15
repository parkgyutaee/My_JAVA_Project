package com.my.base;

import java.util.Scanner;

public class ioStream3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();            // 이전에 엔터키를 가져온다.

        System.out.print("나이를 입력해보세요: ");
        int i = sc.nextInt();                   // 버퍼에 엔터키가 남아있다.




        System.out.println("num: " + i);
        System.out.println("이름: " + name);
    }
}
