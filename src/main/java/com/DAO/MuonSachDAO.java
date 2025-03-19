package com.DAO;

import com.library.models.MuonSach;
import com.library.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MuonSachDAO {

    // Thêm một phiếu mượn sách mới
    public boolean addMuonSach(MuonSach muonSach) {
        String query = "INSERT INTO MuonSach (MaNguoiDung, MaSach, HanTra, TrangThai) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, muonSach.getMaNguoiDung());
            stmt.setInt(2, muonSach.getMaSach());
            stmt.setDate(3, new java.sql.Date(muonSach.getHanTra().getTime()));
            stmt.setString(4, muonSach.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy tất cả phiếu mượn sách
    public List<MuonSach> getAllMuonSach() {
        List<MuonSach> muonSachs = new ArrayList<>();
        String query = "SELECT * FROM MuonSach";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MuonSach muonSach = new MuonSach(
                        rs.getInt("MaMuonSach"),
                        rs.getInt("MaNguoiDung"),
                        rs.getInt("MaSach"),
                        rs.getTimestamp("NgayMuon"),
                        rs.getDate("HanTra"),
                        rs.getDate("NgayTra"),
                        rs.getString("TrangThai")
                );
                muonSachs.add(muonSach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return muonSachs;
    }
    
    // Cập nhật phiếu mượn khi trả sách
    public boolean updateMuonSach(MuonSach muonSach) {
        String query = "UPDATE MuonSach SET NgayTra = ?, TrangThai = 'DaTra' WHERE MaMuonSach = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(muonSach.getNgayTra().getTime()));
            stmt.setInt(2, muonSach.getMaMuonSach());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
