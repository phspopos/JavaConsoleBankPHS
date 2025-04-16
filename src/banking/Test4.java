package banking;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
	    int x = 0;
	    int y = 0;
	
	    while (true) {
	        System.out.println("현재 위치: (" + x + ", " + y + ")");
	        System.out.print("W/A/S/D 중 하나를 입력하고 엔터: ");
	        String input = scanner.nextLine().toUpperCase();
	
	        switch (input) {
	            case "W":
	                y--;
	                break;
	            case "S":
	                y++;
	                break;
	            case "A":
	                x--;
	                break;
	            case "D":
	                x++;
	                break;
	            default:
	                System.out.println("잘못된 입력입니다.");
	        }
	    }    
	
	}
}
