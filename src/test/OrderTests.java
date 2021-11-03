package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import application.Coffee;
import application.Order;

class OrderTest {

	@ParameterizedTest
	@MethodSource("orderDataProvider")
	public void orderTest(int orderID, List<Coffee> coffeeOrder, int newOrderID, List<Coffee> newCoffeeOrder) {
		Order order = new Order(orderID, coffeeOrder);
		assertEquals(order.getOrderID(), orderID);
		assertArrayEquals(order.getCoffeeOrder().toArray(), coffeeOrder.toArray());
		order.setOrderID(newOrderID);
		assertEquals(order.getOrderID(), newOrderID);

		order.setCoffeeOrder(newCoffeeOrder);
		assertArrayEquals(order.getCoffeeOrder().toArray(), newCoffeeOrder.toArray());
	}

	public static Stream<Arguments> orderDataProvider() {
		return Stream.of(Arguments.of(1,
				Arrays.asList(new Coffee(2, "caramel"), new Coffee(4, "chocolate"), new Coffee(7, "hazlenut")), 2,
				Arrays.asList(new Coffee(3, "chocolate"), new Coffee(2, "caramel"), new Coffee(4, "hazlenut"))));
	}

}

