
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.DefaultValueDataset;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/*import org.jfree.chart.ChartFactory;
	import org.jfree.chart.ChartFrame;
	import org.jfree.chart.JFreeChart;
	import org.jfree.chart.labels.PieSectionLabelGenerator;
	import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
	import org.jfree.chart.plot.PiePlot;
	import org.jfree.data.general.DefaultPieDataset;*/
//import javax.swing.JPanel;
import java.io.IOException;
public class Dedupe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger=Logger.getLogger(Dedupe.class);
	JFreeChart objChart;
	JLabel userLabel = new JLabel("");
	JLabel constLabel = new JLabel("Profile Summary");
	JLabel tenure = new JLabel("");
	JLabel lblTenure = new JLabel("Tenure :");
	JLabel amount = new JLabel("");
	JLabel lblAmt = new JLabel("Loan Amt : ");
	JLabel lblAge = new JLabel("Age : ");
	JLabel age = new JLabel("");
	private final JLabel scoring = new JLabel("SCORING");
	private final JLabel scoreResult = new JLabel("");
	private final JLabel lblValue = new JLabel("Value :");
	private final JLabel value = new JLabel("");
	private final JButton btnEmi = new JButton("Proceed to Emi Plan");
	JLabel lblCharts = new JLabel("View Score Graphically???");
	Choice choiceChart = new Choice();
	public final double EMI_ACTIVE=5.5;
	public final double EMI_REFER=3.0;
	private final JLabel apply = new JLabel("");
	double result;
	double ageResult;
	double tenureResult;
	double liabResult;
	double nationResult;
	double statusResult;
	double professionResult;
	double genderResult;
	/*	public static void main(String[] args) {
					Dedupe frame = new Dedupe();
					frame.setVisible(true);
	}
	 */
	public Dedupe(final Person  p1) {
		logger.debug("IN dedupe calculation");
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 9));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userLabel.setBounds(247, 11, 179, 25);
		getContentPane().add(userLabel);
		userLabel.setText("WELCOME "+p1.getUsername());
		constLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		constLabel.setBounds(30, 57, 118, 25);
		getContentPane().add(constLabel);
		lblAge.setBounds(40, 97, 46, 14);
		getContentPane().add(lblAge);
		age.setBounds(112, 97, 96, 14);
		getContentPane().add(age);
		age.setText(p1.getAge() + " years");
		lblAmt.setBounds(40, 130, 65, 14);
		getContentPane().add(lblAmt);
		amount.setBounds(112, 130, 96, 14);
		getContentPane().add(amount);
		amount.setText(p1.getLoanAmt()+" Rs.");
		lblTenure.setBounds(40, 161, 46, 14);
		getContentPane().add(lblTenure);
		tenure.setText(p1.getLoanTenure()+ " months ");
		tenure.setBounds(112, 161, 96, 14);
		getContentPane().add(tenure);
		scoring.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		scoring.setForeground(Color.RED);
		scoring.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scoring.setBounds(30, 215, 419, 25);
		getContentPane().add(scoring);
		scoreResult.setBounds(218, 255, 231, 30);
		getContentPane().add(scoreResult);
		lblValue.setBounds(40, 186, 46, 14);
		getContentPane().add(lblValue);
		value.setBounds(122, 186, 86, 14);
		getContentPane().add(value);
		value.setText(p1.getLoanValue()+" Rs.");
		btnEmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEmi.setForeground(Color.RED);
		btnEmi.setBounds(21, 339, 185, 60);
		btnEmi.setEnabled(false);
		getContentPane().add(btnEmi);
		JLabel processLbl = new JLabel("");
		processLbl.setBounds(122, 225, 146, 30);
		getContentPane().add(processLbl);
		apply.setBounds(205, 64, 221, 25);
		getContentPane().add(apply);
		apply.setText("Applied for "+p1.getLoanType());
		JTextArea textArea = new JTextArea();
		textArea.setBounds(247, 272, -452, 78);
		getContentPane().add(textArea);
		choiceChart .add("Select the graph type");
		choiceChart.add("Pie Chart ...");
		//choiceChart.add("Bar Chart...");
		choiceChart.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(choiceChart.getSelectedItem()=="Pie Chart ..."){
					showPie();
					@SuppressWarnings("unused")
					Process winCalc;
					try {
						winCalc = Runtime.getRuntime().exec("\\Applications\\Calculator.app");
					} catch (IOException exp) {
						exp.printStackTrace();
					}
				}
			}
		});
		JButton viewScore = new JButton("Score-O-Meter");
		viewScore.setForeground(Color.RED);
		viewScore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		viewScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DemoChartProblem();
			}
		});
		viewScore.setBounds(343, 272, 196, 48);
		getContentPane().add(viewScore);
		lblCharts.setForeground(Color.ORANGE);
		lblCharts.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCharts.setBounds(410, 77, 221, 34);
		getContentPane().add(lblCharts);
		choiceChart.setBounds(410, 118, 179, 26);
		getContentPane().add(choiceChart);
		DedupeCalc calc= new DedupeCalc();
		ageResult=calc.ageCheck(p1);
		tenureResult=calc.tenureCheck(p1);
		liabResult=calc.liabScore(p1);
		nationResult=calc.nationCheck(p1);
		statusResult=calc.statusCheck(p1);
		genderResult=calc.genderCheck(p1);
		boolean check=calc.valCheck(p1.getLoanAmt(),p1.getLoanValue(),p1);
		boolean check1=calc.valCheck(p1.getLiability(), p1.getAssets(),p1);
		boolean loancheck=calc.loanTypeCheck(p1);
		System.out.println("check is "+check);
		System.out.println("check1 is "+check1);
		System.out.println("dedupe cal is "+DedupeCalc.loanCheck);
		System.out.println("laonchk is "+loancheck);
		logger.debug("Amt and Value "+check);
		logger.debug("Liab and asset "+check1);
		if(check && check1){
			System.out.println("check and check1 && loancheck");
			logger.debug("in check and check1");
			professionResult=calc.professionCheck(p1);
			//as the score is declared static in dedupecalc.java    ,,,,,  
			//therefore final result value is stored in professional result as it is called last.
			result=genderResult+statusResult+nationResult+professionResult+liabResult+tenureResult+ageResult;
			@SuppressWarnings("unused")
			int resVal=(int)result;
			logger.debug("Scoring is "+result);
			scoreResult.setText(Double.toString(result));
			//sucess.setText("Loan can be processed ....");
			if(result<EMI_REFER){
				processLbl.setText("Sorry... Score very low");
			}
			else if(result<EMI_ACTIVE){
				processLbl.setText("Refer to the Bank Manager.");
				btnEmi.setEnabled(true);
				btnEmi.setEnabled(true);
			}
			else{
				processLbl.setText("Congo.. U Are Eligible");
				btnEmi.setEnabled(true);
			}
		}
		else{
			scoreResult.setText("Sorry  Check ur credentials");
			processLbl.setText("Amt & Value mismatch");
			//sucess.setText("Apply later..");
		}
		btnEmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emi emi=new Emi(p1);
				Dedupe.this.setVisible(false);
				emi.setVisible(true);
				emi.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
	}
	private void showPie(){
		// Create DataSet for Pie
		DefaultPieDataset objDataset = new DefaultPieDataset();
		objDataset.setValue("Age",ageResult);
		objDataset.setValue("Tenure",tenureResult);
		objDataset.setValue("Liabilty",liabResult);
		objDataset.setValue("Status",statusResult);
		objDataset.setValue("Profession",professionResult);
		objDataset.setValue("Gender",genderResult);
		objDataset.setValue("Nationality",nationResult);
		// Specify Parameters for Pie
		objChart = ChartFactory.createPieChart ( "Score Parameters",     objDataset, 	    true,        true,             false     );
		ChartFrame frame = new ChartFrame("Pie-2015", objChart);
		frame.pack();
		frame.setVisible(true);
	}
	public class DemoChartProblem {
		private static final int DISPLAY_MAX = 10;
		private final DefaultValueDataset dataset = new DefaultValueDataset();
		private final DefaultValueDataset displayDataset = new DefaultValueDataset();
		private final JFrame frame = new JFrame();
		public DemoChartProblem() {
			frame.setPreferredSize(new Dimension(300, 300));
			frame.getContentPane().add(buildDialPlot(0, DISPLAY_MAX, 1));
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setValue(result);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(true);
				}
			});
		}
		private void setValue(double value) {
			dataset.setValue(value);
			displayDataset.setValue(Math.min(DISPLAY_MAX, value));
		}
		private ChartPanel buildDialPlot(int minimumValue, int maximumValue,
				int majorTickGap) {
			DialPlot plot = new DialPlot();
			plot.setDataset(0, dataset);
			plot.setDataset(1, displayDataset);
			plot.setDialFrame(new StandardDialFrame());
			// value indicator uses the real data set
			plot.addLayer(new DialValueIndicator(0));
			// needle uses constrained data set
			plot.addLayer(new DialPointer.Pointer(1));
			StandardDialScale scale = new StandardDialScale(minimumValue, maximumValue,
					-120, -300, majorTickGap, majorTickGap - 1);
			scale.setTickRadius(0.88);
			scale.setTickLabelOffset(0.20);
			plot.addScale(0, scale);
			return new ChartPanel(new JFreeChart(plot));
		}
	}
}
