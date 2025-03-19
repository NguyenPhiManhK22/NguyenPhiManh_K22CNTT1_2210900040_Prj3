package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.DAO.BookDAO;
import com.library.models.Sach;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public AddBookServlet() {
        super();
    }

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng đến trang thêm sách
        request.getRequestDispatcher("views/addBook.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String tieuDe = request.getParameter("TieuDe");
        int maTacGia = Integer.parseInt(request.getParameter("MaTacGia"));
        int maTheLoai = Integer.parseInt(request.getParameter("MaTheLoai"));
        String isbn = request.getParameter("ISBN");
        int namXuatBan = Integer.parseInt(request.getParameter("NamXuatBan"));
        int soLuong = Integer.parseInt(request.getParameter("SoLuong"));
        String anhBia = request.getParameter("AnhBia");

        // Xử lý ảnh bìa
        if (request.getPart("AnhBia") != null) {
            Part filePart = request.getPart("AnhBia");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads" + File.separator + fileName;
            filePart.write(uploadPath);
            anhBia = "uploads/" + fileName;  // Lưu đường dẫn ảnh
        }

        // Thêm sách vào CSDL
        Sach sach = new Sach(0, tieuDe, maTacGia, maTheLoai, isbn, namXuatBan, soLuong, anhBia);
        bookDAO.addBook(sach);

        // Chuyển hướng đến trang danh sách sách
        response.sendRedirect("views/bookListServlet");
    }
}

