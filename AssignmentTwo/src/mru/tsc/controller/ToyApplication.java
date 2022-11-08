package mru.tsc.controller;
import mru.tsc.model.*;
import mru.tsc.view.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import mru.tsc.exceptions.*;

/**
 * This class drives the logic behind the Toy Store Application
 * 
 * 
 * 
 * 
 */


public class ToyApplication {
	
	
	static Scanner keyboard= new Scanner(System.in);

/**
 * This method creates initializes the controls, opens the Toy File, and passes the data onto the main menu.
 * 
 * 
 * 
 * 
 */


	public static void main(String[] args) throws IOException, IncompatiblePlayers, NegativePrice{
		
		
	 File toys = new File("src/toys.txt");
	 if( toys.exists()){
	 Scanner toyList= new Scanner(toys);
	 
	 
	 ArrayList<Toy> toyCatalogue = toySorter(toyList);
	
	
	
	toyList.close();
	 ToyView.mainMenu(toyCatalogue);
		
	
		
	}
	 
	 else {
		 
		 System.out.println("Sorry, we cannot find our catalogue at this moment.");
	 }
	 
}
	
	
	
	/**
	 * This method sorts the scanner data into an ArrayList of the various kinds of Toy objects.
	 * 
	 * @param toyList This is the scanner of the file we took in.
	 * 
	 * 
	 */

	public static ArrayList<Toy> toySorter(Scanner toyList) throws IncompatiblePlayers, NegativePrice {
		
		ArrayList<Toy> toyCatalogue = new ArrayList<Toy>();
		
		while(toyList.hasNextLine()) {
		String nextToy =toyList.nextLine();
		int toyNumber = (nextToy.charAt(0));
		toyNumber-=48;	
		if(toyNumber>=0&&toyNumber<=1) {
			Figure toy= new Figure(nextToy);
			toyCatalogue.add(toy);
		}
		
		else if(toyNumber>=2&&toyNumber<=3) {
			Animal toy= new Animal(nextToy);
			toyCatalogue.add(toy);
		}
		
		else if(toyNumber>=4&&toyNumber<=6) {
			Puzzle toy= new Puzzle(nextToy);
			toyCatalogue.add(toy);
			
		}
		
		else if(toyNumber>=7&&toyNumber<=9) {
			BoardGame toy = new BoardGame(nextToy);
			toyCatalogue.add(toy);
		}
		
		}
		return toyCatalogue;
		
	}

	
	

	/**
	 * This method creates a new toy object with user input
	 * 
	 * @param toyCatalogue This is the ArrayList of Toy objects we have created
	 * 
	 * 
	 */






	public static void addToy(ArrayList<Toy>toyCatalogue) throws FileNotFoundException, NegativePrice {
			String newToySN;
			String newToyName;
			String newToyBrand;
			double newToyPrice = 0.00;
			int newToyAvailable = 0;
			int newToyAge = 0;
			boolean checkPrice=false;
			boolean checkCount=false;
			boolean checkAvailable=false;
			boolean checkAge=false;
			boolean checkMinPlayer = false;
			boolean checkMaxPlayer = false;
			
			
			try {
			
			newToySN = SNChecker();
			while(newToySN==null) {
				newToySN = SNChecker();
			}
		
			for (Toy a:toyCatalogue) {
				if(a.getSN().equals(newToySN)){
					System.out.println("Sorry, this SN is taken");
					addToy(toyCatalogue);
					break;
				}
				
			}
			
			
			System.out.println("Please input the new Toy's name.");
			
			newToyName= keyboard.nextLine();
			
			System.out.println("Brand: ");
			newToyBrand = keyboard.nextLine();
			while(checkPrice==false) {
			try{	
				
				System.out.println("Price: ");
				String enteredPrice=keyboard.nextLine();
				newToyPrice=Double.parseDouble(enteredPrice);
				checkPrice=true;
				
				}
				
			
			
			catch(Exception e){
				System.out.println("Sorry, this is an invalid entry. Please enter the price like this: '00.00' ");
				
			}
			}
			System.out.println("Available: ");
			
			String enteredAvailable=keyboard.nextLine();
			while(checkAvailable==false) {
			try {
			newToyAvailable =Integer.parseInt(enteredAvailable);
			checkAvailable=true;
			}
			catch(Exception e) {
				System.out.println("Sorry, this is an invalid entry. Please enter the availability as an integer: ");
				enteredAvailable=keyboard.nextLine();
			}
			
			
			}
			
			
			System.out.println("What is the recommended age?");
			String enteredAge=keyboard.nextLine();
			while(checkAge==false) {
				try {
					
				newToyAge =Integer.parseInt(enteredAge);
				checkAge=true;
				}
				catch(Exception e) {
					System.out.println("Sorry, this is an invalid entry. Please enter the age as an integer: ");
					enteredAge=keyboard.nextLine();
				}
				
				
				}
			
			
				int toyNumber = (newToySN.charAt(0));
			toyNumber-=48;
			
			
			if(toyNumber>=0&&toyNumber<=1) {
				
				System.out.println("Please type A for Action, D for Doll, or H for Historical: ");
				String newToyClass = keyboard.nextLine();
				char figureClassification = newToyClass.toUpperCase().charAt(0);
				
				
				
				
				while(newToyClass.length()!=1||(figureClassification!='A'&&figureClassification!='D'&&figureClassification!='H')) {
					System.out.println("Sorry, please choose either A, D, or H.");
					newToyClass=keyboard.nextLine();
					figureClassification = newToyClass.toUpperCase().charAt(0);
				}
				
				
				
				String figureEntry= String.format(newToySN+";"+newToyName+";"+newToyBrand+";"+"%.2f;"+
				
						newToyAvailable+";"+newToyAge+";"+figureClassification, newToyPrice);
				
				Figure addFigure= new Figure(figureEntry);
					toyCatalogue.add(addFigure);
					System.out.println(addFigure);
					
					System.out.println("This item has been entered. Press enter to return to the main menu");
					keyboard.nextLine();
					ToyView.mainMenu(toyCatalogue);
			}
			
			
			
			else if(toyNumber>=2&&toyNumber<=3) {
				
				System.out.println("Type S for Small, M for medium, or L for Large: ");
				String newToySize = keyboard.nextLine();
				char animalSize = newToySize.toUpperCase().charAt(0);
				while(newToySize.length()!=1||(animalSize!='S'&&animalSize!='M'&&animalSize!='L')) 
				
				{
					System.out.println("Sorry, please choose either S, M, or L.");
					newToySize=keyboard.nextLine();
					animalSize = newToySize.toUpperCase().charAt(0);
				}
				String animalEntry= String.format(newToySN+";"+newToyName+";"+newToyBrand+";"+"%.2f;"+
				
						newToyAvailable+";"+newToyAge+";"+animalSize, newToyPrice);
				
				Animal addAnimal= new Animal(animalEntry);
					toyCatalogue.add(addAnimal);
					
					System.out.println(addAnimal);
					
					System.out.println("This item has been entered. Press enter to return to the main menu");
					keyboard.nextLine();
					ToyView.mainMenu(toyCatalogue);
				
			}
			
			else if(toyNumber>=4&&toyNumber<=6) {
			
				System.out.println("Type M for Action, C for Doll, L for, T for, or R for: ");
				String newToyType = keyboard.nextLine();
				char puzzleType = newToyType.toUpperCase().charAt(0);
				while(newToyType.length()!=1||(puzzleType!='M'&&puzzleType!='C'&&puzzleType!='L'&&puzzleType!='T'&&puzzleType!='R')) {
					System.out.println("Sorry, please choose either M, C, L, T or R.");
					newToyType=keyboard.nextLine();
					puzzleType = newToyType.toUpperCase().charAt(0);
				}
				String puzzleEntry= String.format(newToySN+";"+newToyName+";"+newToyBrand+";"+"%.2f;"+
				
						newToyAvailable+";"+newToyAge+";"+puzzleType, newToyPrice);
				
				Puzzle addPuzzle= new Puzzle(puzzleEntry);
					toyCatalogue.add(addPuzzle);
					System.out.println(addPuzzle);
					System.out.println("This item has been entered. Press enter to return to the main menu");
					keyboard.nextLine();
					ToyView.mainMenu(toyCatalogue);
			}
			
			else if(toyNumber>=7&&toyNumber<=9) {
				
				int minPlayer=0;
				int maxPlayer=0;
					System.out.println("	Minimum players: "); 
					String minInput = keyboard.nextLine();
					while (checkMinPlayer==false) {
						try { minPlayer = Integer.parseInt(minInput);
								checkMinPlayer=true;
						
					}
					catch(Exception e) {
							System.out.println("	Please type an Integer.\n Minimum Players: ");
							minInput = keyboard.nextLine();
						}
					}
					
					
					System.out.println("	Maximum Players: ");
					String maxInput = keyboard.nextLine();
					while (checkMaxPlayer==false) {
						try { maxPlayer = Integer.parseInt(maxInput);
								checkMaxPlayer=true;
						
					}
					catch(Exception e) {
						System.out.println("Please type an Integer.\n Maximum Players: ");
						maxInput = keyboard.nextLine();
						}
					}
					
					
					System.out.println("	Designers(Separate with ','):	");
					try {
					String designer = keyboard.nextLine();
					String boardGameEntry= String.format(newToySN+";"+newToyName+";"+newToyBrand+";"+"%.2f;"+
							
						newToyAvailable+";"+newToyAge+";"+minPlayer+"-"+maxPlayer+";"+designer, newToyPrice);
				
					BoardGame addBoardGame= new BoardGame(boardGameEntry);
					toyCatalogue.add(addBoardGame);
					System.out.println(addBoardGame);
					System.out.println("This item has been entered. Press enter to return to the main menu");
					keyboard.nextLine();
					ToyView.mainMenu(toyCatalogue);}
					
					catch(IncompatiblePlayers e){
						
						System.out.println(e.getMessage()+"/nPlease press enter to return to the main menu");
						keyboard.nextLine();
						ToyView.mainMenu(toyCatalogue);
						
						
					}
					
			}	}
			
			catch(NegativePrice e) {
				
				System.out.println(e.getMessage());
				System.out.println("Press enter to return to main menu");
				keyboard.nextLine();
				ToyView.mainMenu(toyCatalogue);
			}
		
	}
	
	
	/**
	 * This method removes a toy
	 * 
	 * @param toyCatalogue This is the ArrayList of Toy objects we have created
	 * 
	 * 
	 */


	public static void removeToy(ArrayList<Toy> toyCatalogue) throws FileNotFoundException, NegativePrice {
	
		boolean productFound=false;
		
		System.out.println("Please type in the SN of the product you wish to remove: ");
		
		String removeProductSN=SNChecker();
		
		while(removeProductSN==null) {
			
			System.out.println("Sorry, valid SN's only");
			removeProductSN=SNChecker();
		}
		
	
		for(Toy a:toyCatalogue) {
			if(a.getSN().equals(removeProductSN)){
				System.out.println("This item has been removed\n"
						+ a.toString()+"\n Press Enter to go back to the main menu");
				
				toyCatalogue.remove(a);
				productFound=true;
				keyboard.nextLine();
				ToyView.mainMenu(toyCatalogue);
				break;
				
			}
			else {
				continue;
			}
		}
		
		if(productFound=false) {
			System.out.println("Sorry, we could not locate the product to remove. Taking you back to the Main Menu");
			
			ToyView.mainMenu(toyCatalogue);
			
		}
		
		
	}

	/**
	 * This method searches and purchases toys by SN number
	 * 
	 * @param toyCatalogue This is the ArrayList of Toy objects we have created
	 * 
	 * 
	 */



	public static void searchToySN(ArrayList<Toy> toyCatalogue) throws FileNotFoundException, NegativePrice{
			
			boolean toyFound=false;
				
			String SN = null;
			
			
			while(SN==null) {
				
				SN = SNChecker();
			}
			
			
			for(Toy a: toyCatalogue) {
				
				if(a.getSN().equals(SN)) {
					
					
				System.out.println(a.toString());
				
				System.out.println("Would you like to purchase this? Y/N:  ");
			
					
					
				String purchaseDecision= keyboard.nextLine().toUpperCase();
				while(purchaseDecision.length()!=1||(purchaseDecision.charAt(0)!='Y'&&purchaseDecision.charAt(0)!='N')) {
					
					System.out.println("Sorry, only type Y or N:	");
					
					purchaseDecision=keyboard.nextLine().toUpperCase();
					
				}
				
				
				if(purchaseDecision.charAt(0)=='Y') {
				a.setAvailable(Integer.toString(a.getAvailable()-1));
				System.out.println("Purchased! Thank you for your contribution.");
				toyFound=true;
				
				keyboard.nextLine();
				ToyView.mainMenu(toyCatalogue);
				
				break;
			
				}
				else {
					System.out.println("Item was not purchased. Please press enter to return to the main menu");
					keyboard.nextLine();
					ToyView.mainMenu(toyCatalogue);
				}
				}
				
				
				}
				if(toyFound==false){
					
					System.out.println("Sorry we couldn't find your toy. Big L.");
					
				}
				
					
				System.out.println("Please press Enter to return to the Main Menu.");
				
				keyboard.nextLine();
				ToyView.mainMenu(toyCatalogue);
					
			
				}


	/**
	 * This method sorts and displays toys by name, then provides the option to purchase
	 * 
	 * @param toyCatalogue This is the ArrayList of Toy objects we have created
	 * 
	 * 
	 */


		
		public static void searchToyName(ArrayList<Toy> toyCatalogue) throws FileNotFoundException, NegativePrice {
			System.out.println("Please input the name of the toy you are looking for: ");
			String input=keyboard.nextLine().toLowerCase();
			int listSize=0;
			boolean toyFound=false;
			
			ArrayList<Toy> matchingToys= new ArrayList<Toy>();
			
		
			for(Toy a:toyCatalogue) {
				if((a.getName().toLowerCase()).contains(input)){
					toyFound=true;
					
					matchingToys.add(a);
					
				}}
				
			if(toyFound==false) {
				System.out.println("Sorry we couldn't find any of your toys. Big L. "
						+ "\nAnyway, press Enter to go back to the Main Menu.");
				
				keyboard.nextLine();
				ToyView.mainMenu(toyCatalogue);
			}
			
			else {
				System.out.println("Here are all the toys matching your description!."
						+ "\n Please type the number that you wish to purchase.");
				for(int i=0; i<matchingToys.size();i++) {
					
					System.out.println("("+(i+1)+")"+ matchingToys.get(i).toString());
					listSize=i+2;
					}
				}
				System.out.println("("+listSize+")		Return to the main menu");
					
					String purchaseInput = keyboard.nextLine();
					
					boolean validPurchase = false;
					
					while(validPurchase==false){
						try { int purchaseChoice = Integer.parseInt(purchaseInput);
						
								if(purchaseChoice==listSize) {
								ToyView.mainMenu(toyCatalogue);}
							
							
							Toy purchasedToy = matchingToys.get(purchaseChoice-1);
								purchasedToy.setAvailable(Integer.toString(purchasedToy.getAvailable()-1));
							
							validPurchase=true;
							
							System.out.println("Purchased!! Thank you!\n"
									+ "Press enter to return to the main menu");
							
							
							keyboard.nextLine();
							ToyView.mainMenu(toyCatalogue);
						}
						
						catch(Exception e) {
							
							System.out.println("Sorry, not a valid choice");
							purchaseInput=keyboard.nextLine();
						}
						
					}
					
				}
				
			
			
		/**
		 * This method sorts and displays the toys by type, providing a purchase option.
		 * 
		 * @param toyCatalogue This is the ArrayList of Toy objects we have created
		 * 
		 * 
		 */


		
			
			
		public static void searchType(ArrayList<Toy> toyCatalogue) {
			ArrayList<Toy> matchingType= new ArrayList<Toy>();
			
			int listSize=0;
			
			int type= ToyView.typeSearchMenu();
								if(type==1) {
										for(Toy a:toyCatalogue) {	
										if(a.getCategory().contains("Figure")) {
										matchingType.add(a);}
									}
								}
								else if(type==2) {
										for(Toy a:toyCatalogue) {	
										if(a.getCategory().contains("Animal")) {
										matchingType.add(a);}
									}		
								}					
								else if(type==3) {
										for(Toy a:toyCatalogue) {
										if(a.getCategory().contains("Board Game")) {
										matchingType.add(a);}
									}	
								}
								else if(type==4) {
										for(Toy a:toyCatalogue) {
										if(a.getCategory().contains("Puzzle")) {			
										matchingType.add(a);
										}
								}
								}
								
								
								for(int i=0;i<matchingType.size();i++){
								System.out.println("(" +(i+1)+")"+matchingType.get(i).toString());
								listSize=i+2;
								}
								System.out.println("("+listSize+")		Return to the main menu");
							
								String purchaseInput = keyboard.nextLine();
								boolean validPurchase = false;
								while(validPurchase==false){
									try { int purchaseChoice = Integer.parseInt(purchaseInput);
										if(purchaseChoice==listSize) {
											ToyView.mainMenu(toyCatalogue);
											
										}
										Toy purchasedToy = matchingType.get(purchaseChoice-1);
											purchasedToy.setAvailable(Integer.toString(purchasedToy.getAvailable()-1));
										validPurchase=true;
										System.out.println("Purchased!! Thank you!\n"
												+ "Press enter to return to the main menu");
										
										
										keyboard.nextLine();
										ToyView.mainMenu(toyCatalogue);
									}
									catch(Exception e) {	
										System.out.println("Sorry, not a valid choice");
										purchaseInput=keyboard.nextLine();
									}
								}
					
		}	
	
		/**
		 * This method validates SN numbers.
		 * 
		 * @param toyCatalogue This is the ArrayList of Toy objects we have created
		 * 
		 * 
		 */


	
	
		public static String SNChecker() {
				System.out.println("Please input a SN: ");
		
				Scanner keyboard=new Scanner(System.in);
					String SN= keyboard.nextLine();
		
						if(SN.length()==10) {
		
							for(char a:SN.toCharArray()) {
								if( Character.isDigit(a)==true){
									continue;
				
								}
								else {
									System.out.println("Sorry, valid SN's only, valid SN's have 10 digits. Please Try again.");
											return null;
								}
							}
							return SN;
							}
		
							else {
								System.out.println("Sorry, valid SN's only, valid SN's have 10 digits. Please try again");
									return null;
							}
		
		
				}
	

						}
	