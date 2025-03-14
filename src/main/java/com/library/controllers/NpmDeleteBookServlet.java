package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.library.utils.DatabaseConnection;

/**
 * Servlet implementation class NpmDeleteBookServlet
 */
@WebServlet("/deleteBook")
public class NpmDeleteBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Sach WHERE MaSach = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, bookId);
            stmt.executeUpdate();
            
            response.sendRedirect("book?action=view");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/error.jsp");
        }
    }
}

