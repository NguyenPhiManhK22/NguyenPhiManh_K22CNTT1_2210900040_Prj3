<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Sách Mới</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-size: 16px;
            color: #333;
            margin-bottom: 8px;
            display: block;
        }

        .form-group input[type="text"], .form-group input[type="number"], .form-group input[type="file"] {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .form-group input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            width: 100%;
        }

        .form-group input[type="submit"]:hover {
            background-color: #45a049;
        }

        .form-group input[type="file"] {
            padding: 6px;
        }

        .button-container {
            text-align: center;
        }

        .form-group input:focus {
            outline: none;
            border-color: #4CAF50;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Thêm Sách Mới</h2>
        <!-- Form có enctype="multipart/form-data" để tải tệp lên -->
        <form action="addBook" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Tên Sách:</label>
                <input type="text" id="title" name="title" required><br><br>
            </div>

            <div class="form-group">
                <label for="author">Tác Giả:</label>
                <input type="text" id="author" name="author" required><br><br>
            </div>

            <div class="form-group">
                <label for="year">Năm Xuất Bản:</label>
                <input type="number" id="year" name="year" required><br><br>
            </div>

            <div class="form-group">
                <label for="quantity">Số Lượng:</label>
                <input type="number" id="quantity" name="quantity" required><br><br>
            </div>

            <div class="form-group">
                <label for="coverImage">Ảnh Bìa:</label>
                <input type="file" id="coverImage" name="coverImage" accept="image/*" required><br><br>
            </div>

            <div class="form-group">
                <input type="submit" value="Thêm Sách">
            </div>
        </form>
    </div>

</body>
</html>
