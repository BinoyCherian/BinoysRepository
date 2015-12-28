package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import core.InventoryImpl;
import core.InventoryInterface;
import plainObjects.CarStandingOrder;

public class CallableCSO implements Callable<List<CarStandingOrder>>{

	InventoryInterface loader=new InventoryImpl();
	List<CarStandingOrder> carStandingOrder=new ArrayList<>();
	
	@Override
	public List<CarStandingOrder> call() throws Exception {
		
		carStandingOrder= loader.readCarStandingOrderFromCSV();
		return carStandingOrder;
	}

}
