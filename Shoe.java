import java.util.*;
import java.text.*;

public class Shoe {
	
	public Shoe() {
		name = "N/A";
		size = 0;
		price = 59.99;
		gender = "N/A";
		primaryColor = "N/A";
		secondaryColor = "N/A";
		colorList = new HashSet<String>();
		Collections.addAll(colorList, "Maraschino", "Cayenne", "Maroon", "Grape", "Salmon", "Tangerine", "Banana", "Lime", "Pine", "Teal", "Turquoise", "Black", "White", "Silver", "Gold");
	}
	
	public Shoe (String name, double price, String primaryColor, String secondaryColor) {
		this.name = name;
		this.price = price;
	}
	
	
	public Shoe (String name, double size, double price, String gender, String primaryColor, String secondaryColor) {
		this.name = name;
		this.size = size;
		this.price = price;
		this.gender = gender;
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		colorList = new HashSet<String>();
		Collections.addAll(colorList, "Maraschino", "Cayenne", "Maroon", "Grape", "Salmon", "Tangerine", "Banana", "Lime", "Pine", "Teal", "Turquoise", "Black", "White", "Silver", "Gold");
	}

	private String name;
	private double size;
	private double price;
	private String gender;
	private String primaryColor;
	private String secondaryColor;
	private HashSet<String> colorList;
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(Scanner scan) {
		System.out.println("Enter a retail price. Round to amount in cents");
		price = scan.nextDouble();
		scan.nextLine();
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	
	public String getPrimaryColor() {
		return primaryColor;
	}


	public void setPrimaryColor(Scanner scan) {
		boolean validColor = false;
		
		while (!validColor) {
			String primaryColor = "";
			String searchString = "";
		System.out.println("Enter a primary color. The color must be from this list ");
		System.out.println("-------------------------------------------------------");
		System.out.println("(Maraschino, Cayenne, Maroon, Grape, Salmon, Tangerine,\nBanana, Lime, Pine, Teal, Turquoise, Black, White,\nSilver, Gold)");
		System.out.println("-------------------------------------------------------");
		primaryColor = scan.next();
		primaryColor = primaryColor.trim();
		primaryColor = primaryColor.toLowerCase();
		
		for (int i = 0; i < primaryColor.length(); i++) {
			if (i == 0) {
				searchString += Character.toUpperCase(primaryColor.charAt(0));;
			}
			else {
				searchString += primaryColor.charAt(i);
			}
		}
		
		if (colorList.contains(searchString)) {
			this.primaryColor = searchString;
			validColor = true;
		}
		else {
			System.out.println("Invalid Color. Please try again.");
		}
		}
		
	}
	
	public void setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
	}


	public String getSecondaryColor() {
		return secondaryColor;
	}


	public void setSecondaryColor(Scanner scan) {
		boolean validColor = false;
		
		while (!validColor) {
			String secondaryColor = "";
			String searchString = "";
		System.out.println("Enter a secondary color. The color must be from this list");
		System.out.println("-------------------------------------------------------");
		System.out.println("(Maraschino, Cayenne, Maroon, Grape, Salmon, Tangerine,\nBanana, Lime, Pine, Teal, Turquoise, Black, White,\nSilver, Gold)");
		System.out.println("-------------------------------------------------------");
		secondaryColor = scan.next();
		secondaryColor = secondaryColor.trim();
		secondaryColor = secondaryColor.toLowerCase();
		
		for (int i = 0; i < secondaryColor.length(); i++) {
			if (i == 0) {
				searchString += Character.toUpperCase(secondaryColor.charAt(0));;
			}
			else {
				searchString += secondaryColor.charAt(i);
			}
		}
		
		if (colorList.contains(searchString)) {
			this.secondaryColor = searchString;
			validColor = true;
		}
		else {
			System.out.println("Invalid Color. Please try again.");
		}
		}
	}
	
	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}


	public String getName() {
		return name;
	}


	public void setName(Scanner scan) {
		String name = "";
		System.out.println("Please enter a name for the shoe:");
		name = scan.next();
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public double getSize() {
		return size;
	}


	public void setSize(Scanner scan) {
		double size;
		boolean validSize = false;
		
		while (!validSize) {
			System.out.println("What size is the shoe? (Please enter a valid whole or half size)");
			size = scan.nextDouble();
			
			if (size % (int)size < .00001 || (size - .5) % (int)size < .00001) {
				this.size = size;
				validSize = true;
			}
			else {
				System.out.println("Invalid size; Please try again.");
			}
		}
	}

	public String getGender() {
		return gender;
	}


	public void setGender(Scanner scan) {
		boolean validInput = false;
		String isMale;
		
		while (!validInput) {
		System.out.println("Is this a male shoe? (Enter \"Yes\" or \"No\")");
		isMale = scan.next();
		if (isMale.equalsIgnoreCase("Yes") || isMale.equalsIgnoreCase("Y")) {
			gender = "Male";
			validInput = true;
		}
		else if (isMale.equalsIgnoreCase("No") || isMale.equalsIgnoreCase("N")) {
			gender = "Female";
			validInput = true;
		}
		else {
			System.out.println("Invalid gender. Please try again.");
		}
		}
	}
	
	public void printInfo() {
		System.out.println("----");
		System.out.println("Name: " + name);
		System.out.println("Size: " + size);
		System.out.println("Price: $" + price);
		System.out.println("Gender: " + gender);
		System.out.println("Primary Color: " + primaryColor);
		System.out.println("Secondary Color: " + secondaryColor);
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Shoe myShoe = new Shoe();
		myShoe.setPrimaryColor(scan);
		myShoe.setSecondaryColor(scan);
		myShoe.setName(scan);
		myShoe.setGender(scan);
		myShoe.setPrice(scan);
		myShoe.setSize(scan);
		
		myShoe.printInfo();
		
		
	}

}
