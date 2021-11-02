package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import application.ReportPage;
import application.SalesPage;

class ReportPageTest {
	
	private static ReportPage reportpage;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		reportpage = new ReportPage();
	}


	
}
