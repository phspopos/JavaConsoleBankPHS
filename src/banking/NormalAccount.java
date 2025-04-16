package banking;

import java.io.Serializable;

public class NormalAccount extends Account implements Serializable{
	
	private double interest_rate;
	
	
	public NormalAccount(String accountNumber, String name, int balance, double interest_rate) {
		super( accountNumber, name, balance );
		this.interest_rate = interest_rate;		
	}
	
	@Override
	public void showAllData() {
		//System.out.println("아버지");
		super.showAllData();
		System.out.print( ", 이자율 : "+ interest_rate + "\n");
		
	}

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	
	@Override
	public boolean equals( Object obj ) {
		
		System.out.println("NormalAccount equals() 호출됨");
		
		NormalAccount nc = null;		
		boolean check = false;
		
		if( obj instanceof NormalAccount ) {
			
			nc = (NormalAccount)obj;
			
			if( nc.getAccountNumber().equals( super.getAccountNumber() ) &&
					nc.getName().equals( super.getName() ) ) {
				
				check = true;
				
			}else {
				
				check = false;
			}			
			
		}
		
		return check;
		
	}
	
	
}
