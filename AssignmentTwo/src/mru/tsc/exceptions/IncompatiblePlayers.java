package mru.tsc.exceptions;


/**
 * 
 * This class creates a custom exception for the BoardGame class.
 * 
 *
 */

public class IncompatiblePlayers extends Exception{

	
	/**
	 * This constructs the Exception
	 * 
	 */
	public IncompatiblePlayers(String message) {
		super(message);
		
	}
	
}
