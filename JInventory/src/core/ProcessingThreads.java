package core;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import plainObjects.AccessoryInventory;
import plainObjects.CarInventory;
import plainObjects.CarStandingOrder;
import plainObjects.MotorInsurance;
import plainObjects.TaxRate;
import threads.CallableAI;
import threads.CallableCI;
import threads.CallableCSO;
import threads.CallableMI;
import threads.CallableTR;

public class ProcessingThreads {

	CallableAI callAI;
	CallableCI callCI;
	CallableCSO callCSO;
	CallableMI callMI;
	CallableTR callTR;
	
	Future<Map<String, AccessoryInventory>> futureAImap;
	Future<Map<String, CarInventory>> futureCImap;
	Future<List<CarStandingOrder>> futureCSOmap;
	Future<List<MotorInsurance>> futureMImap;
	

	public ProcessingThreads() {

		callAI= new CallableAI();
		callCI=new CallableCI();
		callCSO=new CallableCSO();
		callMI=new CallableMI();
		callTR=new CallableTR();
		

	}

	public void startThreads() {


		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		futureAImap=executor.submit(callAI);
		futureCImap=executor.submit(callCI);
		futureCSOmap=executor.submit(callCSO);
		futureMImap=executor.submit(callMI);
		futureTRmap=executor.submit(callTR);
		
		//System.out.println("Futures Value-------------------");
		
	}

	public Future<Map<String, AccessoryInventory>> getFutureAImap() {
		return futureAImap;
	}

	public Future<Map<String, CarInventory>> getFutureCImap() {
		return futureCImap;
	}

	public Future<List<CarStandingOrder>> getFutureCSOmap() {
		return futureCSOmap;
	}
	
	Future<List<TaxRate>> futureTRmap;
	public Future<List<TaxRate>> getFutureTRmap() {
		return futureTRmap;
	}

	public Future<List<MotorInsurance>> getFutureMImap() {
		return futureMImap;
	}

	

	

}
