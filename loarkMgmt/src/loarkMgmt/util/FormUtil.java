package loarkMgmt.util;

import org.json.simple.JSONObject;

public class FormUtil {
	
	public static String jsonToTextareaFormUser(JSONObject obj, String[] key) {
		StringBuilder sb = new StringBuilder();
		String[] userKey = {"����","�̸�","����","������","Ŭ����"};
		for(int i = 0; i<key.length; i++) {
			String value = obj.get(key[i]).toString();
			if(i==key.length-1) {
				sb.append(userKey[i]+" : "+value);
			}else {
				sb.append(userKey[i]+" : "+value+"\n\n");
			}
		}
		String result = sb.toString();
		return result;
	}
}
