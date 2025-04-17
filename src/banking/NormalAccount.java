package banking;

import java.io.Serializable;
import java.util.Objects;

//import common.Teacher;

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
	
	/*
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
	*/
	
	
	/*
	@Override
	public int hashCode() {

		int returnCode2 = Objects.hash(super.getAccountNumber() , this.interest_rate );
		System.out.println("노말1 returnCode2 = " + returnCode2);
		
		return returnCode2;
	}
	*/
	
	/*
	@Override
	public boolean equals( Object obj ) {
		
		System.out.println(" NormalAccount equals() 호출됨");
		
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
