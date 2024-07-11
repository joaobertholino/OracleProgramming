package dataAccess;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static Connection conn;
	private static Statement st;

	private DatabaseConnection(){

	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		DatabaseConnection.conn = conn;
	}

	public static Statement getSt() {
		return st;
	}

	public static void setSt(Statement st) {
		DatabaseConnection.st = st;
	}

	public static void inicializeDatabase(String url, String user, String password) throws SQLException {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);

		DatabaseConnection.conn = dataSource.getConnection();
		DatabaseConnection.st = DatabaseConnection.conn.createStatement();
	}
}
