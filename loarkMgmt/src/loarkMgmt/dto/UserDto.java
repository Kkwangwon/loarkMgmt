package loarkMgmt.dto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UserDto {
	private String name;
	private int level;
	private String charClass;
	private String charJob;
	private String server;
	
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
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	
	public JSONObject toJson() {
		
		JSONObject sobj = new JSONObject();
		sobj.put("name",name);
		sobj.put("level", level);
		sobj.put("charClass", charClass);
		sobj.put("charJob", charJob);
		
		JSONArray arr = new JSONArray();
		arr.add(sobj);
		
		JSONObject obj = new JSONObject();
		obj.put("server",server);
		obj.put("characterInfo", arr);
		
		return obj;
		
	}
	
}
