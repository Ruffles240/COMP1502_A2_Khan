package mru.tsc.exceptions;
/**
 * 
 * This class creates a custom exception for the BoardGame class.
 * 
 *
 */


public class NegativePrice extends Exception {
	
	
	/**
	 * This constructs the Exception
	 * 
	 */
	public NegativePrice(String message) {
	
			super(message);
			
	}
}
