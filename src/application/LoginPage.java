package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * 
 * @author crdgo
 *
 */
public class LoginPage extends Application {
	private static Stage stage;

	@FXML
	private TextField userName;
	@FXML
	private TextField password;

	Manager manager = new Manager("admin", "123");
	Cashier cashier = new Cashier("cashier", "456");

	/**
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			Parent root = FXMLLoader.load(Main.class.getResource("/layout/LoginPage.fxml"));
			primaryStage.setTitle("Java Expresso");
			primaryStage.setScene(new Scene(root, 900, 600));
			primaryStage.show();
			stage = primaryStage;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void salesPage(Event e) {

		Window owner = userName.getScene().getWindow();

		String name = userName.getText().toString();
		String pass = password.getText().toString();
		if (loginAuthentication(name, pass)) {
			SalesPage secondScreen = new SalesPage();
			try {
				secondScreen.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			showAlert(Alert.AlertType.ERROR, owner, "Please enter a valid  " + "username &password", "Form error!");
		}
	}

	/**
	 * 
	 * @return
	 */
	public boolean loginAuthentication(String name, String pass) {

		if ((name.equals(manager.getUserName()) && pass.equals(manager.getPassword()))
				|| (name.equals(cashier.getUserName()) && (pass.equals(cashier.getPassword())))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param alertType
	 * @param owner
	 * @param message
	 * @param title
	 */
	public void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
		Alert alert = new Alert(alertType);
		alert.setContentText(message);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.initOwner(owner);
		alert.show();
	}

}
