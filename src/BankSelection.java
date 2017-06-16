
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BankSelection extends JFrame {
	private static final long serialVersionUID = -739798055564549758L;
	public static void main(String[] args) {
		BankSelection frame = new BankSelection(null);
		frame.setVisible(true);
	}
	public BankSelection(final Person p1) {
		//getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 465);
		getContentPane().setLayout(null);
		ImageIcon bank1=new ImageIcon(BankSelection.class.getResource("hdfcb_logo.png"));
		JButton hdfc = new JButton(bank1);
		hdfc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sourcing	source = new Sourcing(p1);
				//source.setExtendedState(JFrame.MAXIMIZED_BOTH);
				source.setVisible(true);
				source.setBounds(100,100,821,465);
				BankSelection.this.setVisible(false);
				dispose();
			}
		});
		hdfc.setBounds(38, 83, 150, 150);
		getContentPane().add(hdfc);
		ImageIcon bank2=new ImageIcon(BankSelection.class.getResource("axis.jpg"));
		JButton axis = new JButton(bank2);
		axis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sourcing	source = new Sourcing(p1);
				//source.setExtendedState(JFrame.MAXIMIZED_BOTH);
				source.setVisible(true);
				source.setBounds(100,100,821,465);
				BankSelection.this.setVisible(false);
				dispose();
			}
		});
		axis.setBounds(250, 83, 150, 150);
		getContentPane().add(axis);
		ImageIcon bank3=new ImageIcon(BankSelection.class.getResource("ICICI-Bank-Logo1_80_80.jpg"));
		JButton icici = new JButton(bank3);
		icici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sourcing	source = new Sourcing(p1);
				//source.setExtendedState(JFrame.MAXIMIZED_BOTH);
				source.setVisible(true);
				source.setBounds(100,100,821,465);
				BankSelection.this.setVisible(false);
				dispose();
			}
		});
		icici.setBounds(450, 83, 150, 150);
		getContentPane().add(icici);
		new ImageIcon(BankSelection.class.getResource("ICICI-Bank-Logo1_80_80.jpg"));
		JButton sbi = new JButton(bank3);
		icici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sourcing	source = new Sourcing(p1);
				//source.setExtendedState(JFrame.MAXIMIZED_BOTH);
				source.setVisible(true);
				source.setBounds(100,100,821,465);
				BankSelection.this.setVisible(false);
				dispose();
			}
		});
		sbi.setBounds(650, 83, 150, 150);
		getContentPane().add(sbi);
		JLabel lblBankSelection = new JLabel("SELECT BANK");
		lblBankSelection.setFont(new Font("Cornerstone", Font.BOLD, 30));
		lblBankSelection.setBounds(320, 16, 215, 23);
		getContentPane().add(lblBankSelection);
		JLabel bankSleectionText = new JLabel("Select a bank with which you want to deak with.");
		bankSleectionText.setFont(new Font("Cornerstone", Font.BOLD, 20));
		bankSleectionText.setBounds(170, 300, 550, 23);
		getContentPane().add(bankSleectionText);
	}
}
