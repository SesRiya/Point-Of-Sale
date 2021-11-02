package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import application.Employee;

class EmployeeTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@Test
	void test() {
		Employee employee = new Employee("admin", "123");

		employee.setUserName("admin");
		assertEquals(employee.getUserName(), "admin");

		employee.setPassword("123");
		assertEquals(employee.getPassword(), "123");

	}

	@ParameterizedTest
	@MethodSource("employeeDataProvider")
	public void employeeTest(String userName, String password) {
		Employee employee = new Employee(userName, password);

		assertEquals(employee.getUserName(), userName);
		assertEquals(employee.getPassword(), password);

	}

	public static Stream<Arguments> employeeDataProvider() {
		return Stream.of(Arguments.of("admin", "123"

		), Arguments.of("Cashier", "456"

		),

				Arguments.of("Penny", "789"

				));
	}

}
