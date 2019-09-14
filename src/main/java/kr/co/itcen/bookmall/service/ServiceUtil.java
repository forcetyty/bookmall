package kr.co.itcen.bookmall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServiceUtil {

	public static Connection getConnection() throws SQLException {
		
		Connection connection = null;

		try {

			// 드라이버 연결
			Class.forName("org.mariadb.jdbc.Driver");

			//학원 192.168.1.81
			String url = "jdbc:mariadb://192.168.0.2:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Fail to Loading Driver:" + e);
			e.printStackTrace();

		}
		return connection;
	}

}
