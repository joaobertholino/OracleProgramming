package databaseAccess;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static Connection conn;
	private static Statement st;

	public static Connection getConn() {
		return DatabaseConnection.conn;
	}

	public static void setConn(Connection conn) {
		DatabaseConnection.conn = conn;
	}

	public static Statement getSt() {
		return DatabaseConnection.st;
	}

	public static void setSt(Statement st) {
		DatabaseConnection.st = st;
	}

	public static void inicializeDatabase(String url) {
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(url);

			DatabaseConnection.conn = ods.getConnection();
			DatabaseConnection.st = DatabaseConnection.conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnections() {
		try {
			if (DatabaseConnection.st != null) DatabaseConnection.st.close();
			if (DatabaseConnection.conn != null) DatabaseConnection.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
