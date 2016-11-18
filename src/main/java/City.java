
public class City {
	String name, landmark; 
	Store store; 
	
	public City(String name, String landmark) {
		this.name = name; 
		this.landmark = landmark; 
	}
	
	public String getName() {
		return this.name; 
	}
	
	public String getLandmark() {
		return this.landmark; 
	}
}
