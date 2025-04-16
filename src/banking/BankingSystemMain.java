package banking;

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
		System.out.println("5. 계좌정보삭제");
		System.out.println("6. 저장옵션");
		System.out.println("7. 프로그램 종료");
		
	}
		
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
				
			}else if( choice == Account.CLEARNUM ) {
				acManager.removeAcount();
				
			}else if( choice == Account.AUTOSAVE ) {
				acManager.autoSave();			
				
			}else if( choice == Account.EXIT ) {
				System.err.println( choice+"선택");
				acManager.objectSave();
				//acManager.objectLoad();
				//System.out.println("AccountInfo.obj 파일을 만듭니다.");
				System.out.println("프로그램을 종료 합니다.");
				System.exit(0);
				
			}
			
		}
	}
	
	public static void main(String[] args) {
				
		menuChoice();	
				
	}
	
}
