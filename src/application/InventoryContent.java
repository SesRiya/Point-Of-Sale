package application;

public class InventoryContent {
	int id,purchasedQuantity,usedQuantity;
	double priceItem;
	String itemName;
	/**
	 * @param id
	 * @param pQuantity
	 * @param uQuantity
	 * @param price
	 * @param itemName
	 */
	public InventoryContent(int id, int pQuantity, int uQuantity, double price, String itemName) {
		
		this.id = id;
		this.purchasedQuantity = pQuantity;
		this.usedQuantity = uQuantity;
		this.priceItem = price;
		this.itemName = itemName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpQuatity() {
		return purchasedQuantity;
	}
	public void setpQuatity(int pQuantity) {
		this.purchasedQuantity = pQuantity;
	}
	public int getuQuatity() {
		return usedQuantity;
	}
	public void setuQuatity(int uQuantity) {
		this.usedQuantity = uQuantity;
	}
	public double getPrice() {
		return priceItem;
	}
	public void setPrice(double price) {
		this.priceItem = price;
	}
	public String getiName() {
		return itemName;
	}
	public void setiName(String itemName) {
		this.itemName = itemName;
	}
	
	
	

}
