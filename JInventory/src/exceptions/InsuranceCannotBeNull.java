package exceptions;

@SuppressWarnings("serial")
public class InsuranceCannotBeNull extends Exception {
	
	String message;

	public InsuranceCannotBeNull(String string) {
		super(string);
		message=string;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}

}
