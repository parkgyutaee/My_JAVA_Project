package com.my.transaction;

import java.sql.Connection;
import java.util.List;

public interface TransactionDAO {

    // 거래 기록 추가 (입금, 출금, 이체)
    void insertTransaction(Transaction transaction, Connection conn) throws Exception;

    // 특정 계좌의 전체 거래 내역 조회
    List<Transaction> findByAccountId(int accountId) throws Exception;

    // 전체 거래 내역 조회 (옵션)
    List<Transaction> findAll() throws Exception;
}
