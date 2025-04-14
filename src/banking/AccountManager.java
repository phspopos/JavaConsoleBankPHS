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
		double rate = BankingSystemMain.sc.nextInt();
		
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
		
		boolean isFind = false;
		
		BankingSystemMain.sc.nextLine();
		
		System.out.println("계좌번호 입력");
		String s_name = BankingSystemMain.sc.nextLine();
		
		System.out.println("입금액을 입력");
		
		//int money = BankingSystemMain.sc.nextInt();
		int money = AccountErrorException.errorCheckMoney();
		
		if( money < 0 ) {
			System.out.println("음수 입니다. 다시 입력해 주세요");
			money = 0;			
			money = AccountErrorException.errorCheckMoney();
		}
		
		 if ( money % 500 == 0 ) {
	        System.out.println("입금이 처리됨");
	        
	      //String searchName = BankingSystemMain.sc.nextLine();
			
			for( int i = 0; i < num; i++ ) {
				
				if( s_name.compareTo( ac[i].getAccountNumber() ) == 0 ) {
					
					//String value ="";
					//value = ((HighCreditAccount)ac[i]).getGrade(); 
						
					
					
					if( ac[i] instanceof HighCreditAccount ) {
										
						/*
						A,B,C 등급별로 각각 기본이율에 7%, 4%, 2%의 이율을 추가로 제공한다.
	 
						이자계산에 대해서는 다음의 규칙을 적용한다.
						이자계산은 입금시에만 잔고를 대상으로 계산한다. 출금할때는 이자계산을 하지 않는다.
						이자계산방식 : 잔고:5000원, 기본이자:2%, 신용등급이자:4%, 입금액:2000원이라 가정하면….
						일반계좌 : 잔고 + (잔고 * 기본이자) + 입금액 
						Ex) 5000 + (5000 * 0.02) + 2000 = 7,100원
						신용계좌 : 잔고 + (잔고 * 기본이자) + (잔고 * 추가이자) + 입금액
						Ex) 5000 + (5000 * 0.02) + (5000 * 0.04) + 2000 = 7,300원
						
						*/
						
						String check = ((HighCreditAccount)ac[i]).getGrade();
						
						if( check.equals("a") ) {
							System.out.println(check + "1");						
							
							int b_money = ac[i].getBalance();										
							int high_money = (int)( b_money + ( b_money * 0.02 ) + ( b_money * 0.07 ) + money );					
							ac[i].setBalance( high_money );
							
						}else if( check.equals("b") ) {
							System.out.println(check + "2");
							
							int b_money = ac[i].getBalance();										
							int high_money = (int)( b_money + ( b_money * 0.02 ) + ( b_money * 0.04 ) + money );					
							ac[i].setBalance( high_money );
							
							
						}else if( check.equals("c") ) {
							System.out.println(check + "3");
							
							int b_money = ac[i].getBalance();										
							int high_money = (int)( b_money + ( b_money * 0.02 ) + ( b_money * 0.02 ) + money );					
							ac[i].setBalance( high_money );
							
						}
						
					}else {				
						
						int b_money = ac[i].getBalance();										
						int nomal_money = (int)( b_money + ( b_money * 0.02 ) + money );					
						ac[i].setBalance( nomal_money );
						
					}
					
					isFind = true;
				}
				
			}
	        
	    } else {
	        System.out.println("500원 단위로만 입금할 수 있습니다.");
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
		//int money = BankingSystemMain.sc.nextInt();
		
		int money = AccountErrorException.errorCheckMoney();
		
		if( money < 0 ) {
			System.out.println("음수는 출금할수 없습니다. 다시 입력해 주세요");
			money = 0;
			money = AccountErrorException.errorCheckMoney();
			
		}
		
		
		for( int i = 0; i < num; i++ ) {
			
			if( acc_number.compareTo( ac[i].getAccountNumber() ) == 0 ) {								
				
				int b_money = ac[i].getBalance();
				
				if( b_money >= money ) {
					
					if ( money % 1000 == 0 ) {
						
						ac[i].setBalance( b_money - money );
						isFind = true;
						
					}else {
						System.out.println("출금은 1000원 단위로만 출금이 가능하다. Ex)2000원 출금가능"
								+"1100원을 출금불가");
					}
					
					
				}else {
					//System.out.println("입금된 금액보다 큼니다. 다시 이용해 주시기 바랍니다.");
					System.out.println("잔고가 부족합니다. 금액전체를 출금할까요? y or n ");
					
					BankingSystemMain.sc.nextLine();
					
					String str = (BankingSystemMain.sc.nextLine());					
					
					System.out.println( str + " 입니다.");
					
					if( str.equals("y") ) {
						
						System.out.println("1111");
						
						if ( money % 1000 == 0 ) {
							
							System.out.println("2222");
							
							ac[i].setBalance( ac[i].getBalance()- ac[i].getBalance() );
							
						}else {
							System.out.println("출금은 1000원 단위로만 출금이 가능하다. Ex)2000원 출금가능, "
									+ "1100원을 출금불가" );
						}
						
					}else {
						System.out.println("출금을 중지 합니다.");
					}
					
					
				}							
				
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
