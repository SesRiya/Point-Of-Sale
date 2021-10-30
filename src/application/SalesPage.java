package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SalesPage extends Application{
	private static Stage stage;

	private List<Coffee> coffeeTypes = new ArrayList<>();
	@FXML
	private TableView<Coffee> order = new TableView<Coffee>();
	
	Coffee coffee = new Coffee();
	
	TableColumn<Coffee, Integer>column1 = new TableColumn<>("ID");

	TableColumn<Coffee, String>column2 = new TableColumn<>("Coffe Flavour");
	TableColumn<Coffee, Double>column3 = new TableColumn<>("Price");
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		createCoffee();
		Parent root = FXMLLoader.load(SalesPage.class.getResource("/layout/SalesPageLayout.fxml"));		
		
				
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();	
		stage = primaryStage;
	}
	
	private void createCoffee() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("Coffee.txt"));
			while (scan.hasNext()) {
				int ID = scan.nextInt();
				String coffeeFlavour = scan.next();
				String coffeeSize = scan.next();
				double coffeePrice = scan.nextDouble();
				scan.nextLine();
				coffeeTypes.add(new Coffee(ID, coffeeFlavour, coffeeSize, coffeePrice));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		if (scan != null) {
			scan.close();
		}
	}

	@FXML
	public void reportPage(Event e) {
		ReportPage thirdScreen = new ReportPage();
		try {
			thirdScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void homePage(Event e) {

		try {
			Main main2 = new Main();
			main2.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void inventoryPage(Event e) {
		InventoryPage fourthScreen = new InventoryPage();
		try {
			fourthScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	
	@FXML
	public void addAmericano(Event e) {
		order.getItems().add(new Coffee(1, "Americano", 4.50));
		
	}

	@FXML
	public void addCappuccino(Event e) {
		coffee.setCoffeeFlavour("Cappuccino");
		coffee.setCoffeeID(2);
	}

	@FXML
	public void addLatte(Event e) {
		coffee.setCoffeeFlavour("Latte");
		coffee.setCoffeeID(3);
	}

	@FXML
	public void addEspresso(Event e) {
		coffee.setCoffeeFlavour("Espresso");
		coffee.setCoffeeID(4);
	}

	@FXML
	public void addDoubleEspresso(Event e) {
		coffee.setCoffeeFlavour("Espresso");
		coffee.setCoffeeID(5);
	}

	@FXML
	public void addEspressoMacchiato(Event e) {
		coffee.setCoffeeFlavour("EspressoMacchiato");
		coffee.setCoffeeID(6);
	}

	@FXML
	public void addRistreto(Event e) {
		coffee.setCoffeeFlavour("Ristreto");
		coffee.setCoffeeID(7);
	}

	@FXML
	public void addLatteMacchiato(Event e) {
		coffee.setCoffeeFlavour("LatteMacchiato");
		coffee.setCoffeeID(8);
	}

	@FXML
	public void addCafeMocha(Event e) {
		coffee.setCoffeeFlavour("CafeMocha");
		coffee.setCoffeeID(9);
	}

	@FXML
	public void addIrishCoffee(Event e) {
		coffee.setCoffeeFlavour("IrishCoffee");
		coffee.setCoffeeID(10);
	}

	@FXML
	public void addFrappe(Event e) {
		coffee.setCoffeeFlavour("Frappe");
		coffee.setCoffeeID(11);
	}

	@FXML
	public void small(Event e) {
		coffee.setCoffeeSize("small");
	}
	
	@FXML
	public void medium(Event e) {
		coffee.setCoffeeSize("medium");
	}
	
	@FXML
	public void large(Event e) {
		coffee.setCoffeeSize("large");
	}

}
