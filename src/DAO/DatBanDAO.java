package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.QuanLyNhaHangJDBC;
import model.DatBanModel;

public class DatBanDAO {
	 
    // Thêm thông tin đặt bàn
    public boolean addDatBan(DatBanModel datBanModel) {
        String sql = "INSERT INTO datban (maDatBan ,maBanAn, maKhachHang, ngayDat, trangThaiDat) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = QuanLyNhaHangJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, datBanModel.getMaDatBan()); 
            stmt.setString(2, datBanModel.getMaBan());
            stmt.setString(3, datBanModel.getMaKhachHang());
            stmt.setDate(4, new java.sql.Date(datBanModel.getNgayDat().getTime()));
            stmt.setString(5, datBanModel.getTrangThaiDat());
            
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    public String getNextBookingId() {
	    String sql = "SELECT MAX(maDatBan) AS maxId FROM datban";
	    try (Connection con = QuanLyNhaHangJDBC.getConnection();
	         PreparedStatement pst = con.prepareStatement(sql);
	         ResultSet rs = pst.executeQuery()) {

	        if (rs.next()) {
	            String maxId = rs.getString("maxId"); // Lấy mã lớn nhất hiện tại
	            if (maxId != null) {
	                // Tăng mã lớn nhất lên 1
	                int nextId = Integer.parseInt(maxId.substring(2)) + 1;
	                return "DB" + String.format("%02d", nextId); // Ví dụ: "DB0005"
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return "DB01"; // Trả về mã mặc định nếu chưa có mã nào trong bảng
	}
    public boolean updateBanStatus(String maBan, String trangThai) {
        String query = "UPDATE banan SET trangThai = ? WHERE maBanAn = ?";
        try (Connection conn = QuanLyNhaHangJDBC.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, trangThai); // Trạng thái mới (ví dụ: "Đã đặt")
            ps.setString(2, maBan); // Mã bàn cần cập nhật
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Object[]> getThongTinDatBan() {
        List<Object[]> result = new ArrayList<>();
        String query = "SELECT * FROM datban, khachhang WHERE khachhang.maKhachHang = datban.maKhachHang";
        
        try (Connection conn = QuanLyNhaHangJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Object[] row = new Object[10];
                row[0] = rs.getString("maDatBan");
                row[1] = rs.getString("maBanAn");
                row[2] = rs.getString("maKhachHang");
                row[3] = rs.getDate("ngayDat");
                row[4] = rs.getString("trangThaiDat");
                row[5] = rs.getString("maKhachHang");
                row[6] = rs.getString("hoTen");
                row[7] = rs.getString("soDT");
                row[8] = rs.getString("diaChi");
                row[9] = rs.getString("gioiTinh");
                
                result.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
}
