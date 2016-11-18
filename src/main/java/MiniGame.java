import java.util.Random; 

public class MiniGame {
	// mini game might be city-specific
	// simple guess-a-number for now
	
	public static boolean play(int guess) {
		Random r = new Random(); 
		int randomNum = r.nextInt() % 3 + 1; 
		return randomNum == guess; 
	}
}
