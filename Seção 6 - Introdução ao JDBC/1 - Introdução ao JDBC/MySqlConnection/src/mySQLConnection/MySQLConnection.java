package mySQLConnection;

import java.sql.*;

public class MySQLConnection {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:<DBType>://localhost:8794/<DBName>";
		String user = "<DBUser>";
		String password = "<DBPassword>";

		try {
			Class.forName(driver);
			String query = "SELECT * FROM employees INNER JOIN departments ON employees.department_id = departments.department_id;";

			try (Connection con = DriverManager.getConnection(url, user, password);
					 Statement st = con.createStatement();
					 ResultSet rs = st.executeQuery(query)) {
				int colNum = getColumnNames(rs);
				if (colNum > 0) {
					while (rs.next()) {
						for (int i = 1; i <= colNum; i++) {
							if (i == colNum) {
								System.out.println(rs.getString(i));
							} else {
								System.out.print(rs.getString(i) + ", ");
							}
						}
					}
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage() + " - " + e.getClass());
			}
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage() + " - " + e.getClass());
		}
	}

	public static int getColumnNames(ResultSet rs) throws SQLException {
		int numberOfColumns = 0;
		if (rs != null) {
			ResultSetMetaData rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			for (int i = 1; i <= numberOfColumns; i++) {
				String columnName = rsMetaData.getColumnName(i);
				System.out.print(columnName + ", ");
			}
		}
		System.out.println();
		return numberOfColumns;
	}
}
