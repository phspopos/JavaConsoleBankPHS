package sourcebackup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//import ex20io.Circle;

public class Test3 {
	
	public static void main(String[] args) {
		
		try {
			
			//인스턴스를 파일로 저장하기 위해 출력스트림 생성
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/banking/AccountInfo.obj")
			);
			
			
		
			// Circle 인스턴스 생성후 파일에 저장
			//out.writeObject( new Circle( 1, 1, 2.4 ) );
			
			//out.writeObject( new Circle( 2, 2, 4.8 ) );
			/*
			  Java에서 제공하는 기본클래스는 별도의 처리없이 직렬화 할수 있다.
			 */
			out.writeObject( new String("String타입의 오브젝트") );
			//스트림 소멸
			out.close();
			
			//// 여기까지 실행하면 obj 파일이 생성됨
			
			/*
			 인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고
			 readObject 를 통해 복원한다. 
			 */
			ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("src/banking/AccountInfo.obj")	
			); 
			
			/*
			 저장시 Object 기반으로 저장되므로 복원시에는 원래의
			 자료형으로 다운캐스팅 (강제형변환) 해야한다.
			 */
//			Circle c1 = (Circle)in.readObject();
//			Circle c2 = (Circle)in.readObject();
//			String message = (String)in.readObject();
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
			
		}/*catch( ClassNotFoundException e ) {
			System.out.println("[예외]클래스없음");
		
		}*/catch( FileNotFoundException e ) {
			System.out.println("[예외]파일없음");
		
		}catch( IOException e ) {
			System.out.println("[Exception]뭔가없음");
		}
		
//		try {
//			
//			//인스턴스를 파일로 저장하기 위해 출력스트림 생성
//			ObjectOutputStream out = new ObjectOutputStream(
//					new FileOutputStream("src/ex20io/circle.obj")
//			);
//			
//			// Circle 인스턴스 생성후 파일에 저장
//			out.writeObject( new Circle( 1, 1, 2.4 ) );
//			out.writeObject( new Circle( 2, 2, 4.8 ) );
//			/*
//			  Java에서 제공하는 기본클래스는 별도의 처리없이 직렬화 할수 있다.
//			 */
//			out.writeObject( new String("String타입의 오브젝트") );
//			//스트림 소멸
//			out.close();
//			
//			//// 여기까지 실행하면 obj 파일이 생성됨
//			
//			/*
//			 인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고
//			 readObject 를 통해 복원한다. 
//			 */
//			ObjectInputStream in = new ObjectInputStream(
//				new FileInputStream("src/ex20io/circle.obj")	
//			); 
//			
//			/*
//			 저장시 Object 기반으로 저장되므로 복원시에는 원래의
//			 자료형으로 다운캐스팅 (강제형변환) 해야한다.
//			 */
//			Circle c1 = (Circle)in.readObject();
//			Circle c2 = (Circle)in.readObject();
//			String message = (String)in.readObject();
//			in.close();
//			
//			/*
//			 개발자가 직접 정의한 클래스는 멤버메서드를 통해 정보를 
//			 출력할 수 있다.			  
//			 */
//			c1.showCircleInfo();
//			c2.showCircleInfo();
//			/*
//			 기본클래스는 이미 toString이 오버라이딩 되어 있으므로
//			 즉시 출력할 수 있다. 
//			 */
//			System.out.println("String 오브젝트 : " + message );
//			
//		}catch( ClassNotFoundException e ) {
//			System.out.println("[예외]클래스없음");
//		
//		}catch( FileNotFoundException e ) {
//			System.out.println("[예외]파일없음");
//		
//		}catch( IOException e ) {
//			System.out.println("[Exception]뭔가없음");
//		}
	}
}
