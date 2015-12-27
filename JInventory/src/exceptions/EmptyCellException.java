package exceptions;

@SuppressWarnings("serial")
public class EmptyCellException extends Exception{
	
	String message;
	
	
	public EmptyCellException(String message)
	{
		super(message);
		this.message=message;
	}
	
	@Override
	public String toString() {
		
		return message;
	}

	@Override
	public String getMessage() {
		
		return message+" cell empty ";
	}
}
