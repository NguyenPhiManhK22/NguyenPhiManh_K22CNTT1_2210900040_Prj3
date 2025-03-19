package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.DAO.BookDAO;
import com.library.models.Sach;

/**
 * Servlet implementation class BookServlet
 */

@WebServlet("/bookListServlet")
public class BookListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public BookListServlet() {
        super();
    }

    public void init() {
        bookDAO = new BookDAO();
    }

    // Hiển thị danh sách sách
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sach> books = bookDAO.getAllBooks();
        request.setAttribute("books", books); // Đảm bảo gán sách vào request
        request.getRequestDispatcher("views/BookList.jsp").forward(request, response); // Forward đến JSP
    }
}
