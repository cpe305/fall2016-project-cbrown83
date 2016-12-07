import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray; 


// singleton class
public class TextWriter {
	
	private static TextWriter instance = null;
	private static JSONObject gameScript; 
	
	protected TextWriter() {
		try {
			gameScript = getGameText();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TextWriter getInstance() {
		if (instance == null) {
			instance = new TextWriter();
		}
		return instance; 
	}
	
	public void printGameText(String textType, boolean wait) {
		
		try {
			if (gameScript.containsKey(textType)) {
				String text = gameScript.get(textType).toString(); 
				System.out.println(text); 
				if (wait) {waitForContinue();}
			}
			else {
				throw new Exception("Invalid JSON Key");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printOptionText(String scriptKey) 
	{
		try {
			if (gameScript.containsKey(scriptKey)) {
				JSONArray options = (JSONArray) gameScript.get(scriptKey); 
				Iterator<String> iterator = options.iterator(); 
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
			}
			else {
				throw new Exception("Invalid JSON Key");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void waitForContinue() 
	{
		System.out.print(gameScript.get("continue").toString()); 
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
			JSONObject JSONObject = (JSONObject) obj;
			
			return JSONObject; 
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		throw new Exception("JSON Parsing Error");
	}
	
	public static JSONObject getGameScript() {
		return gameScript; 
	}
}
