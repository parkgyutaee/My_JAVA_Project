package com.my.poly.library;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager manager = new BookManager();

        while (true) {
            System.out.println("1. 책 등록, 2. 목록, 3. 검색, 4. 삭제, 0. 종료");
            System.out.print("번호를 골라 입력해주세요! ");
            int menu = sc.nextInt();
            sc.nextLine(); // 엔터 처리

            if (menu == 1) {
                System.out.print("제목 입력: ");
                String title = sc.nextLine();
                System.out.print("저자 입력: ");
                String author = sc.nextLine();
                manager.addBooks(title, author);
            } else if (menu == 2) {
                manager.booksList();
            } else if (menu == 3) {
                System.out.print("검색할 제목 키워드: ");
                String keyword = sc.nextLine();
                manager.searchBooks(keyword);
            } else if (menu == 4) {
                System.out.print("삭제할 책 ID 입력: ");
                int id = sc.nextInt();
                manager.deleteBooks(id);
            } else if (menu == 0) {
                System.out.println("프로그램 종료!");
                break;
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
        sc.close();
    }
}
