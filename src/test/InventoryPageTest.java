package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import application.Coffee;
import application.InventoryContent;
import application.InventoryPage;
import application.ReportPage;
import application.SalesPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * test inventory page
 * @author liuziyu
 *
 */
class InventoryPageTest {

	private static InventoryPage inventorypage;

	/*
	 * set inventory page as a test page
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		inventorypage = new InventoryPage();
	}

	/**
	 * test method for update coffee beans
	 * @param ic inventory data
	 * @param cups numbers of cups
	 * @param quantity quantity of coffee beans left
	 */
	@ParameterizedTest
	@MethodSource("updateCoffeeBeansTestDataProvider")
	public void updateCoffeeBeansTest(InventoryContent ic, int cups, double quantity) {
		inventorypage.setCoffeeBeans(ic);
		assertEquals(quantity, inventorypage.updateCoffeeBeans(cups));
	}

	public static Stream<Arguments> updateCoffeeBeansTestDataProvider() {
		return Stream.of(Arguments.of(new InventoryContent(1, "Coffee Beans", 1000, 10000, 300), 3, 9646.0),
				Arguments.of(new InventoryContent(1, "Coffee Beans", 1000, 5000, 300), 6, 4592.0));
	}
}
