package plainObjects;

/**
 * 
 * @author raaool
 * This class is used to store the the data from the accessory Inventory csv. The variables represent the coloumns of
 * the csv.
 *
 */
public class AccessoryInventory {
	
	private static String vendor;
	private static String model;
	private static String accessory;
	private static long price;
	private static long quantitiyAvailable;
	
	//getters and setters
	
	   
	public String getVendor() {
		return vendor;
	}
	public static void setVendor(String vendor) {
		AccessoryInventory.vendor = vendor;
	}
	public String getModel() {
		return model;
	}
	public static void setModel(String model) {
		AccessoryInventory.model = model;
	}
	public String getAccessory() {
		return accessory;
	}
	public static void setAccessory(String accessory) {
		AccessoryInventory.accessory = accessory;
	}
	public Long getPrice() {
		return price;
	}
	public static void setPrice(long price) {
		AccessoryInventory.price = price;
	}
	public long getQuantitiyAvailable() {
		return quantitiyAvailable;
	}
	public static void setQuantitiyAvailable(long quantitiyAvailable) {
		AccessoryInventory.quantitiyAvailable = quantitiyAvailable;
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
