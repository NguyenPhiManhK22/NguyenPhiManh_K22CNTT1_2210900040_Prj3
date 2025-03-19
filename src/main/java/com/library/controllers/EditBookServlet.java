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
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBookServlet")
public class EditBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public EditBookServlet() {
        super();
    }

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSach = Integer.parseInt(request.getParameter("MaSach"));

        // Lấy thông tin sách từ CSDL
        Sach sach = bookDAO.getBookById(maSach);

        // Gửi thông tin sách đến trang sửa sách
        request.setAttribute("sach", sach);
        request.getRequestDispatcher("views/editSach.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSach = Integer.parseInt(request.getParameter("MaSach"));
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

        // Cập nhật thông tin sách trong CSDL
        Sach sach = new Sach(maSach, tieuDe, maTacGia, maTheLoai, isbn, namXuatBan, soLuong, anhBia);
        bookDAO.updateBook(sach);

        // Chuyển hướng đến trang danh sách sách
        response.sendRedirect("views/bookListServlet");
    }
}
