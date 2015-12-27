package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import core.InventoryImpl;
import core.InventoryInterface;
import plainObjects.AccessoryInventory;

public class CallableAI implements Callable<Map<String, AccessoryInventory>>{

	Map<String, AccessoryInventory> accessoryinventorymap=new HashMap<>();
	InventoryInterface loader=new InventoryImpl();
	@Override
	public Map<String, AccessoryInventory> call() throws Exception {
		
		accessoryinventorymap=loader.readAccessoryInventoryfromCSV();
		
		
		return accessoryinventorymap;
	}

}
