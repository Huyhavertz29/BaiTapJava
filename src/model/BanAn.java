package model;

import java.util.Objects;

public class BanAn {
	private String maBanAn;
	private String TenBanAn;
	private int choNgoi;
	private String trangThai;

	public BanAn() {

	}

	public BanAn(String maBanAn, String tenBanAn, int choNgoi, String trangThai) {
		this.maBanAn = maBanAn;
		TenBanAn = tenBanAn;
		this.choNgoi = choNgoi;
		this.trangThai = trangThai;
	}

	public String getMaBanAn() {
		return maBanAn;
	}

	public void setMaBanAn(String maBanAn) {
		this.maBanAn = maBanAn;
	}

	public String getTenBanAn() {
		return TenBanAn;
	}

	public void setTenBanAn(String tenBanAn) {
		TenBanAn = tenBanAn;
	}

	public int getChoNgoi() {
		return choNgoi;
	}

	public void setChoNgoi(int choNgoi) {
		this.choNgoi = choNgoi;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "BanAn [maBanAn=" + maBanAn + ", TenBanAn=" + TenBanAn + ", choNgoi=" + choNgoi + ", trangThai="
				+ trangThai + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(TenBanAn, choNgoi, maBanAn, trangThai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BanAn other = (BanAn) obj;
		return Objects.equals(TenBanAn, other.TenBanAn) && choNgoi == other.choNgoi
				&& Objects.equals(maBanAn, other.maBanAn) && Objects.equals(trangThai, other.trangThai);
	}
	

}
