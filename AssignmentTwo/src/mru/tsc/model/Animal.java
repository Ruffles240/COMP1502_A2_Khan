package mru.tsc.model;

import mru.tsc.exceptions.NegativePrice;

/**
 * This class defines the Animal subclass of Toy
 * 
 * 
 * 
 * 
 */



public class Animal extends Toy {
	
	/**
	 * This field is the category, which is a constant.
	 * 
	 * 
	 */


	final private String CATEGORY= "Animal";
	/**
	 * This field defines the size of the animal
	 * 
	 * 
	 */


	private char size;
	/**
	 * This is the constructor
	 * @return toy This is the string of info for the toy/animal object
	 */


	
	public Animal(String toy) throws NegativePrice{
		
		super(toy);
		setSize(this.getElements()[6].charAt(0));
	}
	
	/**
	 * This method retrieves the category as a String
	 * @return CATEGORY the category of the animal object differentiating it from other Toy objects.
	 */


	public String getCategory() {
		
		return CATEGORY;
	}
	/**
	 * This method sets the Toy's size
	 * @param this character represents the size of the toy
	 */

	public void setSize(char toySize) {
		
		size =  toySize;
	}
	/**
	 * This method overrides toString and gives us all the info about the object
	 * @return This is the string of info about the object.
	 */

	public String toString(){
		String toyDescription= String.format("\n***********************************************\n"+"Category: " +CATEGORY+" SN: "+ this.getSN()+" Name: " + this.getName()+" Brand: " +this.getBrandName()+
				" Price: %.2f " 
				+ " Available: " +this.getAvailable()+ " Age: " +this.getAge() + " Size: " + size+ "\n***********************************************\n", this.getPrice() );
		
		return toyDescription;
	}
	/**
	 * This method saves the toy into string that it can be read by our code again.
	 * @return This is the string meant to be written into files about the object.
	 */
	public String saveToy() {
		String toyFile=String.format(this.getSN()+";"+this.getName()+";"+this.getBrandName()+";%.2f"+";"+this.getAvailable()+";"+this.getAge()+";"+this.size, this.getPrice());
		return toyFile;
	}
}
