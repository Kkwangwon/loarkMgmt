package loarkMgmt.ui;

import org.json.simple.JSONObject;

import loarkMgmt.dto.userConfig;
import loarkMgmt.util.userSetUtil;

public class LAM {

	public static void main(String[] args) {
		
		JSONObject obj = userSetUtil.userSet("�ѱ�", "�Ǳ���", 28, "free", "it");
		
		String k = obj.toString();
		System.out.println(k);
	}

}
