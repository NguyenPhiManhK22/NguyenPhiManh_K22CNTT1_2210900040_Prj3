package com.library.models;

import java.util.Date;

public class MuonSach {
    private int maMuonSach;     // Mã mượn sách
    private int maNguoiDung;    // Mã người dùng
    private int maSach;         // Mã sách
    private Date ngayMuon;      // Ngày mượn sách
    private Date hanTra;        // Hạn trả sách
    private Date ngayTra;       // Ngày trả sách (có thể null nếu chưa trả)
    private String trangThai;   // Trạng thái (Đang mượn, Đã trả)

    // Constructor
    public MuonSach(int maMuonSach, int maNguoiDung, int maSach, Date ngayMuon, Date hanTra, Date ngayTra, String trangThai) {
        this.maMuonSach = maMuonSach;
        this.maNguoiDung = maNguoiDung;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    // Getter và Setter cho MaMuonSach
    public int getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(int maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    // Getter và Setter cho MaNguoiDung
    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    // Getter và Setter cho MaSach
    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    // Getter và Setter cho NgayMuon
    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    // Getter và Setter cho HanTra
    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    // Getter và Setter cho NgayTra
    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    // Getter và Setter cho TrangThai
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // Phương thức toString() để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "MuonSach{" +
                "maMuonSach=" + maMuonSach +
                ", maNguoiDung=" + maNguoiDung +
                ", maSach=" + maSach +
                ", ngayMuon=" + ngayMuon +
                ", hanTra=" + hanTra +
                ", ngayTra=" + ngayTra +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
