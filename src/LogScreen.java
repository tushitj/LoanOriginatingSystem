
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class LogScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 431146269315521054L;
	Logger logger=Logger.getLogger(LogScreen.class);	
	private JTextField userField1;
	private JPasswordField passwordField1;
	JLabel userLabel1 = new JLabel("User Name :");
	JLabel passLabel1 = new JLabel("PassWord  :");
	private final JButton subBtn = new JButton("Submit");
	private final JLabel logSucess = new JLabel("");
	public LogScreen(final Person p1) {
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
				@SuppressWarnings("deprecation")
				String passCheck=passwordField1.getText().trim();
				if(userCheck.equals(p1.getUsername()) && passCheck.equals(p1.getPassword())){
					logSucess.setText("sucessful login");
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
	}
}
