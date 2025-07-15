import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorePayment {
    private List<String> productNames; // 구매한 상품명 목록
    private List<Integer> quantities;
    private int totalPrice;         // 전체 결제 금액
    private String paymentMethod;

    public StorePayment(List<String> productNames, List<Integer> quantities, int totalPrice, String paymentMethod) {
        this.productNames = productNames;
        this.quantities = quantities;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public static void cashProduct(Connection connection, Scanner scanner) {
        final String show_sql = """
        SELECT productId, productName, manufacturer, expirationDate,
               isAdultOnly, price, quantity
        FROM Product
        """;
        List<StoreProduct> productList = new ArrayList<>();

        System.out.println("=====상품 목록=====");

        try (PreparedStatement preparedStatement = connection.prepareStatement(show_sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                StoreProduct product = new StoreProduct(
                        rs.getString("productName"),
                        rs.getString("manufacturer"),
                        rs.getDate("expirationDate").toLocalDate(),
                        rs.getString("isAdultOnly").equals("Y"),
                        rs.getInt("price"),
                        rs.getInt("quantity")
                );
                product.setProductId(rs.getInt("productId"));
                productList.add(product);

                System.out.printf("%s : %d개\n", product.getProductName(), product.getQuantity());
            }

            System.out.println("어떤 것을 구매하시겠습니까?");
            System.out.println("원하는 상품을 입력하세요! (여러개는 ,쉼표로 구분)");

            String input = scanner.nextLine();
            String[] selectedNames = input.split(",");

            List<StoreProduct> selectedProducts = new ArrayList<>();

            for (String rawName : selectedNames) {
                String trimmedInput = rawName.trim().replaceAll("\\s+", "");
                for (StoreProduct product : productList) {
                    String dbNameNoSpace = product.getProductName().replaceAll("\\s+", "");
                    if (trimmedInput.equalsIgnoreCase(dbNameNoSpace)) {
                        selectedProducts.add(product);
                        break;
                    }
                }
            }

            if (selectedProducts.isEmpty()) {
                System.out.println("선택한 상품이 존재하지 않습니다.");
                return;
            }

            LocalDate today = LocalDate.now();
            List<StoreProduct> expired = new ArrayList<>();
            for (StoreProduct p : selectedProducts) {
                if (p.getExpirationDate().isBefore(today)) {
                    expired.add(p);
                }
            }

            if (!expired.isEmpty()) {
                System.out.println("유통기한이 지난 상품은 구매할 수 없습니다:");
                for (StoreProduct p : expired) {
                    System.out.println("- " + p.getProductName());
                }
                selectedProducts.removeAll(expired);
            }

            boolean hasAdultItem = selectedProducts.stream().anyMatch(StoreProduct::isAdultOnly);
            if (hasAdultItem) {
                System.out.print("19금 상품이 포함되어 있습니다. 주민등록확인을 위해 나이를 입력하세요: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age < 20) {
                    System.out.println("미성년자는 19금 상품을 구매할 수 없습니다.");
                    selectedProducts.removeIf(StoreProduct::isAdultOnly);
                }
            }



            if (selectedProducts.isEmpty()) {
                System.out.println("구매 가능한 상품이 없습니다. 결제를 종료합니다.");
                return;
            }

            List<String> productNames = new ArrayList<>();
            List<Integer> quantities = new ArrayList<>();
            int totalPrice = 0;

            for (StoreProduct product : selectedProducts) {
                int stock = product.getQuantity();
                int count = 0;

                while (true) {
                    System.out.printf("%s 몇 개 구매하시겠습니까? (재고: %d) → ", product.getProductName(), stock);
                    String qtyInput = scanner.nextLine();
                    try {
                        count = Integer.parseInt(qtyInput);
                        if (count <= 0) {
                            System.out.println("1개 이상 입력해야 합니다.");
                        } else if (count > stock) {
                            System.out.println("재고보다 많은 수량을 입력할 수 없습니다.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("숫자로 입력해주세요.");
                    }
                }

                productNames.add(product.getProductName());
                quantities.add(count);
                totalPrice += product.getPrice() * count;
            }
            System.out.printf("총 결제 금액은 %d원입니다.\n", totalPrice);


            System.out.print("결제 수단을 선택하세요 (카드/현금): ");
            String paymentMethod = scanner.nextLine().trim();

            if (!paymentMethod.equals("카드") && !paymentMethod.equals("현금")) {
                System.out.println("올바른 결제 수단이 아닙니다. 결제 취소합니다.");
                return;
            }
            if (paymentMethod.equals("현금")) {
                System.out.print("얼마를 내시겠습니까? → ");
                int cash = Integer.parseInt(scanner.nextLine());
                if (cash < totalPrice) {
                    System.out.println("지불 금액이 부족합니다. 결제를 취소합니다.");
                    return;
                }
                int change = cash - totalPrice;
                System.out.printf("거스름돈은 %d원입니다.\n", change);
            }

            final String updateBalanceSql = "UPDATE STORE_STATUS SET balance = balance + ? WHERE statusId = 1";
            try (PreparedStatement prepareStatement = connection.prepareStatement(updateBalanceSql)) {
                prepareStatement.setInt(1, totalPrice);
                prepareStatement.executeUpdate();
            }

            StorePayment payment = new StorePayment(productNames, quantities, totalPrice, paymentMethod);
            payment.insertPayment(connection);

            System.out.println("결제가 완료되었습니다.");

            final String updateStockSql = "UPDATE Product SET quantity = quantity - ? WHERE productName = ?";
            try (PreparedStatement prepareStatement = connection.prepareStatement(updateStockSql)) {
                for (int i = 0; i < productNames.size(); i++) {
                    prepareStatement.setInt(1, quantities.get(i));
                    prepareStatement.setString(2, productNames.get(i));
                    prepareStatement.executeUpdate();
                }
                System.out.println("재고가 정상적으로 차감되었습니다.");
            } catch (SQLException e) {
                System.out.println("재고 차감 중 오류 발생");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("상품 조회 중 오류 발생");
            e.printStackTrace();
        }
    }




    public void insertPayment(Connection connection) {
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PAYMENT (")
                .append("totalPrice, paymentMethod")
                .append(") VALUES (?, ?)");

        try (PreparedStatement pstmt = connection.prepareStatement(sql.toString())) {
            pstmt.setInt(1, totalPrice);
            pstmt.setString(2, paymentMethod);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("결제 내역이 저장되었습니다.");
            } else {
                System.out.println("결제 저장 실패.");
            }

        } catch (SQLException e) {
            System.out.println("결제 저장 중 오류 발생:");
            e.printStackTrace();
        }
    }


    public static void TotalPayment(Connection connection, Scanner scanner) {

        final String totalPay_sql = """
                SELECT SUM(TotalPrice) AS total FROM payment
                WHERE TRUNC(paymentDate) = ?
                """;

        System.out.println("총매출액을 알려드릴게요");
        System.out.print("원하는 날짜를 yyyy-mm-dd 형식으로 입력하세요: ");
        String paymentDateStr = scanner.nextLine();

        try (PreparedStatement preparedStatement = connection.prepareStatement(totalPay_sql)) {
            // 날짜 문자열을 java.sql.Date로 변환
            Date paymentDate = Date.valueOf(paymentDateStr);
            preparedStatement.setDate(1, paymentDate);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt("total");
                    System.out.println("총 매출액은 " + total + "원입니다.");
                } else {
                    System.out.println("해당 날짜에 매출이 없습니다.");
                }
            }
        } catch (SQLException e) {
            System.out.println("총 매출 검색 중 오류 발생: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("날짜 형식이 잘못되었습니다. yyyy-mm-dd 형식으로 입력해주세요.");
        }
    }





}
