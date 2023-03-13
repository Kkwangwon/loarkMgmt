package loarkMgmt.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class userParser {

	public static JSONObject parse(File fileList){
		JSONParser parser = new JSONParser();
		Reader reader = null;
		JSONObject obj = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileList), "UTF-8"));
			obj = (JSONObject) parser.parse(br);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


}
