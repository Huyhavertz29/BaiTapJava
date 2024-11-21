package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class QuanLyNhaHangJDBC {
	public static Connection getConnection() {
		Connection c = null;
		
		
		try {
			// Đăng ký driver
			DriverManager.registerDriver(new SQLServerDriver());
			
			// Các thông số
			String url = "jdbc:sqlserver://LAPTOP-JEFMO64U:1433;database=QUANLYNHAHANG;encrypt=true;trustServerCertificate=true;";
			String userName = "sa";
			String password = "123456789";
			
			// Tạo kết nối
			c = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
