public class Driver {
	
	private Driver() {}
	
	private static TextWriter writer = new TextWriter(); 
	private static InputReader reader = InputReader.getInstance(); 
	
	public static void main(String[] args) throws Exception
	{	
		writer.printGameText("messageGreeting", false);
		writer.printOptionText("optionsHomeScreen");
		int choice = reader.getInput(1, 3);
		
		switch(choice) 
		{
			case 1: // Start game
				Game game = Game.getInstance(writer, reader); 
				game.play();
				break; 
				
			case 2: // View high scores
				System.out.println("view high scores");
				break;
				
			case 3: // Exit		
				return; 
				
			default: 
				return; 
		}
	}
}
