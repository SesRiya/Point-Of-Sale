package application;

/**
 * Class for items in the Inventory Content
 * 

 * @author POS group
 *
 */
public class InventoryContent {
	private int itemID;
	private String itemName;
	private double priceItem;
	private double purchasedQuantity;
	private double usedQuantity;
	private double quantityLeft;

	/**
	 * 
	 * @param itemID id of item
	 * @param itemName name of item
	 * @param priceItem price of item
	 * @param purchasedQuantity quantity purchased
	 * @param usedQuantity quantity used
	 */
	public InventoryContent(int itemID, String itemName, double priceItem, double purchasedQuantity,
			double usedQuantity) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.priceItem = priceItem;
		this.purchasedQuantity = purchasedQuantity;
		this.usedQuantity = usedQuantity;
	}

	/**
	 * 
	 * @param itemID id of item
	 * @param itemName name of item
	 * @param priceItem price of item
	 * @param purchasedQuantity quantity purchased
	 * @param usedQuantity quantity used
	 * @param quantityLeft quantity left
	 */
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

	/**
	 * 
	 * @return id of item
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * 
	 * @param itemID id of item
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	/**
	 * 
	 * @return item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 
	 * @param itemName name of item
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 
	 * @return price of the item
	 */
	public double getPriceItem() {
		return priceItem;
	}


	/**
	 * 
	 * @param priceItem
	 */
	public void setPriceItem(double priceItem) {
		this.priceItem = priceItem;
	}

	/**
	 * 
	 * @return purchased quantity
	 */
	public double getPurchasedQuantity() {
		return purchasedQuantity;
	}

	/**
	 * 
	 * @param purchasedQuantity
	 */
	public void setPurchasedQuantity(double purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}

	/**
	 * 
	 * @return used quantity
	 */
	public double getUsedQuantity() {
		return usedQuantity;
	}

	/**
	 * 
	 * @param usedQuantity used quantity
	 */
	public void setUsedQuantity(double usedQuantity) {
		this.usedQuantity = usedQuantity;
	}

	/**
	 * 
	 * @return quantity which left
	 */
	public double getQuantityLeft() {
		return quantityLeft;
	}

	/**
	 * 
	 * @param quantityLeft leftquantity
	 */
	public void setQuantityLeft(double quantityLeft) {
		this.quantityLeft = quantityLeft;
	}

}
