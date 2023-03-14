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
	
	public static JSONObject homeWorkSet(boolean valtan, boolean biackiss, boolean kouku_saton, boolean abrelshud,boolean illiakan, boolean abyssOfKayangel, boolean abyssOfVoldaik, boolean chaos_dungeon, boolean guardian_conquest,boolean challenge_guardian_conquest,boolean challenge_abyss_dungeon) {
		HomeWorkDto hwd = new HomeWorkDto();
		
		hwd.setValtan(valtan);
		hwd.setBiackiss(biackiss);
		hwd.setKouku_saton(kouku_saton);
		hwd.setAbrelshud(abrelshud);
		hwd.setIlliakan(illiakan);
		hwd.setAbyssOfKayangel(abyssOfKayangel);
		hwd.setAbyssOfVoldaik(abyssOfVoldaik);
		hwd.setChaos_dungeon(chaos_dungeon);
		hwd.setGuardian_conquest(guardian_conquest);
		hwd.setChallenge_guardian_conquest(challenge_guardian_conquest);
		hwd.setChallenge_abyss_dungeon(challenge_abyss_dungeon);
		
		JSONObject obj = hwd.toJson();
		
		return obj;
		
	}

}
