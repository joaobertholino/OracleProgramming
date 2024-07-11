package application;

import databaseAccess.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String user = "<user>";
		String password = "<password>";

		System.out.print("Insira o codigo SQL para consulta: ");
		String query = in.nextLine();

		DatabaseConnection.inicializeDatabase("jdbc:oracle:thin:" + user + "/" + password + "@localhost:1521:xe");
		try (ResultSet rs = DatabaseConnection.getSt().executeQuery(query)) {
			int colNum = getAmountColumn(rs);
			if (colNum > 0) {
				while (rs.next()) {
					for (int i = 1; i <= colNum; i++) {
						if (i != colNum) {
							System.out.print(rs.getString(i) + " - ");
						} else {
							System.out.println(rs.getString(i));
						}
					}
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getClass() + " - " + e.getMessage());
		} finally {
			DatabaseConnection.closeConnections();
		}
	}

	public static int getAmountColumn(ResultSet rs) throws SQLException {
		int numberOfColumns = 0;
		if (rs != null) {
			ResultSetMetaData rsmd = rs.getMetaData();
			numberOfColumns = rsmd.getColumnCount();

			for (int i = 1; i <= numberOfColumns; i++) {
				String columnName = rsmd.getColumnName(i);
				if (i != numberOfColumns) {
					System.out.print(columnName + " - ");
				} else {
					System.out.print(columnName);
				}
			}
		}
		System.out.println();
		return numberOfColumns;
	}
}