package com.library.models;

public class Book {
    private int maSach;
    private String tieuDe;
    private int maTacGia;
    private int maTheLoai;
    private String isbn;
    private int namXuatBan;
    private int soLuong;
    private String anhBia;

    // Constructors, getters, setters, toString
    public Book(int maSach, String tieuDe, int maTacGia, int maTheLoai, int namXuatBan, String anhBia) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.maTacGia = maTacGia;
        this.maTheLoai = maTheLoai;
        this.isbn = isbn;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.anhBia = anhBia;
    }

    // Getters and Setters
    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public int getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.maTacGia = maTacGia;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getAnhBia() {
        return anhBia;
    }

    public void setAnhBia(String anhBia) {
        this.anhBia = anhBia;
    }
}
