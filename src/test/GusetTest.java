package test;

import javax.swing.UIManager;

import view.Guest;



public class GusetTest {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Guest guest = new Guest();
			guest.setVisible(true);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
