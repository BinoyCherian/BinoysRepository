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
	
	private static String customerName;
	private static String region;
	private static  String vendor;
	private static String model;
	private static String variant;
	private static String color;
	private static ArrayList<String> accessories;
	private static String motorInsurance;
	private static String personalProtectPlan;
	
	
	

	//getters and setters 
	
	
	
	public String getCustomerName() {
		return customerName;
	}
	public static void setCustomerName(String customerName) {
		CarStandingOrder.customerName = customerName;
	}
	public String getRegion() {
		return region;
	}
	public static void setRegion(String region) {
		CarStandingOrder.region = region;
	}
	public String getVendor() {
		return vendor;
	}
	public static void setVendor(String vendor) {
		CarStandingOrder.vendor = vendor;
	}
	public String getModel() {
		return model;
	}
	public static void setModel(String model) {
		CarStandingOrder.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public static void setVariant(String variant) {
		CarStandingOrder.variant = variant;
	}
	public String getColor() {
		return color;
	}
	public static void setColor(String color) {
		CarStandingOrder.color = color;
	}
	public ArrayList<String> getAccessories() {
		return accessories;
	}
	public static void setAccessories(ArrayList<String> accessories) {
		CarStandingOrder.accessories = accessories;
	}
	public String getMotorInsurance() {
		return motorInsurance;
	}
	public static void setMotorInsurance(String motorInsurance) {
		CarStandingOrder.motorInsurance = motorInsurance;
	}
	public String getPersonalProtectPlan() {
		return personalProtectPlan;
	}
	public static void setPersonalProtectPlan(String personalProtectPlan) {
		CarStandingOrder.personalProtectPlan = personalProtectPlan;
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
