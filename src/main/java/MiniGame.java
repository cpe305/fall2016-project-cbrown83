import java.util.Random; 

public class MiniGame {
	// mini game might be city-specific
	// simple guess-a-number for now
	
	// guess number between 1 and 3
	public static boolean play(Santa santa, Sleigh sleigh, int guess) {
		Random r = new Random(); 
		int randomNum = r.nextInt() % 3 + 1; 
		return randomNum == guess; 
	}
}
