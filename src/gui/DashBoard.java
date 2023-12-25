package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DatabaseConnection;
import helperClass.FrameChange;
import smallComp.AlertMessagePanel;
import smallComp.UserDetails;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import java.awt.FlowLayout;

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
	 UserPan userPan;
	 ProductTab productTab;
	 Sales sales;
	 Customers customers;
	 Supplier supplier;
	public DashBoard(String userName,String password) {
		DatabaseConnection db=new DatabaseConnection("myinventory");
		UserDetails userDet=db.GetUserDetails(userName, password);
//		System.out.println(userDet.getName());
		frame=new JFrame();
		frame.setVisible(true);
		frame.setSize(1003, 576);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		db.checkForLowStocks();
		contentPane = new JPanel();
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JPanel DashboardPanel = new JPanel();
		DashboardPanel.setBounds(0, 0, 243, 539);
		DashboardPanel.setBackground(new Color(0, 0, 139));
		contentPane.add(DashboardPanel);
		DashboardPanel.setLayout(null);
		
		JButton DashboardCustomerButton = new JButton("Customers");
		DashboardCustomerButton.setBounds(10, 194, 223, 38);
		DashboardCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(false);
				userPan.setVisible(false);
				sales.setVisible(false);
				customers.setVisible(true);
				supplier.setVisible(false);
			}
		});
		DashboardCustomerButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DashboardPanel.add(DashboardCustomerButton);
		
		JButton DashboardSalesButton = new JButton("Sales");
		DashboardSalesButton.setBounds(10, 132, 223, 38);
		DashboardSalesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(false);
				userPan.setVisible(false);	
				sales.setVisible(true);
				customers.setVisible(false);
				supplier.setVisible(false);
			}
		});
		DashboardSalesButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DashboardPanel.add(DashboardSalesButton);
		
		JButton DashboardProductButton = new JButton("Product");
		DashboardProductButton.setBounds(10, 71, 223, 38);
		DashboardProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(true);
				userPan.setVisible(false);	
				sales.setVisible(false);
				customers.setVisible(false);
				supplier.setVisible(false);
			}
		});
		DashboardProductButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DashboardPanel.add(DashboardProductButton);
		
		JButton DashboardUserButton = new JButton("User");
		DashboardUserButton.setBounds(10, 315, 223, 38);
		DashboardUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(false);
				userPan.setVisible(true);	
				sales.setVisible(false);
				customers.setVisible(false);
				supplier.setVisible(false);
					
			}
		});
		DashboardUserButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		boolean check=userDet.isAdmin();
		if (check)
			DashboardUserButton.setVisible(true);
		else
			DashboardUserButton.setVisible(false);
		DashboardPanel.add(DashboardUserButton);
		

		JButton DashboardSupplierButton = new JButton("Suppliers");
		DashboardSupplierButton.setBounds(10, 254, 223, 38);
		DashboardSupplierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTab.setVisible(false);
				userPan.setVisible(false);	
				sales.setVisible(false);
				customers.setVisible(false);
				supplier.setVisible(true);
			}
		});
		DashboardSupplierButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DashboardPanel.add(DashboardSupplierButton);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setBounds(10, 10, 229, 51);
		DashboardPanel.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		
		supplier = new Supplier(db, userDet);
		supplier.setBounds(253, 10, 726, 519);
		supplier.setVisible(false);
		contentPane.add(supplier);
		
		customers = new Customers(db,userDet);
		customers.setBounds(253, 10, 726, 519);
		customers.setVisible(false);
		contentPane.add(customers);
		
		sales = new Sales(db,userDet);
		sales.setBounds(253, 10, 726, 519);
		sales.setVisible(false);
		contentPane.add(sales);
		
		productTab = new ProductTab(db,userDet);
		productTab.setBounds(253, 10, 726, 519);
		contentPane.add(productTab);
		
		userPan = new UserPan(db, userDet,frame);
		userPan.setBackground(Color.darkGray);
		userPan.setBounds(253, 10, 726, 519);
		userPan.setVisible(false);
		contentPane.add(userPan);
		
		
	frame.addComponentListener(new FrameChange() {
		@Override
		public void componentResized(ComponentEvent arg0) {
	        int frameWidth=frame.getWidth();
	        int frameHeight=frame.getHeight();
	        System.out.println(frameWidth+" "+frameHeight);
	        int dashBoardWidth=(frameWidth*(24))/100;
	        int restFrameWidth=frameWidth-dashBoardWidth;
	        DashboardPanel.setSize(dashBoardWidth,frameHeight);
	        int buttWidth=(dashBoardWidth*90)/100;
	        int buttBndX=(dashBoardWidth*5)/100;
	        int lblY=(dashBoardWidth*2)/100;
	        int buttBndY=(frameHeight*3)/100;
	        int buttHeight=DashboardSupplierButton.getHeight()+((DashboardSupplierButton.getHeight()*5)/100);
	        lblNewLabel.setBounds(buttBndX,lblNewLabel.getHeight()+lblY,buttWidth,buttHeight);
	        DashboardProductButton.setBounds(buttBndX,lblNewLabel.getBounds().y+lblNewLabel.getHeight()+buttBndY, buttWidth, buttHeight);
	        DashboardSalesButton.setBounds(buttBndX,DashboardProductButton.getBounds().y+DashboardProductButton.getHeight()+buttBndY, buttWidth, buttHeight);
	        DashboardCustomerButton.setBounds(buttBndX,DashboardSalesButton.getBounds().y+DashboardSalesButton.getHeight()+buttBndY, buttWidth, buttHeight);
	        DashboardSupplierButton.setBounds(buttBndX,DashboardCustomerButton.getBounds().y+DashboardCustomerButton.getHeight()+buttBndY, buttWidth, buttHeight);
	        DashboardUserButton.setBounds(buttBndX,DashboardSupplierButton.getBounds().y+DashboardSupplierButton.getHeight()+buttBndY, buttWidth, buttHeight);
	        Rectangle check=DashboardPanel.getBounds();
	        userPan.setSize(restFrameWidth, frameHeight);
	        userPan.setBounds(dashBoardWidth+check.x,userPan.getBounds().y, restFrameWidth, frameHeight);
	        productTab.setSize(restFrameWidth, frameHeight);
	        productTab.setBounds(dashBoardWidth+check.x,productTab.getBounds().y, restFrameWidth-2, frameHeight);
	        sales.setSize(restFrameWidth, frameHeight);
	        sales.setBounds(dashBoardWidth+check.x,sales.getBounds().y, restFrameWidth, frameHeight);
	        customers.setSize(restFrameWidth-2, frameHeight);
	        customers.setBounds(dashBoardWidth+check.x,productTab.getBounds().y, restFrameWidth-2, frameHeight);
	        supplier.setSize(restFrameWidth-2, frameHeight);
	        supplier.setBounds(dashBoardWidth+check.x,productTab.getBounds().y, restFrameWidth-2, frameHeight);
	        frame.revalidate();
	        
	    }
	});

		
		
		
		
		
		
		
		
		
		
		
		
	}
}
