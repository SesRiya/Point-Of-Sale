package application;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
 * Sales Page for Coffee Order and Price
 * 
 * @author crdgo
 *
 */
public class SalesPage extends Application implements Initializable {
	private static Stage stage;
	private File fileName;
	private Coffee selectedCoffee;
	private double totalPrice = 0;
	private double gst = 0;

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
	private Label gstLabel;

	private ObservableList<Coffee> coffee = FXCollections.observableArrayList();

	/**
	 * Initializes table columns
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
	 * display UI
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(SalesPage.class.getResource("/layout/SalesPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 900, 600));
		primaryStage.show();
		stage = primaryStage;

	}

	/**
	 * display report Page Ui
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
	 * display homePage UI
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
	 * display inventoryPage UI
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
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addAmericano(Event e) {
		Coffee americano = new Coffee(1, "Americano", "S", "Regular", "None", 4.50);
		coffee.add(americano);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addCappuccino(Event e) {
		Coffee cappuccino = new Coffee(2, "Cappuccino", "S", "Regular", "None", 4.50);
		coffee.add(cappuccino);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addLatte(Event e) {
		Coffee latte = new Coffee(3, "Latte", "S", "Regular", "None", 4.50);
		coffee.add(latte);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addEspresso(Event e) {
		Coffee espresso = new Coffee(4, "Espresso", "S", "Regular", "None", 3.00);
		coffee.add(espresso);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addDoubleEspresso(Event e) {
		Coffee doubleEspresso = new Coffee(5, "Double Espresso", "S", "Regular", "None", 3.00);
		coffee.add(doubleEspresso);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addEspressoMacchiato(Event e) {
		Coffee espressoMacchiato = new Coffee(6, "Espresso Macchiato", "S", "Regular", "None", 5.50);
		coffee.add(espressoMacchiato);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addRistreto(Event e) {
		Coffee espressoRistreto = new Coffee(7, "Espresso Ristreto", "S", "Regular", "None", 3.00);
		coffee.add(espressoRistreto);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addLatteMacchiato(Event e) {
		Coffee latteMacchiato = new Coffee(8, "Latte Macchiato", "S", "Regular", "None", 5.50);
		coffee.add(latteMacchiato);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addCafeMocha(Event e) {
		Coffee cafeMocha = new Coffee(9, "Cafe Mocha", "S", "Regular", "None", 5.50);
		coffee.add(cafeMocha);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addIrishCoffee(Event e) {
		Coffee irishCoffee = new Coffee(10, "Irish Coffee", "S", "Regular", "None", 5.50);
		coffee.add(irishCoffee);
	}

	/**
	 * adds Coffee Object to observable list
	 * 
	 * @param e
	 */
	@FXML
	public void addFrappe(Event e) {
		Coffee frappe = new Coffee(11, "Frappe", "S", "Regular", "None", 5.50);
		coffee.add(frappe);
	}

	/**
	 * menu button to set coffee size
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set coffee size
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set coffee size
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set coffee milk
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set coffee milk
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set coffee milk
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set coffee milk
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set extras on coffee
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set extras on coffee
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set extras on coffee
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * menu button to set extras on coffee
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
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		}
	}

	/**
	 * Calculates price Per coffee cup based on the additional menu
	 * button/parameters clicked or added by the user
	 * 
	 * @param e
	 */
	@FXML
	public void pricePerCoffee(Event e) {
		Window owner = orderTableView.getScene().getWindow();
		if (selectedCoffee == null) {
			showAlert(Alert.AlertType.ERROR, owner, "Please select from table row first", "Form error!");
		} else {
			double priceCoffee = priceCoffeeFlavour(selectedCoffee) + priceCoffeeMilk(selectedCoffee)
					+ priceCoffeeSize(selectedCoffee) + priceCoffeeExtra(selectedCoffee);
			selectedCoffee.setCoffeePrice(priceCoffee);
			orderTableView.refresh();
		}
	}

	/**
	 * Computes and returns price based on user preferred coffee flavour
	 * 
	 * @return
	 */
	public double priceCoffeeFlavour(Coffee selectedCoffee) {
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
	 * Computes and returns price based on user preferred coffee milk
	 * 
	 * @return
	 */
	public double priceCoffeeMilk(Coffee selectedCoffee) {
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
	 * Computes and returns price based on user preferred coffee size
	 * 
	 * @return
	 */
	public double priceCoffeeSize(Coffee selectedCoffee) {
		double priceSize = 0;
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
	 * Computes and returns price based on user preferred extras on coffee
	 * 
	 * @return
	 */
	public double priceCoffeeExtra(Coffee selectedCoffee) {
		double priceExtra = 0;
		if (selectedCoffee.getCoffeeExtra().equals("Cream")) {
			priceExtra = 0.80;
		} else if (selectedCoffee.getCoffeeExtra().equals("Espresso")) {
			priceExtra = 0.80;
		} else if (selectedCoffee.getCoffeeExtra().equals("Flavour")) {
			priceExtra = 0.30;
		} else {
			priceExtra = 0.00;
		}
		return priceExtra;
	}

	/**
	 * Clears tableview and list
	 * 
	 * @return
	 */
	public void cancelOrder() {
		totalPrice = 0;
		totalPayment.setText("");
		gstLabel.setText("");
		coffee.clear();
		orderTableView.getItems().clear();
	}

	/**
	 * Clears tableView and list
	 */
	public void newOrder() {
		totalPrice = 0;
		totalPayment.setText("");
		gstLabel.setText("");
		coffee.clear();
		orderTableView.getItems().clear();
	}

	/**
	 * Computes total Price for all the coffees in the list
	 * 
	 * @param coffee
	 * @return
	 */
	public double totalPrice(ObservableList<Coffee> coffee) {
		totalPrice = 0;
		for (Coffee coffeePrice : coffee) {
			totalPrice += coffeePrice.getCoffeePrice();
		}
		return totalPrice;
	}

	/**
	 * button for computing total price on the UI
	 * 
	 * @param e
	 */
	@FXML
	public void totalPriceButton(Event e) {
		totalPrice(coffee);
		totalPayment.setText(String.valueOf(totalPrice));
		gstLabel.setText(String.valueOf(gst(totalPrice)));
	}

	/**
	 * Gst computation based on the totalPrice
	 * 
	 * @return
	 */
	public double gst(double totalPrice) {
		gst = totalPrice * 0.15;
		return gst;
	}

	/**
	 * button to save/write the file to a text file
	 * 
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void complete(Event e) throws IOException {
		Window owner = orderTableView.getScene().getWindow();
		saveDataToFile("sales_data.txt", coffee);
		showAlert(Alert.AlertType.INFORMATION, owner, "Transaction Complete", "Thank You!");
	}

	/**
	 * method to save data to a file
	 * 
	 * @param fileName
	 * @param coffee
	 * @throws IOException
	 */
	public void saveDataToFile(String fileName, ObservableList<Coffee> coffee) throws IOException {
		FileWriter wr = new FileWriter(fileName, true);
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
	 * UI alert
	 * 
	 * @param alertType
	 * @param owner
	 * @param message
	 * @param title
	 */
	public void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
		Alert alert = new Alert(alertType);
		alert.setContentText(message);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.initOwner(owner);
		alert.show();
	}

	/**
	 * setter for selected coffee
	 * 
	 * @param selectedCoffee
	 */
	public void setSelectedCoffee(Coffee selectedCoffee) {
		this.selectedCoffee = selectedCoffee;
	}

}
