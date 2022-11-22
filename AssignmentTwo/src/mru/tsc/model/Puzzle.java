package mru.tsc.model;

import mru.tsc.exceptions.NegativePrice;

public class Puzzle extends Toy {

	final private String CATEGORY = "PUZZLE";
	private char puzzleType;
	
	
	/**
	 * This is the constructor for Puzzle objects(Extending Toy)
	 * @param toy
	 * @throws NegativePrice This occurs if the price of the object is negative.
	 */
	
	
	public Puzzle(String toy) throws NegativePrice {
		super(toy);
		setPuzzleType(this.getElements()[6].charAt(0));
	}
	/**
	 * This method gets the category.
	 * @return CATEGORY
	 */
	
	public String getCategory() {
		
		return CATEGORY;
	}
	
	/**
	 * This method sets the puzzle type
	 * @param type
	 */
	
	private void setPuzzleType(char type) {
		puzzleType =type;
		
	}
	/**
	 * This method gets the Puzzle type.
	 * @return puzzleType
	 */
	public char getPuzzleType() {
		return puzzleType;
		}
	
	
	/**
	 * This overrides toString and provides object info.
	 * @return toyDescription
	 */


	public String toString(){
		String toyDescription=String.format("\n**************************************************************\n" +"Category: " + CATEGORY+ " SN: "+ this.getSN()+" Name: " + this.getName()+" Brand: " +this.getBrandName()+
				" Price: %.2f" 
				+ " Available: " +this.getAvailable()+ " Age: " +this.getAge()+ " Type: " + puzzleType+"\n*****************************************************************", this.getPrice());
		
		return toyDescription;
	}
	
	/**
	 * This is meant to provide data to be saved and reread by the algorithm.
	 * @return toyFile
	 */
	
	public String saveToy() {
		String toyFile= String.format(this.getSN()+";"+this.getName()+";"+this.getBrandName()+";%.2f"+";"+this.getAvailable()+";"+this.getAge()+";"+puzzleType, this.getPrice());
		return toyFile;
	}
	
}