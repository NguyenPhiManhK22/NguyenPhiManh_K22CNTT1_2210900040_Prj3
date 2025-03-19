package com.library.models;

public class TienPhat {
    private int maTienPhat;     // Mã tiền phạt
    private int maMuonSach;     // Mã mượn sách
    private double soTien;      // Số tiền phạt
    private boolean daThanhToan; // Đã thanh toán hay chưa

    // Constructor
    public TienPhat(int maTienPhat, int maMuonSach, double soTien, boolean daThanhToan) {
        this.maTienPhat = maTienPhat;
        this.maMuonSach = maMuonSach;
        this.soTien = soTien;
        this.daThanhToan = daThanhToan;
    }

    // Getter và Setter
    public int getMaTienPhat() {
        return maTienPhat;
    }

    public void setMaTienPhat(int maTienPhat) {
        this.maTienPhat = maTienPhat;
    }

    public int getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(int maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public boolean isDaThanhToan() {
        return daThanhToan;
    }

    public void setDaThanhToan(boolean daThanhToan) {
        this.daThanhToan = daThanhToan;
    }

    @Override
    public String toString() {
        return "TienPhat{" +
                "maTienPhat=" + maTienPhat +
                ", maMuonSach=" + maMuonSach +
                ", soTien=" + soTien +
                ", daThanhToan=" + daThanhToan +
                '}';
    }
}
