package application;

public class Coffee {
	private int coffeeID;
	private String coffeeFlavour;
	private String coffeeSize;
	private double coffeePrice;
		
	
	public Coffee(int coffeeID, String coffeeFlavour, String coffeeSize, double coffeePrice) {
		super();
		this.coffeeID = coffeeID;
		this.coffeeFlavour = coffeeFlavour;
		this.coffeeSize = coffeeSize;
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
	public String getCoffeeSize() {
		return coffeeSize;
	}
	public void setCoffeeSize(String coffeeSize) {
		this.coffeeSize = coffeeSize;
	}
	public double getCoffeePrice() {
		return coffeePrice;
	}
	public void setCoffeePrice(double coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	
	
}
