package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.Member;

/* member Table 구조
 * no - 기본키 - Auto
 * name - 이름 - String
 * pnumber - 핸드폰 번호 - int
 * email - 이메일 - String
 * password - 비밀번호 - String
 */

public class MemberDao {

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

	// DataBase에서 회원테이블에 대한 정보를 가져오는 메소드
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
	
	// 회원별 책 구매 목록을 출력 Dao
	public void memberBookOrderList() {
		
	}

}
