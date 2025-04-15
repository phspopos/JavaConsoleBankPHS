package banking;

public class AutoSaver extends Thread {

	
	@Override
	public void run() {		
		
		try {
						
			while( AccountManager.check ) {
				
				sleep(5000); 				
				BankingSystemMain.acManager.autoSaveFile();
				System.out.println("파일 저장중");
				
			}
			
		}catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}
	
}
