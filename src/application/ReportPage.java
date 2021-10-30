package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReportPage extends Application{
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(ReportPage.class.getResource("InventoryPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
		stage = primaryStage;
		
	}
	
	public void salesPage(Event e){
        SalesPage secondScreen = new SalesPage();
        try {
			secondScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
	
	@FXML
	public void reportPage(Event e){
        InventoryPage thirdScreen = new InventoryPage();
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
