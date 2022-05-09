import java.util.*;

public class Store {
	
	//Default store shoes
	private static BasketballShoe defaultShoe1 = new BasketballShoe("Nike Air Jordan 1", 139.99, "Maraschino", "Black", true, true);
	private static BasketballShoe defaultShoe2 = new BasketballShoe("Adidas KB8", 229.99, "Grape", "White", true, true);
	private static RunningShoe defaultShoe3 = new RunningShoe("Nike Zoom VaporFly 4%", 239.99, "Turquoise", "Cayenne", 300, "Road");
	private static RunningShoe defaultShoe4 = new RunningShoe("Saucony Peregrine 12", 130.00, "Tangerine", "Warm grey", 550, "Trail");
	private static final Shoe[] storePresets = {defaultShoe1, defaultShoe2, defaultShoe3, defaultShoe4};
	
	
	private static ArrayList<OnlineUser> userDatabase = new ArrayList<OnlineUser>();
	private HashMap<Integer, Double> orderHistory = new HashMap<Integer, Double>(); //Maps user id number to amount spent
	private ArrayList<Shoe> currentOrder;
	private OnlineUser currentUserInStore;
	private static int numOrders = 0;
	private int orderNum;
	
	
	public Store () {
		numOrders++;
		orderNum = numOrders;
		currentOrder = new ArrayList<Shoe>();
	}
	
	public void userLogin(Scanner scan) {
		boolean correctPassword = false;
		boolean usernameFound = false;
		while (!correctPassword) {
		System.out.println("Enter your username:");
		String userName = scan.next();
		userName = userName.trim();
		int arraySlot;
		
		for (int i = 0; i < userDatabase.size(); i++) {
			if (userName.equals(userDatabase.get(i).getUsername())) {
				usernameFound = true;
				System.out.println("Enter your password:");
				String password = scan.next();
				password = password.trim();
				if (userDatabase.get(i).getPassword().equals(password)) {
					System.out.println("Successfully logged in.");
					currentUserInStore = userDatabase.get(i);
					correctPassword = true;
					break;
					
				}
				else {
					System.out.println("Incorrect password. Please try again.");
				}
			}
		}
		if (!usernameFound) {
			System.out.println("Username was not found.");
		}
		}
	}
	
	public void userCreation(Scanner scan) {
		currentUserInStore = new OnlineUser();
		currentUserInStore.setUsername(scan);
		currentUserInStore.setPassword(scan);
		userDatabase.add(currentUserInStore);
	}
	
	public void viewUserInformation() {
		currentUserInStore.printInfo();
	}
	
	public void viewInventory() {
		for (Shoe defaultShoe : storePresets) {
			defaultShoe.printInfo();
		}
	}
	
	public void addToCart(Scanner scan) {
		Shoe newShoePurchase = new Shoe();
		boolean validInput = false;
		
		while (!validInput) {
		System.out.println("What shoe would you like to order?");
		System.out.println("Nike Air Jordan 1 - Enter 1");
		System.out.println("Adidas KB8 - Enter 2");
		System.out.println("Nike Zoom VaporFly 4% - Enter 3");
		System.out.println("Saucony Peregrine 12 - Enter 4");
		int userChoice = scan.nextInt();
		
		switch (userChoice) {
		case 1:
			newShoePurchase = defaultShoe1;
			newShoePurchase.setSize(scan);
			newShoePurchase.setGender(scan);
			currentOrder.add(newShoePurchase);
			System.out.println("Nike Air Jordan 1 added to cart.");
			validInput = true;
			break;
		case 2: 
			newShoePurchase = defaultShoe2;
			newShoePurchase.setSize(scan);
			newShoePurchase.setGender(scan);
			currentOrder.add(newShoePurchase);
			System.out.println("Adidas KB8 added to cart.");
			validInput = true;
			break;
		case 3:
			newShoePurchase = defaultShoe3;
			newShoePurchase.setSize(scan);
			newShoePurchase.setGender(scan);
			currentOrder.add(newShoePurchase);
			System.out.println("Nike Zoom VaporFly 4% added to cart.");
			validInput = true;
			break;
		case 4:
			newShoePurchase = defaultShoe4;
			newShoePurchase.setSize(scan);
			newShoePurchase.setGender(scan);
			currentOrder.add(newShoePurchase);
			System.out.println("Saucony Peregrine 12 added to cart.");
			validInput = true;
			break;
		default:
			System.out.println("Invalid input. please try again.");
			break;
		}
		}
	}
	
	public void viewCart() {
		for (int i = 0; i < currentOrder.size(); i++) {
			System.out.println("----");
			System.out.println("Item number " + (i + 1) + ":");
			currentOrder.get(i).printInfo();
		}
	}
	
	public void removeFromCart(Scanner scan) {
		System.out.println("Your cart:");
		System.out.println("----");
		for (int i = 0; i < currentOrder.size(); i++) {
			System.out.println("Item #" + (i + 1) + ": " + currentOrder.get(i).getName() + ", $" + currentOrder.get(i).getPrice()); 
		}
		System.out.println("----");
		System.out.println("Enter item number to remove:");
		int itemNumber = scan.nextInt();
		currentOrder.remove(itemNumber - 1);
		System.out.println("Item #" + itemNumber + " removed.");
	}
	
	public void addFunds(Scanner scan) {
		System.out.println(currentUserInStore.getUsername() + "'s account balance: $" + currentUserInStore.getAccountBalance());
		System.out.println("Please enter a positive double amount to add money to your account, or negative double amount to ");
		System.out.println("withdraw money from your account. (Please note your account balance cannot go below $0.00)");
		double addFunds = scan.nextDouble();
		
		if (currentUserInStore.getAccountBalance() + addFunds >= 0 && addFunds >= 0) {
			currentUserInStore.addFunds(addFunds);
			System.out.println("$" + addFunds + " successfully added to the account.");
			System.out.println("New account balance: $" + currentUserInStore.getAccountBalance());
		}
		else if (currentUserInStore.getAccountBalance() + addFunds >= 0 && addFunds < 0) {
			currentUserInStore.addFunds(addFunds);
			System.out.println("$" + Math.abs(addFunds) + " successfully withdrawn from account.");
			System.out.println("New account balance: $" + currentUserInStore.getAccountBalance());
		}
		else if (currentUserInStore.getAccountBalance() + addFunds < 0) {
			System.out.println("Can't withdraw more money than is currently in account.");
			System.out.println("Account balance: $" + currentUserInStore.getAccountBalance());
		}
	}
	
	public void checkout(Scanner scan) {
		boolean validInput = false;
		double cartCost = 0;
		for (int i = 0; i < currentOrder.size(); ++i) {
			cartCost += currentOrder.get(i).getPrice();
		}
		
		System.out.println(currentUserInStore.getUsername() + "'s cart:");
		System.out.println("Balance: $" + currentUserInStore.getAccountBalance());
		System.out.println("Cart total: $" + cartCost);
		System.out.println("Would you like to purchase your current cart? (Enter yes or no)");
		String answer = scan.next();
		answer = answer.trim();
		
		while (!validInput) {
		if (answer.equalsIgnoreCase("Yes") && cartCost <= currentUserInStore.getAccountBalance()) {
			currentUserInStore.addFunds((cartCost * -1));
			double purchaseHistory = 0;
			if (orderHistory.containsKey(currentUserInStore.getIdNumber())) {
			purchaseHistory = orderHistory.get(currentUserInStore.getIdNumber());
			}
			purchaseHistory += cartCost;
			orderHistory.put(currentUserInStore.getIdNumber(), purchaseHistory);
			
			System.out.println("Purchase successful.");
			System.out.println("Updated account balance: $" + currentUserInStore.getAccountBalance());
			System.out.println("Thank you for your purchase! Have a great day!");
			currentOrder.clear();
			validInput = true;
		}
		else if (answer.equalsIgnoreCase("Yes") && cartCost > currentUserInStore.getAccountBalance()) {
			System.out.println("Sorry, you don't have enough money to purchase the current cart.");
			System.out.println("Please add funds or remove items from cart.");
			validInput = true;
		}
		else if (answer.equalsIgnoreCase("No")) {
			System.out.println("All good. Come back if you change your mind.");
			validInput = true;
		}
		else {
			System.out.println("Invalid input. please try again.");
		}
		}
	}
	
	public void viewOrderHistory(Scanner scan) {
		System.out.println("Please enter your ID number: ");
		int idNumber = scan.nextInt();
		
		if (orderHistory.containsKey(idNumber) && idNumber == currentUserInStore.getIdNumber()) {
			System.out.println("Your account has spent $" + orderHistory.get(idNumber));
		}
		else if (idNumber != currentUserInStore.getIdNumber()) {
			System.out.println("Not your account ID nosy guy.");
		}
		else {
			System.out.println("This ID number has never made a purchase.");
		}
	}
	
	public void welcomeMenu(Scanner scan) {
		boolean validInput = false;
		System.out.println("Welcome to the store section!");
		
		while (!validInput) {
		System.out.println("If you are a new user, please create a new account");
		System.out.print("by entering 0. If you are a returning user, please enter 1: ");
		int userType = scan.nextInt();
		scan.nextLine();
		if (userType == 0) {
			this.userCreation(scan);
			validInput = true;
		}
		else if (userType == 1) {
			this.userLogin(scan);
			validInput = true;
		}
		else {
			System.out.println("Invalid input. Try again.");
		}
		}
	}
	
	public void optionsMenu(Scanner scan) {
		boolean quitMenu = false;
		
		while (!quitMenu) {
		System.out.println("----");
		System.out.println("Welcome to kawsCustoms Store, please see the below menu for different options.");
		System.out.println("1: User information");
		System.out.println("2: Current store inventory");
		System.out.println("3: Add shoes to cart");
		System.out.println("4: Remove shoes from cart");
		System.out.println("5: View your cart");
		System.out.println("6: Add funds");
		System.out.println("7: Checkout");
		System.out.println("8: View order history");
		System.out.println("9: Logout");
		
		System.out.println("Select a number: ");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			this.viewUserInformation();
			break;
		case 2:
			this.viewInventory();
			break;
		case 3:
			this.addToCart(scan);
			break;
		case 4:
			this.removeFromCart(scan);
			break;
		case 5:
			this.viewCart();
			break;
		case 6:
			this.addFunds(scan);
			break;
		case 7:
			this.checkout(scan);
			break;
		case 8:
			this.viewOrderHistory(scan);
			break;
		case 9:
			System.out.println("You have been logged out.");
			quitMenu = true;
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			break;
		}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
