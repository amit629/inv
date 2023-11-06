package gui;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import database.DatabaseConnection;
import smallComp.AlertMessagePanel;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SpringLayout;
import java.net.URL;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		DatabaseConnection db=new DatabaseConnection("myinventory");
		if(!db.hasConnection()) {
			System.exit(0);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 482);
		Image image = null;

        try {
            image = ImageIO.read(new URL("https://cdn.shopify.com/s/files/1/0070/7032/files/inventory-management-software.png?format=jpg&quality=90&v=1678484855"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		contentPane = new LoginJpanel(image);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
//		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 430, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 865, SpringLayout.WEST, contentPane);
		panel.setBackground(new Color(0,0,0,20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 287, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 71, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -177, SpringLayout.EAST, panel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		panel.add(lblNewLabel);
		
		Username = new JTextField();
		Username.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sl_panel.putConstraint(SpringLayout.NORTH, Username, 137, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Username, 184, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, Username, 775, SpringLayout.WEST, panel);
		
		Username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel.add(Username);
		
		JLabel lblNewLabel_1 = new JLabel("Username/Email");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 104, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 32, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 127, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 154, SpringLayout.WEST, panel);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 243, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 32, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 266, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 104, SpringLayout.WEST, panel);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblNewLabel_2);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sl_panel.putConstraint(SpringLayout.WEST, Username, 0, SpringLayout.WEST, Password);
		sl_panel.putConstraint(SpringLayout.NORTH, Password, 276, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, Password, 77, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Password, 323, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, Password, 775, SpringLayout.WEST, panel);
		
		Password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel.add(Password);
		
		JButton btnNewButton = new JButton("Login");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 364, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, 403, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 556, SpringLayout.WEST, panel);
		btnNewButton.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground"), 2, true));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=Username.getText();
				String password=new String(Password.getPassword());
				if(name.length()==0 || password.length()==0) {
					new AlertMessagePanel(name.length()==0?"username cannot be empty":"password cannot be empty");
				}else {
//					new AlertMessagePanel("username: "+name+" password: "+password);
					boolean resp=db.isAuthorized(name, password);
					new AlertMessagePanel(resp==true?"Welcome":"Not Authorized Contact Admin");
					if(resp==true) {
						dispose();
						new DashBoard(name,password);
					}
					
				}
			}
		});
		panel.add(btnNewButton);
		
	
		
		
	}
}
