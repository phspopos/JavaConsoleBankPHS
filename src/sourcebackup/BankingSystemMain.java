package sourcebackup;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {

	public static Scanner sc = new Scanner(System.in);
	public static AccountManager acManager = new AccountManager();
	
	public static void menu() {
		System.out.println("---Menu---");
		System.out.println("1. 계좌계설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 프로그램 종료");
		
	}
	
	/*
	 / 메뉴출력
	void makeAccount();    // 계좌개설을 위한 함수
	void depositMoney();    // 입    금
	void withdrawMoney(); // 출    금
	void showAccInfo();  // 3전체계좌정보출력

	 */
	public static void menuChoice() {		

		
		int choice = 0;
		
		while( true ) {
			
			menu();
		
			choice = AccountErrorException.errorCheck();
			//choice = sc.nextInt();
			
			if( choice == Account.MAKE ) {
				System.err.println( choice+"선택");
				acManager.makeAccount();
				
			}else if( choice == Account.DEPOSIT ) {
				System.err.println( choice+"선택");
				acManager.depositMoney();
				
			}else if( choice == Account.WITHDRAW ) {
				System.err.println( choice+"선택");
				acManager.withdrawMoney();
							
			}else if( choice == Account.INQUIRE ) {
				System.err.println( choice+"선택");
				acManager.showAccInfo();
				
			}else if( choice == Account.EXIT ) {
				System.err.println( choice+"선택");
				System.out.println("프로그램을 종료 합니다.");
				System.exit(0);
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		/*
		double num = 2.00001;
		double test = Math.floor(num);
		//int test = (int)num;
		System.out.println( " test : " + test );
		
		System.out.println("되나");
		String str = (BankingSystemMain.sc.nextLine());
		
		if( str.equals("y") ) {
			System.out.println("1111");
		} else {
			System.out.println("2222");
		}
		*/
		
		menuChoice();
		
		
	}
	
}
