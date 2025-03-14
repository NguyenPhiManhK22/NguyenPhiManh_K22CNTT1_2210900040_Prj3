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


@WebServlet("/Register")
public class NpmRegisterServlet extends HttpServlet {

    // Xử lý yêu cầu GET (Khi trang đăng ký được tải)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chỉ cần chuyển tiếp tới trang NpmRegister.jsp
        request.getRequestDispatcher("views/NpmRegister.jsp").forward(request, response);
    }

    // Xử lý yêu cầu POST (Khi người dùng gửi form đăng ký)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO NguoiDung (HoTen, Email, MatKhau, VaiTro) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, password);  
                stmt.setString(4, role);
                stmt.executeUpdate();
                response.sendRedirect("views/NpmLogin.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
