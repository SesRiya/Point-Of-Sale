module TestSceneBuilder {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires java.base;
	requires javafx.web;
	requires junit;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
