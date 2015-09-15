package Exceptions;

public class AppException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException (String errorMsg){
		super(errorMsg);
	}
 
	public AppException(String errorMsg, Throwable cause){
		
		super(errorMsg,cause);
	}
}
