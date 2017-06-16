
public class qdeSelection {
	static public void MaritialId(Person p1){
		System.out.println("martial status detected is "+p1.getMaritial());
		if(p1.getMaritial()=="Single"){
			p1.setChoiceMaritialID(0);
		}
		else if(p1.getMaritial()=="Married"){
			p1.setChoiceMaritialID(1);
		}
		else if(p1.getMaritial()=="Divorced"){
			p1.setChoiceMaritialID(2);
		}
		else{
			p1.setChoiceMaritialID(3);
		}
		System.out.println("married id si "+p1.getChoiceMaritialID());
	}
	static public void statusId(Person p1){
		if(p1.getCreditStatus()=="Single"){
			p1.setChoiceStatusID(0);
		}
		else if(p1.getCreditStatus()=="Firm"){
			p1.setChoiceStatusID(1);
		}
		else{
			p1.setChoiceStatusID(2);
		}
		System.out.println("choice staus is  " +p1.getChoiceStatusID());
	}
	static public void  nationid(Person p1){
		if(p1.getNationality()=="Indian"){
			p1.setChoiceNationID(0);
		}
		else{
			p1.setChoiceNationID(1);
			System.out.println("nation id result is "+p1.getChoiceNationID());
		}
	}
	static public void incomeId(Person p1){
		if(p1.getIncome()==" < 3 lakh"){
			p1.setChoiceIncomeID(0);
		}
		else if(p1.getIncome()==" 3-7 lakh"){
			p1.setChoiceIncomeID(1);
		}
		else if(p1.getIncome()==" 7-15 lakh"){
			p1.setChoiceIncomeID(2);
		}
		else{
			p1.setChoiceIncomeID(3);
		}
		System.out.println("income select is "+p1.getChoiceIncomeID());
	}
	static public void educationId(Person p1){
		if(p1.getEducation()=="10th"){
			p1.setChoiceEduID(0);
		}
		else if(p1.getEducation()=="12th"){
			p1.setChoiceEduID(1);
		}
		else if(p1.getEducation()=="Graduate"){
			p1.setChoiceEduID(2);
		}
		else if(p1.getEducation()=="Masters"){
			p1.setChoiceEduID(3);
		}
		else{
			p1.setChoiceEduID(4);
		}
		System.out.println("edu select is "+p1.getChoiceEduID());
	}
	public static void professionId(Person p1){
		if(p1.getProfession()=="Job"){
			p1.setListProfessionID(1);
		}
		else if(p1.getProfession()=="Business"){
			p1.setListProfessionID(2);
		}
		else if(p1.getProfession()=="Practice"){
			p1.setListProfessionID(3);
		}
		else{
			p1.setListProfessionID(0);
		}
		System.out.println("profession is "+p1.getListProfessionID());
	}
}
