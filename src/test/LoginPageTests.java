package test;

import application.LoginPage;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * test login page
 * @author liuziyu
 *
 */
class LoginPageTests {
	private static LoginPage loginPage;

	/**
	 * 
	 * @throws Exception set log in page as the test page
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		loginPage = new LoginPage();
	}

	/**
	 * test method for loginauthentication
	 * @param name name
	 * @param pwd password
	 */
	@ParameterizedTest
	@MethodSource("test.LoginTestDataProvider#loginAuthenticationTestDataProvider")
	public void loginAuthenticationPositiveTest(String name, String pwd) {
		assertTrue(loginPage.loginAuthentication(name, pwd));
	}

	@ParameterizedTest(name = "{index}: loginAuthenticationNegativeTest(0,1,2)")
	@MethodSource("test.LoginTestDataProvider#listAuthDataProvider")
	public void loginAuthenticationNegativeTest(String name, String pwd, boolean result) {
		assertEquals(loginPage.loginAuthentication(name, pwd), result);
	}

}
