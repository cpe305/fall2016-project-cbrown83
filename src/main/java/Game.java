import java.util.ArrayList;
import java.util.List;


public class Game {
	
	private static final int NUMBER_OF_REINDEER = 9; 
	
	private static Santa santa; 
	private static Sleigh sleigh; 
	private static List<Reindeer> reindeer;
	private static List<City> cities;  
	
	public static void playGame(TextWriter writer, InputReader reader) {
		reindeer = getReindeerNames(writer, reader); 
		printOpeningMessage(writer); 
		//reader.getInput(); 
	}
	
	// need to add auto-fill feature
	private static List<Reindeer> getReindeerNames(TextWriter writer, InputReader reader) {
		List<Reindeer> reindeer = new ArrayList<Reindeer>(); 
		
		System.out.println("Enter names for the nine reindeer: ");
		String name = ""; 
		for (int i = 0; i < NUMBER_OF_REINDEER; i++) {
			System.out.print(i+1 + ". "); 
			name = reader.getInput(); 
			System.out.println("adding " + name);
			reindeer.add(new Reindeer(name));
		}
		return reindeer; 
	}
	
	private static void printOpeningMessage(TextWriter writer) {
		
	}
	
	
	
	
}
