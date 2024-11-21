package model;

import java.util.Objects;

public class MonAn {
	private String maMon;
	private String tenMon;
	private String loaiMon;
	private float gia;
	
	
	
	public MonAn() {
		
	}
	public MonAn(String maMon, String tenMon, String loaiMon, float gia) {
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.loaiMon = loaiMon;
		this.gia = gia;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public String getLoaiMon() {
		return loaiMon;
	}
	public void setLoaiMon(String loaiMon) {
		this.loaiMon = loaiMon;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "MonAn [maMon=" + maMon + ", tenMon=" + tenMon + ", loaiMon=" + loaiMon + ", gia=" + gia + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(gia, loaiMon, maMon, tenMon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonAn other = (MonAn) obj;
		return Float.floatToIntBits(gia) == Float.floatToIntBits(other.gia) && Objects.equals(loaiMon, other.loaiMon)
				&& Objects.equals(maMon, other.maMon) && Objects.equals(tenMon, other.tenMon);
	}
	
	
	
}
