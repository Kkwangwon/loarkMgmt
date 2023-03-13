package loarkMgmt.util;

import org.json.simple.JSONObject;

import loarkMgmt.dto.userDto;

public class userSetUtil {
	
	public static JSONObject userSet(String server, String name, int level, String charClass, String charJob) {
		userDto uc = new userDto();
		uc.setServer(server);
		uc.setName(name);
		uc.setLevel(level);
		uc.setCharClass(charClass);
		uc.setCharJob(charJob);
		
		JSONObject obj = uc.toJson();
		
		return obj;
	}

}
