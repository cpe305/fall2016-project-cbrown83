import org.json.simple.JSONObject; 

public class City {
	String name; 
	String landmark; 
	Store store; 
	boolean visited; 
	City nextCity; 
	
	public City(String name, String landmark) {
		this.name = name; 
		this.landmark = landmark; 
		this.visited = false; 
		this.store = null; 
	}
	
	public String getName() {
		return this.name; 
	}
	
	public String getLandmark() {
		return this.landmark; 
	}
	
	public void visit(JSONObject script) {
		this.visited = true; 
		stockStore(script); 
	}
	
	public boolean isVisited() {
		return visited; 
	}
	
	public void setNextCity(City nextCity) {
		this.nextCity = nextCity; 
	}
	
	public City getNextCity() {
		return this.nextCity; 
	}
	
	// storeItems should be script.get("inventory<cityName>")
	private void stockStore(JSONObject script) {
		this.store = new Store(this, script);
	}
	
	public Store getStore() {
		return this.store; 
	}
	
	@Override
	public boolean equals(Object o) {
		City c = (City) o; 
		
 		return (c.getName() == this.name) && (c.getLandmark() == this.landmark) &&
 				c.getNextCity() == this.nextCity; 
	}
}
