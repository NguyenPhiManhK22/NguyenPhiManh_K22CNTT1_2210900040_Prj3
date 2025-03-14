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
import java.util.ArrayList;
import java.util.List;

import com.library.models.Book;
import com.library.utils.DatabaseConnection;

/**
 * Servlet implementation class NpmBookServlet
 */
@WebServlet("/book")
public class NpmBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> booksList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Sach";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Chuyển ResultSet thành List<Book>
            while (rs.next()) {
                int maSach = rs.getInt("MaSach");
                String tieuDe = rs.getString("TieuDe");
                int maTacGia = rs.getInt("MaTacGia");
                int namXuatBan = rs.getInt("NamXuatBan");
                int soLuong = rs.getInt("SoLuong");
                String anhBia = rs.getString("AnhBia");

                // Tạo đối tượng Book và thêm vào danh sách
                Book book = new Book(maSach, tieuDe, maTacGia, namXuatBan, soLuong, anhBia);
                booksList.add(book);
            }

            // Gửi danh sách sách tới JSP
            request.setAttribute("book", booksList);
            request.getRequestDispatcher("/views/BookList.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/error.jsp");
        }
    }
}
