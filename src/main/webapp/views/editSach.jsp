<%@ page import="com.library.models.Sach" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Thông Tin Sách</title>
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <h2>Sửa Thông Tin Sách</h2>

    <%
        // Lấy thông tin sách từ request
        Sach sach = (Sach) request.getAttribute("sach");
    %>

    <form action="editSachServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="MaSach" value="<%= sach.getMaSach() %>">

        <label for="TieuDe">Tiêu Đề:</label>
        <input type="text" id="TieuDe" name="TieuDe" value="<%= sach.getTieuDe() %>" required>

        <label for="MaTacGia">Mã Tác Giả:</label>
        <input type="number" id="MaTacGia" name="MaTacGia" value="<%= sach.getMaTacGia() %>" required>

        <label for="MaTheLoai">Mã Thể Loại:</label>
        <input type="number" id="MaTheLoai" name="MaTheLoai" value="<%= sach.getMaTheLoai() %>" required>

        <label for="ISBN">ISBN:</label>
        <input type="text" id="ISBN" name="ISBN" value="<%= sach.getISBN() %>" required>

        <label for="NamXuatBan">Năm Xuất Bản:</label>
        <input type="number" id="NamXuatBan" name="NamXuatBan" value="<%= sach.getNamXuatBan() %>" required>

        <label for="SoLuong">Số Lượng:</label>
        <input type="number" id="SoLuong" name="SoLuong" value="<%= sach.getSoLuong() %>" required>

        <label for="AnhBia">Ảnh Bìa:</label>
        <input type="file" id="AnhBia" name="AnhBia">

        <input type="submit" value="Cập Nhật Sách">
    </form>

    <br>
    <a href="bookListServlet">Quay lại danh sách sách</a>
</body>
</html>