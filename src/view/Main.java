package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DAO.DatBanDAO;
import controller.QLMAController;
import database.QuanLyNhaHangJDBC;
import model.BanAn;
import model.MonAn;
import model.QLBA;
import model.QLMAModel;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPanel jp1, jp2, jp3, jp4, jp5;
	public JTable table;
	public JTextField textField_mama;
	public JTextField textField_tenma;
	public JTextField textField_gia;
	public JTextField textField_timMon;
	public JTextField textField_loaima;
	public JComboBox<String> comboBox_Gia;
	public QLMAModel model;
	public JTable table_1;
	private Map<String, String> foodImageMap = new HashMap<>();
	public JTextField textField_maban;
	private JTextField textField_tenban;
	private JTextField textField_socho;
	private JTextField textField_trangthai;
	private JPanel panel_content;
	private JPanel panel_table;
	private JTable table_ttdb;
	private JTable table_2;
	private JSpinner spinner;

	public Main() {
		this.model = new QLMAModel();
		this.setTitle("Quản lý nhà hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 651);
		ActionListener actionListener = new QLMAController(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(0, 0, 226, 622);
		panel_menu.setBackground(new Color(51, 153, 204));
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);

		JPanel tab1 = new JPanel();
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.this.setTitle("Đặt bàn");
				jp1.setVisible(true);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(false);
				jp5.setVisible(false);
			}
		});
		tab1.setBounds(0, 323, 226, 52);
		panel_menu.add(tab1);
		tab1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đặt món");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(70, 11, 103, 28);
		tab1.add(lblNewLabel_1_1);

		JPanel tab2 = new JPanel();
		tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(true);
				jp3.setVisible(false);
				jp4.setVisible(false);
				jp5.setVisible(false);

			}
		});
		tab2.setBounds(0, 402, 226, 52);
		panel_menu.add(tab2);
		tab2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Thông tin món ăn\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(37, 11, 189, 28);
		tab2.add(lblNewLabel_1_1_1);

		JPanel tab3 = new JPanel();
		tab3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(true);
				jp4.setVisible(false);
				jp5.setVisible(false);
			}
		});
		tab3.setBounds(0, 482, 226, 52);
		panel_menu.add(tab3);
		tab3.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Thanh toán");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_2.setBounds(64, 11, 103, 28);
		tab3.add(lblNewLabel_1_1_2);

		JPanel tab4 = new JPanel();
		tab4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(true);
				jp5.setVisible(false);
			}
		});
		tab4.setBounds(0, 578, 226, 44);
		panel_menu.add(tab4);

		JPanel tab5 = new JPanel();
		tab5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(false);
				jp5.setVisible(true);
			}
		});
		tab5.setBounds(0, 243, 226, 52);
		panel_menu.add(tab5);
		tab5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Đặt bàn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(71, 11, 103, 28);
		tab5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Main.class.getResource("/view/account (1).png")));
		lblNewLabel_3.setBounds(46, 24, 122, 122);
		panel_menu.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(56, 157, 140, 32);
		panel_menu.add(lblNewLabel_4);

		JPanel panel_content = new JPanel();
		panel_content.setBounds(222, 0, 893, 622);
		contentPane.add(panel_content);
		panel_content.setLayout(new CardLayout(0, 0));

		jp1 = new JPanel();
		jp1.setBackground(new Color(255, 255, 255));
		panel_content.add(jp1, "name_18743125243600");
		jp1.setLayout(null);

		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] {
				"M\u00E3 m\u00F3n \u0103n", "T\u00EAn m\u00F3n \u0103n", "Lo\u1EA1i m\u00F3n \u0103n", "Gi\u00E1" }));

		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 59, 436, 170);
		jp1.add(scrollPane_1);
		loadDataToTable(table_1);
		JButton btn_reset = new JButton("Tải lại\r\n");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataToTable(table_1);
			}
		});
		btn_reset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_reset.setBounds(10, 253, 101, 29);
		jp1.add(btn_reset);

		JLabel lblNewLabel_gt = new JLabel("Danh sách món ăn");
		lblNewLabel_gt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_gt.setBounds(10, 21, 158, 27);
		jp1.add(lblNewLabel_gt);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(
				new TitledBorder(null, "M\u00F4 t\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.setBounds(456, 31, 414, 202);
		jp1.add(verticalBox);

		JPanel panel = new JPanel();
		verticalBox.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("                 Vui lòng chọn món ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
//		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/view/rac.png")));
		addTableRowClickListener(table_1, lblNewLabel);
		lblNewLabel.setBounds(0, 5, 402, 175);
		panel.add(lblNewLabel);

		JButton btn_reset_1 = new JButton("Chọn");
		btn_reset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table_1.getSelectedRow();
			        if (selectedRow == -1) {
			            JOptionPane.showMessageDialog(null, "Vui lòng chọn một món ăn trong danh sách!");
			            return;
			        }

			        // Lấy dữ liệu từ table_1
			        String tenMonAn = table_1.getValueAt(selectedRow, 1).toString();
			        double gia = Double.parseDouble(table_1.getValueAt(selectedRow, 3).toString());
			        int soLuong = (int) spinner.getValue();

			        // Kiểm tra số lượng hợp lệ
			        if (soLuong <= 0) {
			            JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0!");
			            return;
			        }

			        // Kiểm tra nếu món đã tồn tại trong table_2
			        boolean exists = false;
			        DefaultTableModel modelTable2 = (DefaultTableModel) table_2.getModel();
			        for (int i = 0; i < table_2.getRowCount(); i++) {
			            if (table_2.getValueAt(i, 0).toString().equals(tenMonAn)) {
			                int currentQuantity = Integer.parseInt(table_2.getValueAt(i, 1).toString());
			                modelTable2.setValueAt(currentQuantity + soLuong, i, 1); // Cập nhật số lượng
			                double newTotal = (currentQuantity + soLuong) * gia;
			                modelTable2.setValueAt(newTotal, i, 3); // Cập nhật tổng tiền
			                exists = true;
			                break;
			            }
			        }

			        // Nếu món chưa tồn tại, thêm dòng mới
			        if (!exists) {
			            double tongTien = gia * soLuong;
			            modelTable2.addRow(new Object[]{tenMonAn, soLuong, gia, tongTien});
			        }
		}});
		

		
		btn_reset_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_reset_1.setBounds(139, 253, 101, 29);
		jp1.add(btn_reset_1);
		
		spinner = new JSpinner();
		spinner.setBounds(358, 256, 49, 26);
		jp1.add(spinner);
		
		JLabel lblNewLabel_2 = new JLabel("Số lượng ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(276, 253, 68, 29);
		jp1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_gt_1 = new JLabel("Danh sách đặt món");
		lblNewLabel_gt_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_gt_1.setBounds(10, 310, 158, 27);
		jp1.add(lblNewLabel_gt_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
		    new Object[][] {}, 
		    new String[] {"Tên món ăn", "Số lượng", "Giá", "Tổng tiền"}
		) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        // Chỉ cho phép chỉnh sửa cột "Số lượng"
		        return column == 1;
		    }
		});

		// Đảm bảo thêm bảng vào giao diện
		JScrollPane scrollPane_3 = new JScrollPane(table_2);
		scrollPane_3.setBounds(27, 348, 843, 180);
		jp1.add(scrollPane_3);

		// Cập nhật tổng tiền khi chỉnh sửa số lượng
		DefaultTableModel modelTable2 = (DefaultTableModel) table_2.getModel();
	    modelTable2.addTableModelListener(e -> {
	        int column = e.getColumn();
	        if (column == 1) { // Nếu chỉnh sửa cột "Số lượng"
	            int row = e.getFirstRow();
	            try {
	                int soLuong = Integer.parseInt(modelTable2.getValueAt(row, 1).toString());
	                double gia = Double.parseDouble(modelTable2.getValueAt(row, 2).toString());
	                double tongTien = soLuong * gia;
	                modelTable2.setValueAt(tongTien, row, 3); // Cập nhật tổng tiền
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Số lượng phải là số hợp lệ!");
	            }
	        }
	    });
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(10, 291, 846, 2);
		jp1.add(separator_3_1);
		
		JButton btn_them_1 = new JButton("Hủy đặt ");
		btn_them_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_2.getSelectedRow();
			    if (selectedRow == -1) {
			        JOptionPane.showMessageDialog(null, "Vui lòng chọn một món ăn để hủy!");
			        return;
			    }

			    // Xác nhận hủy món ăn
			    int confirm = JOptionPane.showConfirmDialog(
			        null, 
			        "Bạn có chắc chắn muốn hủy món ăn đã chọn?", 
			        "Xác nhận hủy", 
			        JOptionPane.YES_NO_OPTION
			    );

			    if (confirm == JOptionPane.YES_OPTION) {
			        DefaultTableModel modelTable2 = (DefaultTableModel) table_2.getModel();
			        modelTable2.removeRow(selectedRow); // Xóa dòng được chọn
			        JOptionPane.showMessageDialog(null, "Đã hủy món ăn thành công!");
			    }
			}
		});
		btn_them_1.setBounds(477, 554, 152, 46);
		jp1.add(btn_them_1);
		
		JButton btn_them_1_1 = new JButton("Thanh toán");
		btn_them_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_them_1_1.setBounds(674, 554, 152, 46);
		jp1.add(btn_them_1_1);

		jp2 = new JPanel();
		jp2.setBackground(new Color(255, 255, 255));
		panel_content.add(jp2, "name_18743145351100");
		jp2.setLayout(null);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 m\u00F3n \u0103n",
				"T\u00EAn m\u00F3n \u0103n", "Lo\u1EA1i m\u00F3n \u0103n", "Gi\u00E1" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 68, 846, 181);
		jp2.add(scrollPane);

		loadDataToTable(table);
		JLabel lblNewLabel_title = new JLabel("Danh sách món ăn\r\n");
		lblNewLabel_title.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_title.setBounds(10, 11, 190, 46);
		jp2.add(lblNewLabel_title);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 262, 846, 2);
		jp2.add(separator);

		JLabel lblNewLabel_title_1 = new JLabel("Thông tin món ăn\r\n");
		lblNewLabel_title_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_title_1.setBounds(10, 275, 190, 46);
		jp2.add(lblNewLabel_title_1);

		JLabel lblNewLabel_mama = new JLabel("Mã món ăn ");
		lblNewLabel_mama.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_mama.setBounds(10, 332, 98, 28);
		jp2.add(lblNewLabel_mama);

		textField_mama = new JTextField();
		textField_mama.setBounds(149, 332, 204, 26);
		jp2.add(textField_mama);
		textField_mama.setColumns(10);

		JLabel lblNewLabel_tenma = new JLabel("Tên món ăn ");
		lblNewLabel_tenma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_tenma.setBounds(10, 387, 98, 28);
		jp2.add(lblNewLabel_tenma);

		textField_tenma = new JTextField();
		textField_tenma.setColumns(10);
		textField_tenma.setBounds(149, 387, 204, 26);
		jp2.add(textField_tenma);

		JLabel lblNewLabel_gia = new JLabel("Giá");
		lblNewLabel_gia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_gia.setBounds(10, 441, 98, 28);
		jp2.add(lblNewLabel_gia);

		textField_gia = new JTextField();
		textField_gia.setColumns(10);
		textField_gia.setBounds(149, 441, 204, 26);
		jp2.add(textField_gia);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(389, 283, 2, 239);
		jp2.add(separator_1);

		JLabel lblNewLabel_title_1_1 = new JLabel("Tra cứu món ăn\r\n");
		lblNewLabel_title_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_title_1_1.setBounds(401, 275, 190, 46);
		jp2.add(lblNewLabel_title_1_1);

		JLabel lblNewLabel_TimMon = new JLabel("Loại món ăn ");
		lblNewLabel_TimMon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_TimMon.setBounds(401, 332, 98, 28);
		jp2.add(lblNewLabel_TimMon);

		textField_timMon = new JTextField();
		textField_timMon.setColumns(10);
		textField_timMon.setBounds(530, 332, 204, 26);
		jp2.add(textField_timMon);

		JButton btn_tkloaiman = new JButton("Tìm kiếm");
		btn_tkloaiman.addActionListener(actionListener);
		btn_tkloaiman.setBounds(756, 324, 112, 36);
		jp2.add(btn_tkloaiman);

		JLabel lblNewLabel_mama_1_1 = new JLabel("Giá");
		lblNewLabel_mama_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_mama_1_1.setBounds(401, 396, 98, 28);
		jp2.add(lblNewLabel_mama_1_1);

		String[] luaChon = new String[] { "", "Món có giá dưới 100k", "Món có giá trên 100k" };
		comboBox_Gia = new JComboBox<String>(luaChon);
		comboBox_Gia.setBounds(530, 401, 204, 22);
		jp2.add(comboBox_Gia);

		JButton btn_tkGia = new JButton("Tìm kiếm ");
		btn_tkGia.addActionListener(actionListener);
		btn_tkGia.setBounds(756, 387, 112, 36);
		jp2.add(btn_tkGia);

		JLabel lblNewLabel_loaima = new JLabel("Loại món ăn ");
		lblNewLabel_loaima.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_loaima.setBounds(10, 494, 98, 28);
		jp2.add(lblNewLabel_loaima);

		textField_loaima = new JTextField();
		textField_loaima.setColumns(10);
		textField_loaima.setBounds(149, 494, 204, 26);
		jp2.add(textField_loaima);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 539, 833, 2);
		jp2.add(separator_2);

		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(actionListener);
		btn_them.setBounds(36, 558, 112, 46);
		jp2.add(btn_them);

		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(actionListener);
		btn_xoa.setBounds(209, 558, 112, 46);
		jp2.add(btn_xoa);

		JButton btn_capnhat = new JButton("Cập nhật");
		btn_capnhat.addActionListener(actionListener);
		btn_capnhat.setBounds(387, 558, 112, 46);
		jp2.add(btn_capnhat);

		JButton btn_luu = new JButton("Lưu");
		btn_luu.addActionListener(actionListener);
		btn_luu.setBounds(565, 558, 112, 46);
		jp2.add(btn_luu);

		JButton btn_huybo = new JButton("Hủy bỏ");
		btn_huybo.addActionListener(actionListener);
		btn_huybo.setBounds(738, 558, 112, 46);
		jp2.add(btn_huybo);

		JButton btn_huyTim = new JButton("Hủy tìm");
		btn_huyTim.addActionListener(actionListener);
		btn_huyTim.setBounds(756, 446, 112, 36);
		jp2.add(btn_huyTim);

		jp3 = new JPanel();
		jp3.setBackground(new Color(255, 255, 255));
		panel_content.add(jp3, "name_18743156565800");
		jp3.setLayout(null);

		jp4 = new JPanel();
		jp4.setBackground(new Color(0, 0, 0));
		panel_content.add(jp4, "name_18743166502900");

		jp5 = new JPanel();
		jp5.setBackground(new Color(255, 255, 255));
		panel_content.add(jp5, "name_9962074686300");
		jp5.setLayout(null);

		panel_table = new JPanel();
		panel_table.setBounds(10, 57, 436, 277);
		jp5.add(panel_table);
		panel_table.setLayout(new GridLayout(4, 4, 10, 10));

		for (int i = 1; i <= 16; i++) {
			JButton btn = new JButton("Bàn " + i);
			btn.setBackground(Color.GREEN);
			btn.setOpaque(true);
			
			 // Đọc trạng thái từ cơ sở dữ liệu
	        String trangThai = QLBA.getTrangThaiBan("BA" + String.format("%02d", i));
	        if (trangThai != null && trangThai.equals("Đã đặt")) {
	            btn.setBackground(Color.RED);  // Nếu đã đặt, đổi màu đỏ
	            btn.setEnabled(false);  // Khóa nút lại
	        }
			
			panel_table.add(btn);

			int tableId = i;
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Lấy thông tin bàn từ cơ sở dữ liệu
					BanAn banAn = QLBA.getBanAnByTenBan("Bàn " + tableId); // Gọi phương thức lấy thông tin bàn theo mã
																			// bàn
					if (banAn != null) {
						// Hiển thị thông tin bàn lên giao diện
						textField_maban.setText(banAn.getMaBanAn());
						textField_tenban.setText(banAn.getTenBanAn());
						textField_socho.setText(String.valueOf(banAn.getChoNgoi()));
						textField_trangthai.setText(banAn.getTrangThai());
					}
				}
			});
		}

		panel_table.setBorder(new LineBorder(Color.BLACK, 1));

		JLabel lblNewLabel_Table = new JLabel("Danh sách bàn ăn ");
		lblNewLabel_Table.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_Table.setBounds(10, 11, 156, 35);
		jp5.add(lblNewLabel_Table);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(466, 11, 2, 323);
		jp5.add(separator_1_1);

		JLabel lblNewLabel_Table_1 = new JLabel("Thông tin bàn ăn ");
		lblNewLabel_Table_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_Table_1.setBounds(481, 11, 156, 35);
		jp5.add(lblNewLabel_Table_1);

		JLabel lblNewLabel_maban = new JLabel("Mã bàn ");
		lblNewLabel_maban.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_maban.setBounds(496, 66, 80, 35);
		jp5.add(lblNewLabel_maban);

		textField_maban = new JTextField();
		textField_maban.setBounds(627, 68, 142, 28);
		jp5.add(textField_maban);
		textField_maban.setColumns(10);

		JLabel lblNewLabel_tenban = new JLabel("Tên bàn");
		lblNewLabel_tenban.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_tenban.setBounds(496, 133, 80, 35);
		jp5.add(lblNewLabel_tenban);

		textField_tenban = new JTextField();
		textField_tenban.setColumns(10);
		textField_tenban.setBounds(627, 138, 142, 28);
		jp5.add(textField_tenban);

		JLabel lblNewLabel_socho = new JLabel("Số chỗ ");
		lblNewLabel_socho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_socho.setBounds(496, 203, 80, 35);
		jp5.add(lblNewLabel_socho);

		textField_socho = new JTextField();
		textField_socho.setColumns(10);
		textField_socho.setBounds(627, 208, 142, 28);
		jp5.add(textField_socho);

		JLabel lblNewLabel_trangthai = new JLabel("Trạng thái ");
		lblNewLabel_trangthai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_trangthai.setBounds(496, 272, 80, 35);
		jp5.add(lblNewLabel_trangthai);

		textField_trangthai = new JTextField();
		textField_trangthai.setColumns(10);
		textField_trangthai.setBounds(627, 272, 142, 28);
		jp5.add(textField_trangthai);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 362, 846, 2);
		jp5.add(separator_3);

		JLabel lblNewLabel_Table_2 = new JLabel("Thông tin đặt bàn");
		lblNewLabel_Table_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_Table_2.setBounds(10, 375, 156, 35);
		jp5.add(lblNewLabel_Table_2);

		JButton btn_DB1 = new JButton("Đặt bàn");
		btn_DB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maBan = textField_maban.getText();
				if (maBan == null || maBan.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn trước khi đặt bàn!");
					return;
				}
				Guest guest = new Guest(maBan);
				guest.setVisible(true);
				guest.setLocationRelativeTo(null);
				guest.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosed(java.awt.event.WindowEvent windowEvent) {
						// Cập nhật trạng thái bàn
						updateTableStatus(maBan);
					}
				});
			}
		});
		btn_DB1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_DB1.setBounds(496, 318, 107, 33);
		jp5.add(btn_DB1);

		JButton btn_huy = new JButton("Hủy");
		btn_huy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_maban.setText("");
				textField_tenban.setText("");
				textField_socho.setText("");
				textField_trangthai.setText("");
			}
		});
		btn_huy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_huy.setBounds(627, 318, 107, 33);
		jp5.add(btn_huy);
		
		table_ttdb = new JTable();
		table_ttdb.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u1EB7t b\u00E0n", "M\u00E3 b\u00E0n \u0103n", "M\u00E3 kh\u00E1ch h\u00E0ng", "Ng\u00E0y \u0111\u1EB7t", "Tr\u1EA1ng th\u00E1i \u0111\u1EB7t", "M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD t\u00EAn", "S\u1ED1 \u0110T", "\u0110\u1ECBa ch\u1EC9", "Gi\u1EDBi t\u00EDnh"
			}
		));
		
		
		JScrollPane scrollPane_2 = new JScrollPane(table_ttdb);
		scrollPane_2.setBounds(20, 421, 846, 174);
		jp5.add(scrollPane_2);
		
		JButton btn_xem = new JButton("Xem\r\n");
		btn_xem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Lấy thông tin đặt bàn từ cơ sở dữ liệu
		        DatBanDAO datBanDAO = new DatBanDAO();
		        List<Object[]> data = datBanDAO.getThongTinDatBan();

		        // Cập nhật dữ liệu lên JTable
		        DefaultTableModel tableModel = (DefaultTableModel) table_ttdb.getModel();
		        tableModel.setRowCount(0); // Xóa hết dữ liệu cũ trong bảng

		        // Duyệt qua danh sách dữ liệu và thêm vào bảng
		        for (Object[] row : data) {
		            tableModel.addRow(row);
		        }
			}
		});
		btn_xem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_xem.setBounds(759, 318, 107, 33);
		jp5.add(btn_xem);
	}

	public void updateTableStatus(String maBan) {
	    System.out.println("Cập nhật trạng thái cho bàn: " + maBan);

	    // Cập nhật trạng thái trong cơ sở dữ liệu
	    DatBanDAO banDAO = new DatBanDAO();
	    boolean updateSuccess = banDAO.updateBanStatus(maBan, "Đã đặt");

	    if (updateSuccess) {
	        JOptionPane.showMessageDialog(null, "Đặt bàn thành công!");
	        textField_trangthai.setText("Đã đặt");

	        // Cập nhật giao diện: đổi màu và khóa nút bàn
	        int tableNumber = Integer.parseInt(maBan.replace("BA", ""));
	        for (Component comp : panel_table.getComponents()) {
	            if (comp instanceof JButton) {
	                JButton btn = (JButton) comp;
	                if (btn.getText().equals("Bàn " + tableNumber)) {
	                    btn.setBackground(Color.RED);  // Chuyển màu bàn thành đỏ
	                    btn.setEnabled(false);  // Khóa nút bàn
	                    break;
	                }
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Cập nhật trạng thái bàn thất bại!");
	    }
	}

	public void xoaForm() {
		textField_mama.setText("");
		textField_tenma.setText("");
		textField_loaima.setText("");
		textField_gia.setText("");

	}

	public void themHoacCapNhapMonAn(MonAn ma) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow(); // Lấy dòng đang được chọn

		if (selectedRow >= 0) {
			// Người dùng chọn dòng để cập nhật
			String oldMaMon = model_table.getValueAt(selectedRow, 0).toString();

			if (!oldMaMon.equals(ma.getMaMon()) && this.model.kiemTraMaTrung(ma.getMaMon())) {
				// Trường hợp mã mới nhập đã tồn tại và khác mã cũ
				JOptionPane.showMessageDialog(this, "Mã món ăn mới đã tồn tại. Vui lòng nhập mã khác.", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			} else {
				// Cập nhật thông tin món ăn
				this.model.update(ma); // Cập nhật vào database (hoặc mô hình dữ liệu)
				model_table.setValueAt(ma.getMaMon(), selectedRow, 0); // Cập nhật cột mã món
				model_table.setValueAt(ma.getTenMon(), selectedRow, 1); // Cập nhật cột tên món
				model_table.setValueAt(ma.getLoaiMon(), selectedRow, 2); // Cập nhật cột loại món
				model_table.setValueAt(String.valueOf(ma.getGia()), selectedRow, 3); // Cập nhật cột giá

				JOptionPane.showMessageDialog(this, "Cập nhật món ăn thành công!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			// Không có dòng nào được chọn (thêm món ăn mới)
			if (this.model.kiemTraMaTrung(ma.getMaMon())) {
				// Kiểm tra mã món ăn đã tồn tại trong database hay chưa
				JOptionPane.showMessageDialog(this, "Mã món ăn đã tồn tại. Vui lòng nhập mã khác.", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			} else {
				// Thêm mới món ăn vào cơ sở dữ liệu và bảng
				this.model.insert(ma);
				// Thêm vào database (hoặc mô hình dữ liệu)
				model_table.addRow(
						new Object[] { ma.getMaMon(), ma.getTenMon(), ma.getLoaiMon(), String.valueOf(ma.getGia()) });
				JOptionPane.showMessageDialog(this, "Thêm mới món ăn thành công!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

//	if (!this.model.kiemTraMaTrung(ma.getMaMon())) {
//		this.model.insert(ma);
//		model_table.addRow(new Object[] { ma.getMaMon(), ma.getTenMon(), ma.getLoaiMon(), ma.getGia() + "",
//
//		});
//		JOptionPane.showMessageDialog(this, "Thêm mới món ăn thành công!", 
//                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//
//	} else {
////		JOptionPane.showMessageDialog(this, "Mã món ăn đã tồn tại. Vui lòng nhập mã khác.", "Lỗi",
////				JOptionPane.ERROR_MESSAGE);
//		this.model.update(ma);
//		int soLuongDong = model_table.getRowCount();
//		for (int i = 0; i < soLuongDong; i++) {
//			String id = model_table.getValueAt(i, 0) + "";
//			if (id.equals(ma.getMaMon() + "")) {
//				model_table.setValueAt(ma.getMaMon() + "", i, 0);
//				model_table.setValueAt(ma.getTenMon() + "", i, 1);
//				model_table.setValueAt(ma.getLoaiMon() + "", i, 2);
//				model_table.setValueAt(ma.getGia() + "", i, 3);
//			}
//		}
//		JOptionPane.showMessageDialog(this, "Cập nhật món ăn thành công!", 
//                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//
//	}
	public MonAn getMonAnDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		if (i_row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một món ăn từ bảng!");
		}
		String maMon = model_table.getValueAt(i_row, 0) + "";
		String tenMon = model_table.getValueAt(i_row, 1) + "";
		String loaiMon = model_table.getValueAt(i_row, 2) + "";
		float gia = Float.valueOf(model_table.getValueAt(i_row, 3) + "");
		MonAn ma = new MonAn(maMon, tenMon, loaiMon, gia);
		return ma;
	}

	public void hienThiThongTinMonAnDaChon() {
		MonAn ma = getMonAnDangChon();

		this.textField_mama.setText(ma.getMaMon() + "");
		this.textField_tenma.setText(ma.getTenMon() + "");
		this.textField_loaima.setText(ma.getLoaiMon() + "");
		this.textField_gia.setText(ma.getGia() + "");

	}

	public void loadDataToTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa các hàng cũ trong bảng nếu có

		String sql = "SELECT * FROM monan";

		try {
			Connection con = QuanLyNhaHangJDBC.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maMon = rs.getString("maMonAn");
				String tenMon = rs.getString("tenMonAn");
				String loaiMon = rs.getString("loaiMonAn");
				float gia = rs.getFloat("gia");

				model.addRow(new Object[] { maMon, tenMon, loaiMon, gia });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadDataToTable_1(JTable table_1) {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0); // Xóa các hàng cũ trong bảng nếu có

		String sql = "SELECT * FROM monan";

		try {
			Connection con = QuanLyNhaHangJDBC.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maMon = rs.getString("maMonAn");
				String tenMon = rs.getString("tenMonAn");
				String loaiMon = rs.getString("loaiMonAn");
				float gia = rs.getFloat("gia");

				model.addRow(new Object[] { maMon, tenMon, loaiMon, gia });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn ?");
		if (luaChon == JOptionPane.YES_OPTION) {
			MonAn ma = getMonAnDangChon();
			this.model.delete(ma);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemMonAn() {
		// lấy dữ liệu
		String maMon = this.textField_mama.getText();
		String tenMon = this.textField_tenma.getText();
		String loaiMon = this.textField_loaima.getText();
		float gia = Float.valueOf(this.textField_gia.getText());

		MonAn ma = new MonAn(maMon, tenMon, loaiMon, gia);
		this.themHoacCapNhapMonAn(ma);
	}

	public void thucHienTim() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
		// Lấy loại món từ ô nhập liệu
		String loaiMon = textField_timMon.getText().trim();

		// Kiểm tra người dùng đã nhập loại món chưa
		if (loaiMon.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập loại món cần tìm!");
			return;
		}

		try {
			Connection con = QuanLyNhaHangJDBC.getConnection();
			String sql = "SELECT maMonAn, tenMonAn, loaiMonAn, gia FROM monan WHERE loaiMonAn = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loaiMon);

			// Thực hiện truy vấn
			ResultSet rs = pst.executeQuery();

			// Xóa dữ liệu cũ trên bảng
			model.setRowCount(0);

			// Kiểm tra kết quả và hiển thị trên bảng
			boolean hasResults = false;
			while (rs.next()) {
				hasResults = true;
				String maMon = rs.getString("maMonAn");
				String tenMon = rs.getString("tenMonAn");
				String loai = rs.getString("loaiMonAn");
				float gia = rs.getFloat("gia");

				// Thêm dòng mới vào bảng
				model.addRow(new Object[] { maMon, tenMon, loai, gia });
			}

			if (!hasResults) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy món ăn thuộc loại: " + loaiMon);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void thucHienTimTheoGia() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// Lấy giá trị từ ComboBox
		String luaChonGia = (String) comboBox_Gia.getSelectedItem();

		// Kiểm tra giá trị được chọn
		if (luaChonGia == null || luaChonGia.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một tùy chọn giá!");
			return;
		}

		// Xác định điều kiện giá
		String sql = ""; // Câu lệnh SQL
		if (luaChonGia.equals("Món có giá dưới 100k")) {
			sql = "SELECT maMonAn, tenMonAn, loaiMonAn, gia FROM monan WHERE gia < 100000";
		} else if (luaChonGia.equals("Món có giá trên 100k")) {
			sql = "SELECT maMonAn, tenMonAn, loaiMonAn, gia FROM monan WHERE gia > 100000";
		}

		// Kết nối cơ sở dữ liệu và thực hiện truy vấn
		try {
			Connection con = QuanLyNhaHangJDBC.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);

			// Thực thi truy vấn
			ResultSet rs = pst.executeQuery();

			// Xóa dữ liệu cũ trên bảng
			model.setRowCount(0);

			// Hiển thị kết quả
			boolean hasResults = false;
			while (rs.next()) {
				hasResults = true;
				String maMon = rs.getString("maMonAn");
				String tenMon = rs.getString("tenMonAn");
				String loaiMon = rs.getString("loaiMonAn");
				float gia = rs.getFloat("gia");

				// Thêm hàng vào bảng
				model.addRow(new Object[] { maMon, tenMon, loaiMon, gia });
			}

			// Thông báo nếu không tìm thấy
			if (!hasResults) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy món ăn phù hợp với tùy chọn giá.");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi truy vấn cơ sở dữ liệu: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void thucHienHuyTim() {
		// Xóa tất cả các dòng trong bảng
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		// Gọi lại phương thức để tải lại toàn bộ dữ liệu vào bảng
		loadDataToTable(table);
	}

	public ImageIcon getImageForRow(String maMonAn) {
		// Map mã món ăn với đường dẫn ảnh
		switch (maMonAn) {
		case "MA01":
			return new ImageIcon(Main.class.getResource("/view/suonxao.png"));
		case "MA02":
			return new ImageIcon(Main.class.getResource("/view/phobo.png"));
		case "MA03":
			return new ImageIcon(Main.class.getResource("/view/chetraicay.png"));
		case "MA04":
			return new ImageIcon(Main.class.getResource("/view/banhcaramen.png"));
		case "MA05":
			return new ImageIcon(Main.class.getResource("/view/nemran.png"));
		case "MA06":
			return new ImageIcon(Main.class.getResource("/view/hacao.png"));
		case "MA07":
			return new ImageIcon(Main.class.getResource("/view/nomhoachuoi.png"));
		case "MA08":
			return new ImageIcon(Main.class.getResource("/view/chevaihatsen.png"));
		case "MA09":
			return new ImageIcon(Main.class.getResource("/view/cakho.png"));
		case "MA10":
			return new ImageIcon(Main.class.getResource("/view/chuoinuong.png"));
		case "MA11":
			return new ImageIcon(Main.class.getResource("/view/chekhucbach.png"));
		case "MA12":
			return new ImageIcon(Main.class.getResource("/view/kem.png"));
		case "MA13":
			return new ImageIcon(Main.class.getResource("/view/nuocep.png"));
		case "MA14":
			return new ImageIcon(Main.class.getResource("/view/raucaudua.png"));
		case "MA15":
			return new ImageIcon(Main.class.getResource("/view/banhxeo.png"));
		case "MA16":
			return new ImageIcon(Main.class.getResource("/view/banhmy.png"));
		case "MA17":
			return new ImageIcon(Main.class.getResource("/view/banhcuon.png"));
		case "MA18":
			return new ImageIcon(Main.class.getResource("/view/suachua.png"));
		case "MA19":
			return new ImageIcon(Main.class.getResource("/view/boxaorau.png"));
		case "MA20":
			return new ImageIcon(Main.class.getResource("/view/canhchuacaloc.png"));
		case "MA21":
			return new ImageIcon(Main.class.getResource("/view/banhcaramen.png"));
		// Thêm các trường hợp khác nếu có
		default:
			return new ImageIcon(Main.class.getResource("/view/banhbao.png")); // Ảnh mặc định
		}
	}

	private void addTableRowClickListener(JTable table, JLabel lblImage) {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					// Lấy mã món ăn từ dòng được chọn (cột 0)
					String maMonAn = (String) table.getValueAt(selectedRow, 0);
					// Lấy ảnh tương ứng
					ImageIcon icon = getImageForRow(maMonAn);
					// Cập nhật ảnh trên JLabel
					lblImage.setIcon(icon);
				}
			}
		});
	}
}
