import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Test;
	
public class TestCity {
	City tokyo = new City("Tokyo", "landmark1");
	City paris = new City("Paris", "landmark2");
	
	@Test 
	public void testGetName() {
		assertEquals(tokyo.getName(), "Tokyo");
		assertEquals(paris.getName(), "Paris");
	}
		
	@Test 
	public void testGetLandmark() {
		assertEquals(tokyo.getLandmark(), "landmark1");
		assertEquals(paris.getLandmark(), "landmark2");
	}
	
	@Test 
	public void testSetNextCity() {
		tokyo.setNextCity(paris);
		paris.setNextCity(tokyo);
		
		assertEquals(tokyo.getNextCity(), paris);
		assertEquals(paris.getNextCity(), tokyo);
	}
	
	@Test
	public void testVisit() {
		TextWriter writer = TextWriter.getInstance();
		try {
			JSONObject script = writer.getGameText();
			
			assertNull(tokyo.getStore());
			assertFalse(tokyo.isVisited());
			tokyo.visit(script);
			assertTrue(tokyo.isVisited());
			assertNotNull(tokyo.getStore());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
