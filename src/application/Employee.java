package application;

/**
 * Class for People who will directly use the POS application
 * 
 * @author POS group
 *
 */
public class Employee extends Person {
	private String userName;
	private String password;

	/**
	 * 
	 * @param userName username 
	 * @param password password
	 */
	public Employee(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
