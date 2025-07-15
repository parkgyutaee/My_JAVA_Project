package com.my.account;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.my.config.DBConfig.*;

public class AccountDAOImpl implements AccountDAO {

    public AccountDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL 드라이버 로드
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // ✅ 계좌 생성 (비밀번호 포함)
    @Override
    public void insertAccount(Account account) throws SQLException {
        String sql = "INSERT INTO account (customer_name, balance, created_at, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, account.getCustomerName());
            pstmt.setBigDecimal(2, account.getBalance());
            pstmt.setTimestamp(3, Timestamp.valueOf(account.getCreatedAt()));
            pstmt.setString(4, account.getPassword());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("계좌 생성 실패, 영향 받은 행이 없습니다.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    account.setAccountId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("계좌 ID 자동 생성 실패.");
                }
            }
        }
    }

    // ✅ 계좌 번호로 조회
    @Override
    public Account findById(int accountId) throws SQLException {
        String sql = "SELECT account_id, customer_name, balance, created_at, password FROM account WHERE account_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, accountId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Account(
                            rs.getInt("account_id"),
                            rs.getString("customer_name"),
                            rs.getBigDecimal("balance"),
                            rs.getTimestamp("created_at").toLocalDateTime(),
                            rs.getString("password")
                    );
                }
            }
        }
        return null;
    }

    // ✅ 전체 계좌 목록 조회
    @Override
    public List<Account> findAll() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, customer_name, balance, created_at, password FROM account";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("account_id"),
                        rs.getString("customer_name"),
                        rs.getBigDecimal("balance"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getString("password")
                ));
            }
        }
        return accounts;
    }

    // ✅ 잔액 변경
    @Override
    public void updateBalance(int accountId, BigDecimal newBalance) throws SQLException {
        String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBigDecimal(1, newBalance);
            pstmt.setInt(2, accountId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("잔액 업데이트 실패, 해당 계좌가 없습니다.");
            }
        }
    }

    // ✅ 출금
    @Override
    public void withdraw(int accountId, BigDecimal amount, Connection conn) throws SQLException {
        String sql = "UPDATE account SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, amount);
            pstmt.setInt(2, accountId);
            pstmt.setBigDecimal(3, amount);
            int rows = pstmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("출금 실패: 계좌가 없거나 잔액 부족");
            }
        }
    }

    // ✅ 입금
    @Override
    public void deposit(int accountId, BigDecimal amount, Connection conn) throws SQLException {
        String sql = "UPDATE account SET balance = balance + ? WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, amount);
            pstmt.setInt(2, accountId);
            int rows = pstmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("입금 실패: 해당 계좌가 없음");
            }
        }
    }

    // ✅ 계좌번호 + 비밀번호로 인증
    @Override
    public Account findByIdWithPassword(int accountId, String password) throws SQLException {
        String sql = "SELECT account_id, customer_name, balance, created_at, password FROM account WHERE account_id = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, accountId);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Account(
                            rs.getInt("account_id"),
                            rs.getString("customer_name"),
                            rs.getBigDecimal("balance"),
                            rs.getTimestamp("created_at").toLocalDateTime(),
                            rs.getString("password")
                    );
                }
            }
        }
        return null;
    }


}
