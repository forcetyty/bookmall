package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.Cart;

public class CartDao {

	public void cartInsertDao(Cart cart) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ServiceUtil.getConnection();
			String sql = "insert into cart values(?,?,?, now())";
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

}
