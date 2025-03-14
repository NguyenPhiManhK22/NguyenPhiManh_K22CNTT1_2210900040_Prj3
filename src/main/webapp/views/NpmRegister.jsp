<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Ký</title>
    <style>
        /* Định dạng chung cho trang */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Container cho form */
        .register-container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
        }

        /* Tiêu đề của form */
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Các trường nhập liệu */
        input[type="text"], input[type="email"], input[type="password"], select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* Nút đăng ký */
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Liên kết tới trang đăng nhập */
        .login-link {
            text-align: center;
            margin-top: 10px;
        }

        .login-link a {
            color: #4CAF50;
            text-decoration: none;
        }

        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <!-- Container chứa form đăng ký -->
    <div class="register-container">
        <h2>Đăng Ký Tài Khoản</h2>
        <!-- Form đăng ký -->
        <form action="NpmRegisterServlet" method="post">
            Họ và tên: <input type="text" name="name" required><br><br>
            Email: <input type="email" name="email" required><br><br>
            Mật khẩu: <input type="password" name="password" required><br><br>
            Vai trò: 
            <select name="role">
                <option value="ThanhVien">Thành viên</option>
                <option value="Admin">Quản trị viên</option>
            </select><br><br>
            <input type="submit" value="Đăng Ký">
        </form>
        <br>
        <!-- Liên kết tới trang đăng nhập -->
        <div class="login-link">
            <a href="views/NpmLogin.jsp">Đã có tài khoản? Đăng nhập ngay!</a>
        </div>
    </div>
</body>
</html>
