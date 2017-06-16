
//import java.awt.BorderLayout;
//import java.awt.EventQueue;*import com.itextpdf.text.Chunk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger=Logger.getLogger(Login.class);
	private JTextField userField;
	private JPasswordField passwordField;
	Person p1;
	boolean sucess=false;
	JLabel userLabel = new JLabel("User Name :");
	JLabel passLabel = new JLabel("Password  :");
	JButton regBtn = new JButton("Register");
	JLabel regSucess;
	JButton logBtn = new JButton("Login");
	//	private final JButton btnAlready = new JButton("Already a user??");
	public static void main(String[] args) {
		Login frame = new Login();
		frame.setVisible(true);
		frame.setTitle("Login Screen");
		/*Login lg=new Login();*/
	}
	@SuppressWarnings("deprecation")
	public void  register(){
		p1=new Person();
		p1.setUsername(userField.getText().trim());
		p1.setPassword(passwordField.getText().trim());
		//p1.setPassword(passwordField.getPassword().toString());
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
		setLocation(100,100);
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
		passwordField.setToolTipText("Enter the password. Password must be at least 6 characters long.");
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
					logBtn.setEnabled(false);
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
	}
}
