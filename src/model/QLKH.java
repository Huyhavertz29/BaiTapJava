package model;

import java.util.ArrayList;

public class QLKH {
	private ArrayList<KhachHang> dsKhachHang;
	
	public QLKH(){
		this.dsKhachHang = new ArrayList<KhachHang>();
	}

	public QLKH(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}

	public ArrayList<KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}

	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}
	
	
	
}
