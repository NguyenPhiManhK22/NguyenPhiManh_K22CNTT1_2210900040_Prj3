package com.library.controllers;

import com.DAO.NguoiDungDAO;
import com.library.models.NguoiDung;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NguoiDungDAO nguoiDungDAO;

    public void init() {
        nguoiDungDAO = new NguoiDungDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen = request.getParameter("HoTen");
        String email = request.getParameter("Email");
        String matKhau = request.getParameter("MatKhau");
        String vaiTro = "ThanhVien"; // Mặc định là thành viên

        NguoiDung nguoiDung = new NguoiDung(0, hoTen, email, matKhau, vaiTro, null);
        boolean isRegistered = nguoiDungDAO.registerUser(nguoiDung);

        if (isRegistered) {
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().println("Lỗi đăng ký tài khoản.");
        }
    }
}
