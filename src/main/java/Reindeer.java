
public class Reindeer {
	private static final int DEFAULT_REINDEER_HEALTH = 10; 
	
	String name; 
	int health; 
	
	public Reindeer(String name) {
		this.name = name; 
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
	
	public String getName() {
		return this.name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
}
