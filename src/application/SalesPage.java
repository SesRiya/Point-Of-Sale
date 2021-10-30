package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SalesPage extends Application{
	private static Stage stage;
	
	@FXML private TextArea orderList;
	private List<String> coffeeOrder = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(SalesPage.class.getResource("/layout/SalesPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
		stage = primaryStage;
		
	}
	
	@FXML
	public void reportPage(Event e){
        ReportPage thirdScreen = new ReportPage();
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
	
	@FXML
	public void inventoryPage(Event e){
        InventoryPage fourthScreen = new InventoryPage();
        try {
			fourthScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
	
	@FXML
	public void addAmericano(Event e) {
		orderList.appendText("Americano" + "\n");
		coffeeOrder.add("Americano");
	}
	
	@FXML
	public void addCappuccino(Event e) {
		orderList.appendText("Cappuccino" + "\n");
	}
	
	@FXML
	public void addLatte(Event e) {
		orderList.appendText("Latte" + "\n");
	}
	
	@FXML
	public void addEspresso(Event e) {
		orderList.appendText("Espresso" + "\n");
	}
	
	@FXML
	public void addDoubleEspresso(Event e) {
		orderList.appendText("Double Espresso" + "\n");
	}
	
	@FXML
	public void addEspressoMacchiato(Event e) {
		orderList.appendText("Espresso Macchiato" + "\n");
	}
	
	@FXML
	public void addRistreto(Event e) {
		orderList.appendText("Ristretp" + "\n");
	}
	
	@FXML
	public void addLatteMacchiato(Event e) {
		orderList.appendText("Latte Macchiato" + "\n");
	}

	@FXML
	public void addCafeMocha(Event e) {
		orderList.appendText("Cafe Mocha" + "\n");
	}
	
	@FXML
	public void addIrishCoffee(Event e) {
		orderList.appendText("Irish Coffee" + "\n");
	}
	
	@FXML
	public void addFrappe(Event e) {
		orderList.appendText("Frappe" + "\n");
	}


	







}
