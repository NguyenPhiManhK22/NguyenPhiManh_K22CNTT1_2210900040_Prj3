package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.library.utils.DatabaseConnection;

/**
 * Servlet implementation class NpmEditBookServlet
 */
@WebServlet("/editBook")
public class NpmEditBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Sach WHERE MaSach = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Set data to request
                request.setAttribute("book", rs);
                request.getRequestDispatcher("/views/EditBook.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author"); 
        int year = Integer.parseInt(request.getParameter("year"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String coverImage = request.getParameter("coverImage");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE Sach SET TieuDe = ?, MaTacGia = ?, NamXuatBan = ?, SoLuong = ?, AnhBia = ? WHERE MaSach = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, title);
            stmt.setInt(2, Integer.parseInt(author)); 
            stmt.setInt(3, year);
            stmt.setInt(4, quantity);
            stmt.setString(5, coverImage);
            stmt.setInt(6, bookId);
            stmt.executeUpdate();
            
            response.sendRedirect("book?action=view");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/error.jsp");
        }
    }
}
