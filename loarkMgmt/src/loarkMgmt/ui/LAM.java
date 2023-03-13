package loarkMgmt.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.json.simple.JSONObject;

import loarkMgmt.util.fileModuleUtil;
import loarkMgmt.util.userSetUtil;

public class LAM extends JFrame{
	
	private JButton loadUserDataBtn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try{
					LAM frame = new LAM();
					frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setButtonStatus(JButton button, boolean enabled) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				button.setEnabled(enabled);
			}
		});
	}
//	public ActionListener buttonActionListener = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			if(e.getSource() = loadUserDataBtn) {
//				List<JSONObject> objList = fileModuleUtil.loadUserData();
//			}else {
//				e.getID();
//			}
//		}
//	};
//	
	
	
}

/*
 * try { JSONObject obj = userSetUtil.userSet("ÇÑ±¹", "±Ç±¤¿ø", 28, "free", "it");
 * fileModuleUtil.saveUserData(obj); String k = obj.toString();
 * System.out.println(k); } catch (Exception e) { // TODO Auto-generated catch
 * block e.printStackTrace(); }
 */