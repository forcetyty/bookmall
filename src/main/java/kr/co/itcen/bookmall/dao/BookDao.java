package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.service.ServiceUtil;
import kr.co.itcen.bookmall.vo.Book;

/*
 * isbm - String - 책 고유 식별번호
 * name - String - 책 이름
 * price - int   - 책 가격
 * maincate - String - 대분류 - 외래키
 * midcate - String  - 중분류 - 외래키
 * 
 */
public class BookDao {

	// Book list All print Method
	public List<Book> bookPrintDao() {
		List<Book> list = new ArrayList<Book>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select isbn, name, price, maincate, midcate  from book order by isbn";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String isbn = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				String maincate = rs.getString(4);
				String midcate = rs.getString(5);

				Book ba = new Book();

				ba.setIsbn(isbn);
				ba.setName(name);
				ba.setPrice(Integer.parseInt(price));
				ba.setMaincate(maincate);
				ba.setMidcate(midcate);

				list.add(ba);
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

	// Category 별 책 수량 확인 출력 Dao
	public List<Book> bookCatePrintDao() {
		List<Book> list = new ArrayList<Book>();

		Connection con = null; // 연결객체
		PreparedStatement pstmt = null; // 운반객체
		ResultSet rs = null; // 결과

		try {
			con = ServiceUtil.getConnection();
			String sql = "select maincate, count(name), midcate  from book group by midcate order by maincate;";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String maincate = rs.getString(1);
				String count = rs.getString(2);
				String midcate = rs.getString(3);

				Book ba = new Book();

				ba.setMaincate(maincate);
				ba.setCount(count);
				ba.setMidcate(midcate);

				list.add(ba);
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
