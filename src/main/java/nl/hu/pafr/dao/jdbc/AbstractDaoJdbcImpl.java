package nl.hu.pafr.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDaoJdbcImpl {
	private static final String MYSQL_DB_DRIV = "com.mysql.jdbc.Driver";
	private static final String MYSQL_DB_CONN = "jdbc:mysql://localhost/pafr";
	private static final String MYSQL_DB_USER = "root";
	private static final String MYSQL_DB_PASS = "";

	public Connection open() {
		try {
			Class.forName(MYSQL_DB_DRIV).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection(MYSQL_DB_CONN, MYSQL_DB_USER, MYSQL_DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
