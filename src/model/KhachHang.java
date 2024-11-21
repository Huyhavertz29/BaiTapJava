package model;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String hoten;
	private String gioiTinh;
	private String soDT;
	private String diaChi;
	private Date ngayDat;

	public KhachHang(String maKhachHang, String hoten, String gioiTinh, String soDT, String diaChi, Date ngayDat) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoten = hoten;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.ngayDat = ngayDat;
	}

	public KhachHang() {

	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoten=" + hoten + ", gioiTinh=" + gioiTinh + ", soDT="
				+ soDT + ", diaChi=" + diaChi + ", ngayDat=" + ngayDat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, gioiTinh, hoten, maKhachHang, ngayDat, soDT);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(gioiTinh, other.gioiTinh)
				&& Objects.equals(hoten, other.hoten) && Objects.equals(maKhachHang, other.maKhachHang)
				&& Objects.equals(ngayDat, other.ngayDat) && soDT == other.soDT;
	}

}
