package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.QuanLyNhaHangJDBC;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Email;
	private JPasswordField passwordField_Password;

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

	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(800,500);
		this.setTitle("Login");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		URL urlIcon = Login.class.getResource("restaurant (3).png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);
		
		JPanel panel_left = new JPanel();
		panel_left.setBackground(new Color(51, 153, 204));
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
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(51, 153, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(138, 11, 151, 80);
		panel_right.add(lblNewLabel);
		
		JLabel lblNewLabel_Email = new JLabel("Email");
		lblNewLabel_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Email.setBounds(24, 109, 76, 28);
		panel_right.add(lblNewLabel_Email);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(24, 148, 336, 34);
		panel_right.add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblNewLabel_Password = new JLabel("Password");
		lblNewLabel_Password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Password.setBounds(24, 208, 76, 28);
		panel_right.add(lblNewLabel_Password);
		
		passwordField_Password = new JPasswordField();
		passwordField_Password.setBounds(24, 247, 336, 34);
		panel_right.add(passwordField_Password);
		
		JButton btn_Login = new JButton("Login");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = QuanLyNhaHangJDBC.getConnection();
					
					String hashedPassword = hashPassword(passwordField_Password.getText());

					String sql = "SELECT * FROM taikhoan WHERE email = ? and password = ?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, textField_Email.getText());
					pst.setString(2, hashedPassword);// trả về đối tượng khi nhận câu lệnh select
					ResultSet rs;
					rs = pst.executeQuery();
					
					if(textField_Email.getText().equals("")|passwordField_Password.getText().equals("")) {
						JOptionPane.showMessageDialog(Login.this, "Vui lòng nhập thông tin ");
					}else if (!textField_Email.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
						JOptionPane.showMessageDialog(Login.this, "Email không hợp lệ. Vui lòng nhập đúng định dạng email.");
						textField_Email.setText("");
					}
					
					// Kiểm tra ký tự không hợp lệ bằng regex
					else if (!passwordField_Password.getText().matches("[a-zA-Z0-9]+")) {
						JOptionPane.showMessageDialog(Login.this,
								"Mật khẩu chỉ được chứa ký tự chữ và số");
					}// Kiểm tra độ dài tối thiểu
					else if (textField_Email.getText().length() < 8 || passwordField_Password.getText().length() < 8) {
						JOptionPane.showMessageDialog(Login.this, "Tên đăng nhập và mật khẩu phải có ít nhất 8 ký tự");
					}
					
					else if(rs.next()) {
						JOptionPane.showMessageDialog(Login.this, "Đăng nhập thành công" );
						Main main_frame = new Main();
						main_frame.setVisible(true);
						main_frame.setLocationRelativeTo(null);
						Login.this.dispose();

						
					}else {
						JOptionPane.showMessageDialog(Login.this, "Đăng nhập thất bại");
						textField_Email.setText("");
						passwordField_Password.setText("");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btn_Login.setForeground(new Color(255, 255, 255));
		btn_Login.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Login.setBounds(24, 315, 103, 41);
		btn_Login.setBackground(new Color(51, 153, 204));
		btn_Login.setOpaque(true);
		btn_Login.setContentAreaFilled(true); // Đảm bảo vùng nền được bật
		btn_Login.setBorderPainted(false); // Bỏ viền của nút nếu không muốn viền
		panel_right.add(btn_Login);
		
		JLabel lblNewLabel_1 = new JLabel("I don't have an account");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(24, 378, 178, 41);
		panel_right.add(lblNewLabel_1);
		
		JButton btn_SignUp = new JButton("Sign Up\r\n");
		btn_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp_frame = new SignUp();
				signUp_frame.setVisible(true);
				signUp_frame.pack();
				Login.this.dispose();
			}
		});
		
		btn_SignUp.setOpaque(true);
		btn_SignUp.setForeground(Color.WHITE);
		btn_SignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_SignUp.setContentAreaFilled(true);
		btn_SignUp.setBorderPainted(false);
		btn_SignUp.setBackground(new Color(51, 153, 204));
		btn_SignUp.setBounds(212, 377, 121, 41);
		panel_right.add(btn_SignUp);
		
		
	}
}
