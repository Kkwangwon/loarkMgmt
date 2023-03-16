package loarkMgmt.util;

import org.json.simple.JSONObject;

public class FormUtil {
	
	public static String jsonToTextareaForm(JSONObject obj, String[] key) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<key.length; i++) {
			String value = obj.get(key[i]).toString();
			if(i==key.length-1) {
				sb.append(key[i]+" : "+value);
			}else {
				sb.append(key[i]+" : "+value+"\n\n");
			}
		}
		String result = sb.toString();
		return result;
	}
}
