import java.util.List;

public class Driver {
	
	private static TextWriter writer = new TextWriter(); 
	private static InputReader reader = InputReader.getInstance(); 
	
	public static void main(String[] args) 
	{	
		writer.printGameText("greeting", false);
		writer.printOptionText("homeScreenOptions", "What is your choice?");
		String choice = reader.getInput();
		
		switch(choice.charAt(0)) 
		{
			case '1': // Start game
				Game.playGame(writer, reader); 
				break; 
				
			case '2': // View high scores
				System.out.println("view high scores");
				break;
				
			case '3': // Exit		
				return; 
		}
	}
}
