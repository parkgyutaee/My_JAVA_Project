import java.sql.*;
import java.util.Scanner;

public class StoreMain {
    public static void main(String[] args) {
        Connection connection = null;

        final String connectionUrl = """
                jdbc:oracle:thin:@192.168.0.2:1521/xe
                """;

        try (Scanner scanner = new Scanner(System.in)) {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(connectionUrl, "c##park", "park");
            System.out.println("연결 성공");

            StoreEmployee employee = StoreEmployee.login(connection, scanner);

            if (employee != null) {
                while (true) {
                    System.out.println("\n=== 메뉴 ===");
                    System.out.println("1. 제품 입력");
                    System.out.println("2. 재고 확인");
                    System.out.println("3. 물품 입고");
                    System.out.println("4. 계산 ");
                    System.out.println("5. 메뉴 찾기");
                    System.out.println("6. 원하는 날짜 매출액");
                    System.out.println("7. 종료");
                    System.out.print("메뉴 선택: ");
                    String menu = scanner.nextLine();

                    if (menu.equals("1")) {
                        StoreProduct.InsertProduct(connection, scanner);
                    } else if (menu.equals("2")) {
                        StoreProduct.ShowProduct(connection);
                    } else if (menu.equals("3")) {
                        StoreProduct.RandomProduct(connection);
                    } else if (menu.equals("4")) {
                        StorePayment.cashProduct(connection,scanner);
                    } else if (menu.equals("5")) {
                        StoreProduct.SearchProduct(connection,scanner);
                    } else if (menu.equals("6")) {
                        StorePayment.TotalPayment(connection,scanner);
                    } else if (menu.equals("7")) {
                        employee.logout();
                        employee.updateEmployee(connection);
                        break;
                    }   else {
                            System.out.println("아직 구현되지 않은 기능입니다.");
                        }
                    }
                }

        } catch (ClassNotFoundException e) {
            System.out.println("jdbc11.jar 없습니다.");
        } catch (SQLException e) {
            System.out.println("로그인 오류");
        }
    }
}
