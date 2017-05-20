import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

import java.awt.List;
import java.awt.List;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;

import java.awt.Color;
import java.io.IOException;


public class qde extends JFrame {
	private static Person Person;

	Logger logger =Logger.getLogger(qde.class);
	
	JRadioButton maleRadio = new JRadioButton("M");
	JRadioButton femaleRadio = new JRadioButton("F");
	List ListMaritial = new List();
	List ListEdu = new List();
	List listProfession = new List();
	List ListStatus = new List();
	List ListNation = new List();
	List ListIncome = new List();
	private JTextField textField;
	private JTextField textFieldVoter;
	private JTextField textFieldPan;
	
	JLabel validLbl = new JLabel("");
	JLabel cmpleteLbl = new JLabel("");
	JButton validityCheck = new JButton("Check Validity");
	JButton cmplteBtn = new JButton("Submit");
	JLabel expChkLbl = new JLabel("");
	
	JLabel panStatus = new JLabel("");
	JLabel votStatus = new JLabel("");
/*public static void main(String[] args) {
		
					qde frame = new qde(Person);
					frame.setVisible(true);
				
	}*/

	public qde(final Person p1) {
		p1.setStage(2);
		
		if(Serial.serialRes){
			System.out.println("in qde stage ");
			listProfession.select(p1.getListProfessionID());
			ListMaritial.select(p1.getChoiceMaritialID());
			ListEdu.select(p1.getChoiceEduID());
			ListNation.select(p1.getChoiceNationID());
			ListStatus.select(p1.getChoiceStatusID());
			ListIncome.select(p1.getChoiceIncomeID());
			textField.setText(p1.getExperience());
			if(p1.getGender()=="male"){
				maleRadio.setSelected(true);
			}
			else{
				femaleRadio.setSelected(true);
			}
		
		
		}
		setResizable(false);
		validityCheck.setEnabled(false);
	
		ButtonGroup bg = new ButtonGroup();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821,426);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 81, 397, 226);
		getContentPane().add(tabbedPane);
		bg.add(maleRadio);
		bg.add(femaleRadio);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Personal Info", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setBounds(10, 11, 61, 14);
		panel_1.add(lblGender);
		
		
		
		
		maleRadio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				p1.setGender("male");
				logger.debug((maleRadio).getText());
				/*System.out.println("maleradio.gettext is "+maleRadio.getText());
				System.out.println("p1.getgender is "+p1.getGender());*/
				//textArea.setText(maleRadio.getText());
			}
		});
		maleRadio.setBounds(155, 7, 61, 23);
		panel_1.add(maleRadio);
		
		
		femaleRadio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				p1.setGender("female");
				logger.debug((femaleRadio).getText());
				/*System.out.println("fmaleradio.gettaxt is "+femaleRadio.getText());
				System.out.println("p1.getgendr is "+p1.getGender());*/
				//textArea.setText(femaleRadio.getText());
				
			}
		});
		femaleRadio.setBounds(234, 7, 61, 23);
		panel_1.add(femaleRadio);
		
		JLabel lblMaritial = new JLabel("Maritial Status :");
		lblMaritial.setBounds(10, 42, 98, 14);
		panel_1.add(lblMaritial);
		
		
		ListMaritial.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				p1.setMaritial(ListMaritial.getSelectedItem().trim());
				logger.debug((ListMaritial).getSelectedItem());
			
				qdeSelection.MaritialId(p1);
				
				
			}
		});
		ListMaritial.setBounds(155, 36, 98, 20);
		panel_1.add(ListMaritial);
		
		JLabel lblEducation = new JLabel("Education :");
		lblEducation.setBounds(10, 82, 77, 14);
		panel_1.add(lblEducation);
		
		
		ListEdu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				p1.setEducation(ListEdu.getSelectedItem().trim());
				logger.debug((ListEdu).getSelectedItem());
				
				qdeSelection.educationId(p1);

			}
		});
		ListEdu.setBounds(155, 76, 98, 20);
		panel_1.add(ListEdu);
		ListEdu.add("10th");
		ListEdu.add("12th");
		ListEdu.add("Graduate");
		ListEdu.add("Masters");
		ListEdu.add("Higher");
		
		JLabel lblProfession = new JLabel("Profession :");
		lblProfession.setBounds(10, 118, 77, 14);
		panel_1.add(lblProfession);
		
		
		listProfession.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				p1.setProfession(listProfession.getSelectedItem().trim());
				logger.debug((listProfession).getSelectedItem());
				
				qdeSelection.professionId(p1);
				
			}
		});
		listProfession.setBounds(155, 109, 110, 23);
		panel_1.add(listProfession);
		listProfession.add("Other");
		listProfession.add("Job");
		listProfession.add("Business");
		listProfession.add("Practice");
		
		JLabel lblExperince = new JLabel("Experience (in yrs):");
		lblExperince.setBounds(10, 159, 117, 14);
		panel_1.add(lblExperince);
		
		textField = new JTextField();
		textField.setBounds(155, 159, 110, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		expChkLbl.setBounds(290, 173, 92, 14);
		panel_1.add(expChkLbl);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Confidential", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblVoter = new JLabel("Voter I-Card :");
		lblVoter.setBounds(10, 23, 79, 14);
		panel.add(lblVoter);
		
		textFieldVoter = new JTextField();
		textFieldVoter.setBounds(157, 20, 123, 20);
		panel.add(textFieldVoter);
		textFieldVoter.setColumns(10);
		
		JLabel lblPan = new JLabel("PAN Card :");
		lblPan.setBounds(10, 61, 79, 20);
		panel.add(lblPan);
		
		textFieldPan = new JTextField();
		textFieldPan.setBounds(157, 61, 123, 20);
		panel.add(textFieldPan);
		textFieldPan.setColumns(10);
		
		
		votStatus.setBounds(305, 23, 77, 14);
		panel.add(votStatus);
		
		
		panStatus.setBounds(300, 64, 82, 14);
		panel.add(panStatus);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Others", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNationality = new JLabel("Nationality :");
		lblNationality.setBounds(21, 22, 86, 14);
		panel_2.add(lblNationality);
		
		JLabel lblType = new JLabel("Creditor Status :");
		lblType.setBounds(21, 63, 95, 14);
		panel_2.add(lblType);
		
		JLabel lblIncome = new JLabel("Income :");
		lblIncome.setBounds(21, 104, 80, 14);
		panel_2.add(lblIncome);
		
		
		ListNation.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				p1.setNationality(ListNation.getSelectedItem().trim());
				logger.debug((ListNation).getSelectedItem());
				qdeSelection.nationid(p1);
				
			}
		});
		
		ListNation.setBounds(194, 22, 106, 20);
		panel_2.add(ListNation);
		
		ListStatus.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				p1.setCreditStatus(ListStatus.getSelectedItem().trim());
				logger.debug((ListStatus).getSelectedItem());
			
				qdeSelection.statusId(p1);
			}
		});
		
		
		
		ListStatus.setBounds(194, 63, 106, 20);
		panel_2.add(ListStatus);
		

		ListIncome.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				p1.setIncome(ListIncome.getSelectedItem().trim());
				logger.debug((ListIncome).getSelectedItem());
				
				qdeSelection.incomeId(p1);
			}
		});
		
		
		ListIncome.setBounds(194, 104, 105, 20);
		panel_2.add(ListIncome);
		//System.out.println("using person class is" + p1.getExperience());
		
		ListNation.add("Indian");
		ListNation.add("Others");
		
		ListIncome.add(" < 3 lakh");
		ListIncome.add(" 3-7 lakh");
		ListIncome.add(" 7-15 lakh");
		ListIncome.add(" >15 lakh");
		
		ListStatus.add("Single");
		ListStatus.add("Firm");
		ListStatus.add("Corporate");
		
		
		
		
		
		ListMaritial.add("Single");
		ListMaritial.add("Married");
		ListMaritial.add("Divorced");
		ListMaritial.add("Widowed");
		
		
		JLabel lblHeading = new JLabel("      Just Some More Details");
		lblHeading.setForeground(Color.BLACK);
		lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHeading.setBounds(119, 11, 284, 50);
		getContentPane().add(lblHeading);
		
		final Defaulter defaulter=new Defaulter();
		
		validityCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				defaulter.defChecker(p1);
				ValidUser user=new ValidUser(p1);
				logger.debug("in validating user screen");
				user.setVisible(true);
				qde.this.setVisible(false);
				
				
		
				
			}
		});
		
		
		
		validityCheck.setBounds(32, 355, 130, 26);
		getContentPane().add(validityCheck);
		
		
		validLbl.setBounds(184, 384, 131, 14);
		getContentPane().add(validLbl);
		
		
		cmpleteLbl.setBounds(184, 318, 130, 14);
		getContentPane().add(cmpleteLbl);
		cmplteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.setVoter(textFieldVoter.getText().trim());
				logger.debug((p1.getVoter()));
				
				
				p1.setPan(textFieldPan.getText().trim());
				logger.debug((p1.getPan()));
				/*System.out.println("pan is "+p1.getPan());
				System.out.println("pan is "+textFieldPan.getText().trim());*/
				Validation validation=new Validation();
				String exp=textField.getText();
				boolean expCheck=validation.checkInt(exp);
				if(expCheck){
					p1.setExperience(exp);
					expChkLbl.setText(null);
				}
				else{
					p1.setExperience(null);
					expChkLbl.setText("enter a number");
					validityCheck.setEnabled(false);
					}
				p1.setExperience(textField.getText().trim());
				logger.debug((p1.getExperience()));
				//System.out.println("experience is "+textField.getText());
				
				SourceClass qdeSource=new SourceClass();
				boolean qdeValid=qdeSource.qdeFormValid(p1);
				
				//Validation val=new Validation();
				int votLength=p1.getVoter().trim().length();
				int panLength=p1.getPan().trim().length();
				boolean votCheck=true;
				boolean panCheck=true;
				if(votLength!=10){
					votCheck=false;
					votStatus.setText("Invalid");
					logger.debug("Invalid voter card");
				}
				else{
					votStatus.setText(null);
					votCheck=true;
					
				}
				
				if(panLength!=10){
					panCheck=false;
					panStatus.setText("Invalid");
					logger.debug("invalid pan card");
				}
				else{
					panCheck=true;
					panStatus.setText(null);
				}
				if(qdeValid && votCheck && panCheck){
					logger.debug("all fields correct");
					validityCheck.setEnabled(true);
				}
				else{
					logger.debug("validation error");
				}
			}
		});
		
		
		cmplteBtn.setBounds(32, 318, 130, 23);
		getContentPane().add(cmplteBtn);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SourceClass sc=new SourceClass();
				String Id=sc.useridSetter(p1);
				String msg="Plz note the user id as : ";
				
				try {
					Serial.saveState(p1);
					JOptionPane.showMessageDialog(qde.this,msg+Id);
					
				} catch (IOException e1) {
				
					System.out.println("Cant save details..");
				}
			}
		});
		btnSave.setBounds(48, 412, 89, 23);
		getContentPane().add(btnSave);
		
		
	}
}