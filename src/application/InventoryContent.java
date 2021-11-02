package application;

public class InventoryContent {
	private int itemID;
	private String itemName;
	private double priceItem;
	private double purchasedQuantity;	
	private double usedQuantity;
	private double quantityLeft;
	
	
	public InventoryContent(int itemID, String itemName, double priceItem, double purchasedQuantity,
			double usedQuantity) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.priceItem = priceItem;
		this.purchasedQuantity = purchasedQuantity;
		this.usedQuantity = usedQuantity;
	}

	
	

	public InventoryContent(int itemID, String itemName, double priceItem, double purchasedQuantity,
			double usedQuantity, double quantityLeft) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.priceItem = priceItem;
		this.purchasedQuantity = purchasedQuantity;
		this.usedQuantity = usedQuantity;
		this.quantityLeft = quantityLeft;
	}




	public int getItemID() {
		return itemID;
	}


	public void setItemID(int itemID) {
		this.itemID = itemID;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getPriceItem() {
		return priceItem;
	}


	public void setPriceItem(double priceItem) {
		this.priceItem = priceItem;
	}


	public double getPurchasedQuantity() {
		return purchasedQuantity;
	}


	public void setPurchasedQuantity(double purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}


	public double getUsedQuantity() {
		return usedQuantity;
	}


	public void setUsedQuantity(double usedQuantity) {
		this.usedQuantity = usedQuantity;
	}

	public double getQuantityLeft() {
		return quantityLeft;
	}


	public void setQuantityLeft(double quantityLeft) {
		this.quantityLeft = quantityLeft;
	}

	

}
