public class SourceClass {
	public boolean valid;
	public boolean formVal;
	public boolean qdeFormVal;
	public void loanSelect(String type,Person p1){
		p1.setLoanType(type);
		if(p1.getLoanType()=="Car Loan"){
			p1.setLoanTypeId(1);
		}
		else if(p1.getLoanType()=="Home Loan"){
			p1.setLoanTypeId(2);
		}
		else {
			p1.setLoanTypeId(3);
		}
		System.out.println("loan id is "+p1.getLoanTypeId());
		System.out.println("loan type is "+p1.getLoanType());
	}
	public boolean checkPhone(String phoneNo,Person p1){
		if(phoneNo.trim().length()==10){
			p1.setPhone(phoneNo);
			return valid=true;
		}
		else{
			p1.setPhone(null);
			return valid=false;
		}
	}
	public boolean formValid(Person p1){
		if(p1.getLoanType()!=null &&p1.getAge()!=null && p1.getLoanAmt()!=null && p1.getPhone()!=null && p1.getAdress()!=null && p1.getLoanTenure()!=null && p1.getAgentName()!=null && p1.getLoanValue()!=null && p1.getAssets()!=null && p1.getLiability()!=null)
		{
			return formVal=true;
		}
		else{
			return formVal=false;
		}
	}
	public boolean qdeFormValid(Person p1){
		if(p1.getGender()!=null && p1.getProfession()!=null && p1.getMaritial()!=null && p1.getEducation()!=null && p1.getVoter()!=null && p1.getPan()!=null  && p1.getExperience()!=null && p1.getIncome()!=null && p1.getCreditStatus()!=null && p1.getNationality()!=null  ){
			return qdeFormVal=true;	
		}
		else{
			return qdeFormVal=false;
		}
	}
	public String useridSetter(Person p1){
		String typeOfLoan;
		int num;
		if(p1.getLoanType()=="Car Loan"){
			typeOfLoan="CL";
			num=Serial.carLoan++;
		}
		else if(p1.getLoanType()=="Home Loan"){
			typeOfLoan="HL";
			num=Serial.homeLoan++;
		}
		else{
			typeOfLoan="EL";
			num=Serial.eduLoan++;
		}
		p1.setUserId((p1.getUsername().substring(0, 2))+typeOfLoan+num);
		return p1.getUserId();
	}
}
