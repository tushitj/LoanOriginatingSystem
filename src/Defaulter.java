import org.apache.log4j.Logger;


public final class Defaulter {
	Logger logger=Logger.getLogger(Defaulter.class);

	static boolean userValid=true;
	static boolean userPhoneValid=true;
	static boolean userVoterValid=true;
	static boolean userPanValid=true;
	static int defaultCounter=0;
	
	 String defName;
	 String defVoter;
	 String defPan;
	 String defPhone;
	
	public String getDefPhone() {
		return defPhone;
	}

	public void setDefPhone(String defPhone) {
		this.defPhone = defPhone;
	}

	public String getDefPan() {
		return defPan;
	}

	public void setDefPan(String defPan) {
		this.defPan = defPan;
	}

	public String getDefName() {
		return defName;
	}

	public  void setDefName(String defName) {
		this.defName = defName;
	}

	public  String getDefVoter() {
		return defVoter;
	}

	public  void setDefVoter(String defVoter) {
		this.defVoter = defVoter;
	}
	
	
	/*private void initialize()
	{
		 System.out.println("NAme is : "+def.getDefName());
	}*/

	
	public void defChecker(Person p1){
		Defaulter def=new Defaulter();
		 def.setDefName("daud");
		 def.setDefVoter("abc0123456");
		 def.setDefPan("abcd0123ef");
		 def.setDefPhone("1111222233");
		 
		 Defaulter def1=new Defaulter();
		 def1.setDefName("abu");
		 def1.setDefVoter("def9876543");
		 def1.setDefPan("jklm4567no");
		 def1.setDefPhone("4444555566");
		
		 Defaulter def2=new Defaulter();
		 def2.setDefName("osama");
		 def2.setDefVoter("xyz1234567");
		 def2.setDefPan("pqrs8901tu");
		 def2.setDefPhone("7777888899");
		 
		 
		 
		//System.out.println("person : "+p1);
		
	
		
		
				checkDefaulter(p1,def,def1,def2);
				
		
		
	}
	
	
	public void checkDefaulter(Person p1,Defaulter d1,Defaulter d2,Defaulter d3){

		logger.debug("checking defaulter");

		
		if(p1.getPhone().equals(d1.getDefPhone()) || p1.getPhone().equals(d2.getDefPhone()) || p1.getPhone().equals(d3.getDefPhone())){
			//		System.out.println("in def votr method");
			logger.debug("Fraud detected");
					Sourcing.enable=true;
					userPhoneValid=false;
					defaultCounter++;
					System.out.println("phone defaulter"+defaultCounter);
					logger.debug("phone defaulter");
				}
	
		
		
		
		
		if(p1.getPan().equals(d1.getDefPan()) || p1.getPan().equals(d2.getDefPan()) || p1.getPan().equals(d3.getDefPan())){
			//		System.out.println("in def votr method");
			logger.debug("Fraud detected");
					Sourcing.enable=true;
					userPanValid=false;
					System.out.println("pan defaulter"+defaultCounter);
					logger.debug("pan card defaulter");
					
				
				}
	
		
	
	if(p1.getVoter().equals(d1.getDefVoter()) || p1.getVoter().equals(d2.getDefVoter()) || p1.getVoter().equals(d3.getDefVoter())){
	//		System.out.println("in def votr method");
		logger.debug("Fraud detected");	
		Sourcing.enable=true;
		userVoterValid=false;
		System.out.println("voter defaulter"+defaultCounter);
		logger.debug("voter card defaulter");
		}
	
	
	
			
		if(p1.getUsername().equals(d1.getDefName()) || p1.getUsername().equals(d2.getDefName()) || p1.getUsername().equals(d3.getDefName()))
		{
			logger.debug("Fraud detected");
		Sourcing.enable=true;
		userValid=false;
		defaultCounter++;
		System.out.println("name defaulter"+defaultCounter);
	
		}

	}

}
