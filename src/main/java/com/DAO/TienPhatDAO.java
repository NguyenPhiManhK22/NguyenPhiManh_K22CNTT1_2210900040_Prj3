package com.DAO;

import com.library.models.TienPhat;
import com.library.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TienPhatDAO {

    // Thêm tiền phạt mới
    public boolean addTienPhat(TienPhat tienPhat) {
        String query = "INSERT INTO TienPhat (MaMuonSach, SoTien, DaThanhToan) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, tienPhat.getMaMuonSach());
            stmt.setDouble(2, tienPhat.getSoTien());
            stmt.setBoolean(3, tienPhat.isDaThanhToan());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy tất cả tiền phạt
    public List<TienPhat> getAllTienPhat() {
        List<TienPhat> tienPhatList = new ArrayList<>();
        String query = "SELECT * FROM TienPhat";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TienPhat tienPhat = new TienPhat(
                        rs.getInt("MaTienPhat"),
                        rs.getInt("MaMuonSach"),
                        rs.getDouble("SoTien"),
                        rs.getBoolean("DaThanhToan")
                );
                tienPhatList.add(tienPhat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tienPhatList;
    }
}
