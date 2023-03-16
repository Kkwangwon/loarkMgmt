package loarkMgmt.dto;

import org.json.simple.JSONObject;

public class HomeWorkDto {
 
	//keySet
 public static String[] homeWorkKey = {"valtan","biackiss","kouku_saton","abrelshud","illiakan","abyssOfKayangel","abyssOfVoldaik","challenge_guardian_conquest","challenge_abyss_dungeon"};
	
 private String charName;
 private String valtan;
 private String biackiss;
 private String kouku_saton;
 private String abrelshud;
 private String illiakan;
 private String abyssOfKayangel;
 private String abyssOfVoldaik;
 private String challenge_guardian_conquest;
 private String challenge_abyss_dungeon;
 
 public String getCharName() {
	 return charName;
}
 public void setCharName(String charName) {
	 this.charName = charName;
}
 public String isValtan() {
	return valtan;
}
public void setValtan(String valtan) {
	this.valtan = valtan;
}
public String isBiackiss() {
	return biackiss;
}
public void setBiackiss(String biackiss) {
	this.biackiss = biackiss;
}
public String isKouku_saton() {
	return kouku_saton;
}
public void setKouku_saton(String kouku_saton) {
	this.kouku_saton = kouku_saton;
}
public String isAbrelshud() {
	return abrelshud;
}
public void setAbrelshud(String abrelshud) {
	this.abrelshud = abrelshud;
}
public String isIlliakan() {
	return illiakan;
}
public void setIlliakan(String illiakan) {
	this.illiakan = illiakan;
}
public String isAbyssOfKayangel() {
	return abyssOfKayangel;
}
public void setAbyssOfKayangel(String abyssOfKayangel) {
	this.abyssOfKayangel = abyssOfKayangel;
}
public String isAbyssOfVoldaik() {
	return abyssOfVoldaik;
}
public void setAbyssOfVoldaik(String abyssOfVoldaik) {
	this.abyssOfVoldaik = abyssOfVoldaik;
}
public String isChallenge_guardian_conquest() {
	return challenge_guardian_conquest;
}
public void setChallenge_guardian_conquest(String challenge_guardian_conquest) {
	this.challenge_guardian_conquest = challenge_guardian_conquest;
}
public String isChallenge_abyss_dungeon() {
	return challenge_abyss_dungeon;
}
public void setChallenge_abyss_dungeon(String challenge_abyss_dungeon) {
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
