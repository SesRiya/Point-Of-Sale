package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import application.Coffee;

class CoffeeTest {

	@Test
	public void coffeeTest() {
		Coffee coffee = new Coffee(2, "caramel");
		assertEquals(coffee.getCoffeeID(), 2);
		assertEquals(coffee.getCoffeeFlavour(), "caramel");

		coffee.setCoffeeSize("L");
		assertEquals(coffee.getCoffeeSize(), "L");

		coffee.setCoffeePrice(4.50);
		assertEquals(coffee.getCoffeePrice(), 4.50);

		coffee.setCoffeeMilk("Soy");
		assertEquals(coffee.getCoffeeMilk(), "Soy");

		coffee.setCoffeeExtra("Shot");
		assertEquals(coffee.getCoffeeExtra(), "Espresso Shot");

	}

	@ParameterizedTest
	@MethodSource("coffeeDataProvider")
	public void coffeeTest(int coffeeID, String coffeeFlavour, String coffeeSize, String coffeeMilk, String coffeeExtra,
			double coffeePrice) {

		Coffee coffee = new Coffee(coffeeID, coffeeFlavour, coffeeSize, coffeeMilk, coffeeExtra, coffeePrice);

		assertEquals(coffee.getCoffeeID(), coffeeID);
		assertEquals(coffee.getCoffeeFlavour(), coffeeFlavour);
		assertEquals(coffee.getCoffeeSize(), coffeeSize);
		assertEquals(coffee.getCoffeeMilk(), coffeeMilk);
		assertEquals(coffee.getCoffeeExtra(), coffeeExtra);
		assertEquals(coffee.getCoffeePrice(), coffeePrice);
	}

	public static Stream<Arguments> coffeeDataProvider() {
		return Stream.of(Arguments.of(3, "Caramel", "M", "Soy", "Espresso Shot", 4.50

		), Arguments.of(7, "Chocolate", "L", "Oat", "Shot", 4.75

		),

				Arguments.of(5, "Chai", "S", "Almond", "Espresso Shot", 3.90

				));
	}

}
