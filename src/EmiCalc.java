
public class EmiCalc {
	public final int TENURE_MIN=15;
	public final int TENURE_MID=37;
	public final int TENURE_MAX=62;
	public double emiCalculation(Person p1){
		int loanAmount=Integer.parseInt(p1.getLoanAmt());
		int loanTenure=Integer.parseInt(p1.getLoanTenure());
		double plan;
		if(loanTenure<TENURE_MIN){
			plan=(loanAmount/loanTenure)+(loanAmount/100);
			return plan;
		}
		else if(loanAmount<TENURE_MID){
			plan=(loanAmount/loanTenure)+(1.5*(loanAmount/100));
			return plan;
		}
		else if(loanAmount<TENURE_MAX){
			plan=(loanAmount/loanTenure)+(1.9*(loanAmount/100));
			return plan;
		}
		else{
			plan=(loanAmount/loanTenure)+(2.5*(loanAmount/100));
			return plan;
		}
	}
}
