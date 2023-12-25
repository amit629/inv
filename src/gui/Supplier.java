package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import database.DatabaseConnection;
import smallComp.AlertMessagePanel;
import smallComp.SupplierInfo;
import smallComp.UserDetails;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Supplier extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable SupplierTable;
	private JTextField SupplierName;
	private JTextField SupplierPhone;
	private JTextField SupplierEmail;
	private JComboBox SupplierPaymentTerms;
	private JTable table;
	private JTextField AssignSupPName;
	private JTextField AssignSupName;

	/**
	 * Create the panel.
	 */
	public Supplier(DatabaseConnection db,UserDetails userDet) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 21, 1112, 633);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Supplier", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 488, 597);
		panel.add(scrollPane);
		
		SupplierTable = new JTable();
		scrollPane.setViewportView(SupplierTable);
		SupplierTable.setModel(db.getsupplierTableData());
		
		JLabel lblNewLabel = new JLabel("Add Supplier");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(578, 10, 453, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(534, 85, 120, 27);
		panel.add(lblNewLabel_1);
		
		SupplierName = new JTextField();
		SupplierName.setBounds(534, 122, 541, 43);
		panel.add(SupplierName);
		SupplierName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(534, 187, 120, 27);
		panel.add(lblNewLabel_2);
		
		SupplierPhone = new JTextField();
		SupplierPhone.setBounds(534, 224, 541, 41);
		panel.add(SupplierPhone);
		SupplierPhone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(534, 275, 120, 27);
		panel.add(lblNewLabel_3);
		
		SupplierEmail = new JTextField();
		SupplierEmail.setBounds(534, 304, 541, 43);
		panel.add(SupplierEmail);
		SupplierEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Payment Terms");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(534, 357, 120, 27);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String supName=SupplierName.getText();
				String supPhone=SupplierPhone.getText();
				String supEmail=SupplierEmail.getText();
				String supTerms=SupplierPaymentTerms.getSelectedItem().toString();
				
				if(supName.length()!=0 && supPhone.length()!=0 && supEmail.length()!=0 && supTerms.length()!=0) {
					boolean check=db.addSupplier(new SupplierInfo(supName,supPhone,supEmail,supTerms));
					
					if(check) {
						SupplierName.setText("");
						SupplierPhone.setText("");
						SupplierEmail.setText("");
						SupplierPaymentTerms.setSelectedItem("");
						SupplierTable.setModel(db.getsupplierTableData());
					}
					
				}else {
					new AlertMessagePanel("Fill All Fields");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(675, 469, 217, 43);
		panel.add(btnNewButton);
		
		SupplierPaymentTerms = new JComboBox(new String[] {"cod","line of credit","advance payment","payment schedules"});
		SupplierPaymentTerms.setBounds(534, 394, 541, 43);
		panel.add(SupplierPaymentTerms);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Assign Supliers", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Assign Products Supplier");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel_5.setBounds(498, 10, 599, 55);
		panel_1.add(lblNewLabel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 475, 597);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(db.getAssingProductSupplier());
		
		JLabel lblNewLabel_6 = new JLabel("Product Id");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(498, 88, 100, 26);
		panel_1.add(lblNewLabel_6);
		
		JComboBox AssignSupPId = new JComboBox();
		AssignSupPId.setBounds(498, 124, 599, 35);
		panel_1.add(AssignSupPId);
		AssignSupPId.setModel(new DefaultComboBoxModel(db.getAllProductId()));
		AssignSupPId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem=Integer.parseInt(AssignSupPId.getSelectedItem().toString());
				AssignSupPName.setText(db.getProductData(selectedItem).getName());
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("Product Name");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(498, 169, 100, 26);
		panel_1.add(lblNewLabel_7);
		
		AssignSupPName = new JTextField();
		AssignSupPName.setBounds(498, 200, 599, 35);
		panel_1.add(AssignSupPName);
		AssignSupPName.setColumns(10);
		AssignSupPName.setEnabled(false);
		
		JLabel lblNewLabel_8 = new JLabel("Supplier Id");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_8.setBounds(498, 245, 109, 26);
		panel_1.add(lblNewLabel_8);
		
		JComboBox AssingSupId = new JComboBox();
		AssingSupId.setBounds(498, 281, 599, 35);
		panel_1.add(AssingSupId);
		AssingSupId.setModel(new DefaultComboBoxModel(db.getAllSuppliersId()));
		AssingSupId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem=Integer.parseInt(AssingSupId.getSelectedItem().toString());
				AssignSupName.setText(db.getSuppById(selectedItem).getName());
			}
		});
		
		JLabel lblNewLabel_9 = new JLabel("Supplier Name");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9.setBounds(498, 339, 100, 26);
		panel_1.add(lblNewLabel_9);
		
		AssignSupName = new JTextField();
		AssignSupName.setBounds(498, 375, 599, 35);
		panel_1.add(AssignSupName);
		AssignSupName.setColumns(10);
		AssignSupName.setEnabled(false);
		
		JButton btnNewButton_1 = new JButton("ASSIGN SUPPLIER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AssignSupName.getText().length()!=0 && AssignSupPName.getText().length()!=0) {
					int pid=Integer.parseInt(AssignSupPId.getSelectedItem().toString());
					int sid=Integer.parseInt(AssingSupId.getSelectedItem().toString());
					boolean check=db.AssignProductToSupplier(pid, sid);
					if(check) {
						AssignSupPId.setSelectedItem("");
						AssingSupId.setSelectedItem("");
						AssignSupPName.setText("");
						AssignSupName.setText("");
						table.setModel(db.getAssingProductSupplier());
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_1.setBounds(628, 462, 312, 49);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reload");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignSupPId.setModel(new DefaultComboBoxModel(db.getAllProductId()));
				AssingSupId.setModel(new DefaultComboBoxModel(db.getAllSuppliersId()));
				SupplierTable.setModel(db.getsupplierTableData());
				table.setModel(db.getAssingProductSupplier());
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.setBounds(911, 10, 99, 27);
		add(btnNewButton_2);
		
	}
}
