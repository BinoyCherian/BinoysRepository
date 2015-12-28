package plainObjects;

/**
 * 
 * @author raaool
 * This class is used to store the the data from the accessory Inventory csv. The variables represent the coloumns of
 * the csv.
 *
 */
public class AccessoryInventory {
	
	private String vendor;
	private String model;
	private String accessory;
	private long price;
	private long quantitiyAvailable;
	
	//getters and setters
	
	   
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getAccessory() {
		return accessory;
	}
	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getQuantitiyAvailable() {
		return quantitiyAvailable;
	}
	public void setQuantitiyAvailable(long quantitiyAvailable) {
		this.quantitiyAvailable = quantitiyAvailable;
	} 
	
	public String getKey()
	{
		return vendor+"_"+model+"_"+accessory;
	}
	
	
	
	@Override
	public String toString() {
		
		return "Vendor: "+vendor+"\nModel: "+model+"\nAccessory: "+accessory+"\nPrice: "+price+"\nQuantity: "+quantitiyAvailable;
	}
	
	
	

}
