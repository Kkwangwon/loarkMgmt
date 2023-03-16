package loarkMgmt.dto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UserDto {
	
	//keySet
	public static String[] userKey = {"server","name","level","charClass","charJob"};
	
	private String server;
	private String name;
	private int level;
	private String charClass;
	private String charJob;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCharClass() {
		return charClass;
	}
	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}
	public String getCharJob() {
		return charJob;
	}
	public void setCharJob(String charJob) {
		this.charJob = charJob;
	}
	
	public JSONObject toJson() {
		
		JSONObject obj = new JSONObject();
		obj.put("server",server);
		obj.put("name",name);
		obj.put("level", level);
		obj.put("charClass", charClass);
		obj.put("charJob", charJob);
		
		return obj;
		
	}
	
}
