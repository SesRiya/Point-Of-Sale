package application;

/**
 * Class for the Coffee object
 * 
 * @param coffeeID
 * @param coffeeFlavour
 * @param coffeeMilk
 * @param coffeeExtra
 * @param coffeePrice
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

	public Coffee(int coffeeID, String coffeeFlavour) {
		this.coffeeID = coffeeID;
		this.coffeeFlavour = coffeeFlavour;
	}

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

	public void setCoffeeID(int coffeeID) {
		this.coffeeID = coffeeID;
	}

	public String getCoffeeFlavour() {
		return coffeeFlavour;
	}

	public void setCoffeeFlavour(String coffeeFlavour) {
		this.coffeeFlavour = coffeeFlavour;
	}

	public double getCoffeePrice() {
		return coffeePrice;
	}

	public void setCoffeePrice(double coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	public String getCoffeeSize() {
		return coffeeSize;
	}

	public void setCoffeeSize(String coffeeSize) {
		this.coffeeSize = coffeeSize;
	}

	public String getCoffeeMilk() {
		return coffeeMilk;
	}

	public void setCoffeeMilk(String coffeeMilk) {
		this.coffeeMilk = coffeeMilk;
	}

	public String getCoffeeExtra() {
		return coffeeExtra;
	}

	public void setCoffeeExtra(String coffeeExtra) {
		this.coffeeExtra = coffeeExtra;
	}

}
