package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import DAO.DatBanDAO;
import DAO.KhachHangDAO;
import database.QuanLyNhaHangJDBC;
import model.DatBanModel;
import model.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.GroupLayout.Group;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_fullname;
	private JTextField textField_phone;
	private JTextField textField_makh;
	private JTextField textField_diachi;
	private String maBan;

	public Guest(String maBan) {
		this.maBan = maBan;
		initComponents();
	}

	private void initComponents() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Thông tin khách hàng đặt bàn");

		URL urlIcon = Login.class.getResource("restaurant (3).png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);

		JLabel lblNewLabel_title = new JLabel("Welcome to restaurant\r\n");
		lblNewLabel_title.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_title.setBounds(154, 0, 357, 86);
		lblNewLabel_title.setForeground(new Color(51, 153, 204));
		contentPane.add(lblNewLabel_title);

		JLabel lblNewLabel_name = new JLabel("Họ và tên");
		lblNewLabel_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_name.setBounds(51, 95, 92, 38);
		contentPane.add(lblNewLabel_name);

		textField_fullname = new JTextField();
		textField_fullname.setBounds(229, 97, 261, 38);
		contentPane.add(textField_fullname);
		textField_fullname.setColumns(10);

		JLabel lblNewLabel_phone = new JLabel("Số điện thoại");
		lblNewLabel_phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_phone.setBounds(51, 217, 111, 38);
		contentPane.add(lblNewLabel_phone);

		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(229, 219, 261, 38);
		contentPane.add(textField_phone);

		JLabel lblNewLabel_gender = new JLabel("Giới tính\r\n");
		lblNewLabel_gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_gender.setBounds(51, 288, 92, 38);
		contentPane.add(lblNewLabel_gender);

		JRadioButton rdbtnNewRadioButton_nam = new JRadioButton("Nam");
		rdbtnNewRadioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_nam.setBounds(229, 296, 59, 23);
		contentPane.add(rdbtnNewRadioButton_nam);

		JRadioButton rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnN.setBounds(302, 296, 59, 23);
		contentPane.add(rdbtnN);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnN);
		buttonGroup.add(rdbtnNewRadioButton_nam);

		JDateChooser jDateChooser = new JDateChooser();
		jDateChooser.setBounds(229, 354, 193, 38);
		contentPane.add(jDateChooser);

		JLabel lblNewLabel_date = new JLabel("Ngày đặt bàn \r\n");
		lblNewLabel_date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_date.setBounds(51, 354, 111, 38);
		contentPane.add(lblNewLabel_date);

		JLabel lblNewLabel_makh = new JLabel("Mã khách hàng \r\n");
		lblNewLabel_makh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_makh.setBounds(51, 439, 122, 38);
		contentPane.add(lblNewLabel_makh);

		textField_makh = new JTextField();
		textField_makh.setColumns(10);
		textField_makh.setBounds(229, 441, 261, 38);
		contentPane.add(textField_makh);

		JButton btn_db2 = new JButton("Đặt bàn ");
		btn_db2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String hoten = textField_fullname.getText();
					String diaChi = textField_diachi.getText();
					String soDTString = textField_phone.getText(); // Lấy chuỗi từ JTextField
					String maKhachHang = textField_makh.getText();
					String gioiTinh = rdbtnNewRadioButton_nam.isSelected() ? "Nam" : "Nữ";
					java.util.Date ngayDat = jDateChooser.getDate();

					if (ngayDat == null) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày đặt bàn!");
						return;
					}

					java.sql.Date sqlDate = new java.sql.Date(ngayDat.getTime());

					// Kiểm tra nếu các trường thông tin cần thiết đã được nhập
					if (hoten.isEmpty() || soDTString.isEmpty() || maKhachHang.isEmpty() || diaChi.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
						return;
					}
					// Kiểm tra xem soDT có phải là số hợp lệ không
					int soDT = 0;
					try {
						soDT = Integer.parseInt(soDTString); // Chuyển đổi chuỗi sang số nguyên
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Số điện thoại phải là một số hợp lệ!");
						return;
					}

					KhachHang khachHang = new KhachHang(maKhachHang, hoten, gioiTinh, soDTString, diaChi, sqlDate);
					KhachHangDAO dao = new KhachHangDAO();
					boolean isCustomerAdded = dao.addCustomer(khachHang);

					if (!isCustomerAdded) {
						JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng!");
						return;
					}

					DatBanDAO banDAO = new DatBanDAO();
					String maDatBan = banDAO.getNextBookingId();
					DatBanModel banModel = new DatBanModel(maDatBan, maBan, maKhachHang, sqlDate, "Đã đặt");

					boolean isBookingAdded = banDAO.addDatBan(banModel);

					if (isBookingAdded) {
						JOptionPane.showMessageDialog(null, "Đặt bàn thành công!");
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi khi thêm đặt bàn!");
					}

					dispose();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Số điện thoại phải là một số hợp lệ!");
				}

			}
		});

		btn_db2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_db2.setBounds(110, 505, 145, 54);
		contentPane.add(btn_db2);

		JButton btnHyB = new JButton("Hủy bỏ");
		btnHyB.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHyB.setBounds(366, 505, 145, 54);
		contentPane.add(btnHyB);

		JLabel lblNewLabel_diachi = new JLabel("Địa chỉ");
		lblNewLabel_diachi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_diachi.setBounds(51, 159, 92, 38);
		contentPane.add(lblNewLabel_diachi);

		textField_diachi = new JTextField();
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(229, 159, 261, 38);
		contentPane.add(textField_diachi);
	}

	public Guest() {

	}
}
