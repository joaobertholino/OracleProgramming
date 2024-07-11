package DatabaseAccess;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection conn;
	private static PreparedStatement pst;

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		DatabaseConnection.conn = conn;
	}

	public static PreparedStatement getPst() {
		return pst;
	}

	public static void setPst(PreparedStatement pst) {
		DatabaseConnection.pst = pst;
	}

	public static void inicializeDatabase(String url, String sql) {
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(url);

			DatabaseConnection.conn = ods.getConnection();
			DatabaseConnection.pst = DatabaseConnection.conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeAllConnections() {
		try {
			if (DatabaseConnection.pst != null) DatabaseConnection.pst.close();
			if (DatabaseConnection.conn != null) DatabaseConnection.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
