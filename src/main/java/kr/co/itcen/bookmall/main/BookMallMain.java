package kr.co.itcen.bookmall.main;

import java.util.Scanner;

import kr.co.itcen.bookmall.dao.MemberDao;
import kr.co.itcen.bookmall.vo.User;

/*
 * - BookMall을 실행시키는 메인 클래스
 * - 핵심 메소드
 * - 1. MemberDaoTest
 * - 2. CategoryDaoTest
 * - 3. BookDaoTest
 * - 4. CartDaoTest
 * - 5. OrderDaoTest
 */
public class BookMallMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMallMain book = new BookMallMain();
		book.init();

	}

	public void init() {
		System.out.println("************************************************************");
		System.out.println("***************************태영 서점***************************");
		System.out.println("************************************************************");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. 회원가입");
		
		int num = scanner.nextInt();

		switch (num) {
		case 1:
			memberDaoTest();
			break;

		default:
			break;
		}
		
		scanner.close();

	}

	public void memberDaoTest() {
		/*
		 * no - 기본키 - 자동증가 name - 이름 pnumber - 핸드폰 번호 email - 이메일 password - 비밀번호
		 */
		Scanner scanner = new Scanner(System.in);
		MemberDao dao = new MemberDao();
		User user = new User();

		System.out.println("<<<<<<<<<<<<회원가입 >>>>>>>>>>>>>");
		
		System.out.print("아이디 : ");
		String id = scanner.nextLine();
		user.setUserid(id);
		
		System.out.print("이름 : ");
		String name = scanner.next();
		user.setName(name);
		
		System.out.print("전화번호 : ");
		int pnumber = scanner.nextInt();	
		user.setPnumber(pnumber);
		
		/*
		 * try {
		 * 
		 * } catch (Exception e) { // TODO: handle exception
		 * System.out.println("11자리를 넘겼습니다."); System.out.println("처음으로 돌아갑니다.\n");
		 * init(); }
		 */

		System.out.print("이메일 : ");
		String email = scanner.next();
		user.setEmail(email);

		System.out.print("비밀번호 : ");
		String password = scanner.next();
		user.setPassword(password);

		System.out.println("회원가입 완료!!!");
		
		dao.memberInsert(user);

		scanner.close();
	}

}
