import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 



public class Game {
	
	// eventually create separate game window to display text at certain scenes
	
	private static final int NUMBER_OF_REINDEER = 9; 
	private static final int NUMBER_OF_CITIES = 11; 
	
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
	private static List<Reindeer> reindeer;
	public static Map<String, City> cities;
	public static Map<String, Integer> storeItems;
	
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
		
		cities.get("North Pole").visit(santa, sleigh, script, NUMBER_OF_CITIES);
		
		
		
		// end game - total score
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
		List<Reindeer> reindeer = new ArrayList<Reindeer>(); 
		
		System.out.println("Enter names for the nine reindeer: ");
		String name; 
		for (int i = 0; i < NUMBER_OF_REINDEER; i++) {
			System.out.print(i+1 + ". "); 
			name = reader.getInput(); 
			System.out.println("adding " + name);
			reindeer.add(new Reindeer(name));
		}
		return reindeer; 
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
	
	private void gameOver() {
		
	}
	
	private void randomEvent() {

	}
	
}
