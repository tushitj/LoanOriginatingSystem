
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class ValidUser extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel nameDisp = new JLabel("");
	JLabel phoneDisp = new JLabel("");
	JLabel VoterDisp = new JLabel("");
	JLabel PanDisp = new JLabel("");
	JButton nxtBtn = new JButton("Proceed to Dedupe");
	JProgressBar progressBar = new JProgressBar();
	JLabel lblFraud = new JLabel("Fraud Chances :");
	public ValidUser(final Person p1) {
		nxtBtn.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 457);
		getContentPane().setLayout(null);
		JLabel lblHeading = new JLabel("         Validating User...");
		lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHeading.setBounds(63, 27, 253, 35);
		getContentPane().add(lblHeading);
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(33, 85, 46, 14);
		getContentPane().add(lblName);
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(33, 118, 61, 14);
		getContentPane().add(lblPhone);
		JLabel lblVotr = new JLabel("Voter Card :");
		lblVotr.setBounds(33, 151, 73, 14);
		getContentPane().add(lblVotr);
		JLabel lblPan = new JLabel("Pan Card :");
		lblPan.setBounds(33, 194, 61, 14);
		getContentPane().add(lblPan);
		nameDisp.setBounds(150, 85, 245, 14);
		getContentPane().add(nameDisp);
		phoneDisp.setBounds(150, 118, 239, 14);
		getContentPane().add(phoneDisp);
		VoterDisp.setBounds(150, 151, 239, 14);
		getContentPane().add(VoterDisp);
		PanDisp.setBounds(150, 194, 245, 14);
		getContentPane().add(PanDisp);
		nameDisp.setText(p1.getUsername());
		phoneDisp.setText(p1.getPhone());
		VoterDisp.setText(p1.getVoter());
		PanDisp.setText(p1.getPan());
		JLabel nameMatch = new JLabel("");
		nameMatch.setBounds(326, 85, 98, 14);
		getContentPane().add(nameMatch);
		JLabel phoneMatch = new JLabel("");
		phoneMatch.setBounds(326, 118, 98, 14);
		getContentPane().add(phoneMatch);
		JLabel votrMatch = new JLabel("");
		votrMatch.setBounds(326, 151, 98, 14);
		getContentPane().add(votrMatch);
		JLabel panMatch = new JLabel("");
		panMatch.setBounds(326, 194, 98, 14);
		getContentPane().add(panMatch);
		nxtBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nxtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dedupe dedupe=new Dedupe(p1);
				ValidUser.this.setVisible(false);
				dedupe.setVisible(true);
				dispose();
				dedupe.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		nxtBtn.setBounds(326, 332, 142, 52);
		getContentPane().add(nxtBtn);
		progressBar.setStringPainted(true);
		progressBar.setBounds(33, 293, 200, 28);
		getContentPane().add(progressBar);
		lblFraud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFraud.setBounds(33, 259, 116, 14);
		getContentPane().add(lblFraud);
		if(Defaulter.userValid){
			nameMatch.setText("No Match");
		}
		else{
			nameMatch.setText("Matched");
		}
		if(Defaulter.userVoterValid){
			votrMatch.setText("No Match");
		}
		else{
			votrMatch.setText("Matched");
		}
		if(Defaulter.userPanValid){
			panMatch.setText("No Match");
		}
		else{
			panMatch.setText("Matched");
		}
		if(Defaulter.userPhoneValid){
			phoneMatch.setText("No Match");
		}
		else{
			phoneMatch.setText("Matched");
		}
		//setting progress bar values;
		if(!Defaulter.userPanValid || !Defaulter.userVoterValid){
			progressBar.setValue(100);
		}
		else{
			nxtBtn.setVisible(true);
			progressBar.setValue((Defaulter.defaultCounter*20));   //* 20 as 100/5 where 5 is number of parameters
		}
	}
}
