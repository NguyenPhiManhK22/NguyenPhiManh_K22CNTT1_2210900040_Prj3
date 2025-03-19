package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.NguoiDungDAO;
import com.library.models.NguoiDung;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NguoiDungDAO nguoiDungDAO;

    public void init() {
        nguoiDungDAO = new NguoiDungDAO(); // Khởi tạo DAO
    }

    // Hiển thị trang đăng nhập khi sử dụng phương thức GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/login.jsp").forward(request, response); // Chuyển tiếp đến trang login.jsp
    }

    // Xử lý đăng nhập khi sử dụng phương thức POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String matKhau = request.getParameter("MatKhau");

        NguoiDung nguoiDung = nguoiDungDAO.loginUser(email, matKhau);

        if (nguoiDung != null) {
            HttpSession session = request.getSession();
            session.setAttribute("nguoiDung", nguoiDung);
            response.sendRedirect("views/index.jsp"); // Chuyển hướng đến trang chủ sau khi đăng nhập thành công
        } else {
            response.getWriter().println("Sai email hoặc mật khẩu.");
        }
    }
}
