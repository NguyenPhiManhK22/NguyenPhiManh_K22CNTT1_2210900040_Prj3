<%@ page import="java.util.List" %>
<%@ page import="com.DAO.BookDAO" %>
<%@ page import="com.library.models.Sach" %>
<%@ page import="com.library.models.NguoiDung" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Chủ - Quản Lý Thư Viện</title>
    <!-- Liên kết đến tệp CSS ngoài -->
    <link rel="stylesheet" type="text/css" href="../Css/style.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div>
            <h1>Quản Lý Thư Viện</h1>
            <p>Chào mừng bạn đến với hệ thống quản lý thư viện của Mạnh</p>
        </div>
        <% 
        // Kiểm tra session để xem người dùng đã đăng nhập hay chưa
        NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");
        if (nguoiDung == null) {
    %>
        <div class="buttons">
            <a href="login.jsp"><button class="button">Đăng Nhập</button></a>
            <a href="register.jsp"><button class="button">Đăng Ký</button></a>
        </div>
    <% 
        } else {
    %>
        <div>
            <p>Xin chào, <%= nguoiDung.getHoTen() %>!</p>
            <a href="logoutServlet"><button class="button">Đăng Xuất</button></a>
        </div>
    <% 
        }
    %>
    </header>

    <!-- Navigation Bar -->
    <nav>
        <a href="index.jsp">Trang Chủ</a>
        <a href="BookList.jsp">Xem Danh Sách Sách</a>       
        <a href="addBook.jsp">Thêm Sách</a>
        <a href="BorrowList.jsp">Quản Lý Sách Mượn </a>
        <a href="tacGiaList.jsp">Quản lý Tác Giả</a>
        <a href="memberList.jsp">Quản Lý Thành Viên </a>
        <a href="tienPhatList.jsp">Quản Lý Tiền Phạt </a>
    </nav>

    <!-- Main Content -->
    <div class="container">
        <h2>Trang Chủ</h2>

        <div class="card">
            <h3>Danh Sách Sách Mới Nhất</h3>
            <p>Đây là nơi hiển thị sách mới thêm vào hệ thống hoặc sách nổi bật.</p>
            
            <%
                // Lấy danh sách sách từ BookDAO
                BookDAO bookDAO = new BookDAO();
                List<Sach> books = bookDAO.getAllBooks();

                if (books != null && !books.isEmpty()) {
            %>
            <% } else { %>
                <p>Không có sách nào trong danh sách.</p>
            <% } %>

            <div class="button-container">
                <button onclick="window.location.href='BookList.jsp'">Xem Danh Sách Sách</button>
            </div>
        </div>

        <div class="card">
            <h3>Thêm Sách Mới</h3>
            <p>Thêm các sách mới vào hệ thống thư viện của bạn.</p>
            <div class="button-container">
                <button onclick="window.location.href='addBook.jsp'">Thêm Sách</button>
            </div>
        </div>
        <div class="card">
            <h3>Kiểm Tra Sách</h3>
            <p>Kiểm tra các phiếu phạt hiện tại của bạn.</p>
            <div class="button-container">
                <button onclick="window.location.href='BorrowList.jsp'">Xem Danh Sách</button>
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
