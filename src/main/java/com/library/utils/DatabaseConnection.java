package com.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/quanlythuvien?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "160804";

    // Thử nạp driver JDBC (nếu cần)
    static {
        try {
            // Nạp driver (có thể không cần nếu dùng MySQL 8+ vì JDBC 4.0 tự động nạp)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL không tìm thấy.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            // Tạo kết nối đến MySQL
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
            throw e; // Ném lại ngoại lệ
        }
    }
}
