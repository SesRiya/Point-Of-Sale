package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.Event;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * Main method
 * @author liuziyu
 *
 */
public class Main extends Application {
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("/layout/MainLayout.fxml"));
			primaryStage.setTitle(" Java Espresso");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("coffeeBeanWindowIcon.png")));
			primaryStage.setScene(new Scene(root, 900, 600));
			primaryStage.show();
			primaryStage.setResizable(false);
			stage = primaryStage;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Displays loginPage UI when user clicks the Login button
	 * 
	 * @param e event
	 */
	@FXML
	public void loginPage(Event e) {
		LoginPage loginPage = new LoginPage();
		try {
			loginPage.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Main method
	 * @param args args
	 */
	public static void main(String[] args) {
		System.out.println("test");
		launch(args);
	}
}
