package com.my.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    private int accountId;               // 계좌 고유 번호
    private String customerName;         // 고객 이름
    private BigDecimal balance;          // 현재 잔액
    private LocalDateTime createdAt;     // 계좌 생성 시간
    private String password;
    // 기본 생성자
    public Account() {}

    // 전체 필드 생성자
    public Account(int accountId, String customerName, BigDecimal balance, LocalDateTime createdAt, String password) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.balance = balance;
        this.createdAt = createdAt;
        this.password = password;
    }

    // Getter & Setter
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", customerName='" + customerName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", password='" + password + '\'' +
                '}';
    }

}
