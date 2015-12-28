/**
 * 
 */
package plainObjects;

import java.util.ArrayList;

/**
 * @author binoy.j.cherian
 *
 */
public class CarStandingOrder {
	
	private String customerName;
	private String region;
	private String vendor;
	private String model;
	private String variant;
	private String color;
	private ArrayList<String> accessories;
	private String motorInsurance;
	private String personalProtectPlan;
	
	
	

	//getters and setters 
	
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
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
	public ArrayList<String> getAccessories() {
		return accessories;
	}
	public void setAccessories(ArrayList<String> accessories) {
		this.accessories = accessories;
	}
	public String getMotorInsurance() {
		return motorInsurance;
	}
	public void setMotorInsurance(String motorInsurance) {
		this.motorInsurance = motorInsurance;
	}
	public String getPersonalProtectPlan() {
		return personalProtectPlan;
	}
	public void setPersonalProtectPlan(String personalProtectPlan) {
		this.personalProtectPlan = personalProtectPlan;
	}
	
	
	public String getKey()
	{
		return vendor+"_"+model+"_"+variant+"_"+color;
	}
	
	public String getAccessoryKey()
	{
		return vendor+"_"+model;
		
	}
	
	@Override
	public String toString() {
		
		return "Customer Name: "+customerName+"\nRegion: "+region+"\nVendor: "+vendor
				+"\nModel: "+model+"\nVariant: "+variant+"\nColor: "+color+
				"\nAccessories: "+accessories+"\nMotor Insurance: "+motorInsurance
				+"\nPersonalProtection: "+personalProtectPlan+"\n";
	}
	

}
