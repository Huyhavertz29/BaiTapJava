package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.QuanLyNhaHangJDBC;

public class QLMAModel {
	private ArrayList<MonAn> dsMonAn;
	private String luaChon;

	public QLMAModel() {
		this.dsMonAn = new ArrayList<MonAn>();
		this.luaChon = "";
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public QLMAModel(ArrayList<MonAn> dsMonAn) {
		this.dsMonAn = dsMonAn;
	}

	public ArrayList<MonAn> getDsMonAn() {
		return dsMonAn;
	}

	public void setDsMonAn(ArrayList<MonAn> dsMonAn) {
		this.dsMonAn = dsMonAn;
	}

	public boolean kiemTraMaTrung(String maMonAn) {
		boolean isDuplicate = false;
		try {
			Connection con = QuanLyNhaHangJDBC.getConnection();
			String sql = "SELECT COUNT(*) FROM monan WHERE maMonAn = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, maMonAn);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					isDuplicate = true; // Nếu có hơn 0 kết quả, mã món ăn đã tồn tại
				}
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDuplicate;
	}

	public void insert(MonAn monAn) {
		try {
			Connection con = QuanLyNhaHangJDBC.getConnection();
			String sql = "INSERT INTO monan values (?, ?, ?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, monAn.getMaMon());
			pst.setString(2, monAn.getTenMon());
			pst.setString(3, monAn.getLoaiMon());
			pst.setFloat(4, monAn.getGia());

			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dsMonAn.add(monAn);
		

	}

	public void delete(MonAn monAn) {
		try {
			Connection con = QuanLyNhaHangJDBC.getConnection();
			String sql = "delete from monan where maMonAn = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, monAn.getMaMon());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dsMonAn.remove(monAn);

	}

	public void update(MonAn monAn) {
		try {
	        // Kết nối đến cơ sở dữ liệu
	        Connection con = QuanLyNhaHangJDBC.getConnection();

	        // Câu lệnh SQL để cập nhật thông tin món ăn
	        String sql = "UPDATE monan SET tenMonAn = ?, loaiMonAn = ?, gia = ? WHERE maMonAn = ?";

	        // Chuẩn bị câu lệnh
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, monAn.getTenMon());  
	        pst.setString(2, monAn.getLoaiMon()); 
	        pst.setFloat(3, monAn.getGia());      
	        pst.setString(4, monAn.getMaMon());   
	        // Thực thi câu lệnh
	        pst.executeUpdate();

	        // Đóng kết nối
	        pst.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		this.dsMonAn.remove(monAn);
		this.dsMonAn.add(monAn);
		
	}
}
