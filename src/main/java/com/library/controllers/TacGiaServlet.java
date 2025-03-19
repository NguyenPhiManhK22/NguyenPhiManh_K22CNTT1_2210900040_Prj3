package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TacGiaServlet
 */
import com.DAO.TacGiaDAO;
import com.library.models.TacGia;
import java.util.List;

@WebServlet("/tacGiaListServlet")
public class TacGiaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TacGiaDAO tacGiaDAO;

  

    public void init() {
        tacGiaDAO = new TacGiaDAO(); // Khởi tạo DAO
    }

    // Hiển thị danh sách tác giả
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TacGia> tacGias = tacGiaDAO.getAllTacGia(); // Lấy tất cả tác giả
        request.setAttribute("tacGias", tacGias); // Gửi danh sách đến JSP
        request.getRequestDispatcher("views/tacGiaList.jsp").forward(request, response); // Forward tới trang JSP
    }
}

