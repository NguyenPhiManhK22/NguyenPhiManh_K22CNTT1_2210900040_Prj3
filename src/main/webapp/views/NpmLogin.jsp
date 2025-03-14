<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Nhập</title>
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
        .login-container {
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
        input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* Nút đăng nhập */
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

        /* Liên kết đăng ký */
        .register-link {
            text-align: center;
            margin-top: 10px;
        }

        .register-link a {
            color: #4CAF50;
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <!-- Container chứa form đăng nhập -->
    <div class="login-container">
        <h2>Đăng Nhập</h2>
        <!-- Form đăng nhập -->
        <form action="login" method="post">
            Email: <input type="email" name="email" required><br><br>
            Mật khẩu: <input type="password" name="password" required><br><br>
            <input type="submit" value="Đăng Nhập">
        </form>
        <br>
        <!-- Liên kết tới trang đăng ký -->
        <div class="register-link">
            <a href="views/NpmRegister.jsp">Đăng ký tài khoản mới</a>
        </div>
    </div>
</body>
</html>
