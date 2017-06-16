
public class DedupeCalc {
	final int MIN_Age=18;
	final int MID_AGE=40;
	final int ADULT_AGE=55;
	final int LESS_EXP=5;
	final int MID_EXP=10;
	static double score=0;
	double nationScore=0;
	double ageScore=0;
	double liabScore=0;
	double tenureScore=0;
	double statusScore=0;
	double genderScore=0;
	double professionScore=0;
	boolean correct;
	static boolean loanCheck;
	public double professionCheck(Person p1){
		System.out.println("in prof blck");
		String exp1=p1.getExperience();
		int exp=Integer.parseInt(exp1);
		if(p1.getProfession()=="Job"){
			if(exp<LESS_EXP){
				professionScore=professionScore+0.5;
				System.out.println(" exp score is "+professionScore);
				return professionScore;
			}
			else if(exp<MID_EXP){
				professionScore=professionScore+1.0;
				System.out.println(" exp score is "+professionScore);
				return professionScore;
			}
			else{
				professionScore=professionScore+1.7;
				System.out.println(" exp escore is "+professionScore);
				return professionScore;
			}
		}
		else{
			if(exp<LESS_EXP){
				professionScore=professionScore+0.3;
				System.out.println("exp score is "+professionScore);
				return professionScore;
			}
			else if(exp<MID_EXP){
				professionScore=professionScore+0.7;
				System.out.println("exp score is "+professionScore);
				return professionScore;
			}
			else{
				professionScore=professionScore+1.3;
				System.out.println("exp score is "+professionScore);
				return professionScore;
			}
		}
	}
	public double nationCheck(Person p1){
		if(p1.getNationality()!="Indian"){
			nationScore=nationScore-1.0;
			System.out.println("nation score is "+nationScore);
			return nationScore;
		}
		System.out.println("nation score  is "+nationScore);
		return nationScore;
	}
	public double genderCheck(Person p1){
		if(p1.getGender()=="Female"){
			System.out.println("female scre");
			genderScore=genderScore+0.4;
			System.out.println("gender score is "+genderScore);
			return genderScore;
		}
		System.out.println("gender else score ois "+genderScore);
		return genderScore;
	}
	public double statusCheck(Person p1){
		if(p1.getCreditStatus()== "Single"){
			statusScore=statusScore+0.5;
			System.out.println( "staus sing score is "+statusScore);
			return statusScore;
		}
		else if(p1.getCreditStatus()== "Firm"){
			statusScore=statusScore+1.0;
			System.out.println("status firm score is "+statusScore);
			return statusScore;
		}
		else{
			statusScore=statusScore+1.5;
			System.out.println(" corp status score is "+statusScore);
			return statusScore;
		}
	}
	public double ageCheck(Person p1){
		String age1=p1.getAge();
		int age=Integer.parseInt(age1);
		if(age<MIN_Age || age>ADULT_AGE){
			ageScore=ageScore-1;
			System.out.println("age score is "+ageScore);
			System.out.println("min age scre");
			return ageScore;
		}
		else if(age>MIN_Age && age<MID_AGE){
			ageScore=ageScore+2;
			System.out.println("mid age scre");
			System.out.println("age score is "+ageScore);
			return ageScore;
		}
		else{
			ageScore=ageScore+1;
			System.out.println("max age scre");
			System.out.println("age score is "+ageScore);
			return ageScore;
		}
	}
	public double tenureCheck(Person p1){
		int tenure=Integer.parseInt(p1.getLoanTenure());
		if(tenure<20){
			tenureScore=tenureScore+2.3;
			System.out.println("tenre score is "+tenureScore);
			System.out.println("min tenure scre");
			return tenureScore;
		}
		else if(tenure<30){
			tenureScore=tenureScore+1.7;
			System.out.println("tenre score is "+tenureScore);
			System.out.println("mid ten scre");
			return tenureScore;
		}
		else if(tenure<55){
			System.out.println("mid+ ten scre");
			System.out.println("tenre score is "+tenureScore);
			tenureScore=tenureScore+1.3;
			return tenureScore;
		}
		else{
			tenureScore=tenureScore+0.8;
			System.out.println("max ten scre");
			System.out.println("tenre score is "+tenureScore);
			return tenureScore;
		}
	}
	public boolean loanTypeCheck(Person p1){
		System.out.println("checking");
		int amt=Integer.parseInt(p1.getLoanAmt());
		int value=Integer.parseInt(p1.getLoanValue());
		if(p1.getLoanType()=="Home Loan"){
			System.out.println("in home loan blck");
			if (amt<=((0.85)*value)){
				System.out.println("in home if");
				loanCheck=true;
			}
			else{
				System.out.println("in home else");
				loanCheck=false;
			}
			return loanCheck;	
		}
		else if(p1.getLoanType()=="Car Loan"){
			System.out.println("in car loan blk");
			if (amt<=((0.60)*value)){
				System.out.println("in car if");
				loanCheck=true;
			}
			else{
				System.out.println("in car else");
				loanCheck=false;
			}
			return loanCheck;
		}
		System.out.println("failure blk");
		return loanCheck;
	}
	public boolean valCheck(String val1,String val2,Person p1){
		int amt=Integer.parseInt(val1);
		int value=Integer.parseInt(val2);
		if(value<amt){
			System.out.println("in value<amt");
			correct=false;
			return correct;
		}
		else{
			System.out.println("in amt<val");
			correct=true;
			return correct;
		}
	}
	public double liabScore(Person p1){
		int liability=Integer.parseInt(p1.getLiability());
		int asset=Integer.parseInt(p1.getAssets());
		double checkVal=0.7*(asset);
		double checkVal1=0.4*(asset);
		if(liability>checkVal){
			liabScore=liabScore+0.8;
			System.out.println("liab score is "+liabScore);
			return score;
		}
		else if(liability>checkVal1){
			liabScore=liabScore+1.4;
			System.out.println("liab score is "+liabScore);
			return liabScore;
		}
		else{
			liabScore=liabScore+2.1;
			System.out.println("liab score is "+liabScore);
			return liabScore;
		}
	}
}
