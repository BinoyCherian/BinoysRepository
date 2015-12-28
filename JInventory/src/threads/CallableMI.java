package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import core.InventoryImpl;
import core.InventoryInterface;
import plainObjects.MotorInsurance;

public class CallableMI implements Callable<List<MotorInsurance>> {

	InventoryInterface loader = new InventoryImpl();
	List<MotorInsurance> insuranceList = new ArrayList<>();

	@Override
	public List<MotorInsurance> call() throws Exception {

		insuranceList = loader.readMotorInsuranceFromCSV();
		return insuranceList;
	}

}
