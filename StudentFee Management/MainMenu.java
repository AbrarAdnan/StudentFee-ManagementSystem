import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLogin.main(new String[] {});
			}
		});
		btnAdminLogin.setBounds(140, 58, 118, 23);
		frame.getContentPane().add(btnAdminLogin);
		
		try {
			Statement stmt=DBConnection.getConnection().createStatement();
			stmt.executeUpdate("use masum;");
			//stmt.executeUpdate("create table studentinfo (ID varchar(10),name varchar(20),paid varchar(20), amountToPay varchar(20) ,dues varchar(20));");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNormalLogin = new JButton("Normal Login");
		btnNormalLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SearchInfo.main(new String[] {});
			}
		});
		btnNormalLogin.setBounds(140, 141, 118, 23);
		frame.getContentPane().add(btnNormalLogin);
	}

}
