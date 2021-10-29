package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Main;

class TestMain {
	Main main;

	@BeforeEach
	void setUp() throws Exception {
		main = new Main();
	}

	@Test
	public void testAdd() {
		assertEquals(8, main.add(5, 3),"Error in the add method");
		assertEquals(2, main.add(5, -3),"Error in the add method");
	}

}
