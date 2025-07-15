import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRun {
    public static void main(String[] args) {
        Connection connection = null;
        final String connectionUrl = """
                jdbc:oracle:thin:@192.168.0.2:1521/xe
                """;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(connectionUrl, "c##madang", "madang");
            final String update_sql = new StringBuilder()
                    .append("UPDATE customer SET\s")
                    .append("name=?, ")
                    .append("address=?, ")
                    .append("phone=? \s")
                    .append("WHERE custid=?")
                    .toString();
            final PreparedStatement preparedStatement = connection.prepareStatement(update_sql);
            preparedStatement.setString(1,"세리 팍");
            preparedStatement.setString(2, "대한민국 대전");
            preparedStatement.setString(3, "010-9999-9999");
            preparedStatement.setInt(4,4);
            final int row = preparedStatement.executeUpdate();
            System.out.printf("%s %d\r\n", "수정된 데이터 행",row);
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.printf("%s\r\n","로그인 또는 오타.");
        } catch (ClassNotFoundException e) {
            System.out.printf("%s\r\n","ojdbc11jar가 없습니다.");
        } finally{
            System.out.printf("%s\r\n","연경종료");
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.printf("%s\r\n","connection오류");
            }
        }
    }
}
