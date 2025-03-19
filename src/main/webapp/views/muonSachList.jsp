<%@ page import="java.util.List" %>
<%@ page import="com.library.models.MuonSach" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Phiếu Mượn Sách</title>
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <h2>Danh Sách Phiếu Mượn Sách</h2>

    <%
        // Lấy danh sách phiếu mượn từ request attribute
        List<MuonSach> muonSachs = (List<MuonSach>) request.getAttribute("muonSachs");

        if (muonSachs != null && !muonSachs.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>Mã Phiếu Mượn</th>
                <th>Mã Người Dùng</th>
                <th>Mã Sách</th>
                <th>Ngày Mượn</th>
                <th>Hạn Trả</th>
                <th>Ngày Trả</th>
                <th>Trạng Thái</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Duyệt qua danh sách phiếu mượn và hiển thị trong bảng
                for (MuonSach muonSach : muonSachs) {
            %>
            <tr>
                <td><%= muonSach.getMaMuonSach() %></td>
                <td><%= muonSach.getMaNguoiDung() %></td>
                <td><%= muonSach.getMaSach() %></td>
                <td><%= muonSach.getNgayMuon() %></td>
                <td><%= muonSach.getHanTra() %></td>
                <td><%= muonSach.getNgayTra() != null ? muonSach.getNgayTra() : "Chưa trả" %></td>
                <td><%= muonSach.getTrangThai() %></td>
                <td>
                    <!-- Thêm sửa và xóa -->
                    <a class="edit" href="editMuonSach.jsp?MaMuonSach=<%= muonSach.getMaMuonSach() %>">Sửa</a> |
                    <a class="delete" href="deleteMuonSachServlet?MaMuonSach=<%= muonSach.getMaMuonSach() %>" onclick="return confirm('Bạn có chắc chắn muốn xóa phiếu mượn này không?');">Xóa</a>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <% } else { %>
    <p class="no-data">Không có phiếu mượn nào trong danh sách.</p>
    <% } %>

    <a href="addMuonSach.jsp">Thêm Phiếu Mượn Mới</a>
</body>
</html>
