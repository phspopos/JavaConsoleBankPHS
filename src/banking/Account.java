package banking;

import java.io.Serializable;
import java.util.Objects;

public abstract class Account implements ICustomDefine, Serializable {
		
	private String accountNumber;
	private String name;
	private int balance;
	
	public Account() {}
	public Account(String accountNumber, String name, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public void showAllData() {
		System.out.println("===전체계좌정보출력===");	  
		System.out.print("계좌번호 : " + getAccountNumber());
		System.out.print(", 고객이름 : " + getName());
		System.out.print(", 잔고 : " + getBalance());		
	}
	

	@Override
	public boolean equals( Object obj ) {
		
		System.out.println(" equals() 호출됨");
		
		boolean check = false;
		NormalAccount nc = null;
		HighCreditAccount hc = null;
		SpecialAccount sp = null;		
		
		if( obj instanceof SpecialAccount ) {
			sp = (SpecialAccount)obj;			
			
			//&& nc.getName().equals( super.getName() ) this.accountNumber
			if( sp.getAccountNumber().equals( this.accountNumber )
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
			if( nc.getAccountNumber().equals( this.accountNumber )
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
			if( hc.getAccountNumber().equals( this.accountNumber )
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
	
	@Override
	public int hashCode() {
		
		int returnCode2 = Objects.hash( this.accountNumber , this.name );
		System.out.println("returnCode2 = " + returnCode2);
		
		return returnCode2;
	}
	
	
	
	
	
}
