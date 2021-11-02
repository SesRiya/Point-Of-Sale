package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import application.SalesPage;

class SalesPageTest {
	
	private static SalesPage salesPage;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		salesPage = new SalesPage();
	}

	

}
