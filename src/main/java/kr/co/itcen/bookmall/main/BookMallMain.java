package kr.co.itcen.bookmall.main;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.MemberDao;
import kr.co.itcen.bookmall.vo.Book;
import kr.co.itcen.bookmall.vo.Category;
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

	// 초기화
	public void init() {
		System.out.println("************************************************************");
		System.out.println("***************************태영 서점***************************");
		System.out.println("************************************************************");

		Scanner scanner = new Scanner(System.in);
		System.out.println("1. 회원가입  2. 회원리스트 출력  3. 카테고리 출력  4. 상품리스트");

		int num = scanner.nextInt();

		switch (num) {
		case 1:
			memberDaoTestInsert();
			break;
		case 2:
			memberDaoTest();
			break;
		case 3:
			categoryDaoTest();
		case 4:
			bookDaoTest();
		default:
			break;
		}

		scanner.close();

	}

	// 회원가입하는 테이블
	public void memberDaoTestInsert() {
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
		String pnumber = scanner.next();
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
	/////////////////////

	// 회원리스트를 출력하는 메소드
	public void memberDaoTest() {
		MemberDao dao = new MemberDao();

		List<User> list = dao.memberList();

		for (User user : list) {
			System.out.println(user);
		}
	}
	///////////////////////

	// 카테고리를 출력하는 메소드
	public void categoryDaoTest() {
		// 대분류 - 몇개가 있는지 출력
		// 중분류 - 몇개가 있는지 출력
		// 전체 리스트 출력
		CategoryDao dao = new CategoryDao();

		List<Category> list;

		System.out.println("1.대분류 목록 출력 | 2.중분류 목록 출력 | 3.전체 리스트 출력");

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();

		switch (num) {
		case 1:
			list = dao.mainCatePrint();
			for (Category cat : list) {
				System.out.println("대분류 :" + cat.getMaincate() + "  전체 :" + cat.getCountnum());
			}
			break;

		case 2:
			list = dao.midCatePrint();
			for (Category cat : list) {
				System.out.println("중분류 :" + cat.getMidcate());
			}
			break;
		case 3:
			list = dao.totalPrint();
			for (Category cat : list) {
				System.out.println("대분류 :" + cat.getMaincate() + ":" + "중분류 :" + cat.getMidcate());
			}
		}

		scanner.close();
	}
	/////////////////////

	// 도서목록을 출력하는 메소드
	// 책 코드 분류 기준!!!
	// 코드 표!!!
	// -- IT 00 -- html 0a / javascript 0b / jsp 0c / react 0d / spring 0e
	// -- computer 01 -- database 0a / network 0b / os 0c /
	public void bookDaoTest() {

		// 1. 전체 수량 - 대분류, 중분류, 책 수량 출력하는 메소드
		// 2. 책 전체 목록 출력 - isbn, name, price, maincate, midcate - 책 테이블에 대한 전체 정보 출력
		BookDao dao = new BookDao();
		List<Book> list;
		
		System.out.println(" 1. 전체 수량 | 2. 책 전체 목록 출력 ");
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		switch (num) {
		case 1:
			System.out.println("카테고리 별 책 수량 출력");
			list = dao.bookCatePrintDao();
			
			for (Book book : list) {
				System.out.println("대분류 :" + book.getMaincate() +" 중분류 :" + book.getMidcate() + " 책 수량 :" + book.getCount());
			}
			break;
		case 2:
			System.out.println("책 전체 목록 출력");
			list = dao.bookPrintDao();
			for (Book book : list) {
				System.out.println("isbn :" + book.getIsbn() + " 책 이름 :" + book.getName() + " 책 가격 :" + book.getPrice()
						+ " 대분류 : " + book.getMaincate() + " 중분류 : " + book.getMidcate());
			}
			break;

		default:
			break;
		}

		scanner.close();
	}
	/////////////////////

}
