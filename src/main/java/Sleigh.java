
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
	
	// update sleigh weight when santa buys anything
	public void updateWeight(Santa santa) {
		this.weight = santa.getWeight() + DEFAULT_WEIGHT_PRESENTS; 
	}
	
	// update the weight of the sleigh
	// use negative numbers to make the sleigh lighter (e.g. successful delivery)
	// returns whether you can add or remove weight based on sleigh capacity
	public boolean updateWeight(int weight) {
		if (weight + this.weight <= SLEIGH_CAPACITY) { 
			this.weight += weight;
			return true;
		}
		else {
			return false; 
		}
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
