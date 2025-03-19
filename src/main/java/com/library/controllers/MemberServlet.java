package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.DAO.MemberDAO;
import com.library.models.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/memberServlet")
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberDAO memberDAO;

    public void init() {
        memberDAO = new MemberDAO(); // Khởi tạo DAO
    }

    // Hiển thị tất cả thành viên
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> memberList = memberDAO.getAllMembers();
        request.setAttribute("memberList", memberList); // Gán dữ liệu vào request
        request.getRequestDispatcher("views/memberList.jsp").forward(request, response); // Chuyển tiếp đến JSP
    }

    // Thêm thành viên mới
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen = request.getParameter("HoTen");
        String email = request.getParameter("Email");
        String matKhau = request.getParameter("MatKhau");
        String vaiTro = "ThanhVien"; // Mặc định là thành viên

        Member member = new Member(0, hoTen, email, matKhau, vaiTro, null);
        boolean isAdded = memberDAO.addMember(member);

        if (isAdded) {
            response.sendRedirect("memberServlet"); // Quay lại danh sách thành viên
        } else {
            response.getWriter().println("Lỗi khi thêm thành viên.");
        }
    }
}
