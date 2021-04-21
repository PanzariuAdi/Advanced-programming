package lab08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String username = "student";
    final static String password = "darabani";

    private DatabaseConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception in database connection " + e.getMessage());
        }
    }

    public Connection getConnection() { return connection; }

    public static DatabaseConnection getInstance() {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }
}
