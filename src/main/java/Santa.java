
public class Santa {
	int weight, cookies, presentsDelivered;
	String size; 
	
	public Santa(int weight) {
		this.weight = weight; 
		this.cookies = 0; 
		this.presentsDelivered = 0; 
	}
	
	public void successfulDelivery() {
		if (MiniGame.play(-1)) {
			addHealth(1); 
		}
		else {
			getCaught(); 
		}
	}
	
	public void addHealth(int add) {
		this.weight += add; 
	}
	
	public void getCaught() {
		this.cookies -= 1; 
	}
}
