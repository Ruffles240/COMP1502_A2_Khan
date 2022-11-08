package mru.tsc.model;


import mru.tsc.exceptions.NegativePrice;


/**
 * This abstract class provides a blueprint for it's child classes
 * 
 */
public abstract class Toy {

	private String SN;
	private String name = "";
	private String brand="";
	private double price=0.0;
	private int availableCount =0;
	private int ageAppropriate=0;
	private String[] toyElements;
	
	
	
	/**
	 * This is the constructor of toys
	 * @toy this is the string of info meant to be parsed by the toy constructor.
	 */
	
	public Toy(String toy) throws NegativePrice {
		
		splitElements(toy);
		
		setSN(toyElements[0]);
		setName(toyElements[1]);
		setBrandName(toyElements[2]);
		setPrice(toyElements[3]);
		setAvailable(toyElements[4]);
		setAge(toyElements[5]);
		
		NegativePrice c = new NegativePrice("Error, price cannot be negative.");
		if(price<0) {
			throw c;}
			
		
	}
	
	
	/**
	 * This splits the elements so they may be sent to the setters
	 * @return SN
	 */  
	
	public void splitElements(String toy) {
		toyElements = toy.split(";");
		
	}
	
	
	/**
	 * This sets the SN(Serial Number)
	 * @param toySn
	 */

	
	public void setSN(String toySN) {
		
		SN=  toySN;
		
	}
	/**
	 * This sets the name of the toy
	 * @param toyName
	 */
	
	public void setName(String toyName) {
		name=toyName;
		
		
	}
	/**
	 * This sets the brand name of the toy
	 * @param brand
	 */
	public void setBrandName(String toyBrand) {
		brand= toyBrand;
		
	}
	/**
	 * This sets the price of the toy
	 * @param toyPrice
	 */
	public void setPrice(String toyPrice) {
		
	price= Double.parseDouble(toyPrice);
		
	}
	/**
	 * This sets the availability of the toy
	 * @param available
	 */
	public void setAvailable(String available) {
		
		availableCount = Integer.parseInt(available);
	}
	/**
	 * This sets the age of the toy
	 * @param age
	 */
	public void setAge(String age) {
		
		ageAppropriate= Integer.parseInt(age);
	}
	/**
	 * This returns the SN(Serial Number)
	 * @return SN
	 */  
	
	public String getSN() {
		
		return SN;
	}
	
	/**
	 * This returns the name of the toy
	 * @return name
	 */  
	public String getName() {
		
		return name;
	}
	
	/**
	 * This returns the brand name of the toy
	 * @return brand
	 */  
	
	public String getBrandName(){
		
		return brand;
	}
	
	/**
	 * This returns the price of the toy
	 * @return price
	 */  
	
	public double getPrice() {
		
		return price;
	}
	/**
	 * This returns the age of the toy
	 * @return ageAppropriate
	 */  
	public int getAge() {
		
		return ageAppropriate;
		
	}
	
	/**
	 * This returns the number of toys available
	 * @return availableCount
	 */  
	
	public int getAvailable(){
		
		return availableCount;
	}
	
	/**
	 * This abstract provides a basis for toys to be saved back into algorithm-readable form
	 * @return SN
	 */  
	
	public abstract String saveToy();
	
	/**
	 * This abstract lets us access the toy elements from other classes.
	 * @return SN
	 */  
	
	
	public String[] getElements() {
		
		return toyElements;
	}
	/**
	 * This abstract lets us retrieve the category constant of each type of toy.
	 * @return SN
	 */  
	
	public abstract String getCategory();
}