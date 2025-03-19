package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.DAO.TienPhatDAO;
import com.library.models.TienPhat;

/**
 * Servlet implementation class TienPhatServlet
 */
@WebServlet("/tienPhatServlet")
public class TienPhatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TienPhatDAO tienPhatDAO;

    public TienPhatServlet() {
        super();
    }

    public void init() {
        tienPhatDAO = new TienPhatDAO(); // Khởi tạo DAO
    }

    // Hiển thị danh sách tiền phạt
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TienPhat> tienPhatList = tienPhatDAO.getAllTienPhat();
        request.setAttribute("tienPhatList", tienPhatList); // Gán dữ liệu vào request
        request.getRequestDispatcher("views/tienPhatList.jsp").forward(request, response); // Chuyển tiếp đến JSP
    }

    // Thêm tiền phạt mới
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maMuonSach = Integer.parseInt(request.getParameter("MaMuonSach"));
        double soTien = Double.parseDouble(request.getParameter("SoTien"));
        boolean daThanhToan = Boolean.parseBoolean(request.getParameter("DaThanhToan"));

        TienPhat tienPhat = new TienPhat(0, maMuonSach, soTien, daThanhToan);
        boolean isAdded = tienPhatDAO.addTienPhat(tienPhat);

        if (isAdded) {
            response.sendRedirect("tienPhatServlet"); // Quay lại danh sách tiền phạt
        } else {
            response.getWriter().println("Lỗi khi thêm tiền phạt.");
        }
    }
}
