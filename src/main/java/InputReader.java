import java.util.Scanner;

public class InputReader {
	
	private static InputReader instance = null;
	private static Scanner scanner = new Scanner(System.in); 
	
	private InputReader() {
		
	}
	
	public static InputReader getInstance() {
		if (instance == null) {
			instance = new InputReader(); 
		}
		return instance; 
	}
	
	public String getInput() {
		String returnValue = scanner.next(); 
		scanner.nextLine(); 
		return returnValue; 
	}
	
}
