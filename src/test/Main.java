package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import database.QuanLyNhaHangJDBC;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			view.Main main = new view.Main();
			main.setVisible(true);
			main.setLocationRelativeTo(null);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
