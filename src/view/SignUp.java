package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.QuanLyNhaHangJDBC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Email;
	private JTextField textField_Password;
	private JTextField textField_RPassword;
	private JComponent btn_Login;
	private JTextField textField_Fullname;

	private static String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(password.getBytes());
		StringBuilder hexString = new StringBuilder();

		for (byte b : hash) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

	public SignUp() {

		setPreferredSize(new Dimension(800, 500));
		this.setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		URL urlIcon = SignUp.class.getResource("restaurant (3).png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);

		JPanel panel_left = new JPanel();
		panel_left.setBackground(new Color(51, 153, 204));
		panel_left.setPreferredSize(new Dimension(400, 500));
		panel_left.setBounds(0, 0, 400, 463);
		contentPane.add(panel_left);
		panel_left.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/view/restaurant (1).png")));
		lblNewLabel_2.setBounds(68, 36, 256, 323);
		panel_left.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("NICOLAS JACKSON\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(55, 356, 307, 50);
		panel_left.add(lblNewLabel_3);

		JPanel panel_right = new JPanel();
		panel_right.setBounds(399, 0, 387, 463);
		contentPane.add(panel_right);
		panel_right.setLayout(null);

		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setForeground(new Color(51, 153, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(138, 11, 151, 80);
		panel_right.add(lblNewLabel);

		JLabel lblNewLabel_Email = new JLabel("Email");
		lblNewLabel_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Email.setBounds(24, 71, 76, 28);
		panel_right.add(lblNewLabel_Email);

		textField_Email = new JTextField();
		textField_Email.setBounds(24, 102, 336, 34);
		panel_right.add(textField_Email);
		textField_Email.setColumns(10);

		JLabel lblNewLabel_Password = new JLabel("Password\r\n");
		lblNewLabel_Password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Password.setBounds(24, 147, 76, 28);
		panel_right.add(lblNewLabel_Password);

		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(24, 175, 336, 34);
		panel_right.add(textField_Password);

		JLabel lblNewLabel_RPassword = new JLabel("Repeat Password\r\n");
		lblNewLabel_RPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_RPassword.setBounds(24, 220, 140, 28);
		panel_right.add(lblNewLabel_RPassword);

		textField_RPassword = new JTextField();
		textField_RPassword.setColumns(10);
		textField_RPassword.setBounds(24, 247, 336, 34);
		panel_right.add(textField_RPassword);

		JButton btn_SignUp = new JButton("Sign Up\r\n");
		btn_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dk = JOptionPane.showConfirmDialog(SignUp.this, "Bạn có muốn đăng ký", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (dk != JOptionPane.YES_OPTION) {
					return;
				}
				try {
					if (textField_Email.getText().equals("") | textField_Password.getText().equals("")
							| textField_RPassword.getText().equals("")|textField_Fullname.getText().equals("")) {
						JOptionPane.showMessageDialog(SignUp.this, "Vui lòng nhập thông tin");
					}else if (!textField_Email.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
					    JOptionPane.showMessageDialog(SignUp.this, "Email không hợp lệ. Vui lòng nhập đúng định dạng email.");
					    textField_Email.setText("");
					}
					// Kiểm tra ký tự không hợp lệ bằng regex
					else if (!textField_Password.getText().matches("[a-zA-Z0-9]+")) {
						JOptionPane.showMessageDialog(SignUp.this,
								"Mật khẩu chỉ được chứa ký tự chữ và số");
					}
					// Kiểm tra độ dài tối thiểu
					else if (textField_Email.getText().length() < 8 || textField_Password.getText().length() < 8) {
						JOptionPane.showMessageDialog(SignUp.this, "Email và mật khẩu phải có ít nhất 8 ký tự");
					}else if (!textField_Password.getText().equals(textField_RPassword.getText())) {
						JOptionPane.showMessageDialog(SignUp.this, "Mật khẩu và mật khẩu xác nhận không giống nhau");
						textField_RPassword.setText("");
					}else {
						Connection con = QuanLyNhaHangJDBC.getConnection();
						String checkUsernameSql = "SELECT COUNT(*) FROM taikhoan WHERE email = ?";
						PreparedStatement checkPst = con.prepareStatement(checkUsernameSql);
						checkPst.setString(1, textField_Email.getText());
						ResultSet rs = checkPst.executeQuery();

						if (rs.next() && rs.getInt(1) > 0) {
							JOptionPane.showMessageDialog(SignUp.this,
									"Email đã tồn tại. Vui lòng chọn email khác.");
							textField_Email.setText("");

						} else {

							// Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
							String hashedPassword = hashPassword(textField_Password.getText());

							// Thêm dữ liệu vào sql
							String sql = "insert into taikhoan values(?,?,?)";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setString(1, textField_Email.getText());
							pst.setString(2, hashedPassword);
							pst.setString(3, textField_Fullname.getText());

							int n = pst.executeUpdate();
							if (n != 0) {
								JOptionPane.showMessageDialog(SignUp.this, "Đăng ký thành công");
								textField_Email.setText("");
								textField_Password.setText("");
								textField_RPassword.setText("");
								textField_Fullname.setText("");
							} else {
								JOptionPane.showMessageDialog(SignUp.this, "Đăng ký thất bại");
							}
						}

					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		btn_SignUp.setForeground(new Color(255, 255, 255));
		btn_SignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_SignUp.setBounds(24, 359, 103, 41);
		btn_SignUp.setBackground(new Color(51, 153, 204));
		btn_SignUp.setOpaque(true);
		btn_SignUp.setContentAreaFilled(true); // Đảm bảo vùng nền được bật
		btn_SignUp.setBorderPainted(false); // Bỏ viền của nút nếu không muốn viền
		panel_right.add(btn_SignUp);

		JLabel lblNewLabel_1 = new JLabel("I've an account");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(24, 411, 118, 41);
		panel_right.add(lblNewLabel_1);

		JButton btn_LoginS = new JButton("Login\r\n");
		btn_LoginS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login_frame = new Login();
				login_frame.setVisible(true);
				login_frame.setLocationRelativeTo(null);
				SignUp.this.dispose();

			}
		});
		btn_LoginS.setOpaque(true);
		btn_LoginS.setForeground(Color.WHITE);
		btn_LoginS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_LoginS.setContentAreaFilled(true);
		btn_LoginS.setBorderPainted(false);
		btn_LoginS.setBackground(new Color(51, 153, 204));
		btn_LoginS.setBounds(152, 410, 103, 40);
		panel_right.add(btn_LoginS);
		
		JLabel lblNewLabel_Fullname = new JLabel("Full name");
		lblNewLabel_Fullname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Fullname.setBounds(24, 292, 76, 14);
		panel_right.add(lblNewLabel_Fullname);
		
		textField_Fullname = new JTextField();
		textField_Fullname.setColumns(10);
		textField_Fullname.setBounds(24, 314, 336, 34);
		panel_right.add(textField_Fullname);

	}
}
