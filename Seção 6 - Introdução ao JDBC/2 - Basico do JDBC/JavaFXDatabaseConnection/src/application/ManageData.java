package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.sql.*;

public class ManageData extends Application {
	private Connection conn;
	private PreparedStatement prst;

	private ResultSet rset;
	private TextField tfid = new TextField();
	private TextField tfSalary = new TextField();
	private Label lblResult = new Label();
	private Label lblSalary;
	private Button btModSalary;

	public static void main(String[] args) {
		launch(args);
	}

	public void initializeDatabase() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:4557/<dbName>";
		String user = "<dbUser>";
		String password = "<dbPassword>";
		String query = "SELECT email, first_name, last_name, salary FROM Employees where employee_id = ?";

		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, user, password);
			this.prst = this.conn.prepareStatement(query);
		} catch (Exception e) {
			System.err.println(e.getClass() + " - " + e.getMessage());
		}
	}

	@Override
	public void start(Stage primaryStage) {
		initializeDatabase();

		try {
			Button btShowID = new Button("Show Employee Details");
			btShowID.setOnAction(e -> showResult());
			Button btClearInfo = new Button("Clear");
			btClearInfo.setOnAction(e -> clear());
			btModSalary = new Button("Update Salary");
			btModSalary.setOnAction(e -> updateSalary());
			lblSalary = new Label("New Salary");
			updateVisibility(false);

			HBox hBox = new HBox(5);
			hBox.getChildren().addAll(new Label(" Employee ID:"), tfid, btShowID, btClearInfo);
			HBox hBox2 = new HBox(5);
			hBox2.getChildren().addAll(lblSalary, tfSalary, btModSalary);

			VBox vBox = new VBox(10);
			vBox.getChildren().addAll(hBox, lblResult, hBox2);

			tfid.setPrefColumnCount(6);
			tfSalary.setPrefColumnCount(6);

			Scene scene = new Scene(vBox, 400, 100);
			primaryStage.setTitle("Show Employee Details");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateSalary() {
		try {
			int id = Integer.parseInt(this.tfid.getText());
			int salary = Integer.parseInt(this.tfSalary.getText());
			PreparedStatement prepst = this.conn.prepareStatement("UPDATE employees SET salary = ? WHERE employee_id = ?");
			prepst.setInt(1, salary);
			prepst.setInt(2, id);
			prepst.execute();
			prepst.close();
		} catch (NumberFormatException e) {
			displayError("Input Error", "Incorrect value entered");
		} catch (SQLIntegrityConstraintViolationException e) {
			displayError("Salary Error", "Negative value for salary entered");
			this.tfSalary.setText("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateVisibility(boolean val) {
		this.lblSalary.setVisible(val);
		this.tfSalary.setVisible(val);
		this.btModSalary.setVisible(val);
		this.lblResult.setVisible(val);
	}

	private void clear() {
		updateVisibility(false);
		this.tfSalary.setText("");
		this.tfid.setText("");
	}

	private void showResult() {
		String employeeID = this.tfid.getText();
		try {
			this.prst.setBigDecimal(1, new BigDecimal(employeeID));
			this.rset = prst.executeQuery();
			if (this.rset.next()) {
				String email = this.rset.getString(1);
				String firstName = this.rset.getString(2);
				String lastName = this.rset.getString(3);
				int empSalary = this.rset.getInt(4);
				this.lblResult.setText(" Employee name is " + firstName + " " + lastName + ", email is " + email + ", salary: $" + empSalary);
				updateVisibility(true);
			} else {
				this.lblResult.setText("Try again !No Employee information for the ID " + employeeID);
				this.lblResult.setVisible(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			displayError("ID Error", "No value entered for Employee ID");
		}
	}

	private void displayError(String title, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
