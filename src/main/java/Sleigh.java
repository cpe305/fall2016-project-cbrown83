
public class Sleigh {
	private static final int DEFAULT_SLEIGH_HEALTH = 100; 
	int health; 
	
	public Sleigh() {
		this.health = DEFAULT_SLEIGH_HEALTH; 
	}
	public void repair() {
		this.health += 10; 
	}
	
	public void damage(int impact) {
		this.health -= impact; 
	}
}
