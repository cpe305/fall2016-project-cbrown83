import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 



public class Game {
	
	// eventually create separate game window to display text at certain scenes
	
	private static final int NUMBER_OF_REINDEER = 9; 
	private static final int NUMBER_OF_CITIES = 11; 
	private static ArrayList<String> DEFAULT_REINDEER_NAMES = new ArrayList<String>(); 
	
	// cities to visit
	private static final String NORTH_POLE = "North Pole";
	private static final String TOKYO = "Tokyo";
	private static final String SYDNEY = "Sydney";
	private static final String AUKLAND = "Aukland"; 
	private static final String BEIJING = "Beijing";
	private static final String MOSCOW = "Moscow";
	private static final String PARIS = "Paris";
	private static final String BUENOS_AIRES = "Buenos Aires";
	private static final String NEW_YORK = "New York";
	private static final String MEXICO_CITY = "Mexico City"; 
	private static final String SEATTLE = "Seattle";
	
	// store items
	public static final String CARROT = "carrot"; 
	public static final String GINGERBREAD_MEN = "gingerbreadMen"; 
	public static final String HOT_COCOA = "hotCocoa"; 
	public static final String SANTA_HAT = "santaHat"; 
	public static final String SANTA_COAT = "santaCoat"; 
	public static final String CANDY_CANES = "candyCanes";
	public static final String SLEIGH_PARTS = "sleighParts"; 
	
	private static TextWriter writer; 
	private static InputReader reader;
	private static JSONObject script;
	
	private static Santa santa; 
	private static Sleigh sleigh; 
	private City curCity; 
	private static List<Reindeer> reindeer = new ArrayList<Reindeer>();
	public static Map<String, City> cities;
	private static Random random = new Random(); 
	
	// Singleton class
	private static Game instance = null; 
	
	protected Game(TextWriter w, InputReader r) {
		writer = w; 
		reader = r; 
	}
	
	public static Game getInstance(TextWriter writer, InputReader reader) {
		if (instance == null) {
			instance = new Game(writer, reader);
		}
		return instance; 
	}
	
	public void play() throws Exception {
		script = writer.getGameScript();
		santa = new Santa(); 
		sleigh = new Sleigh(santa); 
		santa.setSleigh(sleigh); 
		
		reindeer = getReindeerNames(); 
		initiateRoute(); 
		
		curCity = cities.get("North Pole");
		cities.get("North Pole").visit(santa, sleigh, script, NUMBER_OF_CITIES);
		
		startAdventure(); 
		
		// end game - total score
		System.out.println("Congratulations! Your score was " + getScore(santa, sleigh) + "\n");
		// save
	}
	
	public void startAdventure() {
		int citiesLeft = NUMBER_OF_CITIES-1; 
		System.out.println("Well then, you're ready to get going. Good luck! You have a long night ahead of you...\n");
		do {
			curCity = curCity.getNextCity(); 
			curCity.visit(santa, sleigh, script, citiesLeft--);
			
		} while (curCity.getNextCity() != null); 
	}
	
	public void initiateRoute() throws Exception {
		populateMap(); 
		writer.printGameText("messageStartLocation", false);
		writer.printOptionText("optionsStartLocation");
		int startLocation = reader.getInput(1, 3); 
		setRoute(startLocation);
	}
	
	// need to add auto-fill feature
	private static List<Reindeer> getReindeerNames() {		
		System.out.println("\nEnter names for the nine reindeer: ");
		System.out.println("If you would like to use the default names, type 'autofill'.");
		String name = ""; 
		for (int i = 0; i < NUMBER_OF_REINDEER; i++) {
			System.out.print(i+1 + ". "); 
			name = reader.getInput(); 
			if (name.equals("autofill")) {
				break; 
			}
			reindeer.add(new Reindeer(name));
		}
		if (name.equals("autofill")) {
			autofillReindeer(); 
		}
		return reindeer; 
	}

	private static void autofillReindeer() {
		DEFAULT_REINDEER_NAMES.add("Dasher"); 
		DEFAULT_REINDEER_NAMES.add("Dancer"); 
		DEFAULT_REINDEER_NAMES.add("Prancer"); 
		DEFAULT_REINDEER_NAMES.add("Vixen"); 
		DEFAULT_REINDEER_NAMES.add("Comet"); 
		DEFAULT_REINDEER_NAMES.add("Cupid"); 
		DEFAULT_REINDEER_NAMES.add("Donner"); 
		DEFAULT_REINDEER_NAMES.add("Blixen"); 
		DEFAULT_REINDEER_NAMES.add("Rudolph"); 
		for (int i = 0; i < NUMBER_OF_REINDEER; i++) {
			reindeer.add(new Reindeer(DEFAULT_REINDEER_NAMES.get(i)));
		}
	}
	private static void populateMap() throws Exception {
		cities = new HashMap<String, City>(); 
		JSONObject city; 
		String name; 
		String landmark; 
		if (script.containsKey("setupCities")) {
			JSONArray setupCities = (JSONArray) script.get("setupCities");
			// initiate all cities
			for (int i = 0; i < setupCities.size(); i++) {
				city = (JSONObject) setupCities.get(i); 
				name = (String)city.get("name"); 
				landmark = (String)city.get("landmark");
				cities.put(name, new City(name, landmark));
			}
			return; 
		}
		throw new Exception("Invalid JSON Key: setupCities"); 
	}
	
	private static void setRoute(int startLocation) {
		switch (startLocation) {
			case 1: //Tokyo
				startAtTokyo(); 
				break; 
				
			case 2: //Sydney
				startAtSydney(); 
				break; 
				
			case 3: //Aukland
				startAtAukland(); 
				break; 
				
			default: 
				break; 
		}
	}
	
	private static void startAtTokyo() {
		cities.get(NORTH_POLE).setNextCity(cities.get(TOKYO));
		cities.get(TOKYO).setNextCity(cities.get(SYDNEY));
		cities.get(SYDNEY).setNextCity(cities.get(AUKLAND));
		cities.get(AUKLAND).setNextCity(cities.get(BEIJING));
		finishRoute(); 
	}
	
	private static void startAtSydney() {
		cities.get(NORTH_POLE).setNextCity(cities.get(SYDNEY));
		cities.get(SYDNEY).setNextCity(cities.get(AUKLAND));
		cities.get(AUKLAND).setNextCity(cities.get(TOKYO));
		cities.get(TOKYO).setNextCity(cities.get(BEIJING));
		finishRoute(); 
	}
	
	private static void startAtAukland() {
		cities.get(NORTH_POLE).setNextCity(cities.get(AUKLAND));
		cities.get(AUKLAND).setNextCity(cities.get(SYDNEY));
		cities.get(SYDNEY).setNextCity(cities.get(TOKYO));
		cities.get(TOKYO).setNextCity(cities.get(BEIJING));
		finishRoute();
	}
	
	private static void finishRoute() {
		cities.get(BEIJING).setNextCity(cities.get(MOSCOW));
		cities.get(MOSCOW).setNextCity(cities.get(PARIS));
		cities.get(PARIS).setNextCity(cities.get(BUENOS_AIRES));
		cities.get(BUENOS_AIRES).setNextCity(cities.get(NEW_YORK));
		cities.get(NEW_YORK).setNextCity(cities.get(MEXICO_CITY));
		cities.get(MEXICO_CITY).setNextCity(cities.get(SEATTLE));
	}
	
	
	private int getScore(Santa santa, Sleigh sleigh) {
		return santa.getCandyCanes() + santa.getCarrots() + santa.getGingerbreadMen() + 
				santa.getHotCocoa() + santa.getSantaCoat() + santa.getSantaHat() +
				sleigh.getRemainingCapacity() + 
				(santa.getPresentsDelivered() * 500);
	}
	
	public void randomEvent() {
		if (random.nextInt() % 5 == 0) {
			// randomEvent
		}
	}
	
	public void viewGuide() {
		writer.printGameText("santasNotes", true);
	}
}
