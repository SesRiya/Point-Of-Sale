package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import application.ReportPage;
import application.SalesPage;

class ReportPageTest {
	
	private static ReportPage reportpage;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		reportpage = new ReportPage();
	}

	

	

}



