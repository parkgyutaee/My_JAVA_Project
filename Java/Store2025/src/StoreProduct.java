import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StoreProduct {
    private int productId;         // 제품 ID
    private String productName;    // 제품명
    private String manufacturer;   // 제조 회사
    private LocalDate expirationDate; // 유통기한
    private boolean isAdultOnly;   // 19금 여부
    private int price;             // 가격
    private int quantity;          // 수량

    public StoreProduct(String name, String manufacturer, LocalDate expirationDate, boolean isAdultOnly, int price, int quantity) {
        this.productName = name;
        this.manufacturer = manufacturer;
        this.expirationDate = expirationDate;
        this.isAdultOnly = isAdultOnly;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isAdultOnly() {
        return isAdultOnly;
    }

    public void setAdultOnly(boolean adultOnly) {
        isAdultOnly = adultOnly;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public static StoreProduct InsertProduct(Connection connection, Scanner scanner) {
        System.out.println("\n==== 제품 등록 ====");

        System.out.print("제품명 입력: ");
        String name = scanner.nextLine();

        System.out.print("제조 회사 입력: ");
        String manufacturer = scanner.nextLine();

        System.out.print("유통기한 입력 (예: 2025-12-31): ");
        String expDateStr = scanner.nextLine();
        LocalDate expirationDate;

        System.out.print("19금 제품인가요? (Y/N): ");
        String adultInput = scanner.nextLine().trim().toUpperCase();
        boolean isAdultOnly = adultInput.equals("Y");

        System.out.print("가격 입력 (숫자): ");
        int price = scanner.nextInt();

        System.out.print("수량 입력 (숫자): ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        try {
            expirationDate = LocalDate.parse(expDateStr);
        } catch (Exception e) {
            System.out.println("유통기한 형식 오류입니다.");
            return null;
        }

        if (expirationDate.isBefore(LocalDate.now())) {
            System.out.println("유통기한이 지난 제품은 등록할 수 없습니다.");
            return null;
        }

        final String insert_sql = new StringBuilder()
                .append("INSERT INTO PRODUCT (")
                .append("productName, manufacturer, expirationDate, isAdultOnly, ")
                .append("price, quantity) ")
                .append("VALUES (?, ?, ?, ?, ?, ?)")
                .toString();


        try (PreparedStatement prepareStatement = connection.prepareStatement(insert_sql)) {
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, manufacturer);
            prepareStatement.setDate(3, Date.valueOf(expirationDate));
            prepareStatement.setString(4, isAdultOnly ? "Y" : "N");
            prepareStatement.setInt(5, price);
            prepareStatement.setInt(6, quantity);

            int result = prepareStatement.executeUpdate();
            if (result > 0) {
                System.out.println(" 제품이 성공적으로 등록되었습니다.");
            } else {
                System.out.println(" 제품 등록 실패");
            }

        } catch (SQLException e) {
            System.out.println("제품 등록 중 오류: " + e.getMessage());
        }
        return null;
    }



    public static void ShowProduct (Connection connection) {
        final String showProduct_sql = """
                SELECT productName, quantity FROM Product
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(showProduct_sql)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                String stars = "*".repeat(quantity);
                System.out.printf("%s : %s (%d)\n",productName, stars, quantity );
            }
        } catch (SQLException e) {
            System.out.println("rs executequery 오류");
            e.printStackTrace();
        }
    }

    // 물품 입고 메서드
    public static void RandomProduct(Connection connection) {

        final String select_sql = """
                SELECT productName FROM PRODUCT
                """;
        List<String> productList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(select_sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                productList.add(rs.getString("productName"));
            }
            if (productList.isEmpty()) {
                System.out.println("입고 가능한 제품이 없습니다.");
                return;
            }

            // 랜덤 제품과 수량 선택
            Random random = new Random();
            String chosenProduct = productList.get(random.nextInt(productList.size()));
            int addedQuantity = random.nextInt(5) + 1; // 1~5개 랜덤 수량


            // UPDATE 실행
            final String update_sql = new StringBuilder()
                    .append("UPDATE PRODUCT SET ")
                    .append("quantity = quantity + ? ")
                    .append("WHERE UPPER(productName) = ?")
                    .toString();

            try (PreparedStatement updateStmt  = connection.prepareStatement(update_sql)) {
                updateStmt .setInt(1, addedQuantity);
                updateStmt .setString(2, chosenProduct.toUpperCase());
                int result = updateStmt.executeUpdate();
                if (result > 0) {
                    System.out.printf("입고 도착했습니다 %s: %d개가 추가되었습니다!\n", chosenProduct, addedQuantity);
                } else {
                    System.out.println("입고 실패: 제품 이름을 찾을 수 없습니다.");
                }
            }

        } catch (SQLException e) {
            System.out.println("업데이트 문 오류");
        }
    }


    public static void SearchProduct(Connection connection, Scanner scanner) {
        final String search_sql = """
                                SELECT productName, quantity, price FROM Product WHERE productName = ?
                                """;

        System.out.print("찾고 싶은 제품명을 입력하세요: ");
        String productName = scanner.nextLine();

        try (PreparedStatement preparedStatement = connection.prepareStatement(search_sql)) {
            preparedStatement.setString(1, productName);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("productName");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");

                    System.out.println("==== 제품 정보 ====");
                    System.out.println("제품명: " + name);
                    System.out.println("수량: " + quantity);
                    System.out.println("가격: " + price + "원");
                } else {
                    System.out.println("해당 제품은 여기에 없습니다ㅠㅠ");
                }
            }
        } catch (SQLException e) {
            System.out.println("제품 검색 중 오류 발생: " + e.getMessage());
        }
    }


}

