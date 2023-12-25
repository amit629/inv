package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import database.DatabaseConnection;
import smallComp.AlertMessagePanel;
import smallComp.UserDetails;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customers extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable CustomerTable;
	private JTextField CustomerMobileField;
	private JTextField CustomerNameField;
	private JTextField CustomerEmailField;

	/**
	 * Create the panel.
	 */
	public Customers(DatabaseConnection db,UserDetails userDet) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 705, 474);
		add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Customers", null, scrollPane, null);
		
		CustomerTable = new JTable();
		CustomerTable.setModel(db.getCustomers());
		scrollPane.setViewportView(CustomerTable);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Customers", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Customer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(218, 10, 226, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cutomer Mobile");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(41, 80, 96, 26);
		panel.add(lblNewLabel_1);
		
		CustomerMobileField = new JTextField();
		CustomerMobileField.setBounds(41, 116, 293, 36);
		panel.add(CustomerMobileField);
		CustomerMobileField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cutomer Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(373, 80, 96, 26);
		panel.add(lblNewLabel_2);
		
		CustomerNameField = new JTextField();
		CustomerNameField.setBounds(373, 116, 293, 36);
		panel.add(CustomerNameField);
		CustomerNameField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Email");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(41, 194, 105, 26);
		panel.add(lblNewLabel_3);
		
		CustomerEmailField = new JTextField();
		CustomerEmailField.setBounds(41, 230, 625, 36);
		panel.add(CustomerEmailField);
		CustomerEmailField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mobileNo=CustomerMobileField.getText();
				String name=CustomerNameField.getText();
				String Email=CustomerEmailField.getText();
				if(mobileNo.length()==0 || name.length()==0 || Email.length()==0) {
					new AlertMessagePanel("fill all fields");
				}else {
					boolean check=db.addCustomer(mobileNo, name, Email);
					if(check==true) {
						CustomerTable.setModel(db.getCustomers());
						CustomerMobileField.setText("");
						CustomerNameField.setText("");
						CustomerEmailField.setText("");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(249, 318, 195, 42);
		panel.add(btnNewButton);

	}
}
