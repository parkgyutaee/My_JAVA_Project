package store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StoreMain {
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
