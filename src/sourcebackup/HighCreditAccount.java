package sourcebackup;

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
	
	@Override
	public boolean equals( Object obj ) {
		
		System.out.println("HighCreditAccount equals() 호출됨");
		
		HighCreditAccount hc = null;		
		boolean check = false;
		
		if( obj instanceof NormalAccount ) {
			
			hc = (HighCreditAccount)obj;
			
			if( hc.getAccountNumber().equals( super.getAccountNumber() ) &&
					hc.getName().equals( super.getName() ) ) {
				System.out.println("하이 11 들어온다.");
				check = true;
				
			}else {
				System.out.println("하이 22 들어온다.");
				check = false;
			}			
			
		}
		
		return check;
		
	}
	
	
	
	
}
