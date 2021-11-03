package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
	
	@ParameterizedTest
	@MethodSource("coffeeFlavourProvider")
	public void  priceCoffeeFlavourTest(String flavour,double price) {
		Coffee coffee=new Coffee(1,flavour);
		salesPage.setSelectedCoffee(coffee);
		assertEquals(salesPage.priceCoffeeFlavour(),price);		
	}
	
	
	public static Stream<Arguments> coffeeFlavourProvider() {
		return Stream.of(
				Arguments.of("Cappuccino",4.50),
				Arguments.of("Espresso",3.00),
				Arguments.of("",5.50),
				Arguments.of("Double Espresso",3.00),
				Arguments.of("Espresso Macchiato",4.50)
				);
	}
	
	

}
