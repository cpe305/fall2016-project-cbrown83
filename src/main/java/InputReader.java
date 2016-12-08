import java.util.Scanner;

// singleton class
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
	
	// method reads all input as a string
	public String getInput() {
		String returnValue = scanner.next(); 
		scanner.nextLine(); 
		return returnValue; 
	}
	
	// getInput with specified min and max values
	public int getInput(int min, int max) {
		int value = -1; 
		while (true) {
			if (scanner.hasNextInt()) {
				value = scanner.nextInt();
				if (value >= min && value <= max ) {
					return value; 
				}
			}
			scanner.nextLine(); 
			System.out.print("Invalid input; try again: "); 
		} 
	}
	
}
