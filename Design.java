import java.util.*;

public class Design {
	
	public void printInstructions(Scanner scan) {
		
		System.out.println("What kind of shoe would you like?");
		System.out.println("Please enter '1' for Running Shoes, or '2' for Basketball Shoes.");
		int num = scan.nextInt();
		
		while (num !=1 || num != 2) {
		if (num == 1) {
			System.out.println("You have selected Running Shoes.");
			RunningShoe newShoe = new RunningShoe();
			System.out.println("");
			System.out.println("Information about your design includes:");
			System.out.println("");
			newShoe.printInfo();
			System.out.println("");
			System.out.println("Please start building your shoes to your specifications");
			System.out.println("");
			
			newShoe.setName(scan);
			newShoe.setSize(scan);
			newShoe.setGender(scan);
			
			newShoe.setPrimaryColor(scan);
			newShoe.setSecondaryColor(scan);
			
			newShoe.setSuggestedMileCapacity(scan);
			newShoe.setSuggestedTerrainUsage(scan);
			
			System.out.println("");
			System.out.println("Here are the order specifications for your shoes");
			newShoe.printInfo();
			break;
		}
		
		else if (num == 2) {
			System.out.println("You have selected Basketball Shoes.");
			BasketballShoe newShoe = new BasketballShoe();
			System.out.println("");
			System.out.println("Information about your design includes:");
			System.out.println("");
			newShoe.printInfo();
			System.out.println("");
			System.out.println("Please start building your shoes to your specifications\n");
	
			
			newShoe.setName(scan);
			newShoe.setSize(scan);
			newShoe.setGender(scan);
			
			newShoe.setPrimaryColor(scan);
			newShoe.setSecondaryColor(scan);
			
			newShoe.setRetro(scan);
			newShoe.setHighTop(scan);
			
			System.out.println("");
			System.out.println("Here are the order specifications for your shoes");
			newShoe.printInfo();	
			break;
		}
		
		else {
			System.out.println("Please select a valid number.");
		
		 num = scan.nextInt();
		}
	
		
		
	}
		
	}

	public static void main (String[] args) {
		

	}
}
