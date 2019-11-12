import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin {

	private JFrame frame;
	private JTextField nameField;
	private JTextField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(53, 63, 72, 31);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(53, 125, 72, 31);
		frame.getContentPane().add(lblPassword);
		
		nameField = new JTextField();
		nameField.setBounds(153, 68, 127, 26);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(153, 130, 127, 26);
		frame.getContentPane().add(passField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=nameField.getText(),pass=passField.getText();
				if((name.equals("Adnan"))&&(pass.equals("1234"))) {
					frame.dispose();
					AdminPanel.main(new String[] {});
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Name or Pass, please try again","Alert!",JOptionPane.PLAIN_MESSAGE);

				}
			}
		});
		btnLogin.setBounds(238, 194, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu.main(new String[] {});
			}
		});
		btnBack.setBounds(53, 194, 89, 23);
		frame.getContentPane().add(btnBack);
	}

}
