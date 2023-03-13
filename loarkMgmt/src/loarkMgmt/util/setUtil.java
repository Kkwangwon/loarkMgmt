package loarkMgmt.util;

import org.json.simple.JSONObject;

import loarkMgmt.dto.userDto;

public class setUtil {
	
	public static JSONObject userSet(String server, String name, int level, String charClass, String charJob) {
		userDto ud = new userDto();
		ud.setServer(server);
		ud.setName(name);
		ud.setLevel(level);
		ud.setCharClass(charClass);
		ud.setCharJob(charJob);
		
		JSONObject obj = ud.toJson();
		
		return obj;
	}
	
	public static JSONObject homeWorkSet(boolean valtan, boolean biakiss, boolean kouku_saton, boolean abrelshud,boolean illiakan, boolean abyssOfKayangel, boolean abyssOfVoldaik, boolean chaos_dungeon, boolean guardian_conquest,boolean challenge_guardian_conquest,boolean challenge_abyss_dungeon) {
		
		
		
		return null;
		
	}

}
