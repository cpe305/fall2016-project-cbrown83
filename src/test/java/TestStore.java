import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

public class TestStore {
	
	TextWriter writer = TextWriter.getInstance(); 
	JSONObject script = writer.getGameScript(); 
	
	City tokyo = new City("Tokyo", "lankmark1");
	Store store = new Store(tokyo, script); 
	
	@Test
	public void testCost() {
		try {
			JSONObject script = writer.getGameText(); 
			assertEquals("Testing cost method...", 
					1, 
					store.cost("carrot", script));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// test too much weight
	// test buy items 
		//-updates inventory
		//-updates sleigh weight
	// test invalid number
	// test available weight display
	// test correct inventory
	// test item prices
	// test multiple string input for options

}
