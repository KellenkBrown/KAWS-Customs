import java.util.*;
public class BasketballShoe extends Shoe {

	public BasketballShoe() {
		retro = false;
		highTop = false;
	}
	
	public BasketballShoe(String name, double price, String primaryColor, String secondaryColor, boolean retro, boolean highTop) {
		this.setName(name);
		this.setPrice(price);
		this.setPrimaryColor(primaryColor);
		this.setSecondaryColor(secondaryColor);
		this.retro = retro;
		this.highTop = highTop;
	}
	
	private boolean retro;
	private boolean highTop;
	private static final String toungeLogo = "K.A.W. Basketball";
	
	
	public static String getLgo() {
		return toungeLogo;
	}
	
	
	public boolean isRetro() {
		return retro;
	}

	public void setRetro(Scanner scan) {
		boolean validInput = false;
		
	
		while (!validInput) {
		System.out.println("Is this shoe a retro? (Enter yes or no):");
		String response = scan.next();
		if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase("Y")) {
			retro = true;
			validInput = true;
		}
		else if (response.equalsIgnoreCase("No") || response.equalsIgnoreCase("N")) {
			retro = false;
			validInput = true;
		}
		else {
			System.out.println("Invalid Input. Please try again.");
		}
		}
	}

	public boolean isHighTop() {
		return highTop;
	}

	public void setHighTop(Scanner scan) {
		boolean validInput = false;
		
		while (!validInput) {
			System.out.println("Is this shoe a high top? (Enter yes or no):");
			String response = scan.next();
			if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase("Y")) {
				highTop = true;
				validInput = true;
			}
			else if (response.equalsIgnoreCase("No") || response.equalsIgnoreCase("N")) {
				highTop = false;
				validInput = true;
			}
			else {
				System.out.println("Invalid Input. Please try again.");
			}
		}
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Retro shoe?: " + retro);
		System.out.println("High top?: " + highTop);
	}
	
	
	public static void main(String[] args) {
		

	}

}
