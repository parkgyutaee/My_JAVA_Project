package com.my.bank;

import com.my.account.Account;
import com.my.account.AccountDAO;
import com.my.account.AccountDAOImpl;
import com.my.transaction.Transaction;
import com.my.transaction.TransactionDAO;
import com.my.transaction.TransactionDAOImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.my.config.DBConfig.*;

public class BankService {

    private AccountDAO accountDAO = new AccountDAOImpl();
    private TransactionDAO transactionDAO = new TransactionDAOImpl();

    // 계좌 조회
    public Account getAccount(int accountId) throws Exception {
        Account account = accountDAO.findById(accountId);
        if (account == null) {
            throw new Exception("해당 계좌가 존재하지 않습니다.");
        }
        return account;
    }

    public void deposit(int accountId, BigDecimal amount) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false); //  트랜잭션 시작

            // 1. 계좌 입금
            accountDAO.deposit(accountId, amount, conn);

            // 2. 거래 로그 기록
            Transaction tx = new Transaction();
            tx.setAccountId(accountId);
            tx.setType("입금");
            tx.setAmount(amount);
            tx.setTransactionDate(java.time.LocalDateTime.now());

            transactionDAO.insertTransaction(tx, conn); //  커넥션 전달해서 로그 저장

            conn.commit(); //  커밋
        } catch (Exception e) {
            throw new Exception("입금 중 오류 발생: " + e.getMessage(), e);
        }
    }



    public void withdraw(int accountId, BigDecimal amount) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false); //  트랜잭션 시작

            // 1. 계좌에서 출금
            accountDAO.withdraw(accountId, amount, conn);

            // 2. 거래 로그 기록
            Transaction tx = new Transaction();
            tx.setAccountId(accountId);
            tx.setType("출금");
            tx.setAmount(amount);
            tx.setTransactionDate(java.time.LocalDateTime.now());

            transactionDAO.insertTransaction(tx, conn); //  같은 커넥션 사용!

            conn.commit(); //  커밋
        } catch (Exception e) {
            throw new Exception("출금 중 오류 발생: " + e.getMessage(), e);
        }
    }


    public void transfer(int fromId, int toId, BigDecimal amount) throws Exception {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false); //  트랜잭션 시작

            // 1. 출금
            accountDAO.withdraw(fromId, amount, conn);

            // 2. 입금
            accountDAO.deposit(toId, amount, conn);

            // 3. 출금 로그
            Transaction outTx = new Transaction();
            outTx.setAccountId(fromId);
            outTx.setType("이체출금");
            outTx.setAmount(amount);
            outTx.setTransactionDate(java.time.LocalDateTime.now());
            transactionDAO.insertTransaction(outTx, conn);

            // 4. 입금 로그
            Transaction inTx = new Transaction();
            inTx.setAccountId(toId);
            inTx.setType("이체입금");
            inTx.setAmount(amount);
            inTx.setTransactionDate(java.time.LocalDateTime.now());
            transactionDAO.insertTransaction(inTx, conn);

            conn.commit(); //  커밋
        } catch (Exception e) {
            if (conn != null) conn.rollback(); // 롤백
            throw new Exception("이체 실패: " + e.getMessage(), e);
        } finally {
            if (conn != null) conn.close();
        }
    }


    public List<Account> getAllAccounts() throws Exception {
        return accountDAO.findAll();
    }

    // 비밀번호 인증 후 계좌 반환
    public Account authenticate(int accountId, String password) throws Exception {
        Account account = accountDAO.findByIdWithPassword(accountId, password);
        if (account == null) {
            throw new Exception(" 인증 실패: 계좌번호 또는 비밀번호가 틀렸습니다.");
        }
        return account;
    }

    public void createAccount(Account account) throws Exception {
        accountDAO.insertAccount(account);
    }

}
