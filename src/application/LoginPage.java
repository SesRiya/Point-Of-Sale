package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPage extends Application {
	private static Stage stage;
	
	
	@FXML private TextField userName;
	@FXML private TextField password;


	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("LoginPage.fxml"));
			primaryStage.setTitle("Java Expresso");
			primaryStage.setScene(new Scene(root, 600, 500));
			primaryStage.show();
			stage = primaryStage;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void loginDetails() {
		
	}

	@FXML
	public void salesPage(Event e) {
		String name = userName.getText().toString();
		String pass = password.getText().toString();

		if ((name.equals("admin") && pass.equals("123")) || (name.equals("cashier") && (pass.equals("456")))) {
			System.out.print("clicked");
			SalesPage secondScreen = new SalesPage();
			try {
				secondScreen.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
