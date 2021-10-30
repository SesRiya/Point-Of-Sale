package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SalesController implements Initializable {
	private static Stage stage;

	private List<String> coffeeOrder = new ArrayList<>();
	@FXML
	private TextArea orderList;
	@FXML
	MenuButton coffeeSize;
	@FXML
	MenuButton coffeeExtras;
	@FXML
	MenuButton coffeeMilk;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// create MenuItem
		MenuItem s1 = new MenuItem("Small");
		MenuItem s2 = new MenuItem("Medium");
		MenuItem s3 = new MenuItem("Large");

		coffeeSize.getItems().addAll(s1, s2, s3);

		MenuItem c1 = new MenuItem("Espresso Shot");
		MenuItem c2 = new MenuItem("Flavours Shot");
		MenuItem c3 = new MenuItem("Whipped Cream");

		coffeeExtras.getItems().addAll(c1, c2, c3);

		MenuItem m1 = new MenuItem("Milk");
		MenuItem m2 = new MenuItem("Skimmed Milk");
		MenuItem m3 = new MenuItem("LowFat Milk");
		MenuItem m4 = new MenuItem("Soy Milk");
		MenuItem m5 = new MenuItem("Almond Milk");
		MenuItem m6 = new MenuItem("Oat Milk");

		coffeeMilk.getItems().addAll(m1, m2, m3, m4, m5, m6);
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
