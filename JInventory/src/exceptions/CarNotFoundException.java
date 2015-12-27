package exceptions;

@SuppressWarnings("serial")
public class CarNotFoundException extends Exception {
	

	String message;
	
	public CarNotFoundException(String key) {
		
		
		super(key);
	}
	
	@Override
	public String toString() {
		
		return message;
	}

	@Override
	public String getMessage() {
		
		return "message";
	}
}
