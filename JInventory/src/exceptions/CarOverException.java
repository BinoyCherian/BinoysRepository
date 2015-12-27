package exceptions;

@SuppressWarnings("serial")
public class CarOverException extends Exception {
	
	String message;
	
	public CarOverException(String message) {
		
		super(message);
		this.message=message;
	}
	
	@Override
	public String toString() {
		
		return message+" in the inventory is over";
	}
	
	@Override
	public String getMessage() {
		
		return message+" in the inventory is over";
	}

}
