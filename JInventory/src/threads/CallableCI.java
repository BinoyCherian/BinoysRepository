package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import core.InventoryImpl;
import core.InventoryInterface;
import plainObjects.CarInventory;

public class CallableCI implements Callable<Map<String, CarInventory>>{

	Map<String, CarInventory> carInventory=new HashMap<>();
	InventoryInterface loader=new InventoryImpl();
	@Override
	public Map<String, CarInventory> call() throws Exception {
		
		carInventory=loader.readCarInventoryFromCSV();
		
		return carInventory;
	}
	

}
