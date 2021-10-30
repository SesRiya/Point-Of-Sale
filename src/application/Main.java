package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.Event;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("MainLayout.fxml"));
			primaryStage.setTitle("Java Expresso");
			primaryStage.setScene(new Scene(root, 800, 600));
			primaryStage.show();
			stage = primaryStage;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void loginPage(Event e){
        LoginPage loginPage = new LoginPage();
        try {
        	loginPage.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }


	@FXML
	public void buttonClicked(Event e){
        System.out.println(add(5,10));
    }
	
	
	public int add(int i, int j) {
		return i + j;
	}
	
	public int add2(int i, int j) {
		return i + j;
	}
	
	
	public static void main(String[] args) {
		System.out.println("test");
		launch(args);
	}
}
