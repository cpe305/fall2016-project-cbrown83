import java.util.List; 
import java.util.Scanner;

import org.json.simple.JSONObject;


public class Game {
	private Santa santa; 
	private Sleigh sleigh; 
	private List<Reindeer> reindeer;
	private List<City> cities;  
	private static TextFormatter format = new TextFormatter(); 
	
	public static void main(String[] args) {	
		format.printGameText("greeting");
	}
	
}
