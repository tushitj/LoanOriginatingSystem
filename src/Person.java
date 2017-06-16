
import java.io.Serializable;
public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	@Override
	public String toString() {
		return "Person [username=" + username + ", password=" + password
				+ ", age=" + age + "stage = "+ stage+ "]";
	}
	private int stage;
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String username;
	private String password;
	private String age;
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	private String loanType;
	private String loanAmt;
	private String adress;
	private String agentName;
	private String phone;
	private int choiceMaritialID;
	private int choiceEduID;
	private int choiceStatusID;
	private int choiceNationID;
	private int choiceIncomeID;
	private int listProfessionID;
	private int loanTypeId;
	public int getListProfessionID() {
		return listProfessionID;
	}
	public void setListProfessionID(int listProfessionID) {
		this.listProfessionID = listProfessionID;
	}
	public int getChoiceMaritialID() {
		return choiceMaritialID;
	}
	public void setChoiceMaritialID(int choiceMaritialID) {
		this.choiceMaritialID = choiceMaritialID;
	}
	public int getChoiceEduID() {
		return choiceEduID;
	}
	public void setChoiceEduID(int choiceEduID) {
		this.choiceEduID = choiceEduID;
	}
	public int getChoiceStatusID() {
		return choiceStatusID;
	}
	public void setChoiceStatusID(int choiceStatusID) {
		this.choiceStatusID = choiceStatusID;
	}
	public int getChoiceNationID() {
		return choiceNationID;
	}
	public void setChoiceNationID(int choiceNationID) {
		this.choiceNationID = choiceNationID;
	}
	public int getChoiceIncomeID() {
		return choiceIncomeID;
	}
	public void setChoiceIncomeID(int choiceIncomeID) {
		this.choiceIncomeID = choiceIncomeID;
	}
	public int getLoanTypeId() {
		return loanTypeId;
	}
	public void setLoanTypeId(int loanTypeId) {
		this.loanTypeId = loanTypeId;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	private String loanTenure;
	private String loanValue;
	private String liability;
	private String assets;
	private String gender;
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	private String maritial;
	private String education;
	private String profession;
	private String experience;
	private String income;
	private String nationality;
	private String creditStatus;
	private String voter;
	private String pan;
	private String cibilScore;
	public String getVoter() {
		return voter;
	}
	public void setVoter(String voter) {
		this.voter = voter;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(String cibilScore) {
		this.cibilScore = cibilScore;
	}
	public String getMaritial() {
		return maritial;
	}
	public void setMaritial(String maritial) {
		this.maritial = maritial;
	}
	public  String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLiability() {
		return liability;
	}
	public void setLiability(String liability) {
		this.liability = liability;
	}
	public String getAssets() {
		return assets;
	}
	public void setAssets(String assets) {
		this.assets = assets;
	}
	public String getLoanValue() {
		return loanValue;
	}
	public void setLoanValue(String loanValue) {
		this.loanValue = loanValue;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static void main(String args[]){
		//Person p=new Person();
	}
	public String getLoanType() {
		return loanType;
	}
	/*public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}*/
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(String loanAmt) {
		this.loanAmt = loanAmt;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}
}
