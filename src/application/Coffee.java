package application;

import javafx.beans.property.SimpleStringProperty;

public class Coffee {
	private int coffeeID;
	private String coffeeFlavour;
	private double coffeePrice;
	private String coffeeSize;

	public Coffee(int coffeeID, String coffeeFlavour, double coffeePrice) {
		this.coffeeID = coffeeID;
		this.coffeeFlavour = coffeeFlavour;
		this.coffeePrice = coffeePrice;
	}

	public Coffee(int coffeeID, String coffeeFlavour, double coffeePrice, String coffeeSize) {
		super();
		this.coffeeID = coffeeID;
		this.coffeeFlavour = coffeeFlavour;
		this.coffeePrice = coffeePrice;
		this.coffeeSize = coffeeSize;
	}

	public String getCoffeeSize() {
		return coffeeSize;
	}

	public void setCoffeeSize(String coffeeSize) {
		this.coffeeSize = coffeeSize;
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
