package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    private static final String URL = "jdbc:mysql://localhost:3306/courier_management";
    private static final String USER = "root";
    private static final String PASSWORD = "bilal123";

    // Private constructor prevents instantiation from other classes
    private DatabaseConnection() { }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Ensure the driver class is available
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish connection to the database
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Connection to database failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
