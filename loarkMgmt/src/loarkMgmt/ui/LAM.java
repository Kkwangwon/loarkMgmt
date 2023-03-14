package loarkMgmt.ui;

import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import loarkMgmt.ui.LAM.SetCharInfoFrame;
import loarkMgmt.util.FileModuleUtil;
import loarkMgmt.util.SetUtil;
import loarkMgmt.util.TextAreaOutputStream;

public class LAM extends JFrame{
	
	//main panel
	private JPanel mainPanel;
	
	//charset panel
	private JPanel charSetPanel;
	
	//button
	private JButton loadUserDataBtn;
	
	private JButton saveUserDataBtn;
	private JButton saveUserPaneBtn;
	
	private JButton loadUserHomeWorkDataBtn;
	private JButton saveUserHomeWorkDataBtn;
	
	//DefaultListModel
	private DefaultListModel<String> charListModel;
	
	
	//JList
	private JList<String> charList;
	
	//textField
	private JTextField serverTextField;
	private JTextField nameTextField;
	private JTextField levelTextField;
	private JTextField charClassTextField;
	private JTextField charJobTextField;
	private JTextField setServerTextField;
	private JTextField setNameTextField;
	private JTextField setLevelTextField;
	private JTextField setCharClassTextField;
	private JTextField setCharJobTextField; 
	
	//scrollPane
	private JScrollPane charListScrollPane;
	private JScrollPane homeWorkScrollPane;
	private JScrollPane logScrollPane;
	
	//checkBox
	private JCheckBox valtan;
	private JCheckBox biackiss;
	private JCheckBox kouku_saton;
	private JCheckBox abrelshud;
	private JCheckBox illiakan;
	private JCheckBox abyssOfKayangel;
	private JCheckBox abyssOfVoldaik;
	private JCheckBox challenge_guardian_conquest;
	private JCheckBox challenge_abyss_dungeon;
	
	//TextArea
	private JTextArea logTextArea;

	public static void main(String[] args){
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
	
	public ActionListener buttonActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == loadUserDataBtn) {
				charListModel = new DefaultListModel<String>();
				List<JSONObject> objList = FileModuleUtil.loadUserData();
				if(!objList.isEmpty()) {
				String charInfo = null;
				String charName = null;
				String charServer = null;
				for(JSONObject o : objList) {
					charName =  ((JSONObject) ((JSONArray) o.get("characterInfo")).get(0)).get("name").toString();
					charServer =  o.get("server").toString();
					charInfo = "<"+charServer+">    "+charName;
					charListModel.addElement(charInfo);
				}
				charList = new JList<String>(charListModel);
				charList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				charListScrollPane.setViewportView(charList);
				System.out.println("유저정보 로드 완료");
				}else {
					System.out.println("유저 정보가 없습니다!");
				}
			}
			if(e.getSource() == saveUserPaneBtn) {
				try {
					SetCharInfoFrame setCharInfoFrame = new SetCharInfoFrame();
					setCharInfoFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
			if(e.getSource()==saveUserDataBtn) {
				String server = setServerTextField.getText();
				String name = setNameTextField.getText();
				int level = Integer.parseInt(setLevelTextField.getText());
				String charClass = setCharClassTextField.getText();
				String charJob = setCharJobTextField.getText();
				JSONObject userObj = SetUtil.userSet(server, name, level, charClass, charJob);
				try {
					SetCharInfoFrame setCharInfoFrame = new SetCharInfoFrame();
					FileModuleUtil.saveUserData(userObj);
					System.out.println("유저정보 저장 완료!");
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("유저정보 저장 실패 ㅠ.ㅠ");
				}
			}
		}
	};
	
	public LAM() throws Exception{
		/*main Frame*/
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setTitle("LostArk HomeWork Of Week Management");
		setSize(1280,640);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*main Pane*/
		mainPanel = new JPanel();
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		/*logScrollPane*/
		logScrollPane = new JScrollPane();
		logScrollPane.setBounds(12,449,1240,125);
		mainPanel.add(logScrollPane);
		logTextArea = new JTextArea();
		logScrollPane.setViewportView(logTextArea);
		logTextArea.setEditable(false);
		logTextArea.setLineWrap(true);
		logTextArea.setWrapStyleWord(true);
		
		PrintStream con = new PrintStream(new TextAreaOutputStream(logTextArea));
		System.setOut(con);
		System.setErr(con);
		
		saveUserPaneBtn = new JButton("유저 정보 설정");
		saveUserPaneBtn.addActionListener(buttonActionListener);
		saveUserPaneBtn.setBounds(10,400,150,30);
		mainPanel.add(saveUserPaneBtn);
		
		loadUserDataBtn = new JButton("유저 정보 로드");
		loadUserDataBtn.addActionListener(buttonActionListener);
		loadUserDataBtn.setBounds(361,400,150,30);
		mainPanel.add(loadUserDataBtn);
		
		charListScrollPane = new JScrollPane();
		charListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		charListScrollPane.setBounds(10,10,500,370);
		mainPanel.add(charListScrollPane);
		
	}
	
	class SetCharInfoFrame extends JFrame{
		public SetCharInfoFrame() throws Exception {
			
			/*charSet Pane*/
			charSetPanel = new JPanel();
			charSetPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			setContentPane(charSetPanel);
			charSetPanel.setLayout(null);
			
			setServerTextField = new JTextField();
			setServerTextField.setText("");
			setServerTextField.setColumns(12);
			setServerTextField.setSize(200,30);
			setServerTextField.setLocation(95,60);
			charSetPanel.add(setServerTextField);
			
			setNameTextField = new JTextField();
			setNameTextField.setText("");
			setNameTextField.setColumns(12);
			setNameTextField.setSize(200,30);
			setNameTextField.setLocation(95,120);
			charSetPanel.add(setNameTextField);
			
			setLevelTextField = new JTextField();
			setLevelTextField.setText("");
			setLevelTextField.setColumns(12);
			setLevelTextField.setSize(200,30);
			setLevelTextField.setLocation(95,180);
			charSetPanel.add(setLevelTextField);
			
			setCharClassTextField = new JTextField();
			setCharClassTextField.setText("");
			setCharClassTextField.setColumns(12);
			setCharClassTextField.setSize(200,30);
			setCharClassTextField.setLocation(95,240);
			charSetPanel.add(setCharClassTextField);
			
			setCharJobTextField = new JTextField();
			setCharJobTextField.setText("");
			setCharJobTextField.setColumns(12);
			setCharJobTextField.setSize(200,30);
			setCharJobTextField.setLocation(95,300);
			charSetPanel.add(setCharJobTextField);
			
			saveUserDataBtn = new JButton("유저 정보 저장");
			saveUserDataBtn.addActionListener(buttonActionListener);
			saveUserDataBtn.setBounds(10,10,150,30);
			charSetPanel.add(saveUserDataBtn);
			
			
			setTitle("Set User Info");
			setSize(400,400);
			setLocationRelativeTo(null);
			setResizable(false);
			setVisible(false);
			setLayout(null);
			
		}
		

	}
	
	
}
