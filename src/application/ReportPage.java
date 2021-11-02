package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class ReportPage extends Application implements Initializable {
	private static Stage stage;
	@FXML
	private LineChart<?, ?> lineChart;

	@FXML
	private CategoryAxis date;

	@FXML
	private NumberAxis revenue;

	@FXML
	private DatePicker calendar;

	@FXML
	private ToggleButton toggleGroup;

	@FXML
	private ToggleButton dayButton;

	@FXML
	private ToggleButton monthButton;

	@FXML
	private ToggleButton weekButton;

	// switch toggle button
	@FXML
	void ToggleButton(ActionEvent event) {
		if (event.getSource() == dayButton) {
			// add implementation

		}
		if (event.getSource() == monthButton) {
			// add implementation

		}
		if (event.getSource() == weekButton) {
			// add implementation

		}
	}

//add data into line chart
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		XYChart.Series income = new XYChart.Series<>();
		income.setName("Income");
		income.getData().add(new XYChart.Data("1st Jan", 23));
		income.getData().add(new XYChart.Data("2nd Jan", 20));
		income.getData().add(new XYChart.Data("3rd jan", 13));
		income.getData().add(new XYChart.Data("4th Jan", 40));
		income.getData().add(new XYChart.Data("5th Jan", 12));
		income.getData().add(new XYChart.Data("6th Jan", 10));
		income.getData().add(new XYChart.Data("7th Jan", loadData()));

		XYChart.Series cost = new XYChart.Series<>();
		cost.setName("Cost");
		cost.getData().add(new XYChart.Data("1st Jan", 13));
		cost.getData().add(new XYChart.Data("2nd Jan", 10));
		cost.getData().add(new XYChart.Data("3rd jan", 5));
		cost.getData().add(new XYChart.Data("4th Jan", 15));
		cost.getData().add(new XYChart.Data("5th Jan", 7));
		cost.getData().add(new XYChart.Data("6th Jan", 6));
		cost.getData().add(new XYChart.Data("7th Jan", 25));

		XYChart.Series profit = new XYChart.Series<>();
		profit.setName("Profit");
		profit.getData().add(new XYChart.Data("1st Jan", 10));
		profit.getData().add(new XYChart.Data("2nd Jan", 10));
		profit.getData().add(new XYChart.Data("3rd jan", 7));
		profit.getData().add(new XYChart.Data("4th Jan", 15));
		profit.getData().add(new XYChart.Data("5th Jan", 3));
		profit.getData().add(new XYChart.Data("6th Jan", 4));
		profit.getData().add(new XYChart.Data("7th Jan", 17));


		lineChart.getData().addAll(income, cost, profit);
	}

	public double loadData() {
		double sum = 0;
		try {
			Scanner scanner = new Scanner(new File("sales_data.txt"));
			while (scanner.hasNextLine()) {
				String[] contents = scanner.nextLine().split(" : ");
				sum += Double.parseDouble(contents[5]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println(sum);
		return sum;

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(ReportPage.class.getResource("/layout/ReportPageLayout.fxml"));
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

}