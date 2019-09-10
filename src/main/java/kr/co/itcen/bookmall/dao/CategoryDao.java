package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.Category;

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

}
