package Project9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Money";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0000";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("데이터베이스 연결 성공!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("데이터베이스 연결 실패!");
            }
        }
        return connection;
    }
}