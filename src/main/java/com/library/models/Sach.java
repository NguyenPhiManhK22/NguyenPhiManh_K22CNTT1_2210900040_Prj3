package com.library.models;

public class Sach {
    private int MaSach;
    private String TieuDe;
    private int MaTacGia;
    private int MaTheLoai;
    private String ISBN;
    private int NamXuatBan;
    private int SoLuong;
    private String AnhBia;

    // Constructor, getter và setter
    public Sach(int MaSach, String TieuDe, int MaTacGia, int MaTheLoai, String ISBN, int NamXuatBan, int SoLuong, String AnhBia) {
        this.MaSach = MaSach;
        this.TieuDe = TieuDe;
        this.MaTacGia = MaTacGia;
        this.MaTheLoai = MaTheLoai;
        this.ISBN = ISBN;
        this.NamXuatBan = NamXuatBan;
        this.SoLuong = SoLuong;
        this.AnhBia = AnhBia;
    }
    
    // Getter và Setter cho các thuộc tính


    public Sach() {
    }
    // Getter and Setter methods

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.TieuDe = tieuDe;
    }

    public int getMaTacGia() {
        return MaTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.MaTacGia = maTacGia;
    }
    
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public int getMaTheLoai() {
        return MaTheLoai;
    }
    public void setMaTheLoai(int MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }
    
    public int getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.NamXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        this.SoLuong = soLuong;
    }

    public String getAnhBia() {
        return AnhBia;
    }

    public void setAnhBia(String anhBia) {
        this.AnhBia = anhBia;
    }
}
