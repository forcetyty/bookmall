package kr.co.itcen.bookmall.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.MemberDao;
import kr.co.itcen.bookmall.vo.Book;
import kr.co.itcen.bookmall.vo.Cart;
import kr.co.itcen.bookmall.vo.Category;
import kr.co.itcen.bookmall.vo.Member;


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
		System.out.println("1. 회원가입  2. 회원리스트 출력  3. 카테고리 출력  4. 상품리스트  5. 카트추가  6. 카트 목록보기");

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
			break;
		case 4:
			bookDaoTest();
			break;
		case 5:
			cartDaoTest();
			break;
		case 6:
			cartDaoTestPrint();
			break;
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
		Member member = new Member();

		System.out.println("<<<<<<<<<<<<회원가입 >>>>>>>>>>>>>");

		System.out.print("아이디 : ");
		String id = scanner.nextLine();
		member.setUserid(id);

		System.out.print("이름 : ");
		String name = scanner.next();
		member.setName(name);

		System.out.print("전화번호 : ");
		String pnumber = scanner.next();
		member.setPnumber(pnumber);

		/*
		 * try {
		 * 
		 * } catch (Exception e) { // TODO: handle exception
		 * System.out.println("11자리를 넘겼습니다."); System.out.println("처음으로 돌아갑니다.\n");
		 * init(); }
		 */

		System.out.print("이메일 : ");
		String email = scanner.next();
		member.setEmail(email);

		System.out.print("비밀번호 : ");
		String password = scanner.next();
		member.setPassword(password);

		System.out.println("회원가입 완료!!!");

		dao.memberInsert(member);
		scanner.close();
	}
	/////////////////////

	// 회원리스트를 출력하는 메소드
	public void memberDaoTest() {
		MemberDao dao = new MemberDao();

		List<Member> list = dao.memberList();

		for (Member member : list) {
			System.out.println("유저 아이디 :" + member.getUserid() + " 이름 :" + member.getName() + " 핸드폰 번호 :"
					+ member.getPnumber() + " 이메일 주소 :" + member.getEmail());
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
				System.out.println(
						"대분류 :" + book.getMaincate() + " 중분류 :" + book.getMidcate() + " 책 수량 :" + book.getCount());
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

	// 카트 리스트 확인
	// Process
	// 1. 아이디 선택 - 해결
	// 2. 상품목록 선택 - 해결
	// 3. 수량 선택 - 해결
	// 4. 카트에 담김 - 완료
	// 5. 카트 목록 - cartDaoTestPrint
	public void cartDaoTest() {

		// 아이디와 상품목록을 담기 위한 기능
		Vector<String> vec = new Vector<String>();
		Cart cart = new Cart();
		CartDao cdao = new CartDao();

		// 회원 목록 Dao 생성
		MemberDao mdao = new MemberDao();
		List<Member> list = mdao.memberList();
		Scanner scanner = new Scanner(System.in);
		int i = 0; // 회원 목록에 대한 번호를 주기 위한 초기 값

		// 책 목록 Dao 생성
		BookDao bdao = new BookDao();
		List<Book> blist = bdao.bookPrintDao();
		int j = 0; // 책 목록에 대한 번호를 주기 위한 초기 값

		// 회원 목록 출력
		for (Member member : list) {
			System.out.println("회원 번호 :" + i++ + " ID :" + member.getUserid() + " Name :" + member.getName());
		}

		System.out.print("회원번호 선택 : ");
		int memnum = scanner.nextInt();

		// 회원의 아이디 담기
		vec.add(list.get(memnum).getUserid());

		// 책 목록 출력
		for (Book book : blist) {
			System.out.println("책 번호 : " + j++ + " isbn :" + book.getIsbn() + " 책 제목 :" + book.getName() + " 책 가격 : "
					+ book.getPrice() + " 대분류 : " + book.getMaincate() + " 중분류 :" + book.getMidcate());
		}

		System.out.print("책 목록 선택 :");
		int bookchoice = scanner.nextInt();

		// 책의 고유번호 담기
		vec.add(blist.get(bookchoice).getIsbn());

		// 수량 넣기
		System.out.print("주문 수량 선택 :");
		int num = scanner.nextInt();

		// 수량 담기
		vec.add(String.valueOf(num));

		// 1차 출력확인 코드
		// 회원 출력확인
		// System.out.println(list.get(member));
		// 책 출력확인
		// System.out.println(blist.get(bookchoice).getIsbn());
		// 수량 출력 확인
		// System.out.println(num);

		// 2차
		// vector 출력 확인
		// for (int v = 0; v < vec.size(); v++) {
		// System.out.println(vec.elementAt(v));
		// }

		cart.setUserid(vec.elementAt(0));
		cart.setIsbn(vec.elementAt(1));
		cart.setNum(vec.elementAt(2));

		cdao.cartInsertDao(cart);

		scanner.close();
	}

	// 5. 카트 목록 출력
	// a. 카트 전체 목록 출력
	// b. 카트 회원 전체 카트 수량 출력
	// c. 날짜별 목록 출력
	public void cartDaoTestPrint() {
		List<Cart> list;
		CartDao dao = new CartDao();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. 카트 전체 목록 출력 | 2. 카트 회원 별 목록 출력 | 3. 날짜별 목록 출력");
		System.out.print("선택 : ");
		int num = scanner.nextInt();

		switch (num) {
		case 1:
			System.out.println("-------------카트 전체 목록 출력-------------");
			list = dao.cartPrintDao();
			int i = 0;
			for (Cart cart : list) {
				System.out.println("카트 번호 :" + i++ + " 회원 아이디 :" + cart.getUserid() + " 도서 번호 : " + cart.getIsbn()
						+ " 수량 :" + cart.getNum() + " 날짜 :" + cart.getCart_date());
			}
			break;
		case 2:
			System.out.println("-------------카트 회원 별 카트 수량 출력-------------");
			list = dao.cartMemberPrintDao();
			for (Cart cart : list) {
				System.out.println("회원 아이디 :" + cart.getUserid() + " 카트 전체 수량 :" + cart.getCount());
			}
			break;
		case 3:
			System.out.println("-------------카트 날짜 별 출력-------------");
			System.out.print("검색할 날짜 입력 (형식 : YYYY-MM-DD ):");
			String dateInput = scanner.next();

			list = dao.cartDatePrintDao(dateInput);
			for (Cart cart : list) {
				System.out.println("날짜 : " + cart.getCart_date() + " 회원 아이디 : " + cart.getUserid() + " 도서번호 : "
						+ cart.getIsbn() + " 수량 : " + cart.getNum());
			}
			break;

		default:
			break;
		}

		scanner.close();

	}

}
