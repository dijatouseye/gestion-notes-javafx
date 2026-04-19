package gestion.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
///parti fatima ly
    private static final String url = "jdbc:mysql://localhost:3306/gestion_notes?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}