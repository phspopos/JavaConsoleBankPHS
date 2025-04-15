package sourcebackup;

import java.util.InputMismatchException;

public class AccountErrorException extends Exception {
	
		
	public static int errorCheck() {
		
		//Scanner sc = new Scanner(System.in);		
		int choice = 0;
		
		try {
			
			choice = BankingSystemMain.sc.nextInt();
			
			if( choice > 7 || choice == 0   ) {					
				System.out.println(" 1~7까지만 입력하세요 다시 입력하세요");
				BankingSystemMain.sc.nextLine();
				Thread.sleep(1000);				
				
			}
			
		}catch( NumberFormatException e2) {
			System.out.println("숫자만 쓰세요");			
			e2.printStackTrace();
		
		}catch( NullPointerException e3 ) {
			System.out.println("값이 없습니다. 다시 입력해 주세요");
			e3.printStackTrace();
		
		}catch( InputMismatchException e) {
			BankingSystemMain.sc.nextLine();
			System.out.println("숫자를 입력해 주세요 잘못 입력되었습니다.");
			e.printStackTrace();
			
		}catch( Exception e4 ) {
			e4.printStackTrace();
			
		}
		
		return choice;
	}
	
	public static int errorCheckMoney() {
		
		//Scanner sc = new Scanner(System.in);		
		int choice = 0;
		
		try {
			
			choice = BankingSystemMain.sc.nextInt();			
			
		}catch( NumberFormatException e2) {
			System.out.println("숫자만 쓰세요");			
			e2.printStackTrace();
		
		}catch( NullPointerException e3 ) {
			System.out.println("값이 없습니다. 다시 입력해 주세요");
			e3.printStackTrace();
		
		}catch( InputMismatchException e) {
			BankingSystemMain.sc.nextLine();
			System.out.println("숫자를 입력해 주세요 잘못 입력되었습니다.");
			e.printStackTrace();
			
		}catch( Exception e4 ) {
			e4.printStackTrace();
			
		}
		
		return choice;
	}
	
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	
}
