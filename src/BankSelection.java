
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankSelection extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		
					BankSelection frame = new BankSelection(null);
					frame.setVisible(true);
				
	}

	public BankSelection(final Person p1) {
		//getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		ImageIcon bank1=new ImageIcon(BankSelection.class.getResource("hdfcb_logo.png"));
		JButton hdfc = new JButton(bank1);
		hdfc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sourcing	source = new Sourcing(p1);
				source.setExtendedState(JFrame.MAXIMIZED_BOTH);
				source.setVisible(true);
				source.setBounds(100,100,821,500);
				BankSelection.this.setVisible(false);
				dispose();
			}
		});
		hdfc.setBounds(38, 83, 80, 80);
		getContentPane().add(hdfc);
		ImageIcon bank2=new ImageIcon(BankSelection.class.getResource("axis.jpg"));
		JButton axis = new JButton(bank2);
		axis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sourcing	source = new Sourcing(p1);
				source.setExtendedState(JFrame.MAXIMIZED_BOTH);
				source.setVisible(true);
				source.setBounds(100,100,821,500);
				BankSelection.this.setVisible(false);
				dispose();
			}
		});
		axis.setBounds(173, 83, 80, 80);
		getContentPane().add(axis);
		ImageIcon bank3=new ImageIcon(BankSelection.class.getResource("ICICI-Bank-Logo1_80_80.jpg"));
		JButton icici = new JButton(bank3);
		icici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Sourcing	source = new Sourcing(p1);
			source.setExtendedState(JFrame.MAXIMIZED_BOTH);
			source.setVisible(true);
			source.setBounds(100,100,821,500);
			BankSelection.this.setVisible(false);
			dispose();
			}
		});
		icici.setBounds(303, 83, 80, 80);
		getContentPane().add(icici);
		
		JLabel lblBankSelection = new JLabel("BANK SELECTION");
		lblBankSelection.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblBankSelection.setBounds(123, 16, 215, 23);
		getContentPane().add(lblBankSelection);
		
		/*Sourcing	source = new Sourcing(p1);
		source.setExtendedState(JFrame.MAXIMIZED_BOTH);
		source.setVisible(true);
		source.setBounds(100,100,821,500);
		BankSelection.this.setVisible(false);
		dispose();*/
	}
}
