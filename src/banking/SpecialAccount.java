package banking;

import java.io.Serializable;

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

}
