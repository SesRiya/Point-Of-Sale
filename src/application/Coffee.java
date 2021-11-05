package application;

/**
 * Coffee object class
 * 
 * @author POS group
 *
 */
public class Coffee {
	private int coffeeID;
	private String coffeeFlavour;
	private String coffeeSize;
	private String coffeeMilk;
	private String coffeeExtra;
	private double coffeePrice;

	/**
	 * 
	 * @param coffeeID id of coffee
	 * @param coffeeFlavour flavour of coffee
	 */
	public Coffee(int coffeeID, String coffeeFlavour) {
		this.coffeeID = coffeeID;
		this.coffeeFlavour = coffeeFlavour;
	}

	/**
	 * 
	 * @param coffeeID id of coffee
	 * @param coffeeFlavour flavour of coffee
	 * @param coffeeSize size of coffee
	 * @param coffeeMilk milk of coffee
	 * @param coffeeExtra extra of coffee
	 * @param coffeePrice price of coffee
	 */
	public Coffee(int coffeeID, String coffeeFlavour, String coffeeSize, String coffeeMilk, String coffeeExtra,
			double coffeePrice) {
		this.coffeeID = coffeeID;
		this.coffeeFlavour = coffeeFlavour;
		this.coffeeSize = coffeeSize;
		this.coffeeMilk = coffeeMilk;
		this.coffeeExtra = coffeeExtra;
		this.coffeePrice = coffeePrice;
	}

	public int getCoffeeID() {
		return coffeeID;
	}

	/**
	 * 
	 * @param coffeeID
	 */
	public void setCoffeeID(int coffeeID) {
		this.coffeeID = coffeeID;
	}

    /**
     * 
     * @return coffee flavour
     */
	public String getCoffeeFlavour() {
		return coffeeFlavour;
	}

	/**
	 * 
	 * @param coffeeFlavour
	 */
	public void setCoffeeFlavour(String coffeeFlavour) {
		this.coffeeFlavour = coffeeFlavour;
	}

	/**
	 * 
	 * @return coffee price
	 */
	public double getCoffeePrice() {
		return coffeePrice;
	}

	/**
	 * 
	 * @param coffeePrice
	 */
	public void setCoffeePrice(double coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	/**
	 * 
	 * @return size of coffee
	 *
	 */
	public String getCoffeeSize() {
		return coffeeSize;
	}

	/**
	 * 
	 * @param coffeeSize
	 */
	public void setCoffeeSize(String coffeeSize) {
		this.coffeeSize = coffeeSize;
	}

	/**
	 * 
	 * @return coffee milk
	 */
	public String getCoffeeMilk() {
		return coffeeMilk;
	}

	/**
	 * 
	 * @param coffeeMilk the milk which coffee uses
	 */
	public void setCoffeeMilk(String coffeeMilk) {
		this.coffeeMilk = coffeeMilk;
	}

	/**
	 * 
	 * @return coffee extra
	 */
	public String getCoffeeExtra() {
		return coffeeExtra;
	}

	/**
	 * 
	 * @param coffeeExtra coffee extra
	 */
	public void setCoffeeExtra(String coffeeExtra) {
		this.coffeeExtra = coffeeExtra;
	}

}
