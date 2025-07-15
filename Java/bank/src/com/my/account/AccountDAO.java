package com.my.account;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    // 계좌 생성
    void insertAccount(Account account) throws Exception;

    // 계좌 번호로 계좌 조회
    Account findById(int accountId) throws Exception;

    // 전체 계좌 목록 조회 (옵션)
    List<Account> findAll() throws Exception;

    // 계좌 잔액 변경 (입금/출금)
    void updateBalance(int accountId, java.math.BigDecimal newBalance) throws Exception;

    // 출금
    void withdraw(int accountId, BigDecimal amount, Connection conn) throws SQLException;

    // 입금
    void deposit(int accountId, BigDecimal amount, Connection conn) throws SQLException;

    // 비밀번호 포함 계좌 조회
    Account findByIdWithPassword(int accountId, String password) throws SQLException;



}
