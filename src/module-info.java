module TestSceneBuilder {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
