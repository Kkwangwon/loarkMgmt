package loarkMgmt.dto;

import org.json.simple.JSONObject;

public class HomeWorkDto {
 private boolean valtan;
 private boolean biackiss;
 private boolean kouku_saton;
 private boolean abrelshud;
 private boolean illiakan;
 private boolean abyssOfKayangel;
 private boolean abyssOfVoldaik;
 private boolean challenge_guardian_conquest;
 private boolean challenge_abyss_dungeon;
 
 public boolean isValtan() {
	return valtan;
}
public void setValtan(boolean valtan) {
	this.valtan = valtan;
}
public boolean isBiackiss() {
	return biackiss;
}
public void setBiackiss(boolean biackiss) {
	this.biackiss = biackiss;
}
public boolean isKouku_saton() {
	return kouku_saton;
}
public void setKouku_saton(boolean kouku_saton) {
	this.kouku_saton = kouku_saton;
}
public boolean isAbrelshud() {
	return abrelshud;
}
public void setAbrelshud(boolean abrelshud) {
	this.abrelshud = abrelshud;
}
public boolean isIlliakan() {
	return illiakan;
}
public void setIlliakan(boolean illiakan) {
	this.illiakan = illiakan;
}
public boolean isAbyssOfKayangel() {
	return abyssOfKayangel;
}
public void setAbyssOfKayangel(boolean abyssOfKayangel) {
	this.abyssOfKayangel = abyssOfKayangel;
}
public boolean isAbyssOfVoldaik() {
	return abyssOfVoldaik;
}
public void setAbyssOfVoldaik(boolean abyssOfVoldaik) {
	this.abyssOfVoldaik = abyssOfVoldaik;
}
public boolean isChallenge_guardian_conquest() {
	return challenge_guardian_conquest;
}
public void setChallenge_guardian_conquest(boolean challenge_guardian_conquest) {
	this.challenge_guardian_conquest = challenge_guardian_conquest;
}
public boolean isChallenge_abyss_dungeon() {
	return challenge_abyss_dungeon;
}
public void setChallenge_abyss_dungeon(boolean challenge_abyss_dungeon) {
	this.challenge_abyss_dungeon = challenge_abyss_dungeon;
}

public JSONObject toJson() {
	
	JSONObject obj = new JSONObject();
	obj.put("valtan",valtan);
	obj.put("biackiss",biackiss);
	obj.put("kouku_saton",kouku_saton);
	obj.put("abrelshud",abrelshud);
	obj.put("illiakan",illiakan);
	obj.put("abyssOfKayangel",abyssOfKayangel);
	obj.put("abyssOfVoldaik",abyssOfVoldaik);
	obj.put("challenge_guardian_conquest",challenge_guardian_conquest);
	obj.put("challenge_abyss_dungeon",challenge_abyss_dungeon);
	
	return obj;
}


}
