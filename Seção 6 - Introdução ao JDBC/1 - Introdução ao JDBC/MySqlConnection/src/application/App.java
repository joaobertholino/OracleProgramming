package application;

import dataAccess.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:<driverType>://localhost:5698/<DatabaseSID>";
		String user = "<username>";
		String password = "<password>";

		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			DatabaseConnection.inicializeDatabase(url, user, password);
			st = DatabaseConnection.getSt();
			rs = st.executeQuery("SELECT employee_id, first_name, salary FROM Employees;");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getDouble(3));
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println(e.getClass() + " - " + e.getMessage());
		} finally {
			try {
				if (st != null) st.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				System.err.println(e.getClass() + " - " + e.getMessage());
			}
		}
	}
}
