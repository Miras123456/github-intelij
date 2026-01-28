package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5433/gym_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to DB ✅");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed ❌");
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
