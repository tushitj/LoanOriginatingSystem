//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
//import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.apache.log4j.Logger;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;


public class LogScreen extends JFrame {
	Logger logger=Logger.getLogger(LogScreen.class);
	/*private String user1;
	private String pass1;*/
	
	
	
	private JTextField userField1;
	
	private JPasswordField passwordField1;
	
	JLabel userLabel1 = new JLabel("User Name   :");
	JLabel passLabel1 = new JLabel("PassWord    :");
	private final JButton subBtn = new JButton("Submit");
	private final JLabel logSucess = new JLabel("");
	
	//Icon icon=new ImageIcon(LogScreen.class.getResource("loan-financing-1024x682.jpg"));
	/*public static void main(String[] args) {
		
					LogScreen frame = new LogScreen();
					frame.setVisible(true);
				
	}*/

	/**
	 * Create the frame.
	 */
	public LogScreen(final Person p1) {
		/*Defaulter sc=new Defaulter();
		sc.defChecker(p1);*/
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		setBounds(100, 100, 494, 370);
		getContentPane().setLayout(null);
		
		userField1 = new JTextField();
		userField1.setToolTipText("Enter User Name");
		userField1.setBounds(263, 62, 105, 20);
		getContentPane().add(userField1);
		userField1.setColumns(10);
		
		
		userLabel1.setBounds(149, 65, 80, 14);
		getContentPane().add(userLabel1);
		
		
		passLabel1.setBounds(150, 124, 79, 14);
		getContentPane().add(passLabel1);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(263, 121, 105, 20);
		getContentPane().add(passwordField1);
		subBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				String userCheck=userField1.getText().trim();
				
						String passCheck=passwordField1.getText().trim();
						
						
				if(userCheck.equals(p1.getUsername()) && passCheck.equals(p1.getPassword())){
					
					logSucess.setText("sucess");
					logger.debug("registeration sucess");
				
				
					
						
					
						
					BankSelection bs=new BankSelection(p1);
					
				//	bs.setExtendedState(JFrame.MAXIMIZED_BOTH);
					bs.setVisible(true);
					LogScreen.this.setVisible(false);
					dispose();
				
					
				
				}
				else{
					logSucess.setText("failed");
					logger.debug("registeration failed");
				}
				}
		
			
		});
		subBtn.setBounds(203, 203, 89, 23);
		
		getContentPane().add(subBtn);
		logSucess.setBounds(322, 207, 105, 14);
		
		getContentPane().add(logSucess);
	
//ImageIcon icon = new ImageIcon(LogScreen.class.getResource("loan-financing-1024x682.jpg"));
		
	//	this.setIconImage(icon.getImage());
	}
}
