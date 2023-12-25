package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import smallComp.CustomerInfo;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Label;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Invoice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Invoice frame = new Invoice();
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
	public static class Printer implements Printable {
	    final Component comp;

	    public Printer(Component comp){
	        this.comp = comp;
	    }

	    @Override
	    public int print(Graphics g, PageFormat format, int page_index) 
	            throws PrinterException {
	        if (page_index > 0) {
	            return Printable.NO_SUCH_PAGE;
	        }

	        // get the bounds of the component
	        Dimension dim = comp.getSize();
	        double cHeight = dim.getHeight();
	        double cWidth = dim.getWidth();

	        // get the bounds of the printable area
	        double pHeight = format.getImageableHeight();
	        double pWidth = format.getImageableWidth();

	        double pXStart = format.getImageableX();
	        double pYStart = format.getImageableY();

	        double xRatio = pWidth / cWidth;
	        double yRatio = pHeight / cHeight;


	        Graphics2D g2 = (Graphics2D) g;
	        g2.translate(pXStart, pYStart);
	        g2.scale(xRatio, yRatio);
	        comp.paint(g2);

	        return Printable.PAGE_EXISTS;
	    }
	}
	public void printData() {
		PrinterJob pjob = PrinterJob.getPrinterJob();
		PageFormat preformat = pjob.defaultPage();
		preformat.setOrientation(PageFormat.PORTRAIT);
		Paper paper=preformat.getPaper();
		paper.setImageableArea(0, 0, preformat.getWidth(), preformat.getHeight());
		preformat.setPaper(paper);
		preformat=pjob.validatePage(preformat);
		
		PageFormat postformat = pjob.pageDialog(preformat);
	
		//If user does not hit cancel then print.
		if (preformat != postformat) {
		    //Set print component
		    pjob.setPrintable(new Printer(frame), postformat);
		    if (pjob.printDialog()) {
		        try {
					pjob.print();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
	}
	public Invoice(int total,String emp_code,CustomerInfo cust,Vector<Vector>Rs,Vector col,String[]check) {
		frame=new JFrame();
		frame.setVisible(true);
		frame.setSize(1226, 755);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		contentPane = new JPanel();
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INVOICE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(390, 10, 351, 63);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 112, 1179, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 162, 1179, 2);
		contentPane.add(separator_1);
		
		JLabel InvoiceNo = new JLabel("New label");
		InvoiceNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		InvoiceNo.setBounds(128, 124, 120, 35);
		InvoiceNo.setText(check[1]);
		contentPane.add(InvoiceNo);
		
		JLabel lblNewLabel_1 = new JLabel("Invoice Date:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(864, 124, 120, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("INVOICE #:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(20, 124, 102, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel InvoiceDate = new JLabel("New label");
		InvoiceDate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		InvoiceDate.setBounds(975, 124, 120, 35);
		InvoiceDate.setText(check[2]);
		contentPane.add(InvoiceDate);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Name:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(20, 168, 130, 35);
		
		contentPane.add(lblNewLabel_3);
		
		JLabel CustomerName = new JLabel("New label");
		CustomerName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustomerName.setBounds(148, 169, 130, 34);
		CustomerName.setText(cust.getCustomerName());
		contentPane.add(CustomerName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 262, 1169, 351);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(Rs,col));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("Customer Mobile:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 206, 129, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel CustMob = new JLabel("New label");
		CustMob.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CustMob.setBounds(148, 207, 114, 35);
		CustMob.setText(cust.getCustomerMob());
		contentPane.add(CustMob);
		
		JLabel lblNewLabel_5 = new JLabel("Order Total:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(834, 625, 130, 49);
		contentPane.add(lblNewLabel_5);
		
		JLabel OrderTotal = new JLabel("New label");
		OrderTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		OrderTotal.setBounds(955, 623, 184, 51);
		OrderTotal.setText("Rs "+Integer.toString(total));
		contentPane.add(OrderTotal);
		
		JLabel lblNewLabel_6 = new JLabel("Order Id: ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(864, 174, 77, 35);
		contentPane.add(lblNewLabel_6);
		
		JLabel Order_id = new JLabel("New label");
		Order_id.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Order_id.setBounds(948, 174, 158, 35);
		Order_id.setText(check[0]);
		contentPane.add(Order_id);
		
		printData();
		
		
	}
}
