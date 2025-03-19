package com.library.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.DAO.MemberDAO;
import com.library.models.Member;

/**
 * Servlet implementation class AddMemberServlet
 */
@WebServlet("/AddMemberServlet")
public class AddMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberDAO memberDAO;

    public AddMemberServlet() {
        super();
    }

    public void init() {
        memberDAO = new MemberDAO();  // Khởi tạo DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward tới trang thêm thành viên (addMember.jsp)
        request.getRequestDispatcher("views/addMember.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String hoTen = request.getParameter("HoTen");
        String email = request.getParameter("Email");
        String matKhau = request.getParameter("MatKhau");
        String vaiTro = request.getParameter("VaiTro");

        // Tạo đối tượng Member
        Member newMember = new Member();
        newMember.setHoTen(hoTen);
        newMember.setEmail(email);
        newMember.setMatKhau(matKhau);
        newMember.setVaiTro(vaiTro);

        // Thêm thành viên vào cơ sở dữ liệu
        boolean isAdded = memberDAO.addMember(newMember);

        if (isAdded) {
            // Chuyển hướng về trang danh sách thành viên nếu thêm thành công
            response.sendRedirect("views/memberList.jsp");
        } else {
            // Gửi thông báo lỗi nếu không thành công
            request.setAttribute("message", "Không thể thêm thành viên!");
            request.getRequestDispatcher("views/addMember.jsp").forward(request, response);
        }
    }
}
