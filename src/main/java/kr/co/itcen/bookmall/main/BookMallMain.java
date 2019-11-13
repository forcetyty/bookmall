package kr.co.itcen.bookmall.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.MemberDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.Book;
import kr.co.itcen.bookmall.vo.BookCartVo;
import kr.co.itcen.bookmall.vo.BookOrder;
import kr.co.itcen.bookmall.vo.BookOrderDetail;
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
 * - 추가 발전사항 - 관리자 기능을 구현!!!
 */
public class BookMallMain {
	static Scanner scan = new Scanner(System.in);
	static int num = 0;
	static String numStr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMallMain book = new BookMallMain();
		BookMallAdmin admin = new BookMallAdmin();
		//book.init();
		
		System.out.println("********************************************************************************************************");
		System.out.println("***********************************************태영 서점***************************************************");
		System.out.println("********************************************************************************************************");

		// 태영서점에 메뉴가 지속적으로 반독 될 수 있도록 해주는 것!!!
		while (true) {
			System.out.println();
			System.out.println("********************************************************************************************************");
			System.out.println(
					"1. 회원가입  2. 회원리스트 출력  3. 카테고리 출력  4. 상품리스트  5. 카트추가  6. 카트 목록보기  7. 카트 주문  8. 카트목록보기 9.종료 10. 관리자 로그인");
			
			num = scan.nextInt();	
			// No Such ElemntException
			// 이 지속적으로 발생한다.
			// 해결방법을 고민해봐야 한다.
			// 해결!!! - 각 메소드에서 Close해준 것을 해지함.

			// "1. 회원가입  2. 회원리스트 출력  3. 카테고리 출력  4. 상품리스트  5. 카트추가  6. 카트 목록보기  7. 카트 주문  8. 카트목록보기 9.종료");
			// 선택사항이 아래 메소드를 실행
			switch (num) {
				case 1:
					book.memberDaoTestInsert();
					break;
				case 2:
					book.memberDaoTest();
					break;
				case 3:
					book.categoryDaoTest();
					break;
				case 4:
					book.bookDaoTest();
					break;
				case 5:
					book.cartDaoTest();
					break;
				case 6:
					book.cartDaoTestPrint();
					break;
				case 7:
					book.cartOrder();
					break;
				case 8:
					book.OrderDaoTest();
					break;
				case 10:
					admin.loginProcess();
				}
			if (num == 9) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
	/////////////////////

	// 회원가입하는 테이블
	//  no - 기본키 - 자동증가 name - 이름 pnumber - 핸드폰 번호 email - 이메일 password - 비밀번호
	public void memberDaoTestInsert() {
		 
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
		cart.setUserid(vec.elementAt(0));
		cart.setIsbn(vec.elementAt(1));
		cart.setNum(vec.elementAt(2));

		cdao.cartInsertDao(cart);
		System.out.println(list.get(memnum).getUserid() + " 회원카트 담기 성공!!!");	
	}
	/////////////////////
	

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
	}
	/////////////////////
	

	// cartOrder
	// 카트에 있는 목록을 실제 주문하도록 하는 기능을 갖고 있음
	public void cartOrder() {

		System.out.println("-------------회원 목록 -------------");
		Scanner scanner = new Scanner(System.in);

		// 회원 목록 Dao 생성
		MemberDao mdao = new MemberDao();
		List<Member> list = mdao.memberList();
		int i = 0; // 회원 목록에 대한 번호 부여

		// 회원 목록 출력
		for (Member member : list) {
			System.out.println("회원 번호 :" + i++ + " ID :" + member.getUserid() + " Name :" + member.getName());
		}

		System.out.print("회원 아이디 선택 : ");
		int memnum = scanner.nextInt();

		// 선택된 회원 번호 출력
		System.out.println("회원 아이디 :" + list.get(memnum).getUserid());

		// 아이디별 카트 목록 Dao 호출
		CartDao cdao = new CartDao();
		List<Cart> clist = cdao.cartChoicePrintDao(list.get(memnum).getUserid());

		// 회원이 가지고 있는 카트 출력
		// 카트를 선택하면 카트에 담겨있는 책 정보도 볼수 있게 해야 함.
		System.out.println("--------" + list.get(memnum).getUserid() + " 회원 카트 목록 출력 --------");
		int j = 0;
		for (Cart cart : clist) {
			System.out.println("카트 선택 번호 : " + j++ + " 도서번호 :" + cart.getIsbn() + " 수량 :" + cart.getNum() + " 날짜 :"
					+ cart.getCart_date() + " 카트 고유 번호 :" + cart.getNo());
		}
		System.out.print("카트 선택 :");
		int orderchoice = scanner.nextInt();

		// 주문실행
		OrderDao orderDao = new OrderDao();
		System.out.println(clist.get(orderchoice).getNo());

		System.out.println("-------주문 실행----------");

		System.out.println("선택한 카트목록에 대한 주문을 실행하시겠습니까??? 1. Yes 2.No");
		System.out.println("번호 선택 :");
		int choice = scanner.nextInt();

		if (choice == 1) {
			System.out.print("배송지를 입력해주세요 : ");
			String address = scanner.next();

			if (address.length() > 0) {
				orderDao.cartOrderDao(clist.get(orderchoice).getNo(), address, clist.get(orderchoice).getIsbn());
				System.out.println("주문 성공");
			}
		} else {
			System.out.println("주문을 취소하셨습니다.");
		}
	}
	/////////////////////
	

	// 주문 테이블에 있는 정보를 출력하는 메소드
	public void OrderDaoTest() {
		System.out.println("-------------------주문 목록 확인-------------------");
		Scanner scanner = new Scanner(System.in);
		int num = 0;

		System.out.println("1.주문 전체 목록 확인  2.주문 도서 리스트 확인");
		num = scanner.nextInt();

		// 전체 주문목록 Dao 생성
		OrderDao dao = new OrderDao();

		List<BookOrder> alllist = dao.orderAllPrintDao();
		List<BookOrderDetail> bodlist = dao.orderMemberPrintDao();

		// 주문목록 출력
		switch (num) {
		case 1:
			System.out.println("주문 전체 목록");
			for (BookOrder bookorder : alllist) {
				System.out.println("주문 카트번호 :" + bookorder.getCartno() + " 주문번호 :" + bookorder.getOrderno() + " 주문일자 :"
						+ bookorder.getOrder_date() + " 주소 :" + bookorder.getAddr());
			}
		case 2:
			System.out.println("주문 도서 리스트 확인");
			for (BookOrderDetail bookorderdetail : bodlist) {
				System.out.println("책 제목 :" + bookorderdetail.getName() + " 가격 :" + bookorderdetail.getPrice()
						+ " 주문번호 :" + bookorderdetail.getOrderNum() + "배송지" + bookorderdetail.getAddress() + " 주문 일자 :"
						+ bookorderdetail.getOrder_date());
			}
			break;

		default:
			break;
		}

	}
	/////////////////////
}
