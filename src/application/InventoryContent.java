package application;

public class InventoryContent {
	int id,pQuatity,uQuatity;
	double price;
	String iName;
	/**
	 * @param id
	 * @param pQuatity
	 * @param uQuatity
	 * @param price
	 * @param iName
	 */
	public InventoryContent(int id, int pQuatity, int uQuatity, double price, String iName) {
		
		this.id = id;
		this.pQuatity = pQuatity;
		this.uQuatity = uQuatity;
		this.price = price;
		this.iName = iName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpQuatity() {
		return pQuatity;
	}
	public void setpQuatity(int pQuatity) {
		this.pQuatity = pQuatity;
	}
	public int getuQuatity() {
		return uQuatity;
	}
	public void setuQuatity(int uQuatity) {
		this.uQuatity = uQuatity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	
	
	

}
