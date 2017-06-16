import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.apache.log4j.Logger;
public class Sourcing extends JFrame implements Serializable{
	private static final long serialVersionUID = -4633989960175086140L;
	public static boolean enable=false;
	Logger logger=Logger.getLogger(Sourcing.class);	
	//private JPanel contentPane;
	private JTextField textField_2= new JTextField();
	private JTextField textField_3= new JTextField();
	private JTextField textField_5= new JTextField();
	private JTextField textField_6= new JTextField();
	private JTextField textField_7= new JTextField();
	private JTextField textField_8= new JTextField();
	private JTextField textField_9= new JTextField();
	private JTextField textField_10= new JTextField();
	JTextArea textField_4 = new JTextArea();	
	public boolean val;
	public boolean phoneVal;
	JLabel phone = new JLabel("");
	JButton btnNext = new JButton("Next");
	JButton btnSubmit = new JButton("Submit");
	JButton saveBtn = new JButton("Save Details");
	JLabel ageLbl = new JLabel("");
	JLabel lbl3 = new JLabel("");
	JLabel lbl4 = new JLabel("");
	JLabel lbl5 = new JLabel("");
	JLabel lbl6 = new JLabel("");
	SourceClass sc=new SourceClass();
	List list = new List();	
	public Sourcing(final Person  p1) {		
		p1.setStage(1);		
		if(Serial.serialRes){
			System.out.println("asset is "+p1.getAssets());
			System.out.println("loan id os "+p1.getLoanTypeId());
			list.select(p1.getLoanTypeId());
			textField_2.setText(p1.getAge());
			textField_3.setText(p1.getLoanAmt());
			textField_4.setText(p1.getAdress());
			textField_5.setText(p1.getAgentName());
			textField_6.setText(p1.getPhone());
			textField_7.setText(p1.getLoanTenure());
			textField_8.setText(p1.getLoanValue());
			textField_9.setText(p1.getLiability());
			textField_10.setText(p1.getAssets());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 465);
		getContentPane().setLayout(null);
		JLabel Label1 = new JLabel("Sourcing");
		Label1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Label1.setBounds(10, 11, 104, 25);
		getContentPane().add(Label1);
		JLabel Label2 = new JLabel("Loan Type :");
		Label2.setBounds(10, 63,90, 14);
		getContentPane().add(Label2);
		JLabel Label4 = new JLabel("Age :");
		Label4.setBounds(10, 109, 90, 14);
		getContentPane().add(Label4);
		textField_2.setBounds(141, 106, 121, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		JLabel Label5 = new JLabel("Loan Amount :");
		Label5.setBounds(10, 134, 100, 14);
		getContentPane().add(Label5);
		textField_3.setBounds(141, 137, 121, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		JLabel Label6 = new JLabel("Address :");
		Label6.setBounds(10, 169, 90, 14);
		getContentPane().add(Label6);
		JLabel Label7 = new JLabel("Agent Name :");
		Label7.setBounds(10, 236, 100, 14);
		getContentPane().add(Label7);
		textField_5.setBounds(141, 235, 121, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		JLabel Label8 = new JLabel("Phone No. :");
		Label8.setBounds(10, 271, 90, 14);
		getContentPane().add(Label8);
		textField_6.setBounds(141, 266, 121, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		JLabel Label9 = new JLabel("Loan Tenure :");
		Label9.setBounds(10, 296, 90, 14);
		getContentPane().add(Label9);
		textField_7.setBounds(141, 297, 121, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		JLabel Label10 = new JLabel("Value :");
		Label10.setBounds(10, 332, 90, 14);
		getContentPane().add(Label10);
		textField_8.setBounds(141, 328, 121, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		textField_9.setBounds(141, 372, 121, 20);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		textField_10.setText("");
		textField_10.setBounds(141, 403, 121, 20);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		JLabel Label12 = new JLabel("Assets :");
		JLabel Label11 = new JLabel("Liabilities:");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=textField_2.getText();
				String b=textField_3.getText();
				String c=textField_6.getText();
				String f=textField_7.getText();
				String g=textField_8.getText();
				String h=textField_9.getText();
				String i=textField_10.getText();	
				Validation validation=new Validation();			
				boolean a1=validation.checkInt(a);
				if(a1){
					p1.setAge(a);
					ageLbl.setText(null);
				}
				else{
					p1.setAge(null);
					ageLbl.setText("Enter a number");
					ageLbl.setBounds(300,109,250,20);
				}
				boolean a2=validation.checkInt(b);
				if(a2){
					p1.setLoanAmt(b);
					lbl3.setText(null);
				}
				else{
					p1.setLoanAmt(null);
					lbl3.setText("Enter a valid addres");
					lbl3.setBounds(300,169,200,20);
				}
				boolean a3=validation.checkInt(f);
				if(a3){
					p1.setLoanTenure(f);
					lbl4.setText(null);
				}
				else{
					p1.setLoanAmt(null);
					lbl4.setText("Enter a number");
					lbl4.setBounds(300,134,250,20);
				}
				boolean a4=validation.checkInt(g);
				if(a4){
					p1.setLoanValue(g);
					lbl5.setText(null);
				}
				else{
					p1.setLoanValue(null);
					lbl5.setText("enter a number");
					lbl5.setBounds(300,109,100,20);
				}
				boolean a5=validation.checkInt(c);
				if(a5){
					p1.setPhone(c);
					phone.setText(null);
				}
				else{
					p1.setPhone(null);
					phone.setText("enter a number");
				}
				boolean a6=validation.checkInt(h);
				if(a6){
					p1.setLiability(h);
					lbl5.setText(null);
				}
				else{
					p1.setLiability(null);
					lbl5.setText("enter a number");
				}
				boolean a7=validation.checkInt(i);
				if(a7){
					p1.setAssets(i);
					lbl6.setText(null);
				}
				else{
					p1.setAssets(null);
					//lbl6.setText("enter a number7");
				}
				p1.setAdress(textField_4.getText());
				p1.setAgentName(textField_5.getText());
				String phoneNo=textField_6.getText();
				phoneVal=sc.checkPhone(phoneNo, p1);
				if(!phoneVal){
					logger.debug("invalid phone");
					phone.setText("Invalid Number");
					phone.setBounds(300,271,150,20);
				}
				else{
					phone.setText(null);
				}				
				val=sc.formValid(p1);			
				if(val){
					logger.debug("form is valid");
					btnNext.setEnabled(true);
					btnSubmit.setEnabled(false);
				}
				else{
					logger.debug("incomplete sourcing form");
				}	
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmit.setBounds(312, 401, 121, 25);
		getContentPane().add(btnSubmit);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qde qde1=new qde(p1);
				logger.debug("in validating user screen");
				qde1.setVisible(true);
				Sourcing.this.setVisible(false);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.setBounds(439, 401, 121, 24);
		getContentPane().add(btnNext);
		btnNext.setEnabled(false);
		list.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String type=list.getSelectedItem();
				sc.loanSelect(type,p1);
			}
		});
		list.setBounds(141, 56, 149, 33);
		getContentPane().add(list);
		phone.setBounds(312, 260, 200, 25);
		getContentPane().add(phone);
		ageLbl.setBounds(355, 109, 121, 17);
		getContentPane().add(ageLbl);
		lbl3.setBounds(365, 140, 111, 14);
		getContentPane().add(lbl3);
		lbl4.setBounds(376, 300, 121, 14);
		getContentPane().add(lbl4);
		lbl5.setBounds(358, 332, 139, 14);
		getContentPane().add(lbl5);
		Label11.setBounds(10, 370, 70, 14);
		getContentPane().add(Label11);
		Label12.setBounds(10, 406, 70, 14);
		getContentPane().add(Label12);
		lbl6.setBounds(355, 359, 126, 25);
		getContentPane().add(lbl6);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 168, 121, 46);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(textField_4);
		textField_4.setBounds(141, 168, 121, 46);
		JButton btnSave = new JButton("Save Details");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id=sc.useridSetter(p1);
				String msg="Please note the user id as : ";
				try {
					Serial.saveState(p1);
					JOptionPane.showMessageDialog(Sourcing.this,msg+Id);
				} catch (IOException e1) {
					System.out.println("Cant save details..");
				}
			}
		});
		btnSave.setBounds(312, 371, 121, 25);
		getContentPane().add(btnSave);
		list.add("Select Loan ");
		list.add("Car Loan");
		list.add("Home Loan");
		list.add("Educational Loan");
	}	
}
