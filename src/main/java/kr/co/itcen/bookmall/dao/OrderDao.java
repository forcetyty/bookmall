package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.BookOrder;
import kr.co.itcen.bookmall.vo.Cart;


//카트를 주문하는 Vo
//cartno - int - 카트 고유 번호를 가지고 오는 기능
//orderno - int - 주문 고유 번호 - 자동증가
//order_date - date - 주문날짜

public class OrderDao {
	
		// 주문목록에 담는 메소드
		public void cartOrderDao(int order, String addr) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ServiceUtil.getConnection();
				String sql = "insert into bookorder values(?, null, now(), ?)";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, order); // 카트 고유번호 입력
				pstmt.setString(2, addr); //배송지 주소 입력
				
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

}
