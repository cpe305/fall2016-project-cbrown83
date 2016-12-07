
public class Santa {
	private static final int WEIGHT_SANTA = 250; 

	// INVENTORY
	int gingerbreadMen = 0; 
	int carrots = 0;
	int hotCocoa = 0; 
	int santaHat = 0; 
	int santaCoat = 0; 
	int candyCanes = 0; 
	int sleighParts = 0; 
	
	int presentsDelivered = 0;
	int timesCaught = 0; 
	String size; 
	
	public Santa() {
	}
	
	public void successfulDelivery() {
		this.presentsDelivered++; 
	}
	
	public int getWeight() {
		return WEIGHT_SANTA + gingerbreadMen + carrots + hotCocoa + santaHat + santaCoat + candyCanes + sleighParts; 
	}
	
	public void updateInventory(String item, int quantity) {
		if (item.equals(Game.CARROTS)) {
			this.carrots += quantity; 
		}
		else if (item.equals(Game.GINGERBREAD_MEN)) {
			this.gingerbreadMen += quantity; 
		}
		else if (item.equals(Game.HOT_COCOA)) {
			this.hotCocoa += quantity; 
		}
		else if (item.equals(Game.SANTA_HAT)) {
			this.santaHat += quantity; 
		}
		else if (item.equals(Game.SANTA_COAT)) {
			this.santaCoat += quantity; 
		}
		else if (item.equals(Game.CANDY_CANES)) {
			this.candyCanes += quantity; 
		}
		else if (item.equals(Game.SLEIGH_PARTS)) {
			this.sleighParts += quantity; 
		}
	}
}
