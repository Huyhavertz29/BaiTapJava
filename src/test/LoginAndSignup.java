package test;

import javax.swing.UIManager;

import view.Login;

public class LoginAndSignup {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Login loginFrame = new Login();
			loginFrame.setVisible(true);
			loginFrame.setLocationRelativeTo(null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
