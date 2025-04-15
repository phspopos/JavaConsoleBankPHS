package sourcebackup;

public class AutoSaver extends Thread {

	
	@Override
	public void run() {		
		
		try {
			
			/*
			 Thread 클래스의 static메서드인 sleep을 통해
			 실행의 흐름을 주어진 시간만큼 block상태로 전화시켜
			 준다. 1000분의 1초 단위이므로 10은 0.01초를 의미한다. 
			 */
			while( AccountManager.check ) {
				
				sleep(5000); //0.01
				BankingSystemMain.acManager.objectSave();
				System.out.println("파일 저장중");
				
			}
			
		}catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}
	
}
