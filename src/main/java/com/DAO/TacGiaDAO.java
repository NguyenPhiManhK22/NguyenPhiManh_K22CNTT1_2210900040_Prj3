package com.DAO;



import java.sql.*;
import java.util.*;
import com.library.models.TacGia;
import com.library.utils.DatabaseConnection;

public class TacGiaDAO {

    // Lấy tất cả tác giả
    public List<TacGia> getAllTacGia() {
        List<TacGia> tacGias = new ArrayList<>();
        String query = "SELECT * FROM TacGia";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TacGia tacGia = new TacGia(
                    rs.getInt("MaTacGia"),
                    rs.getString("TenTacGia"),
                    rs.getInt("NamSinh"),
                    rs.getString("QuocGia"),
                    rs.getString("AnhTacGia")
                );
                tacGias.add(tacGia);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching authors: " + e.getMessage());
            e.printStackTrace();
        }
        return tacGias;
    }

    // Tìm tác giả theo mã
    public TacGia getTacGiaById(int maTacGia) {
        TacGia tacGia = null;
        String query = "SELECT * FROM TacGia WHERE MaTacGia = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maTacGia);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tacGia = new TacGia(
                    rs.getInt("MaTacGia"),
                    rs.getString("TenTacGia"),
                    rs.getInt("NamSinh"),
                    rs.getString("QuocGia"),
                    rs.getString("AnhTacGia")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error fetching author by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return tacGia;
    }
}
