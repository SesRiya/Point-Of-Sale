package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InventoryPage extends Application {
	private static Stage stage;

	@FXML
	private TableView<InventoryContent> tableInventory;

	@FXML
	private TableColumn<InventoryContent, Integer> idItemColumn;
	@FXML
	private TableColumn<InventoryContent, String> itemNameColumn;
	@FXML
	private TableColumn<InventoryContent, Integer> purchasedQuantityColumn;
	@FXML
	private TableColumn<InventoryContent, Integer> usedQuantityColumn;
	@FXML
	private TableColumn<InventoryContent, Double> priceItemColumn;

	ObservableList<InventoryContent> list = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(InventoryPage.class.getResource("/layout/InventoryPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 530, 500));
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

}
