package application;

import DatabaseAccess.DatabaseConnection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class App extends Application {
	private ResultSet rs;
	private TextField textFieldId = new TextField();
	private TextField textFieldSalary = new TextField();
	private Label labelResult = new Label();
	private Label labelSalary;
	private Button btnUpdateSalary;

	public static void main(String[] args) {
		launch(args);
		DatabaseConnection.closeAllConnections();
	}

	private void showResult() {
		String employeeId = this.textFieldId.getText();
		try {
			DatabaseConnection.getPst().setBigDecimal(1, new BigDecimal(employeeId));
			this.rs = DatabaseConnection.getPst().executeQuery();

			if (this.rs.next()) {
				String email = this.rs.getString(1);
				String firstName = this.rs.getString(2);
				String lastName = this.rs.getString(3);
				double salary = this.rs.getDouble(4);
				this.labelResult.setText("Employee name: " + firstName + " " + lastName + ".\nEmail: " + email + "\nSalary: " + salary);
				updateVisibility(true);
			} else {
				this.labelResult.setText("Try again! No employee information for the ID: " + employeeId);
				this.labelResult.setVisible(true);
			}
		} catch (NumberFormatException e) {
			displayError("ID Error", "No value entered for employee ID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void displayError(String windowTitle, String messageError) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(windowTitle);
		alert.setHeaderText(null);
		alert.setContentText(messageError);
		alert.showAndWait();
	}

	private void clear() {
		updateVisibility(false);
		this.textFieldId.setText("");
		this.textFieldSalary.setText("");
	}

	private void updateVisibility(boolean value) {
		this.labelSalary.setVisible(value);
		this.textFieldSalary.setVisible(value);
		this.btnUpdateSalary.setVisible(value);
		this.labelResult.setVisible(value);
	}

	private void updateSalary() {
		try {
			String query = "UPDATE employees SET salary = ? WHERE employee_id = ?";
			int employeeId = Integer.parseInt(this.textFieldId.getText());
			double salary = Double.parseDouble(this.textFieldSalary.getText());

			PreparedStatement pst = DatabaseConnection.getConn().prepareStatement(query);
			pst.setBigDecimal(1, BigDecimal.valueOf(salary));
			pst.setInt(2, employeeId);

			pst.executeUpdate();
			pst.close();
		} catch (NumberFormatException e) {
			displayError("Input Error", "Incorrect value entered");
		} catch (SQLIntegrityConstraintViolationException e) {
			displayError("Salary Error", "Negative value for salary entered");
			this.textFieldSalary.setText("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		String user = "<user>";
		String password = "<password>";
		String url = "jdbc:oracle:thin:" + user + "/" + password + "@localhost:1521:xe";
		String query = "SELECT email, first_name, last_name, salary FROM employees WHERE employee_id = ?";
		DatabaseConnection.inicializeDatabase(url, query);

		try {
			Button btnShowID = new Button("Show Employee Details");
			btnShowID.setOnAction(e -> showResult());

			Button btnClearInfo = new Button("Clear");
			btnClearInfo.setOnAction(e -> clear());

			this.btnUpdateSalary = new Button("Update salary");
			this.btnUpdateSalary.setOnAction(e -> updateSalary());
			this.labelSalary = new Label("New salary");
			updateVisibility(false);

			HBox hBoxOne = new HBox(5);
			hBoxOne.getChildren().addAll(new Label("Employee ID"), this.textFieldId, btnShowID, btnClearInfo);

			HBox hBoxTwo = new HBox(5);
			hBoxTwo.getChildren().addAll(this.labelSalary, this.textFieldSalary, this.btnUpdateSalary);

			VBox vBox = new VBox(10);
			vBox.getChildren().addAll(hBoxOne, this.labelResult, hBoxTwo);
			this.textFieldId.setPrefColumnCount(6);
			this.textFieldSalary.setPrefColumnCount(this.textFieldId.getPrefColumnCount());
			Scene scene = new Scene(vBox, 400, 400);

			stage.setTitle("Show employee ID");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}