package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SalesPage extends Application implements Initializable {
	private static Stage stage;
	private Coffee selectedCoffee;

	@FXML
	private TableView<Coffee> orderTableView;
	@FXML
	private TableColumn<Coffee, Integer> coffeeIDColumn;
	@FXML
	private TableColumn<Coffee, String> coffeeFlavourColumn;
	@FXML
	private TableColumn<Coffee, Double> coffeePriceColumn;
	@FXML
	private TableColumn<Coffee, String> coffeeSizeColumn;
	@FXML
	private MenuButton coffeeSize;

	ObservableList<Coffee> coffee = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		coffeeIDColumn.setCellValueFactory(new PropertyValueFactory<Coffee, Integer>("coffeeID"));
		coffeeFlavourColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("coffeeFlavour"));
		coffeePriceColumn.setCellValueFactory(new PropertyValueFactory<Coffee, Double>("coffeePrice"));
		coffeeSizeColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("coffeeSize"));
		orderTableView.setItems(coffee);

		orderTableView.setRowFactory(tv -> {
			TableRow<Coffee> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty()) {
					selectedCoffee = row.getItem();
				}
			});
			return row;
		});

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(SalesPage.class.getResource("/layout/SalesPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
		stage = primaryStage;

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
		Coffee americano = new Coffee(1, "Americano", 4.50);
		coffee.add(americano);
	}

	@FXML
	public void addCappuccino(Event e) {
		Coffee cappuccino = new Coffee(2, "Cappuccino", 4.50);
		coffee.add(cappuccino);
	}

	@FXML
	public void addLatte(Event e) {
		Coffee latte = new Coffee(3, "Latte", 4.50);
		coffee.add(latte);
	}

	@FXML
	public void addEspresso(Event e) {
		Coffee espresso = new Coffee(4, "Espresso", 4.50);
		coffee.add(espresso);
	}

	@FXML
	public void addDoubleEspresso(Event e) {
		Coffee doubleEspresso = new Coffee(5, "Double Espresso", 4.50);
		coffee.add(doubleEspresso);
	}

	@FXML
	public void addEspressoMacchiato(Event e) {
		Coffee espressoMacchiato = new Coffee(6, "Espresso Macchiato", 4.50);
		coffee.add(espressoMacchiato);
	}

	@FXML
	public void addRistreto(Event e) {
		Coffee espressoRistreto = new Coffee(7, "Espresso Ristreto", 4.50);
		coffee.add(espressoRistreto);
	}

	@FXML
	public void addLatteMacchiato(Event e) {
		Coffee latteMacchiato = new Coffee(8, "Latte Macchiato", 4.50);
		coffee.add(latteMacchiato);
	}

	@FXML
	public void addCafeMocha(Event e) {
		Coffee cafeMocha = new Coffee(9, "Cafe Mocha", 4.50);
		coffee.add(cafeMocha);
	}

	@FXML
	public void addIrishCoffee(Event e) {
		Coffee irishCoffee = new Coffee(10, "Irish Coffee", 4.50);
		coffee.add(irishCoffee);
	}

	@FXML
	public void addFrappe(Event e) {
		Coffee frappe = new Coffee(11, "Frappe", 4.50);
		coffee.add(frappe);
	}

	@FXML
	public void small(Event e) {
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeSize("Small");
			orderTableView.refresh();
		} else {
			System.out.println("Please select a coffee first.");
		}
	}

	@FXML
	public void medium(Event e) {

	}

	@FXML
	public void large(Event e) {

	}

}
