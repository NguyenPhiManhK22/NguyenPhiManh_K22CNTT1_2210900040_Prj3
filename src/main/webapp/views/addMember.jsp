<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Thành Viên</title>
   	<link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <h2>Thêm Thành Viên Mới</h2>
    
    <!-- Form Thêm Thành Viên -->
    <form action="AddMemberServlet" method="post">
        <label for="hoTen">Họ Tên:</label>
        <input type="text" id="hoTen" name="hoTen" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="matKhau">Mật Khẩu:</label>
        <input type="password" id="matKhau" name="matKhau" required><br><br>

        <label for="vaiTro">Vai Trò:</label>
        <select id="vaiTro" name="vaiTro">
            <option value="ThanhVien">Thành Viên</option>
            <option value="Admin">Admin</option>
        </select><br><br>

        <input type="submit" value="Thêm Thành Viên">
    </form>
</body>
</html>
