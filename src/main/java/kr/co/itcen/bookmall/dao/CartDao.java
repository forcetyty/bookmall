package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.Book;
import kr.co.itcen.bookmall.vo.BookCartVo;
import kr.co.itcen.bookmall.vo.Cart;

public class CartDao {

	// 카트에 담는 메소드
	public void cartInsertDao(Cart cart) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into cart values(null,?,?,?, now())";
			con = ServiceUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cart.getUserid()); // userid 입력
			pstmt.setString(2, cart.getIsbn()); // 책 고유번호
			pstmt.setInt(3, Integer.parseInt(cart.getNum())); // 책 수량

			pstmt.execute();
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("MemberDao Error :" + e);
			System.out.println("detail");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("MemberDao connection Error :" + e);

			}
		}
	}
	//////////////

	// 카트 전체 목록 출력
	public List<Cart> cartPrintDao() {
		List<Cart> list = new ArrayList<Cart>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select userid, isbn, num, cart_date from cart";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userid = rs.getString(1);
				String isbn = rs.getString(2);
				String num = rs.getString(3);
				String cart_date = rs.getString(4);

				Cart ca = new Cart();

				ca.setUserid(userid);
				ca.setIsbn(isbn);
				ca.setNum(num);
				ca.setCart_date(cart_date);

				list.add(ca);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error :" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("close error :" + e);
			}

		}
		return list;
	}
	//////////////

	// 카트 회원 전체 카트 수량 출력
	public List<Cart> cartMemberPrintDao() {
		List<Cart> list = new ArrayList<Cart>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select userid, count(isbn) from cart group by userid";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userid = rs.getString(1);
				String count = rs.getString(2);

				Cart ca = new Cart();

				ca.setUserid(userid);
				ca.setCount(Integer.parseInt(count));

				list.add(ca);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error :" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("close error :" + e);
			}

		}
		return list;
	}
	//////////////

	// 날짜별 카트 회원 수량 출력
	public List<Cart> cartDatePrintDao(String date) {
		List<Cart> list = new ArrayList<Cart>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select userid, isbn, num, cart_date from cart where cart_date = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date); // where 절에 대한 질의 처리
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userid = rs.getString(1);
				String isbn = rs.getString(2);
				String num = rs.getString(3);
				String cart_date = rs.getString(4);

				Cart ca = new Cart();

				ca.setUserid(userid);
				ca.setIsbn(isbn);
				ca.setNum(num);
				ca.setCart_date(cart_date);

				list.add(ca);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error :" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("close error :" + e);
			}

		}
		return list;
	}

	//////////////
	// 연관 Order
	// 회원이 가지고 있는 카트정보에 도서정보를 출력해주는 메소드
	public List<Cart> cartChoicePrintDao(String input_userid) {
		List<Cart> list = new ArrayList<Cart>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select cartno, isbn, num, cart_date from cart where userid = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, input_userid); // userid 입력

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cartno = rs.getInt(1);
				String isbn = rs.getString(2);
				String num = rs.getString(3);
				String cart_date = rs.getString(4);

				Cart ca = new Cart();

				ca.setNo(cartno);
				ca.setIsbn(isbn);
				ca.setNum(num);
				ca.setCart_date(cart_date);

				list.add(ca);

			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error :" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("close error :" + e);
			}

		}
		return list;

	}

	// 연관 Order
	// 카트에 있는 도서정보를 출력해주는 기능
	public List<BookCartVo> cartChoiceBookPrintDao(String input_isbn) {
		List<BookCartVo> list = new ArrayList<BookCartVo>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과
		
		try {
			con = ServiceUtil.getConnection();
			String sql = "select c.userid, c.isbn, b.name, b.price, c.cart_date from book as b, cart as c where b.isbn = c.isbn and c.isbn = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, input_isbn); //
			

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String userid = rs.getString(1);
				String isbn = rs.getString(2);
				String name = rs.getString(3);
				int price = rs.getInt(4);
				String cart_date = rs.getString(5);

				BookCartVo bcv = new BookCartVo();

				bcv.setUserid(userid);
				bcv.setIsbn(isbn);
				bcv.setName(name);
				bcv.setPrice(price);
				bcv.setCart_date(cart_date);

				list.add(bcv);

			}

		} catch (SQLException e) { // TODO: handle exception
			System.out.println("error :" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("close error :" + e);
			}

		}
		return list;

	}

	//////////////

}
