import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EditInfo {

	private JFrame frame;
	private JTextField textID;
	private JTextField textName;
	private JTextField textPaid;
	private JTextField txtAmountToPay;
	private JTextField textDues;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditInfo window = new EditInfo();
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
	public EditInfo() {
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
		
		textID = new JTextField();
		textID.setBounds(80, 24, 234, 33);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 24, 60, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=textID.getText(),name=textName.getText(),amountToPay=txtAmountToPay.getText(),paid=textPaid.getText(),due=textDues.getText();
				
				Statement stmt;
				try {
					stmt = DBConnection.getConnection().createStatement();
					stmt.executeUpdate("use masum");
					ResultSet rs=stmt.executeQuery("select * from studentinfo where id='"+textID.getText()+"'");
					if(rs.next()) {
						textID.setText(rs.getString("ID"));
						textName.setText(rs.getString("name"));
						txtAmountToPay.setText(rs.getString("amountToPay"));
						textPaid.setText(rs.getString("Paid"));
						textDues.setText(rs.getString("Dues"));
						
					}
					
					else
						JOptionPane.showMessageDialog(null, "Not FOund");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSearch.setBounds(324, 29, 100, 23);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 68, 60, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setBounds(80, 71, 234, 33);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPaid = new JTextField();
		textPaid.setColumns(10);
		textPaid.setBounds(136, 121, 178, 33);
		frame.getContentPane().add(textPaid);
		
		JLabel lblDues = new JLabel("Paid");
		lblDues.setBounds(10, 118, 89, 39);
		frame.getContentPane().add(lblDues);
		
		txtAmountToPay = new JTextField();
		txtAmountToPay.setColumns(10);
		txtAmountToPay.setBounds(136, 168, 178, 33);
		frame.getContentPane().add(txtAmountToPay);
		
		JLabel lblAmountToPay = new JLabel("Amount to pay");
		lblAmountToPay.setBounds(10, 165, 116, 39);
		frame.getContentPane().add(lblAmountToPay);
		
		textDues = new JTextField();
		textDues.setColumns(10);
		textDues.setBounds(80, 214, 234, 33);
		frame.getContentPane().add(textDues);
		
		JLabel lblDues_1 = new JLabel("Dues");
		lblDues_1.setBounds(10, 211, 60, 39);
		frame.getContentPane().add(lblDues_1);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu.main(new String[] {});
			}
		});
		btnMainMenu.setBounds(324, 219, 100, 23);
		frame.getContentPane().add(btnMainMenu);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=textID.getText(),name=textName.getText(),amountToPay=txtAmountToPay.getText(),paid=textPaid.getText(),due=textDues.getText();
				Statement stmt;
				try {
					stmt = DBConnection.getConnection().createStatement();
					stmt.executeUpdate("use masum");
					stmt.executeUpdate("DELETE from studentinfo where id = '"+textID.getText()+"'");
					stmt.executeUpdate("insert into studentinfo values('"+ID+"','"+name+"','"+amountToPay+"','"+paid+"','"+due+"')");

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnEdit.setBounds(324, 173, 100, 23);
		frame.getContentPane().add(btnEdit);
	}
}
