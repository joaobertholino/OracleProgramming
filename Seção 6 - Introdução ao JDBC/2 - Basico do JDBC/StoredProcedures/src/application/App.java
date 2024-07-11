package application;

import databaseAccess.DatabaseConnection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class App extends Application {
	private TextField textField = new TextField();
	private Label labelResult = new Label();

	public static void main(String[] args) {
		launch(args);
		DatabaseConnection.closeAllConnections();
	}

	private void showResult() {
		this.labelResult.setText("");
		try {
			int employeeId = Integer.parseInt(this.textField.getText());
			DatabaseConnection.getCs().setInt(1, employeeId);
			DatabaseConnection.getCs().registerOutParameter(2, Types.DOUBLE);
			DatabaseConnection.getCs().registerOutParameter(3, Types.VARCHAR);
			DatabaseConnection.getCs().execute();

			BigDecimal salary = DatabaseConnection.getCs().getBigDecimal(2);
			String lastName = DatabaseConnection.getCs().getString(3);

			this.labelResult.setText("Last name: " + lastName + "\nSalary: " + salary);
		} catch (SQLException | NumberFormatException e) {
			labelResult.setText("Wrong employee ID! Please try again.");
		}
	}

	private void displayDatabaseDetails() {
		try {
			DatabaseMetaData dmd = DatabaseConnection.getConn().getMetaData();

			System.out.println("Database Version: " + dmd.getDatabaseProductVersion());
			System.out.println("Driver Name: " + dmd.getDriverName());
			System.out.println("URL: " + dmd.getURL());
			System.out.println("UserName: " + dmd.getUserName());

			ResultSet rs = dmd.getTables(null, null, "EMP%", new String[]{"TABLE"});
			while(rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		String query = "{call getEmployeeSalary(?, ?, ?)}";
		String user = "<user>";
		String password = "<password>";
		String url = "jdbc:oracle:thin:" + user + "/" + password + "@localhost:1521/xe";
		DatabaseConnection.inicializeDatabase(url, query);
		displayDatabaseDetails();

		try {
			Button btnShowId = new Button("Show employee salary from procedure");
			HBox hBox = new HBox(5);
			hBox.getChildren().addAll(new Label("Employee ID"), this.textField, btnShowId);

			VBox vBox = new VBox(10);
			vBox.getChildren().addAll(hBox, this.labelResult);

			this.textField.setPrefColumnCount(6);
			btnShowId.setOnAction(e -> showResult());

			Scene scene = new Scene(vBox, 400, 100);
			stage.setTitle("Show Employee Salary");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}