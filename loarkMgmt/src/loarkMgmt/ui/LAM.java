package loarkMgmt.ui;

import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JButton createUserPaneBtn;
	
	private JButton loadUserHomeWorkDataBtn;
	private JButton saveUserHomeWorkDataBtn;
	
	private JButton deleteUserDataBtn;
	
	//DefaultListModel
	private DefaultListModel<String> charListModel;
	private DefaultListModel<Boolean> homeWorkListModel;
	
	
	//iist
	private JList<String> charList;
	private JList<Boolean> homeWorkList;
	
	//textField
	private JTextField setServerTextField;
	private JTextField setNameTextField;
	private JTextField setLevelTextField;
	private JTextField setCharClassTextField;
	private JTextField setCharJobTextField; 
	
	//label
	private JLabel serverLabel;
	private JLabel nameLabel;
	private JLabel levelLabel;
	private JLabel charClassLabel;
	private JLabel charJobLabel;
	private JLabel setServerLabel;
	private JLabel setNameLabel;
	private JLabel setLevelLabel;
	private JLabel setCharClassLabel;
	private JLabel setCharJobLabel; 
	
	//scrollPane
	private JScrollPane charListScrollPane;
	private JScrollPane homeWorkScrollPane;
	private JScrollPane charInfoScrollPane;
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
				List<JSONObject> objList = FileModuleUtil.loadUserData();
				if(!objList.isEmpty()) {
				loadCharList(objList);
				}
				else {
					System.out.println("저장된 캐릭터 목록이 없습니다. 캐릭터를 생성하세요");
					e.setSource(createUserPaneBtn);
				}
			}
			if(e.getSource() == createUserPaneBtn) {
				try {
					SetCharInfoFrame setCharInfoFrame = new SetCharInfoFrame();
					if(!setCharInfoFrame.isFocused()) {
						setCharInfoFrame.dispose();
					}
				} catch (Exception e1) {
					System.out.println("캐릭터 저장창에 문제가 생겼어요. 관리자에게 문의해주세요");
				} 
			}
			
			if(e.getSource()==deleteUserDataBtn) {
				if(charList != null && !charList.isSelectionEmpty()) {
					String value = charList.getSelectedValue();
					int idx = charList.getSelectedIndex();
					String[] nameInfo = value.split("<");
					String charName = nameInfo[0];
					FileModuleUtil.userDelete(charName);
					charListModel.removeElementAt(idx);
					System.out.println("삭제가 정상적으로 이루어졌습니다.");
				}else{
					System.out.println("삭제하고 싶은 캐릭터를 선택해 주세요");
				}
				 
			}
		}
	};
	
	private void loadCharList(List<JSONObject> objList) {
		String charInfo = null;
		String charName = null;
		String charServer = null;
		charListModel = new DefaultListModel<String>();
		for(JSONObject o : objList) {
			charName =  ((JSONObject) ((JSONArray) o.get("characterInfo")).get(0)).get("name").toString();
			charServer =  o.get("server").toString();
			charInfo = charName+"<"+charServer+">";
			charListModel.addElement(charInfo);
		}
		charList = new JList<String>(charListModel);
		charList.addMouseListener(new MouseAdapter() {
			
			
			public void mouseCliked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					selectCharList();
				}
			}	
		
		});
		
		charList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		charListScrollPane.setViewportView(charList);
		System.out.println("로딩 완료!");
		
	}
	
	private void selectCharList() {
		if(charList != null && charList.isSelectionEmpty()) {
			String value = charList.getSelectedValue();
			String[] nameInfo = value.split("<");
			String charName = nameInfo[0];
			JSONObject obj = FileModuleUtil.loadHomeWorkData(charName);
			homeWorkListModel = new DefaultListModel<>();
			homeWorkList = new JList<Boolean>(homeWorkListModel);
			 Boolean valtan = (Boolean) obj.get("valtan");
			 Boolean biackiss = (Boolean) obj.get("biackiss");
			 Boolean kouku_saton = (Boolean) obj.get("kouku_saton");
			 Boolean abrelshud = (Boolean) obj.get("abrelshud");
			 Boolean illiakan = (Boolean) obj.get("illiakan");
			 Boolean abyssOfKayangel = (Boolean) obj.get("abyssOfKayangel");
			 Boolean abyssOfVoldaik = (Boolean) obj.get("abyssOfVoldaik");
			 Boolean challenge_guardian_conquest = (Boolean) obj.get("challenge_guardian_conquest");
			 Boolean challenge_abyss_dungeon = (Boolean) obj.get("challenge_abyss_dungeon");
		}
	}
	
	
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
		
		createUserPaneBtn = new JButton("유저 정보 설정");
		createUserPaneBtn.addActionListener(buttonActionListener);
		createUserPaneBtn.setBounds(10,400,150,30);
		mainPanel.add(createUserPaneBtn);
		
		loadUserDataBtn = new JButton("유저 정보 로드");
		loadUserDataBtn.addActionListener(buttonActionListener);
		loadUserDataBtn.setBounds(185,400,150,30);
		mainPanel.add(loadUserDataBtn);
		
		deleteUserDataBtn = new JButton("유저 정보 삭제");
		deleteUserDataBtn.addActionListener(buttonActionListener);
		deleteUserDataBtn.setBounds(361,400,150,30);
		mainPanel.add(deleteUserDataBtn);
		
		charListScrollPane = new JScrollPane();
		charListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		charListScrollPane.setBounds(10,10,500,190);
		mainPanel.add(charListScrollPane);

		charInfoScrollPane = new JScrollPane();
		charInfoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		charInfoScrollPane.setBounds(10,180,500,210);
		
		serverLabel = new JLabel("aa");
		serverLabel.setLocation(280,220);
		serverLabel.setSize(200,30);
		mainPanel.add(serverLabel);
		
		nameLabel = new JLabel("aa");
		nameLabel.setLocation(280,250);
		nameLabel.setSize(200,30);
		mainPanel.add(nameLabel);
		
		levelLabel = new JLabel("aa");
		levelLabel.setLocation(280,280);
		levelLabel.setSize(200,30);
		mainPanel.add(levelLabel);
		
		charClassLabel = new JLabel("aa");
		charClassLabel.setLocation(280,310);
		charClassLabel.setSize(200,30);
		mainPanel.add(charClassLabel);
		
		charJobLabel = new JLabel("사진이 들어갈 예정");
		charJobLabel.setLocation(20,220);
		charJobLabel.setSize(200,30);
		mainPanel.add(charJobLabel);
		
		homeWorkScrollPane = new JScrollPane();
		homeWorkScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		homeWorkScrollPane.setBounds(700,10,550,380);
		mainPanel.add(homeWorkScrollPane);		
		
		loadUserHomeWorkDataBtn = new JButton(">>");
		loadUserHomeWorkDataBtn.addActionListener(buttonActionListener);
		loadUserHomeWorkDataBtn.setBounds(580, 190, 50, 50);
		mainPanel.add(loadUserHomeWorkDataBtn);
		
		}
	
	class SetCharInfoFrame extends JFrame{
		
		public ActionListener userConfigButtonActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==saveUserDataBtn) {
					try {
					String server = setServerTextField.getText();
					String name = setNameTextField.getText();
					int level = Integer.parseInt(setLevelTextField.getText());
					String charClass = setCharClassTextField.getText();
					String charJob = setCharJobTextField.getText();
					JSONObject userObj = SetUtil.userSet(server, name, level, charClass, charJob);
					JSONObject defaultHwObj = SetUtil.createHomeWorkSet(name);
					FileModuleUtil.createUserData(userObj,defaultHwObj);
					dispose();
						System.out.println("캐릭터정보 저장 완료!");
					} catch (Exception e1) {
						System.out.println("캐릭터정보 저장 실패 ㅠ.ㅠ  다시한번 확인해주세요");
					}
				}
			}
		};

		public SetCharInfoFrame() throws Exception {
			
			/*charSet Pane*/
			charSetPanel = new JPanel();
			charSetPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			setContentPane(charSetPanel);
			charSetPanel.setLayout(null);
			
			setServerTextField = new JTextField();
			setServerTextField.setText("");
			setServerTextField.setColumns(12);
			setServerTextField.setLocation(95,60);
			setServerTextField.setSize(200,30);
			charSetPanel.add(setServerTextField);
			
			setNameTextField = new JTextField();
			setNameTextField.setText("");
			setNameTextField.setColumns(12);
			setNameTextField.setLocation(95,120);
			setNameTextField.setSize(200,30);
			charSetPanel.add(setNameTextField);
			
			setLevelTextField = new JTextField();
			setLevelTextField.setText("");
			setLevelTextField.setColumns(12);
			setLevelTextField.setLocation(95,180);
			setLevelTextField.setSize(200,30);
			charSetPanel.add(setLevelTextField);
			
			setCharClassTextField = new JTextField();
			setCharClassTextField.setText("");
			setCharClassTextField.setColumns(12);
			setCharClassTextField.setLocation(95,240);
			setCharClassTextField.setSize(200,30);
			charSetPanel.add(setCharClassTextField);
			
			setCharJobTextField = new JTextField();
			setCharJobTextField.setText("");
			setCharJobTextField.setColumns(12);
			setCharJobTextField.setLocation(95,300);
			setCharJobTextField.setSize(200,30);
			charSetPanel.add(setCharJobTextField);
			
			setServerLabel = new JLabel("서버 : ");
			setServerLabel.setLocation(95,30);
			setServerLabel.setSize(200,30);
			charSetPanel.add(setServerLabel);
			
			setNameLabel = new JLabel("닉네임 : ");
			setNameLabel.setLocation(95,90);
			setNameLabel.setSize(200,30);
			charSetPanel.add(setNameLabel);
			
			setLevelLabel = new JLabel("아이템레벨 : ");
			setLevelLabel.setLocation(95,150);
			setLevelLabel.setSize(200,30);
			charSetPanel.add(setLevelLabel);
			
			setCharClassLabel = new JLabel("직업군 : ");
			setCharClassLabel.setLocation(95,210);
			setCharClassLabel.setSize(200,30);
			charSetPanel.add(setCharClassLabel);
			
			setCharJobLabel = new JLabel("클래스명 : ");
			setCharJobLabel.setLocation(95,270);
			setCharJobLabel.setSize(200,30);
			charSetPanel.add(setCharJobLabel);

			saveUserDataBtn = new JButton("저장");
			saveUserDataBtn.addActionListener(userConfigButtonActionListener);
			saveUserDataBtn.setBounds(10,10,100,20);
			charSetPanel.add(saveUserDataBtn);
			
			setTitle("Set User Info");
			setSize(400,400);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			setAlwaysOnTop(true);
			setResizable(false);
			setVisible(true);
			setLayout(null);
			
		}
		

	}
	
	
}
