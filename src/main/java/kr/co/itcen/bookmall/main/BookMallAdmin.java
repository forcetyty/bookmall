package kr.co.itcen.bookmall.main;

import java.util.Scanner;

// BookMall 관리자 화면!!!
public class BookMallAdmin {
	private String ID = "admin";
	private String PW = "1234";
	
	private Scanner scan = new Scanner(System.in);
	
	public void loginProcess() {
		String id = null;
		String password = null;
		
		System.out.print("ID :" );
		id = scan.next().trim();
		System.out.print("password :" );
		password = scan.next().trim();
		
		if(ID.equals(id) || PW.equals(password)) {
			System.out.println("잘 못 입력하셨습니다.");
		}else if(ID.equals(id) && PW.equals(password)) {
			System.out.println("로그인 되었 습니다.");
		}
		
	}

}
