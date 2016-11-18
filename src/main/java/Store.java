
public class Store {
	private int priceCookie, priceRepair, priceCarrots, priceRepellant; 
	
	public Store(int priceCookie, int priceRepair, int priceCarrots, int priceRepellant) {
		this.priceCookie = priceCookie; 
		this.priceRepair = priceRepair; 
		this.priceCarrots = priceCarrots; 
		this.priceRepellant = priceRepellant; 
	}
	
	// each method corresponds to an option chosen from the store menu
	// returns cost of cookies to be reflected in Santa's inventory/health
	public int buyCookies(int numCookies) {
		return numCookies *= priceCookie; 
	}
	
	public int repairSleigh() {
		return priceRepair; 
	}
	
	public int buyCarrots(int numCarrots) {
		return numCarrots * priceCarrots; 
	}
	
	public int buyRepellent(int numRepellant) {
		return numRepellant * priceRepellant; 
	}
}
