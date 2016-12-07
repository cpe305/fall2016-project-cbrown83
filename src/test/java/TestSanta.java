import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

public class TestSanta {
	Santa santa = new Santa(); 
	TextWriter writer = TextWriter.getInstance();
	
	@Test
	public void testConstructor() {
		assertEquals("Testing constructor...", 
				250, 
				santa.getWeight()); 
	}
	
	@Test
	public void testDeliverPresents() {
		santa.successfulDelivery();
		assertEquals("Testing successfulDelivery - updated weight...", 
				230, 
				santa.getWeight());
		assertEquals("Testing successfulDelivery - updated delivered count...", 
				1, 
				santa.getPresentsDelivered());
	}
	
	@Test
	public void testCost() {
		try {
			JSONObject script = writer.getGameText(); 
			assertEquals("Testing cost method...", 
					1, 
					santa.cost("carrot", script));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test 
	public void testUpdateInventory() {
		try {
			JSONObject script = writer.getGameText(); 
			
			// ADD CARROT
			santa.updateInventory("carrot", 5, script);
			assertEquals("Testing updateInventory - updated inventory (carrot)...", 
					5, 
					santa.getCarrots());		
			assertEquals("Testing updateInventory - updated weight (carrot)...", 
					255, 
					santa.getWeight());
			
			// ADD GINGERBREAD MEN
			santa.updateInventory(Game.GINGERBREAD_MEN, 2, script);
			assertEquals("Testing updateInventory - updated inventory (gingerbreadMen)...", 
					4, 
					santa.getGingerbreadMen());
			assertEquals("Testing updateInventory - updated weight (gingerbreadMen)...", 
					259, 
					santa.getWeight()); 
			
			// ADD HOT COCOA
			santa.updateInventory(Game.HOT_COCOA, 2, script);
			assertEquals("Testing updateInventory - updated inventory (hotCocoa)...", 
					6, 
					santa.getHotCocoa()); 
			assertEquals("Testing updateInventory - updated weight (hotCocoa)...", 
					265, 
					santa.getWeight());
			
			// ADD SANTA HAT
			santa.updateInventory(Game.SANTA_HAT, 1, script);
			assertEquals("Testing updateInventory - updated inventory (santaHat)...", 
					4, 
					santa.getSantaHat()); 
			assertEquals("Testing updateInventory - updated weight (santaHat)...", 
					269, 
					santa.getWeight()); 
			
			// ADD SANTA COAT
			santa.updateInventory(Game.SANTA_COAT, 2, script);
			assertEquals("Testing updateInventory - updated inventory (santaCoat)...", 
					10, 
					santa.getSantaCoat()); 
			assertEquals("Testing updateInventory - updated weight (santaCoat)...", 
					279, 
					santa.getWeight()); 
	
			// ADD CANDY CANES
			santa.updateInventory(Game.CANDY_CANES, 5, script);
			assertEquals("Testing updateInventory - updated inventory (candyCanes)...", 
					50, 
					santa.getCandyCanes()); 
			assertEquals("Testing updateInventory - updated weight (candyCanes)...", 
					329, 
					santa.getWeight()); 
	
			// ADD SLEIGH PARTS
			santa.updateInventory(Game.SLEIGH_PARTS, 2, script);
			assertEquals("Testing updateInventory - updated inventory (sleighParts)...", 
					20, 
					santa.getSleighParts()); 
			assertEquals("Testing updateInventory - updated weight (sleighParts)...", 
					349, 
					santa.getWeight()); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
