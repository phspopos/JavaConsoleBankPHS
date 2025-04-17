package banking;

import java.io.Serializable;
import java.util.Objects;

public class HighCreditAccount extends Account implements Serializable{

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
	
	
	/*
	@Override
	public int hashCode() {
		
		int returnCode2 = Objects.hash(super.getAccountNumber() , this.interest_rate );
		System.out.println("하이2 returnCode2 = " + returnCode2);
		
		return returnCode2;
	}
	*/
	
	/*
	@Override
	public boolean equals( Object obj ) {
		
		System.out.println(" HighCreditAccount equals() 호출됨");
		
		boolean check = false;
		NormalAccount nc = null;
		HighCreditAccount hc = null;
		SpecialAccount sp = null;		
		
		if( obj instanceof SpecialAccount ) {
			sp = (SpecialAccount)obj;			
			
			//&& nc.getName().equals( super.getName() )
			if( sp.getAccountNumber().equals( super.getAccountNumber() )
					 ) {
				
				System.out.println("스페셜 1111");				
				check = true;
			
			}else {
				System.out.println("스페셜 2222");				
				check = false;
			}
		}else if( obj instanceof NormalAccount ) {
			nc = (NormalAccount)obj;
		
			//&& nc.getName().equals( super.getName() )
			if( nc.getAccountNumber().equals( super.getAccountNumber() )
					 ) {
				
				System.out.println("노말 : 1111");				
				check = true;
			
			}else {
				System.out.println("노말 : 2222");				
				check = false;
			}
			
			
		}else if( obj instanceof HighCreditAccount ) {
			hc = (HighCreditAccount)obj;
			
			
			//&& nc.getName().equals( super.getName() )
			if( hc.getAccountNumber().equals( super.getAccountNumber() )
					 ) {
				
				System.out.println("하이 1111");				
				check = true;
			
			}else {
				System.out.println("하이 2222");				
				check = false;
			}
		} 
		
		return check;	
		
	}
	*/
	
	
	
}
