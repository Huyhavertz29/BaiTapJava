package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MonAn;
import view.Main;

public class QLMAController implements ActionListener {
	public Main main;
	
	
	public QLMAController(Main main) {
		this.main = main;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(main, "Bạn vừa nhấn vào:" +cm);
		if(cm.equals("Thêm")) {
			this.main.xoaForm();
			this.main.model.setLuaChon("Thêm");
		}else if(cm.equals("Lưu")) {
			
			try {
				this.main.thucHienThemMonAn();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}else if(cm.equals("Cập nhật")) {
			this.main.hienThiThongTinMonAnDaChon();
		}else if(cm.equals("Xóa")) {
			this.main.thucHienXoa();	
		}else if(cm.equals("Hủy bỏ")) {
			this.main.xoaForm();	
		}else if(cm.equals("Tìm kiếm")) {
			this.main.thucHienTim();	
		}else if(cm.equals("Tìm kiếm ")) {
			this.main.thucHienTimTheoGia();	
		}else if(cm.equals("Hủy tìm")) {
			this.main.thucHienHuyTim();	
		}
	}

}
