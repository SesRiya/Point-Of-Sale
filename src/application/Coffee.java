package application;

public class Coffee {
	private int coffeeID;
	private String coffeeFlavour;
	private double coffeePrice;

	public Coffee(int coffeeID, String coffeeFlavour, double coffeePrice) {
		this.coffeeID = coffeeID;
		this.coffeeFlavour = coffeeFlavour;
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

}
