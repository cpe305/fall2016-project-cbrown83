import java.io.FileReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// singleton class
public class TextFormatter {
	
	private static TextFormatter instance = null;
	private static JSONObject gameScript = null; 
	
	protected TextFormatter() {
		try {
			gameScript = getGameText();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TextFormatter getInstance() {
		if (instance == null) {
			instance = new TextFormatter();
		}
		return instance; 
	}
	
	public void printGameText(String textType) {
		
		try {
			if (gameScript.containsKey(textType)) {
				String text = gameScript.get(textType).toString(); 
				System.out.println(text); 
				waitForContinue();
			}
			else {
				throw new Exception("Invalid JSON Key");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void waitForContinue() {
		try {
			int nextChar = System.in.read();  
			while (nextChar != '\n') {
				nextChar = System.in.read(); 
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public JSONObject getGameText() throws Exception {
		JSONParser reader = new JSONParser(); 
	
		try {
			
			URL url = getClass().getResource("gameScript.json");
			Object obj = reader.parse(new FileReader(
					url.getPath()));
			JSONObject jsonObject = (JSONObject) obj;
			
			return jsonObject; 
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		throw new Exception("JSON Parsing Error");
	}
}
