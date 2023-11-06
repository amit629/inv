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

	/**
	 * Create the panel.
	 */
	public void setVisibility(boolean vis) {
		this.setVisible(vis);
	}
	public ProductTab(DatabaseConnection db,UserDetails userDet) {
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JTabbedPane ProductTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, ProductTabbedPane, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, ProductTabbedPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, ProductTabbedPane, 446, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, ProductTabbedPane, -10, SpringLayout.EAST, this);
		add(ProductTabbedPane);
		
		JPanel panel = new JPanel();
		ProductTabbedPane.addTab("Products", null, panel, null);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, 399, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 661, SpringLayout.WEST, panel);
		panel.add(scrollPane);
		
		ProductTable = new JTable();
		ProductTable.setModel(db.getProducts("add"));
		scrollPane.setViewportView(ProductTable);
		
		JPanel panel_1 = new JPanel();
		ProductTabbedPane.addTab("Add Product", null, panel_1, null);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		AddProductSKU = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, AddProductSKU, 43, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, AddProductSKU, 158, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, AddProductSKU, -333, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, AddProductSKU, -82, SpringLayout.EAST, panel_1);
		panel_1.add(AddProductSKU);
		AddProductSKU.setColumns(10);
		
		AddProductName = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, AddProductName, 22, SpringLayout.SOUTH, AddProductSKU);
		sl_panel_1.putConstraint(SpringLayout.WEST, AddProductName, 158, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, AddProductName, -278, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, AddProductName, -82, SpringLayout.EAST, panel_1);
		panel_1.add(AddProductName);
		AddProductName.setColumns(10);
		
		AddProductPrice = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, AddProductPrice, 0, SpringLayout.WEST, AddProductSKU);
		sl_panel_1.putConstraint(SpringLayout.EAST, AddProductPrice, 0, SpringLayout.EAST, AddProductSKU);
		panel_1.add(AddProductPrice);
		AddProductPrice.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SKU");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, -1, SpringLayout.NORTH, AddProductSKU);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 42, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -56, SpringLayout.SOUTH, AddProductName);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1, -33, SpringLayout.WEST, AddProductSKU);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 22, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 42, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_3, 83, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		AddProductQuantity = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, AddProductPrice, -23, SpringLayout.NORTH, AddProductQuantity);
		sl_panel_1.putConstraint(SpringLayout.NORTH, AddProductQuantity, 283, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, AddProductQuantity, 0, SpringLayout.WEST, AddProductSKU);
		sl_panel_1.putConstraint(SpringLayout.EAST, AddProductQuantity, 0, SpringLayout.EAST, AddProductSKU);
		panel_1.add(AddProductQuantity);
		AddProductQuantity.setColumns(10);
		
		JTextArea AddProductDescription = new JTextArea();
		sl_panel_1.putConstraint(SpringLayout.NORTH, AddProductPrice, 23, SpringLayout.SOUTH, AddProductDescription);
		sl_panel_1.putConstraint(SpringLayout.NORTH, AddProductDescription, 148, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, AddProductDescription, 0, SpringLayout.WEST, AddProductSKU);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, AddProductDescription, 77, SpringLayout.SOUTH, AddProductName);
		sl_panel_1.putConstraint(SpringLayout.EAST, AddProductDescription, -82, SpringLayout.EAST, panel_1);
		panel_1.add(AddProductDescription);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -30, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 7, SpringLayout.NORTH, AddProductQuantity);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 42, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel_4);
		
		JButton AddProductButton = new JButton("Add Product");
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, AddProductButton, 347, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, AddProductButton, -29, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, AddProductQuantity, -31, SpringLayout.NORTH, AddProductButton);
		sl_panel_1.putConstraint(SpringLayout.WEST, AddProductButton, 220, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, AddProductButton, -207, SpringLayout.EAST, panel_1);
		AddProductButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(AddProductButton);
		
		JPanel panel_2 = new JPanel();
		ProductTabbedPane.addTab("Edit Product", null, panel_2, null);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		sl_panel_2.putConstraint(SpringLayout.NORTH, scrollPane_1, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, scrollPane_1, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, scrollPane_1, 382, SpringLayout.NORTH, panel_2);
		panel_2.add(scrollPane_1);
		
		EditProductTable = new JTable();
		EditProductTable.setModel(db.getProducts("edit"));
		scrollPane_1.setViewportView(EditProductTable);
		
		JLabel lblNewLabel_5 = new JLabel("Product Id");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_5, 269, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, scrollPane_1, -6, SpringLayout.WEST, lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 31, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 55, SpringLayout.NORTH, panel_2);
		panel_2.add(lblNewLabel_5);
		
		EditProductIdField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, EditProductIdField, 338, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_5, -6, SpringLayout.WEST, EditProductIdField);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditProductIdField, 0, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditProductIdField, 0, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditProductIdField, -10, SpringLayout.EAST, panel_2);
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
					}
					else {
						new AlertMessagePanel("Product with the id dosen't exist");
						EditProductSKUField.setText("");
						EditProductNameField.setText("");
						EditProductDescriptionField.setText("");
						EditProductPriceField.setText("");
						EditProductQuantityField.setText("");
					}
				}catch(NumberFormatException err) {
					new AlertMessagePanel("Not A Valid ID");			}
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("SKU");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_6, 6, SpringLayout.EAST, scrollPane_1);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 26, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 50, SpringLayout.SOUTH, lblNewLabel_5);
		panel_2.add(lblNewLabel_6);
		
		EditProductSKUField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_6, -6, SpringLayout.WEST, EditProductSKUField);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditProductSKUField, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel_2.putConstraint(SpringLayout.WEST, EditProductSKUField, 0, SpringLayout.WEST, EditProductIdField);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditProductSKUField, 0, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditProductSKUField, 0, SpringLayout.EAST, EditProductIdField);
		panel_2.add(EditProductSKUField);
		EditProductSKUField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_7, 6, SpringLayout.EAST, scrollPane_1);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 20, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 44, SpringLayout.SOUTH, lblNewLabel_6);
		panel_2.add(lblNewLabel_7);
		
		EditProductNameField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_7, -6, SpringLayout.WEST, EditProductNameField);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditProductNameField, 20, SpringLayout.SOUTH, EditProductSKUField);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditProductNameField, -260, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, EditProductNameField, 0, SpringLayout.WEST, EditProductIdField);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditProductNameField, 0, SpringLayout.EAST, EditProductIdField);
		panel_2.add(EditProductNameField);
		EditProductNameField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Price");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_8, 6, SpringLayout.EAST, scrollPane_1);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_8);
		
		EditProductPriceField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 4, SpringLayout.NORTH, EditProductPriceField);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_8, -6, SpringLayout.WEST, EditProductPriceField);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditProductPriceField, 71, SpringLayout.SOUTH, EditProductNameField);
		sl_panel_2.putConstraint(SpringLayout.WEST, EditProductPriceField, 0, SpringLayout.WEST, EditProductIdField);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditProductPriceField, -10, SpringLayout.EAST, panel_2);
		panel_2.add(EditProductPriceField);
		EditProductPriceField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Quantity");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_9, 6, SpringLayout.EAST, scrollPane_1);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_2.add(lblNewLabel_9);
		
		EditProductQuantityField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_9, -6, SpringLayout.WEST, EditProductQuantityField);
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditProductQuantityField, 262, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditProductPriceField, -18, SpringLayout.NORTH, EditProductQuantityField);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 4, SpringLayout.NORTH, EditProductQuantityField);
		sl_panel_2.putConstraint(SpringLayout.WEST, EditProductQuantityField, 338, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditProductQuantityField, 0, SpringLayout.EAST, EditProductIdField);
		panel_2.add(EditProductQuantityField);
		EditProductQuantityField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_1, 15, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditProductQuantityField, -24, SpringLayout.NORTH, btnNewButton_1);
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_1, 310, SpringLayout.NORTH, panel_2);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_2, 478, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnNewButton_1, -17, SpringLayout.WEST, btnNewButton_2);
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_2, 310, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -58, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton_2);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnNewButton_2);
		
		EditProductDescriptionField = new JTextArea();
		sl_panel_2.putConstraint(SpringLayout.NORTH, EditProductDescriptionField, 18, SpringLayout.SOUTH, EditProductNameField);
		sl_panel_2.putConstraint(SpringLayout.WEST, EditProductDescriptionField, 0, SpringLayout.WEST, EditProductIdField);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, EditProductDescriptionField, 53, SpringLayout.SOUTH, EditProductNameField);
		sl_panel_2.putConstraint(SpringLayout.EAST, EditProductDescriptionField, 0, SpringLayout.EAST, EditProductIdField);
		panel_2.add(EditProductDescriptionField);
		
		JLabel lblNewLabel_13 = new JLabel("Description");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_13, 6, SpringLayout.EAST, scrollPane_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_13, -6, SpringLayout.WEST, EditProductDescriptionField);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_13, 18, SpringLayout.SOUTH, lblNewLabel_7);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_13, 42, SpringLayout.SOUTH, lblNewLabel_7);
		panel_2.add(lblNewLabel_13);
		
		JPanel panel_3 = new JPanel();
		ProductTabbedPane.addTab("Add Category", null, panel_3, null);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane_2, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane_2, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane_2, 399, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane_2, 301, SpringLayout.WEST, panel_3);
		panel_3.add(scrollPane_2);
		
		AddProductCategoryTable = new JTable();
		AddProductCategoryTable.setModel(db.getCategoryTable());
		scrollPane_2.setViewportView(AddProductCategoryTable);
		
		JLabel lblNewLabel_10 = new JLabel("Add Category");
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_10, 34, SpringLayout.EAST, scrollPane_2);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel_10, -37, SpringLayout.EAST, panel_3);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 19));
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_10, 47, SpringLayout.NORTH, panel_3);
		
		JLabel lblNewLabel_11 = new JLabel("Categories");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setColumnHeaderView(lblNewLabel_11);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("Category Name");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 36, SpringLayout.SOUTH, lblNewLabel_10);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_12, 25, SpringLayout.EAST, scrollPane_2);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_12, -289, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel_12, -220, SpringLayout.EAST, panel_3);
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_3.add(lblNewLabel_12);
		
		CategoryAddField = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, CategoryAddField, 6, SpringLayout.SOUTH, lblNewLabel_12);
		sl_panel_3.putConstraint(SpringLayout.WEST, CategoryAddField, 25, SpringLayout.EAST, scrollPane_2);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, CategoryAddField, 43, SpringLayout.SOUTH, lblNewLabel_12);
		sl_panel_3.putConstraint(SpringLayout.EAST, CategoryAddField, -37, SpringLayout.EAST, panel_3);
		panel_3.add(CategoryAddField);
		CategoryAddField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Add Category");
		sl_panel_3.putConstraint(SpringLayout.WEST, btnNewButton_3, 106, SpringLayout.EAST, scrollPane_2);
		sl_panel_3.putConstraint(SpringLayout.EAST, btnNewButton_3, -139, SpringLayout.EAST, panel_3);
		AddProductButton.setBackground(Color.BLUE);
		
		
		
		JLabel lblNewLabel = new JLabel("Description");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 148, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -18, SpringLayout.NORTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, AddProductDescription);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel);
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
		sl_panel_3.putConstraint(SpringLayout.NORTH, btnNewButton_3, 42, SpringLayout.SOUTH, CategoryAddField);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 72, SpringLayout.SOUTH, CategoryAddField);
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		ProductTabbedPane.addTab("Assign Categories", null, panel_4, null);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		sl_panel_4.putConstraint(SpringLayout.NORTH, scrollPane_3, 10, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, scrollPane_3, 10, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, scrollPane_3, 399, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, scrollPane_3, 322, SpringLayout.WEST, panel_4);
		panel_4.add(scrollPane_3);
		
		ProductHasCategory = new JTable();
		ProductHasCategory.setModel(db.ProductWithCategories());
		scrollPane_3.setViewportView(ProductHasCategory);
		
		JLabel lblNewLabel_14 = new JLabel("Assign Category to Products");
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_14, 27, SpringLayout.EAST, scrollPane_3);
		sl_panel_4.putConstraint(SpringLayout.EAST, lblNewLabel_14, -21, SpringLayout.EAST, panel_4);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 17));
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_14, 10, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_14, 46, SpringLayout.NORTH, panel_4);
		panel_4.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Product Id");
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_15, 16, SpringLayout.SOUTH, lblNewLabel_14);
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_15, 6, SpringLayout.EAST, scrollPane_3);
		sl_panel_4.putConstraint(SpringLayout.EAST, lblNewLabel_15, -277, SpringLayout.EAST, panel_4);
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_15);
		
		AssignCatPId = new JComboBox();
		sl_panel_4.putConstraint(SpringLayout.NORTH, AssignCatPId, 16, SpringLayout.SOUTH, lblNewLabel_14);
		sl_panel_4.putConstraint(SpringLayout.WEST, AssignCatPId, 20, SpringLayout.EAST, lblNewLabel_15);
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
		sl_panel_4.putConstraint(SpringLayout.NORTH, AssignCatPName, 21, SpringLayout.SOUTH, AssignCatPId);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, AssignCatPName, -269, SpringLayout.SOUTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, AssignCatPName, -29, SpringLayout.EAST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, AssignCatPId, 0, SpringLayout.EAST, AssignCatPName);
		AssignCatPName.setEnabled(false);
		AssignCatPName.setEditable(false);
		panel_4.add(AssignCatPName);
		
		AssignCatPDes = new JTextArea();
		sl_panel_4.putConstraint(SpringLayout.NORTH, AssignCatPDes, 157, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, AssignCatPDes, -29, SpringLayout.EAST, panel_4);
		AssignCatPDes.setEnabled(false);
		AssignCatPDes.setEditable(false);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, AssignCatPDes, 53, SpringLayout.SOUTH, AssignCatPName);
		panel_4.add(AssignCatPDes);
		
		JLabel lblNewLabel_16 = new JLabel("Product Name");
		sl_panel_4.putConstraint(SpringLayout.EAST, lblNewLabel_16, -263, SpringLayout.EAST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, AssignCatPName, 6, SpringLayout.EAST, lblNewLabel_16);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_15, -21, SpringLayout.NORTH, lblNewLabel_16);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_16, 0, SpringLayout.NORTH, AssignCatPName);
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_16, 6, SpringLayout.EAST, scrollPane_3);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_16, 0, SpringLayout.SOUTH, AssignCatPName);
		panel_4.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Description");
		sl_panel_4.putConstraint(SpringLayout.EAST, lblNewLabel_17, -272, SpringLayout.EAST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, AssignCatPDes, 15, SpringLayout.EAST, lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_17, 157, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_17, 6, SpringLayout.EAST, scrollPane_3);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_17, -216, SpringLayout.SOUTH, panel_4);
		panel_4.add(lblNewLabel_17);
		
		AssignCatId = new JComboBox();
		AssignCatId.setModel(new DefaultComboBoxModel(db.getAllCategoryId()));
		sl_panel_4.putConstraint(SpringLayout.NORTH, AssignCatId, 24, SpringLayout.SOUTH, AssignCatPDes);
		sl_panel_4.putConstraint(SpringLayout.WEST, AssignCatId, 0, SpringLayout.WEST, AssignCatPId);
		sl_panel_4.putConstraint(SpringLayout.EAST, AssignCatId, 0, SpringLayout.EAST, AssignCatPId);
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
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_18, 0, SpringLayout.NORTH, AssignCatId);
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_18, 6, SpringLayout.EAST, scrollPane_3);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_18, 0, SpringLayout.SOUTH, AssignCatId);
		sl_panel_4.putConstraint(SpringLayout.EAST, lblNewLabel_18, 0, SpringLayout.EAST, lblNewLabel_16);
		panel_4.add(lblNewLabel_18);
		
		JButton btnNewButton = new JButton("Assign Category");
		sl_panel_4.putConstraint(SpringLayout.NORTH, btnNewButton, 89, SpringLayout.SOUTH, AssignCatId);
		sl_panel_4.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, AssignCatPId);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, btnNewButton, -46, SpringLayout.SOUTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, btnNewButton, -102, SpringLayout.EAST, panel_4);
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
		AssignCatName.setEnabled(false);
		AssignCatName.setEditable(false);
		sl_panel_4.putConstraint(SpringLayout.NORTH, AssignCatName, 17, SpringLayout.SOUTH, AssignCatId);
		sl_panel_4.putConstraint(SpringLayout.WEST, AssignCatName, 0, SpringLayout.WEST, AssignCatPId);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, AssignCatName, 53, SpringLayout.SOUTH, AssignCatId);
		sl_panel_4.putConstraint(SpringLayout.EAST, AssignCatName, 0, SpringLayout.EAST, AssignCatPId);
		panel_4.add(AssignCatName);
		
		JLabel lblNewLabel_19 = new JLabel("Category Name");
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_19, 17, SpringLayout.SOUTH, lblNewLabel_18);
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_19, 6, SpringLayout.EAST, scrollPane_3);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_19, 0, SpringLayout.SOUTH, AssignCatName);
		sl_panel_4.putConstraint(SpringLayout.EAST, lblNewLabel_19, -2, SpringLayout.WEST, AssignCatName);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_4.add(lblNewLabel_19);
		
	}
}
