import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Test;
	
public class TestCity {
	City tokyo = new City("Tokyo", "landmark1");
	City paris = new City("Paris", "landmark2");
	
	@Test 
	public void testGetName() {
		assertEquals("Testing Tokyo...", tokyo.getName(), "Tokyo");
		assertEquals("Testing Paris...", paris.getName(), "Paris");
	}
		
	@Test 
	public void testGetLandmark() {
		assertEquals("Testing Tokyo...", tokyo.getLandmark(), "landmark1");
		assertEquals("Testing Tokyo...", paris.getLandmark(), "landmark2");
	}
	
	@Test 
	public void testSetNextCity() {
		tokyo.setNextCity(paris);
		paris.setNextCity(tokyo);
		
		assertEquals("Testing Tokyo...", tokyo.getNextCity(), paris);
		assertEquals("Testing Paris...", paris.getNextCity(), tokyo);
	}
	
	@Test
	public void testVisit() {
		TextWriter writer = TextWriter.getInstance();
		try {
			JSONObject script = writer.getGameText();
			
			assertNull("Testing Tokyo unititialized...", tokyo.getStore());
			assertFalse("Testing Tokyo is not visited...", tokyo.isVisited());
			tokyo.visit(script);
			assertTrue("Testing Tokyo is visited...", tokyo.isVisited());
			assertNotNull("Testing Tokyo store was created", tokyo.getStore());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
