
public class Sleigh {
	private static final int SLEIGH_CAPACITY = 500; 
	private static final int DEFAULT_WEIGHT_PRESENTS = 200; 
	
	private int weight; 
	private boolean damaged; 
	
	public Sleigh(Santa santa) {
		this.weight = santa.getWeight() + DEFAULT_WEIGHT_PRESENTS; 
		this.damaged = false; 
	}
	public void repair() {
		this.damaged = false; 
	}
	
	public void damage() {
		this.damaged = true; 
	}
	
	public boolean isDamaged() {
		return damaged; 
	}
	
	public void notify(Santa santa) {
		updateWeight(santa);
	}
	// update sleigh weight when santa buys anything
	public void updateWeight(Santa santa) {
		this.weight = santa.getWeight() + DEFAULT_WEIGHT_PRESENTS; 
	}
	
	public int getWeight() {
		return weight; 
	}
	
	public boolean hasCapacity() {
		return SLEIGH_CAPACITY > weight; 
	}
	
	public int getRemainingCapacity() {
		return SLEIGH_CAPACITY - weight; 
	}
	
	
}
