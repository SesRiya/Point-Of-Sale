package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
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
	
	@ParameterizedTest(name="{index}:totalPriceTest(0,1)")
	@MethodSource("coffeProvider")
	public void totalPriceTest(List<Coffee> coffees, double totalPrice) {
		ObservableList<Coffee> coffeesOL = FXCollections.observableArrayList();	
		for(Coffee coffee: coffees ) {
			coffeesOL.add(coffee);
		}				
		assertEquals(totalPrice, salesPage.totalPrice(coffeesOL));
	}
	
	public static Collection coffeProvider() {
		return Arrays.asList(new Object[][] {{
				Arrays.asList(
						new Coffee(1, "Americano", "S", "Regular", "None", 5.50),
						new Coffee(2, "Cappuccino", "S", "Regular", "None", 4.50),
						new Coffee(4, "Espresso", "S", "Regular", "None", 4.00)
						),
				14
				},
			{
					Arrays.asList(
							new Coffee(1, "Americano", "S", "Regular", "None", 7.50),
							new Coffee(2, "Cappuccino", "S", "Regular", "None", 5.50),
							new Coffee(4, "Espresso", "S", "Regular", "None", 5.00)
							),
					18	
			}
		});
	}
	

}
