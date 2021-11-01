package application;

import java.net.URL;
import java.util.ResourceBundle;

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

public class ReportPage extends Application implements Initializable{
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
    
    //switch toggle button
    @FXML
    void ToggleButton(ActionEvent event) {
    	if(event.getSource()==dayButton) {
    		//add implementation
    		
    	}
    	if(event.getSource()==monthButton) {
    		//add implementation
    		
    	}
    	if(event.getSource()==weekButton) {
    		//add implementation
    		
    	}
    }
    

//add data into line chart
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		XYChart.Series income= new XYChart.Series<>();
		income.setName("Income");
		income.getData().add(new XYChart.Data("1st Jan",230));
		income.getData().add(new XYChart.Data("2nd Jan",200));
		income.getData().add(new XYChart.Data("3rd jan",130));
		income.getData().add(new XYChart.Data("4th Jan",400));
		income.getData().add(new XYChart.Data("5th Jan",120));
		income.getData().add(new XYChart.Data("6th Jan",100));
		income.getData().add(new XYChart.Data("7th Jan",670));
		
		XYChart.Series cost= new XYChart.Series<>();
		cost.setName("Cost");
		cost.getData().add(new XYChart.Data("1st Jan",130));
		cost.getData().add(new XYChart.Data("2nd Jan",100));
		cost.getData().add(new XYChart.Data("3rd jan",50));
		cost.getData().add(new XYChart.Data("4th Jan",150));
		cost.getData().add(new XYChart.Data("5th Jan",70));
		cost.getData().add(new XYChart.Data("6th Jan",60));
		cost.getData().add(new XYChart.Data("7th Jan",300));
		
		
		XYChart.Series profit= new XYChart.Series<>();
		profit.setName("Profit");
		profit.getData().add(new XYChart.Data("1st Jan",100));
		profit.getData().add(new XYChart.Data("2nd Jan",100));
		profit.getData().add(new XYChart.Data("3rd jan",70));
		profit.getData().add(new XYChart.Data("4th Jan",151));
		profit.getData().add(new XYChart.Data("5th Jan",30));
		profit.getData().add(new XYChart.Data("6th Jan",40));
		profit.getData().add(new XYChart.Data("7th Jan",370));
		
		lineChart.getData().addAll(income,cost,profit);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(ReportPage.class.getResource("/layout/ReportPageLayout.fxml"));
		primaryStage.setScene(new Scene(root, 900, 600));
		primaryStage.show();
		stage = primaryStage;
		
	}

	@FXML
	public void salesPage(Event e){
        SalesPage secondScreen = new SalesPage();
        try {
			secondScreen.start(stage);
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
	public void inventoryPage(Event e) {
		InventoryPage fourthScreen = new InventoryPage();
		try {
			fourthScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}