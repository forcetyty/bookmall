package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.Member;
import kr.co.itcen.bookmall.vo.MemberOrder;


public class MemberDao {

	// 회원가입을 가능하게 하는 Dao
	public void memberInsert(Member member) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ServiceUtil.getConnection();
			String sql = "insert into member values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getUserid()); // 아이디
			pstmt.setString(2, member.getPassword());// 비밀번호
			pstmt.setString(3, member.getName()); // 이름
			pstmt.setString(4, member.getPnumber()); // 폰번호
			pstmt.setString(5, member.getEmail()); // 이메일 주소

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

	// DataBase에서 회원테이블에 대한 정보를 가져오는 Dao
	public List<Member> memberList() {
		List<Member> list = new ArrayList<Member>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ServiceUtil.getConnection();
			String sql = "select userid, password, name, number, email from member";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 데이터베이스에 있는 Row를 돌며 VO 객체를 통해 접근
			while (rs.next()) {
				String id = rs.getString(1);
				String pass = rs.getString(2);
				String name = rs.getString(3);
				String pnumber = rs.getString(4);
				String email = rs.getString(5);

				Member member = new Member();

				member.setUserid(id);
				member.setPassword(pass);
				member.setName(name);
				member.setPnumber(pnumber);
				member.setEmail(email);

				list.add(member);
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

	// 회원을 삭제하는 Dao
	public void memberDeleteDao(String id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ServiceUtil.getConnection();
			String sql = "delete from member where userid = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			pstmt.execute();
			con.commit();

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
	}
	//////////////

	// 회원별 책 구매 목록을 출력 Dao
	public List<MemberOrder> memberBookOrderList(String id) {

		List<MemberOrder> list = new ArrayList<MemberOrder>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ServiceUtil.getConnection();
			String sql = "select t.userid, t.orderno, t.order_date, b.name from book b, (select c.userid, bo.orderno, bo.order_date, bo.isbn from bookorder bo, cart c where bo.cartno = c.cartno) as t where b.isbn = t.isbn and t.userid = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			// 데이터베이스에 있는 Row를 돌며 VO 객체를 통해 접근
			while (rs.next()) {
				
				String userid = rs.getString(1);
				int orderno = rs.getInt(2);
				String order_date = rs.getString(3);
				String name = rs.getString(4);
				
				MemberOrder morder = new MemberOrder();

				morder.setUserid(userid);
				morder.setOrderno(orderno);
				morder.setOrder_date(order_date);
				morder.setName(name);
		
				list.add(morder);
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
