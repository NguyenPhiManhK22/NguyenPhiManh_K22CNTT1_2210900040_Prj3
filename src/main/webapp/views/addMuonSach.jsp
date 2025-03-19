<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Phiếu Mượn Sách</title>
    <!-- Liên kết đến tệp CSS ngoài -->
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>

    <!-- Header -->
    <header>
        <h1>Quản Lý Thư Viện</h1>
    </header>

    <!-- Form Container -->
    <div class="form-container">
        <h2>Thêm Phiếu Mượn Sách</h2>

        <form action="muonSachServlet" method="post">
            <label for="MaNguoiDung">Mã Người Dùng:</label>
            <input type="text" id="MaNguoiDung" name="MaNguoiDung" required><br><br>

            <label for="MaSach">Mã Sách:</label>
            <input type="text" id="MaSach" name="MaSach" required><br><br>

            <label for="HanTra">Hạn Trả:</label>
            <input type="date" id="HanTra" name="HanTra" required><br><br>

            <input type="submit" value="Thêm Phiếu Mượn">
        </form>

        <a href="muonSachServlet" class="back-link">Quay lại danh sách phiếu mượn</a>
    </div>

</body>
</html>
