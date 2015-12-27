package threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import core.InventoryImpl;
import core.InventoryInterface;
import plainObjects.TaxRate;

public class CallableTR implements Callable<ArrayList<TaxRate>>{

    @Override
    public ArrayList<TaxRate> call() throws Exception {
        InventoryInterface loader=new InventoryImpl();
        
        return (ArrayList<TaxRate>) loader.readTaxRateFromCSV();
    }

}
