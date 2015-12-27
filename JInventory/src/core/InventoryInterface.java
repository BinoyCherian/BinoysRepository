package core;


import java.util.List;
import java.util.Map;

import plainObjects.AccessoryInventory;
import plainObjects.CarInventory;
import plainObjects.CarStandingOrder;
import plainObjects.MotorInsurance;
import plainObjects.TaxRate;

public interface InventoryInterface {
	
	public Map<String, CarInventory> readCarInventoryFromCSV();
	
	public Map<String, AccessoryInventory> readAccessoryInventoryfromCSV();
	
	public List<CarStandingOrder> readCarStandingOrderFromCSV();
	
	public List<MotorInsurance> readMotorInsuranceFromCSV();
	
	public List<TaxRate> readTaxRateFromCSV();
	
}
