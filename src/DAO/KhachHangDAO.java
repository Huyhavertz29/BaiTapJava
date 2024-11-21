package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.QuanLyNhaHangJDBC;
import model.KhachHang;

public class KhachHangDAO {
	 public boolean addCustomer(KhachHang kh) {
	        String sql = "INSERT INTO khachhang (maKhachHang, hoTen, diaChi, soDT, gioiTinh, ngayDat) VALUES (?, ?, ?, ?, ?, ?)";
	        try{
	        	Connection con = QuanLyNhaHangJDBC.getConnection(); 
	            PreparedStatement pst = con.prepareStatement(sql);
	            
	            pst.setString(1, kh.getMaKhachHang());
	            pst.setString(2, kh.getHoten());
	            pst.setString(3, kh.getDiaChi());
	            pst.setString(4, kh.getSoDT());
	            pst.setString(5, kh.getGioiTinh());
	            pst.setDate(6, kh.getNgayDat());
	            return pst.executeUpdate() > 0;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            return false;
	        }
	    }
}
