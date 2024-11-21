package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.QuanLyNhaHangJDBC;

public class QLBA {
	private ArrayList<BanAn> dsBanAn;

	public QLBA() {
		this.dsBanAn = new ArrayList<BanAn>();
	}

	public QLBA(ArrayList<BanAn> dsBanAn) {
		this.dsBanAn = dsBanAn;
	}

	public ArrayList<BanAn> getDsBanAn() {
		return dsBanAn;
	}

	public void setDsBanAn(ArrayList<BanAn> dsBanAn) {
		this.dsBanAn = dsBanAn;
	}

	// Lấy danh sách bàn ăn từ cơ sở dữ liệu
	public void loadDsBanAnFromDatabase() {
		String sql = "SELECT * FROM BanAn";
		try {
			Connection con = QuanLyNhaHangJDBC.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);

			// Lấy dữ liệu từ ResultSet và thêm vào dsBanAn
			while (rs.next()) {
				String maban = rs.getString("maBanAn");
				String tenban = rs.getString("tenBanAn");
				int socho = rs.getInt("choNgoi");
				String trangthai = rs.getString("trangThai");

				BanAn banAn = new BanAn(maban, tenban, socho, trangthai);
				dsBanAn.add(banAn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static BanAn getBanAnByTenBan(String tenBanAn ) {
	    String sql = "SELECT * FROM BanAn WHERE tenBanAn = ?";
	    BanAn banAn = null;

	    try (Connection con = QuanLyNhaHangJDBC.getConnection();
	         PreparedStatement pst = con.prepareStatement(sql)) {
	        pst.setString(1, tenBanAn);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            String maban = rs.getString("maBanAn");
	            int socho = rs.getInt("choNgoi");
	            String trangthai = rs.getString("trangThai");

	            banAn = new BanAn(maban, tenBanAn, socho, trangthai);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return banAn;
	}

	public void updateTrangThaiBanAn(String maban, String trangthai) {
        String sql = "UPDATE BanAn SET trangThai = ? WHERE maBanAn = ?";
        try {
        	Connection con = QuanLyNhaHangJDBC.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, trangthai);
            pst.setString(2, maban);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getTrangThaiBan(String maBan) {
        String trangThai = null;
        String query = "SELECT trangThai FROM banan WHERE maBanAn = ?";
        try (Connection con = QuanLyNhaHangJDBC.getConnection();
        	PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, maBan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                trangThai = rs.getString("trangThai");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trangThai;
    }


}
