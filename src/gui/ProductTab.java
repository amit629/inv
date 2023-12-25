package gui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;
import helperClass.HelperUtils;
import smallComp.AlertMessagePanel;
import smallComp.Category;
import smallComp.ProductSchema;
import smallComp.UserDetails;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class ProductTab extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField AddProductSKU;
	private JTextField AddProductName;
	private JTextField AddProductPrice;
	private JTable ProductTable;
	private JTextField AddProductQuantity;
	private JTable EditProductTable;
	private JTextField EditProductIdField;
	private JTextField EditProductSKUField;
	private JTextField EditProductNameField;
	private JTextField EditProductPriceField;
	private JTextField EditProductQuantityField;
	private JTable AddProductCategoryTable;
	private JTextField CategoryAddField;
	private JTextArea EditProductDescriptionField;
	private JTable ProductHasCategory;
	private JComboBox AssignCatPId;
	private JComboBox AssignCatId ;
	private JTextArea AssignCatPName;
	private JTextArea AssignCatPDes;
	private JTextArea AssignCatName;
	private JTable LowThresholdTable;
	private JTable table;
	private JTextField EditThresholdField;

	/**
	 * Create the panel.
	 */
	public void setVisibility(boolean vis) {
		this.setVisible(vis);
	}
	public ProductTab(DatabaseConnection db,UserDetails userDet) {
		setLayout(null);
		
		JTabbedPane ProductTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ProductTabbedPane.setBounds(10, 41, 1115, 644);
		add(ProductTabbedPane);
		
		JPanel panel = new JPanel();
		ProductTabbedPane.addTab("Products", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1090, 626);
		panel.add(scrollPane);
		
		ProductTable = new JTable();
		ProductTable.setModel(db.getProducts("add"));
		scrollPane.setViewportView(ProductTable);
		
		JPanel panel_1 = new JPanel();
		ProductTabbedPane.addTab("Add Product", null, panel_1, null);
		panel_1.setLayout(null);
		
		AddProductSKU = new JTextField();
		AddProductSKU.setBounds(186, 187, 807, 41);
		panel_1.add(AddProductSKU);
		AddProductSKU.setColumns(10);
		
		AddProductName = new JTextField();
		AddProductName.setBounds(186, 123, 807, 41);
		panel_1.add(AddProductName);
		AddProductName.setColumns(10);
		
		AddProductPrice = new JTextField();
		AddProductPrice.setBounds(186, 432, 807, 41);
		panel_1.add(AddProductPrice);
		AddProductPrice.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SKU");
		lblNewLabel_1.setBounds(77, 193, 83, 27);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(66, 126, 102, 33);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(77, 438, 83, 27);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		AddProductQuantity = new JTextField();
		AddProductQuantity.setBounds(186, 363, 807, 41);
		panel_1.add(AddProductQuantity);
		AddProductQuantity.setColumns(10);
		
		JTextArea AddProductDescription = new JTextArea();
		AddProductDescription.setBounds(186, 253, 807, 81);
		panel_1.add(AddProductDescription);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setBounds(77, 369, 83, 27);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel_4);
		
		JButton AddProductButton = new JButton("Add Product");
		AddProductButton.setBounds(351, 537, 293, 55);
		AddProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(AddProductPrice.getText().length()!=0 && AddProductQuantity.getText().length()!=0) {
						ProductSchema pr=new ProductSchema(AddProductSKU.getText(),AddProductName.getText(),AddProductDescription.getText(),Integer.parseInt(AddProductPrice.getText()),Integer.parseInt(AddProductQuantity.getText()));
						if(pr.getSKU().length()!=0 && pr.getName().length()!=0 && pr.getDescription().length()!=0) {
							boolean resp=db.AddProduct(pr, userDet.getEmail());
							if(resp) {
								ProductTable.setModel(db.getProducts("add"));
								AssignCatPId.setModel(new DefaultComboBoxModel(db.getAllProductId()));
								AddProductSKU.setText("");
								AddProductName.setText("");
								AddProductDescription.setText("");
								AddProductPrice.setText("");
								AddProductQuantity.setText("");
								ProductTabbedPane.revalidate();
							}
						}
						else {
							new AlertMessagePanel("Fill All Fields");
						}
					}
					else {
						new AlertMessagePanel("Fill All Fields");
					}
					
				}catch(NumberFormatException err) {
					new AlertMessagePanel("Enter only numbers in price and quantity");
				}
			}
		});
		AddProductButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(AddProductButton);
		
		JPanel panel_2 = new JPanel();
		ProductTabbedPane.addTab("Edit Product", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 417, 626);
		panel_2.add(scrollPane_1);
		
		EditProductTable = new JTable();
		EditProductTable.setModel(db.getProducts("edit"));
		scrollPane_1.setViewportView(EditProductTable);
		
		JLabel lblNewLabel_5 = new JLabel("Product Id");
		lblNewLabel_5.setBounds(437, 38, 63, 24);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_5);
		
		EditProductIdField = new JTextField();
		EditProductIdField.setBounds(524, 31, 576, 40);
		panel_2.add(EditProductIdField);
		EditProductIdField.setColumns(10);
		EditProductIdField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id=Integer.parseInt(EditProductIdField.getText());
					ProductSchema ProductData=db.getProductData(id);
					if(ProductData.getName().length()!=0) {
						EditProductSKUField.setText(ProductData.getSKU());
						EditProductNameField.setText(ProductData.getName());
						EditProductDescriptionField.setText(ProductData.getDescription());
						EditProductPriceField.setText(Integer.toString(ProductData.getPrice()));
						EditProductQuantityField.setText(Integer.toString(ProductData.getQuantity()));
						System.out.println(ProductData.getThreshold());	
						if(ProductData.getThreshold()!=0) {
							EditThresholdField.setText(Integer.toString(ProductData.getThreshold()));
						}else {
							EditThresholdField.setText("");
						}
					}
					else {
						new AlertMessagePanel("Product with the id dosen't exist");
						EditProductSKUField.setText("");
						EditProductNameField.setText("");
						EditProductDescriptionField.setText("");
						EditProductPriceField.setText("");
						EditProductQuantityField.setText("");
						EditThresholdField.setText("");
					}
				}catch(NumberFormatException err) {
					new AlertMessagePanel("Not A Valid ID");			}
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("SKU");
		lblNewLabel_6.setBounds(437, 102, 63, 24);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_6);
		
		EditProductSKUField = new JTextField();
		EditProductSKUField.setBounds(524, 95, 576, 40);
		panel_2.add(EditProductSKUField);
		EditProductSKUField.setEnabled(false);
		EditProductSKUField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setBounds(437, 164, 63, 24);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_7);
		
		EditProductNameField = new JTextField();
		EditProductNameField.setBounds(524, 157, 576, 40);
		panel_2.add(EditProductNameField);
		EditProductNameField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Price");
		lblNewLabel_8.setBounds(437, 386, 63, 40);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_8);
		
		EditProductPriceField = new JTextField();
		EditProductPriceField.setBounds(524, 387, 576, 40);
		panel_2.add(EditProductPriceField);
		EditProductPriceField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Quantity");
		lblNewLabel_9.setBounds(437, 232, 63, 15);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_9);
		
		EditProductQuantityField = new JTextField();
		EditProductQuantityField.setBounds(524, 220, 576, 40);
		panel_2.add(EditProductQuantityField);
		EditProductQuantityField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pid=Integer.parseInt(EditProductIdField.getText());
				String productName = EditProductNameField.getText();
				String productDescription = EditProductDescriptionField.getText();
				String productPrice = EditProductPriceField.getText();
				String productQuantity = EditProductQuantityField.getText();	
				String productThreshold=EditThresholdField.getText();
				
				if (EditProductIdField.getText().length() != 0 &&
						EditProductSKUField.getText().length() != 0 &&
					    productName.length() != 0 &&
					    productDescription.length() != 0 &&
					    productPrice.length() != 0 &&
					    productQuantity.length() != 0 && productThreshold.length()!=0) {
					
						boolean check=db.updateProductData(pid, productName, productDescription, Integer.parseInt(productPrice), Integer.parseInt(productQuantity),Integer.parseInt(productThreshold));
						if(check) {
							EditProductIdField.setText("");
							EditProductSKUField.setText("");
							EditProductNameField.setText("");
							EditProductDescriptionField.setText("");
							EditProductPriceField.setText("");
							EditProductQuantityField.setText("");
							EditThresholdField.setText("");
							EditProductTable.setModel(db.getProducts("edit"));
						}
					   
					} else {
					   new AlertMessagePanel("Fields cannnot be empty");
					}		
				
			}
		});
		btnNewButton_1.setBounds(666, 531, 264, 45);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnNewButton_1);
		
		EditProductDescriptionField = new JTextArea();
		EditProductDescriptionField.setBounds(524, 280, 576, 85);
		panel_2.add(EditProductDescriptionField);
		
		JLabel lblNewLabel_13 = new JLabel("Description");
		lblNewLabel_13.setBounds(437, 308, 63, 24);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_23 = new JLabel("Threshold");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_23.setBounds(437, 469, 63, 24);
		panel_2.add(lblNewLabel_23);
		
		EditThresholdField = new JTextField();
		EditThresholdField.setBounds(524, 457, 576, 40);
		panel_2.add(EditThresholdField);
		EditThresholdField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		ProductTabbedPane.addTab("Add Category", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 388, 626);
		panel_3.add(scrollPane_2);
		
		AddProductCategoryTable = new JTable();
		AddProductCategoryTable.setModel(db.getCategoryTable());
		scrollPane_2.setViewportView(AddProductCategoryTable);
		
		JLabel lblNewLabel_10 = new JLabel("Add Category");
		lblNewLabel_10.setBounds(424, 10, 676, 63);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblNewLabel_11 = new JLabel("Categories");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setColumnHeaderView(lblNewLabel_11);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("Category Name");
		lblNewLabel_12.setBounds(424, 104, 122, 46);
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_3.add(lblNewLabel_12);
		
		CategoryAddField = new JTextField();
		CategoryAddField.setBounds(424, 160, 676, 37);
		panel_3.add(CategoryAddField);
		CategoryAddField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Add Category");
		btnNewButton_3.setBounds(605, 260, 270, 30);
		AddProductButton.setBackground(Color.BLUE);
		
		
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(77, 283, 83, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_20 = new JLabel("Add Products");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblNewLabel_20.setBounds(128, 20, 778, 74);
		panel_1.add(lblNewLabel_20);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoryName=CategoryAddField.getText();
				boolean resp=db.AddCategory(categoryName.toLowerCase(),userDet.getEmail());
				if(resp==true) {
					AddProductCategoryTable.setModel(db.getCategoryTable());
					AssignCatId.setModel(new DefaultComboBoxModel(db.getAllCategoryId()));
					CategoryAddField.setText("");
					ProductTabbedPane.revalidate();
				}
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		ProductTabbedPane.addTab("Assign Categories", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 10, 481, 626);
		panel_4.add(scrollPane_3);
		
		ProductHasCategory = new JTable();
		ProductHasCategory.setModel(db.ProductWithCategories());
		scrollPane_3.setViewportView(ProductHasCategory);
		
		JLabel lblNewLabel_14 = new JLabel("Assign Category to Products");
		lblNewLabel_14.setBounds(501, 10, 599, 77);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_4.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Product Id");
		lblNewLabel_15.setBounds(520, 154, 97, 32);
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_15);
		
		AssignCatPId = new JComboBox();
		AssignCatPId.setBounds(627, 154, 431, 32);
		AssignCatPId.setModel(new DefaultComboBoxModel(db.getAllProductId()));
		panel_4.add(AssignCatPId);
		AssignCatPId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pid=Integer.parseInt(AssignCatPId.getSelectedItem().toString());
				ProductSchema pr=db.getProductData(pid);
				if(pr.getName().length()!=0){
					AssignCatPName.setText(pr.getName());
					AssignCatPDes.setText(pr.getDescription());
					AssignCatPName.setDisabledTextColor(Color.BLACK);
					AssignCatPDes.setDisabledTextColor(Color.BLACK);
				}
				else {
					AssignCatPName.setText("");
					AssignCatPDes.setText("");
				}
			}
		});
		
		AssignCatPName = new JTextArea();
		AssignCatPName.setBounds(627, 208, 431, 50);
		AssignCatPName.setEnabled(false);
		AssignCatPName.setEditable(false);
		panel_4.add(AssignCatPName);
		
		AssignCatPDes = new JTextArea();
		AssignCatPDes.setBounds(627, 281, 431, 50);
		AssignCatPDes.setEnabled(false);
		AssignCatPDes.setEditable(false);
		panel_4.add(AssignCatPDes);
		
		JLabel lblNewLabel_16 = new JLabel("Product Name");
		lblNewLabel_16.setBounds(520, 208, 97, 50);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_4.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Description");
		lblNewLabel_17.setBounds(520, 281, 97, 50);
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_17);
		
		AssignCatId = new JComboBox();
		AssignCatId.setBounds(627, 356, 431, 32);
		AssignCatId.setModel(new DefaultComboBoxModel(db.getAllCategoryId()));
		panel_4.add(AssignCatId);
		AssignCatId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem=Integer.parseInt(AssignCatId.getSelectedItem().toString());
				if(selectedItem!=0) {
					Category cd=db.getCategoryById(selectedItem);
					AssignCatName.setText(cd.getCategoryName());
					AssignCatName.setDisabledTextColor(Color.BLACK);
				}else {
					AssignCatName.setText("");
					new AlertMessagePanel("please select a category");
				}
			}
		});
		
		JLabel lblNewLabel_18 = new JLabel("Category Id");
		lblNewLabel_18.setBounds(510, 356, 107, 32);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_4.add(lblNewLabel_18);
		
		JButton btnNewButton = new JButton("Assign Category");
		btnNewButton.setBounds(643, 520, 296, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectCat=AssignCatId.getSelectedItem().toString();
				String ProductId=AssignCatPId.getSelectedItem().toString();
				if(selectCat.length()!=0 && ProductId.length()!=0) {
					boolean resp=db.AssignProductToCategory(Integer.parseInt(ProductId), Integer.parseInt(selectCat));
					if(resp) {
						AssignCatName.setText("");
						AssignCatPName.setText("");
						AssignCatPDes.setText("");
						AssignCatId.setSelectedItem(0);
						AssignCatPId.setSelectedIndex(0);
						ProductHasCategory.setModel(db.ProductWithCategories());
						ProductTabbedPane.revalidate();
						
					}
					
				}else {
					if(selectCat.length()==0 && ProductId.length()!=0) {
						new AlertMessagePanel("please select a Category");
					}else {
						new AlertMessagePanel("please select a Product");
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_4.add(btnNewButton);
		
		AssignCatName = new JTextArea();
		AssignCatName.setBounds(627, 416, 431, 50);
		AssignCatName.setEnabled(false);
		AssignCatName.setEditable(false);
		panel_4.add(AssignCatName);
		
		JLabel lblNewLabel_19 = new JLabel("Category Name");
		lblNewLabel_19.setBounds(520, 416, 97, 50);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_4.add(lblNewLabel_19);
		
		JPanel panel_5 = new JPanel();
		ProductTabbedPane.addTab("Low Stocks", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 10, 452, 626);
		panel_5.add(scrollPane_4);
		
		LowThresholdTable = new JTable();
		scrollPane_4.setViewportView(LowThresholdTable);
		LowThresholdTable.setModel(db.getLowStocksTable());
		
		JLabel lblNewLabel_21 = new JLabel("Filter By Category");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_21.setBounds(531, 12, 492, 60);
		panel_5.add(lblNewLabel_21);
		
		JComboBox FilterByCatComboBox = new JComboBox();
		FilterByCatComboBox.setBounds(494, 160, 572, 46);
		panel_5.add(FilterByCatComboBox);
		FilterByCatComboBox.setModel(new DefaultComboBoxModel(db.getCategoryName2()));
		FilterByCatComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem=FilterByCatComboBox.getSelectedItem().toString();
				if(selectedItem.equalsIgnoreCase("all")) {
					LowThresholdTable.setModel(db.getLowStocksTable());
				}
				else {
					LowThresholdTable.setModel(db.getLowStocksTableByCat(selectedItem));														
				}
			}
		});
		
		JLabel lblNewLabel_22 = new JLabel("Category Name");
		lblNewLabel_22.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_22.setBounds(494, 116, 182, 27);
		panel_5.add(lblNewLabel_22);
		
		JButton btnNewButton_4 = new JButton("Reload");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilterByCatComboBox.setModel(new DefaultComboBoxModel(db.getCategoryName2()));
				LowThresholdTable.setModel(db.getLowStocksTable());
				ProductHasCategory.setModel(db.ProductWithCategories());
				AssignCatId.setModel(new DefaultComboBoxModel(db.getAllCategoryId()));
				AssignCatId.setModel(new DefaultComboBoxModel(db.getAllCategoryId()));
				ProductTable.setModel(db.getProducts("add"));
				AssignCatPId.setModel(new DefaultComboBoxModel(db.getAllProductId()));
				EditProductTable.setModel(db.getProducts("edit"));
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_4.setBounds(918, 10, 85, 31);
		add(btnNewButton_4);

		
	}
}
