import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject; 


public class Store {	 
	City city; 
	List<String> itemList = new ArrayList<String>(); 

	
	// Item names must be in format to print out
	public Store(City city, JSONObject script) {
		this.city = city; 
		String cityInventory; 
		String key = "inventory" + city.getName(); 
		
		try {
			cityInventory = (String) script.get(key);
			// construct list of items in store 
			for (String item : cityInventory.split(" ")) {
				itemList.add(item); 
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int cost(String item, JSONObject script) {
		return Integer.valueOf(script.get(item).toString());
	}
	
	public void visit(Santa santa, Sleigh sleigh, JSONObject script) {
		System.out.println("Welcome to the store at " + city.getLandmark());
		System.out.println("Here are the store items and their cost: ");

		String item;
		for (int i = 0; i < itemList.size(); i++) {
			item = itemList.get(i);
			System.out.println(i+1 + ". " + item + " (" + script.get(item) + "lb)");
		}
		System.out.println(itemList.size()+1 + ". Exit");
		System.out.println();
		
		shop(itemList, santa, sleigh, script);
	}
	
	public void shop(List<String> itemList, Santa santa, Sleigh sleigh, JSONObject script) {
		int quantity; 
		int itemNum; 
		InputReader reader = InputReader.getInstance(); 
		while (sleigh.hasCapacity()) {
			System.out.println("You have " + sleigh.getRemainingCapacity() + "lb left.");
			System.out.print("Which item would you like to add? (Enter #) ");
			itemNum = reader.getInput(1, itemList.size()+1);

			if (itemNum == (itemList.size() + 1)) { 
				System.out.println("Exiting store...");
				return; 
			}
			else {
				System.out.print("How many would you like? ");
				quantity = Integer.parseInt(reader.getInput());
				if (Integer.parseInt((String)script.get(itemList.get(itemNum-1))) * quantity > sleigh.getRemainingCapacity()) {
					System.out.println("Weight exceeds remaining capacity; item was not added"); 
					System.out.println(); 
				}
				else {
					santa.updateInventory(itemList.get(itemNum-1), quantity, script);
				}
			}
		}
	}
}
