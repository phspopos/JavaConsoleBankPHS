package sourcebackup.banking.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingManager {

	public Connection con = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;
	public Statement stmt = null;
	public CallableStatement csmt;
	
	
	public Connection getConnection() {
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "education";
			String pass = "1234";
			
			con = DriverManager.getConnection( url, id, pass ); 
			
			/*
			if( con != null ) {
				System.out.println("Oracle 연결성공");
			}else {
				System.out.println("Oracle 연결실패");
			}
			*/
		}catch( Exception e ) {
			System.out.println("Oracle 연결시 예외발생");
		}
		return con;
	}
	
	public void insert() {
		
		try{
			//( seq_banking_idx.nextval, '11', '김하나', 10000, 2.0 );
			String sql = "insert into banking values( seq_banking_idx.nextval,"
					+ " ?, ?, ?, ? ) ";
			
			System.out.println(sql);
			
			con = getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString( 1, inputValue("계좌번호") );
			psmt.setString( 2, inputValue("이름") );
			psmt.setInt( 3, Integer.parseInt( inputValue("잔액") ) );
			psmt.setDouble( 4, Double.parseDouble( inputValue("이자율") ) );
			
			int result = psmt.executeUpdate();
			
			if( result > 0 ) {
				System.out.println("입력성공");
			
			}else {
				System.out.println("입력실패");
			}			
			
		}catch( SQLException e ) {
			e.printStackTrace();
		
		}finally {
			dbClose();
		}
		
	}
	
	//전체 검색
	public void selectAll(){
		
		try {
			//int idx, String accountNum, String name, int balance, double rate
			String sql = "select idx, accountNum, name, balance, rate from banking order by idx";
			System.out.println(sql);
			con = getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				
				int idx = rs.getInt("idx");
				String accountNum = rs.getString("accountNum");
				String name = rs.getString("name");
				int balance = rs.getInt("balance");
				double rate = rs.getDouble("rate");
				
				System.out.println( idx + " " + accountNum + " " + name + " " + balance + " " + rate );
				
			}
			
		}catch( SQLException e ) {
			e.printStackTrace();
		
		}finally {
			dbClose();
		}		
		
	}
	
	//지정한 계좌 정보 출력
	public void selectOne() {
		
		try {
			
			System.out.println("계좌번호를 입력해 주세요");
			String accNum = BankingMain.sc.nextLine();
			
			String sql = "select idx, accountNum, name, balance, rate from banking "
					+ " where accountNum = " + accNum;
			
			System.out.println(sql);
			
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				
				int idx = rs.getInt("idx");
				String accountNum = rs.getString("accountNum");
				String name = rs.getString("name");
				int balance = rs.getInt("balance");
				double rate = rs.getDouble("rate");
				
				System.out.println( idx + " " + accountNum + " " + name + " " + balance + " " + rate );
				
			}
			
			
		}catch( SQLException e ) {
			e.printStackTrace();
			
		}finally {
			dbClose();
			
		}
	}
	
	public void dbClose() {
		
		try{	
			
			if( rs != null ) rs.close();
			if( psmt != null ) psmt.close();
			if( stmt != null ) stmt.close();
			if( csmt != null ) csmt.close();
			if( con != null ) con.close();			
			
		}catch( SQLException e ) {
			e.printStackTrace();
		}		
	}
	
	//입금
	public void depositMoney() {
		
		try {
			
			System.out.println("계좌번호를 입력해 주세요");
			String accNum = BankingMain.sc.nextLine();
			
			System.out.println("입금액을 입력해 주세요");
			int money = BankingMain.sc.nextInt();
			
			String sql1 = "select balance from banking where accountNum = "+ accNum;
			System.out.println(sql1);
			
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql1);
			
			int b_money = 0;
			
			while( rs.next() ) {
				b_money = rs.getInt("balance");	
			}
			
			System.out.println(" 잔액 : " + b_money );
			
			String sql2 = "update banking set balance = ? where accountNum = ?";
			
			System.out.println(sql2);
			
			//잔액 + (잔액 * 기본이자) + 입금액
			int total = (int)( (b_money + ( b_money * 0.02 )) + money );
			
			psmt = con.prepareStatement(sql2);
			psmt.setInt( 1, total );
			psmt.setString( 2, accNum );
			
			int result = psmt.executeUpdate();
			
			if( result > 0 ) {
				System.out.println("입금성공");
			
			}else {
				System.out.println("입금실패");
			}
			
			
			
		}catch( SQLException e ) {
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		
	}
	
	//출 금
	public void withdrawMoney() {
		
		try {
			
			System.out.println("계좌번호를 입력해 주세요");
			String accNum = BankingMain.sc.nextLine();
			
			BankingMain.sc.nextLine();
			
			System.out.println("찾을 금액을 입력해 주세요");
			int money = BankingMain.sc.nextInt();	
			
			String sql = "select balance from banking where accountNum = " + accNum;
			System.out.println(sql);
			
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			int b_money = 0;
			
			while( rs.next() ) {
				b_money = rs.getInt("balance");
			}
			
			System.out.println("찾기 잔액 : " + b_money);
			
			String sql2 = "update banking set balance = ? where accountNum = ?";
			System.out.println(sql2);
			
			
			if( b_money >= money ) {
				
				int total = b_money - money;
				
				psmt = con.prepareStatement(sql2);
				
				psmt.setInt( 1, total );
				psmt.setString( 2, accNum );
				
				int result = psmt.executeUpdate();
				
				if( result > 0 ) {
					System.out.println("출금성공");
				
				}else {
					System.out.println("에러발생 다시 시작해 주세요");
				}				
				
			}else {
				System.out.println("현재 있는 잔액보다 찾을 금액이 큼니다.");
			}			
			
			
		}catch( SQLException e ) {
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
	}
	
		
	public String inputValue(String title) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print( title + "을(를) 입력(exit->종료) : ");
		String inputStr = sc.nextLine();
			
		if( "EXIT".equalsIgnoreCase( inputStr ) ) {
			System.out.println("프로그램을 종료합니다.");
		
			//dbClose();		
			System.exit(0);
			
		}		
		
		return inputStr;
	}
	
	//삭제
	public void bankDelete() {
		
		try {
			
			System.out.println("삭제할 계좌번호를 입력해 주세요");
			String accNum = BankingMain.sc.nextLine();
			
			con = getConnection();
			
			//csmt = con.prepareCall("{ call ShopDeleteGoods( ?, ? ) }");
			csmt = con.prepareCall("{ call bankingDelete( ?, ? ) } ");
			csmt.setString( 1, accNum );
			csmt.registerOutParameter( 2, Types.VARCHAR );
			csmt.execute();
			
			String result = csmt.getString(2);
			
			System.out.println( result );			
			
			
			
		}catch( SQLException e ) {
			e.printStackTrace();
		
		}finally {
			dbClose();
		}
		
		
	}
	
	
}
