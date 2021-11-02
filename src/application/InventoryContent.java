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
	public int getPurchasedQuantity() {
		return purchasedQuantity;
	}
	public void setPurchasedQuantity(int purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}
	public int getUsedQuantity() {
		return usedQuantity;
	}
	public void setUsedQuantity(int usedQuantity) {
		this.usedQuantity = usedQuantity;
	}
	public double getPriceItem() {
		return priceItem;
	}
	public void setPriceItem(double priceItem) {
		this.priceItem = priceItem;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
}
