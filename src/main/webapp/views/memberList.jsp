<%@ page import="java.util.List" %>
<%@ page import="com.library.models.Member" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Thành Viên</title>
    <!-- Liên kết đến tệp CSS ngoài -->
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <h2>Danh Sách Thành Viên</h2>

    <%
        List<Member> memberList = (List<Member>) request.getAttribute("memberList");

        if (memberList != null && !memberList.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>Mã Thành Viên</th>
                <th>Họ Tên</th>
                <th>Email</th>
                <th>Vai Trò</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Member member : memberList) {
            %>
            <tr>
                <td><%= member.getMaNguoiDung() %></td>
                <td><%= member.getHoTen() %></td>
                <td><%= member.getEmail() %></td>
                <td><%= member.getVaiTro() %></td>
                <td class="action-links">
                    <a class="edit" href="editMember.jsp?MaNguoiDung=<%= member.getMaNguoiDung() %>">Sửa</a> |
                    <a class="delete" href="deleteMemberServlet?MaNguoiDung=<%= member.getMaNguoiDung() %>" onclick="return confirm('Bạn có chắc chắn muốn xóa thành viên này không?');">Xóa</a>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <% } else { %>
        <p class="no-data">Không có thành viên nào trong danh sách.</p>
    <% } %>

    <a href="addMember.jsp">Thêm Thành Viên Mới</a>
</body>
</html>
