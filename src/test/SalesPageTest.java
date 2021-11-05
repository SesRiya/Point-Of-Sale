package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.TemporaryFolder;

import application.Coffee;
import application.InventoryPage;
import application.SalesPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SalesPageTest {

	private static SalesPage salesPage;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		salesPage = new SalesPage();
	}

	@ParameterizedTest(name = "{index}:totalPriceTest(0,1)")
	@MethodSource("coffeProvider")
	public void totalPriceTest(List<Coffee> coffees, double totalPrice) {
		ObservableList<Coffee> coffeesOL = FXCollections.observableArrayList();
		for (Coffee coffee : coffees) {
			coffeesOL.add(coffee);
		}
		assertEquals(totalPrice, salesPage.totalPrice(coffeesOL));
	}

	public static Collection coffeProvider() {
		return Arrays.asList(new Object[][] {
				{ Arrays.asList(new Coffee(1, "Americano", "S", "Regular", "None", 5.50),
						new Coffee(2, "Cappuccino", "S", "Regular", "None", 4.50),
						new Coffee(4, "Espresso", "S", "Regular", "None", 4.00)), 14 },
				{ Arrays.asList(new Coffee(1, "Americano", "S", "Regular", "None", 7.50),
						new Coffee(2, "Cappuccino", "S", "Regular", "None", 5.50),
						new Coffee(4, "Espresso", "S", "Regular", "None", 5.00)), 18 } });
	}

	@ParameterizedTest
	@MethodSource("coffeeFlavourProvider")
	public void priceCoffeeFlavourTest(String flavour, double price) {
		Coffee coffee = new Coffee(1, flavour);
		salesPage.setSelectedCoffee(coffee);
		assertEquals(salesPage.priceCoffeeFlavour(coffee), price);
	}

	public static Stream<Arguments> coffeeFlavourProvider() {
		return Stream.of(Arguments.of("Cappuccino", 4.50), Arguments.of("Espresso", 3.00), Arguments.of("", 5.50),
				Arguments.of("Double Espresso", 3.00), Arguments.of("Espresso Macchiato", 4.50));
	}

	@ParameterizedTest
	@MethodSource("coffeeMilkProvider")
	public void priceCoffeeMilkTest(String milk, double price) {
		Coffee coffee = new Coffee(1, milk);
		coffee.setCoffeeMilk(milk);

		assertEquals(salesPage.priceCoffeeMilk(coffee), price);
	}

	public static Stream<Arguments> coffeeMilkProvider() {
		return Stream.of(Arguments.of("Regular", 0.00), Arguments.of("Soy", 0.50), Arguments.of("Almond", 0.50),
				Arguments.of(" ", 0.20));
	}

	@ParameterizedTest
	@MethodSource("coffeeSizeProvider")
	public void priceCoffeeSizeTest(String size, double price) {
		Coffee coffee = new Coffee(1, size);
		coffee.setCoffeeSize(size);

		assertEquals(salesPage.priceCoffeeSize(coffee), price);
	}

	public static Stream<Arguments> coffeeSizeProvider() {
		return Stream.of(Arguments.of("S", 0.00), Arguments.of("M", 0.30)
		);
	}

	@ParameterizedTest
	@MethodSource("coffeeExtraProvider")
	public void priceCoffeeExtraTest(String extra, double price) {
		Coffee coffee = new Coffee(1, extra);
		coffee.setCoffeeExtra(extra);

		assertEquals(salesPage.priceCoffeeExtra(coffee), price);
	}

	public static Stream<Arguments> coffeeExtraProvider() {
		return Stream.of(Arguments.of("Cream", 0.80), Arguments.of("Espresso", 0.80), Arguments.of("Flavour", 0.30));
	}

	@ParameterizedTest
	@MethodSource("gstProvider")
	public void gstTest(double totalPrice, double gst) {
		assertEquals(salesPage.gst(totalPrice), gst);
	}

	public static Stream<Arguments> gstProvider() {
		return Stream.of(Arguments.of(10, 1.5), Arguments.of(20, 3.0));
	}

	@ParameterizedTest
	@MethodSource("coffeeSaveDataProvider")
	public void saveDataToFile(String fileName, List<Coffee> coffees) throws IOException {
		// Test writing to file
		ObservableList<Coffee> coffeesOL = FXCollections.observableArrayList();
		coffeesOL.addAll(coffees);
		// Create a new file always
		Writer fileWriter = new FileWriter(fileName, false);
		fileWriter.close();
		salesPage.saveDataToFile(fileName, coffeesOL);
		// Test reading from file
		InventoryPage inventoryPage = new InventoryPage();
		inventoryPage.loadSalesData(fileName);
		List<String> coffeeSizeList = inventoryPage.getCoffeeSizeList();
		assertEquals(coffeeSizeList.size(), coffees.size());

		for (int i = 0; i < coffees.size(); i++) {
			assertEquals(coffeeSizeList.get(i), coffees.get(i).getCoffeeSize());
		}
	}

	public static Stream<Arguments> coffeeSaveDataProvider() {
		return Stream.of(Arguments.of("sales_data_test.txt",
				Arrays.asList(new Coffee(2, "Cappuccino", "S", "Regular", "None", 4.50),
						new Coffee(4, "Espresso", "S", "Regular", "None", 4.00))));
	}
}
