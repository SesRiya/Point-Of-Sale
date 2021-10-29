package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FourthScreen extends Application{
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(FourthScreen.class.getResource("ThirdLayout.fxml"));
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
		stage = primaryStage;
		
	}
	
	public void salesPage(Event e){
        SecondScreen secondScreen = new SecondScreen();
        try {
			secondScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
	
	@FXML
	public void reportPage(Event e){
        ThirdScreen thirdScreen = new ThirdScreen();
        try {
			thirdScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
	
	@FXML
	public void homePage(Event e){      
        try {
			Main main2 = new Main();
			main2.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }


}
