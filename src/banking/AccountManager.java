package banking;


public class AccountManager {

	private Account[] ac;
	private int num;
	
	
	public AccountManager(){
		ac = new Account[50];
		num = 0;
	}
	
	// 메뉴출력
	public void showMenu() {
		
	}   
	
	// 계좌개설을 위한 함수
	public void makeAccount() {
		System.out.println("***신규계좌계설***");
		
		BankingSystemMain.sc.nextLine();
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");		
		int choice = BankingSystemMain.sc.nextInt();
		
		BankingSystemMain.sc.nextLine();
		System.out.println("계좌번호 입력");
		String accountNumber = BankingSystemMain.sc.nextLine();
		System.out.println("고객이름");
		String name = BankingSystemMain.sc.nextLine();
		System.out.println("잔고");
		int balance = BankingSystemMain.sc.nextInt();		
		System.out.println("이자율");
		int rate = BankingSystemMain.sc.nextInt();
		
		if( choice == 1 ) {
			
			//BankingSystemMain.sc.nextLine();
			
			Account account = new NormalAccount(accountNumber, name, balance, rate );
			ac[num++] = account;
			
			System.out.println( account.getAccountNumber() + " : "
					+ account.getName() +" : "+ account.getBalance() + " : "+((NormalAccount)account).getInterest_rate() );
		
		}else if( choice == 2 ) {
			
			BankingSystemMain.sc.nextLine();
			
			System.out.print("등급");
			String r_grade = BankingSystemMain.sc.nextLine();
			
			Account account = new HighCreditAccount(accountNumber, name, balance, rate, r_grade );
			ac[num++] = account;
			
			System.out.println( account.getAccountNumber() + " : "
					+ account.getName() +" : "+ account.getBalance() + " : "+((HighCreditAccount)account).getInterest_rate() 
					+ " : " + ((HighCreditAccount)account).getGrade());
		
		}
		
		
		
		System.out.println( " 계좌계설이 완료되었습니다. " );		
		
		
	}
	
	 // 입    금
	public void depositMoney() {
		System.out.println("*** 입금하기 ***");		
		
		BankingSystemMain.sc.nextLine();
		
		System.out.println("계좌번호 입력");
		String s_name = BankingSystemMain.sc.nextLine();
		
		System.out.println("입금액을 입력");
		int money = BankingSystemMain.sc.nextInt();
		
		boolean isFind = false;		
		
		
		
		//String searchName = BankingSystemMain.sc.nextLine();
		
		for( int i = 0; i < num; i++ ) {
			
			if( s_name.compareTo( ac[i].getAccountNumber() ) == 0 ) {
				
				if( ((HighCreditAccount)ac[i]).getGrade() != null ) {
					
					/*
					신용계좌 : 잔고 + (잔고 * 기본이자) + (잔고 * 추가이자) + 입금액
					Ex) 5000 + (5000 * 0.02) + (5000 * 0.04) + 2000 = 7,300원
					*/
					
					String check = ((HighCreditAccount)ac[i]).getGrade();
					
					if( check.equals("a") ) {
						System.out.println(check);
						
					}else if( check.equals("b")) {
						System.out.println(check);
						
					}else if( check.equals("c")) {
						System.out.println(check);
						
					}
					//int b_money = ac[i].getBalance();
					
					//double result = b_money + ( b_money * 0.02 ) + ( b_money * )
					//ac[i].setBalance( b_money + money );
					
					
				}else {
					
					//int b_money = ac[i].getBalance();
					//ac[i].setBalance( b_money + money );
				}
				
				isFind = true;
			}
			
		}
		
		if( isFind ) {
			System.out.println("입금성공");
		}else {
			System.out.println("입금할 계좌가 없습니다.");
		}
		
		
	}
	
	// 출    금
	public void withdrawMoney() {
		
		boolean isFind = false;
		
		BankingSystemMain.sc.nextLine();
		
		System.out.println("*** 출금하기 ***");
		
		System.out.println("계좌번호 입력");
		String acc_number = BankingSystemMain.sc.nextLine();
		
		System.out.println("출금할 금액");
		int money = BankingSystemMain.sc.nextInt();
		
		
		for( int i = 0; i < num; i++ ) {
			
			if( acc_number.compareTo( ac[i].getAccountNumber() ) == 0 ) {
				int b_money = ac[i].getBalance();
				ac[i].setBalance( b_money - money );
				isFind = true;
			}
		}
		
		if( isFind ) {
			System.out.println("출금이 완료되었습니다.");
		}else {
			System.out.println("계좌번호가 다릅니다.");
		}
		
		
	}
	
	// 전체계좌정보출력	
	public void showAccInfo() {
		//System.out.println("***계좌정보출력***");
		
		for( int i = 0; i < num; i++ ) {
			ac[i].showAllData();
		}
		
	}  

}
