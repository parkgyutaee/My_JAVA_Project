package com.my.transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.my.config.DBConfig.*;  // ✅ DB 설정 불러오기

public class TransactionDAOImpl implements TransactionDAO {

    public TransactionDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 거래 기록 저장
    @Override
    public void insertTransaction(Transaction transaction, Connection conn) throws SQLException {
        String sql = "INSERT INTO transaction (account_id, type, amount, transaction_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, transaction.getAccountId());
            pstmt.setString(2, transaction.getType());
            pstmt.setBigDecimal(3, transaction.getAmount());
            pstmt.setTimestamp(4, Timestamp.valueOf(transaction.getTransactionDate()));

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("거래 기록 저장 실패");
            }

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    transaction.setTransactionId(rs.getInt(1));
                }
            }
        }
    }


    // 특정 계좌의 거래 내역 조회
    @Override
    public List<Transaction> findByAccountId(int accountId) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT transaction_id, account_id, type, amount, transaction_date FROM transaction WHERE account_id = ? ORDER BY transaction_date DESC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, accountId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction t = new Transaction(
                            rs.getInt("transaction_id"),
                            rs.getInt("account_id"),
                            rs.getString("type"),
                            rs.getBigDecimal("amount"),
                            rs.getTimestamp("transaction_date").toLocalDateTime()
                    );
                    transactions.add(t);
                }
            }
        }

        return transactions;
    }

    // 전체 거래 내역 조회
    @Override
    public List<Transaction> findAll() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT transaction_id, account_id, type, amount, transaction_date FROM transaction ORDER BY transaction_date DESC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("account_id"),
                        rs.getString("type"),
                        rs.getBigDecimal("amount"),
                        rs.getTimestamp("transaction_date").toLocalDateTime()
                );
                transactions.add(t);
            }
        }

        return transactions;
    }
}
