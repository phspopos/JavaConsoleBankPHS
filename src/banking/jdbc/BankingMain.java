package banking.jdbc;

import java.util.Scanner;
import banking.AccountErrorException;

public class BankingMain {

	
	public static Scanner sc = new Scanner(System.in);
	public static BankingManager bkManager = new BankingManager();
	
	public static void menu() {
		System.out.println("---Menu---");
		System.out.println("1. 계좌계설 정보 입력 ");
		System.out.println("2. 전체정보보기");
		System.out.println("3. 입금하기");
		System.out.println("4. 현금찾기");
		System.out.println("5. 지정계좌정보출력");
		System.out.println("6. 계좌삭제하기");
	}
	
	public static void menuChoice() {
		
		int choice = 0;
		
		while( true ) {
			
			menu();
		
			choice = AccountErrorException.errorCheckMoney();
			//choice = sc.nextInt();
			
			if( choice == 1 ) {
				System.err.println( choice+"선택");
				bkManager.insert();
				
			}else if( choice == 2 ) {
				System.err.println( choice+"선택");
				bkManager.selectAll();
				
			}else if( choice == 3 ) {
				System.err.println( choice+"선택");
				bkManager.depositMoney();
			
			}else if( choice == 4 ) {
				System.err.println( choice+"선택");
				bkManager.withdrawMoney();
			
			}else if( choice == 5 ) {
				System.err.println( choice+"선택");
				bkManager.selectOne();
			
			}else if( choice == 6 ) {
				System.err.println( choice+"선택");
				bkManager.bankDelete();
			}	
			
		}
	}
	
	public static void main(String[] args) {
		
		menuChoice();		
		
	}
}
