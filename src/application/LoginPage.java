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
 * Class for Log in Authentication
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

	/**
	 * add a new manager
	 */
	Manager manager = new Manager("admin", "123");
	/**
	 * add a new cashier
	 */
	Cashier cashier = new Cashier("cashier", "456");

	/**
	 * Loads the UI
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
	 * Displays salesPage UI when user clicks the salesPage icon
	 * 
	 * 
	 * @param e event
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
	 * Checks if username and password is equal to the values initialized by the
	 * Manager and Cashier object
	 * 
	 * @return boolean if it is the right name and password
	 * @param name name
	 * @param pass password
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
	 * alert on UI page if password and username is empty or not correct
	 *
	 * @param alertType alertype
	 * @param owner owner
	 * @param message message
	 * @param title title
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
