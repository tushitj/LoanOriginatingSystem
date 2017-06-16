
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Serial {
	public static int carLoan=0;
	public static int homeLoan=0;
	public static int eduLoan=0;
	public static boolean serialRes=false;
	static public void idCounter() throws FileNotFoundException{
		File file=new File("//Users//tushitjain//Downloads//LoanOriginatingSystem-master");
		File files [] = file.listFiles();
		for(File f: files){
			if(f.isFile())
			{
				if(f.getName().contains("EL")){
					eduLoan++;
				}
				else if(f.getName().contains("HL")){
					homeLoan++;
				}
				else if(f.getName().contains("CL")){
					carLoan++;
				}
			}
		}
		System.out.println("edu is "+eduLoan);
		System.out.println("car is "+carLoan);
		System.out.println("home is "+homeLoan);
	}
	static public void saveState(Person person) throws IOException{
		FileOutputStream file=new FileOutputStream("//Users//tushitjain//Downloads//LoanOriginatingSystem-master//"+person.getUserId()+".txt");
		ObjectOutputStream writing=new ObjectOutputStream(file);
		writing.writeObject(person);
		System.out.println("person created");
		writing.close();
	}
	static public void loadState(String userRegistered,String passwordRegistered) throws IOException, ClassNotFoundException{
		FileInputStream fi=new FileInputStream("//Users//tushitjain//Downloads//LoanOriginatingSystem-master//"+userRegistered+".txt");
		ObjectInputStream  reading=new ObjectInputStream(fi);
		Person p1=(Person)(reading.readObject());
		System.out.println("pass typed is "+passwordRegistered);
		System.out.println("pass is "+p1.getPassword());
		System.out.println("assets i s"+p1.getAssets());
		System.out.println("person detected  "+p1);
		System.out.println("pname is "+p1.getUsername()+"stage is "+p1.getStage());
		if(passwordRegistered.equals(p1.getPassword())){
			if(p1.getStage()==1){
				serialRes= true;
				Sourcing s=new Sourcing(p1);
				System.out.println("in 1 stage");
				s.setVisible(true);
			}
			else if(p1.getStage()==2){
				serialRes= true;
				System.out.println("in 2 stage");
				qde q=new qde(p1);
				q.setVisible(true);
			}
		}
		else{
			System.out.println("wrong credentials");
		}
		System.out.println(p1.getAge()+"age of person");
		reading.close();
	}
}
