
public class Reindeer {
	private static final int DEFAULT_REINDEER_HEALTH = 10; 
	int health; 
	
	public Reindeer() {
		this.health = DEFAULT_REINDEER_HEALTH; 
	}
	
	public void addHealth(int add) {
		this.health += add; 
	}
	
	public void damageHealth(int damage) {
		this.health -= damage; 
	}
	
	public int getHealth() {
		return this.health;
	}
}
