<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Sách Mới</title>
    <!-- Liên kết đến tệp CSS ngoài -->
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <h2>Thêm Sách Mới</h2>

    <!-- Form thêm sách -->
    <div class="form-container">
        <form action="bookServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="action" value="add">

            <label for="TieuDe">Tiêu Đề Sách:</label>
            <input type="text" id="TieuDe" name="TieuDe" required>

            <label for="MaTacGia">Mã Tác Giả:</label>
            <input type="number" id="MaTacGia" name="MaTacGia" required>

            <label for="MaTheLoai">Mã Thể Loại:</label>
            <input type="number" id="MaTheLoai" name="MaTheLoai" required>

            <label for="ISBN">ISBN:</label>
            <input type="text" id="ISBN" name="ISBN" required>

            <label for="NamXuatBan">Năm Xuất Bản:</label>
            <input type="number" id="NamXuatBan" name="NamXuatBan" required>

            <label for="SoLuong">Số Lượng:</label>
            <input type="number" id="SoLuong" name="SoLuong" required>

            <label for="AnhBia">Ảnh Bìa:</label>
            <input type="file" id="AnhBia" name="AnhBia">

            <input type="submit" value="Thêm Sách">
        </form>
    </div>

    <br>
    <a href="BookList.jsp">Quay lại danh sách sách</a>
</body>
</html>
