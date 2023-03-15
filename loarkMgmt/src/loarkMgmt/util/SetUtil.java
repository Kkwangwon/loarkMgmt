package loarkMgmt.util;

import org.json.simple.JSONObject;

import loarkMgmt.dto.HomeWorkDto;
import loarkMgmt.dto.UserDto;

public class SetUtil {
	
	public static JSONObject userSet(String server, String name, int level, String charClass, String charJob) {
		UserDto ud = new UserDto();
		ud.setServer(server);
		ud.setName(name);
		ud.setLevel(level);
		ud.setCharClass(charClass);
		ud.setCharJob(charJob);
		
		JSONObject obj = ud.toJson();
		
		return obj;
	}
	
	public static JSONObject homeWorkSet(String charName, boolean valtan, boolean biackiss, boolean kouku_saton, boolean abrelshud,boolean illiakan, boolean abyssOfKayangel, boolean abyssOfVoldaik, boolean challenge_guardian_conquest, boolean challenge_abyss_dungeon) {
		HomeWorkDto hwd = new HomeWorkDto();
		
		hwd.setCharName(charName);
		hwd.setValtan(valtan);
		hwd.setBiackiss(biackiss);
		hwd.setKouku_saton(kouku_saton);
		hwd.setAbrelshud(abrelshud);
		hwd.setIlliakan(illiakan);
		hwd.setAbyssOfKayangel(abyssOfKayangel);
		hwd.setAbyssOfVoldaik(abyssOfVoldaik);
		hwd.setChallenge_guardian_conquest(challenge_guardian_conquest);
		hwd.setChallenge_abyss_dungeon(challenge_abyss_dungeon);
		
		JSONObject obj = hwd.toJson();
		
		return obj;
	}
	public static JSONObject createHomeWorkSet(String charName) {
		HomeWorkDto hwd = new HomeWorkDto();
		
		hwd.setCharName(charName);
		hwd.setValtan(false);
		hwd.setBiackiss(false);
		hwd.setKouku_saton(false);
		hwd.setAbrelshud(false);
		hwd.setIlliakan(false);
		hwd.setAbyssOfKayangel(false);
		hwd.setAbyssOfVoldaik(false);
		hwd.setChallenge_guardian_conquest(false);
		hwd.setChallenge_abyss_dungeon(false);
		
		JSONObject obj = hwd.toJson();
		
		return obj;
		
	}

}
