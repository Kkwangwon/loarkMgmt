package loarkMgmt.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import loarkMgmt.parser.UserParser;

public class FileModuleUtil {
	
	private static String BASE_DIR = "C://userConfig/";
	
	//make loa userdata savefile
	public static void createUserData(JSONObject userObj, JSONObject hwObj) throws Exception {
		try {
			if(userObj != null) {
				String nameInfo = "nameInfo/" + ((JSONObject) ((JSONArray) userObj.get("characterInfo")).get(0)).get("name").toString();
				String homeWorkInfo = "homeWorkInfo/" + ((JSONObject) ((JSONArray) userObj.get("characterInfo")).get(0)).get("name").toString();
				
				File file1 = new File(BASE_DIR+nameInfo+".json");
				File file2 = new File(BASE_DIR+homeWorkInfo+".json");
				
				file1.mkdirs();
				file2.mkdirs();
				if(file1.exists()) {
					file1.delete();
				}
				if(file2.exists()) {
					file2.delete();
				}
				file1.createNewFile();
				file2.createNewFile();
				
				BufferedWriter writer1  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1.getAbsolutePath()), "MS949"));
				BufferedWriter writer2  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2.getAbsolutePath()), "MS949"));
				String user = userObj.toJSONString();
				String homeWork = hwObj.toJSONString();
				writer1.write(user);
				writer2.write(homeWork);
				writer1.close();
				writer2.close();
				
			}else {
				throw new Exception();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//load loa userdata savefile
	public static List<JSONObject> loadUserData() {
		File dir = new File(BASE_DIR+"nameInfo/");
		File[] fileList = dir.listFiles();
		JSONObject obj = null;
		List<JSONObject> objList = new ArrayList<>();
		if(dir.listFiles() !=null && dir.listFiles().length>0) {
			for(int i = 0; i<fileList.length; i++) {
				obj = UserParser.parse(fileList[i]);
				objList.add(obj);
			}
		}
		return objList;
	}
	
	
	//make loa homework savefile
	public static void saveHomeWorkData(String charName, JSONObject homeWorkObj) throws Exception {
		try {
			if(charName != null) {
				String homeWorkInfo = "homeWorkInfo/" + charName;
				
				File file = new File(BASE_DIR+homeWorkInfo+".json");
				
				file.mkdirs();
				
				if(file.exists()) {
					file.delete();
				}
				file.createNewFile();
		
				BufferedWriter writer  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), "MS949"));
				String homeWork = homeWorkObj.toJSONString();
				writer.write(homeWork);
				writer.close();
				
			}else {
				throw new Exception();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//load loa homework savefile
	public static JSONObject loadHomeWorkData(String charName) {
		File dir = new File(BASE_DIR+"homeWorkInfo/"+charName+".json");
		JSONObject obj = new JSONObject();
		obj = UserParser.parse(dir);
		return obj;
	}
	
	public static void userDelete(String charName) {
		File file1 = new File(BASE_DIR+"nameInfo/"+charName+".json");
		File file2 = new File(BASE_DIR+"homeWorkInfo/"+charName+".json");
		if(file1.exists()) {
			file1.delete();
			file2.delete();
		}
		
	}

}
