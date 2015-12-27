package plainObjects;



public class CarInventory {
	
	private static String vendor;
	private static String model;
	private static String variant;
	private static String color;
	private static long basePrice;
	private static int quantityAvailable;
	
	//getters and setters
	
	public  String getVendor() {
		return vendor;
	}
	public static void setVendor(String vendor) {
		CarInventory.vendor = vendor;
	}
	public String getModel() {
		return model;
	}
	public static void setModel(String model) {
		CarInventory.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public static void setVariant(String variant) {
		CarInventory.variant = variant;
	}
	public String getColor() {
		return color;
	}
	public static void setColor(String color) {
		CarInventory.color = color;
	}
	public long getBasePrice() {
		return basePrice;
	}
	public static void setBasePrice(long basePrice) {
		CarInventory.basePrice = basePrice;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public static void setQuantityAvailable(int quantityAvailable) {
		CarInventory.quantityAvailable = quantityAvailable;
	}
	
	public String getKey()
	{
//		System.out.println("Key: "+(vendor+"_"+model+"_"+variant+"_"+color));
		return vendor+"_"+model+"_"+variant+"_"+color;
		
	}
	
	@Override
	public String toString() {
		
		return "Vendor: "+vendor+"\nModel: "+model
				+"\nVariant: "+variant+"\nColor: "+color+"\nBase Price: "+basePrice
				+"\nQuantity Available: "+quantityAvailable
				;
	}
	
	

}
