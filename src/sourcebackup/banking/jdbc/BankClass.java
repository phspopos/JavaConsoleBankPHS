package sourcebackup.banking.jdbc;

public class BankClass {

	private int idx;
	private String accountNum;
	private String name;
	private int balance;
	private double rate;
	
	public BankClass() {}
	public BankClass(int idx, String accountNum, String name, int balance, double rate) {
		
		this.idx = idx;
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
		this.rate = rate;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
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
	
	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}	
		
}
