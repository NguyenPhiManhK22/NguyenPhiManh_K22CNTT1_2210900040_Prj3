package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.DAO.BookDAO;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/deleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public DeleteBookServlet() {
        super();
    }

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSach = Integer.parseInt(request.getParameter("MaSach"));

        // Xóa sách khỏi CSDL
        bookDAO.deleteBook(maSach);

        // Chuyển hướng đến trang danh sách sách
        response.sendRedirect("views/bookListServlet");
    }
}

