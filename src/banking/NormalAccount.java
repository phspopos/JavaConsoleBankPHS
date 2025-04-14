package banking;

public class NormalAccount extends Account{
	
	private double interest_rate;
	
	
	public NormalAccount(String accountNumber, String name, int balance, double interest_rate) {
		super( accountNumber, name, balance );
		this.interest_rate = interest_rate;		
	}
	
	@Override
	public void showAllData() {
		super.showAllData();
		System.out.print( ", 이자율 : "+ interest_rate + "\n");
		
	}

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	
	
	
	
}
