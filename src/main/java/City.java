import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 

public class City {
	private static final int DELIVER_PRESENTS = 1; 
	private static final int CHECK_INVENTORY = 2; 
	private static final int EXPLORE_PARK = 3; 
	private static final int VISIT_STORE = 4; 
	private static final int NEXT_CITY = 5; 
	
	private String name; 
	private String landmark; 
	private Store store; 
	private boolean visited; 
	private City nextCity; 
	private boolean attemptedDelivery; 
	
	public City(String name, String landmark) {
		this.name = name; 
		this.landmark = landmark; 
		this.visited = false; 
		this.store = null; 
		this.attemptedDelivery = false; 
	}
	
	public String getName() {
		return this.name; 
	}
	
	public String getLandmark() {
		return this.landmark; 
	}
	
	public void visit(Santa santa, Sleigh sleigh, JSONObject script, int citiesLeft) {
		this.visited = true; 
		stockStore(script); 
		
		if (getName().equals("North Pole")) {
			TextWriter writer = TextWriter.getInstance(); 
			writer.printGameText("messageSantasWorkshop", false);
			store.visit(santa, sleigh, script); 
		}
		else {
			// display city stats
			System.out.println("City: " + getName());
			System.out.println("Cities left: " + citiesLeft);
			
			// display options (switch)
			while (displayCityOptions(santa, sleigh, script) != NEXT_CITY); 
		}
	}
	
	public int displayCityOptions(Santa santa, Sleigh sleigh, JSONObject script) {
		InputReader reader = InputReader.getInstance();
		System.out.println("\nYou may: ");
		System.out.println("1. Deliver Presents");
		System.out.println("2. Check Inventory");
		System.out.println("3. Explore the Park");
		System.out.println("4. Stop at " + getLandmark());
		if (getNextCity() == null) {
			System.out.println("5. Return to the North Pole");
		}
		else {
			System.out.println("5. Travel to " + getNextCity().getName());
		}
		
		System.out.println("What would you like to do?");
		int choice = reader.getInput(DELIVER_PRESENTS, NEXT_CITY);
		
		switch (choice) {
			case DELIVER_PRESENTS: 
				if (!attemptedDelivery) {
					playMiniGame(santa, reader, script);
				}
				else {
					System.out.println("You already tried to deliver presents");
				}
				break; 
				
			case CHECK_INVENTORY:
				santa.displayInventory(script); 
				break; 
				
			case EXPLORE_PARK:
				// random event
				break; 
				
			case VISIT_STORE: 
				store.visit(santa, sleigh, script); 
				break; 
				
			case NEXT_CITY: 
				break; 
		}
		return choice; 
	}
	
	private void playMiniGame(Santa santa, InputReader reader, JSONObject script) {
		attemptedDelivery = true; 
		System.out.println("Guess a number between 1 and 3");
		int guess = reader.getInput(1, 3);
		if (MiniGame.play(guess)) {
			System.out.println("Congratulations! Santa has successfully delivered presents to " + getName());
			santa.successfulDelivery(); 
		}
		else {
			Random random = new Random(); 
			int messageNum = random.nextInt() % 4 * -1; 
			JSONArray messages = (JSONArray)script.get("methodsToCatch");
			System.out.println(messages.get(messageNum));
			System.out.println("You were unable to deliver presents to " + getName());
		}
	}
	
	public boolean isVisited() {
		return visited; 
	}
	
	public void setNextCity(City nextCity) {
		this.nextCity = nextCity; 
	}
	
	public City getNextCity() {
		return this.nextCity; 
	}
	
	// storeItems should be script.get("inventory<cityName>")
	private void stockStore(JSONObject script) {
		this.store = new Store(this, script);
	}
	
	public Store getStore() {
		return this.store; 
	}
	
	@Override
	public boolean equals(Object o) {
		City c = (City) o; 
		
 		return (c.getName() == this.name) && (c.getLandmark() == this.landmark) &&
 				c.getNextCity() == this.nextCity; 
	}
	

}
