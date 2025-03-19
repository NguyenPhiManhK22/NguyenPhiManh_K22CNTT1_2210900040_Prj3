package com.DAO;

import com.library.models.Member;
import com.library.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    // Thêm thành viên mới
    public boolean addMember(Member member) {
        String query = "INSERT INTO NguoiDung (HoTen, Email, MatKhau, VaiTro) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, member.getHoTen());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getMatKhau()); // Cần mã hóa mật khẩu
            stmt.setString(4, member.getVaiTro());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy tất cả thành viên
    public List<Member> getAllMembers() {
        List<Member> memberList = new ArrayList<>();
        String query = "SELECT * FROM NguoiDung";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Member member = new Member(
                        rs.getInt("MaNguoiDung"),
                        rs.getString("HoTen"),
                        rs.getString("Email"),
                        rs.getString("MatKhau"),
                        rs.getString("VaiTro"),
                        rs.getTimestamp("NgayTao")
                );
                memberList.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }

    // Lấy thành viên theo email
    public Member getMemberByEmail(String email) {
        Member member = null;
        String query = "SELECT * FROM NguoiDung WHERE Email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                member = new Member(
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
        return member;
    }

    // Cập nhật thông tin thành viên
    public boolean updateMember(Member member) {
        String query = "UPDATE NguoiDung SET HoTen = ?, Email = ?, MatKhau = ?, VaiTro = ? WHERE MaNguoiDung = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, member.getHoTen());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getMatKhau());
            stmt.setString(4, member.getVaiTro());
            stmt.setInt(5, member.getMaNguoiDung());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa thành viên
    public boolean deleteMember(int maNguoiDung) {
        String query = "DELETE FROM NguoiDung WHERE MaNguoiDung = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maNguoiDung);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
