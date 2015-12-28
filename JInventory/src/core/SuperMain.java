package core;

import java.util.concurrent.ExecutionException;

import exceptions.AccessoryOverException;
import exceptions.CarOverException;

public class SuperMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException, AccessoryOverException, CarOverException {
		
			
//		try {
//			Class.forName("core.HandleOrdersUsingExecutor");
//		} catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}

		MapBuilderUsingExecutor builder=new MapBuilderUsingExecutor();
		builder.getStarted();
		
//		InventoryImpl impl=new InventoryImpl();
//		impl.readAccessoryInventoryfromCSV();
//		impl.readCarInventoryFromCSV();
//		impl.readCarStandingOrderFromCSV();
//		impl.readTaxRateFromCSV();
//		impl.readMotorInsuranceFromCSV();
		
		
		
	}

}
