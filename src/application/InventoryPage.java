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

public class InventoryPage extends Application implements Initializable {
	private static Stage stage;
	private InventoryContent selectedInventory;
	private int numberOfCups;
	

	private List<String> coffeeFlavourList = new ArrayList<>();
	private List<String> coffeeMilkList = new ArrayList<>();
	private List<String> coffeeExtraList = new ArrayList<>();
	private List<String> coffeeSizeList = new ArrayList<>();

	private InventoryContent coffeeBeans;

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
		loadSalesData();
		inventoryList();
		updateCoffeeBeans(numberOfCups);
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
					selectedInventory = row.getItem();
				}
			});
			return row;
		});

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(InventoryPage.class.getResource("/layout/InventoryPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 550, 600));
		primaryStage.show();
		stage = primaryStage;
	}

	@FXML
	public void salesPage(Event e) {
		SalesPage secondScreen = new SalesPage();
		try {
			secondScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
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

	public void loadSalesData() {
		try {
			Scanner scanner = new Scanner(new File("sales_data.txt"));
			while (scanner.hasNextLine()) {
				String[] contents = scanner.nextLine().split(" : ");
				String coffeeFlavour = (contents[1]);
				coffeeFlavourList.add(coffeeFlavour);
				String coffeeMilk = (contents[3]);
				coffeeMilkList.add(coffeeMilk);
				String coffeeExtra = (contents[3]);
				coffeeExtraList.add(coffeeExtra);
				String coffeeSize = (contents[2]);
				coffeeSizeList.add(coffeeSize);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		numberOfCups = coffeeFlavourList.size();
		
		
	}

	public void inventoryList() {
		coffeeBeans = new InventoryContent(1, "Coffee Beans", 1000, 10000, 300);
		listIngredients.add(coffeeBeans);
		InventoryContent milkRegular = new InventoryContent(2, "Regular Milk", 50, 10, 1);
		listIngredients.add(milkRegular);
		InventoryContent milkSkimmed = new InventoryContent(3, "Skimmed Milk", 50, 5, 1);
		listIngredients.add(milkSkimmed);
		InventoryContent milkSoy = new InventoryContent(4, "Soy Milk", 50, 5, 1);
		listIngredients.add(milkSoy);
		InventoryContent milkAlmond = new InventoryContent(5, "Almond Milk", 50, 5, 1);
		listIngredients.add(milkAlmond);
		InventoryContent whippedCream = new InventoryContent(6, "Whipped Cream", 50, 5, 1);
		listIngredients.add(whippedCream);
		InventoryContent flavour = new InventoryContent(6, "Flavour", 50, 5, 1);
		listIngredients.add(flavour);
	}

	public double updateCoffeeBeans(int numberOfCups) {
	
		// assumption 1 cup of coffee uses 18g of beans
		int gramsBeansUsed = numberOfCups * 18;

		double usedQuantity = coffeeBeans.getUsedQuantity() + gramsBeansUsed;
		coffeeBeans.setUsedQuantity(usedQuantity);

		double quantityLeft = coffeeBeans.getPurchasedQuantity() - coffeeBeans.getUsedQuantity();
		coffeeBeans.setQuantityLeft(quantityLeft);
		
		return quantityLeft;
	}

//	public double updateCream(int numberOfCups) {
//		
//		//assumption extra whipped cream uses 10ml of cream
//		
//		
//	
//	}
	
	@FXML
	public void updateInventory(Event e) {
		coffeeBeans.getUsedQuantity();
		coffeeBeans.getQuantityLeft();
		tableInventory.refresh();
	}

}
