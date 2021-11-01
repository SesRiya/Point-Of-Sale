package application;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Sales Page
 * 
 * @author crdgo
 *
 */
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
	private TableColumn<Coffee, String> coffeeSizeColumn;
	@FXML
	private TableColumn<Coffee, String> coffeeMilkColumn;
	@FXML
	private TableColumn<Coffee, String> coffeeExtrasColumn;
	@FXML
	private TableColumn<Coffee, Double> coffeePriceColumn;

	@FXML
	private MenuButton coffeeSize;
	@FXML
	private MenuButton coffeeMilk;
	@FXML
	private MenuButton coffeeExtra;
	@FXML
	private Label totalPayment;
	@FXML
	private Label gst;

	ObservableList<Coffee> coffee = FXCollections.observableArrayList();

	/**
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		coffeeIDColumn.setCellValueFactory(new PropertyValueFactory<Coffee, Integer>("coffeeID"));
		coffeeFlavourColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("coffeeFlavour"));
		coffeePriceColumn.setCellValueFactory(new PropertyValueFactory<Coffee, Double>("coffeePrice"));
		coffeeSizeColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("coffeeSize"));
		coffeeMilkColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("coffeeMilk"));
		coffeeExtrasColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("coffeeExtra"));
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

	/**
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(SalesPage.class.getResource("/layout/SalesPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 900, 600));
		primaryStage.show();
		stage = primaryStage;

	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void reportPage(Event e) {
		ReportPage thirdScreen = new ReportPage();
		try {
			thirdScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void homePage(Event e) {

		try {
			Main main2 = new Main();
			main2.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void inventoryPage(Event e) {
		InventoryPage fourthScreen = new InventoryPage();
		try {
			fourthScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addAmericano(Event e) {
		Coffee americano = new Coffee(1, "Americano");
		coffee.add(americano);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addCappuccino(Event e) {
		Coffee cappuccino = new Coffee(2, "Cappuccino");
		coffee.add(cappuccino);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addLatte(Event e) {
		Coffee latte = new Coffee(3, "Latte");
		coffee.add(latte);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addEspresso(Event e) {
		Coffee espresso = new Coffee(4, "Espresso");
		coffee.add(espresso);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addDoubleEspresso(Event e) {
		Coffee doubleEspresso = new Coffee(5, "Double Espresso");
		coffee.add(doubleEspresso);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addEspressoMacchiato(Event e) {
		Coffee espressoMacchiato = new Coffee(6, "Espresso Macchiato");
		coffee.add(espressoMacchiato);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addRistreto(Event e) {
		Coffee espressoRistreto = new Coffee(7, "Espresso Ristreto");
		coffee.add(espressoRistreto);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addLatteMacchiato(Event e) {
		Coffee latteMacchiato = new Coffee(8, "Latte Macchiato");
		coffee.add(latteMacchiato);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addCafeMocha(Event e) {
		Coffee cafeMocha = new Coffee(9, "Cafe Mocha");
		coffee.add(cafeMocha);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addIrishCoffee(Event e) {
		Coffee irishCoffee = new Coffee(10, "Irish Coffee");
		coffee.add(irishCoffee);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void addFrappe(Event e) {
		Coffee frappe = new Coffee(11, "Frappe");
		coffee.add(frappe);
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void small(Event e) {
		Window owner = coffeeSize.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeSize("S");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void medium(Event e) {
		Window owner = coffeeSize.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeSize("M");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void large(Event e) {
		Window owner = coffeeSize.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeSize("L");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void onRegular(Event e) {
		Window owner = coffeeMilk.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeMilk("Regular");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void onSkimmed(Event e) {
		Window owner = coffeeMilk.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeMilk("Skimmed");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void onSoy(Event e) {
		Window owner = coffeeMilk.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeMilk("Soy");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void onAlmond(Event e) {
		Window owner = coffeeMilk.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeMilk("Almond");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void onEspressoShot(Event e) {
		Window owner = coffeeExtra.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeExtra("Espresso");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void onExtraFlavour(Event e) {
		Window owner = coffeeExtra.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeExtra("Flavour");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void onWhippedCream(Event e) {
		Window owner = coffeeExtra.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeExtra("Cream");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void none(Event e) {
		Window owner = coffeeExtra.getScene().getWindow();
		
		if (selectedCoffee != null) {
			selectedCoffee.setCoffeeExtra("None");
			orderTableView.refresh();
		} else {
			showAlert(Alert.AlertType.ERROR, owner, 
					"Please select from table row first", "Form error!");
		}
	}

	/**
	 * 
	 * @param e
	 */
	@FXML
	public void pricePerCoffee(Event e) {
		double priceCoffee = priceCoffeeFlavour() + priceCoffeeMilk() + priceCoffeeSize() + priceCoffeeExtra();
		selectedCoffee.setCoffeePrice(priceCoffee);
		orderTableView.refresh();
	}

	/**
	 * 
	 * @return
	 */
	private double priceCoffeeFlavour() {
		double priceFlavour = 0;
		if (selectedCoffee.getCoffeeFlavour().equals("Cappuccino") || (selectedCoffee.getCoffeeFlavour().equals("Latte")
				|| (selectedCoffee.getCoffeeFlavour().equals("Espresso Macchiato")
						|| (selectedCoffee.getCoffeeFlavour().equals("Americano"))))) {
			priceFlavour = 4.50;
		} else if (selectedCoffee.getCoffeeFlavour().equals("Espresso")
				|| (selectedCoffee.getCoffeeFlavour().equals("Double Espresso")
						|| (selectedCoffee.getCoffeeFlavour().equals("Ristreto")))) {
			priceFlavour = 3.00;
		} else {
			priceFlavour = 5.50;
		}
		return priceFlavour;
	}

	/**
	 * 
	 * @return
	 */
	private double priceCoffeeMilk() {
		double priceMilk = 0;
		if (selectedCoffee.getCoffeeMilk().equals("Regular")) {
			priceMilk = 0.00;
		} else if (selectedCoffee.getCoffeeMilk().equals("Soy") || (selectedCoffee.getCoffeeMilk().equals("Almond"))) {
			priceMilk = 0.50;
		} else {
			priceMilk = 0.20;
		}
		return priceMilk;
	}

	/**
	 * 
	 * @return
	 */
	private double priceCoffeeSize() {
		double priceSize;
		if (selectedCoffee.getCoffeeSize().equals("S")) {
			priceSize = 0.00;
		} else if (selectedCoffee.getCoffeeSize().equals("M")) {
			priceSize = 0.30;
		} else {
			priceSize = 0.50;
		}
		return priceSize;
	}

	/**
	 * 
	 * @return
	 */
	private double priceCoffeeExtra() {
		double priceExtra;
		if (selectedCoffee.getCoffeeExtra().equals("Cream")) {
			priceExtra = 0.80;
		} else if (selectedCoffee.getCoffeeExtra().equals("Espresso")) {
			priceExtra = 0.80;
		} else {
			priceExtra = 0.00;
		}
		return priceExtra;
	}

	/**
	 * 
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void complete(Event e) throws IOException {

		totalPayment.setText(String.valueOf(totalPayment()));
		gst.setText(String.valueOf(gst()));

		File file = new File("sales_data.txt");
		FileWriter wr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(wr);
		for (int i = 0; i < coffee.size(); i++) {
			Coffee cof = coffee.get(i);
			String record = cof.getCoffeeID() + " : " + cof.getCoffeeFlavour() + " : " + cof.getCoffeeSize() + " : "
					+ cof.getCoffeeMilk() + " : " + cof.getCoffeeExtra() + " : " + cof.getCoffeePrice() + "\n";
			br.write(record);
		}
		wr.flush();
		br.close();
		wr.close();

	}

	/**
	 * 
	 * @return
	 */
	private double totalPayment() {
		TableColumn<Coffee, Double> column = coffeePriceColumn; // column you want

		List<Double> columnPriceData = new ArrayList<>();
		for (Coffee item : orderTableView.getItems()) {
			columnPriceData.add(column.getCellObservableValue(item).getValue());
		}
		double totalPrice = 0;
		for (Double coffePrice : columnPriceData) {
			totalPrice += coffePrice;
		}
		return totalPrice;
	}

	/**
	 * 
	 * @return
	 */
	private double gst() {
		double gst = totalPayment() * 0.15;
		return gst;
	}

	public static void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
		Alert alert = new Alert(alertType);
		alert.setContentText(message);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.initOwner(owner);
		alert.show();
	}
}
