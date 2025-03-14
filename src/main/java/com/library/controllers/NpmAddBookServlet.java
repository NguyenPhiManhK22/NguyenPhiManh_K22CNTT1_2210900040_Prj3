package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.library.models.Book;
import com.library.utils.DatabaseConnection;

/**
 * Servlet implementation class NpmAddBookServlet
 */
@WebServlet("/addBook")
public class NpmAddBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int year = Integer.parseInt(request.getParameter("year"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Xử lý tải ảnh lên
        Part filePart = request.getPart("coverImage");
        String fileName = filePart.getSubmittedFileName();

        // Lưu ảnh vào thư mục images
        String uploadPath = getServletContext().getRealPath("") + "images" + File.separator + fileName;
        File file = new File(uploadPath);
        try (InputStream inputStream = filePart.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Sach (TieuDe, MaTacGia, NamXuatBan, SoLuong, AnhBia) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, author);  
            stmt.setInt(3, year);
            stmt.setInt(4, quantity);
            stmt.setString(5, fileName);  
            stmt.executeUpdate();

            response.sendRedirect("book?action=view");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/error.jsp");
        }
    }
}


