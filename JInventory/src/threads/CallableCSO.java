package threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import core.InventoryImpl;
import core.InventoryInterface;
import plainObjects.CarStandingOrder;

public class CallableCSO implements Callable<ArrayList<CarStandingOrder>>{

	InventoryInterface loader=new InventoryImpl();
	ArrayList<CarStandingOrder> carStandingOrder=new ArrayList<>();
	
	@Override
	public ArrayList<CarStandingOrder> call() throws Exception {
		
		carStandingOrder=(ArrayList<CarStandingOrder>) loader.readCarStandingOrderFromCSV();
		return carStandingOrder;
	}

}
