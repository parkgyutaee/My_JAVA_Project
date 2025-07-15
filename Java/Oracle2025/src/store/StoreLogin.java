package store;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StoreLogin {
    public static void main(String[] args) {
        Connection connection = null;
        final String connectionUrl = """
                jdbc:oracle:thin:@192.168.0.2:1521/xe
                """;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(connectionUrl, "c##madang", "madang");
            System.out.printf("%s\r\n", connection);
            System.out.printf("%s\r\n", "연결 성공");

            Scanner scanner = new Scanner(System.in);

            System.out.print("아이디 입력: ");
            String inputId = scanner.nextLine();

            System.out.print("비밀번호 입력: ");
            String inputPw = scanner.nextLine();

            String selectSql = """
                SELECT empName FROM Employee
                WHERE empId = ? AND empPw = ?
                """;

            PreparedStatement pstmt = connection.prepareStatement(selectSql);
            pstmt.setString(1, inputId);
            pstmt.setString(2, inputPw);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String empName = rs.getString("empName");
                System.out.printf("사원: %s 안녕하세요.\n", empName);

                // 현재 로그인 시간 저장
                String updateSql = """
                    UPDATE Employee
                    SET lastLogin = SYSTIMESTAMP
                    WHERE empId = ?
                    """;
                PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                updateStmt.setString(1, inputId);
                updateStmt.executeUpdate();
                updateStmt.close();

            } else {
                System.out.println("로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.");
            }

            rs.close();
            pstmt.close();

        } catch (ClassNotFoundException e) {
            System.out.printf("%s\r\n", "jdbc11.jar 없습니다.");
        } catch (SQLException e) {
            System.out.printf("%s\r\n", "로그인 오류");
        } finally {
            System.out.printf("%s\r\n", "연결종료");
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("연결오류");
            }
        }
    }
}
