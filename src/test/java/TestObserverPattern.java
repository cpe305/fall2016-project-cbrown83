import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Test;

public class TestObserverPattern {
	Santa santa = new Santa(); 
	Sleigh sleigh = new Sleigh(santa);
	TextWriter writer = TextWriter.getInstance(); 
	JSONObject script = writer.getGameScript(); 
	
	@Test 
	public void testUpdateInventoryAddItem() {
		santa.setSleigh(sleigh);
		santa.updateInventory("sleighParts", 2, script);
		assertEquals("Testing santa's weight...", 270, santa.getWeight());
		assertEquals("Testing sleigh weight...", 470, sleigh.getWeight());
		
	}
	
	public void testUpdateInventoryUseItem() {
		santa.updateInventory("carrot", -4, script);
		assertEquals("Testing santa's weight...", 266, santa.getWeight());
		assertEquals("Testing sleigh weight...", 466, sleigh.getWeight());
	}
	
	public void testSuccessfulDelivery() {
		santa.successfulDelivery();
		assertEquals("Testing santa's weight...", 266, santa.getWeight()); 
		assertEquals("Testing sleigh weight...", 446, sleigh.getWeight());
	}
}
