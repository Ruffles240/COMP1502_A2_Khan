package mru.tsc.model;

import mru.tsc.exceptions.NegativePrice;
/**
 * This class builds Figure objects(From superclass Toy)
 * @return toyDescription
 */

public class Figure extends Toy {

	final private String CATEGORY= "FIGURE";
	 private char classification;
	 
	 
	 
	 /**
		 * This is the constructor
		 * @param toy the string to be parsed into the object
		 * @throws NegativePrice This occurs if the price of the object is negative.
		 */


	
	public Figure(String toy) throws NegativePrice{
		
		super(toy);
		setClassification(this.getElements()[6]);
	}
	/**
	 * This gets the category of the object
	 * @return CATEGORY
	 */

	public String getCategory() {
		
		return CATEGORY;
	}
	
	/**
	 * This method sets the Classification
	 * @param figureClassification
	 */

	public void setClassification(String figureClassification) {
		classification=figureClassification.charAt(0);
		
		
	}
	/**
	 * This method gets the classification
	 * @return classification
	 */

	public char getClassification() {
		
		return classification;
	}
	
	/**
	 * This overrides toString and provides object info.
	 * @return toyDescription
	 */

	public String toString(){
		String toyDescription=("\n*************************************\n"+ "Category: " +CATEGORY+" SN: "+ this.getSN()+" Name: " + this.getName()+" Brand: " +this.getBrandName()+
				" Price: " +this.getPrice()
				+ " Available: " +this.getAvailable()+ " Age: " +this.getAge() + " Classification: " + this.classification+ "\n*************************************" );
		
		return toyDescription;
	}
	
	/**
	 * This is meant to provide data to be saved and reread by the algorithm.
	 * @return toyFile
	 */

	public String saveToy() {
		String toyFile=String.format(this.getSN()+";"+this.getName()+";"+this.getBrandName()+";%.2f"+";"+this.getAvailable()+";"+this.getAge()+";"+classification, this.getPrice());
		return toyFile;
	}
}
