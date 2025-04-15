package banking;

import java.util.HashSet;
import java.util.Iterator;

public class AccountManager {

	//private Account[] ac;
	
	HashSet<Account> set = null;
	
	//private int num;
	
	
	public AccountManager(){
		//ac = new Account[50];
		//num = 0;
		set = new HashSet<Account>();
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
		
		Account account1 = null;
		Account account2 = null;
		
		if( choice == 1 ) {
						
			//BankingSystemMain.sc.nextLine();			
			account1 = new NormalAccount(accountNumber, name, balance, rate );			
						
			System.out.println( account1.getAccountNumber() + " : "
					+ account1.getName() +" : "+ account1.getBalance() + " : "+((NormalAccount)account1).getInterest_rate() );
		
		}else if( choice == 2 ) {
			
			BankingSystemMain.sc.nextLine();
			
			System.out.print("등급");
			String r_grade = BankingSystemMain.sc.nextLine();
			
			account2 = new HighCreditAccount(accountNumber, name, balance, rate, r_grade );
									
			System.out.println( account2.getAccountNumber() + " : "
					+ account2.getName() +" : "+ account2.getBalance() + " : "+((HighCreditAccount)account2).getInterest_rate() 
					+ " : " + ((HighCreditAccount)account2).getGrade());
		
		}
		
		
		Iterator<Account> it = set.iterator();
		
		while( it.hasNext() ) {
			
			Account ac = (Account)it.next();		  
					
			System.out.println("1111");
						
			if( choice == 1 ) {
				System.out.println("111**");
				//&& ac.getAccountNumber().equals(accountNumber)
				if( ac.getAccountNumber().equals(accountNumber) ) {
					
					if( ac.equals(account1) ) {					
						System.out.println("2222");
						System.out.println("덥어쓸까요 y or n");
						BankingSystemMain.sc.nextLine();
						String str = BankingSystemMain.sc.nextLine();
						
						System.out.println("3333");
						if( str.equalsIgnoreCase("y") ) {
							System.out.println("덥어쓴다.");
							set.remove(ac);
							set.add(account1);						
						}else if( str.equalsIgnoreCase("n") ) {
							System.out.println("입력중지 됩니다. 다시 계좌 개설을 해주세요");
						}
						
					} 
				}else {
					set.add( account1 );
				}
				
				
			}else if( choice == 2 ) {
				
				System.out.println("222***");
				
				//&& ac.getAccountNumber().equals(accountNumber)
				if( ac.getAccountNumber().equals(accountNumber) ) {					
				
					if( ac.equals(account2) ) {					
						System.out.println("4444");
						System.out.println("***덥어쓸까요 y or n");
						//BankingSystemMain.sc.nextLine();
						String str = BankingSystemMain.sc.nextLine();
						
						System.out.println("5555");
						if( str.equalsIgnoreCase("y") ) {
							System.out.println("***덥어쓴다.");
							set.remove(ac);
							set.add(account2);						
						}else if( str.equalsIgnoreCase("n") ) {
							System.out.println("입력중지 됩니다. 다시 계좌 개설을 해주세요");
						}
						
					} 			
				}else {
					set.add( account2 );
				}	
			}
			
		}
		
		if( choice ==  1  && set.size() == 0 ) {
			set.add(account1);
			
		}else if( choice == 2 && set.size() == 0 ){
			set.add(account2);
			
		}
		
				
	
		/*
		
		while( it.hasNext() ) {
			
			Account ac = it.next();
			
			System.out.println("1111");
			
			if( ac instanceof NormalAccount) {
				
				if( ac.equals(account1) ) {					
					System.out.println("2222");
					System.out.println("덥어쓸까요 y or n");
					BankingSystemMain.sc.nextLine();
					String str = BankingSystemMain.sc.nextLine();
					
					System.out.println("3333");
					if( str.equalsIgnoreCase("y") ) {
						System.out.println("덥어쓴다.");
						set.remove(ac);
						set.add(account1);						
					}else if( str.equalsIgnoreCase("n") ) {
						System.out.println("입력중지 됩니다. 다시 계좌 개설을 해주세요");
					}
					
				} else {
					set.add( account1 );
				}
			
			
			}else if( ac instanceof HighCreditAccount ) {
				
				//sIterator<Account> it2 = set.iterator();
				
				while( it.hasNext() ) {
					Account ac2 = it.next();
					
					System.out.println("4444");
					
					if( ac2.equals(account2) ) {					
						System.out.println("5555");
						System.out.println("덥어쓸까요 y or n");
						BankingSystemMain.sc.nextLine();
						String str = BankingSystemMain.sc.nextLine();
						
						System.out.println("6666");
						if( str.equalsIgnoreCase("y") ) {
							System.out.println("덥어쓴다.");
							set.remove(ac);
							set.add(account2);						
						}else if( str.equalsIgnoreCase("n") ) {
							System.out.println("입력중지 됩니다. 다시 계좌 개설을 해주세요");
						}
						
					} else {
						set.add( account2 );
					}
				}
			}
			
			
		}
		*/
		
		/*if( set.size() == 0) {
			set.add( account2 );
		}*/
		
		//System.out.println( " 계좌계설이 완료되었습니다. " );		
		
		
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
			
	        Iterator<Account> it = set.iterator();
	        
	        while( it.hasNext() ) {
	        	
	        	Account ac= it.next();
	        	
	        	if( ac instanceof NormalAccount ) {
	        		
	        		NormalAccount nc = (NormalAccount)ac;
	        		
	        		int b_money = nc.getBalance();										
					int nomal_money = (int)( b_money + ( b_money * Account.NORMAL ) + money );					
					nc.setBalance( nomal_money );
	        	
	        	}else if (ac instanceof HighCreditAccount ) {
	        		
	        		String check = ((HighCreditAccount)ac).getGrade();					
	        		HighCreditAccount hc = (HighCreditAccount)ac;
	        		
					if( check.equalsIgnoreCase("a") ) {
						System.out.println(check + "1");						
						
						int b_money = hc.getBalance();										
						int high_money = (int)( b_money + ( b_money * Account.NORMAL ) + ( b_money * Account.A ) + money );					
						hc.setBalance( high_money );
						
					}else if( check.equalsIgnoreCase("b") ) {
						System.out.println(check + "2");
						
						int b_money = hc.getBalance();										
						int high_money = (int)( b_money + ( b_money * Account.NORMAL ) + ( b_money * Account.B ) + money );					
						hc.setBalance( high_money );
						
						
					}else if( check.equalsIgnoreCase("c") ) {
						System.out.println(check + "3");
						
						int b_money = hc.getBalance();										
						int high_money = (int)( b_money + ( b_money * Account.NORMAL ) + ( b_money * Account.C ) + money );					
						hc.setBalance( high_money );
						
					}	        		
	        		
	        	}	        	
	        	
	        }
		 }else {			 
		    System.out.println("500원 단위로만 입금할 수 있습니다.");
		    
		 }
		 
//		if( isFind ) {
//			System.out.println("입금성공");
//		}else {
//			System.out.println("입금할 계좌가 없습니다.");
//		}
		
		
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
		
		Iterator<Account> it = set.iterator();
		
		while( it.hasNext() ) {
			
			Account ac = it.next();
			
			int b_money = ac.getBalance();
			
			if( ac.getAccountNumber().equals( acc_number ) ) {
			
				if( b_money >= money ) {
					
					if ( money % 1000 == 0 ) {
						
						ac.setBalance( b_money - money );
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
							
							ac.setBalance( ac.getBalance()- ac.getBalance() );
							
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
		
////		for( int i = 0; i < num; i++ ) {
////			
////			if( acc_number.compareTo( ac[i].getAccountNumber() ) == 0 ) {								
////				
////				int b_money = ac[i].getBalance();
////				
////				if( b_money >= money ) {
////					
////					if ( money % 1000 == 0 ) {
////						
////						ac[i].setBalance( b_money - money );
////						isFind = true;
////						
////					}else {
////						System.out.println("출금은 1000원 단위로만 출금이 가능하다. Ex)2000원 출금가능"
////								+"1100원을 출금불가");
////					}
////					
////					
////				}else {
////					//System.out.println("입금된 금액보다 큼니다. 다시 이용해 주시기 바랍니다.");
////					System.out.println("잔고가 부족합니다. 금액전체를 출금할까요? y or n ");
////					
////					BankingSystemMain.sc.nextLine();
////					
////					String str = (BankingSystemMain.sc.nextLine());					
////					
////					System.out.println( str + " 입니다.");
////					
////					if( str.equals("y") ) {
////						
////						System.out.println("1111");
////						
////						if ( money % 1000 == 0 ) {
////							
////							System.out.println("2222");
////							
////							ac[i].setBalance( ac[i].getBalance()- ac[i].getBalance() );
////							
////						}else {
////							System.out.println("출금은 1000원 단위로만 출금이 가능하다. Ex)2000원 출금가능, "
////									+ "1100원을 출금불가" );
////						}
////						
////					}else {
////						System.out.println("출금을 중지 합니다.");
////					}
//					
//					
//				}							
//				
//			}
//		}
		
//		if( isFind ) {
//			System.out.println("출금이 완료되었습니다.");
//		}else {
//			System.out.println("계좌번호가 다릅니다.");
//		}
		
		
	}
	
	// 전체계좌정보출력	
	public void showAccInfo() {
		//System.out.println("***계좌정보출력***");
		
		/*
		for( int i = 0; i < num; i++ ) {
			ac[i].showAllData();
		}*/
		Iterator<Account> it = set.iterator();
		
		while( it.hasNext() ) {
			Account ac = it.next();
			
			if( ac instanceof NormalAccount ) {
				NormalAccount nc = (NormalAccount)ac;
				nc.showAllData();
				
			}else if( ac instanceof HighCreditAccount ) {
				HighCreditAccount hc = (HighCreditAccount)ac;
				hc.showAllData();
			}
			
		}	
		
	}  

}
