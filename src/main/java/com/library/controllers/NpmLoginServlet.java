package com.library.controllers;

import com.library.utils.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;	

@WebServlet("/Login")
public class NpmLoginServlet extends HttpServlet { 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        request.getRequestDispatcher("views/NpmLogin.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM NguoiDung WHERE Email = ? AND MatKhau = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, email);
                stmt.setString(2, password);  

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("VaiTro");
                    if (role.equals("Admin")) {
                        response.sendRedirect("adminHome.jsp");
                    } else {
                        response.sendRedirect("memberHome.jsp");
                    }
                } else {
                    response.sendRedirect("views/NpmLogin.jsp?error=true");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/NpmLogin.jsp?error=true");
        }
    }
}
