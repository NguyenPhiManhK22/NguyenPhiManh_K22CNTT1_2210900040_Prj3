package com.library.models;

public class TacGia {
    private int MaTacGia;      // Mã tác giả
    private String TenTacGia;  // Tên tác giả
    private int NamSinh;       // Năm sinh của tác giả
    private String QuocGia;    // Quốc gia của tác giả
    private String AnhTacGia;  // Đường dẫn ảnh của tác giả

    // Constructor
    public TacGia(int MaTacGia, String TenTacGia, int NamSinh, String QuocGia, String AnhTacGia) {
        this.MaTacGia = MaTacGia;
        this.TenTacGia = TenTacGia;
        this.NamSinh = NamSinh;
        this.QuocGia = QuocGia;
        this.AnhTacGia = AnhTacGia;
    }

    // Getter và Setter cho MaTacGia
    public int getMaTacGia() {
        return MaTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        MaTacGia = maTacGia;
    }

    // Getter và Setter cho TenTacGia
    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        TenTacGia = tenTacGia;
    }

    // Getter và Setter cho NamSinh
    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }

    // Getter và Setter cho QuocGia
    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    // Getter và Setter cho AnhTacGia
    public String getAnhTacGia() {
        return AnhTacGia;
    }

    public void setAnhTacGia(String anhTacGia) {
        AnhTacGia = anhTacGia;
    }

    // Phương thức toString() để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "TacGia{" +
                "MaTacGia=" + MaTacGia +
                ", TenTacGia='" + TenTacGia + '\'' +
                ", NamSinh=" + NamSinh +
                ", QuocGia='" + QuocGia + '\'' +
                ", AnhTacGia='" + AnhTacGia + '\'' +
                '}';
    }
}
