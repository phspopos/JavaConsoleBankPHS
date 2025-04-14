package banking;

import java.util.HashSet;
import java.util.Iterator;

public class Tset {

	public static void main(String[] args) {
		
		
		Account ac1 = new NormalAccount( "111","111", 10000, 2);
		Account ac2 = new HighCreditAccount( "222","222", 20000, 2, "a");
		
		//HashSet<Teacher> hashSet = new HashSet<Teacher>();
		
		HashSet<Account> set = new HashSet<Account>();
		set.add(ac1);
		set.add(ac2);
		
		/*
		Iterator<Teacher>  it = hashSet.iterator();
		
		while( it.hasNext() ) {
			System.out.println( it.next() );
		}
		*/
		
		Iterator it = set.iterator();
		
		while( it.hasNext() ) {
			
			Account ac = (Account)it.next();
			
			if(  ac instanceof NormalAccount ) {
				System.out.println("노말 계좌번호 : "+ ((NormalAccount)ac).getAccountNumber() );
				
			}else if( ac instanceof HighCreditAccount ) {
				System.out.println("하이 계좌번호"+ ((HighCreditAccount)ac).getAccountNumber() );
			}
			
		}
		
		
	}
}
