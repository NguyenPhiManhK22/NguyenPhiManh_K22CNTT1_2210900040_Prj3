<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Chủ - Quản Lý Thư Viện</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        
        /* Header */
        header {
            background-color: #4CAF50;
            padding: 20px;
            text-align: center;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        header h1 {
            margin: 0;
        }

        /* Header right buttons (Login/Signup) */
        .header-buttons {
            display: flex;
        }

        .header-buttons a {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            margin-left: 10px;
            border-radius: 5px;
        }

        .header-buttons a:hover {
            background-color: #45a049;
        }

        /* Navigation Bar */
        nav {
            background-color: #333;
            overflow: hidden;
        }

        nav a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }

        nav a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Main Content */
        .container {
            padding: 20px;
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        .button-container button:hover {
            background-color: #45a049;
        }

        h2 {
            color: #333;
        }

        .card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 20px 0;
            padding: 20px;
        }

        .card h3 {
            color: #4CAF50;
        }

        .card p {
            color: #555;
        }

        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <header>
        <div>
            <h1>Quản Lý Thư Viện</h1>
            <p>Chào mừng bạn đến với hệ thống quản lý thư viện</p>
        </div>
        <div class="header-buttons">
            <a href="NpmLogin.jsp">Đăng Nhập</a>
            <a href="NpmRegister.jsp">Đăng Ký</a>
        </div>
    </header>

    <!-- Navigation Bar -->
    <nav>
        <a href="index.jsp">Trang Chủ</a>
        <a href="BookList.jsp">Danh Sách Sách</a>
        <a href="AddBook.jsp">Thêm Sách</a>
        <a href="searchBook.jsp">Tìm Kiếm Sách</a>
    </nav>

    <!-- Main Content -->
    <div class="container">
        <h2>Trang Chủ</h2>

        <div class="card">
            <h3>Danh Sách Sách Mới Nhất</h3>
            <p>Đây là nơi hiển thị sách mới thêm vào hệ thống hoặc sách nổi bật.</p>
            <div class="button-container">
                <button onclick="window.location.href='BookList.jsp'">Xem Danh Sách Sách</button>
            </div>
        </div>

        <div class="card">
            <h3>Thêm Sách Mới</h3>
            <p>Thêm các sách mới vào hệ thống thư viện của bạn.</p>
            <div class="button-container">
                <button onclick="window.location.href='AddBook.jsp'">Thêm Sách</button>
            </div>
        </div>

        <div class="card">
            <h3>Thông Tin Hệ Thống</h3>
            <p>Hệ thống quản lý thư viện cho phép bạn dễ dàng quản lý sách, thêm mới, sửa đổi và xóa sách.</p>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 Quản Lý Thư Viện. Tất cả quyền được bảo lưu.</p>
    </footer>

</body>
</html>
