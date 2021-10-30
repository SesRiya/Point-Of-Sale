package application;

public class Order {

	private int orderID;
	private Coffee coffee;
	private int quantity;
	
	
	public Order(int orderID, Coffee coffee, int quantity) {
		super();
		this.orderID = orderID;
		this.coffee = coffee;
		this.quantity = quantity;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public Coffee getCoffee() {
		return coffee;
	}


	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
