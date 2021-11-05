package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class LoginTestDataProvider {
	/**
	 * 
	 * @return test data
	 */
	public static Stream<Arguments> loginAuthenticationTestDataProvider() {
		return Stream.of(
					Arguments.of(
							"admin",
							"123"
							),
					Arguments.of(
							"cashier",
							"456"
							)
				);
	}
	
	/**
	 * 
	 * @return test data
	 */
	public static Collection listAuthDataProvider() {
		return Arrays.asList(new Object[][] {
									{"yuri", "123", false},
									{"admin", "123", true}
			}
		);
	}
}
