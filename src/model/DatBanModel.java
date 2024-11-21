package model;

import java.sql.Date;

public class DatBanModel {
	private String maDatBan;  // Mã đặt bàn
    private String maBan;     // Mã bàn
    private String maKhachHang;  // Mã khách hàng
    private Date ngayDat;     // Ngày đặt
    private String trangThaiDat; // Trạng thái đặt bàn

    // Constructor
    public DatBanModel(String maDatBan, String maBan, String maKhachHang, Date ngayDat, String trangThaiDat) {
        this.maDatBan = maDatBan;
        this.maBan = maBan;
        this.maKhachHang = maKhachHang;
        this.ngayDat = ngayDat;
        this.trangThaiDat = trangThaiDat;
    }

    // Getters và Setters
    public String getMaDatBan() {
        return maDatBan;
    }

    public void setMaDatBan(String maDatBan) {
        this.maDatBan = maDatBan;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getTrangThaiDat() {
        return trangThaiDat;
    }

    public void setTrangThaiDat(String trangThaiDat) {
        this.trangThaiDat = trangThaiDat;
    }

    // Phương thức để in thông tin đặt bàn (tuỳ chọn)
    @Override
    public String toString() {
        return "DatBan{" +
                "maDatBan='" + maDatBan + '\'' +
                ", maBan='" + maBan + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayDat=" + ngayDat +
                ", trangThaiDat='" + trangThaiDat + '\'' +
                '}';
    }
}
