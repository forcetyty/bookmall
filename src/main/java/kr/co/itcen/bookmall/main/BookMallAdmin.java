package kr.co.itcen.bookmall.main;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.MemberDao;
import kr.co.itcen.bookmall.vo.Member;
import kr.co.itcen.bookmall.vo.MemberOrder;

// BookMall 관리자 화면!!!
public class BookMallAdmin {

	private String ID = "admin";	// 관리자 로그인에 대한 ID
	private String PW = "1234";		// 관리자 비밀번호에 대한 Password

	private Scanner scan = new Scanner(System.in);

	// 관리자 로그인 처리 Process
	public void loginProcess() {
		String id = null;
		String password = null;

		System.out.print("ID :");
		id = scan.next().trim();
		System.out.print("password :");
		password = scan.next().trim();

		// 관리자
		if (ID.equals(id) && PW.equals(password)) {
			System.out.println("로그인 되었 습니다.");
			adminProcess();
		} else if (!ID.equals(id)) {
			System.out.println("잘 못 입력하셨습니다. ");
		} else if (!PW.equals(password)) {
			System.out.println("잘 못 입력하셨습니다. ");
		}
	}
	/////////////////////

	// 로그인된 관리자 처리 Process
	public void adminProcess() {
		int choice = 0;

		System.out.println("1. 회원정보 출력 2. 회원별 구매 목록 확인 3. 회원 삭제");
		choice = scan.nextInt();

		switch (choice) {
		case 1:
			memberDaoTest();
			break;
		case 2:
			memberBookOrderCheck();
			break;
		case 3:
			memberDaoTest();
			memberDelete();
			break;
		default:
			break;
		}
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

	// 회원을 삭제하는 기능
	public void memberDelete() {
		String id = null;

		MemberDao dao = new MemberDao();

		System.out.println("삭제할 ID를 입력 : ");
		id = scan.next();

		dao.memberDeleteDao(id.trim());

		System.out.println(id + "님의 회원 정보가 삭제되었습니다.");

	}
	///////////////////////

	// 회원별 책 구매내역 확인
	public void memberBookOrderCheck() {
		// member와 cart, bookorder를 기반으로 데이터를 가져와야함.
		// 회원 목록 출력
		String id = null;
		MemberDao dao = new MemberDao();
		List<Member> list = dao.memberList();

		for (Member member : list) {
			System.out.println("유저 아이디 :" + member.getUserid() + " 이름 :" + member.getName() + " 핸드폰 번호 :"
					+ member.getPnumber() + " 이메일 주소 :" + member.getEmail());
		}

		System.out.println("----------회원별 책 구매내역 확인----------");
		System.out.print("아이디 입력 : ");
		id = scan.next().trim();
		
		List<MemberOrder> mlist = dao.memberBookOrderList(id);

		for (MemberOrder morder : mlist) {
			System.out.println(
					"유저 아이디 :" + morder.getUserid() + " 주문 번호 : "+ morder.getOrderno() + " 책 이름 : " + morder.getName() + " 주문번호 : " + morder.getOrder_date());
		}

	}
	///////////////////////

}
