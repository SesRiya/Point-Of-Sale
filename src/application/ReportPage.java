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
    private ToggleButton yearButton;
    
    //switch toggle button
    @FXML
    void ToggleButton(ActionEvent event) {
    	if(event.getSource()==dayButton) {
    		//add implementation
    		
    	}
    	if(event.getSource()==monthButton) {
    		//add implementation
    		
    	}
    	if(event.getSource()==yearButton) {
    		//add implementation
    		
    	}
    }
    


//add data into line chart
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		XYChart.Series series= new XYChart.Series<>();
		series.getData().add(new XYChart.Data("1",23));
		series.getData().add(new XYChart.Data("3",13));
		series.getData().add(new XYChart.Data("4",40));
		series.getData().add(new XYChart.Data("5",67));
		series.getData().add(new XYChart.Data("6",12));
		series.getData().add(new XYChart.Data("7",10));
		
		lineChart.getData().addAll(series);
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
	public void inventoryPage(Event e){
        InventoryPage fourthScreen = new InventoryPage();
        try {
			fourthScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }

	@FXML
	public void ReportPage(Event e){
        InventoryPage fourthScreen = new InventoryPage();
        try {
			fourthScreen.start(stage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }

}
