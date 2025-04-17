package banking;

import java.io.Serializable;
import java.util.Objects;

public class SpecialAccount extends NormalAccount implements Serializable {

	private int count;
	
	public SpecialAccount(String accountNumber, String name, int balance, double interest_rate, int count ) {
		super(accountNumber, name, balance, interest_rate);
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public void showAllData() {
		//System.out.println("아들");
		super.showAllData();
		System.out.print( "방문숫자 : "+ count +"\n" );
		
		
	}
	
	/*
	@Override
	public int hashCode() {		
		int returnCode2 = Objects.hash(super.getAccountNumber() , this.count );
		System.out.println("스페셜3 returnCode2 = " + returnCode2);
		
		return returnCode2;
	}*/
	
	/*
	@Override
	public boolean equals( Object obj ) {
		
		System.out.println(" SpecialAccount equals() 호출됨");
		
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
