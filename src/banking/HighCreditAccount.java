package banking;

public class HighCreditAccount extends Account {

	private double interest_rate;
	private String grade;  
	
	public HighCreditAccount(String accountNumber, String name, int balance, double interest_rate, String grade) {
		super( accountNumber, name, balance );
		this.interest_rate = interest_rate;
		this.grade = grade;
	}
	
	@Override
	public void showAllData() {
		super.showAllData();
		System.out.print( ", 이자율 : "+ interest_rate + ", 등급 " + grade +"\n" );
		
	}

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
}
