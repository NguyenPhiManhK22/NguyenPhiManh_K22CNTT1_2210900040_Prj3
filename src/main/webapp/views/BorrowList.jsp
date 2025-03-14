
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Danh Sách Mượn Sách</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        img {
            width: 50px;
            height: 50px;
        }
        a {
            text-decoration: none;
            color: blue;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Danh Sách Mượn Sách</h2>
    <table>
        <thead>
            <tr>
                <th>Mã Mượn Sách</th>
                <th>Mã Thành Viên</th>
                <th>Mã Sách</th>
                <th>Ngày Mượn</th>
                <th>Hạn Trả</th>
                <th>Ngày Trả</th>
            </tr>
        </thead>
        <tbody>
            <!-- Lặp qua danh sách mượn sách -->
            <c:forEach var="borrow" items="${borrowList}">
                <tr>
                    <td>${borrow.maMuonSach}</td>
                    <td>${borrow.maNguoiDung}</td>
                    <td>${borrow.maSach}</td>
                    <td>${borrow.ngayMuon}</td>
                    <td>${borrow.hanTra}</td>
                    <td>
                        <!-- Kiểm tra nếu ngày trả là null -->
                        <c:choose>
                            <c:when test="${borrow.ngayTra != null}">
                                ${borrow.ngayTra}
                            </c:when>
                            <c:otherwise>
                                Chưa trả
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
