<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Tiền Phạt</title>
  	<link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>

    <h2>Thêm Tiền Phạt</h2>

    <div class="form-container">
        <form action="tienPhatServlet" method="post">
            <label for="MaMuonSach">Mã Mượn Sách:</label>
            <input type="text" id="MaMuonSach" name="MaMuonSach" required><br><br>

            <label for="SoTien">Số Tiền:</label>
            <input type="text" id="SoTien" name="SoTien" required><br><br>

            <label for="DaThanhToan">Đã Thanh Toán:</label>
            <input type="checkbox" id="DaThanhToan" name="DaThanhToan"><br><br>

            <input type="submit" value="Thêm Tiền Phạt">
        </form>
    </div>

    <a href="tienPhatList.jsp" class="back-link">Quay lại danh sách tiền phạt</a>

</body>
</html>
