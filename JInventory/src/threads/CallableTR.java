package threads;

import java.util.List;
import java.util.concurrent.Callable;

import core.InventoryImpl;
import core.InventoryInterface;
import plainObjects.TaxRate;

public class CallableTR implements Callable<List<TaxRate>> {

	@Override
	public List<TaxRate> call() throws Exception {
		InventoryInterface loader = new InventoryImpl();

		return loader.readTaxRateFromCSV();
	}

}
