package databaseAccess;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection conn;
	private static CallableStatement cs;

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		DatabaseConnection.conn = conn;
	}

	public static CallableStatement getCs() {
		return cs;
	}

	public static void setCs(CallableStatement cs) {
		DatabaseConnection.cs = cs;
	}

	public static void inicializeDatabase(String url, String query) {
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(url);

			DatabaseConnection.conn = ods.getConnection();
			DatabaseConnection.cs = DatabaseConnection.conn.prepareCall(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeAllConnections() {
		try {
			if (DatabaseConnection.cs != null) DatabaseConnection.cs.close();
			if (DatabaseConnection.conn != null) DatabaseConnection.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
