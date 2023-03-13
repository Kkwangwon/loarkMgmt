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

import loarkMgmt.parser.userParser;

public class fileModuleUtil {
	
	private static String BASE_DIR = "C://userConfig/";
	
	//make loa userdata savefile
	public static void saveUserData(JSONObject obj) throws Exception {
		try {
			if(obj != null) {
				String nameInfo = "nameInfo/" + ((JSONObject) ((JSONArray) obj.get("characterInfo")).get(0)).get("name").toString();
				
				File file = new File(BASE_DIR+nameInfo+".json");
				
				file.mkdirs();
				
				if(file.exists()) {
					file.delete();
				}
				file.createNewFile();
		
				BufferedWriter writer  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), "MS949"));
				String user = obj.toJSONString();
				writer.write(user);
				writer.close();
				
			}else {
				throw new Exception();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
				obj = userParser.parse(fileList[i]);
				objList.add(obj);
			}
		}
		return objList;
	}
	
	
	//make loa homework savefile
	public static void saveHomeWorkData(JSONObject charObj, JSONObject homeWorkObj) throws Exception {
		try {
			if(charObj != null) {
				String homeWorkInfo = "homeWorkInfo/" + ((JSONObject) ((JSONArray) charObj.get("characterInfo")).get(0)).get("name").toString();
				
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//load loa homework savefile
	public static List<JSONObject> loadHomeWorkData() {
		File dir = new File(BASE_DIR+"homeWorkInfo/");
		File[] fileList = dir.listFiles();
		JSONObject obj = null;
		List<JSONObject> objList = new ArrayList<>();
		if(dir.listFiles() !=null && dir.listFiles().length>0) {
			for(int i = 0; i<fileList.length; i++) {
				obj = userParser.parse(fileList[i]);
				objList.add(obj);
			}
		}
		return objList;
	}

}
