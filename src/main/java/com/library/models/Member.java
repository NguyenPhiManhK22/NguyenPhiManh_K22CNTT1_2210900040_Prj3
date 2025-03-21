package com.library.models;

import java.util.Date;

public class Member {
    private int maNguoiDung;     // Mã người dùng (ID của thành viên)
    private String hoTen;        // Họ tên thành viên
    private String email;        // Email thành viên (có thể dùng làm đăng nhập)
    private String matKhau;      // Mật khẩu thành viên (cần mã hóa)
    private String vaiTro;       // Vai trò của thành viên (Admin, ThanhVien)
    private Date ngayTao;        // Ngày tạo tài khoản của thành viên

    // Constructor
    public Member(int maNguoiDung, String hoTen, String email, String matKhau, String vaiTro, Date ngayTao) {
        this.maNguoiDung = maNguoiDung;
        this.hoTen = hoTen;
        this.email = email;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.ngayTao = ngayTao;
    }

    public Member() {
		// TODO Auto-generated constructor stub
	}

	// Getter và Setter cho các thuộc tính
    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "Member{" +
                "maNguoiDung=" + maNguoiDung +
                ", hoTen='" + hoTen + '\'' +
                ", email='" + email + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", vaiTro='" + vaiTro + '\'' +
                ", ngayTao=" + ngayTao +
                '}';
    }
}
