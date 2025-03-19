<%@ page import="java.util.List" %>
<%@ page import="com.library.models.TienPhat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Tiền Phạt</title>
    <!-- Liên kết đến tệp CSS ngoài -->
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <h2>Danh Sách Tiền Phạt</h2>

    <%
        List<TienPhat> tienPhatList = (List<TienPhat>) request.getAttribute("tienPhatList");

        if (tienPhatList != null && !tienPhatList.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>Mã Tiền Phạt</th>
                <th>Mã Mượn Sách</th>
                <th>Số Tiền</th>
                <th>Đã Thanh Toán</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (TienPhat tienPhat : tienPhatList) {
            %>
            <tr>
                <td><%= tienPhat.getMaTienPhat() %></td>
                <td><%= tienPhat.getMaMuonSach() %></td>
                <td><%= tienPhat.getSoTien() %></td>
                <td><%= tienPhat.isDaThanhToan() ? "Đã Thanh Toán" : "Chưa Thanh Toán" %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <% } else { %>
        <p>Không có tiền phạt nào trong danh sách.</p>
    <% } %>

    <form action="tienPhatServlet" method="post">
        <h3>Thêm Tiền Phạt</h3>
        <label for="MaMuonSach">Mã Mượn Sách:</label>
        <input type="text" id="MaMuonSach" name="MaMuonSach" required><br><br>

        <label for="SoTien">Số Tiền:</label>
        <input type="text" id="SoTien" name="SoTien" required><br><br>

        <label for="DaThanhToan">Đã Thanh Toán:</label>
        <input type="checkbox" id="DaThanhToan" name="DaThanhToan"><br><br>

        <input type="submit" value="Thêm Tiền Phạt">
    </form>
</body>
</html>
