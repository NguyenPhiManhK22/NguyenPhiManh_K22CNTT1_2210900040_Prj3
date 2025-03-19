package com.DAO;

import com.library.models.NguoiDung;
import com.library.utils.DatabaseConnection;

import java.sql.*;

public class NguoiDungDAO {

    // Đăng ký người dùng mới
    public boolean registerUser(NguoiDung nguoiDung) {
        String query = "INSERT INTO NguoiDung (HoTen, Email, MatKhau, VaiTro) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nguoiDung.getHoTen());
            stmt.setString(2, nguoiDung.getEmail());
            stmt.setString(3, nguoiDung.getMatKhau()); // Cần mã hóa mật khẩu
            stmt.setString(4, nguoiDung.getVaiTro());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Đăng nhập người dùng
    public NguoiDung loginUser(String email, String matKhau) {
        String query = "SELECT * FROM NguoiDung WHERE Email = ? AND MatKhau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new NguoiDung(
                        rs.getInt("MaNguoiDung"),
                        rs.getString("HoTen"),
                        rs.getString("Email"),
                        rs.getString("MatKhau"),
                        rs.getString("VaiTro"),
                        rs.getTimestamp("NgayTao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
