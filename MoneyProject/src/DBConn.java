
package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    private static Connection dbConn;

    public static Connection getConnection() {

        if (dbConn == null) {
            try {
                // MySQL JDBC URL에 맞게 수정
                String url = "jdbc:mysql://localhost:3306/project";
                String user = "root"; // MySQL 계정 사용자명
                String password = "0000"; // MySQL 계정 비밀번호

                dbConn = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return dbConn;
    }

    public static void close() {

        if (dbConn != null) {
            try {
                if (!dbConn.isClosed()) {
                    dbConn.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        dbConn = null;
    }
}
