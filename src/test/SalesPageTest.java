package test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import application.Coffee;
import application.SalesPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class SalesPageTest {

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
		return Stream.of(Arguments.of("Cream", 0.80), Arguments.of("Espresso", 0.80), Arguments.of("Flavour", 0.30)

		);
	}

}
