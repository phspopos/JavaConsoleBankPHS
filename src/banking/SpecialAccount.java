package banking;

public class SpecialAccount extends NormalAccount {

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
	
	

}
