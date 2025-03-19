<%@ page import="java.util.List" %>
<%@ page import="com.DAO.BookDAO" %>
<%@ page import="com.library.models.Sach" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sách</title>
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <h2>Danh Sách Sách</h2>

    <%
        // Lấy danh sách sách từ request attribute
        List<Sach> books = (List<Sach>) request.getAttribute("books");

        if (books == null || books.isEmpty()) {
    %>
    <div class="no-data">Không có sách nào trong danh sách.</div>
    <%
        } else {
    %>
    <table>
        <thead>
            <tr>
                <th>Mã Sách</th>
                <th>Tiêu Đề</th>
                <th>Mã Tác Giả</th>
                <th>Mã Thể Loại</th>
                <th>ISBN</th>
                <th>Năm Xuất Bản</th>
                <th>Số Lượng</th>
                <th>Ảnh Bìa</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Duyệt qua danh sách sách và hiển thị mỗi sách trong bảng
                for (Sach sach : books) {
            %>
            <tr>
                <td><%= sach.getMaSach() %></td>
                <td><%= sach.getTieuDe() %></td>
                <td><%= sach.getMaTacGia() %></td>
                <td><%= sach.getMaTheLoai() %></td>
                <td><%= sach.getISBN() %></td>
                <td><%= sach.getNamXuatBan() %></td>
                <td><%= sach.getSoLuong() %></td>
                <td>
                    <% if (sach.getAnhBia() != null && !sach.getAnhBia().isEmpty()) { %>
                        <img src="<%= sach.getAnhBia() %>" alt="Ảnh Bìa" width="50">
                    <% } else { %>
                        Không có ảnh
                    <% } %>
                </td>
                <td class="action-links">
                    <a class="edit" href="editBookServlet?MaSach=<%= sach.getMaSach() %>">Sửa</a>
                    <a class="delete" href="deleteBookServlet?MaSach=<%= sach.getMaSach() %>" onclick="return confirm('Bạn có chắc chắn muốn xóa sách này không?');">Xóa</a>
                </td>
            </tr>
            <%
                }
            %>	
        </tbody>
    </table>
    <% } %>

    <a class="Add" href="AddBookServlet">Thêm mới</a> <br/>
    <br/>
    <a href="index.jsp">Về trang chủ </a>
</body>
</html>
