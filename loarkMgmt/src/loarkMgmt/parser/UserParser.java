package loarkMgmt.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class UserParser {

	public static JSONObject parse(File fileList){
		JSONParser parser = new JSONParser();
		StringBuilder sb = null;
		JSONObject obj = null;
		String str  = null;
		String payload = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileList),"MS949"));
			sb = new StringBuilder();
			while((str = br.readLine()) !=null) {
				sb.append(str);
			}
			br.close();
			payload = sb.toString();
			obj = (JSONObject) parser.parse(payload);
			sb = sb != null ? null: null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


}
