package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.Category;

/*
 * 추후 발전
 * 비슷한 구조를 가지고 있기 떄문에
 * 인자로 sql 문장을 구분해주는 코드를 구현하면
 * 코드의 중복을 막을수 있을 듯하다!!!
 */
public class CategoryDao {

	// 대분류를 가져오는 Dao
	public List<Category> mainCatePrint() {
		List<Category> list = new ArrayList<Category>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select maincate, count(maincate) from category group by maincate";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String maincate = rs.getString(1);
				String maincount = rs.getString(2);

				Category ca = new Category();

				ca.setMaincate(maincate);
				ca.setCountnum(maincount);

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

	// 중분류를 가져오는 Dao
	public List<Category> midCatePrint() {
		List<Category> list = new ArrayList<Category>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select midcate from category";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String midcate = rs.getString(1);

				Category ca = new Category();

				ca.setMidcate(midcate);

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

	// 전체 분류를 가져오는 Dao
	public List<Category> totalPrint() {
		List<Category> list = new ArrayList<Category>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select maincate, midcate from category";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String maincate = rs.getString(1);
				String midcate = rs.getString(2);
				
				Category ca = new Category();

				ca.setMaincate(maincate);
				ca.setMidcate(midcate);

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

}
