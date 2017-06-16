
//import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.apache.log4j.Logger;
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
public class Emi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String loanTenure;
	String applicName;
	String loanAmt;
	String applicId;
	Double emiPlan;
	Double amtWithIntrest = 0.0;
	Logger logger = Logger.getLogger(Emi.class);
	public Emi(final Person p1) {
		logger.debug("In EMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 393);
		getContentPane().setLayout(null);
		JLabel headingLbl = new JLabel("EMI Plan");
		headingLbl.setForeground(Color.RED);
		headingLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		headingLbl.setBounds(33, 27, 129, 41);
		getContentPane().add(headingLbl);
		JLabel PlanLbl = new JLabel("Your Proposed EMI  Status :");
		PlanLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		PlanLbl.setBounds(33, 77, 176, 30);
		getContentPane().add(PlanLbl);
		JLabel amountLbl = new JLabel("Loan Amt : ");
		amountLbl.setBounds(33, 139, 83, 14);
		getContentPane().add(amountLbl);
		JLabel tenureLbl = new JLabel("Tenure :");
		tenureLbl.setBounds(33, 175, 46, 14);
		getContentPane().add(tenureLbl);
		JLabel lblAmt = new JLabel("");
		lblAmt.setBounds(95, 139, 91, 14);
		getContentPane().add(lblAmt);
		lblAmt.setText(p1.getLoanAmt() + " Rs.");
		JLabel lblTenure = new JLabel("");
		lblTenure.setBounds(89, 175, 97, 14);
		getContentPane().add(lblTenure);
		lblTenure.setText(p1.getLoanTenure() + " months");
		JLabel status = new JLabel("");
		status.setFont(new Font("Tahoma", Font.PLAIN, 14));
		status.setForeground(Color.RED);
		status.setBounds(89, 222, 313, 28);
		getContentPane().add(status);
		JLabel emi = new JLabel(" EMI :");
		emi.setBounds(33, 222, 46, 14);
		getContentPane().add(emi);
		EmiCalc emiCalc = new EmiCalc();
		emiPlan = emiCalc.emiCalculation(p1);
		status.setText("Rs. " + emiPlan + "      per month  for  " + p1.getLoanTenure() + "  months");
		loanTenure = p1.getLoanTenure();
		applicName = p1.getUsername();
		applicId = p1.getUserId();
		loanAmt = p1.getLoanAmt();
		amtWithIntrest = ((emiPlan) * (Double.valueOf(loanTenure)));
		JButton btnPdf = new JButton("Generate PDF");
		btnPdf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				samplePDF();
			}
		});
		btnPdf.setBounds(33, 292, 100, 23);
		getContentPane().add(btnPdf);
		// String enableText=Boolean.toString(Sourcing.enable);
	}
	@SuppressWarnings("deprecation")
	private void samplePDF() {
		Document doc = new Document();
		PdfWriter docWriter = null;
		DecimalFormat df = new DecimalFormat("0.00");
		try {
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream("D:\\Test10.pdf"));
			// document header attributes
			doc.addAuthor("betterThanZero");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("MySampleCode.com");
			doc.addTitle("EMI Plan Report..");
			doc.setPageSize(PageSize.LETTER);
			// open document
			doc.open();
			// create a paragraph
			Paragraph paragraph = new Paragraph("Thanks for choosing Loan Origination System.........");
			// specify column widths
			float[] columnWidths = { 1f, 2f, 1.5f, 5f, 2f };
			// create PDF table with the given widths
			PdfPTable table = new PdfPTable(columnWidths);
			// set table width a percentage of the page width
			table.setWidthPercentage(90f);
			// insert column headings
			insertCell(table, "EMI NO. ", Element.ALIGN_RIGHT, 1);
			insertCell(table, "Date Due", Element.ALIGN_RIGHT, 1);
			insertCell(table, "ID NO.", Element.ALIGN_LEFT, 1);
			insertCell(table, "Amount(in Rs.)", Element.ALIGN_MIDDLE, 1);
			insertCell(table, "Balance(in Rs.)", Element.ALIGN_RIGHT, 1);
			table.setHeaderRows(1);
			// insert an empty row
			insertCell(table, "", Element.ALIGN_LEFT, 5);
			// create section heading by cell merging
			double balanceAmt;
			// just some random data to fill
			Date date = new Date();
			int month = date.getMonth() + 1;
			int year = date.getYear() + 1900;
			for (int x = 0; x < Integer.parseInt(loanTenure); x++) {
				month = month + 1;
				if (month == 13) {
					month = 1;
					year += 1;
				}
				insertCell(table, "" + (x + 1), Element.ALIGN_RIGHT, 1);
				insertCell(table, date.getDate() + "/" + month + "/" + year, Element.ALIGN_LEFT, 1);
				insertCell(table, applicId, Element.ALIGN_RIGHT, 1);
				insertCell(table, Double.toString(emiPlan), Element.ALIGN_MIDDLE, 1);
				balanceAmt = (Double.valueOf(amtWithIntrest) - ((x + 1) * emiPlan));
				insertCell(table, df.format(balanceAmt), Element.ALIGN_RIGHT, 1);
			}
			// merge the cells to create a footer for that section
			insertCell(table, "Total amount is ...", Element.ALIGN_RIGHT, 3);
			insertCell(table, "" + amtWithIntrest, Element.ALIGN_RIGHT, 1);
			// add the PDF table to the paragraph
			paragraph.add(table);
			// add the paragraph to the document
			doc.add(paragraph);
			doc.add(new Paragraph("Applicant's Name : " + applicName + "   as  " + applicId));
			doc.add(Chunk.NEWLINE);
			doc.add(new Paragraph("Loan Amount  : Rs. " + loanAmt));
			doc.add(new Paragraph("Total amount payable is  : Rs. " + amtWithIntrest));
			doc.add(Chunk.NEWLINE);
			doc.add(new Paragraph("Tenure :  " + loanTenure + " Months "));
			doc.add(Chunk.NEWLINE);
		} catch (DocumentException dex) {
			System.out.println("file nt exists");
			dex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("general");
			ex.printStackTrace();
		} finally {
			if (doc != null) {
				// close the document
				doc.close();
			}
			if (docWriter != null) {
				// close the writer
				docWriter.close();
			}
		}
	}
	private void insertCell(PdfPTable table, String text, int align, int colspan) {
		// create a new cell with the specified Text and Font
		PdfPCell cell = new PdfPCell(new Phrase(text.trim()));
		// set the cell alignment
		cell.setHorizontalAlignment(align);
		// set the cell column span in case you want to merge two or more cells
		cell.setColspan(colspan);
		// in case there is no text and you wan to create an empty row
		if (text.trim().equalsIgnoreCase("")) {
			cell.setMinimumHeight(10f);
		}
		// add the call to the table
		table.addCell(cell);
	}
}
