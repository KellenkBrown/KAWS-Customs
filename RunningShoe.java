import java.util.*;
public class RunningShoe extends Shoe {

	public RunningShoe() {
		suggestedMileCapacity = 0;
		suggestedTerrainUsage = "N/A";
		terrains = new HashSet<String>();
		Collections.addAll(terrains, "Trail", "Track", "Road");
	}
	
	public RunningShoe(int suggestedMileCapacity, String suggestedTerrainUsage) {
		this.suggestedMileCapacity = suggestedMileCapacity;
		this.suggestedTerrainUsage = suggestedTerrainUsage;
		terrains = new HashSet<String>();
		Collections.addAll(terrains, "Trail", "Track", "Road");
	}
	
	public RunningShoe(String name, double price, String primaryColor, String secondaryColor, int suggestedMileCapacity, String suggestedTerrainUsage) {
		this.setName(name);
		this.setPrice(price);
		this.setPrimaryColor(primaryColor);
		this.setSecondaryColor(secondaryColor);
		this.suggestedMileCapacity = suggestedMileCapacity;
		this.suggestedTerrainUsage = suggestedTerrainUsage;
	}
	
	
	private int suggestedMileCapacity;
	private String suggestedTerrainUsage;
	private HashSet<String> terrains;
	
	public int getSuggestedMileCapacity() {
		return suggestedMileCapacity;
	}

	public void setSuggestedMileCapacity(Scanner scan) {
		System.out.println("Enter an integer for recommended max milage usage");
		int suggestedMileCapacity = scan.nextInt();
		this.suggestedMileCapacity = suggestedMileCapacity;
	}

	public String getSuggestedTerrainUsage() {
		return suggestedTerrainUsage;
	}

	public void setSuggestedTerrainUsage(Scanner scan) {
		boolean validInput = false;
		
		while (!validInput) {
			String suggestedTerrainUsage = "";
			String searchString = "";
			System.out.println("Please enter what type of running shoe this will be.");
			System.out.println("Choose from this list: (Trail, Track, Road)");
			suggestedTerrainUsage = scan.next();
			suggestedTerrainUsage = suggestedTerrainUsage.trim();
			suggestedTerrainUsage = suggestedTerrainUsage.toLowerCase();
			
			for (int i = 0; i < suggestedTerrainUsage.length(); ++i) {
				if (i == 0) {
					searchString += Character.toUpperCase(suggestedTerrainUsage.charAt(0));
				}
				else {
					searchString += suggestedTerrainUsage.charAt(i);
				}
			}
			if (terrains.contains(searchString)) {
				this.suggestedTerrainUsage = searchString;
				validInput = true;
			}
			else {
				System.out.println("Incorrect input. Please try again.");
			}
		}
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Suggested mile capacity: " + suggestedMileCapacity);
		System.out.println("Suggested terrain usage: " + suggestedTerrainUsage);
	}

	public static void main(String[] args) {
		

	}

}
