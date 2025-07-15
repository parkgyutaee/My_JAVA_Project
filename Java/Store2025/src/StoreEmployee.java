import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StoreEmployee {
    private String empId;
    private String password;
    private String name;

    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;


    private long workMinutes;
    private long dailyPay;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPsssword() {
        return password;
    }

    public void setPsssword(String psssword) {
        this.password = psssword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoreEmployee (String empId, String password, String name) {
        this.empId = empId;
        this.password = password;
        this.name = name;
    }

    public void markLoginTime() {
        this.loginTime = LocalDateTime.now();
    }

    public static StoreEmployee login(Connection connection, Scanner scanner) {
        System.out.println("===== 로그인 창 =====");
        System.out.print("아이디 입력: ");
        String inputId = scanner.nextLine();

        System.out.print("비밀번호 입력: ");
        String inputPw = scanner.nextLine();

        final String sql = """
            SELECT empId, password, name FROM EMPLOYEE WHERE empId = ? AND password = ?
            """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, inputId);
            preparedStatement.setString(2, inputPw);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                StoreEmployee employee = new StoreEmployee(
                        rs.getString("empId"),
                        rs.getString("password"),
                        rs.getString("name")
                );
                employee.markLoginTime();
                System.out.println("로그인 성공: " + employee.name + "님 환영합니다.");
                return employee;
            } else {
                System.out.println(" 아이디 또는 비밀번호가 일치하지 않습니다.");
            }

        } catch (SQLException e) {
            System.out.println("로그인 중 오류 발생: " + e.getMessage());
        }

        return null;
    }
    // 로그아웃 및 일당 계산 메서드
    public void logout() {
        this.logoutTime = LocalDateTime.now();

        this.workMinutes = Duration.between(loginTime, logoutTime).toMinutes();
        this.dailyPay = this.workMinutes * 11000;

        System.out.println("로그아웃 하셨습니다.");
        System.out.println("오늘 총 근무 시간은 " + workMinutes + "분입니다!");
        System.out.println("오늘 총 일당은 " + dailyPay + "원입니다! 고생하셨습니다!");
    }

    // 로그아웃 후 테이블 업데이트
    public void updateEmployee(Connection connection) {
        final String update_sql = new StringBuilder()
                .append("UPDATE EMPLOYEE SET ")
                .append("loginTime = ?, ")
                .append("logoutTime = ?, ")
                .append("workMinutes = ?, ")
                .append("dailyPay = ? ")
                .append("WHERE empId = ?")
                .toString();

        try (PreparedStatement preparedStatement = connection.prepareStatement(update_sql)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(loginTime));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(logoutTime));
            preparedStatement.setLong(3, workMinutes);
            preparedStatement.setLong(4, dailyPay);
            preparedStatement.setString(5, empId);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("박규태님 안녕히 가세요!");
            } else {
                System.out.println("DB 업데이트 실패: 해당 사원이 존재하지 않습니다.");
            }

        } catch (SQLException e) {
            System.out.println("DB 업데이트 중 오류 발생: " + e.getMessage());
        }
    }

}
