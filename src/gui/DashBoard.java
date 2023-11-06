package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DatabaseConnection;
import smallComp.AlertMessagePanel;
import smallComp.UserDetails;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DashBoard frame = new DashBoard();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	JFrame frame;
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
	public DashBoard(String userName,String password) {
		DatabaseConnection db=new DatabaseConnection("myinventory");
		UserDetails userDet=db.GetUserDetails(userName, password);
//		System.out.println(userDet.getName());
		frame=new JFrame();
		frame.setVisible(true);
		frame.setSize(976, 576);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		contentPane = new JPanel();
		frame.getContentPane().add(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 243, SpringLayout.WEST, contentPane);
		panel.setBackground(new Color(0, 0, 139));
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 45, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, panel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Customers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(false);
				tabbedPaneContainer.setVisible(false);
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -331, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, lblNewLabel);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sales");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(false);
				tabbedPaneContainer.setVisible(false);	
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 21, SpringLayout.SOUTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -275, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, lblNewLabel);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Product");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_3, 27, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_3, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, lblNewLabel);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(true);
				tabbedPaneContainer.setVisible(false);	
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("User");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(false);
				tabbedPaneContainer.setVisible(true);	
					
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_4, 12, SpringLayout.SOUTH, btnNewButton_2);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_4, -228, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, lblNewLabel);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnNewButton_4);
		
		productTab = new ProductTab(db,userDet);
		sl_contentPane.putConstraint(SpringLayout.NORTH, productTab, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, productTab, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, productTab, 529, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, productTab, -10, SpringLayout.EAST, contentPane);
		
		JButton btnNewButton_4_1 = new JButton("Suppliers");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_4_1, -381, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 15, SpringLayout.SOUTH, btnNewButton_4_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -16, SpringLayout.NORTH, btnNewButton_4_1);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_4_1, 123, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_4_1, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_4_1, 0, SpringLayout.EAST, lblNewLabel);
		btnNewButton_4_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnNewButton_4_1);
		productTab.setBackground(new Color(51, 51, 51));
		contentPane.add(productTab);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, tabbedPane, 22, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, tabbedPane, 26, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tabbedPane, -23, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tabbedPane, -37, SpringLayout.EAST, contentPane);
		
//		String[] columns= {"id","Full Name","Username","Email","Password","Role"};
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Users", null, scrollPane, null);
		
		table = new JTable();
		table.setModel(db.getUsers(userDet.getEmail()));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add User", null, panel_1, null);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		addUsernameField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, addUsernameField, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, addUsernameField, -326, SpringLayout.SOUTH, panel_1);
		panel_1.add(addUsernameField);
		addUsernameField.setColumns(10);
		
		AddEmailField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, AddEmailField, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, AddEmailField, -259, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, AddEmailField, -23, SpringLayout.EAST, panel_1);
		panel_1.add(AddEmailField);
		AddEmailField.setColumns(10);
		
		AddPasswordField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, AddPasswordField, 0, SpringLayout.WEST, addUsernameField);
		sl_panel_1.putConstraint(SpringLayout.EAST, AddPasswordField, -23, SpringLayout.EAST, panel_1);
		panel_1.add(AddPasswordField);
		AddPasswordField.setColumns(10);
		
		addNameField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, addNameField, -33, SpringLayout.NORTH, AddEmailField);
		sl_panel_1.putConstraint(SpringLayout.EAST, addUsernameField, -54, SpringLayout.WEST, addNameField);
		sl_panel_1.putConstraint(SpringLayout.EAST, addNameField, -23, SpringLayout.EAST, panel_1);
		panel_1.add(addNameField);
		addNameField.setColumns(10);
		
		JRadioButton rad1 = new JRadioButton("admin");
		sl_panel_1.putConstraint(SpringLayout.WEST, rad1, 0, SpringLayout.WEST, addUsernameField);
		rad1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(rad1);
		
		
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rad1);
		
		JRadioButton rad2 = new JRadioButton("user");
		sl_panel_1.putConstraint(SpringLayout.NORTH, rad2, 0, SpringLayout.NORTH, rad1);
		sl_panel_1.putConstraint(SpringLayout.WEST, rad2, 16, SpringLayout.EAST, rad1);
		sl_panel_1.putConstraint(SpringLayout.EAST, rad2, -526, SpringLayout.EAST, panel_1);
		rad2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(rad2);
		bg.add(rad2);
		
		JButton btnNewButton_5 = new JButton("Add User");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton_5, -112, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton_5, 193, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnNewButton_5, -68, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton_5, -231, SpringLayout.EAST, panel_1);
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
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -370, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, addUsernameField, 10, SpringLayout.SOUTH, lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		sl_panel_1.putConstraint(SpringLayout.NORTH, addNameField, 10, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, addNameField, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 291, SpringLayout.EAST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL");
		sl_panel_1.putConstraint(SpringLayout.NORTH, AddEmailField, 6, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 12, SpringLayout.SOUTH, addUsernameField);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, addUsernameField);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD");
		sl_panel_1.putConstraint(SpringLayout.NORTH, AddPasswordField, 6, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4, -587, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 6, SpringLayout.SOUTH, AddEmailField);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, addUsernameField);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ROLE");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 300, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, AddPasswordField, -16, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel_1.putConstraint(SpringLayout.NORTH, rad1, 6, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, addUsernameField);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -167, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_5, -621, SpringLayout.EAST, panel_1);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Change user", null, panel_2, null);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		sl_panel_2.putConstraint(SpringLayout.NORTH, scrollPane_1, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, scrollPane_1, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, scrollPane_1, 345, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, scrollPane_1, 407, SpringLayout.WEST, panel_2);
		panel_2.add(scrollPane_1);
		
		userEditTable = new JTable();
		scrollPane_1.setViewportView(userEditTable);
		userEditTable.setModel(db.getUsers(userDet.getEmail()));
		
		JButton btnNewButton_6 = new JButton("UPDATE");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_6, 24, SpringLayout.SOUTH, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_6, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnNewButton_6, 74, SpringLayout.SOUTH, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnNewButton_6, 192, SpringLayout.WEST, panel_2);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("DELETE");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_7, 24, SpringLayout.SOUTH, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_7, 19, SpringLayout.EAST, btnNewButton_6);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnNewButton_7, 74, SpringLayout.SOUTH, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnNewButton_7, -295, SpringLayout.EAST, panel_2);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnNewButton_7);
		
		EditEmpId = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, EditEmpId, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditEmpId, -10, SpringLayout.EAST, panel_2);
		panel_2.add(EditEmpId);
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
				panel_2.revalidate();
			}
		});
		
		EditEmpName = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, EditEmpName, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditEmpName, -10, SpringLayout.EAST, panel_2);
		panel_2.add(EditEmpName);
		EditEmpName.setColumns(10);
		
		EditEmpUsername = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, EditEmpUsername, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditEmpUsername, -10, SpringLayout.EAST, panel_2);
		panel_2.add(EditEmpUsername);
		EditEmpUsername.setColumns(10);
		
		EditEmpEmail = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, EditEmpEmail, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditEmpEmail, -10, SpringLayout.EAST, panel_2);
		panel_2.add(EditEmpEmail);
		EditEmpEmail.setColumns(10);
		
		EditEmpPassword = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, EditEmpPassword, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditEmpPassword, -10, SpringLayout.EAST, panel_2);
		panel_2.add(EditEmpPassword);
		EditEmpPassword.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("EMP ID");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 11, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_6, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_6, -230, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditEmpId, 6, SpringLayout.SOUTH, lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("NAME");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_7, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditEmpId, -6, SpringLayout.NORTH, lblNewLabel_7);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 47, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditEmpName, 6, SpringLayout.SOUTH, lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("USERNAME");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_8, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditEmpUsername, 6, SpringLayout.SOUTH, lblNewLabel_8);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 135, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditEmpName, -6, SpringLayout.NORTH, lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("EMAIL");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_9, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditEmpEmail, 6, SpringLayout.SOUTH, lblNewLabel_9);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 197, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditEmpUsername, -6, SpringLayout.NORTH, lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("PASSWORD");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_10, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_10, -192, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditEmpPassword, 6, SpringLayout.SOUTH, lblNewLabel_10);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 259, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditEmpEmail, -6, SpringLayout.NORTH, lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_10);
		
		JSeparator separator = new JSeparator();
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditEmpPassword, -39, SpringLayout.NORTH, separator);
		sl_panel_2.putConstraint(SpringLayout.NORTH, separator, 354, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, separator, -126, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, separator, -62, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, separator, -194, SpringLayout.EAST, panel_2);
		panel_2.add(separator);
		
		
		tabbedPaneContainer = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tabbedPaneContainer, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, tabbedPaneContainer, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tabbedPaneContainer, 0, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, tabbedPaneContainer, 709, SpringLayout.EAST, panel);
		tabbedPaneContainer.add(tabbedPane);
		tabbedPaneContainer.setVisible(false);							
		contentPane.add(tabbedPaneContainer);
		
		SpringLayout sl_tabbedPaneContainer = new SpringLayout();
		sl_tabbedPaneContainer.putConstraint(SpringLayout.NORTH, tabbedPane, 10, SpringLayout.NORTH, tabbedPaneContainer);
		sl_tabbedPaneContainer.putConstraint(SpringLayout.WEST, tabbedPane, 10, SpringLayout.WEST, tabbedPaneContainer);
		sl_tabbedPaneContainer.putConstraint(SpringLayout.SOUTH, tabbedPane, -10, SpringLayout.SOUTH, tabbedPaneContainer);
		sl_tabbedPaneContainer.putConstraint(SpringLayout.EAST, tabbedPane, 0, SpringLayout.EAST, tabbedPaneContainer);
		tabbedPaneContainer.setLayout(sl_tabbedPaneContainer);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
