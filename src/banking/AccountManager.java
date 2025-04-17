package banking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class AccountManager {
	
	public HashSet<Account> set = null;
	public static boolean check = false;
	//public static int count;
		
	public AccountManager(){
		
		set = new HashSet<Account>();
		
		ObjectInputStream in = null;
		
		try {
				in = new ObjectInputStream(
					new FileInputStream("src/banking/AccountInfo.obj")	
				);
			
		}catch( FileNotFoundException e ) {
			System.out.println("파일없음");
		
		}catch( IOException e ) {
			System.out.println("파일이 존재하지 않음");
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
		System.out.println("3.특판계좌");
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
		
		if( choice == 1 ) {						
						
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
		
		}else if( choice == 3 ) {
			//int count = 0;
			
			System.out.println("특판");
			account = new SpecialAccount(accountNumber, name, balance, rate, 0 );
			//System.out.println("111111111111111");
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
				
				//System.out.println("3333");				
				if( str.equalsIgnoreCase("y") ){	
					
					//System.out.println("444");
					System.out.println("덥어쓴다.");
					//set.remove(ac);
					
					System.out.println(" 저장여부 : " + set.add(account));
					
					//set.add(account);
					set.remove(account);
					
					set.add(account);
					
					break;
					
				}else {
					System.out.println("입력중지 됩니다. 다시 계좌 개설을 해주세요");
					
				}				
			}			
		}
		
		if( !isDup ) {
			set.add(account);
		}
			
	}
	
	 // 입    금
	public void depositMoney() {
		System.out.println("*** 입금하기 ***");		
		
		boolean isFind = false;
		
		BankingSystemMain.sc.nextLine();
		
		System.out.println("계좌번호 입력");
		String accountNumber = BankingSystemMain.sc.nextLine();
		
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
	        	//ac.getAccountNumber().equals(accountNumber)
	        	
	        	if (ac.getAccountNumber().equals(accountNumber)) {
	        		
	        		System.out.println("계좌번호가 같은 것 들어온다.");
	        		
	        		if (ac instanceof SpecialAccount ) {
	        			
	        			System.out.println("스페셜 들어온다.");        			
		        		
		        		System.out.println("특판계좌 입금");
		        		SpecialAccount sp = (SpecialAccount)ac;
		        		
		        		sp.setCount( sp.getCount() + 1  );
		        		
		        		int b_money = sp.getBalance();
		        		
		        		if( sp.getCount() % 2 == 0 ) {
		        			System.out.println("특판 500원 보너스 지급");
		        			//잔고 + (잔고 * 기본이자) + 입금액 + 500원 
		        			int specialMoney = (int)(b_money + ( b_money % Account.NORMAL ) + money) + 500;
		        			
		        			sp.setBalance( specialMoney );
		        			break;
		        			
		        		}else {
		        			//잔고 + (잔고 * 기본이자) + 입금액
		        			int specialMoney = (int)(b_money + ( b_money % Account.NORMAL ) + money);
		        			
		        			sp.setBalance(specialMoney);
		        			break;
		        		}        		
	        			
	        		
	        		} else if( ac instanceof NormalAccount  ) {
		        		System.out.println("NormalAccount 입금");
		        		NormalAccount nc = (NormalAccount)ac;
		        		
		        		int b_money = nc.getBalance();										
						int nomal_money = (int)( b_money + ( b_money * Account.NORMAL ) + money );					
						nc.setBalance( nomal_money );
						break;
		        	//&& ac.getAccountNumber().equals(accountNumber)
		        	}else if ( ac instanceof HighCreditAccount ) {
		        		System.out.println("HighCreditAccount 입금");
		        		String check = ((HighCreditAccount)ac).getGrade();					
		        		HighCreditAccount hc = (HighCreditAccount)ac;
		        		
						if( check.equalsIgnoreCase("a") ) {
							System.out.println(check + "1");						
							
							int b_money = hc.getBalance();										
							int high_money = (int)( b_money + ( b_money * Account.NORMAL ) + ( b_money * Account.A ) + money );					
							hc.setBalance( high_money );
							break;
							
						}else if( check.equalsIgnoreCase("b") ) {
							System.out.println(check + "2");
							
							int b_money = hc.getBalance();										
							int high_money = (int)( b_money + ( b_money * Account.NORMAL ) + ( b_money * Account.B ) + money );					
							hc.setBalance( high_money );
							break;
							
							
						}else if( check.equalsIgnoreCase("c") ) {
							System.out.println(check + "3");
							
							int b_money = hc.getBalance();										
							int high_money = (int)( b_money + ( b_money * Account.NORMAL ) + ( b_money * Account.C ) + money );					
							hc.setBalance( high_money );
							break;
							
						}	        		
		        		
		        	}
		        }
	        }
		 }else {			 
		    System.out.println("500원 단위로만 입금할 수 있습니다.");
		    
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
						
						//System.out.println("1111");
						
						if ( money % 1000 == 0 ) {
							
							//System.out.println("2222");
							
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
		
	}
	
	// 전체계좌정보출력	
	public void showAccInfo() {
		//System.out.println("***계좌정보출력***");
				
		Iterator<Account> it = set.iterator();
		
		while( it.hasNext() ) {
			Account ac = it.next();
			
			if( ac instanceof SpecialAccount) {
				SpecialAccount sp = (SpecialAccount)ac;
				sp.showAllData();
				
			}else if( ac instanceof NormalAccount ) {
				NormalAccount nc = (NormalAccount)ac;
				nc.showAllData();
				
			}else if( ac instanceof HighCreditAccount ) {
				HighCreditAccount hc = (HighCreditAccount)ac;
				hc.showAllData();
			}
			
		}	
		
	}
	
	// 고객정보 저장
	public void objectSave() {
		
		try {
			
			
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/banking/AccountInfo.obj")
			);
						
			out.writeObject(set);			
			
			out.close();											
			
			
		}/*catch( ClassNotFoundException e ) {
			System.out.println("[예외]클래스없음");
		
		}*/catch( FileNotFoundException e ) {
			System.out.println("[예외]파일없음");
		
		}catch( IOException e ) {
			System.out.println("[Exception]뭔가없음");
		}		
	}
	
	// 고객정보 불러오기
	public void objectLoad() {
		try {
		 
		ObjectInputStream in = new ObjectInputStream(
			new FileInputStream("src/banking/AccountInfo.obj")	
		); 
		
		//System.out.println( "인의 값은 : " + in );
					
		set = (HashSet)in.readObject();			
		//System.out.println( " 사이즈 : "+set.size() );		
		
		in.close();
				
		}catch( ClassNotFoundException e ) {
			System.out.println("클래스없음");
		
		}catch( FileNotFoundException e ) {
			System.out.println("파일없음");
		
		}catch( IOException e ) {
			System.out.println("뭔가없음");
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
	
	// txt 파일 자동저장 처리 
	public void autoSave() {
		
		BankingSystemMain.sc.nextLine();
		
		System.out.println("1번 자동저장 2번 자동저장끄기");
		String str = BankingSystemMain.sc.nextLine();
		
		
		if( str.equals("1") ) {
			
			if(check) {
				
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
	
	// txt 파일형태로 자료 저장
	public void autoSaveFile() {
		
		try {
				
			//Writer out = new FileWriter("src/banking/AutoSaveAccount.txt");			
			
			PrintWriter out = new PrintWriter(
					new FileWriter("src/banking/AutoSaveAccount.txt")	
			);		
									
			if( set.size() == 0) {
				System.out.println("저장할 정보가 없습니다.");
			
			}else {
				
				Iterator<Account> it = set.iterator();
				
				while( it.hasNext() ) {
					
					Account ac = it.next();
					
					if( ac instanceof SpecialAccount ) {
						SpecialAccount sp = (SpecialAccount)ac;
						
						out.print( sp.getAccountNumber() + " " );
						out.print( sp.getName() + " " );
						out.print( sp.getBalance() + " " );
						out.print( sp.getInterest_rate() + " " );
						out.print( sp.getCount() + " " );
						out.println();
						
					}else if( ac instanceof NormalAccount ) {
						NormalAccount nc = (NormalAccount)ac;
						
						out.print( nc.getAccountNumber() + " " );
						out.print( nc.getName() + " " );
						out.print( nc.getBalance() + " " );
						out.print( String.valueOf( nc.getInterest_rate() ) + " ");
						out.println();
						
						
					}else if( ac instanceof HighCreditAccount) {
						HighCreditAccount hc = (HighCreditAccount)ac;
						
						out.print( hc.getAccountNumber() + " " );
						out.print( hc.getName() + " " );
						out.print( hc.getBalance() + " " );
						out.print( String.valueOf( hc.getInterest_rate() ) + " ");
						out.print( hc.getGrade() + " " );
						out.println();
					}					
					
				}
				
				out.close();
				System.out.println("AutoSaveAccount.txt가 생성되었습니다.");
				
				
			}
			
		}catch( IOException e) {
			System.out.println("문자스트림 작업중 오류발생");
			e.printStackTrace();
		}		
		
	}
	
}
