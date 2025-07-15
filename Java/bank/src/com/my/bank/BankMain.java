package com.my.bank;

import com.my.account.Account;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static com.my.config.DBConfig.*;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();


        while (true) {
            System.out.println("\n=== 뱅크 시스템 ===");
            System.out.println("1. 계좌 조회 ");
            System.out.println("2. 입금 ");
            System.out.println("3. 출금 ");
            System.out.println("4. 이체 ");
            System.out.println("5. 전체 계좌 목록");
            System.out.println("6. 계좌 생성");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택 > ");

            int menu = sc.nextInt();
            try {
                switch (menu) {
                    case 1: //  계좌 조회 (비밀번호 인증)
                        System.out.print("조회할 계좌 ID: ");
                        int id = sc.nextInt();
                        System.out.print("비밀번호 4자리: ");
                        String pw = sc.next();
                        Account acc = service.authenticate(id, pw);
                        System.out.println("계좌번호: " + acc.getAccountId());
                        System.out.println("고객명: " + acc.getCustomerName());
                        System.out.println("잔액: " + acc.getBalance());
                        System.out.println("개설일: " + acc.getCreatedAt());
                        break;

                    case 2: //  입금 (비밀번호 인증)
                        System.out.print("입금할 계좌 ID: ");
                        int depositId = sc.nextInt();
                        System.out.print("비밀번호 4자리: ");
                        String depositPw = sc.next();
                        Account depositAcc = service.authenticate(depositId, depositPw);

                        System.out.print("입금 금액: ");
                        BigDecimal depositAmt = sc.nextBigDecimal();
                        service.deposit(depositAcc.getAccountId(), depositAmt);
                        System.out.println(" 입금 완료");
                        break;

                    case 3: //  출금 (비밀번호 인증)
                        System.out.print("출금할 계좌 ID: ");
                        int withdrawId = sc.nextInt();
                        System.out.print("비밀번호 4자리: ");
                        String withdrawPw = sc.next();
                        Account withdrawAcc = service.authenticate(withdrawId, withdrawPw);

                        System.out.print("출금 금액: ");
                        BigDecimal withdrawAmt = sc.nextBigDecimal();
                        service.withdraw(withdrawAcc.getAccountId(), withdrawAmt);
                        System.out.println(" 출금 완료");
                        break;

                    case 4: //  이체 (보내는 계좌만 인증)
                        System.out.print("보내는 계좌 ID: ");
                        int fromId = sc.nextInt();
                        System.out.print("비밀번호 4자리: ");
                        String fromPw = sc.next();
                        Account fromAcc = service.authenticate(fromId, fromPw);

                        System.out.print("받는 계좌 ID: ");
                        int toId = sc.nextInt();
                        System.out.print("이체 금액: ");
                        BigDecimal txAmt = sc.nextBigDecimal();

                        service.transfer(fromAcc.getAccountId(), toId, txAmt);
                        System.out.println(" 이체 성공");
                        break;

                    case 5: // 전체 계좌 목록
                        List<Account> all = service.getAllAccounts();
                        for (Account a : all) {
                            System.out.printf("[%d] %s | 잔액: %s | 생성일: %s%n",
                                    a.getAccountId(), a.getCustomerName(), a.getBalance(), a.getCreatedAt());
                        }
                        break;

                    case 6:
                        sc.nextLine();  // 입력 버퍼 정리 (nextInt 후 nextLine 사용 시 필요)
                        try {
                            System.out.print("예금주 이름 입력: ");
                            String name = sc.nextLine();

                            System.out.print("초기 입금액 입력: ");
                            BigDecimal balance = new BigDecimal(sc.nextLine());

                            System.out.print("비밀번호(4자리 숫자) 입력: ");
                            String password = sc.nextLine();

                            if (!password.matches("\\d{4}")) {
                                System.out.println("❌ 비밀번호는 4자리 숫자여야 합니다.");
                                break;
                            }

                            Account account = new Account();
                            account.setCustomerName(name);
                            account.setBalance(balance);
                            account.setPassword(password);
                            account.setCreatedAt(LocalDateTime.now());

                            service.createAccount(account);  // ✅ 서비스에 위임

                            System.out.println("✅ 계좌가 성공적으로 생성되었습니다. 계좌번호: " + account.getAccountId());
                        } catch (Exception e) {
                            System.out.println("❌ 계좌 생성 중 오류 발생: " + e.getMessage());
                        }
                        break;


                    case 0:
                        System.out.println("프로그램 종료!");
                        sc.close();
                        return;

                    default:
                        System.out.println(" 잘못된 메뉴입니다.");
                }
            } catch (Exception e) {
                System.out.println(" 오류 발생: " + e.getMessage());
            }
        }
    }
}
