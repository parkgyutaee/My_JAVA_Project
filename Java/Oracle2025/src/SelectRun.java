import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class SelectRun {
    public static void main(String[] args) {
        Connection connection = null;
        final String connectionUrl = """
                jdbc:oracle:thin:@192.168.0.2:1521/xe
                """;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(connectionUrl, "c##madang", "madang");
            final String select_sql = """
                    SELECT bookid, bookname, publisher, price\s
                    FROM book
                    """;

            final PreparedStatement preparedStatement = connection.prepareStatement(select_sql);
            final ResultSet resultSet = preparedStatement.executeQuery();
            final OutputStream outputStream = new FileOutputStream("./oracle.txt");
            final Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);

            while (resultSet.next()) {
                final Book book = new Book(resultSet.getInt(1), resultSet.getString(2),
                                           resultSet.getString(3), resultSet.getInt(4));
                System.out.printf("%s\r\n",book);
                writer.write(String.valueOf(book));
                System.out.println("");
                writer.flush();     // 버퍼를 비워주세요.
            }
            writer.close();
            resultSet.close();
            preparedStatement.close();


        } catch (ClassNotFoundException e) {
            System.out.printf("%s\r\n","로그인 또는 오타");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            System.out.printf("%s\r\n","파일이 없습니다");
        } catch (IOException e) {
            System.out.printf("%s\r\n","write() 함수 오류");
        } finally {
            try {
                System.out.printf("%s\r\n","연결종료");
                connection.close();
            } catch (SQLException e) {
                System.out.printf("%s\r\n");

            }
        }
    }
    }
