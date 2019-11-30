package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.BookOrder;
import kr.co.itcen.bookmall.vo.BookOrderDetail;


public class OrderDao {

	// 주문목록에 담는 Dao
	// 카트에 있는 주문 목록을 주문테이블에 입력
	public void cartOrderDao(int order, String addr, String isbn) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ServiceUtil.getConnection();
			String sql = "insert into bookorder values(?, null, now(), ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, order); // 카트 고유번호 입력
			pstmt.setString(2, addr); // 배송지 주소 입력
			pstmt.setString(3, isbn); // 배송지 주소 입력

			pstmt.execute();
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error :" + e);
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

	// 주문 전체 목록에 대한 출력 Dao
	public List<BookOrder> orderAllPrintDao() {
		List<BookOrder> list = new ArrayList<BookOrder>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select cartno, orderno, order_date, addr from bookorder";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cartno = rs.getInt(1);
				int orderno = rs.getInt(2);
				String order_date = rs.getString(3);
				String addr = rs.getString(4);

				BookOrder bo = new BookOrder();

				bo.setCartno(cartno);
				bo.setOrderno(orderno);
				bo.setOrder_date(order_date);
				bo.setAddr(addr);

				list.add(bo);
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

	// 주문 상세 정보에 대한 출력 Dao
	public List<BookOrderDetail> orderMemberPrintDao() {
		List<BookOrderDetail> list = new ArrayList<BookOrderDetail>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select b.name, b.price, bo.orderno, bo.addr, bo.order_date from bookorder as bo, book as b\r\n" + 
					"where bo.isbn = b.isbn";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String name = rs.getString(1);
				int price = rs.getInt(2);
				int orderno = rs.getInt(3);
				String addr = rs.getString(4);
				String order_date = rs.getString(5);

				BookOrderDetail bod = new BookOrderDetail();

				bod.setName(name);
				bod.setPrice(price);
				bod.setOrderNum(orderno);
				bod.setAddress(addr);
				bod.setOrder_date(order_date);

				list.add(bod);
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

}
