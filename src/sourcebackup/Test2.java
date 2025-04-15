//package banking;
//
//import java.util.Objects;
//
//
//
//public class Test2 {
//
//	@Override
//	public int hashCode() {
//		/*
//		  
//		 */
//		int returnCode1 = super.getAge() + this.subject.hashCode();
//		System.out.println("returnCode1 = " + returnCode1);
//		
//		/*
//		 방법2 : Object 클래스의 정적메서드인 hash()를 사용한다.
//		 멤버변수의 갯수만큼 인수로 전달하면 방법1과 동일하게
//		 고유한 주소값을 정수형으로 반환해준다. 
//		 */
//		int returnCode2 = Objects.hash(super.getAge(), this.subject );
//		System.out.println("returnCode2 = " + returnCode2);
//		
//		return returnCode2;
//	}
//		
//	@Override
//	public boolean equals( Object obj ) {
//		
//		System.out.println("equals() 호출됨");
//		
//		Teacher teacher = (Teacher)obj;
//				
//		if( teacher.getAge() == super.getAge() 
//				&& teacher.subject.equals(this.subject) ) {
//		
//			return true;
//		
//		}else {
//		
//			return false;
//		}
//	}
//
//	
//	@Override
//	public boolean equals( Object obj ) {
//		
//		System.out.println("equals() 호출됨");
//		
//		NormalAccount nc = null;
//		HighCreditAccount hc = null;
//		
//		if( obj instanceof NormalAccount ) {
//			
//			nc = (NormalAccount)obj;
//			
//			if( nc.getAccountNumber().equals( this.  ) ) {
//				
//			}
//			
//			
//		}else if( obj instanceof HighCreditAccount ) {			
//			hc = (HighCreditAccount)obj;
//		}
//			
//		  
//		
//		if( teacher.getAge() == super.getAge() 
//				&& teacher.subject.equals(this.subject) ) {		
//			return true;
//		
//		}else {
//			
//			return false;
//		}
//	}
//	
//}
package sourcebackup;


