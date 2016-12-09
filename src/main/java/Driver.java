public class Driver {
	
	private Driver() {}
	
	private static TextWriter writer = new TextWriter(); 
	private static InputReader reader = InputReader.getInstance(); 
	
	public static void main(String[] args) throws Exception
	{	
		int choice = 0; 
		while (choice != 4 && choice != 1) {
			writer.printGameText("messageGreeting", false);
			writer.printOptionText("optionsHomeScreen");
			choice = reader.getInput(1, 4);
			Game game = Game.getInstance(writer, reader); 
			
			switch(choice) 
			{
				case 1: // Start game
					game.play();
					break; 
					
				case 2: // View high scores
					System.out.println("view high scores");
					break;
					
				case 3: // View game guide	
					game.viewGuide(); 
					break; 
					
				case 4: // Exit
					return; 
					
				default: 
					return; 
			}
		}
	}
}
