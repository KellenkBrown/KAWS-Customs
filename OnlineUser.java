import java.util.Scanner;

public class OnlineUser {

	private int idNumber;
	private String username;
	private String password;
	private static int numUsers = -1;
	private int shoesOrdered = 0;
	private double accountBalance;
	
	public OnlineUser() {
		numUsers++;
		idNumber = numUsers;
		username = "N/A";
		password = "N/A";
		accountBalance = 0;
	}
	
	public OnlineUser(int idNumber, String username, String password) {
		this.idNumber = idNumber;
		this.username = username;
		this.password = password;
		accountBalance = 0;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void addFunds(double fundsAdded) {
		accountBalance += fundsAdded;
	}
	
	
	public int getShoesOrdered() {
		return shoesOrdered;
	}
	
	public void incrementShoesOrdered(int shoesOrdered) {
		this.shoesOrdered += shoesOrdered;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(Scanner scan) {
		boolean validUsername = false;
		boolean hasLowercase = false;
		boolean hasUppercase = false;
		boolean hasNumber = false;
		boolean noSpaces = true;
		
		while (!validUsername) {
			System.out.println("Enter a username. Must have an uppercase, lowercase, number, and no spaces.");
			String username = scan.nextLine();
			username = username.trim();
			
			for (int i = 0; i < username.length(); i++) {
				if (Character.isUpperCase(username.charAt(i))) {
					hasUppercase = true;
				}
				else if (Character.isLowerCase(username.charAt(i))) {
					hasLowercase = true;
				}
				else if (Character.isDigit(username.charAt(i))) {
					hasNumber = true;
				}
				else if (Character.isWhitespace(username.charAt(i))) {
					noSpaces = false;
				}
			}
			
			if (noSpaces && hasNumber && hasUppercase && hasLowercase) {
				System.out.println("Username submitted.");
				this.username = username;
				validUsername = true;
			}
			else {
				System.out.println("Username invalid. Please try again.");
			}
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(Scanner scan) {
		boolean validInput = false;
		boolean noWhitespace = true;
		
		while (!validInput) {
		System.out.println("Enter a password. Must have no spaces.");
		String password = scan.nextLine();
		password = password.trim();
		
		for (int i = 0; i < password.length(); ++i) {
			if (Character.isWhitespace(password.charAt(i))) {
				noWhitespace = false;
			}
		}
		if (noWhitespace) {
			System.out.println("Password set.");
			this.password = password;
			validInput = true;
		}
		else {
			System.out.println("Password invalid. Please try again.");
		}
		}
	}
	
	public void printInfo() {
		System.out.println("ID number: " + idNumber);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Account balance: $" + accountBalance);
	}

	public static void main(String[] args) {
		

	}

}