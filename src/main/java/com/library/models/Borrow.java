package com.library.models;

import java.sql.Date;

public class Borrow {
    private int maMuonSach;
    private int maNguoiDung;
    private int maSach;
    private Date ngayMuon;
    private Date hanTra;
    private Date ngayTra;

    // Constructor
    public Borrow(int maMuonSach, int maNguoiDung, int maSach, Date ngayMuon, Date hanTra, Date ngayTra) {
        this.maMuonSach = maMuonSach;
        this.maNguoiDung = maNguoiDung;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.ngayTra = ngayTra;
    }

    // Getters and Setters
    public int getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(int maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
}
