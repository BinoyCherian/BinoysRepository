package plainObjects;

public class TaxRate {
    String state;
    Long taxRate;
    
    
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Long getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }
    
    @Override
    public String toString() {
    	
    	return "State: "+state+"\nTaxRate: "+taxRate;
    }

}
