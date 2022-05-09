import java.util.*;
public class kawsCustoms {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean quitProgram = false;
		
		while (!quitProgram) {
		System.out.println("\t~^~^~^~^~^~^~^~^~^~^~^~");
		System.out.println("Hello! Welcome to kawsCustoms online store and customozations!");
		System.out.println("Our site has two seperate parts; Feel free to either explore our store section to interact with our current models in stock,");
		System.out.println("or design and create your own models! To get you started, enter 0 to access the store part of");
		System.out.println("the site, press 1 to enter the custom design section, or press 2 to exit the program.");
		System.out.println("\t~^~^~^~^~^~^~^~^~^~^~^~");

		boolean validInput;
		int storeSection = scan.nextInt();
		
		if (storeSection == 0) {
			boolean quitStore = false;
			Store newStore = new Store();
			
			while (!quitStore) {
			newStore.welcomeMenu(scan);
			newStore.optionsMenu(scan);
			
			validInput = false;
			
			while (!validInput) {
			System.out.println("Continue using store section? (Enter yes or no)");
			String userChoice = scan.next();
			userChoice = userChoice.trim();
			if (userChoice.equalsIgnoreCase("yes")) {
				quitStore= false;
				validInput = true;
			}
			else if (userChoice.equalsIgnoreCase("no")) {
				quitStore = true;
				validInput = true;
			}
			else {
				System.out.println("Invalid input.");
			}
			}
			}
		}
		else if (storeSection == 1) {
			Design newDesign = new Design();
			newDesign.printInstructions(scan);
		}
		else if (storeSection == 2) {
			System.out.println("Thank you so much for using kawsCustoms. We hope you enjoyed your experience.");
			quitProgram = true;
		}
		else {
			System.out.println("Please enter a valid input.");
		}
		}
		
		
	}
}
