package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.DAO.MuonSachDAO;
import com.library.models.MuonSach;

/**
 * Servlet implementation class MuonSachServlet
 */
@WebServlet("/muonSachServlet")
public class MuonSachServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MuonSachDAO muonSachDAO;

    public MuonSachServlet() {
        super();
    }

    public void init() {
        muonSachDAO = new MuonSachDAO(); // Khởi tạo DAO
    }

    // Hiển thị danh sách phiếu mượn sách
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MuonSach> muonSachs = muonSachDAO.getAllMuonSach(); // Lấy tất cả phiếu mượn sách
        request.setAttribute("muonSachs", muonSachs); // Gán dữ liệu vào request
        request.getRequestDispatcher("views/muonSachList.jsp").forward(request, response); // Chuyển tiếp đến JSP
    }

    // Thêm phiếu mượn sách
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNguoiDung = Integer.parseInt(request.getParameter("MaNguoiDung"));
        int maSach = Integer.parseInt(request.getParameter("MaSach"));
        String hanTraStr = request.getParameter("HanTra");
        String trangThai = "DangMuon"; // Trạng thái ban đầu là Đang mượn

        // Chuyển đổi chuỗi ngày thành Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date hanTraDate = null;
        try {
            hanTraDate = sdf.parse(hanTraStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        MuonSach muonSach = new MuonSach(0, maNguoiDung, maSach, new java.util.Date(), hanTraDate, null, trangThai);
        boolean isAdded = muonSachDAO.addMuonSach(muonSach);

        if (isAdded) {
            response.sendRedirect("muonSachServlet"); // Quay lại danh sách phiếu mượn
        } else {
            response.getWriter().println("Lỗi khi thêm phiếu mượn sách.");
        }
    }
}