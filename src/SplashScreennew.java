
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.Timer;

import javazoom.jl.player.Player;

import org.apache.log4j.Logger;


public class SplashScreennew extends JWindow {
	
	Logger logger=Logger.getLogger(SplashScreennew.class);
	int color=1;
	int x=33;
	Icon icon=new ImageIcon(SplashScreennew.class.getResource("loan.jpg"));
	private final JProgressBar progressBar = new JProgressBar();
	int progressVal=1;
	Timer progressTimer=null;
	private JTextField txtLoading;
	boolean isVisible=true;
	JLabel Loading = new JLabel("Loading..");
	Timer timer=null;
	
	
	 Player playMP3;
	
	public static void main(String[] args) {
		SplashScreennew frame=new SplashScreennew();
		frame.setLocation(100,100	);
		frame.setVisible(true);
		frame.doAnimation();
		frame.doProgress();
		//frame.playSound();

	}

private void playSound(){
	//soundTimer.start();
	try{
	    FileInputStream fis = new FileInputStream("song.mp3");
	    playMP3 = new Player(fis);
	    playMP3.play();
	    
	}
	catch(Exception exc){
	    exc.printStackTrace();
	  System.out.println("Failed to play the file.");
}
} 
	



private void doProgress(){
	logger.debug("Progress bar executed");
	
	
	ActionListener l=new ActionListener() {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(progressVal<=progressBar.getMaximum()){
				
				progressBar.setValue(progressVal);
				progressVal++;
				
			}
			else{
				//soundTimer.stop();
				SplashScreennew.this.setVisible(false);
				if(progressTimer!=null){
					progressTimer.stop();
					//playMP3.close();
					logger.debug("Progress bar completed");
				}
				
				SplashScreennew.this.dispose();
			
				Login login=new Login();
				login.setVisible(true);
				//login.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		}
	};
	
	progressTimer =new Timer(50,l);
	progressTimer.start();
	
}
private void doAnimation(){


		Loading.setVisible(isVisible);
		isVisible = !isVisible;
	
}
		
	

	
	
	public SplashScreennew() {
		getContentPane().setBackground(Color.WHITE);
		
		setBounds(100, 100, 596, 400);
		
		getContentPane().setLayout(null);
		
		JLabel LoanImage = new JLabel( " ");
		LoanImage.setIcon(icon);
		LoanImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		LoanImage.setBounds(0, 0, 596, 326);
		getContentPane().add(LoanImage);
		progressBar.setBounds(0, 370, 596, 13);
		progressBar.setForeground(Color.CYAN);
		progressBar.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(progressBar);
		
		JLabel LoanText = new JLabel("Loan Originating System [LOS]...");
		LoanText.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		LoanText.setBounds(15, 335, 350, 30);
		getContentPane().add(LoanText);
	
		
		
		
		
	}
}
