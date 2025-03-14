package com.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	 private static final String URL = "jdbc:mysql://localhost:3306/nguyenphimanh_2210900040";  
	    private static final String USER = "root";  
	    private static final String PASSWORD = "160804"; 

	   
	    public static Connection getConnection() throws SQLException {
	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");
	           
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            throw new SQLException("Không thể kết nối tới cơ sở dữ liệu", e);
	        }
	    }
}
