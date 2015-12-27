package core;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import plainObjects.AccessoryInventory;
import plainObjects.CarInventory;
import plainObjects.CarStandingOrder;
import threads.CallableAI;
import threads.CallableCI;
import threads.CallableCSO;

public class ProcessingThreads {

	CallableAI callAI;
	CallableCI callCI;
	CallableCSO callCSO;
	
	Future<Map<String, AccessoryInventory>> futureAImap;
	Future<Map<String, CarInventory>> futureCImap;
	Future<ArrayList<CarStandingOrder>> futureCSOmap;
	

	public ProcessingThreads() {

		callAI= new CallableAI();
		callCI=new CallableCI();
		callCSO=new CallableCSO();

	}

	public void startThreads() {


		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		futureAImap=executor.submit(callAI);
		futureCImap=executor.submit(callCI);
		futureCSOmap=executor.submit(callCSO);
		//System.out.println("Futures Value-------------------");
		
	}

	public Future<Map<String, AccessoryInventory>> getFutureAImap() {
		return futureAImap;
	}

	public Future<Map<String, CarInventory>> getFutureCImap() {
		return futureCImap;
	}

	public Future<ArrayList<CarStandingOrder>> getFutureCSOmap() {
		return futureCSOmap;
	}

	

}
