import java.util.Random; 

public class Child {
	
	int damage; 
	
	public Child() {
		Random rand = new Random(); 
		this.damage = rand.nextInt(3) + 1; 
	}

}
