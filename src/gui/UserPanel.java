package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import database.DatabaseConnection;
import smallComp.AlertMessagePanel;
import smallComp.UserDetails;

public class UserPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField addUsernameField;
	private JTextField AddEmailField;
	private JTextField AddPasswordField;
	private JTextField addNameField;
	private JTable userEditTable;
	private JTextField EditEmpId;
	private JTextField EditEmpName;
	private JTextField EditEmpUsername;
	private JTextField EditEmpEmail;
	private JTextField EditEmpPassword;
	private ProductTab productTab;
	private JPanel tabbedPaneContainer;
	
	public UserPanel(DatabaseConnection db,UserDetails userDet) {
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 10, 687, 499);
		
//		String[] columns= {"id","Full Name","Username","Email","Password","Role"};
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Users", null, scrollPane, null);
		
		table = new JTable();
		table.setModel(db.getUsers(userDet.getEmail()));
		scrollPane.setViewportView(table);
		
		JPanel pp1 = new JPanel();
		tabbedPane.addTab("Add User", null, pp1, null);
		pp1.setLayout(null);
		
		addUsernameField = new JTextField();
		addUsernameField.setBounds(20, 55, 307, 34);
		pp1.add(addUsernameField);
		addUsernameField.setColumns(10);
		
		AddEmailField = new JTextField();
		AddEmailField.setBounds(20, 135, 651, 34);
		pp1.add(AddEmailField);
		AddEmailField.setColumns(10);
		
		AddPasswordField = new JTextField();
		AddPasswordField.setBounds(20, 204, 651, 34);
		pp1.add(AddPasswordField);
		AddPasswordField.setColumns(10);
		
		addNameField = new JTextField();
		addNameField.setBounds(371, 55, 290, 34);
		pp1.add(addNameField);
		addNameField.setColumns(10);
		
		JRadioButton rad1 = new JRadioButton("admin");
		rad1.setBounds(10, 269, 61, 25);
		rad1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pp1.add(rad1);
		
		
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rad1);
		
		JRadioButton rad2 = new JRadioButton("user");
		rad2.setBounds(73, 269, 71, 25);
		rad2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pp1.add(rad2);
		bg.add(rad2);
		
		JButton btnNewButton_5 = new JButton("Add User");
		btnNewButton_5.setBounds(185, 308, 260, 44);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=addUsernameField.getText();
				String name=addNameField.getText();
				String email=AddEmailField.getText();
				String password=AddPasswordField.getText();
				boolean admin=rad1.isSelected();
				boolean user=rad2.isSelected();
				if(username.length()==0 || name.length()==0 || email.length()==0 || password.length()==0) {
					new AlertMessagePanel("Fill all the fields");
				}
				else {
					boolean resp=db.addUser(userDet.getEmail(), name, username, email, password, admin);
					if(resp) {
						table.setModel(db.getUsers(userDet.getEmail()));
						userEditTable.setModel(db.getUsers(userDet.getEmail()));
						addUsernameField.setText("");
						addNameField.setText("");
						AddEmailField.setText("");
						AddPasswordField.setText("");
						rad1.setSelected(false);
						rad2.setSelected(false);
						
						tabbedPane.revalidate();
						
					}
				}
			}
		});
		btnNewButton_5.setBorder(new LineBorder(new Color(0, 0, 205), 3, true));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pp1.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(10, 30, 70, 15);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(361, 30, 38, 15);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL");
		lblNewLabel_3.setBounds(10, 110, 42, 15);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD");
		lblNewLabel_4.setBounds(10, 179, 87, 15);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ROLE");
		lblNewLabel_5.setBounds(10, 248, 53, 15);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp1.add(lblNewLabel_5);
		
		JPanel pp2 = new JPanel();
		tabbedPane.addTab("Change user", null, pp2, null);
		pp2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 397, 335);
		pp2.add(scrollPane_1);
		
		userEditTable = new JTable();
		scrollPane_1.setViewportView(userEditTable);
		userEditTable.setModel(db.getUsers(userDet.getEmail()));
		
		JButton btnNewButton_6 = new JButton("UPDATE");
		btnNewButton_6.setBounds(10, 369, 182, 50);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pp2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("DELETE");
		btnNewButton_7.setBounds(211, 369, 178, 50);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pp2.add(btnNewButton_7);
		
		EditEmpId = new JTextField();
		EditEmpId.setBounds(413, 32, 261, 35);
		pp2.add(EditEmpId);
		EditEmpId.setColumns(10);
		EditEmpId.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(event);
				UserDetails ud=db.getSingleUserDetails(userDet.getEmail(),EditEmpId.getText());
				if(ud.getEmail().length()==0) {
					new AlertMessagePanel("User Dont't Exist");
					EditEmpName.setText("");
					EditEmpUsername.setText("");
					EditEmpEmail.setText("");
					EditEmpPassword.setText("");
				}else {
					EditEmpName.setText(ud.getName());
					EditEmpUsername.setText(ud.getUsername());
					EditEmpEmail.setText(ud.getEmail());
					EditEmpPassword.setText(ud.getPassword());
					
					
				}
				pp2.revalidate();
			}
		});
		
		EditEmpName = new JTextField();
		EditEmpName.setBounds(413, 94, 261, 35);
		pp2.add(EditEmpName);
		EditEmpName.setColumns(10);
		
		EditEmpUsername = new JTextField();
		EditEmpUsername.setBounds(413, 156, 261, 35);
		pp2.add(EditEmpUsername);
		EditEmpUsername.setColumns(10);
		
		EditEmpEmail = new JTextField();
		EditEmpEmail.setBounds(413, 218, 261, 35);
		pp2.add(EditEmpEmail);
		EditEmpEmail.setColumns(10);
		
		EditEmpPassword = new JTextField();
		EditEmpPassword.setBounds(413, 280, 261, 35);
		pp2.add(EditEmpPassword);
		EditEmpPassword.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("EMP ID");
		lblNewLabel_6.setBounds(413, 11, 41, 15);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("NAME");
		lblNewLabel_7.setBounds(413, 73, 38, 15);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("USERNAME");
		lblNewLabel_8.setBounds(413, 135, 70, 15);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("EMAIL");
		lblNewLabel_9.setBounds(413, 197, 42, 15);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("PASSWORD");
		lblNewLabel_10.setBounds(413, 259, 79, 15);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pp2.add(lblNewLabel_10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(622, 354, -132, -8);
		pp2.add(separator);
		
		
		
//		tabbedPaneContainer.setLayout(null);
								
	}

}
