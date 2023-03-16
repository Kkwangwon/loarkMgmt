package loarkMgmt.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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

import loarkMgmt.dto.UserDto;
import loarkMgmt.ui.LAM.SetCharInfoFrame;
import loarkMgmt.util.FileModuleUtil;
import loarkMgmt.util.FormUtil;
import loarkMgmt.util.SetUtil;
import loarkMgmt.util.TextAreaOutputStream;

public class LAM extends JFrame{
	
	//main panel
	private JPanel mainPanel;
	
	//charset panel
	private JPanel charSetPanel;
	
	//button
	private JButton valtanButton;
	private JButton biackissButton;
	private JButton kouku_satonButton;
	private JButton abrelshudButton;
	private JButton illiakanButton;
	private JButton abyssOfKayangelButton;
	private JButton abyssOfVoldaikButton;
	private JButton challenge_guardian_conquestButton;
	private JButton challenge_abyss_dungeonButton;
	
	private JButton loadUserDataBtn;
	private JButton saveUserDataBtn;
	private JButton createUserPaneBtn;
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
	private JLabel setServerLabel;
	private JLabel setNameLabel;
	private JLabel setLevelLabel;
	private JLabel setCharClassLabel;
	private JLabel setCharJobLabel; 
	private JLabel lostArkMark;
	
	//scrollPane
	private JScrollPane charListScrollPane;
	private JScrollPane charInfoScrollPane;
	private JScrollPane logScrollPane;
	private JScrollPane charImageScrollPane;
	
	
	//TextArea
	private JTextArea logTextArea;
	private JTextArea charInfoTextArea;
	

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
					charListScrollPane.requestFocus(true);
					System.out.println("삭제가 정상적으로 이루어졌습니다.");
					setHomeWorkButtonfalse();
				}else{
					System.out.println("삭제하고 싶은 캐릭터를 선택해 주세요");
				}
				 
			}
			if(e.getSource()==valtanButton) {
				try {
				String value = valtanButton.getText();
				if(value.equals("false")) {
					valtanButton.setText("true");
				}else {
					valtanButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
			if(e.getSource()==biackissButton) {
				try {
				String value = biackissButton.getText();
				if(value.equals("false")) {
					biackissButton.setText("true");
				}else {
					biackissButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
			if(e.getSource()==kouku_satonButton) {
				try {
				String value = kouku_satonButton.getText();
				if(value.equals("false")) {
					kouku_satonButton.setText("true");
				}else {
					kouku_satonButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
			if(e.getSource()==abrelshudButton) {
				try {
				String value = abrelshudButton.getText();
				if(value.equals("false")) {
					abrelshudButton.setText("true");
				}else {
					abrelshudButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
			if(e.getSource()==illiakanButton) {
				try {
				String value = illiakanButton.getText();
				if(value.equals("false")) {
					illiakanButton.setText("true");
				}else {
					illiakanButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
			if(e.getSource()==abyssOfKayangelButton) {
				try {
				String value = abyssOfKayangelButton.getText();
				if(value.equals("false")) {
					abyssOfKayangelButton.setText("true");
				}else {
					abyssOfKayangelButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
			if(e.getSource()==abyssOfVoldaikButton) {
				try {
				String value = abyssOfVoldaikButton.getText();
				if(value.equals("false")) {
					abyssOfVoldaikButton.setText("true");
				}else {
					abyssOfVoldaikButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
			if(e.getSource()==challenge_guardian_conquestButton) {
				try {
				String value = challenge_guardian_conquestButton.getText();
				if(value.equals("false")) {
					challenge_guardian_conquestButton.setText("true");
				}else {
					challenge_guardian_conquestButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
			if(e.getSource()==challenge_abyss_dungeonButton) {
				try {
				String value = challenge_abyss_dungeonButton.getText();
				if(value.equals("false")) {
					challenge_abyss_dungeonButton.setText("true");
				}else {
					challenge_abyss_dungeonButton.setText("false");
				}
				saveHomeWorkData();
				}catch(Exception e1) {
					System.out.println("어케 누름?! 빨리 만든사람한테 말해주셈");
				}
			}
		}

	};
	
	private void saveHomeWorkData() {
		
		String value = charList.getSelectedValue();
		String[] nameInfo = value.split("<");
		String charName = nameInfo[0];
		String valtan = valtanButton.getText();
		String biackiss = biackissButton.getText();
		String kouku_saton = kouku_satonButton.getText();
		String abrelshud = abrelshudButton.getText();
		String illiakan = illiakanButton.getText();
		String abyssOfKayangel = abyssOfKayangelButton.getText();
		String abyssOfVoldaik = abyssOfVoldaikButton.getText();
		String challenge_guardian_conquest = challenge_guardian_conquestButton.getText();
		String challenge_abyss_dungeon = challenge_abyss_dungeonButton.getText();
		
		JSONObject homeWorkObj = SetUtil.homeWorkSet(charName, valtan, biackiss, kouku_saton, abrelshud, illiakan, abyssOfKayangel, abyssOfVoldaik, challenge_guardian_conquest, challenge_abyss_dungeon);
		try {
			FileModuleUtil.saveHomeWorkData(charName, homeWorkObj);
		} catch (Exception e) {
			System.out.println("숙제 정보가 저장이 안됬어요 ㅠㅠ 관리자에게 물어봐야해요");
		}
	}
	
	private void tranceformIcon(JButton button) {
		
		ImageIcon trueIcon = new ImageIcon("");
		ImageIcon falseIcon = new ImageIcon("");
		String value = button.getText();
		if(value == "true") {
			button.setIcon(trueIcon);
		}else {
			button.setIcon(falseIcon);
		}
	}
	
	private void loadCharList(List<JSONObject> objList) {
		String charInfo = null;
		String charName = null;
		String charServer = null;
		charListModel = new DefaultListModel<String>();
		for(JSONObject o : objList) {
			charName =  o.get("name").toString();
			charServer =  o.get("server").toString();
			charInfo = charName+"<"+charServer+">";
			charListModel.addElement(charInfo);
		}
		charList = new JList<String>(charListModel);
		charList.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					selectCharList();
				}
			}
		
		});

		charList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		charList.setFocusable(true);
		charListScrollPane.setViewportView(charList);
		charListScrollPane.setVisible(true);

		System.out.println("로딩 완료!");
		setHomeWorkButtonfalse();
		
	}
	
	private void selectCharList() {
		
			String value = charList.getSelectedValue();
			String[] nameInfo = value.split("<");
			String charName = nameInfo[0];
			JSONObject hObj = FileModuleUtil.loadHomeWorkData(charName);
			JSONObject obj = FileModuleUtil.loadCharData(charName);
			String insert = FormUtil.jsonToTextareaForm(obj, UserDto.userKey);
			charImageScrollPane.setVisible(true);
			charInfoScrollPane.setVisible(true);
			charInfoTextArea.setText(insert);
			
			String valtan = hObj.get("valtan").toString();
			String biackiss =  hObj.get("biackiss").toString();
			String kouku_saton =  hObj.get("kouku_saton").toString();
			String abrelshud =  hObj.get("abrelshud").toString();
			String illiakan =  hObj.get("illiakan").toString();
			String abyssOfKayangel =  hObj.get("abyssOfKayangel").toString();
			String abyssOfVoldaik =  hObj.get("abyssOfVoldaik").toString();
			String challenge_guardian_conquest =  hObj.get("challenge_guardian_conquest").toString();
			String challenge_abyss_dungeon =  hObj.get("challenge_abyss_dungeon").toString();
			
			valtanButton.setText(valtan);
			biackissButton.setText(biackiss);
			kouku_satonButton.setText(kouku_saton);
			abrelshudButton.setText(abrelshud);
			illiakanButton.setText(illiakan);
			abyssOfKayangelButton.setText(abyssOfKayangel);
			abyssOfVoldaikButton.setText(abyssOfVoldaik);
			challenge_guardian_conquestButton.setText(challenge_guardian_conquest);
			challenge_abyss_dungeonButton.setText(challenge_abyss_dungeon);
			
			setHomeWorkButtonTrue();

	}
	
	private void setHomeWorkButtonTrue() {
		valtanButton.setEnabled(true);
		biackissButton.setEnabled(true);
		kouku_satonButton.setEnabled(true);
		abrelshudButton.setEnabled(true);
		illiakanButton.setEnabled(true);
		abyssOfKayangelButton.setEnabled(true);
		abyssOfVoldaikButton.setEnabled(true);
		challenge_guardian_conquestButton.setEnabled(true);
		challenge_abyss_dungeonButton.setEnabled(true);
	}
	
	private void setHomeWorkButtonfalse() {
		valtanButton.setEnabled(false);
		biackissButton.setEnabled(false);
		kouku_satonButton.setEnabled(false);
		abrelshudButton.setEnabled(false);
		illiakanButton.setEnabled(false);
		abyssOfKayangelButton.setEnabled(false);
		abyssOfVoldaikButton.setEnabled(false);
		challenge_guardian_conquestButton.setEnabled(false);
		challenge_abyss_dungeonButton.setEnabled(false);
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
		logScrollPane.setBounds(12,509,1240,80);
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
		createUserPaneBtn.setBounds(10,450,150,30);
		mainPanel.add(createUserPaneBtn);
		
		loadUserDataBtn = new JButton("유저 정보 로드");
		loadUserDataBtn.addActionListener(buttonActionListener);
		loadUserDataBtn.setBounds(185,450,150,30);
		mainPanel.add(loadUserDataBtn);
		
		deleteUserDataBtn = new JButton("유저 정보 삭제");
		deleteUserDataBtn.addActionListener(buttonActionListener);
		deleteUserDataBtn.setBounds(361,450,150,30);
		mainPanel.add(deleteUserDataBtn);
		
		charListScrollPane = new JScrollPane();
		charListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		charListScrollPane.setBounds(10,10,500,190);
		charListScrollPane.setVisible(false);
		mainPanel.add(charListScrollPane);

		charImageScrollPane = new JScrollPane();
		charImageScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		charImageScrollPane.setBounds(10,203,240,190);
		charImageScrollPane.setVisible(false);
		mainPanel.add(charImageScrollPane);
		
		charInfoScrollPane = new JScrollPane();
		charInfoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		charInfoScrollPane.setBounds(270,203,240,190);
		mainPanel.add(charInfoScrollPane);
		charInfoTextArea = new JTextArea();
		charInfoScrollPane.setViewportView(charInfoTextArea);
		charInfoScrollPane.setVisible(false);
		charInfoTextArea.setEditable(false);
		charInfoTextArea.setLineWrap(true);
		charInfoTextArea.setWrapStyleWord(true);
		
		valtanButton = new JButton("false");
		valtanButton.setBounds(700,10,150,150);
		valtanButton.setEnabled(false);
		valtanButton.setFont(new Font("Serif",Font.BOLD,0));
		valtanButton.addActionListener(buttonActionListener);
		mainPanel.add(valtanButton);
		
		biackissButton = new JButton("false");
		biackissButton.setBounds(900,10,150,150);
		biackissButton.setEnabled(false);
		biackissButton.setFont(new Font("Serif",Font.BOLD,0));
		biackissButton.addActionListener(buttonActionListener);
		mainPanel.add(biackissButton);
		
		kouku_satonButton = new JButton("false");
		kouku_satonButton.setBounds(1100,10,150,150);
		kouku_satonButton.setEnabled(false);
		kouku_satonButton.setFont(new Font("Serif",Font.BOLD,0));
		kouku_satonButton.addActionListener(buttonActionListener);
		mainPanel.add(kouku_satonButton);
		
		abrelshudButton = new JButton("false");
		abrelshudButton.setBounds(700,170,150,150);
		abrelshudButton.setEnabled(false);
		abrelshudButton.setFont(new Font("Serif",Font.BOLD,0));
		abrelshudButton.addActionListener(buttonActionListener);
		mainPanel.add(abrelshudButton);
		
		illiakanButton = new JButton("false");
		illiakanButton.setBounds(900,170,150,150);
		illiakanButton.setEnabled(false);
		illiakanButton.setFont(new Font("Serif",Font.BOLD,0));
		illiakanButton.addActionListener(buttonActionListener);
		mainPanel.add(illiakanButton);
		
		abyssOfKayangelButton = new JButton("false");
		abyssOfKayangelButton.setBounds(1100,170,150,150);
		abyssOfKayangelButton.setEnabled(false);
		abyssOfKayangelButton.setFont(new Font("Serif",Font.BOLD,0));
		abyssOfKayangelButton.addActionListener(buttonActionListener);
		mainPanel.add(abyssOfKayangelButton);
		
		abyssOfVoldaikButton = new JButton("false");
		abyssOfVoldaikButton.setBounds(700,330,150,150);
		abyssOfVoldaikButton.setEnabled(false);
		abyssOfVoldaikButton.setFont(new Font("Serif",Font.BOLD,0));
		abyssOfVoldaikButton.addActionListener(buttonActionListener);
		mainPanel.add(abyssOfVoldaikButton);
		
		challenge_guardian_conquestButton = new JButton("false");
		challenge_guardian_conquestButton.setBounds(900,330,150,150);
		challenge_guardian_conquestButton.setEnabled(false);
		challenge_guardian_conquestButton.setFont(new Font("Serif",Font.BOLD,0));
		challenge_guardian_conquestButton.addActionListener(buttonActionListener);
		mainPanel.add(challenge_guardian_conquestButton);
		
		challenge_abyss_dungeonButton = new JButton("false");
		challenge_abyss_dungeonButton.setBounds(1100,330,150,150);
		challenge_abyss_dungeonButton.setEnabled(false);
		challenge_abyss_dungeonButton.setFont(new Font("Serif",Font.BOLD,0));
		challenge_abyss_dungeonButton.addActionListener(buttonActionListener);
		mainPanel.add(challenge_abyss_dungeonButton);
		
		lostArkMark = new JLabel("LostArk마크가 들어갈 예정");
		lostArkMark.setBounds(530, 190, 150, 50);
		lostArkMark.setOpaque(true);
		lostArkMark.setBackground(Color.CYAN);
		mainPanel.add(lostArkMark);
		
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
					JSONObject userObj;
					userObj = SetUtil.userSet(server, name, level, charClass, charJob);
					JSONObject defaultHwObj = SetUtil.createHomeWorkSet(name);
					FileModuleUtil.createUserData(userObj,defaultHwObj);
					dispose();
					List<JSONObject> objList = FileModuleUtil.loadUserData();
					if(!objList.isEmpty()) {
					loadCharList(objList);
					}
						System.out.println("캐릭터정보 저장 완료!");
						setHomeWorkButtonfalse();
					} catch (Exception e1) {
						System.out.println("캐릭터정보 저장 실패 ㅠ.ㅠ  값을 다시 한번 확인해주세요");
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
