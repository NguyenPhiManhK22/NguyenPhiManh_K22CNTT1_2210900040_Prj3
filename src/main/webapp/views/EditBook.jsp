<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Sửa Sách</title>
</head>
<body>
    <h2>Sửa Thông Tin Sách</h2>
    <form action="editBook" method="post">
        <input type="hidden" name="id" value="${book.getInt("MaSach")}">

        <label for="title">Tên Sách:</label>
        <input type="text" id="title" name="title" value="${book.getString("TieuDe")}" required><br>

        <label for="author">Tác Giả:</label>
        <input type="text" id="author" name="author" value="${book.getInt("MaTacGia")}" required><br>

        <label for="year">Năm Xuất Bản:</label>
        <input type="number" id="year" name="year" value="${book.getInt("NamXuatBan")}" required><br>

        <label for="quantity">Số Lượng:</label>
        <input type="number" id="quantity" name="quantity" value="${book.getInt("SoLuong")}" required><br>

        <label for="coverImage">Ảnh Bìa:</label>
        <input type="text" id="coverImage" name="coverImage" value="${book.getString("AnhBia")}" required><br>

        <input type="submit" value="Cập Nhật">
    </form>
</body>
</html>
