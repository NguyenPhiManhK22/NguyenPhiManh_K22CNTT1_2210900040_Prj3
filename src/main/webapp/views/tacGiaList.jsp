<%@ page import="java.util.List"%>
<%@ page import="com.DAO.TacGiaDAO"%>
<%@ page import="com.library.models.TacGia"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Tác Giả</title>
    <!-- Liên kết đến tệp CSS ngoài -->
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <h2>Danh Sách Tác Giả</h2>

    <%
        List<TacGia> tacGias = (List<TacGia>) request.getAttribute("tacGias");
    %>

    <table>
        <thead>
            <tr>
                <th>Mã Tác Giả</th>
                <th>Tên Tác Giả</th>
                <th>Năm Sinh</th>
                <th>Quốc Gia</th>
                <th>Ảnh Tác Giả</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (tacGias != null && !tacGias.isEmpty()) {
                    for (TacGia tacGia : tacGias) {
            %>
            <tr>
                <td><%= tacGia.getMaTacGia() %></td>
                <td><%= tacGia.getTenTacGia() %></td>
                <td><%= tacGia.getNamSinh() %></td>
                <td><%= tacGia.getQuocGia() %></td>
                <td>
                    <% if (tacGia.getAnhTacGia() != null && !tacGia.getAnhTacGia().isEmpty()) { %>
                        <img src="<%= tacGia.getAnhTacGia() %>" alt="Ảnh Tác Giả">
                    <% } else { %>
                        Không có ảnh
                    <% } %>
                </td>
                <td class="action-links">
                    <a class="edit" href="editTacGia.jsp?MaTacGia=<%= tacGia.getMaTacGia() %>">Sửa</a>
                    <a class="delete" href="deleteTacGiaServlet?MaTacGia=<%= tacGia.getMaTacGia() %>" onclick="return confirm('Bạn có chắc chắn muốn xóa tác giả này không?');">Xóa</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6" class="no-data">Không có tác giả nào trong danh sách.</td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <br>
    <a href="addTacGia.jsp">Thêm Tác Giả Mới</a>
</body>
</html>
