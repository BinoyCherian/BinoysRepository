package core;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;

import exceptions.AccessoryOverException;
import exceptions.CarOverException;
import plainObjects.AccessoryInventory;
import plainObjects.CarInventory;
import plainObjects.CarStandingOrder;
import plainObjects.MotorInsurance;
import plainObjects.TaxRate;

public class MapBuilderUsingExecutor {

	static Map<String, AccessoryInventory> ai;
	static Map<String, CarInventory> ci;
	static List<CarStandingOrder> cso;
	static List<MotorInsurance> mi;
	static List<TaxRate> ti;
	static Logger log=Logger.getLogger(MapBuilderUsingExecutor.class);


	static {
		ProcessingThreads processing = new ProcessingThreads();
		processing.startThreads();
		try {

			ai = processing.getFutureAImap().get();
			ci = processing.getFutureCImap().get();
			cso = processing.getFutureCSOmap().get();
			mi=processing.getFutureMImap().get();
			ti=processing.getFutureTRmap().get();
			
//			
//			log.info("ai: "+ai.size());
//			log.info("ci: "+ci.size());
//			log.info("cso: "+cso.size());
//			log.info("mi: "+mi.size());
//			log.info("ti: "+ti.size());

		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ExecutionException e) {

			e.printStackTrace();
		}

	}

	public void getStarted() throws InterruptedException, ExecutionException, AccessoryOverException, CarOverException {

//		System.out.println("Get Started");
		
		boolean carAvailablity = false;
		boolean allAccessoriesAvailable=false;

		for (CarStandingOrder realOrder : cso) {
//			System.out.println("key: "+realOrder.getKey());
			carAvailablity = checkCarInventory(realOrder.getKey());
			
			
			if (carAvailablity) {
				
//				System.out.println(realOrder.getKey()+" is available for processing");
				
				allAccessoriesAvailable=checkAccessoriesForOrder(realOrder);
			}
			else
			{
				System.out.println(realOrder.getKey()+" is not available for processing");
			}
			
			if(carAvailablity==allAccessoriesAvailable)
			{
				processOrder(realOrder);
			}
		}

	}

	private void processOrder(CarStandingOrder realOrder) {
		
		
	}

	private boolean checkAccessoriesForOrder(CarStandingOrder realOrder) {
		
		AccessoryInventory tempAccessory=new AccessoryInventory();
		
		boolean musicSystemAvailable=false;
		boolean powerDoorLocksAvailable=false;
		boolean bodyCoverAvailable=false;
		boolean floorMatAvailable=false;
		boolean seatCoverAvailable=false;
		boolean allAccessoriesAvailable=false;
		int countAccessories=0;
		
		System.out.println(realOrder.getAccessories());
		System.out.println("Working for: "+realOrder.getAccessoryKey());
		
		
//		System.out.println("New Keys");
		for(String str: realOrder.getAccessories())
		{
//			System.out.println(str);
			String newKeyForAccessory=realOrder.getAccessoryKey()+"_"+str;
			tempAccessory=ai.get(newKeyForAccessory);
			switch (str) {
			
			case "Music System":
				
				if(ai.get(newKeyForAccessory)!=null)
				{
					
					if(tempAccessory.getQuantitiyAvailable()>1)
					{
						System.out.println(tempAccessory.getAccessory()+" available: "+tempAccessory.getQuantitiyAvailable());
						musicSystemAvailable=true;
						countAccessories++;
					}
					else
					{
						musicSystemAvailable=false;
						//throw accessory not available
						//order cannot be processed
					}
					
				}
				
				break;
				
			case "Power Door Locks":
				
				
				if(ai.get(newKeyForAccessory)!=null)
				{
					if(tempAccessory.getQuantitiyAvailable()>1)
					{
						System.out.println(tempAccessory.getAccessory()+" available: "+tempAccessory.getQuantitiyAvailable());
						powerDoorLocksAvailable=true;
						countAccessories++;
					}
					else
					{
						powerDoorLocksAvailable=false;
					}
				}
				break;
				
				
			case "Body Cover": 
				if(ai.get(newKeyForAccessory)!=null)
				{
					if(tempAccessory.getQuantitiyAvailable()>1)
					{
						System.out.println(tempAccessory.getAccessory()+" available: "+tempAccessory.getQuantitiyAvailable());
						bodyCoverAvailable=true;
						countAccessories++;
					}
					else
					{
						bodyCoverAvailable=false;
					}
				}
				
				break;
				
			case "Floor Mat":
				
				if(ai.get(newKeyForAccessory)!=null)
				{
					if(tempAccessory.getQuantitiyAvailable()>1)
					{
						System.out.println(tempAccessory.getAccessory()+" available: "+tempAccessory.getQuantitiyAvailable());
						floorMatAvailable=true;
						countAccessories++;
					}
					else
					{
						floorMatAvailable=false;
					}
				}
				break;
				
			case "Seat Cover":
				
				if(ai.get(newKeyForAccessory)!=null)
				{
					if(tempAccessory.getQuantitiyAvailable()>1)
					{
						System.out.println(tempAccessory.getAccessory()+" available: "+tempAccessory.getQuantitiyAvailable());
						seatCoverAvailable=true;
						countAccessories++;
					}
					else
					{
						seatCoverAvailable=false;
					}
				}
				
				break;

			default:
				break;
			}
			
		}
		
		
		if(countAccessories==realOrder.getAccessories().size())
		{
			System.out.println("All accessories available for: "+realOrder.getKey());
			allAccessoriesAvailable=true;
		}
		else
		{
			System.out.println("Complete accessories not available for : "+realOrder.getKey());
			allAccessoriesAvailable=false;
		}
		


		
		System.exit(0);
		return allAccessoriesAvailable;
		
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

	public static List<CarStandingOrder> getCso() {
		return cso;
	}
}
