package mru.tsc.model;
import mru.tsc.exceptions.*;

/**
 * This class extends Toys and defines Board Game objects
 * 
 */
public class BoardGame extends Toy {
	
	final private String CATEGORY= "Board Game";
	
	private int minNum;
	private int maxNum;
	private String designer;
	private String ageRange;
	
	
	/**
	 * This is the constructor for Board Game objects.
	 * It also contains a custom exception meant to make it incapable of producing objects where the minimum  players is greater than maximum.
	 * @param toy this string is meant to be parsed into the various fields of info
	 * 
	 */
	
	public BoardGame(String toy) throws IncompatiblePlayers, NegativePrice {
		super(toy);
		parsePlayers(this.getElements()[6]);
		setDesigner(this.getElements()[7]);
		setAgeRange(minNum,maxNum);
		
		
				IncompatiblePlayers c = new IncompatiblePlayers("Error, minimum cannot be greater than maximum");
				if(minNum>maxNum) {
					throw c;}
					
				
			
		
	
	}
	
	/**
	 * This returns the category
	 * @return CATEGORY
	 */
	public String getCategory() {
		
		return CATEGORY;
	}
	/**
	 * This sets the designer field
	 * @param
	 */
	private void setDesigner(String maker) {
		designer=maker;
		
	}
	/**
	 * This gets the designer field
	 * @param designer
	 */
	private String getDesigner(){
		
		return designer;
	}
	
	
	/**
	 * This parses the player range into two values.
	 * @param players this is the players as a range separated by "-"
	 */
	public void parsePlayers(String players){
		String[] minMax = players.split("-");
		int min = Integer.parseInt(minMax[0]);
		int max = Integer.parseInt(minMax[1]);
		
		setMin(min);
		setMax(max);
		
	}
	/**
	 * This sets the max players
	 * @param max
	 */
	private void setMax(int max) {
		maxNum=max;
		
	}
	/**
	 * This sets the minimum players
	 * @param min
	 */
	public void setMin(int min) {
		minNum=min;
		
		
	}
	/**
	 * This sets puts the players back into an age range.
	 * @param
	 */
	private void setAgeRange(int min, int max) {
	 ageRange= min +"-"+max; 
		
	}
	
	/**
	 * This returns the age range
	 * @return ageRange
	 */
	private String getAgeRange() {
		
		return ageRange;
	}
	
	/**
	 * This overrides toString and provides object info.
	 * @return toyDescription
	 */

	public String toString(){
		String toyDescription= String.format(""
				+ "***********************************************************\n"+"Category: " +CATEGORY+"SN: "+ this.getSN()+" Name: " + this.getName()+" Brand: " +this.getBrandName()+
				" Price: %.2f"
				+ " Available: " +this.getAvailable()+ " Age: " +this.getAge()+" Age Range: "+ageRange+" designer: " +designer+"\n************************************************************************", this.getPrice());
		
		return toyDescription;
	}
	/**
	 * This is meant to provide data to be saved and reread by the algorithm.
	 * @return toyFile
	 */

	public String saveToy() {
		String toyFile=String.format(this.getSN()+";"+this.getName()+";"+this.getBrandName()+";%.2f"+";"+this.getAvailable()+";"+this.getAge()+";"+this.getAgeRange()+";"
				+designer, this.getPrice());
		
		return toyFile;
	}
	
	
}