package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Class for the items listed in the Inventory Page
 * 
 * @param coffeeFlavourList
 * @param coffeeMilkExtraList
 * @param coffeeSizeList
 * @param coffeeExtraList
 *
 * @author POS Group
 *
 */
public class InventoryPage extends Application implements Initializable {
	private static Stage stage;

	private List<String> coffeeFlavourList = new ArrayList<>();
	private List<String> coffeeMilkList = new ArrayList<>();
	private List<String> coffeeExtraList = new ArrayList<>();
	private List<String> coffeeSizeList = new ArrayList<>();

	private InventoryContent coffeeBeans;
	private InventoryContent milkRegular;
	private InventoryContent whippedCream;
	private InventoryContent flavour;
	private int creamUsed;
	private double regularMilkUsed;
	private int numberOfCups;
	private int flavourUsed;

	@FXML
	private TableView<InventoryContent> tableInventory;
	@FXML
	private TableColumn<InventoryContent, Integer> idItemColumn;
	@FXML
	private TableColumn<InventoryContent, String> itemNameColumn;
	@FXML
	private TableColumn<InventoryContent, Double> priceItemColumn;
	@FXML
	private TableColumn<InventoryContent, Double> purchasedQuantityColumn;
	@FXML
	private TableColumn<InventoryContent, Double> usedQuantityColumn;
	@FXML
	private TableColumn<InventoryContent, Double> quantityLeftColumn;

	ObservableList<InventoryContent> listIngredients = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadSalesData("sales_data.txt");
		inventoryList();
		updateCoffeeBeans(numberOfCups);
		updateCream(creamUsed);
		updateFlavour(flavourUsed);
		updateRegularMilk(regularMilkUsed);
		idItemColumn.setCellValueFactory(new PropertyValueFactory<InventoryContent, Integer>("itemID"));
		itemNameColumn.setCellValueFactory(new PropertyValueFactory<InventoryContent, String>("itemName"));
		priceItemColumn.setCellValueFactory(new PropertyValueFactory<InventoryContent, Double>("priceItem"));
		purchasedQuantityColumn
				.setCellValueFactory(new PropertyValueFactory<InventoryContent, Double>("purchasedQuantity"));
		usedQuantityColumn.setCellValueFactory(new PropertyValueFactory<InventoryContent, Double>("usedQuantity"));
		quantityLeftColumn.setCellValueFactory(new PropertyValueFactory<InventoryContent, Double>("quantityLeft"));
		tableInventory.setItems(listIngredients);
		// add your data here from any source

		tableInventory.setRowFactory(tv -> {
			TableRow<InventoryContent> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty()) {
					row.getItem();
				}
			});
			return row;
		});

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(InventoryPage.class.getResource("/layout/InventoryPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 900, 600));
		primaryStage.show();
		stage = primaryStage;
	}

	/**
	 * Displays salesPage UI when user clicks the salesPage icon
	 * 
	 * @param e
	 */
	@FXML
	public void salesPage(Event e) {
		SalesPage secondScreen = new SalesPage();
		try {
			secondScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Displays reportPage UI when user clicks the reportPage icon
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
	 * Displays homePage UI when user clicks the homePage icon
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
	 * Reads data from the saved sales_data.txt file and loads them into variables
	 * 
	 * @param fileName
	 */
	public void loadSalesData(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				String[] contents = scanner.nextLine().split(" : ");
				String coffeeFlavour = (contents[1]);
				coffeeFlavourList.add(coffeeFlavour);
				String coffeeMilk = (contents[3]);
				coffeeMilkList.add(coffeeMilk);
				String coffeeExtra = (contents[4]);
				coffeeExtraList.add(coffeeExtra);
				String coffeeSize = (contents[2]);
				coffeeSizeList.add(coffeeSize);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		numberOfCups = coffeeFlavourList.size();
		creamUsed = (int) creamUsed();
		flavourUsed = (int) flavourUsed();
		regularMilkUsed = regularMilkUsed();

	}

	/**
	 * Sets the hardcoded value for the inventory items:
	 * 
	 */
	public void inventoryList() {
		coffeeBeans = new InventoryContent(1, "Coffee Beans", 1000, 10000, 700);
		listIngredients.add(coffeeBeans);
		milkRegular = new InventoryContent(2, "Regular Milk", 5000, 10000, 1000);
		listIngredients.add(milkRegular);
		InventoryContent milkSkimmed = new InventoryContent(3, "Skimmed Milk", 5000, 5000, 100);
		listIngredients.add(milkSkimmed);
		InventoryContent milkSoy = new InventoryContent(4, "Soy Milk", 5000, 5000, 200);
		listIngredients.add(milkSoy);
		InventoryContent milkAlmond = new InventoryContent(5, "Almond Milk", 500, 50000, 200);
		listIngredients.add(milkAlmond);
		whippedCream = new InventoryContent(6, "Whipped Cream", 50, 2500, 500);
		listIngredients.add(whippedCream);
		flavour = new InventoryContent(6, "Flavour", 50, 2500, 500);
		listIngredients.add(flavour);
	}

	/**
	 * Returns quantity left of the coffeeBean inventory item after usedquantity is
	 * subtracted from the loaded sales data file {@link loadSalesData()}
	 * 
	 * @param numberOfCups
	 * @return quantityLeft
	 */
	public double updateCoffeeBeans(int numberOfCups) {
		// assumption 1 cup of coffee uses 18g of beans
		double gramsBeansUsed = numberOfCups * 18;

		double usedQuantity = coffeeBeans.getUsedQuantity() + gramsBeansUsed;
		coffeeBeans.setUsedQuantity(usedQuantity);

		double quantityLeft = coffeeBeans.getPurchasedQuantity() - coffeeBeans.getUsedQuantity();
		coffeeBeans.setQuantityLeft(quantityLeft);

		return quantityLeft;
	}

	/**
	 * Returns quantityLeft for the regular milk in the inventory items after
	 * loading the sales data file and updating the used quantity of the regular
	 * milk
	 * 
	 * @param regularMilkUsed
	 * @return quantityLeft
	 */
	public double updateRegularMilk(double regularMilkUsed) {
		double usedQuantity = milkRegular.getUsedQuantity() + regularMilkUsed;
		milkRegular.setUsedQuantity(usedQuantity);

		double quantityLeft = milkRegular.getPurchasedQuantity() - milkRegular.getUsedQuantity();
		milkRegular.setQuantityLeft(quantityLeft);

		return quantityLeft;
	}

	/**
	 * Returns the quantity of regular milk used by going thru the list of
	 * CoffeeMilk on the sales data and checking how many coffee objects has the
	 * regular milk used and multiplying it by 150 to get the volume of regular milk
	 * used
	 * 
	 * @return regularMilkUsed
	 */
	public double regularMilkUsed() {
		double regularMilkUsed = 0;
		int counter = 0;
		for (int i = 0; i < coffeeMilkList.size(); i++) {
			if (coffeeMilkList.contains("Regular")) {
				counter++;
			}
			// assumption 1 cup of coffee uses 150ml of milk
			regularMilkUsed = counter * 150;
		}
		return regularMilkUsed;

	}

	/**
	 * Returns quantityLeft for the cream in the inventory items after loading the
	 * sales data file and updating the used quantity of the cream
	 * 
	 * @param creamUsed
	 * @return quantityLeft
	 */
	public double updateCream(double creamUsed) {
		// assumption 1 cup of coffee uses 10ml of cream
		double usedQuantity = whippedCream.getUsedQuantity() + creamUsed;
		whippedCream.setUsedQuantity(usedQuantity);

		double quantityLeft = whippedCream.getPurchasedQuantity() - whippedCream.getUsedQuantity();
		whippedCream.setQuantityLeft(quantityLeft);

		return quantityLeft;
	}

	/**
	 * Returns the quantity of cream used by going thru the list of CoffeeExtra on
	 * the sales data and checking how many coffee objects has the cream used and
	 * multiplying it by 10 to get the volume of cream used
	 * 
	 * @return creamUsed
	 */
	private double creamUsed() {
		double creamUsed = 0;
		int counter = 0;
		for (int i = 0; i < coffeeExtraList.size(); i++) {
			if (coffeeExtraList.contains("Cream")) {
				counter++;
			}
			creamUsed = counter * 10;
		}
		return creamUsed;
	}

	/**
	 * Returns quantityLeft for the flavour in the inventory items after loading the
	 * sales data file and updating the used quantity of the flavour
	 * 
	 * @param flavourUsed
	 * @return quantityLeft
	 */
	public double updateFlavour(double flavourUsed) {
		// assumption 1 cup of coffee uses 10ml of flavorings

		double usedQuantity = flavour.getUsedQuantity() + flavourUsed;
		flavour.setUsedQuantity(usedQuantity);

		double quantityLeft = flavour.getPurchasedQuantity() - flavour.getUsedQuantity();
		flavour.setQuantityLeft(quantityLeft);

		return quantityLeft;
	}

	/**
	 * Returns the quantity of flavour used by going thru the list of CoffeeExtra on
	 * the sales data and checking how many coffee objects has the flavour used and
	 * multiplying it by 5 to get the volume of flavour used
	 * 
	 * @return flavourUsed
	 */
	private double flavourUsed() {
		double flavourUsed = 0;
		int counter = 0;
		for (int i = 0; i < coffeeExtraList.size(); i++) {
			if (coffeeExtraList.contains("Flavour")) {
				counter++;
			}
			flavourUsed = counter * 5;
		}
		return flavourUsed;
	}

	/**
	 * Updates the CoffeeBeans, Cream, Regular Milk and Flavour quantities on the
	 * InventoryPage UI when the update Inventory Button is clicked
	 * 
	 * @param e
	 */
	@FXML
	public void updateInventory(Event e) {
		updateCoffeeBeans(numberOfCups);
		updateCream(creamUsed);
		updateRegularMilk(regularMilkUsed);
		updateFlavour(flavourUsed);
		coffeeBeans.getUsedQuantity();
		coffeeBeans.getQuantityLeft();
		whippedCream.getUsedQuantity();
		whippedCream.getQuantityLeft();
		flavour.getUsedQuantity();
		flavour.getQuantityLeft();
		milkRegular.getUsedQuantity();
		milkRegular.getQuantityLeft();
		tableInventory.refresh();
	}

	public void setCoffeeBeans(InventoryContent coffeeBeans) {
		this.coffeeBeans = coffeeBeans;
	}

	public int getNumberOfCups() {
		return numberOfCups;
	}

	public List<String> getCoffeeFlavourList() {
		return coffeeFlavourList;
	}

	public List<String> getCoffeeMilkList() {
		return coffeeMilkList;
	}

	public List<String> getCoffeeExtraList() {
		return coffeeExtraList;
	}

	public List<String> getCoffeeSizeList() {
		return coffeeSizeList;
	}

}
