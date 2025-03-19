<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Ký</title>
    <!-- Liên kết đến tệp CSS ngoài -->
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>

    <div class="form-container">
        <h2>Đăng Ký</h2>
        <form action="registerServlet" method="post">
            <label for="HoTen">Họ Tên:</label>
            <input type="text" id="HoTen" name="HoTen" required><br><br>

            <label for="Email">Email:</label>
            <input type="email" id="Email" name="Email" required><br><br>

            <label for="MatKhau">Mật khẩu:</label>
            <input type="password" id="MatKhau" name="MatKhau" required><br><br>

            <input type="submit" value="Đăng Ký">
        </form>
        <a href="login.jsp" class="back-link">Đã có tài khoản? Đăng nhập ngay</a>
    </div>

</body>
</html>
