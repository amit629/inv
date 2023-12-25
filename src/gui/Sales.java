package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;
import smallComp.AlertMessagePanel;
import smallComp.Category;
import smallComp.CustomerInfo;
import smallComp.ProductSchema;
import smallComp.UserDetails;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Sales extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField BillingProductName;
	private JTextField BillingProductPrice;
	private JTextField BillingAvailableQuant;
	private JTextField BillingOrderQuant;
	private JTable BillingOrderTable;
	private JTextField BillingEmpId;
	private JTextField BillingTotal;
	private JTextField BillingRecieved;
	private JTextField BillingBalance;
	private JTextField BillingCustMob;
	private JTextField BillingCustName;
	private JTextField BillingEmpName;

	/**
	 * Create the panel.
	 */
	public Sales(DatabaseConnection db,UserDetails userDet) {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 27, 1129, 652);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Billing", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product id");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 24, 66, 20);
		panel.add(lblNewLabel);
		
		JComboBox BillingProductId = new JComboBox();
		BillingProductId.setModel(new DefaultComboBoxModel(db.getAllProductId()));
		BillingProductId.setBounds(86, 24, 101, 21);
		BillingProductId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem=Integer.parseInt(BillingProductId.getSelectedItem().toString());
				if(selectedItem!=0) {
					ProductSchema ps=db.getProductData(selectedItem);
					BillingProductName.setText(ps.getName());
					BillingProductPrice.setText(Integer.toString(ps.getPrice()));
					BillingAvailableQuant.setText(Integer.toString(ps.getQuantity()));
					
				}else {
					BillingProductName.setText("");
					BillingProductPrice.setText("");
					BillingAvailableQuant.setText("");
					new AlertMessagePanel("please select a category");
				}
			}
		});
		panel.add(BillingProductId);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(197, 24, 84, 20);
		panel.add(lblNewLabel_1);
		
		BillingProductName = new JTextField();
		BillingProductName.setBounds(278, 25, 136, 21);
		BillingProductName.setEnabled(false);
		panel.add(BillingProductName);
		BillingProductName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(424, 28, 46, 16);
		panel.add(lblNewLabel_2);
		
		BillingProductPrice = new JTextField();
		BillingProductPrice.setBounds(476, 25, 96, 21);
		BillingProductPrice.setEnabled(false);
		panel.add(BillingProductPrice);
		BillingProductPrice.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Available Quantity");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(582, 28, 101, 20);
		panel.add(lblNewLabel_3);
		
		BillingAvailableQuant = new JTextField();
		BillingAvailableQuant.setBounds(693, 26, 96, 21);
		BillingAvailableQuant.setEnabled(false);
		panel.add(BillingAvailableQuant);
		BillingAvailableQuant.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Order Quantity");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setBounds(800, 28, 84, 20);
		panel.add(lblNewLabel_4);
		
		BillingOrderQuant = new JTextField();
		BillingOrderQuant.setBounds(894, 26, 96, 21);
		panel.add(BillingOrderQuant);
		BillingOrderQuant.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 1104, 289);
		panel.add(scrollPane);
		
//		Vector col={"Product Id","Product Name","Price/Unit","Quantity","Total"};
		Vector col=new Vector();
		col.add("Product Id");
		col.add("Product Name");
		col.add("Price / Unit");
		col.add("Quantity");
		col.add("Total");
		
		
		Vector<Vector> rows=new Vector();
		BillingOrderTable = new JTable();
		BillingOrderTable.setModel(new DefaultTableModel(rows,col));
//		BillingOrderTable.getModel().addTableModelListener(
//				new TableModelListener() 
//				{
//				    public void tableChanged(TableModelEvent evt) 
//				    {
//				         // here goes your code "on cell update"
//				    }
//				});
		BillingOrderTable.setEnabled(false);
//		BillingOrderTable.getModel().addTableModelListener(new TableModelListener() {
//			 	public void tableChanged(TableModelEvent evt) 
//			    {
//			         new AlertMessagePanel(rows.toString());
//			    }
//		});
		scrollPane.setViewportView(BillingOrderTable);
		
		JLabel lblNewLabel_5 = new JLabel("Order Items");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 73, 113, 24);
		panel.add(lblNewLabel_5);
		
		JButton BillingAddPro = new JButton("ADD");
		BillingAddPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BillingProductName.getText().length()==0) {
					new AlertMessagePanel("Product dosent Exist");
				}
				else {
					if(Integer.parseInt(BillingOrderQuant.getText())>Integer.parseInt(BillingAvailableQuant.getText())) {
						new AlertMessagePanel("Order Quantity more than Availability");
					}else {
						String CurrId=BillingProductId.getSelectedItem().toString();
						int ind=ifRepeated(rows,CurrId);
						Vector n=new Vector();
						n.add(BillingProductId.getSelectedItem());
						n.add(BillingProductName.getText());
						n.add(BillingProductPrice.getText());
						n.add(BillingOrderQuant.getText());
						n.add(Integer.toString(Integer.parseInt(BillingOrderQuant.getText())*Integer.parseInt(BillingProductPrice.getText())));
						if(ind==-1) {
							rows.add(n);
						}else {
							rows.set(ind, n);
						}
						BillingOrderTable.setModel(new DefaultTableModel(rows,col));
						BillingTotal.setText(getOrderTotal(rows));
						tabbedPane.revalidate();
					}
				}
			}
		});
		BillingAddPro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		BillingAddPro.setBounds(1000, 14, 97, 41);
		panel.add(BillingAddPro);
		
		JLabel lblNewLabel_6 = new JLabel("EMP ID");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 431, 46, 29);
		panel.add(lblNewLabel_6);
		
		BillingEmpId = new JTextField();
		BillingEmpId.setBounds(66, 431, 121, 24);
		panel.add(BillingEmpId);
		BillingEmpId.setColumns(10);
		BillingEmpId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id=Integer.parseInt(BillingEmpId.getText());
					UserDetails UserData=db.getUserById(id);
					if(UserData.getName().length()!=0) {
						BillingEmpName.setText(UserData.getName());
					}
					else {
						new AlertMessagePanel("employee with the id dosen't exist");
						
					}
				}catch(NumberFormatException err) {
					new AlertMessagePanel("Not A Valid ID");			}
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("EMP NAME");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_7.setBounds(208, 435, 73, 21);
		panel.add(lblNewLabel_7);
		
		BillingEmpName = new JTextField();
		BillingEmpName.setBounds(290, 434, 136, 24);
		BillingEmpName.setEnabled(false);
		panel.add(BillingEmpName);
		BillingEmpName.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Sub Total");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 553, 66, 20);
		panel.add(lblNewLabel_8);
		
		BillingTotal = new JTextField();
		BillingTotal.setBounds(86, 550, 175, 29);
		panel.add(BillingTotal);
		BillingTotal.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Recieved");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_9.setBounds(292, 549, 66, 29);
		panel.add(lblNewLabel_9);
		
		BillingRecieved = new JTextField();
		BillingRecieved.setBounds(368, 550, 175, 29);
		panel.add(BillingRecieved);
		BillingRecieved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int billTot=Integer.parseInt(BillingTotal.getText().toString());
				int billRecieved=Integer.parseInt(BillingRecieved.getText().toString());
				if(billRecieved>=billTot) {
					BillingBalance.setText(Integer.toString(billRecieved-billTot));
				}
				else {
					new AlertMessagePanel("Recieved amount should not be less tha total amount");
				}
			}
		});
		BillingRecieved.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Balance");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_10.setBounds(565, 549, 66, 29);
		panel.add(lblNewLabel_10);
		
		
		BillingBalance = new JTextField();
		BillingBalance.setBounds(641, 550, 167, 30);
		BillingBalance.setEnabled(false);
		panel.add(BillingBalance);
		BillingBalance.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Generate Invoice");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BillingBalance.getText().length()!=0 && rows.size()!=0 && BillingEmpName.getText().length()!=0 && BillingCustName.getText().length()!=0) {
					int billTot=Integer.parseInt(BillingTotal.getText().toString());
					int billRecieved=Integer.parseInt(BillingRecieved.getText().toString());
					if(billRecieved>=billTot) {
						BillingBalance.setText(Integer.toString(billRecieved-billTot));
						Vector<Vector> orderItems=rows;
						String emp_code=BillingEmpId.getText();
						String cutomer_mob=BillingCustMob.getText();
						CustomerInfo cst=db.getCustomerInfo(cutomer_mob);
						String[] check=db.CreateOrderAndGenerateInvoice(billTot, orderItems, emp_code, cutomer_mob);
						if(check.length!=0) {
							new Invoice(billTot,emp_code,cst,orderItems,col,check);
							rows.removeAllElements();
							BillingOrderTable.setModel(new DefaultTableModel(rows,col));
							BillingTotal.setText(getOrderTotal(rows));
							BillingEmpName.setText("");
							BillingCustName.setText("");
							BillingProductName.setText("");
							BillingProductPrice.setText("");
							BillingOrderQuant.setText("");
							tabbedPane.revalidate();
							
						}
					
					}
					else {
						new AlertMessagePanel("Recieved amount should not be less tha total amount");
					}
				}else {
					new AlertMessagePanel("Fill All Fields");
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(831, 535, 160, 58);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_11 = new JLabel("Customer Mobile");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_11.setBounds(11, 485, 101, 29);
		panel.add(lblNewLabel_11);
		
		BillingCustMob = new JTextField();
		BillingCustMob.setBounds(122, 485, 191, 29);
		
		BillingCustMob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mobNo=BillingCustMob.getText();
				CustomerInfo cst=db.getCustomerInfo(mobNo);
				BillingCustName.setText(cst.getCustomerName());
				if(cst.getCustomerName().length()==0) {
					BillingCustMob.setText("");
					BillingCustName.setText("");
				}
			}
		});	
		panel.add(BillingCustMob);
		BillingCustMob.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Customer Name");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_12.setBounds(340, 485, 96, 29);
		panel.add(lblNewLabel_12);
		
		BillingCustName = new JTextField();
		BillingCustName.setBounds(440, 485, 191, 29);
		BillingCustName.setEnabled(false);
		panel.add(BillingCustName);
		BillingCustName.setColumns(10);
		
		JButton btnNewButton = new JButton("Reload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillingProductId.setModel(new DefaultComboBoxModel(db.getAllProductId()));
				tabbedPane.revalidate();
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(995, 10, 85, 21);
		add(btnNewButton);
		
	}
	
	public String getOrderTotal(Vector<Vector>Rows) {
		int total=0;
		for(int i=0;i<Rows.size();i++) {
			int currPrice=Integer.parseInt(Rows.get(i).get(2).toString());
			int currQuant=Integer.parseInt(Rows.get(i).get(3).toString());
			total=total+(currPrice*currQuant);
		}
		return Integer.toString(total);
	}
	public int ifRepeated(Vector<Vector>Rows,String id) {
		for(int i=0;i<Rows.size();i++) {
			if(Rows.get(i).get(0).equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	
}
