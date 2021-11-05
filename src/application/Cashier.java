package application;

/**
 * Person who has Login Authentication and able to access Sales Page
 * 
 * @author POS group
 *
 */
public class Cashier extends Employee{

	/**
	 * 
	 * @param userName username
	 * @param password1 password
	 */
	public Cashier(String userName, String password1) {
		super(userName, password1);
	}

}
