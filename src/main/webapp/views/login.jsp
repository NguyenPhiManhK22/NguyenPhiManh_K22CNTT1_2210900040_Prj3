<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Nhập</title>
    <!-- Liên kết đến tệp CSS ngoài -->
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>

    <div class="form-container">
        <h2>Đăng Nhập</h2>
        <form action="loginServlet" method="post">
            <label for="Email">Email:</label>
            <input type="email" id="Email" name="Email" required><br><br>

            <label for="MatKhau">Mật khẩu:</label>
            <input type="password" id="MatKhau" name="MatKhau" required><br><br>

            <input type="submit" value="Đăng Nhập">
        </form>
        <a href="register.jsp" class="back-link">Chưa có tài khoản? Đăng ký ngay</a>
    </div>

</body>
</html>
