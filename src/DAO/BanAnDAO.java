package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.QuanLyNhaHangJDBC;

public class BanAnDAO {
	 public boolean updateTrangThaiBan(String maBanAn, String trangThai) {
	        String sql = "UPDATE BanAn SET trangThai = ? WHERE maBanAn = ?";
	        
	        try{
	        	Connection conn = QuanLyNhaHangJDBC.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql) ; 
	            stmt.setString(1, trangThai);
	            stmt.setString(2, maBanAn);
	            
	            int rows = stmt.executeUpdate();
	            return rows > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
}
