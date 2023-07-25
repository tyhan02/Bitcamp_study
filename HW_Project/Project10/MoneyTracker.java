package Project10;

import java.sql.*;

public class MoneyTracker {
    // MySQL 데이터베이스 연결 정보
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Money";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0000";

    public static void main(String[] args) {
        // 데이터베이스 연결 객체
        Connection conn = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 용돈 기입 정보를 추가하는 메서드 호출
            addMoneyEntry(conn, "2023-07-24", "식료품 구매", 50.00);
            addMoneyEntry(conn, "2023-07-25", "카페에서 커피", 5.00);
            addMoneyEntry(conn, "2023-07-26", "영화 관람", 12.50);

            // 용돈 기입 정보를 출력하는 메서드 호출
            printMoneyEntries(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 연결 해제
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 용돈 기입 정보를 데이터베이스에 추가하는 메서드
    private static void addMoneyEntry(Connection conn, String date, String description, double amount) throws SQLException {
        String sql = "INSERT INTO money_tracker (date, description, amount) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, date);
            stmt.setString(2, description);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();
        }
    }

    // 용돈 기입 정보를 데이터베이스에서 조회하여 출력하는 메서드
    private static void printMoneyEntries(Connection conn) throws SQLException {
        String sql = "SELECT * FROM money_tracker";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            // 결과 출력
            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("date");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");

                System.out.println("ID: " + id + ", Date: " + date + ", Description: " + description + ", Amount: " + amount);
            }
        }
    }
}
