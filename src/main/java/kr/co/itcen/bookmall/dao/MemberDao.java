package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.User;

/* user Table 구조
 * no - 기본키 - Auto
 * name - 이름 - String
 * pnumber - 핸드폰 번호 - int
 * email - 이메일 - String
 * password - 비밀번호 - String
 */

public class MemberDao {

	public void memberInsert(User user) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ServiceUtil.getConnection();
			String sql = "insert into user values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getUserid()); // 아이디
			pstmt.setString(2, user.getPassword());// 비밀번호
			pstmt.setString(3, user.getName()); // 이름
			pstmt.setInt(4, user.getPnumber()); // 폰번호
			pstmt.setString(5, user.getEmail()); // 이메일 주소
			

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

}
