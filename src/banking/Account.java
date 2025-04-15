package banking;

import java.io.Serializable;

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
	
}
