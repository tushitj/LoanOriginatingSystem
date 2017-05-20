
//import java.awt.BorderLayout;
//import java.awt.EventQueue;*import com.itextpdf.text.Chunk;

import java.awt.Desktop;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends JFrame {
	
	
	Logger logger=Logger.getLogger(Login.class);
	
	private JTextField userField;
	private JPasswordField passwordField;
	 Person p1;
	

	boolean sucess=false;
	
	

	
	JLabel userLabel = new JLabel("User Name   :");
	JLabel passLabel = new JLabel("PassWord    :");

	JButton regBtn = new JButton("Register");
	JLabel regSucess;

	JButton logBtn = new JButton("Login");
//	private final JButton btnAlready = new JButton("Already a user??");
	
	public static void main(String[] args) {
	
					Login frame = new Login();
					frame.setVisible(true);
					frame.setTitle("login screen");
				
					/*Login lg=new Login();*/
				
	}
	public void  register(){
		
		p1=new Person();
			p1.setUsername(userField.getText().trim());
		
		
		p1.setPassword(passwordField.getText().trim());
		
		
		
		if(p1.getUsername().length() > 0 && p1.getPassword().length()>5){
			//System.out.println("in condition 1");
			logger.debug("reg sucess");
			sucess=true;
		
		}
		else{
			//System.out.println("in condition 2");
			logger.debug("reg failed");
			sucess=false;
		}
		
		}
		
	

	
	public Login() {
		
		
		try {
			Serial.idCounter();
		} catch (FileNotFoundException e2) {
			
			System.out.println("no files before");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 465);
		getContentPane().setLayout(null);
		
		userField = new JTextField();
		userField.setToolTipText("Enter User Name");
		userField.setBounds(200, 62, 105, 20);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		
		userLabel.setBounds(100, 65, 80, 14);
		getContentPane().add(userLabel);
		
		
		passLabel.setBounds(100, 124, 79, 14);
		getContentPane().add(passLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 121, 105, 20);
		getContentPane().add(passwordField);
		
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 register();
			
			 if(sucess){
				
				 
				 regSucess.setText("Registered sucessfully");
	

				 
				 logBtn.setEnabled(true);
				 regBtn.setEnabled(false);
			 }
			else{
				 regSucess.setText("Registered failed");
			 }
		}
		});
		regBtn.setBounds(149, 181, 89, 23);
		getContentPane().add(regBtn);
		
		regSucess = new JLabel("");
		regSucess.setBounds(263, 190, 250, 40);
		getContentPane().add(regSucess);
		
		
		logBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogScreen lgScreen=new LogScreen(p1);
				Login.this.setVisible(false);
				Login.this.dispose();
				
				lgScreen.setVisible(true);
				lgScreen.setBounds(100, 100, 821, 465);
			}
		});
		logBtn.setBounds(149, 240, 89, 23);
		getContentPane().add(logBtn);
		logBtn.setEnabled(false);
		
	/*	btnAlready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String alreadyUser=userField.getText();
			String passAlready=passwordField.getText();
			
			try {
				Serial.loadState(alreadyUser,passAlready);
		
				
		
			} catch (ClassNotFoundException | IOException e1) {
				
				System.out.println("no person found");

			}
				logBtn.setVisible(true);
			}	
			
		});
		btnAlready.setBounds(354, 294, 147, 23);
		
		getContentPane().add(btnAlready);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//samplePDF();
			}
		});
		btnPdf.setBounds(121, 294, 89, 23);
		getContentPane().add(btnPdf);
		*/
		
		
	
}
	
	
}
