package loarkMgmt.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

import loarkMgmt.util.FileModuleUtil;
import loarkMgmt.util.SetUtil;

public class LAM extends JFrame{
	
	//main panel
	private JPanel mainPanel;
	
	//button
	private JButton loadUserDataBtn;
	private JButton saveUserDataBtn;
	private JButton loadUserHomeWorkDataBtn;
	private JButton saveUserHomeWorkDataBtn;
	
	//textField
	private JTextField serverTextField;
	private JTextField nameTextField;
	private JTextField levelTextField;
	private JTextField charClassTextField;
	private JTextField charJobTextField;
	
	//scrollPane
	private JScrollPane charListScrollPane;
	private JScrollPane homeWorkScrollPane;
	
	
	
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