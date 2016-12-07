import java.util.HashMap;

import org.json.simple.JSONObject; 


public class Store {
	 
	String messageKey;
	HashMap<String, Integer> inventory; 
	
	// Item names must be in format to print out
	public Store(City city, JSONObject script) {
		String cityInventory; 
		inventory = new HashMap<String, Integer>(); 
		String key = "inventory" + city.getName(); 
		
		try {
			cityInventory = (String) script.get(key);
			for (String item : cityInventory.split(" ")) {
				inventory.put(item, Integer.valueOf((String)script.get(item)));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void visit() {
		// display welcome message
		// display all keys with associated values
		// ask if user wants to buy anything
		/*writer.printGameText(messageKey, false);
		// print available items
		System.out.println("   Item				Price");
		for (int i = 0; i < items.size(); i++) {
			String item = items.get(i); 
			int price = storeItems.get(item); 
			System.out.println((i+1) + ". " + item + numTabs(item) + price);
		}
		System.out.println((items.size()+1) + ". Exit");
		
		purchaseItems(items);*/
	}
	
	public void buy(String itemName) {
		/*	public void purchaseItems(List<String> items) {
				int itemNum = 0; 
				int quantity = 0; 
		
				while (sleigh.hasCapacity()) {
					System.out.println("You have " + sleigh.getRemainingCapacity() + "lb left.");
					System.out.print("Which item would you like to add? (Enter #) ");
					itemNum = Character.getNumericValue(reader.getInput().charAt(0));
		
					if (itemNum == (items.size() + 1)) { return; }
					
					System.out.print("How many would you like? ");
					quantity = Integer.parseInt(reader.getInput());
					
					santa.updateInventory(items.get(itemNum-1), quantity);
					sleigh.addWeight(storeItems.get(items.get(itemNum-1)) * quantity);
				}
			}*/
	}
}
