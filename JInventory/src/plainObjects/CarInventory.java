package plainObjects;



public class CarInventory {
	
	private String vendor;
	private String model;
	private   String variant;
	private   String color;
	private   long basePrice;
	private   int quantityAvailable;
	
	//getters and setters
	
	public  String getVendor() {
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
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(long basePrice) {
		this.basePrice = basePrice;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
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
