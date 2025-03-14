<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Danh Sách Sách</title>
    <!-- Thêm FontAwesome CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        /* Cấu hình chung cho trang */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4; /* Màu nền trắng nhẹ */
            margin: 0;
            padding: 0;
        }

        /* Tiêu đề */
        h2 {
            text-align: center;
            color: #333; /* Màu đen cho tiêu đề */
            margin-top: 20px;
        }

        /* Container chứa bảng */
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        /* Thêm Sách Mới */
        .button-container {
            text-align: center;
            margin-bottom: 20px;
        }

        .button-container button {
            background-color: #4CAF50; /* Xanh lá cây */
            color: white;
            font-size: 16px;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .button-container button:hover {
            background-color: #45a049; /* Màu xanh lá cây đậm khi hover */
        }

        /* Cấu hình bảng */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd; /* Viền bảng màu xám nhạt */
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #4CAF50; /* Xanh lá cây cho tiêu đề bảng */
            color: white; /* Chữ trắng */
        }

        td {
            background-color: #ffffff; /* Nền trắng cho các ô dữ liệu */
        }

        /* Cải thiện hình ảnh */
        img {
            width: 50px;
            height: 50px;
            object-fit: cover;
            border-radius: 4px;
        }

        /* Liên kết */
        a {
            text-decoration: none;
            color: #4CAF50; /* Xanh lá cây */
            padding: 5px 10px;
            border-radius: 5px;
            background-color: #f2f2f2; /* Màu nền xám nhạt cho liên kết */
        }

        a:hover {
            background-color: #ddd; /* Màu nền xám nhạt khi hover */
        }

        /* Sửa/Xóa với biểu tượng FontAwesome */
        td a {
            display: inline-block;
            margin: 5px;
            font-size: 18px;
            padding: 5px 10px;
            border-radius: 5px;
            transition: all 0.3s ease-in-out;
        }

        td a.edit {
            color: #2196F3; /* Màu xanh dương cho sửa */
        }

        td a.delete {
            color: #f44336; /* Màu đỏ cho xóa */
        }

        td a:hover {
            background-color: #ddd;
            color: #333; /* Màu đen khi hover */
        }

        /* Hover hiệu ứng trên bảng */
        tr:hover {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Danh Sách Sách</h2>

        <div class="button-container">
            <a href="AddBook.jsp">
                <button>Thêm Sách Mới</button>
            </a>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Mã Sách</th>
                    <th>Tên Sách</th>
                    <th>Tác Giả</th>
                    <th>Ngày Xuất Bản</th>
                    <th>Số Lượng</th>
                    <th>Hình Ảnh</th>
                    <th>Thao Tác</th>
                </tr>
            </thead>
            <tbody>
                <!-- Lặp qua danh sách sách -->
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.maSach}</td>
                        <td>${book.tieuDe}</td>
                        <td>${book.maTacGia}</td>
                        <td>${book.namXuatBan}</td>
                        <td>${book.soLuong}</td>
                        <td><img src="images/${book.anhBia}" alt="Ảnh bìa sách"></td>
                        <td>
                            <!-- Biểu tượng Sửa -->
                            <a href="editBook?id=${book.maSach}" class="edit"><i class="fas fa-edit"></i> Sửa</a>
                            |
                            <!-- Biểu tượng Xóa -->
                            <a href="deleteBook?id=${book.maSach}" onclick="return confirm('Bạn có chắc chắn muốn xóa sách này?')" class="delete"><i class="fas fa-trash-alt"></i> Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
