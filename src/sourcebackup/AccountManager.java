package sourcebackup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class AccountManager {

	//private Account[] ac;
	
	HashSet<Account> set = null;

	static boolean check = false;
	//private int num;
	
	
	public AccountManager(){
		//ac = new Account[50];
		//num = 0;
		set = new HashSet<Account>();
		
		ObjectInputStream in = null;
		try {
				in = new ObjectInputStream(
				new FileInputStream("src/banking/AccountInfo.obj")	
			);
			
		}catch( FileNotFoundException e ) {
			System.out.println("[예외]파일없음");
		
		}catch( IOException e ) {
			System.out.println("[Exception]뭔가없음");
		}
		
		if( in != null ) {
			objectLoad();
		}else {
			System.out.println("로드될 자료가 없습니다.");
		}
		
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
		
		Account account = null;
		//Account account2 = null;
		
		if( choice == 1 ) {
						
			//BankingSystemMain.sc.nextLine();			
			account = new NormalAccount(accountNumber, name, balance, rate );			
						
			System.out.println( account.getAccountNumber() + " : "
					+ account.getName() +" : "+ account.getBalance() + " : "+((NormalAccount)account).getInterest_rate() );
		
		}else if( choice == 2 ) {
			
			BankingSystemMain.sc.nextLine();
			
			System.out.print("등급");
			String r_grade = BankingSystemMain.sc.nextLine();
			
			account = new HighCreditAccount(accountNumber, name, balance, rate, r_grade );
									
			System.out.println( account.getAccountNumber() + " : "
					+ account.getName() +" : "+ account.getBalance() + " : "+((HighCreditAccount)account).getInterest_rate() 
					+ " : " + ((HighCreditAccount)account).getGrade());
		
		}
		
		
		boolean isDup = false;
		Iterator<Account> it = set.iterator();
		
		while( it.hasNext() ) {
			
			Account ac = (Account)it.next();
			
			if( ac.getAccountNumber().equals(accountNumber) ) {
				System.out.println("중복됨");
				isDup = true;
				
				BankingSystemMain.sc.nextLine();
				
				System.out.println("덥어쓸까요 y or n");				
				//BankingSystemMain.sc.nextLine();
				String str = BankingSystemMain.sc.nextLine();				
				
				System.out.println("3333");				
				if( str.equalsIgnoreCase("y") ){	
					
					System.out.println("444");
					System.out.println("덥어쓴다.");
					set.remove(ac);
					set.add(account);
					break;
					
				}else {
					System.out.println("입력중지 됩니다. 다시 계좌 개설을 해주세요");
					
				}
				
//				if( str.equals("y") ) {
//					
//					System.out.println("덥어쓴다.");
//					set.remove(ac);
//					set.add(account);
//					break;
//					
//				}else if( str.equals("n") ) {
//					System.out.println("입력중지 됩니다. 다시 계좌 개설을 해주세요");
//				}
				
				//break;
			}			
		}
		
		if( !isDup ) {
			set.add(account);
		}
		
		/*
		
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
				
				String str2 = ac.getAccountNumber();
				
				//&& ac.getAccountNumber().equals(accountNumber)
				if( str2.equals(accountNumber) ) {					
				
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
		
		*/		
	
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
	
	public void objectSave() {
		
		try {
			
			//System.out.println("111");
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/banking/AccountInfo.obj")
			);
			
			//System.out.println("22222");
			
			/*
			Iterator<Account> it = set.iterator();
			int count = 0;
			
			while( it.hasNext() ) {
				Account ac = (Account)it.next();
				
				out.writeObject(ac);
				count++;
			}
			*/
			out.writeObject(set);
			//System.out.println("3333");
			
			//System.out.println(" 숫자는 : " + count + " 입니다.");
			
			out.close();
			
			
			
			/*
			 인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고
			 readObject 를 통해 복원한다. 
			 */
			/*
			ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("src/ex20io/circle.obj")	
			); 
			*/
			/*
			 저장시 Object 기반으로 저장되므로 복원시에는 원래의
			 자료형으로 다운캐스팅 (강제형변환) 해야한다.
			 */
//			Circle c1 = (Circle)in.readObject();
//			Circle c2 = (Circle)in.readObject();
//			String message = (String)in.readObject();
			//in.close();
			
			/*
			 개발자가 직접 정의한 클래스는 멤버메서드를 통해 정보를 
			 출력할 수 있다.			  
			 */
			//c1.showCircleInfo();
			//c2.showCircleInfo();
			/*
			 기본클래스는 이미 toString이 오버라이딩 되어 있으므로
			 즉시 출력할 수 있다. 
			 */
			//System.out.println("String 오브젝트 : " + message );
			
		}/*catch( ClassNotFoundException e ) {
			System.out.println("[예외]클래스없음");
		
		}*/catch( FileNotFoundException e ) {
			System.out.println("[예외]파일없음");
		
		}catch( IOException e ) {
			System.out.println("[Exception]뭔가없음");
		}		
	}

	public void objectLoad() {
		try {
		 
		ObjectInputStream in = new ObjectInputStream(
			new FileInputStream("src/banking/AccountInfo.obj")	
		); 
		
		System.out.println( "인의 값은 : " + in );
		
		/*
		Account a = (Account)in.readObject();
		
		System.out.println( a.getAccountNumber() );
		*/
		
		
		//in.readObject();
		//Object obj = in.readObject();
		
		//ArrayList<Account> list = (ArrayList<Account>)in.readObject();		
		//System.out.println("어레이리스트 : " + list.size() );
		//HashSet<Account> set
			
		set = (HashSet)in.readObject();			
		System.out.println( " 사이즈 : "+set.size() );
		
		/*
		 저장시 Object 기반으로 저장되므로 복원시에는 원래의
		 자료형으로 다운캐스팅 (강제형변환) 해야한다.
		 */
		
//		Circle c1 = (Circle)in.readObject();
//		Circle c2 = (Circle)in.readObject();
//		String message = (String)in.readObject();
		in.close();
		
		/*
		 개발자가 직접 정의한 클래스는 멤버메서드를 통해 정보를 
		 출력할 수 있다.			  
		 */
		//c1.showCircleInfo();
		//c2.showCircleInfo();
		/*
		 기본클래스는 이미 toString이 오버라이딩 되어 있으므로
		 즉시 출력할 수 있다. 
		 */
		//System.out.println("String 오브젝트 : " + message );
		
		}catch( ClassNotFoundException e ) {
			System.out.println("[예외]클래스없음");
		
		}catch( FileNotFoundException e ) {
			System.out.println("[예외]파일없음");
		
		}catch( IOException e ) {
			System.out.println("[Exception]뭔가없음");
		}
		
	}
	
	//계좌 삭제
	public void removeAcount() {
		
		BankingSystemMain.sc.nextLine();
		
		if( set.size() == 0 ) {
			System.out.println("삭제할 계좌번호가 없습니다.");
		}else {
		
			System.out.println("삭제할 계좌번호를 입력해주세요");
					
			String accountNumber = BankingSystemMain.sc.nextLine();
			
			Iterator it = set.iterator();
			
			while( it.hasNext() ) {
				
				Account ac = (Account)it.next();
				
				if( ac.getAccountNumber().equals( accountNumber ) ) {
					set.remove(ac);
					System.out.println("삭제되었습니다.");
					break;
				}
				
			}
			
		}		
		
	}
	
	public void autoSave() {
		
		BankingSystemMain.sc.nextLine();
		
		System.out.println("1번 자동저장 2번 자동저장끄기");
		String str = BankingSystemMain.sc.nextLine();
		
		
		if( str.equals("1") ) {
			
			if(check) {
				
				//BankingSystemMain.acManager.isAlive();
				isAlive();
			}else {
				
				check = true;
				
			}			
			
		}else if( str.equals("2") ){
			check = false;
		}
		
		if( check ) {
			AutoSaver as = new AutoSaver();
			as.start();
		}
		
		
	}

	public void isAlive() {
		//BankingSystemMain.sc.nextLine();
		
		System.out.println("이미 자동저장 실행중 입니다.");
	}
}
