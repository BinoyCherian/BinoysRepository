package core;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import exceptions.AccessoryOverException;
import exceptions.CarNotFoundException;
import exceptions.CarOverException;
import plainObjects.AccessoryInventory;
import plainObjects.CarInventory;
import plainObjects.CarStandingOrder;

public class MapBuilderUsingExecutor {

	static Map<String, AccessoryInventory> ai;
	static Map<String, CarInventory> ci;
	static ArrayList<CarStandingOrder> cso;
	static boolean lock1 = false;
	static boolean lock2 = false;

	static {
		ProcessingThreads processing = new ProcessingThreads();
		processing.startThreads();
		try {

			ai = processing.getFutureAImap().get();
			ci = processing.getFutureCImap().get();
			cso = processing.getFutureCSOmap().get();

		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ExecutionException e) {

			e.printStackTrace();
		}

	}

	public void getStarted() throws InterruptedException, ExecutionException, AccessoryOverException, CarOverException {

		System.out.println("Get Started");
		boolean carAvailablity = false;

		for (CarStandingOrder realOrder : cso) {
			carAvailablity = checkCarInventory(realOrder.getKey());
			if (carAvailablity) {
				System.out.println("Car available for processing");
				
				checkAccessoriesForOrder(realOrder);
				
			} else {
				System.out.println("Car not available");
				
			}
		}

	}

	private void checkAccessoriesForOrder(CarStandingOrder realOrder) {
		
		System.out.println(realOrder.getAccessories());
		System.out.println(realOrder.getAccessoryKey());
		
		
		System.out.println("New Keys");
		for(int i=0;i<realOrder.getAccessories().size();i++)
		{
			String newKeyForAccessory=realOrder.getAccessoryKey()+"_"+realOrder.getAccessories().get(i);
			System.out.println(newKeyForAccessory);
			
		}
		
		System.exit(0);
		
		
	}

	public boolean checkCarInventory(String key) {

		boolean carAvailable = false;
		if (ci.get(key) == null) {
			carAvailable = false;
		}

		else {
			carAvailable = true;

		}

		return carAvailable;

	}


	

	public static Map<String, AccessoryInventory> getAi() {
		return ai;
	}

	public static Map<String, CarInventory> getCi() {
		return ci;
	}

	public static ArrayList<CarStandingOrder> getCso() {
		return cso;
	}
}
