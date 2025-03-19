package com.DAO;

import java.sql.*;
import java.util.*;

import com.library.models.Sach;
import com.library.utils.DatabaseConnection;

public class BookDAO {
    

    // Thêm sách mới
    public boolean addBook(Sach sach) {
        String query = "INSERT INTO Sach (TieuDe, MaTacGia, MaTheLoai, ISBN, NamXuatBan, SoLuong, AnhBia) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (	Connection conn = DatabaseConnection.getConnection();
        		PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sach.getTieuDe());
            stmt.setInt(2, sach.getMaTacGia());
            stmt.setInt(3, sach.getMaTheLoai());
            stmt.setString(4, sach.getISBN());
            stmt.setInt(5, sach.getNamXuatBan());
            stmt.setInt(6, sach.getSoLuong());
            stmt.setString(7, sach.getAnhBia());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Sửa sách
    public boolean updateBook(Sach sach) {
        String query = "UPDATE Sach SET TieuDe = ?, MaTacGia = ?, MaTheLoai = ?, ISBN = ?, NamXuatBan = ?, SoLuong = ?, AnhBia = ? WHERE MaSach = ?";
        try (Connection conn = DatabaseConnection.getConnection();
        		PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sach.getTieuDe());
            stmt.setInt(2, sach.getMaTacGia());
            stmt.setInt(3, sach.getMaTheLoai());
            stmt.setString(4, sach.getISBN());
            stmt.setInt(5, sach.getNamXuatBan());
            stmt.setInt(6, sach.getSoLuong());
            stmt.setString(7, sach.getAnhBia());
            stmt.setInt(8, sach.getMaSach());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa sách
    public boolean deleteBook(int maSach) {
        String query = "DELETE FROM Sach WHERE MaSach = ?";
        try (Connection conn = DatabaseConnection.getConnection();
        		PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSach);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách sách
    public List<Sach> getAllBooks() {
        List<Sach> books = new ArrayList<>();
        String query = "SELECT * FROM Sach";  // Truy vấn lấy tất cả sách
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Sach sach = new Sach(
                    rs.getInt("MaSach"),
                    rs.getString("TieuDe"),
                    rs.getInt("MaTacGia"),
                    rs.getInt("MaTheLoai"),
                    rs.getString("ISBN"),
                    rs.getInt("NamXuatBan"),
                    rs.getInt("SoLuong"),
                    rs.getString("AnhBia")
                );
                books.add(sach);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching books: " + e.getMessage());
            e.printStackTrace();
        }
        return books;
    }


    // Tìm sách theo mã
    public Sach getBookById(int maSach) {
        Sach sach = null;
        String query = "SELECT * FROM Sach WHERE MaSach = ?";
        try (Connection conn = DatabaseConnection.getConnection();
        		PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSach);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                sach = new Sach(
                    rs.getInt("MaSach"),
                    rs.getString("TieuDe"),
                    rs.getInt("MaTacGia"),
                    rs.getInt("MaTheLoai"),
                    rs.getString("ISBN"),
                    rs.getInt("NamXuatBan"),
                    rs.getInt("SoLuong"),
                    rs.getString("AnhBia")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sach;
    }
}
