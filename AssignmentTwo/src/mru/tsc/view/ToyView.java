package mru.tsc.view;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.controller.*;
import mru.tsc.exceptions.NegativePrice;
import mru.tsc.model.*;
/**
 * This class contains the majority of user facing information.
 * 
 */  

public class ToyView {
	
	static Scanner keyboard = new Scanner(System.in);
	/**
	 * This method displays and controls the main menu, taking user input to perform other tasks
	 * @param toyCatalogue the ArrayList of Toy objects.
	 */  
	
	
	
	public static void mainMenu(ArrayList<Toy> toyCatalogue) throws FileNotFoundException, NegativePrice{
		
		System.out.println("********************************\nWelcome to Toy Store"
				+ " Company!!\n********************************");
		 
			
			System.out.println("Please select one of the following options"
					+ "\n	1. Search Inventory and Purchase Toy "
					+ "\n	2. Add a New Toy"
					+ "\n	3. Remove a Toy "
					+ "\n	4. Save and Exit");		
			System.out.println("Type your choice: ");
			String input =keyboard.nextLine();
			try {Integer.parseInt(input);
			
			}
			
			
				catch(Exception e) {
				
				System.out.println("Sorry, please input integers only.");
				
				mainMenu(toyCatalogue);
			}
			
			if(input.length()==1&&(Integer.parseInt(input)>=1)&&(Integer.parseInt(input)<=5)) {
			
			int choice = Integer.parseInt(input);
		
			switch(choice) {
			
			case 1 :
				searchToy(toyCatalogue);
				
				break;
			
			case 2:
				
				ToyApplication.addToy(toyCatalogue);
				break;
				
			case 3:
				ToyApplication.removeToy(toyCatalogue);
				break;
				
			case 4:
				PrintWriter toys = new PrintWriter("src/toys.txt");
				for(Toy a:toyCatalogue) {
					toys.println(a.saveToy());
				}
				
				toys.close();
				
				System.out.println("Saving your data");
				
				System.out.println("******Thank you for shopping with us!******");
				System.exit(choice);
				
				break;
			
				
			default: 
				
				System.out.println("Sorry, not a valid input.");
				searchToy(toyCatalogue);
				break;
				
			}
				}
			
			else {
				
				System.out.println("Sorry, not a valid input.");
				mainMenu(toyCatalogue);
			}
			
			}
			
			
			
	/**
	 * This method displays a menu allowing the user to decide how they want to search through the list of toys
	 * @param toyCatalogue
	 */  
	
		
		
	
	public static void searchToy(ArrayList<Toy> toyCatalogue) {
		System.out.println("********************************\nPlease select a method of searching"
				+ "\n********************************"
				+ "\n	1. Search by SN number."
				+ "\n	2. Search by name."
				+ "\n	3. Search by Type");
		boolean toyFound=false;
		
		System.out.print("\n	Type your choice: ");
		
		String input = keyboard.nextLine();
		
		try {
			
			Integer.parseInt(input);
		
		int choice = Integer.parseInt(input);
	
		switch(choice) {
		
		case 1:
			ToyApplication.searchToySN(toyCatalogue);
			break;
		case 2:
			ToyApplication.searchToyName(toyCatalogue);
			break;
			
		case 3:
			ToyApplication.searchType(toyCatalogue);
			break;
			
		default: 
			
			System.out.println("Sorry, not a valid input.");
			searchToy(toyCatalogue);
			break;
		
		}}
		catch(Exception e) {
			
			System.out.println("Sorry, please input integers only.");
			
			searchToy(toyCatalogue);}}
	
	/**
	 * This method provides a menu for users to search through toys by type
	 * @type this goes back to the controller, giving the users input to be directed.
	 */  
	
		
	public static int typeSearchMenu() {
			System.out.println("\n********************************\nPlease select a type of "
					+ "toy you wish to purchase.\n********************************\n"
					+ "\n	1. A figurine."
					+ "\n	2. An animal doll."
					+ "\n	3. A board game."
					+ "\n	4. A Puzzle.");
			
			System.out.print("\n	Type your choice: ");
			int type=0;
			String searchedType = keyboard.nextLine();
			boolean validType=false;
			
		
			while(validType==false) {
				try {
					type = Integer.parseInt(searchedType);
						if(type<=4&&type>=1) {
							validType=true;
							System.out.println("Here are all the toys of that type! Please select the one you wish to purchase.");
							
						
			
							}
						
						
						else {
							System.out.println("Sorry, please select one of these 4 types only");
							searchedType=keyboard.nextLine();
							
							
						}
				}
						
						catch(Exception e){
							
							System.out.println("Sorry, please select one of these 4 types only");
							searchedType=keyboard.nextLine();
							
			
						}
			}
		
			return type;
	
			}
		

}
			
