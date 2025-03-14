package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.library.utils.DatabaseConnection;

/**
 * Servlet implementation class NpmBorrowServlet
 */
@WebServlet("/borrow")
public class NpmBorrowServlet extends HttpServlet {

    // Mượn sách
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNguoiDung = Integer.parseInt(request.getParameter("maNguoiDung"));
        int maSach = Integer.parseInt(request.getParameter("maSach"));
        Date ngayMuon = Date.valueOf(request.getParameter("ngayMuon"));
        Date hanTra = Date.valueOf(request.getParameter("hanTra"));

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Borrow (MaNguoiDung, MaSach, NgayMuon, HanTra) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, maNguoiDung);
            stmt.setInt(2, maSach);
            stmt.setDate(3, ngayMuon);
            stmt.setDate(4, hanTra);
            stmt.executeUpdate();
            response.sendRedirect("views/BorrowList.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/error.jsp");
        }
    }

    // Trả sách
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maMuonSach = Integer.parseInt(request.getParameter("maMuonSach"));
        Date ngayTra = Date.valueOf(request.getParameter("ngayTra"));

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE Borrow SET NgayTra = ? WHERE MaMuonSach = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, ngayTra);
            stmt.setInt(2, maMuonSach);
            stmt.executeUpdate();
            response.sendRedirect("views/BorrowList.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/error.jsp");
        }
    }
}
