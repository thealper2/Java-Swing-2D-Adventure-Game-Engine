import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.sound.sampled.*;

import javax.swing.*;

public class Game {

	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, inventoryPanel, infoPanel, mapPanel, backgroundPanel, backgroundPanel2, marketMapPanel, healthPanel, itemPanel, mainBackgroundPanel, playerSelectionPanel, player1imagePanel, player2imagePanel, player3imagePanel, playerSelectPanel, levelSelectionPanel, levelSelectPanel, level1Panel, level2Panel, level3Panel, level4Panel, level5Panel, marketPanel, losePanel, loseiconPanel, optionsPanel, resumePanel, aboutPanel, buyPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, coinLabel, coinLabelNumber, infoLabel, mapLabel, backgroundLabel, backgroundLabel2,mainBackgroundLabel, player1imageLabel, player2imageLabel, player3imageLabel, playerSelectLabel, selectErrorLabel, level1Label, level2Label, level3Label, level4Label, level5Label, levelSelectLabel, levelErrorLabel, loseLabel, losetext1Label, losetext2Label, loseiconLabel, buyLabel, buyItemLabel, itemInfoLabel;
	JLabel hpCount, expCount;
	JProgressBar healthBar, expBar;
	JLayeredPane con2;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	Font pixelFont, pixelButtonFont, pixelTextFont, pixelSmallFont;
	String level1action = "level1action", level2action = "level2action", level3action = "level3action", episode;
	String clickSound, errorSound, walkSound, mainSound, winSound, loseSound, storySound, fightSound;
	String playerAttack, ep1b1s , ep1b1as, ep1b1ds,  ep1b2s , ep1b2as, ep1b2ds,  ep1b3s , ep1b3as, ep1b3ds, ep1b4s , ep1b4as, ep1b4ds, ep2b1s , ep2b1as, ep2b2s , ep2b2as, ep2b2ds, ep2b3s , ep2b3as, ep2b3ds, ep2b4s , ep2b4as, ep2b4ds, ep2b5s , ep2b5as, ep2b5ds, ep3b1s , ep3b1as, ep3b1ds, ep3b2s , ep3b2as, ep3b2ds, ep3b3s , ep3b3as, ep3b3ds, ep3b4s , ep3b4as, ep3b4ds, ep3b5s , ep3b5as, ep3b5ds, ep3b6s , ep3b6as, ep3b6ds;
	int itemCost, playerDamage, savedXP = 0;
	GraphicsDevice gDevice;
	GraphicsEnvironment ge;
	boolean start = true, ep1s1bool, ep1s2bool;
	boolean EP1boss1key = false, EP1boss2key = false, EP1boss3key = false, EP1boss4key = false;
	boolean EP2boss1key = false, EP2boss2key = false, EP2boss3key = false, EP2boss4key = false, EP2boss5key = false;
	boolean EP3boss1key = false, EP3boss2key = false, EP3boss3key = false, EP3boss4key = false, EP3boss5key = false, EP3boss6key = false, EP3boss7key = false, EP3boss8key = false;
	
	JLabel imte;
	ImageIcon player, level1image, level2image, level3image, level4image, level5image, gameOver;
	JButton startButton, choice1, choice2, choice3, choice4,inventoryButton, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5, market, map, inventory, setPlayer, level1, level2, level3, level4, level5, optionsButton, resumeButton, aboutButton, xOptionsClose, xAboutClose, buyButton;
	JToggleButton player1, player2, player3;
	JTextArea mainTextArea;
	int playerHP, monsterHP, playerCoin, award, silverRing, i=0, j=0, playerArmor;
	String weapon, position, inventoryStatus, clickedButton, monsterName;
	String text, itemName;
	JLabel icon1,icon2, icon3, icon5, icon4, icon6, icon7, icon8, icon9, icon10, icon11, icon12, icon13, icon14, icon15, icon16, icon17, icon18, icon19, icon20, icon21;
	ImageIcon img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17, img18, img19, img20, img21;
	JLabel name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20, name21;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21;
	boolean item1bought, item2bought, item3bought, item4bought, item5bought, item6bought, item7bought, item8bought, item9bought, item10bought, item11bought, item12bought, item13bought, item14bought, item15bought, item16bought, item17bought, item18bought;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	InventoryHandler inventoryHandler = new InventoryHandler();
	ShowMarket showMarket = new ShowMarket();
	ShowMap showMap = new ShowMap();
	SetPlayer playerSet = new SetPlayer();
	SetterPlayer playerSetter = new SetterPlayer();
	LevelSelecter levelSelecter = new LevelSelecter();
	ShowOptions showOptions = new ShowOptions();
	LoadGame loadGame = new LoadGame();
	ShowAbout showAbout = new ShowAbout();
	MouseHandler mouseHandler = new MouseHandler();
	SoundEffect se = new SoundEffect();
	ButtonClick buttonClick = new ButtonClick();
	BuyHandler buyHandler = new BuyHandler();
	BuyOption buyOption = new BuyOption();
	Walk walk = new Walk();
	Error error = new Error();
	
	JButton ep1s1, ep1s2, ep1s3, ep1s4, ep1s5, ep1s6, ep1s7, ep1s8, ep1s9, ep1s10, ep1s11, ep1s12, ep1s13, ep1s14, ep1s15, ep1s16, ep1s17, ep1s18, ep1s19, ep1s20, ep1s21, ep1s22, ep1s23, ep1s24, ep1s25, ep1b1, ep1b2, ep1b3, ep1b4;
	JButton ep2s1, ep2s2, ep2s3, ep2s4, ep2s5, ep2s6, ep2s7, ep2s8, ep2s9, ep2s10, ep2s11, ep2s12, ep2s13, ep2s14, ep2s15, ep2s16, ep2s17, ep2s18, ep2b1, ep2b2, ep2b3, ep2b4, ep2b5;
	JButton ep3s1, ep3s2, ep3s3, ep3s4, ep3s5, ep3s6, ep3s7, ep3s8, ep3s9, ep3s10, ep3s11, ep3s12, ep3s13, ep3s14, ep3s15, ep3s16, ep3s17, ep3b1, ep3b2, ep3b3, ep3b4, ep3b5, ep3b6, ep3b7, ep3b8;
	
	ImageIcon ep1s1i, ep1s2i, ep1s3i, ep1s4i, ep1s5i, ep1s6i, ep1s7i, ep1s8i, ep1s9i, ep1s10i, ep1s11i, ep1s12i, ep1s13i, ep1s14i, ep1s15i, ep1s16i, ep1s17i, ep1s18i, ep1s19i, ep1s20i, ep1s21i, ep1s22i, ep1s23i, ep1s24i, ep1s25i, ep1b1i, ep1b2i, ep1b3i, ep1b4i;
	ImageIcon ep2s1i, ep2s2i, ep2s3i, ep2s4i, ep2s5i, ep2s6i, ep2s7i, ep2s8i, ep2s9i, ep2s10i, ep2s11i, ep2s12i, ep2s13i, ep2s14i, ep2s15i, ep2s16i, ep2s17i, ep2s18i, ep2b1i, ep2b2i, ep2b3i, ep2b4i, ep2b5i;
	ImageIcon ep3s1i, ep3s2i, ep3s3i, ep3s4i, ep3s5i, ep3s6i, ep3s7i, ep3s8i, ep3s9i, ep3s10i, ep3s11i, ep3s12i, ep3s13i, ep3s14i, ep3s15i, ep3s16i, ep3s17i, ep3b1i, ep3b2i, ep3b3i, ep3b4i, ep3b5i, ep3b6i, ep3b7i, ep3b8i;
	
	String[] playerItem = new String[5];
	ImageIcon pixel, screen, mainBackground, itemIcon;

	Timer timer2 = new Timer(250, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			char character[] = text.toCharArray();
			int arrayNumber = character.length;
			String s = String.valueOf(character[j]);
			titleNameLabel.setText(titleNameLabel.getText() + s);
			j++;
			if(j == arrayNumber)
			{
				j = 0;
				timer2.stop();
			}
			
		}
		
	});
	
	Timer timer = new Timer(80, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			char character[] = text.toCharArray();
			int arrayNumber = character.length;
			String s = String.valueOf(character[i]);
			mainTextArea.append(s);
			i++;
			if(i == arrayNumber)
			{
				i = 0;
				timer.stop();
			}
			
		}
		
	});
	
	
	public static void main(String[] args) {
		
		/*try { 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); 
	    } catch(Exception ignored){}
		
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }*/
		
		new Game();
	}
	
	public Game(){
		
		try
		{
			pixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Minecraft.ttf")).deriveFont(90f);
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Minecraft1.ttf")));
			
		} catch(IOException | FontFormatException e) {
			
		}
		
		GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gDevice = gEnvironment.getDefaultScreenDevice();
		
		
		window = new JFrame();
		window.setSize(1280, 720);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		con = window.getContentPane();
		con2 = window.getLayeredPane();
		
		mainBackground = new ImageIcon("images/ezgif3.gif");
		
		clickSound = "sounds/click.wav";
		errorSound = "sounds/error.wav";
		walkSound = "sounds/grass.wav";
		
		playerAttack = "sounds/playerattack.wav";
		
		ep1b1s = "sounds/ep1boss1.wav";
		ep1b1as = "sounds/ep1boss1attack.wav";
		ep1b1ds = "sounds/ep1boss1death.wav";
		
		ep1b2s = "sounds/ep1boss1.wav";
		ep1b2as = "sounds/ep1boss1attack.wav";
		ep1b2ds = "sounds/ep1boss1death.wav";
		
		ep1b3s = "sounds/ep1boss3.wav";
		ep1b3as = "sounds/ep1boss3attack.wav";
		ep1b3ds = "sounds/ep1boss3death.wav";
		
		ep1b4s = "sounds/ep1boss4.wav";
		ep1b4as = "sounds/ep1boss4attack.wav";
		ep1b4ds = "sounds/ep1boss4death.wav";
		
		ep2b1s = "sounds/ep2boss1.wav";
		ep2b1as = "sounds/ep2boss1attack.wav";
		
		ep2b2s = "sounds/ep2boss2.wav";
		ep2b2as = "sounds/ep2boss2attack.wav";
		ep2b2ds = "sounds/ep2boss2death.wav";
		
		ep2b3s = "sounds/ep2boss3.wav";
		ep2b3as = "sounds/ep2boss3attack.wav";
		ep2b3ds = "sounds/ep2boss3death.wav";
		
		ep2b4s = "sounds/ep2boss4.wav";
		ep2b4as = "sounds/ep2boss4attack.wav";
		ep2b4ds = "sounds/ep2boss4death.wav";
		
		ep2b5s = "sounds/ep2boss5.wav";
		ep2b5as = "sounds/ep2boss5attack.wav";
		ep2b5ds = "sounds/ep2boss5death.wav";
		
		ep3b1s = "sounds/ep3boss1.wav";
		ep3b1as = "sounds/ep3boss1attack.wav";
		ep3b1ds = "sounds/ep3boss1death.wav";
		
		ep3b2s = "sounds/ep3boss2.wav";
		ep3b2as = "sounds/ep3boss2attack.wav";
		ep3b2ds = "sounds/ep3boss2death.wav";
		
		ep3b3s = "sounds/ep3boss3.wav";
		ep3b3as = "sounds/ep3boss3attack.wav";
		ep3b3ds = "sounds/ep3boss3death.wav";
		
		ep3b4s = "sounds/ep3boss4.wav";
		ep3b4as = "sounds/ep3boss4attack.wav";
		ep3b4ds = "sounds/ep3boss4death.wav";
		
		ep3b5s = "sounds/ep3boss5.wav";
		ep3b5as = "sounds/ep3boss5attack.wav";
		ep3b5ds = "sounds/ep3boss5death.wav";
	
		ep3b6s = "sounds/ep3boss6.wav";
		ep3b6as = "sounds/ep3boss6attack.wav";
		ep3b6ds = "sounds/ep3boss6death.wav";
		
		
		mainBackgroundPanel = new JPanel();
		mainBackgroundPanel.setBounds(0, 0, 1280, 720);
		mainBackgroundPanel.setBackground(Color.black);
		
		mainBackgroundLabel = new JLabel();
		mainBackgroundLabel.setBounds(0, 0, 1280, 720);
		mainBackgroundLabel.setIcon(mainBackground);
		mainBackgroundPanel.add(mainBackgroundLabel);
		con2.add(mainBackgroundPanel, new Integer(0));
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(40, 75, 600, 100);
		titleNamePanel.setBackground(new Color(0, 0, 0));
		text =  "ADVENTURE";
		titleNameLabel = new JLabel();
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(pixelFont);
		timer2.start();
		
		//startButtonPanel = new JPanel();
		//startButtonPanel.setBounds(500, 400, 130, 45);
		//startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBounds(190, 300, 250, 50);
		startButton.setBackground(Color.WHITE);
		startButton.setForeground(Color.BLACK);
		startButton.setFont(normalFont);
		//startButton.addActionListener(buttonClick);
		startButton.addActionListener(tsHandler);
		startButton.addActionListener(buttonClick);
		startButton.setFocusPainted(false);
		//startButton.setBorder(null);
		startButton.setActionCommand("start");
		startButton.setContentAreaFilled(false);
		
		resumeButton = new JButton("RESUME");
		resumeButton.setBounds(190, 360, 250, 50);
		resumeButton.setBackground(Color.WHITE);
		resumeButton.setForeground(Color.BLACK);
		resumeButton.setFont(normalFont);
		resumeButton.addActionListener(loadGame);
		resumeButton.setFocusPainted(false);
		resumeButton.setActionCommand("resume");
		resumeButton.setContentAreaFilled(false);
		resumeButton.addActionListener(buttonClick);
		
		resumePanel = new JPanel();
		resumePanel.setBackground(new Color(0, 0, 0, 65));
		
		optionsButton = new JButton("OPTIONS");
		optionsButton.setBounds(190, 420, 250, 50);
		optionsButton.setBackground(Color.WHITE);
		optionsButton.setForeground(Color.BLACK);
		optionsButton.setFont(normalFont);
		optionsButton.addActionListener(buttonClick);
		optionsButton.addActionListener(showOptions);
		optionsButton.setFocusPainted(false);
		optionsButton.setContentAreaFilled(false);
		
		optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(0, 0, 0, 65));
		optionsPanel.setBounds(600, 265, 600, 400);
		optionsPanel.setLayout(null);
		optionsPanel.setVisible(false);
		
		xOptionsClose = new JButton("X");
		xOptionsClose.setBounds(575, 0, 25, 25);
		xOptionsClose.setBackground(Color.WHITE);
		xOptionsClose.setForeground(Color.BLACK);
		xOptionsClose.setFocusPainted(false);
		xOptionsClose.setContentAreaFilled(false);
		xOptionsClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(aboutPanel.isVisible() == true)
				{
					aboutPanel.setVisible(false);
				}
				optionsPanel.setVisible(false);			
			}
			
		});
		
		JLabel temalar = new JLabel("Tema : ");
		temalar.setFont(normalFont);
		temalar.setBounds(50, 50, 100, 30);
		
		final UIManager.LookAndFeelInfo[] plafInfos = UIManager.getInstalledLookAndFeels();
        String[] plafNames = new String[plafInfos.length];
        for (int i=0; i<plafInfos.length; i++) {
            plafNames[i] = plafInfos[i].getName();
        }
		
		JComboBox tcb = new JComboBox(plafNames);
		//tcb.setFont(normalFont);
		tcb.setBounds(130, 50, 200, 35);
		tcb.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                int index = tcb.getSelectedIndex();
                try {
                    UIManager.setLookAndFeel(plafInfos[index].getClassName());
                    SwingUtilities.updateComponentTreeUI(window);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        } );
		
		JLabel cozunurluk = new JLabel("Cozunurluk : ");
		cozunurluk.setFont(normalFont);
		cozunurluk.setBounds(50, 100, 200, 30);
		
		String[] cozunurlukler = {"3840x2160","1920x1080", "1680x1050", "1600x900", "1440x900", "1366x768", "1280x1024", "1280x960", "1280x800", "1280x768", "1280x720 (onerilen)", "800x600"};
		
		JComboBox ccb = new JComboBox(cozunurlukler);
		ccb.setSelectedIndex(10);
		ccb.setBounds(200, 100, 200, 35);
		
		JLabel sesAcKapa = new JLabel("Muzik : ");
		sesAcKapa.setFont(normalFont);
		sesAcKapa.setBounds(50, 150, 200, 30);
		
		JLabel sesDurum = new JLabel("ON");
		sesDurum.setFont(normalFont);
		sesDurum.setBounds(200, 150, 60, 30);
		
		JButton turnOff = new JButton("<");
		turnOff.setFont(normalFont);
		turnOff.setBounds(150, 150, 32, 32);
		JButton turnOn = new JButton(">");
		turnOn.setFont(normalFont);
		turnOn.setBounds(260, 150, 32, 32);
		turnOn.setEnabled(false);
		
		turnOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				turnOff.setEnabled(false);
				turnOn.setEnabled(true);
				sesDurum.setText("OFF");
			}
			
		});
		
		turnOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				turnOn.setEnabled(false);
				turnOff.setEnabled(true);
				sesDurum.setText("ON");
			}
			
		});
		
		JLabel ekran = new JLabel("Ekran : ");
		ekran.setFont(normalFont);
		ekran.setBounds(50, 200, 200, 30);
	
		JRadioButton normalEkran = new JRadioButton("Normal");
		normalEkran.setFont(normalFont);
		normalEkran.setBounds(150, 200, 200, 30);
		normalEkran.setSelected(true);
		
		JRadioButton tamEkran = new JRadioButton("Tam Ekran");
		tamEkran.setFont(normalFont);
		tamEkran.setBounds(350, 200, 200, 30);
		tamEkran.setSelected(false);
		
		normalEkran.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(normalEkran.isSelected() == true)
				{
					tamEkran.setSelected(false);
					gDevice.setFullScreenWindow(null);
				}
				
			}
			
		});
		
		tamEkran.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tamEkran.isSelected() == true)
				{
					normalEkran.setSelected(false);
					gDevice.setFullScreenWindow(window);
				}
			}
			
		});
		
		optionsPanel.add(xOptionsClose);
		optionsPanel.add(temalar);
		optionsPanel.add(tcb);
		optionsPanel.add(cozunurluk);
		optionsPanel.add(ccb);
		optionsPanel.add(sesAcKapa);
		optionsPanel.add(turnOff);
		optionsPanel.add(sesDurum);
		optionsPanel.add(ekran);
		optionsPanel.add(normalEkran);
		optionsPanel.add(tamEkran);
		optionsPanel.add(turnOn);
		
		
		aboutButton = new JButton("ABOUT");
		aboutButton.setBounds(190, 480, 250, 50);
		aboutButton.setBackground(Color.WHITE);
		aboutButton.setForeground(Color.BLACK);
		aboutButton.setFont(normalFont);
		aboutButton.addActionListener(buttonClick);
		aboutButton.addActionListener(showAbout);
		aboutButton.setFocusPainted(false);
		aboutButton.setContentAreaFilled(false);
		
		aboutPanel = new JPanel();
		aboutPanel.setBackground(new Color(0, 0, 0, 65));
		aboutPanel.setBounds(600, 265, 600, 400);
		aboutPanel.setLayout(null);
		aboutPanel.setVisible(false);
		
		xAboutClose = new JButton("X");
		xAboutClose.setBounds(575, 0, 25, 25);
		xAboutClose.setBackground(Color.WHITE);
		xAboutClose.setForeground(Color.BLACK);
		xAboutClose.setFocusPainted(false);
		xAboutClose.setContentAreaFilled(false);
		xAboutClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(optionsPanel.isVisible() == true)
				{
					optionsPanel.setVisible(false);
				}
				aboutPanel.setVisible(false);			
			}
			
		});
		
		ImageIcon myPicI = new ImageIcon("images/Unknown.png");
		ImageIcon twitterI = new ImageIcon("icons/icons8-twitter.png");
		ImageIcon instagramI = new ImageIcon("icons/icons8-instagram.png");
		ImageIcon steamI = new ImageIcon("icons/icons8-steam.png");
		ImageIcon facebookI = new ImageIcon("icons/icons8-facebook.png");
		JLabel myPic = new JLabel();
		myPic.setIcon(myPicI);
		myPic.setBounds(10, 10, 250, 250);
		
		JTextArea myInfo = new JTextArea("Bu projenin yapımına 11-12-2021 tarihinde başlanmıştır. 29-12-2021 tarihinde bitmiştir. Proje yapımında Photopea, Ezgif programları kullanılmıştır. Ses ve gif dosyaları itch io sitesinden alınmıştır.");
		myInfo.setLineWrap(true);
		myInfo.setWrapStyleWord(true);
		myInfo.setEditable(false);
		myInfo.setBounds(270, 10, 300, 250);
		
		JButton twitter = new JButton();
		twitter.setIcon(twitterI);
		twitter.setBounds(10, 300, 100, 50);
		twitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(new URL("https://twitter.com").toURI());
				} catch (IOException | URISyntaxException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		
		JButton instagram = new JButton();
		instagram.setIcon(instagramI);
		instagram.setBounds(170, 300, 100, 50);
		instagram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(new URL("https://www.instagram.com").toURI());
				} catch (IOException | URISyntaxException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		
		JButton steam = new JButton();
		steam.setIcon(steamI);
		steam.setBounds(330, 300, 100, 50);
		steam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(new URL("https://store.steampowered.com").toURI());
				} catch (IOException | URISyntaxException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		
		JButton facebook = new JButton();
		facebook.setIcon(facebookI);
		facebook.setBounds(490, 300, 100, 50);
		facebook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(new URL("https://www.facebook.com").toURI());
				} catch (IOException | URISyntaxException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		
		aboutPanel.add(xAboutClose);
		aboutPanel.add(myPic);
		aboutPanel.add(myInfo);
		aboutPanel.add(twitter);
		aboutPanel.add(instagram);
		aboutPanel.add(steam);
		aboutPanel.add(facebook);
		
		titleNamePanel.add(titleNameLabel);
		
		con2.add(titleNamePanel, new Integer(1));
		con2.add(startButton, new Integer(2));
		con2.add(resumeButton, new Integer(3));
		con2.add(optionsButton, new Integer(4));
		con2.add(aboutButton, new Integer(5));
		con2.add(optionsPanel, new Integer(6));
		con2.add(aboutPanel, new Integer(7));
		
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
		//window.getRootPane().setDefaultButton(startButton);
	}

	public void prepareText() {
		i = 0;
		mainTextArea.setText("");
		timer.start();
	}
	
	public void PlayerSelection() {
		titleNamePanel.setVisible(false);
		startButton.setVisible(false);
		resumeButton.setVisible(false);
		optionsButton.setVisible(false);
		aboutButton.setVisible(false);
		mainBackgroundPanel.setVisible(false);
		aboutPanel.setVisible(false);
		optionsPanel.setVisible(false);
		
		playerSelectPanel = new JPanel();
		playerSelectPanel.setBounds(200, 50, 800, 100);
		playerSelectPanel.setBackground(Color.WHITE);
		playerSelectPanel.setForeground(Color.BLACK);
	
		playerSelectLabel = new JLabel("SELECT PLAYER");
		playerSelectLabel.setBounds(200, 50, 800, 100);
		playerSelectLabel.setBackground(Color.WHITE);
		playerSelectLabel.setForeground(Color.BLACK);
		playerSelectLabel.setFont(pixelFont);
		playerSelectPanel.add(playerSelectLabel);
		
		playerSelectionPanel = new JPanel();
		playerSelectionPanel.setLayout(null);
		playerSelectionPanel.setBounds(0, 0, 1280, 720);
		playerSelectionPanel.setBackground(Color.BLACK);
		playerSelectionPanel.setForeground(Color.WHITE);
		
		player = new ImageIcon("images/player.png");
		
		player1 = new JToggleButton("Oyuncu 1");
		player1.setBounds(200, 500, 200, 50);
		player1.setBackground(Color.WHITE);
		player1.setForeground(Color.BLACK);
		player1.setFocusPainted(false);
		player1.addItemListener(playerSet);
		
		player1imagePanel = new JPanel();
		player1imagePanel.setBounds(200, 275, 200, 200);
		player1imagePanel.setBackground(Color.WHITE);
		
		player1imageLabel = new JLabel();
		player1imageLabel.setIcon(player);
		player1imagePanel.add(player1imageLabel);
		
		player2 = new JToggleButton("Oyuncu 2");
		player2.setBounds(500, 500, 200, 50);
		player2.setBackground(Color.WHITE);
		player2.setForeground(Color.BLACK);
		player2.setFocusPainted(false);
		player2.addItemListener(playerSet);
		
		player2imagePanel = new JPanel();
		player2imagePanel.setBounds(500, 275, 200, 200);
		player2imagePanel.setBackground(Color.WHITE);
		
		player2imageLabel = new JLabel();
		player2imageLabel.setIcon(player);
		player2imagePanel.add(player2imageLabel);
		
		player3 = new JToggleButton("Oyuncu 3");
		player3.setBounds(800, 500, 200, 50);
		player3.setBackground(Color.WHITE);
		player3.setForeground(Color.BLACK);
		player3.setFocusPainted(false);
		player3.addItemListener(playerSet);
		
		player3imagePanel = new JPanel();
		player3imagePanel.setBounds(800, 275, 200, 200);
		player3imagePanel.setBackground(Color.WHITE);
		
		player3imageLabel = new JLabel();
		player3imageLabel.setIcon(player);
		player3imagePanel.add(player3imageLabel);
		
		setPlayer = new JButton("Basla");
		setPlayer.setBounds(500, 600, 200, 50);
		setPlayer.setBackground(Color.WHITE);
		setPlayer.setForeground(Color.BLACK);
		setPlayer.setFocusPainted(false);
		setPlayer.addActionListener(buttonClick);
		setPlayer.addActionListener(playerSetter);
		
		selectErrorLabel = new JLabel("");
		selectErrorLabel.setBounds(500, 200, 400, 50);
		selectErrorLabel.setBackground(Color.BLACK);
		selectErrorLabel.setForeground(Color.WHITE);
		
		playerSelectionPanel.add(playerSelectPanel);
		playerSelectionPanel.add(selectErrorLabel);
		playerSelectionPanel.add(player1);
		playerSelectionPanel.add(player2);
		playerSelectionPanel.add(player3);
		playerSelectionPanel.add(setPlayer);
		playerSelectionPanel.add(player1imagePanel);
		playerSelectionPanel.add(player2imagePanel);
		playerSelectionPanel.add(player3imagePanel);
		
		con.add(playerSelectionPanel);
	}
	
	public void LevelSelection() {
		playerSelectionPanel.setVisible(false);
		
		levelSelectionPanel = new JPanel();
		levelSelectionPanel.setLayout(null);
		levelSelectionPanel.setBounds(0, 0, 1280, 720);
		levelSelectionPanel.setBackground(Color.BLACK);
		levelSelectionPanel.setForeground(Color.WHITE);
		
		levelSelectPanel = new JPanel();
		levelSelectPanel.setBounds(65, 100, 1150, 100);
		levelSelectPanel.setBackground(Color.WHITE);
		levelSelectPanel.setForeground(Color.BLACK);
		
		levelSelectLabel = new JLabel("SELECT LEVEL");
		levelSelectLabel.setBounds(65, 100, 800, 100);
		levelSelectLabel.setBackground(Color.WHITE);
		levelSelectLabel.setForeground(Color.BLACK);
		levelSelectLabel.setFont(pixelFont);
		levelSelectPanel.add(levelSelectLabel);
		
		level1Panel = new JPanel();
		level1Panel.setBounds(90, 350, 100, 110);
		level1Panel.setBackground(Color.WHITE);
		level1Panel.setForeground(Color.BLACK);
		
		level1image = new ImageIcon("images/level1.gif");
		
		level1Label = new JLabel();
		level1Label.setBounds(90, 350, 100, 110);
		level1Label.setBackground(Color.WHITE);
		level1Label.setForeground(Color.BLACK);
		level1Label.setIcon(level1image);
		
		level1 = new JButton("Level 1");
		level1.setBounds(65, 500, 150, 50);
		level1.setBackground(Color.WHITE);
		level1.setForeground(Color.BLACK);
		level1.setFocusPainted(false);
		level1.setActionCommand(level1action);
		level1.addActionListener(buttonClick);
		level1.addActionListener(levelSelecter);
		
		level2Panel = new JPanel();
		level2Panel.setBounds(340, 350, 100, 110);
		level2Panel.setBackground(Color.WHITE);
		level2Panel.setForeground(Color.BLACK);
		
		level2image = new ImageIcon("images/level2.gif");
		
		level2Label = new JLabel();
		level2Label.setBounds(340, 350, 100, 110);
		level2Label.setBackground(Color.WHITE);
		level2Label.setForeground(Color.BLACK);
		level2Label.setIcon(level2image);
		
		level2 = new JButton("Level 2");
		level2.setBounds(315, 500, 150, 50);
		level2.setBackground(Color.WHITE);
		level2.setForeground(Color.BLACK);
		level2.setFocusPainted(false);
		level2.setActionCommand(level2action);
		level2.addActionListener(buttonClick);
		level2.addActionListener(levelSelecter);
		
		level3Panel = new JPanel();
		level3Panel.setBounds(590, 350, 100, 110);
		level3Panel.setBackground(Color.WHITE);
		level3Panel.setForeground(Color.BLACK);
		
		level3image = new ImageIcon("images/level3.gif");
		
		level3Label = new JLabel();
		level3Label.setBounds(590, 350, 100, 110);
		level3Label.setBackground(Color.WHITE);
		level3Label.setForeground(Color.BLACK);
		level3Label.setIcon(level3image);
		
		level3 = new JButton("Level 3");
		level3.setBounds(565, 500, 150, 50);
		level3.setBackground(Color.WHITE);
		level3.setForeground(Color.BLACK);
		level3.setFocusPainted(false);
		level3.setActionCommand(level3action);
		level3.addActionListener(buttonClick);
		level3.addActionListener(levelSelecter);
		
		level4Panel = new JPanel();
		level4Panel.setBounds(840, 350, 100, 110);
		level4Panel.setBackground(Color.WHITE);
		level4Panel.setForeground(Color.BLACK);
		
		level4image = new ImageIcon("images/level4.gif");
		
		level4Label = new JLabel();
		level4Label.setBounds(840, 350, 100, 110);
		level4Label.setBackground(Color.WHITE);
		level4Label.setForeground(Color.BLACK);
		level4Label.setIcon(level4image);
		
		level4 = new JButton("Level 4");
		level4.setBounds(815, 500, 150, 50);
		level4.setBackground(Color.WHITE);
		level4.setForeground(Color.BLACK);
		level4.addActionListener(buttonClick);
		level4.setFocusPainted(false);
		
		level5Panel = new JPanel();
		level5Panel.setBounds(1090, 350, 100, 110);
		level5Panel.setBackground(Color.WHITE);
		level5Panel.setForeground(Color.BLACK);
		
		level5image = new ImageIcon("images/level5.gif");
		
		level5Label = new JLabel();
		level5Label.setBounds(1090, 350, 100, 110);
		level5Label.setBackground(Color.WHITE);
		level5Label.setForeground(Color.BLACK);
		level5Label.setIcon(level5image);
		
		level5 = new JButton("Level 5");
		level5.setBounds(1065, 500, 150, 50);
		level5.setBackground(Color.WHITE);
		level5.setForeground(Color.BLACK);
		level5.addActionListener(buttonClick);
		level5.setFocusPainted(false);
	
		level1Panel.add(level1Label);
		level2Panel.add(level2Label);
		level3Panel.add(level3Label);
		level4Panel.add(level4Label);
		level5Panel.add(level5Label);
		
		levelErrorLabel = new JLabel("", SwingConstants.CENTER);
		levelErrorLabel.setBounds(65, 600, 800, 50);
		levelErrorLabel.setBackground(Color.BLACK);
		levelErrorLabel.setForeground(Color.WHITE);
		
		levelSelectionPanel.add(levelSelectPanel);
		levelSelectionPanel.add(level1Panel);
		levelSelectionPanel.add(level1);
		levelSelectionPanel.add(level2Panel);
		levelSelectionPanel.add(level2);
		levelSelectionPanel.add(level3Panel);
		levelSelectionPanel.add(level3);
		levelSelectionPanel.add(level4Panel);
		levelSelectionPanel.add(level4);
		levelSelectionPanel.add(level5Panel);
		levelSelectionPanel.add(level5);
		levelSelectionPanel.add(levelErrorLabel);
		
		con.add(levelSelectionPanel);
		
	}
	
	public void createGameScreen(){
		titleNamePanel.setVisible(false);
		startButton.setVisible(false);
		resumeButton.setVisible(false);
		optionsButton.setVisible(false);
		aboutButton.setVisible(false);
		mainBackgroundPanel.setVisible(false);
		levelSelectionPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(640, 0, 640, 260);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);	
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(640, 0, 640, 260);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true); 
		mainTextArea.setEditable(false); 	
		window.addMouseListener(mouseHandler);
		
		mainTextPanel.add(mainTextArea);
			
		infoPanel = new JPanel();
		infoPanel.setBounds(0, 560, 150, 160);
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setForeground(Color.BLACK);
		infoPanel.setFont(normalFont);
		
		infoLabel = new JLabel();
		infoLabel.setBounds(0, 560, 200, 160);
		
		pixel = new ImageIcon("images/level1.gif");
		infoLabel.setIcon(pixel);
		infoPanel.add(infoLabel);
		
		backgroundPanel = new JPanel();
		backgroundPanel.setBounds(0, 0, 640, 560);
		backgroundPanel.setBackground(Color.BLACK);
		backgroundPanel.setForeground(Color.BLACK);
		backgroundPanel.setFont(normalFont);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setBounds(0, 0, 640, 560);
		
		backgroundPanel.add(backgroundLabel);
		
		con.add(backgroundPanel);
		con.add(infoPanel);
		
		market = new JButton("Market");
		market.setBackground(Color.WHITE);
		market.setForeground(Color.BLACK);
		market.setFocusPainted(false);
		market.addActionListener(buttonClick);
		market.addActionListener(showMarket);
		
		map = new JButton("Map");
		map.setBackground(Color.WHITE);
		map.setForeground(Color.BLACK);
		map.setFocusPainted(false);
		map.addActionListener(buttonClick);
		map.addActionListener(showMap);
		
		marketPanel = new JPanel();
		marketPanel.setBackground(Color.BLACK);
		marketPanel.setForeground(Color.WHITE);
		marketPanel.setBounds(0, 0, 1000, 560);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
	    panel.setPreferredSize(new Dimension(120, 1800));
	    panel.setLayout(null); 
	    
	    JLabel silahlar = new JLabel("SILAHLAR" , SwingConstants.CENTER);
	    silahlar.setFont(titleFont);
	    silahlar.setBounds(0, 0, 1000, 70);
	    panel.add(silahlar);
	    
	    icon1 = new JLabel("", SwingConstants.CENTER);
	    img1 = new ImageIcon("icons/wood-club.png");
	    icon1.setBounds(0, 80, 190, 80);
	    icon1.setIcon(img1);
	    panel.add(icon1);
	    
	    name1 = new JLabel("Wood-Club", SwingConstants.CENTER);
	    name1.setBounds(0, 170, 190, 40);
	    panel.add(name1);
	    
	    btn1 = new JButton("Incele");
	    btn1.setBounds(0, 220, 190, 30);
	    btn1.addActionListener(buyHandler);
	    btn1.setActionCommand("item1");
	    panel.add(btn1);
	    
	    icon2 = new JLabel("", SwingConstants.CENTER);
	    img2 = new ImageIcon("icons/kusarigama.png");
	    icon2.setBounds(190, 80, 190, 80);
	    icon2.setIcon(img2);
	    panel.add(icon2);
	    
	    name2 = new JLabel("Kusarigama", SwingConstants.CENTER);
	    name2.setBounds(190, 170, 190, 40);
	    panel.add(name2);
	    
	    btn2 = new JButton("Incele");
	    btn2.setBounds(190, 220, 190, 30);
	    btn2.addActionListener(buyHandler);
	    btn2.setActionCommand("item2");
	    panel.add(btn2);
	    
	    icon3 = new JLabel("", SwingConstants.CENTER);
	    img3 = new ImageIcon("icons/wood-axe.png");
	    icon3.setBounds(380, 80, 190, 80);
	    icon3.setIcon(img3);
	    panel.add(icon3);
	    
	    name3 = new JLabel("Wood-Axe", SwingConstants.CENTER);
	    name3.setBounds(380, 170, 190, 40);
	    panel.add(name3);
	    
	    btn3 = new JButton("Incele");
	    btn3.setBounds(380, 220, 190, 30);
	    btn3.addActionListener(buyHandler);
	    btn3.setActionCommand("item3");
	    panel.add(btn3);
	    
	    icon4 = new JLabel("", SwingConstants.CENTER);
	    img4 = new ImageIcon("icons/sai.png");
	    icon4.setBounds(570, 80, 190, 80);
	    icon4.setIcon(img4);
	    panel.add(icon4);
	    
	    name4 = new JLabel("Sai", SwingConstants.CENTER);
	    name4.setBounds(570, 170, 190, 40);
	    panel.add(name4);
	    
	    btn4 = new JButton("Incele");
	    btn4.setBounds(570, 220, 190, 30);
	    btn4.addActionListener(buyHandler);
	    btn4.setActionCommand("item4");
	    panel.add(btn4);
	    
	    icon5 = new JLabel("", SwingConstants.CENTER);
	    img5 = new ImageIcon("icons/katana.png");
	    icon5.setBounds(760, 80, 190, 80);
	    icon5.setIcon(img5);
	    panel.add(icon5);
	     
	    name5 = new JLabel("Katana", SwingConstants.CENTER);
	    name5.setBounds(760, 170, 190, 40);
	    panel.add(name5);
	   
	    btn5 = new JButton("Incele");
	    btn5.setBounds(760, 220, 190, 30);
	    btn5.addActionListener(buyHandler);
	    btn5.setActionCommand("item5");
	    panel.add(btn5);
	    
	    icon6 = new JLabel("", SwingConstants.CENTER);
	    img6 = new ImageIcon("icons/broadsword.png");
	    icon6.setBounds(0, 260, 190, 80);
	    icon6.setIcon(img6);
	    panel.add(icon6);
	     
	    name6 = new JLabel("Broadsword", SwingConstants.CENTER);
	    name6.setBounds(0, 350, 190, 40);
	    panel.add(name6);
	   
	    btn6 = new JButton("Incele");
	    btn6.setBounds(0, 400, 190, 30);
	    btn6.addActionListener(buyHandler);
	    btn6.setActionCommand("item6");
	    panel.add(btn6);
	    
	    JLabel kasklar = new JLabel("KASKLAR" , SwingConstants.CENTER);
	    kasklar.setFont(titleFont);
	    kasklar.setBounds(0, 440, 1000, 70);
	    panel.add(kasklar);
	 
	    icon7 = new JLabel("", SwingConstants.CENTER);
	    img7 = new ImageIcon("icons/light-helm.png");
	    icon7.setBounds(0, 550, 190, 80);
	    icon7.setIcon(img7);
	    panel.add(icon7);
	     
	    name7 = new JLabel("Light-Helmet", SwingConstants.CENTER);
	    name7.setBounds(0, 640, 190, 40);
	    panel.add(name7);
	   
	    btn7 = new JButton("Incele");
	    btn7.setBounds(0, 690, 190, 30);
	    btn7.addActionListener(buyHandler);
	    btn7.setActionCommand("item7");
	    panel.add(btn7);
	    
	    icon8 = new JLabel("", SwingConstants.CENTER);
	    img8 = new ImageIcon("icons/closed-barbute.png");
	    icon8.setBounds(190, 550, 190, 80);
	    icon8.setIcon(img8);
	    panel.add(icon8);
	     
	    name8 = new JLabel("Closed-Barbute", SwingConstants.CENTER);
	    name8.setBounds(190, 640, 190, 40);
	    panel.add(name8);
	   
	    btn8 = new JButton("Incele");
	    btn8.setBounds(190, 690, 190, 30);
	    btn8.addActionListener(buyHandler);
	    btn8.setActionCommand("item8");
	    panel.add(btn8);
	    
	    icon9 = new JLabel("", SwingConstants.CENTER);
	    img9 = new ImageIcon("icons/heavy-helm.png");
	    icon9.setBounds(380, 550, 190, 80);
	    icon9.setIcon(img9);
	    panel.add(icon9);
	     
	    name9 = new JLabel("Heavy-Helmet", SwingConstants.CENTER);
	    name9.setBounds(380, 640, 190, 40);
	    panel.add(name9);
	   
	    btn9 = new JButton("Incele");
	    btn9.setBounds(380, 690, 190, 30);
	    btn9.addActionListener(buyHandler);
	    btn9.setActionCommand("item9");
	    panel.add(btn9);
	    
	    JLabel zirhlar = new JLabel("ZIRHLAR" , SwingConstants.CENTER);
	    zirhlar.setFont(titleFont);
	    zirhlar.setBounds(0, 730, 1000, 70);
	    panel.add(zirhlar);
	    
	    icon10 = new JLabel("", SwingConstants.CENTER);
	    img10 = new ImageIcon("icons/leather-armor.png");
	    icon10.setBounds(0, 810, 190, 80);
	    icon10.setIcon(img10);
	    panel.add(icon10);
	     
	    name10 = new JLabel("Leather-Armor", SwingConstants.CENTER);
	    name10.setBounds(0, 900, 190, 40);
	    panel.add(name10);
	   
	    btn10 = new JButton("Incele");
	    btn10.setBounds(0, 950, 190, 30);
	    btn10.addActionListener(buyHandler);
	    btn10.setActionCommand("item10");
	    panel.add(btn10);
	    
	    icon11 = new JLabel("", SwingConstants.CENTER);
	    img11 = new ImageIcon("icons/chest-armor.png");
	    icon11.setBounds(190, 810, 190, 80);
	    icon11.setIcon(img11);
	    panel.add(icon11);
	     
	    name11 = new JLabel("Chest-Armor", SwingConstants.CENTER);
	    name11.setBounds(190, 900, 190, 40);
	    panel.add(name11);
	   
	    btn11 = new JButton("Incele");
	    btn11.setBounds(190, 950, 190, 30);
	    btn11.addActionListener(buyHandler);
	    btn11.setActionCommand("item11");
	    panel.add(btn11);
	    
	    icon12 = new JLabel("", SwingConstants.CENTER);
	    img12 = new ImageIcon("icons/lamellar.png");
	    icon12.setBounds(380, 810, 190, 80);
	    icon12.setIcon(img12);
	    panel.add(icon12);
	     
	    name12 = new JLabel("Lamellar", SwingConstants.CENTER);
	    name12.setBounds(380, 900, 190, 40);
	    panel.add(name12);
	   
	    btn12 = new JButton("Incele");
	    btn12.setBounds(380, 950, 190, 30);
	    btn12.addActionListener(buyHandler);
	    btn12.setActionCommand("item12");
	    panel.add(btn12);
	    
	    JLabel pants = new JLabel("PANTS" , SwingConstants.CENTER);
	    pants.setFont(titleFont);
	    pants.setBounds(0, 990, 1000, 70);
	    panel.add(pants);
	    
	    icon13 = new JLabel("", SwingConstants.CENTER);
	    img13 = new ImageIcon("icons/greaves.png");
	    icon13.setBounds(0, 1070, 190, 80);
	    icon13.setIcon(img13);
	    panel.add(icon13);
	     
	    name13 = new JLabel("Greaves", SwingConstants.CENTER);
	    name13.setBounds(0, 1160, 190, 40);
	    panel.add(name13);
	   
	    btn13 = new JButton("Incele");
	    btn13.setBounds(0, 1210, 190, 30);
	    btn13.addActionListener(buyHandler);
	    btn13.setActionCommand("item13");
	    panel.add(btn13);
	    
	    icon14 = new JLabel("", SwingConstants.CENTER);
	    img14 = new ImageIcon("icons/armored-pants.png");
	    icon14.setBounds(190, 1070, 190, 80);
	    icon14.setIcon(img14);
	    panel.add(icon14);
	     
	    name14 = new JLabel("Armored-Pants", SwingConstants.CENTER);
	    name14.setBounds(190, 1160, 190, 40);
	    panel.add(name14);
	   
	    btn14 = new JButton("Incele");
	    btn14.setBounds(190, 1220, 190, 30);
	    btn14.addActionListener(buyHandler);
	    btn14.setActionCommand("item14");
	    panel.add(btn14);
	    
	    icon15 = new JLabel("", SwingConstants.CENTER);
	    img15 = new ImageIcon("icons/metal-skirt.png");
	    icon15.setBounds(380, 1070, 190, 80);
	    icon15.setIcon(img15);
	    panel.add(icon15);
	     
	    name15 = new JLabel("Metal-Skirt", SwingConstants.CENTER);
	    name15.setBounds(380, 1160, 190, 40);
	    panel.add(name15);
	   
	    btn15 = new JButton("Incele");
	    btn15.setBounds(380, 1220, 190, 30);
	    btn15.addActionListener(buyHandler);
	    btn15.setActionCommand("item15");
	    panel.add(btn15);
	    
	    JLabel boots = new JLabel("BOOTS" , SwingConstants.CENTER);
	    boots.setFont(titleFont);
	    boots.setBounds(0, 1260, 1000, 70);
	    panel.add(boots);
	    
	    icon16 = new JLabel("", SwingConstants.CENTER);
	    img16 = new ImageIcon("icons/boots.png");
	    icon16.setBounds(0, 1340, 190, 80);
	    icon16.setIcon(img16);
	    panel.add(icon16);
	     
	    name16 = new JLabel("Leather-Boot", SwingConstants.CENTER);
	    name16.setBounds(0, 1430, 190, 40);
	    panel.add(name16);
	   
	    btn16 = new JButton("Incele");
	    btn16.setBounds(0, 1480, 190, 30);
	    btn16.addActionListener(buyHandler);
	    btn16.setActionCommand("item16");
	    panel.add(btn16);
	    
	    icon17 = new JLabel("", SwingConstants.CENTER);
	    img17 = new ImageIcon("icons/leg-armor.png");
	    icon17.setBounds(190, 1340, 190, 80);
	    icon17.setIcon(img17);
	    panel.add(icon17);
	     
	    name17 = new JLabel("Wood-Boot", SwingConstants.CENTER);
	    name17.setBounds(190, 1430, 190, 40);
	    panel.add(name17);
	   
	    btn17 = new JButton("Incele");
	    btn17.setBounds(190, 1480, 190, 30);
	    btn17.addActionListener(buyHandler);
	    btn17.setActionCommand("item17");
	    panel.add(btn17);
	    
	    icon18 = new JLabel("", SwingConstants.CENTER);
	    img18 = new ImageIcon("icons/metal-boot.png");
	    icon18.setBounds(380, 1340, 190, 80);
	    icon18.setIcon(img18);
	    panel.add(icon18);
	     
	    name18 = new JLabel("Metal-Boot", SwingConstants.CENTER);
	    name18.setBounds(380, 1430, 190, 40);
	    panel.add(name18);
	   
	    btn18 = new JButton("Incele");
	    btn18.setBounds(380, 1480, 190, 30);
	    btn18.addActionListener(buyHandler);
	    btn18.setActionCommand("item18");
	    panel.add(btn18);
	    
	    JLabel potions = new JLabel("POTIONS" , SwingConstants.CENTER);
	    potions.setFont(titleFont);
	    potions.setBounds(0, 1520, 1000, 70);
	    panel.add(potions);
	    
	    icon19 = new JLabel("", SwingConstants.CENTER);
	    img19 = new ImageIcon("icons/potion-ball.png");
	    icon19.setBounds(0, 1600, 190, 80);
	    icon19.setIcon(img19);
	    panel.add(icon19);
	     
	    name19 = new JLabel("Potion-Ball", SwingConstants.CENTER);
	    name19.setBounds(0, 1690, 190, 40);
	    panel.add(name19);
	   
	    btn19 = new JButton("Incele");
	    btn19.setBounds(0, 1740, 190, 30);
	    btn19.addActionListener(buyHandler);
	    btn19.setActionCommand("item19");
	    panel.add(btn19);
	    
	    icon20 = new JLabel("", SwingConstants.CENTER);
	    img20 = new ImageIcon("icons/magic-potion.png");
	    icon20.setBounds(190, 1600, 190, 80);
	    icon20.setIcon(img20);
	    panel.add(icon20);
	     
	    name20 = new JLabel("Magic-Potion", SwingConstants.CENTER);
	    name20.setBounds(190, 1690, 190, 40);
	    panel.add(name20);
	   
	    btn20 = new JButton("Incele");
	    btn20.setBounds(190, 1740, 190, 30);
	    btn20.addActionListener(buyHandler);
	    btn20.setActionCommand("item20");
	    panel.add(btn20);

	    icon21 = new JLabel("", SwingConstants.CENTER);
	    img21 = new ImageIcon("icons/health-potion.png");
	    icon21.setBounds(380, 1600, 190, 80);
	    icon21.setIcon(img21);
	    panel.add(icon21);
	     
	    name21 = new JLabel("Health-Potion", SwingConstants.CENTER);
	    name21.setBounds(380, 1690, 190, 40);
	    panel.add(name21);
	   
	    btn21 = new JButton("Incele");
	    btn21.setBounds(380, 1740, 190, 30);
	    btn21.addActionListener(buyHandler);
	    btn21.setActionCommand("item21");
	    panel.add(btn21);
	    
	    JScrollPane scrollPane = new JScrollPane(panel);
	    marketPanel.setLayout(new BorderLayout());
	    marketPanel.add(scrollPane);
	    marketPanel.setVisible(false);
	    con.add(marketPanel);
	    
	    buyPanel = new JPanel();
		buyPanel.setBackground(Color.BLACK);
		buyPanel.setForeground(Color.WHITE);
		buyPanel.setBounds(1000, 0, 280, 560);
		buyPanel.setLayout(null);
		buyPanel.setVisible(false);
		
		buyItemLabel = new JLabel();
		buyItemLabel.setForeground(Color.WHITE);
		buyItemLabel.setBounds(15, 15, 250, 250);
		buyPanel.add(buyItemLabel);
		
		itemInfoLabel = new JLabel();
		itemInfoLabel.setForeground(Color.WHITE);
		itemInfoLabel.setBounds(15, 275, 200, 200);
		buyPanel.add(itemInfoLabel);
		
		buyButton = new JButton("Satin Al");
		buyButton.setBounds(0, 510, 280, 50);
		buyButton.setBackground(Color.WHITE);
		buyButton.setForeground(Color.BLACK);
		buyButton.setFocusPainted(false);
		buyButton.setContentAreaFilled(false);
		buyButton.addActionListener(buyOption);
		buyPanel.add(buyButton);
		
		con.add(buyPanel);
		
		inventory = new JButton("Inventory");
		inventory.setBackground(Color.WHITE);
		inventory.setForeground(Color.BLACK);
		inventory.setFocusPainted(false);
		inventory.addActionListener(buttonClick);
		inventory.addActionListener(inventoryHandler);
		inventory.setActionCommand("inventoryButton");
		
		marketMapPanel = new JPanel();
		marketMapPanel.setBounds(840, 560, 440, 135);
		marketMapPanel.setBackground(Color.WHITE);
		marketMapPanel.setForeground(Color.BLACK);
		marketMapPanel.setLayout(new GridLayout(1, 3));
		marketMapPanel.add(market);
		marketMapPanel.add(map);
		marketMapPanel.add(inventory);
		con.add(marketMapPanel);
		
		mapPanel = new JPanel();
		mapPanel.setBounds(0, 0, 1280, 560);
		mapPanel.setBackground(Color.BLACK);
		mapPanel.setForeground(Color.WHITE);
		mapPanel.setLayout(null);
		mapPanel.setVisible(false);
	
		con.add(mapPanel);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(660, 260, 300, 300);
		choiceButtonPanel.setBackground(Color.BLACK);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.WHITE);
		choice1.setForeground(Color.BLACK);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler); 
		choice1.setActionCommand("c1"); 
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.WHITE);
		choice2.setForeground(Color.BLACK);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.WHITE);
		choice3.setForeground(Color.BLACK);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.WHITE);
		choice4.setForeground(Color.BLACK);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(960, 260, 300, 300);
		inventoryPanel.setBackground(Color.BLACK);
		inventoryPanel.setForeground(Color.WHITE);
		inventoryPanel.setLayout(new GridLayout(5, 1));
		con.add(inventoryPanel);
		
		itemButton1 = new JButton("");
		itemButton1.setBackground(Color.BLACK);
		itemButton1.setForeground(Color.BLACK);
		itemButton1.setFont(normalFont);
		itemButton1.setFocusPainted(false);
		itemButton1.addActionListener(inventoryHandler);
		itemButton1.setActionCommand("item1");
		inventoryPanel.add(itemButton1);
		
		itemButton2 = new JButton("");
		itemButton2.setBackground(Color.BLACK);
		itemButton2.setForeground(Color.BLACK);
		itemButton2.setFont(normalFont);
		itemButton2.setFocusPainted(false);
		itemButton2.addActionListener(inventoryHandler);
		itemButton2.setActionCommand("item2");
		inventoryPanel.add(itemButton2);
		
		itemButton3 = new JButton("");
		itemButton3.setBackground(Color.BLACK);
		itemButton3.setForeground(Color.BLACK);
		itemButton3.setFont(normalFont);
		itemButton3.setFocusPainted(false);
		itemButton3.addActionListener(inventoryHandler);
		itemButton3.setActionCommand("item3");
		inventoryPanel.add(itemButton3);
		
		itemButton4 = new JButton("");
		itemButton4.setBackground(Color.BLACK);
		itemButton4.setForeground(Color.BLACK);
		itemButton4.setFont(normalFont);
		itemButton4.setFocusPainted(false);
		itemButton4.addActionListener(inventoryHandler);
		itemButton4.setActionCommand("item4");
		inventoryPanel.add(itemButton4);

		itemButton5 = new JButton("");
		itemButton5.setBackground(Color.BLACK);
		itemButton5.setForeground(Color.BLACK);
		itemButton5.setFont(normalFont);
		itemButton5.setFocusPainted(false);
		itemButton5.addActionListener(inventoryHandler);
		itemButton5.setActionCommand("item5");
		inventoryPanel.add(itemButton5);
		
		inventoryPanel.setVisible(false);

		playerPanel = new JPanel();
		playerPanel.setBounds(150, 560, 250, 160);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new FlowLayout());
		con.add(playerPanel);
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		hpLabel.setPreferredSize(new Dimension(100, 30));
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		hpLabelNumber.setText("" + playerHP);
		hpLabelNumber.setPreferredSize(new Dimension(100, 30));
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		weaponLabel.setBackground(Color.BLACK);
		weaponLabel.setPreferredSize(new Dimension(100, 30));
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		weaponLabelName.setText("" + weapon);
		weaponLabelName.setPreferredSize(new Dimension(100, 30));
		playerPanel.add(weaponLabelName);
		
		coinLabel = new JLabel("Coin:");
		coinLabel.setFont(normalFont);
		coinLabel.setForeground(Color.WHITE);
		coinLabel.setBackground(Color.BLACK);
		coinLabel.setPreferredSize(new Dimension(100, 30));
		playerPanel.add(coinLabel);
		
		coinLabelNumber = new JLabel();
		coinLabelNumber.setFont(normalFont);
		coinLabelNumber.setForeground(Color.WHITE);
		coinLabelNumber.setBackground(Color.BLACK);
		coinLabelNumber.setText("" + playerCoin);
		coinLabelNumber.setPreferredSize(new Dimension(100, 30));
		playerPanel.add(coinLabelNumber);
		
		healthPanel = new JPanel();
		healthPanel.setBounds(400, 560, 400, 160);
		healthPanel.setBackground(Color.BLACK);
		healthPanel.setLayout(new FlowLayout());
		con.add(healthPanel);
		
		hpCount = new JLabel("HP");
		hpCount.setForeground(Color.white);
		hpCount.setBackground(Color.black);
		hpCount.setFont(normalFont);
		healthPanel.add(hpCount);     
		UIManager.put("healthBar.selectionForeground",Color.GRAY);
		UIManager.put("expBar.selectionForeground",Color.GRAY);
		healthBar = new JProgressBar(0, playerHP);
		healthBar.setStringPainted(true);
		healthBar.setPreferredSize(new Dimension(350, 50));
		healthBar.setForeground(Color.WHITE);
		healthBar.setValue(playerHP);
		
		expCount = new JLabel("XP");
		expCount.setForeground(Color.white);
		expCount.setBackground(Color.black);
		expCount.setFont(normalFont);
		
		expBar = new JProgressBar(0,10);
		expBar.setStringPainted(true);
		expBar.setPreferredSize(new Dimension(350, 50));
		expBar.setForeground(Color.WHITE);
		expBar.setValue(0);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(healthBar);
			SwingUtilities.updateComponentTreeUI(expBar);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(window);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		healthPanel.add(healthBar);
		healthPanel.add(expCount);
		healthPanel.add(expBar);
		
		playerItem[0] = "Potion";
		playerItem[1] = "Orange";
		playerItem[2] = "";
		playerItem[3] = "";
		playerItem[4] = "";
		
		if(start == true) {
			EP1screen1();
		}
	}
	public void viewMap() {
		if(episode == "episode1") 
		{
			
			ep1s1 = new JButton("");
			ep1s1.setBounds(290, 35, 70, 70);
			ep1s1i = new ImageIcon("map/EP1screen1.png");
			ep1s1.setIcon(ep1s1i);
			mapPanel.add(ep1s1);
			
			ep1s2 = new JButton("");
			ep1s2.setBounds(360, 35, 70, 70);
			ep1s2i = new ImageIcon("map/EP1screen2.png");
			ep1s2.setIcon(ep1s2i);
			mapPanel.add(ep1s2);
			
			ep1s3 = new JButton("");
			ep1s3.setBounds(430, 35, 70, 70);
			ep1s3i = new ImageIcon("map/EP1screen3.png");
			ep1s3.setIcon(ep1s3i);
			mapPanel.add(ep1s3);
			
			ep1s4 = new JButton("");
			ep1s4.setBounds(430, 105, 70, 70);
			ep1s4i = new ImageIcon("map/EP1screen4.png");
			ep1s4.setIcon(ep1s4i);
			mapPanel.add(ep1s4);
			
			ep1s5 = new JButton("");
			ep1s5.setBounds(430, 175, 70, 70);
			ep1s5i = new ImageIcon("map/EP1screen5.png");
			ep1s5.setIcon(ep1s5i);
			mapPanel.add(ep1s5);
			
			ep1s6 = new JButton("");
			ep1s6.setBounds(360, 175, 70, 70);
			ep1s6i = new ImageIcon("map/EP1screen6.png");
			ep1s6.setIcon(ep1s6i);
			mapPanel.add(ep1s6);
			
			ep1s7 = new JButton("");
			ep1s7.setBounds(500, 175, 70, 70);
			ep1s7i = new ImageIcon("map/EP1screen7.png");
			ep1s7.setIcon(ep1s7i);
			mapPanel.add(ep1s7);
			
			ep1s8 = new JButton("");
			ep1s8.setBounds(570, 175, 70, 70);
			ep1s8i = new ImageIcon("map/EP1screen8.png");
			ep1s8.setIcon(ep1s8i);
			mapPanel.add(ep1s8);
			
			ep1s9 = new JButton("");
			ep1s9.setBounds(500, 35, 70, 70);
			ep1s9i = new ImageIcon("map/EP1screen9.png");
			ep1s9.setIcon(ep1s9i);
			mapPanel.add(ep1s9);
			
			ep1s10 = new JButton("");
			ep1s10.setBounds(570, 35, 70, 70);
			ep1s10i = new ImageIcon("map/EP1screen10.png");
			ep1s10.setIcon(ep1s10i);
			mapPanel.add(ep1s10);
			
			ep1s11 = new JButton("");
			ep1s11.setBounds(640, 35, 70, 70);
			ep1s11i = new ImageIcon("map/EP1screen11.png");
			ep1s11.setIcon(ep1s11i);
			mapPanel.add(ep1s11);
			
			ep1s12 = new JButton("");
			ep1s12.setBounds(710, 35, 70, 70);
			ep1s12i = new ImageIcon("map/EP1screen12.png");
			ep1s12.setIcon(ep1s12i);
			mapPanel.add(ep1s12);
			
			ep1s13 = new JButton("");
			ep1s13.setBounds(710, 105, 70, 70);
			ep1s13i = new ImageIcon("map/EP1screen13.png");
			ep1s13.setIcon(ep1s13i);
			mapPanel.add(ep1s13);
			
			ep1s14 = new JButton("");
			ep1s14.setBounds(780, 35, 70, 70);
			ep1s14i = new ImageIcon("map/EP1screen14.png");
			ep1s14.setIcon(ep1s14i);
			mapPanel.add(ep1s14);
			
			ep1s15 = new JButton("");
			ep1s15.setBounds(850, 35, 70, 70);
			ep1s15i = new ImageIcon("map/EP1screen15.png");
			ep1s15.setIcon(ep1s15i);
			mapPanel.add(ep1s15);
			
			ep1s16 = new JButton("");
			ep1s16.setBounds(850, 105, 70, 70);
			ep1s16i = new ImageIcon("map/EP1screen16.png");
			ep1s16.setIcon(ep1s16i);
			mapPanel.add(ep1s16);
			
			ep1s17 = new JButton("");
			ep1s17.setBounds(850, 175, 70, 70);
			ep1s17i = new ImageIcon("map/EP1screen17.png");
			ep1s17.setIcon(ep1s17i);
			mapPanel.add(ep1s17);
			
			ep1s18 = new JButton("");
			ep1s18.setBounds(850, 245, 70, 70);
			ep1s18i = new ImageIcon("map/EP1screen18.png");
			ep1s18.setIcon(ep1s18i);
			mapPanel.add(ep1s18);
			
			ep1s19 = new JButton("");
			ep1s19.setBounds(850, 315, 70, 70);
			ep1s19i = new ImageIcon("map/EP1screen19.png");
			ep1s19.setIcon(ep1s19i);
			mapPanel.add(ep1s19);
			
			ep1s20 = new JButton("");
			ep1s20.setBounds(780, 315, 70, 70);
			ep1s20i = new ImageIcon("map/EP1screen20.png");
			ep1s20.setIcon(ep1s20i);
			mapPanel.add(ep1s20);
			
			ep1s21 = new JButton("");
			ep1s21.setBounds(710, 315, 70, 70);
			ep1s21i = new ImageIcon("map/EP1screen21.png");
			ep1s21.setIcon(ep1s21i);
			mapPanel.add(ep1s21);
			
			ep1s22 = new JButton("");
			ep1s22.setBounds(640, 315, 70, 70);
			ep1s22i = new ImageIcon("map/EP1screen22.png");
			ep1s22.setIcon(ep1s22i);
			mapPanel.add(ep1s22);
			
			ep1s23 = new JButton("");
			ep1s23.setBounds(570, 315, 70, 70);
			ep1s23i = new ImageIcon("map/EP1screen23.png");
			ep1s23.setIcon(ep1s23i);
			mapPanel.add(ep1s23);
			
			ep1s24 = new JButton("");
			ep1s24.setBounds(640, 385, 70, 70);
			ep1s24i = new ImageIcon("map/EP1screen24.png");
			ep1s24.setIcon(ep1s24i);
			mapPanel.add(ep1s24);
			
			ep1s25 = new JButton("");
			ep1s25.setBounds(640, 455, 70, 70);
			ep1s25i = new ImageIcon("map/EP1screen25.png");
			ep1s25.setIcon(ep1s25i);
			mapPanel.add(ep1s25);
			
			ep1b1 = new JButton("");
			ep1b1.setBounds(920, 175, 70, 70);
			ep1b1i = new ImageIcon("map/EP1screen17.png");
			ep1b1.setIcon(ep1b1i);
			mapPanel.add(ep1b1);
			
			ep1b2 = new JButton("");
			ep1b2.setBounds(710, 455, 70, 70);
			ep1b2i = new ImageIcon("map/EP1screen25.png");
			ep1b2.setIcon(ep1b2i);
			mapPanel.add(ep1b2);
			
			ep1b3 = new JButton("");
			ep1b3.setBounds(290, 175, 70, 70);
			ep1b3i = new ImageIcon("map/EP1screen6.png");
			ep1b3.setIcon(ep1b3i);
			mapPanel.add(ep1b3);
			
			ep1b4 = new JButton("");
			ep1b4.setBounds(500, 315, 70, 70);
			ep1b4i = new ImageIcon("map/EP1screen22.png");
			ep1b4.setIcon(ep1b4i);
			mapPanel.add(ep1b4);
		}
		else if(episode == "episode2")
		{
			ep2s1 = new JButton("");
			ep2s1.setBounds(190, 460, 90, 90);
			ep2s1i = new ImageIcon("map/EP2screen1.png");
			ep2s1.setIcon(ep2s1i);
			mapPanel.add(ep2s1);
			
			ep2s2 = new JButton("");
			ep2s2.setBounds(280, 460, 90, 90);
			ep2s2i = new ImageIcon("map/EP2screen2.png");
			ep2s2.setIcon(ep2s2i);
			mapPanel.add(ep2s2);
			
			ep2s3 = new JButton("");
			ep2s3.setBounds(280, 370, 90, 90);
			ep2s3i = new ImageIcon("map/EP2screen3.png");
			ep2s3.setIcon(ep2s3i);
			mapPanel.add(ep2s3);
			
			ep2s4 = new JButton("");
			ep2s4.setBounds(280, 280, 90, 90);
			ep2s4i = new ImageIcon("map/EP2screen4.png");
			ep2s4.setIcon(ep2s4i);
			mapPanel.add(ep2s4);
			
			ep2s5 = new JButton("");
			ep2s5.setBounds(280, 190, 90, 90);
			ep2s5i = new ImageIcon("map/EP2screen5.png");
			ep2s5.setIcon(ep2s5i);
			mapPanel.add(ep2s5);
			
			ep2s6 = new JButton("");
			ep2s6.setBounds(280, 100, 90, 90);
			ep2s6i = new ImageIcon("map/EP2screen6.png");
			ep2s6.setIcon(ep2s6i);
			mapPanel.add(ep2s6);
			
			ep2s7 = new JButton("");
			ep2s7.setBounds(190, 100, 90, 90);
			ep2s7i = new ImageIcon("map/EP2screen7.png");
			ep2s7.setIcon(ep2s7i);
			mapPanel.add(ep2s7);
			
			ep2s8 = new JButton("");
			ep2s8.setBounds(370, 100, 90, 90);
			ep2s8i = new ImageIcon("map/EP2screen8.png");
			ep2s8.setIcon(ep2s8i);
			mapPanel.add(ep2s8);
			
			ep2s9 = new JButton("");
			ep2s9.setBounds(460, 100, 90, 90);
			ep2s9i = new ImageIcon("map/EP2screen9.png");
			ep2s9.setIcon(ep2s9i);
			mapPanel.add(ep2s9);
			
			ep2s10 = new JButton("");
			ep2s10.setBounds(550, 100, 90, 90);
			ep2s10i = new ImageIcon("map/EP2screen10.png");
			ep2s10.setIcon(ep2s10i);
			mapPanel.add(ep2s10);
			
			ep2s11 = new JButton("");
			ep2s11.setBounds(640, 100, 90, 90);
			ep2s11i = new ImageIcon("map/EP2screen11.png");
			ep2s11.setIcon(ep2s11i);
			mapPanel.add(ep2s11);
			
			ep2s12 = new JButton("");
			ep2s12.setBounds(730, 100, 90, 90);
			ep2s12i = new ImageIcon("map/EP2screen12.png");
			ep2s12.setIcon(ep2s12i);
			mapPanel.add(ep2s12);
			
			ep2s13 = new JButton("");
			ep2s13.setBounds(820, 100, 90, 90);
			ep2s13i = new ImageIcon("map/EP2screen13.png");
			ep2s13.setIcon(ep2s13i);
			mapPanel.add(ep2s13);
			
			ep2s14 = new JButton("");
			ep2s14.setBounds(910, 100, 90, 90);
			ep2s14i = new ImageIcon("map/EP2screen14.png");
			ep2s14.setIcon(ep2s14i);
			mapPanel.add(ep2s14);
			
			ep2s15 = new JButton("");
			ep2s15.setBounds(910, 190, 90, 90);
			ep2s15i = new ImageIcon("map/EP2screen15.png");
			ep2s15.setIcon(ep2s15i);
			mapPanel.add(ep2s15);
			
			ep2s16 = new JButton("");
			ep2s16.setBounds(910, 280, 90, 90);
			ep2s16i = new ImageIcon("map/EP2screen16.png");
			ep2s16.setIcon(ep2s16i);
			mapPanel.add(ep2s16);
			
			ep2s17 = new JButton("");
			ep2s17.setBounds(910, 370, 90, 90);
			ep2s17i = new ImageIcon("map/EP2screen17.png");
			ep2s17.setIcon(ep2s17i);
			mapPanel.add(ep2s17);
			
			ep2s18 = new JButton("");
			ep2s18.setBounds(910, 460, 90, 90);
			ep2s18i = new ImageIcon("map/EP2screen18.png");
			ep2s18.setIcon(ep2s18i);
			mapPanel.add(ep2s18);
			
			ep2b1 = new JButton("");
			ep2b1.setBounds(190, 10, 90, 90);
			ep2b1i = new ImageIcon("map/EP2screen7.png");
			ep2b1.setIcon(ep2b1i);
			mapPanel.add(ep2b1);
			
			ep2b2 = new JButton("");
			ep2b2.setBounds(550, 10, 90, 90);
			ep2b2i = new ImageIcon("map/EP2screen10.png");
			ep2b2.setIcon(ep2b2i);
			mapPanel.add(ep2b2);
			
			ep2b3 = new JButton("");
			ep2b3.setBounds(550, 190, 90, 90);
			ep2b3i = new ImageIcon("map/EP2screen10.png");
			ep2b3.setIcon(ep2b3i);
			mapPanel.add(ep2b3);
			
			ep2b4 = new JButton("");
			ep2b4.setBounds(910, 10, 90, 90);
			ep2b4i = new ImageIcon("map/EP2screen14.png");
			ep2b4.setIcon(ep2b4i);
			mapPanel.add(ep2b4);
			
			ep2b5 = new JButton("");
			ep2b5.setBounds(1000, 460, 90, 90);
			ep2b5i = new ImageIcon("map/EP2screen17.png");
			ep2b5.setIcon(ep2b5i);
			mapPanel.add(ep2b5);
		}
		else if(episode == "episode3")
		{
			ep3s1 = new JButton("");
			ep3s1.setBounds(390, 30, 100, 100);
			ep3s1i = new ImageIcon("map/EP3screen1.png");
			ep3s1.setIcon(ep3s1i);
			mapPanel.add(ep3s1);
			
			ep3s2 = new JButton("");
			ep3s2.setBounds(490, 30, 100, 100);
			ep3s2i = new ImageIcon("map/EP3screen2.png");
			ep3s2.setIcon(ep3s2i);
			mapPanel.add(ep3s2);
			
			ep3s3 = new JButton("");
			ep3s3.setBounds(590, 30, 100, 100);
			ep3s3i = new ImageIcon("map/EP3screen3.png");
			ep3s3.setIcon(ep3s3i);
			mapPanel.add(ep3s3);
			
			ep3s4 = new JButton("");
			ep3s4.setBounds(690, 30, 100, 100);
			ep3s4i = new ImageIcon("map/EP3screen4.png");
			ep3s4.setIcon(ep3s4i);
			mapPanel.add(ep3s4);
			
			ep3s5 = new JButton("");
			ep3s5.setBounds(790, 130, 100, 100);
			ep3s5i = new ImageIcon("map/EP3screen5.png");
			ep3s5.setIcon(ep3s5i);
			mapPanel.add(ep3s5);
			
			ep3s6 = new JButton("");
			ep3s6.setBounds(790, 230, 100, 100);
			ep3s6i = new ImageIcon("map/EP3screen6.png");
			ep3s6.setIcon(ep3s6i);
			mapPanel.add(ep3s6);
			
			ep3s7 = new JButton("");
			ep3s7.setBounds(790, 330, 100, 100);
			ep3s7i = new ImageIcon("map/EP3screen7.png");
			ep3s7.setIcon(ep3s7i);
			mapPanel.add(ep3s7);
			
			ep3s8 = new JButton("");
			ep3s8.setBounds(690, 430, 100, 100);
			ep3s8i = new ImageIcon("map/EP3screen8.png");
			ep3s8.setIcon(ep3s8i);
			mapPanel.add(ep3s8);
			
			ep3s9 = new JButton("");
			ep3s9.setBounds(590, 430, 100, 100);
			ep3s9i = new ImageIcon("map/EP3screen9.png");
			ep3s9.setIcon(ep3s9i);
			mapPanel.add(ep3s9);
			
			ep3s10 = new JButton("");
			ep3s10.setBounds(490, 430, 100, 100);
			ep3s10i = new ImageIcon("map/EP3screen10.png");
			ep3s10.setIcon(ep3s10i);
			mapPanel.add(ep3s10);
			
			ep3s11 = new JButton("");
			ep3s11.setBounds(390, 330, 100, 100);
			ep3s11i = new ImageIcon("map/EP3screen11.png");
			ep3s11.setIcon(ep3s11i);
			mapPanel.add(ep3s11);
			
			ep3s12 = new JButton("");
			ep3s12.setBounds(390, 230, 100, 100);
			ep3s12i = new ImageIcon("map/EP3screen12.png");
			ep3s12.setIcon(ep3s12i);
			mapPanel.add(ep3s12);
			
			ep3s13 = new JButton("");
			ep3s13.setBounds(490, 130, 100, 100);
			ep3s13i = new ImageIcon("map/EP3screen13.png");
			ep3s13.setIcon(ep3s13i);
			mapPanel.add(ep3s13);
			
			ep3s14 = new JButton("");
			ep3s14.setBounds(590, 130, 100, 100);
			ep3s14i = new ImageIcon("map/EP3screen14.png");
			ep3s14.setIcon(ep3s14i);
			mapPanel.add(ep3s14);
			
			ep3s15 = new JButton("");
			ep3s15.setBounds(690, 230, 100, 100);
			ep3s15i = new ImageIcon("map/EP3screen15.png");
			ep3s15.setIcon(ep3s15i);
			mapPanel.add(ep3s15);
			
			ep3s16 = new JButton("");
			ep3s16.setBounds(590, 330, 100, 100);
			ep3s16i = new ImageIcon("map/EP3screen16.png");
			ep3s16.setIcon(ep3s16i);
			mapPanel.add(ep3s16);
			
			ep3s17 = new JButton("");
			ep3s17.setBounds(490, 230, 100, 100);
			ep3s17i = new ImageIcon("map/EP3screen17.png");
			ep3s17.setIcon(ep3s17i);
			mapPanel.add(ep3s17);
			
			ep3b1 = new JButton("");
			ep3b1.setBounds(790, 30, 100, 100);
			ep3b1i = new ImageIcon("map/EP3boss1.gif");
			ep3b1.setIcon(ep3b1i);
			mapPanel.add(ep3b1);
			
			ep3b2 = new JButton("");
			ep3b2.setBounds(790, 430, 100, 100);
			ep3b2i = new ImageIcon("map/EP3boss2.gif");
			ep3b2.setIcon(ep3b2i);
			mapPanel.add(ep3b2);
			
			ep3b3 = new JButton("");
			ep3b3.setBounds(390, 430, 100, 100);
			ep3b3i = new ImageIcon("map/EP3boss3.gif");
			ep3b3.setIcon(ep3b3i);
			mapPanel.add(ep3b3);
			
			ep3b4 = new JButton("");
			ep3b4.setBounds(390, 130, 100, 100);
			ep3b4i = new ImageIcon("map/EP3boss4.gif");
			ep3b4.setIcon(ep3b4i);
			mapPanel.add(ep3b4);
			
			ep3b5 = new JButton("");
			ep3b5.setBounds(690, 130, 100, 100);
			ep3b5i = new ImageIcon("map/EP3boss5.gif");
			ep3b5.setIcon(ep3b5i);
			mapPanel.add(ep3b5);
			
			ep3b6 = new JButton("");
			ep3b6.setBounds(690, 330, 100, 100);
			ep3b6i = new ImageIcon("map/EP3boss6.gif");
			ep3b6.setIcon(ep3b6i);
			mapPanel.add(ep3b6);
			
			ep3b7 = new JButton("");
			ep3b7.setBounds(490, 330, 100, 100);
			ep3b7i = new ImageIcon("map/EP3boss7.gif");
			ep3b7.setIcon(ep3b7i);
			mapPanel.add(ep3b7);
			
			ep3b8 = new JButton("");
			ep3b8.setBounds(590, 230, 100, 100);
			ep3b8i = new ImageIcon("map/EP3boss8.gif");
			ep3b8.setIcon(ep3b8i);
			mapPanel.add(ep3b8);
		}
	}
	public void loadData() {
		try {
			Scanner br = new Scanner(new File("save.txt"));
			start = false;
			while (br.hasNextLine()) {
				position = br.nextLine();
				playerHP = Integer.parseInt(br.nextLine());
				weapon = br.nextLine();
				playerCoin = Integer.parseInt(br.nextLine());
		    }
			
			br.close();
			start = false;
			PlayerSelection();
			LevelSelection();
			createGameScreen();
			EP1screen1();
			EP1screen2();
			
		}
		catch(Exception e) {
			
		}
	}
	public void saveData() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
			
			bw.write(position + "\n");
			bw.write(playerHP + "\n");
			bw.write(weapon + "\n");
			bw.write(playerCoin + "\n");
			
			bw.close();
		}
		catch(Exception e) {
			
		}
		
	}
	public void EP1screen1(){
		position = "EP1screen1";
		episode = "episode1";
		viewMap();
		updateMap();
		saveData();
		//mainTextArea.setText("EP1screen1 -> EP1screen2");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		screen = new ImageIcon("images/EP1screen1.gif");
		backgroundLabel.setIcon(screen);
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen2(){
		position = "EP1screen2";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen2 -> EP1screen3");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen3(){
		position = "EP1screen3";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen3 -> EP1screen4 || EP1Screen9");
		text = "Yol ikiye ayrılıyor. Acaba nereden gitmeliyim ?";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Asagi in");
		choice3.setText("Geri");
		choice4.setText("");
	}
	public void EP1screen4(){
		position = "EP1screen4";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen4 -> EP1screen5");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen5(){
		position = "EP1screen5";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen5 -> EP1screen6 || EP1screen7");
		text = "Yol ikiye ayrılıyor. Acaba nereden gitmeliyim ?";
		prepareText();
		choice1.setText("Sola Git");
		choice2.setText("Saga git");
		choice3.setText("Geri");
		choice4.setText("");
	}
	public void EP1screen6(){
		position = "EP1screen6";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen6 -> EP1boss3");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen7(){
		position = "EP1screen7";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen7 -> EP1screen8");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen8(){
		position = "EP1screen8";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen8 -> NULL");
		text = "Yol burada bitmiş gibi görünüyor. Sanırım geri dönmeliyim.";
		prepareText();
		choice1.setText("Geri");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen9(){
		position = "EP1screen9";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen9 -> EP1screen10");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen10(){
		position = "EP1screen10";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen10 -> EP1screen11");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen11(){
		position = "EP1screen11";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1scree11 -> EP1screen12");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen12(){
		position = "EP1screen12";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen12 -> EP1screen13 || EP1screen14");
		text = "Yol ikiye ayrılıyor. Acaba nereden gitmeliyim ?";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Asagi in");
		choice3.setText("Geri");
		choice4.setText("");
	}
	public void EP1screen13(){
		position = "EP1screen13";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		//mainTextArea.setText("EP1screen9 -> NULL (Long Sword founded)");
		text = "Tebrikler ! Bir Easter Egg buldunuz. (Long Sword eşyası envanterinize eklendi.)";
		prepareText();
		choice1.setText("Geri");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen14(){
		position = "EP1screen14";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen14 -> EP1screen15");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen15(){
		position = "EP1screen15";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen15 -> EP1screen16");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen16(){
		position = "EP1screen16";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen16 -> EP1screen17");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen17(){
		position = "EP1screen17";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen17 -> EP1boss1");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Asagi in");
		choice3.setText("Geri");
		choice4.setText("");
	}
	public void EP1screen18(){
		position = "EP1screen18";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen18 -> EP1screen19");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen19(){
		position = "EP1screen19";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen19 -> EP1screen20");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen20(){
		position = "EP1screen20";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen20 -> EP1screen21");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen21(){
		position = "EP1screen21";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen21 -> EP1screen22");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen22(){
		position = "EP1screen22";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen22 -> EP1screen23 || EP1screen24");
		text = "Yol ikiye ayrılıyor. Acaba nereden gitmeliyim ?";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Asagi in");
		choice3.setText("Geri");
		choice4.setText("");
	}
	public void EP1screen23(){
		position = "EP1screen23";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen23 -> EP1boss4");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen24(){
		position = "EP1screen24";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen24 -> EP1screen25");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1screen25(){
		position = "EP1screen25";
		updateMap();
		saveData();
		se.setFile(walkSound);
		se.play();
		//mainTextArea.setText("EP1screen25 -> EP1boss2");
		text = "Sanırım ilerlemem gerek !";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void playerAttack(){
		position = "playerAttack";
		
		playerDamage = 0;
		
		if(weapon.equals("Knife")){
			playerDamage = new java.util.Random().nextInt(3) + savedXP;
		}
		else if(weapon.equals("Wood-Club")) {
			playerDamage = new java.util.Random().nextInt(5) + savedXP;
		}
		else if(weapon.equals("Kusarigama")) {
			playerDamage = new java.util.Random().nextInt(6) + savedXP;
		}
		else if(weapon.equals("Wood-Axe")) {
			playerDamage = new java.util.Random().nextInt(7) + savedXP;
		}
		else if(weapon.equals("Sai")) {
			playerDamage = new java.util.Random().nextInt(8) + savedXP;
		}
		else if(weapon.equals("Katana")) {
			playerDamage = new java.util.Random().nextInt(9) + savedXP;
		}
		else if(weapon.equals("Broadsword")) {
			playerDamage = new java.util.Random().nextInt(10) + savedXP;
		}
		else if(weapon.equals("Long Sword")){
			playerDamage = new java.util.Random().nextInt(12) + savedXP; 
		}
		se.setFile(playerAttack);
		se.play();
		//mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		text = monsterName + " canavarina saldirdiniz ve " + playerDamage + " hasar verdiniz!";
		prepareText();
		
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText("Devam Et");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void monsterAttack(){
		position = "monsterAttack";
		int monsterDamage = 0;
		if(monsterName == "EP1boss1") {
			monsterDamage = new java.util.Random().nextInt(10);
		}
		else if(monsterName == "EP1boss2") {
			monsterDamage = new java.util.Random().nextInt(12);
		}
		else if(monsterName == "EP1boss3") {
			monsterDamage = new java.util.Random().nextInt(14);
		}
		else if(monsterName == "EP1boss4") {
			monsterDamage = new java.util.Random().nextInt(16);
		}
		else if(monsterName == "EP2boss1") {
			monsterDamage = new java.util.Random().nextInt(18);
		}
		else if(monsterName == "EP2boss2") {
			monsterDamage = new java.util.Random().nextInt(20);
		}
		else if(monsterName == "EP2boss3") {
			monsterDamage = new java.util.Random().nextInt(22);
		}
		else if(monsterName == "EP2boss4") {
			monsterDamage = new java.util.Random().nextInt(24);
		}
		else if(monsterName == "EP2boss5") {
			monsterDamage = new java.util.Random().nextInt(26);
		}
		
		//mainTextArea.setText("The " + monsterName + " attacked you and gave " + monsterDamage + " damage!");
		text = monsterName + " canavari size saldirdi ve " + monsterDamage + " hasar aldiniz!";
		prepareText();
		
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText(""+playerHP);
		healthBar.setValue(playerHP);
		
		choice1.setText("Devam Et");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void fight(){
		position = "fight";
		//mainTextArea.setText("Monster Name : " + monsterName + "\nMonster HP : " + monsterHP + " \nWhat do you do ?");
		text = "Canavar Adi : " + monsterName + "\nMonster Can : " + monsterHP + " \nNe yapacaksiniz ?";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1boss1(){
		position = "EP1boss1";
		updateMap();
		se.setFile(ep1b1s);
		se.play();
		monsterName = "EP1boss1";
		monsterHP = 10;
		
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP1boss2(){
		position = "EP1boss2";
		updateMap();
		se.setFile(ep1b2s);
		se.play();
		monsterName = "EP1boss2";
		monsterHP = 15;
		
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
		
		if(EP1boss1key != true) {
			//mainTextArea.setText("Kilitli. Once boss1'i yenmelisiniz.");
			text = "Kilitli. Once boss1'i yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else
		{
			//mainTextArea.setText("EP1boss2");
			text = "EP1boss2";
			prepareText();
			choice1.setVisible(true);
		}
	}
	public void EP1boss3(){
		position = "EP1boss3";
		updateMap();
		se.setFile(ep1b3s);
		se.play();
		monsterName = "EP1boss3";
		monsterHP = 20;
		
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
		if(EP1boss1key != true && EP1boss2key != true) {
			//mainTextArea.setText("Kilitli. Once boss1 ve boss2'yi yenmelisiniz.");
			text = "Kilitli. Once boss1 ve boss2'yi yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP1boss1key == true && EP1boss2key != true) {
			//mainTextArea.setText("Kilitli. Once boss2'yi yenmelisiniz.");
			text = "Kilitli. Once boss2'yi yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else
		{
			mainTextArea.setText("EP1boss3");
			text = "EP1boss3";
			prepareText();
			choice1.setVisible(true);
		}
	}
	public void EP1boss4(){
		position = "EP1boss4";
		updateMap();
		se.setFile(ep1b4s);
		se.play();
		monsterName = "EP1boss4";
		monsterHP = 25;
		
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
		if(EP1boss1key != true && EP1boss2key != true && EP1boss3key != true) {
			//mainTextArea.setText("Kilitli. Once boss1, boss2 ve boss3'u yenmelisiniz.");
			text = "Kilitli. Once boss1, boss2 ve boss3'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP1boss1key == true && EP1boss2key != true && EP1boss3key != true) {
			//mainTextArea.setText("Kilitli. Once boss2 ve boss3'u yenmelisiniz.");
			text = "Kilitli. Once boss2 ve boss3'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP1boss1key == true && EP1boss2key == true && EP1boss3key != true) {
			//mainTextArea.setText("Kilitli. Once boss3'u yenmelisiniz.");
			text = "Kilitli. Once boss3'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else
		{
			//mainTextArea.setText("EP1boss4");
			text = "EP1boss4";
			prepareText();
			choice1.setVisible(true);
		}
	}
	public void EP2screen1() {
		position = "EP2screen1";
		episode = "episode2";
		viewMap();
		updateMap();
		screen = new ImageIcon("images/EP2screen1.gif");
		pixel = new ImageIcon("images/level2.gif");
		backgroundLabel.setIcon(screen);
		//mainTextArea.setText("EP2screen1 -> EP2screen2");
		text = "EP2screen1 -> EP2screen2";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen2() {
		position = "EP2screen2";
		updateMap();
		//mainTextArea.setText("EP2screen2 -> EP2screen3");
		text = "EP2screen2 -> EP2screen3";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen3() {
		position = "EP2screen3";
		updateMap();
		//mainTextArea.setText("EP2screen3 -> EP2screen4");
		text = "EP2screen3 -> EP2screen4";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen4() {
		position = "EP2screen4";
		updateMap();
		//mainTextArea.setText("EP2screen4 -> EP2screen5");
		text = "EP2screen4 -> EP2screen5";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen5() {
		position = "EP2screen5";
		updateMap();
		//mainTextArea.setText("EP2screen5 -> EP2screen6");
		text = "EP2screen5 -> EP2screen6";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen6() {
		position = "EP2screen6";
		updateMap();
		//mainTextArea.setText("EP2screen6 -> EP2screen7 || EP2screen8");
		text = "EP2screen6 -> EP2screen7 || EP2screen8";
		prepareText();
		choice1.setText("Sola Git");
		choice2.setText("Saga Git");
		choice3.setText("Geri");
		choice4.setText("");
	}
	public void EP2screen7() {
		position = "EP2screen7";
		updateMap();
		//mainTextArea.setText("EP2screen7 -> EP2boss1");
		text = "EP2screen7 -> EP2boss1";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen8() {
		position = "EP2screen8";
		updateMap();
		//mainTextArea.setText("EP2screen8 -> EP2screen9");
		text = "EP2screen8 -> EP2screen9";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen9() {
		position = "EP2screen9";
		updateMap();
		//mainTextArea.setText("EP2screen9 -> EP2screen10");
		text = "EP2screen9 -> EP2screen10";
		prepareText();
		choice1.setText("Ileri");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen10() {
		position = "EP2screen10";
		updateMap();
		//mainTextArea.setText("EP2screen10 -> EP2screen11 || EP2boss2 || EP2boss3");
		text = "EP2screen10 -> EP2screen11 || EP2boss2 || EP2boss3";
		prepareText();
		choice1.setText("Yukari Git");
		choice2.setText("Asagi Git");
		choice3.setText("Ileri");
		choice4.setText("Geri");
	}
	public void EP2screen11() {
		position = "EP2screen11";
		updateMap();
		//mainTextArea.setText("EP2screen11 -> EP2screen12");
		text = "EP2screen11 -> EP2screen12";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen12() {
		position = "EP2screen12";
		updateMap();
		//mainTextArea.setText("EP2screen12 -> EP2screen13");
		text = "EP2screen12 -> EP2screen13";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen13() {
		position = "EP2screen13";
		updateMap();
		//mainTextArea.setText("EP2screen13 -> EP2screen14");
		text = "EP2screen13 -> EP2screen14";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen14() {
		position = "EP2screen14";
		updateMap();
		//mainTextArea.setText("EP2screen14 -> EP2screen15 || EP2boss4");
		text = "EP2screen14 -> EP2screen15 || EP2boss4";
		prepareText();
		choice1.setText("Yukari Git");
		choice2.setText("Ilerle");
		choice3.setText("Geri");
		choice4.setText("");
	}
	public void EP2screen15() {
		position = "EP2screen15";
		updateMap();
		//mainTextArea.setText("EP2screen15 -> EP2screen16");
		text = "EP2screen15 -> EP2screen16";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen16() {
		position = "EP2screen16";
		updateMap();
		//mainTextArea.setText("EP2screen16 -> EP2screen17");
		text = "EP2screen16 -> EP2screen17";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen17() {
		position = "EP2screen17";
		updateMap();
		//mainTextArea.setText("EP2screen17 -> EP2screen18");
		text = "EP2screen17 -> EP2screen18";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2screen18() {
		position = "EP2screen18";
		updateMap();
		//mainTextArea.setText("EP2screen18 -> EP2boss5");
		text = "EP2screen18 -> EP2boss5";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2boss1(){
		position = "EP2boss1";
		updateMap();
		se.setFile(ep2b1s);
		se.play();
		monsterName = "EP2boss1";
		monsterHP = 35;

		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP2boss2(){
		position = "EP2boss2";
		updateMap();
		se.setFile(ep2b2s);
		se.play();
		monsterName = "EP2boss2";
		monsterHP = 40;

		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
		
		if(EP2boss1key != true) {
			//mainTextArea.setText("Kilitli. Once boss1'i yenmelisiniz.");
			text = "Kilitli. Once boss1'i yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else
		{
			//mainTextArea.setText("EP2boss2");
			text = "EP2boss2";
			prepareText();
			choice1.setVisible(true);
		}
	}
	public void EP2boss3(){
		position = "EP2boss3";
		updateMap();
		se.setFile(ep2b3s);
		se.play();
		monsterName = "EP2boss3";
		monsterHP = 45;
		
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
		if(EP2boss1key != true && EP2boss2key != true) {
			//mainTextArea.setText("Kilitli. Once boss1 ve boss2'yi yenmelisiniz.");
			text = "Kilitli. Once boss1 ve boss2'yi yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP2boss1key == true && EP2boss2key != true) {
			//mainTextArea.setText("Kilitli. Once boss2'yi yenmelisiniz.");
			text = "Kilitli. Once boss2'yi yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else
		{
			//mainTextArea.setText("EP2boss3");
			text = "EP2boss3";
			prepareText();
			choice1.setVisible(true);
		}
	}
	public void EP2boss4(){
		position = "EP2boss4";
		updateMap();
		se.setFile(ep2b4s);
		se.play();
		monsterName = "EP2boss4";
		monsterHP = 50;
		
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
		if(EP2boss1key != true && EP2boss2key != true && EP2boss3key != true) {
			//mainTextArea.setText("Kilitli. Once boss1, boss2 ve boss3'u yenmelisiniz.");
			text = "Kilitli. Once boss1, boss2 ve boss3'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP2boss1key == true && EP2boss2key != true && EP2boss3key != true) {
			//mainTextArea.setText("Kilitli. Once boss2 ve boss3'u yenmelisiniz.");
			text = "Kilitli. Once boss2 ve boss3'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP2boss1key == true && EP2boss2key == true && EP2boss3key != true) {
			//mainTextArea.setText("Kilitli. Once boss3'u yenmelisiniz.");
			text = "Kilitli. Once boss3'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else
		{
			//mainTextArea.setText("EP2boss4");
			text = "EP2boss4";
			prepareText();
			choice1.setVisible(true);
		}
	}
	public void EP2boss5() {
		position = "EP2boss5";
		updateMap();
		se.setFile(ep2b5s);
		se.play();
		monsterName = "EP2boss5";
		monsterHP = 60;
		
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
		if(EP2boss1key != true && EP2boss2key != true && EP2boss3key != true && EP2boss4key != true) {
			//mainTextArea.setText("Kilitli. Once boss1, boss2,boss3 ve boss4'u yenmelisiniz.");
			text = "Kilitli. Once boss1, boss2,boss3 ve boss4'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP2boss1key == true && EP2boss2key != true && EP2boss3key != true && EP2boss4key != true) {
			//mainTextArea.setText("Kilitli. Once boss2, boss3 ve boss4'u yenmelisiniz.");
			text = "Kilitli. Once boss2, boss3 ve boss4'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP2boss1key == true && EP2boss2key == true && EP2boss3key != true && EP2boss4key != true) {
			//mainTextArea.setText("Kilitli. Once boss3 ve boss4'u yenmelisiniz.");
			text = "Kilitli. Once boss3 ve boss4'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else if(EP2boss1key == true && EP2boss2key == true && EP2boss3key == true && EP2boss4key != true) {
			//mainTextArea.setText("Kilitli. Once boss4'u yenmelisiniz.");
			text = "Kilitli. Once boss4'u yenmelisiniz.";
			prepareText();
			choice1.setVisible(false);
		}
		else
		{
			//mainTextArea.setText("EP2boss5");
			text = "EP2boss5";
			prepareText();
			choice1.setVisible(true);
		}
	}
	public void EP3screen1() {
		position = "EP3screen1";
		episode = "episode3";
		viewMap();
		updateMap();
		screen = new ImageIcon("images/EP3screen1.gif");
		pixel = new ImageIcon("images/level3.gif");
		backgroundLabel.setIcon(screen);
		//mainTextArea.setText("EP3screen1 -> EP3screen2");
		text = "EP3screen1 -> EP3screen2";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen2() {
		position = "EP3screen2";
		updateMap();
		//mainTextArea.setText("EP3screen2 -> EP3screen3");
		text = "EP3screen2 -> EP3screen3";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen3() {
		position = "EP3screen3";
		updateMap();
		//mainTextArea.setText("EP3screen3 -> EP3screen4");
		text = "EP3screen3 -> EP3screen4";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen4() {
		position = "EP3screen4";
		updateMap();
		//mainTextArea.setText("EP3screen4 -> EP3boss1");
		text = "EP3screen4 -> EP3boss1";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen5() {
		position = "EP3screen5";
		updateMap();
		//mainTextArea.setText("EP3screen5 -> EP3screen6");
		text = "EP3screen5 -> EP3screen6";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen6() {
		position = "EP3screen6";
		updateMap();
		//mainTextArea.setText("EP3screen6 -> EP3screen7");
		text = "EP3screen6 -> EP3screen7";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen7() {
		position = "EP3screen7";
		updateMap();
		//mainTextArea.setText("EP3screen7 -> EP3boss2");
		text = "EP3screen7 -> EP3boss2";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen8() {
		position = "EP3screen8";
		updateMap();
		//mainTextArea.setText("EP3screen8 -> EP3screen9");
		text = "EP3screen8 -> EP3screen9";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen9() {
		position = "EP3screen9";
		updateMap();
		//mainTextArea.setText("EP3screen9 -> EP3screen10");
		text = "EP3screen9 -> EP3screen10";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen10() {
		position = "EP3screen10";
		updateMap();
		//mainTextArea.setText("EP3screen10 -> EP3boss3");
		text = "EP3screen10 -> EP3boss3";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen11() {
		position = "EP3screen11";
		updateMap();
		//mainTextArea.setText("EP3screen11 -> EP3screen12");
		text = "EP3screen11 -> EP3screen12";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("Geri");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen12() {
		position = "EP3screen12";
		updateMap();
		//mainTextArea.setText("EP3screen12 -> EP3boss4");
		text = "EP3screen12 -> EP3boss4";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen13() {
		position = "EP3screen13";
		updateMap();
		//mainTextArea.setText("EP3screen13 -> EP3screen14");
		text = "EP3screen13 -> EP3screen14";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen14() {
		position = "EP3screen14";
		updateMap();
		//mainTextArea.setText("EP3screen14 -> EP3boss5");
		text = "EP3screen14 -> EP3boss5";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen15() {
		position = "EP3screen15";
		updateMap();
		//mainTextArea.setText("EP3screen15 -> EP3boss6");
		text = "EP3screen15 -> EP3boss6";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen16() {
		position = "EP3screen16";
		updateMap();
		//mainTextArea.setText("EP3screen16-> EP3boss7");
		text = "EP3screen16-> EP3boss7";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3screen17() {
		position = "EP3screen17";
		updateMap();
		//mainTextArea.setText("EP3screen17 -> EP3boss8");
		text = "EP3screen17 -> EP3boss8";
		prepareText();
		choice1.setText("Ilerle");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3boss1(){
		position = "EP3boss1";
		updateMap();
		se.setFile(ep3b1s);
		se.play();
		monsterName = "EP3boss1";
		monsterHP = 75;
		//mainTextArea.setText("EP3boss1");
		text = "EP3boss1";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3boss2(){
		position = "EP3boss2";
		updateMap();
		se.setFile(ep3b2s);
		se.play();
		monsterName = "EP3boss2";
		monsterHP = 80;
		//mainTextArea.setText("EP3boss2");
		text = "EP3boss2";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3boss3(){
		position = "EP3boss3";
		updateMap();
		se.setFile(ep3b3s);
		se.play();
		monsterName = "EP3boss3";
		monsterHP = 90;
		//mainTextArea.setText("EP3boss3");
		text = "EP3boss3";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3boss4(){
		position = "EP3boss4";
		updateMap();
		se.setFile(ep3b4s);
		se.play();
		monsterName = "EP3boss4";
		monsterHP = 100;
		//mainTextArea.setText("EP3boss4");
		text = "EP3boss4";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3boss5() {
		position = "EP3boss5";
		updateMap();
		se.setFile(ep3b5s);
		se.play();
		monsterName = "EP3boss5";
		monsterHP = 110;
		//mainTextArea.setText("EP3boss5");
		text = "EP3boss5";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3boss6() {
		position = "EP3boss6";
		updateMap();
		se.setFile(ep3b6s);
		se.play();
		monsterName = "EP3boss6";
		monsterHP = 120;
		//mainTextArea.setText("EP3boss6");
		text = "EP3boss6";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3boss7() {
		position = "EP3boss7";
		updateMap();
		se.setFile(ep3b6s);
		se.play();
		monsterName = "EP3boss7";
		monsterHP = 140;
		//mainTextArea.setText("EP3boss7");
		text = "EP3boss7";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void EP3boss8() {
		position = "EP3boss8";
		updateMap();
		se.setFile(ep3b6s);
		se.play();
		monsterName = "EP3boss8";
		monsterHP = 150;
		//mainTextArea.setText("EP3boss8");
		text = "EP3boss8";
		prepareText();
		choice1.setText("Savas");
		choice2.setText("Kac");
		choice3.setText("");
		choice4.setText("");
	}
	public void win() {
		position = "win";
		//mainTextArea.setText(monsterName + " defeated.");
		text = monsterName + " defeated.";
		prepareText();
		addAward();
		choice1.setText("Geri");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void lose(){
		position = "lose";
		
		backgroundPanel.setVisible(false);
		infoPanel.setVisible(false);
		marketMapPanel.setVisible(false);
		mainTextPanel.setVisible(false);
		choiceButtonPanel.setVisible(false);
		playerPanel.setVisible(false);
		healthPanel.setVisible(false);
		levelSelectionPanel.setVisible(false);
		playerSelectionPanel.setVisible(false);
		mainBackgroundPanel.setVisible(false);
		
		losePanel = new JPanel();
		losePanel.setBounds(0, 0, 1280, 720);
		losePanel.setLayout(null);
		losePanel.setBackground(Color.BLACK);
		losePanel.setForeground(Color.WHITE);
		
		loseiconPanel = new JPanel();
		loseiconPanel.setBounds(280, 0, 720, 720);
		loseiconPanel.setBackground(Color.WHITE);
		
		gameOver = new ImageIcon("images/gameover.gif");
		
		loseiconLabel = new JLabel();
		loseiconLabel.setBounds(280, 0, 720, 720);
		loseiconLabel.setBackground(Color.WHITE);
		loseiconLabel.setIcon(gameOver);
		loseiconPanel.add(loseiconLabel);
		
		losetext1Label = new JLabel("<html>G<br>A<br>M<br>E<br></html>", SwingConstants.CENTER);
		losetext1Label.setFont(titleFont);
		losetext1Label.setForeground(Color.WHITE);
		losetext1Label.setBounds(0, 0, 280, 720);
		
		losetext2Label = new JLabel("<html>O<br>V<br>E<br>R<br></html>", SwingConstants.CENTER);
		losetext2Label.setFont(titleFont);
		losetext2Label.setForeground(Color.WHITE);
		losetext2Label.setBounds(1000, 0, 280, 720);
		
		losePanel.add(losetext1Label);
		losePanel.add(loseiconPanel);
		losePanel.add(losetext2Label);
		losePanel.setVisible(false);
		con.add(losePanel);
		
	}
	public void ending(){
		position = "ending";
		mainTextArea.setText("Tebrikler ! Oyunuz Kazandiniz");
		choiceButtonPanel.setVisible(false);
	}
	
	public void addAward() {
		if(monsterName.equals("EP1boss1")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP1boss2")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP1boss3")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP1boss4")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP2boss1")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP2boss2")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP2boss3")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP2boss4")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP2boss5")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP3boss1")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP3boss2")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP3boss3")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP3boss4")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP3boss5")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP3boss6")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP3boss7")) {
			playerCoin += 5;
		}
		else if(monsterName.equals("EP3boss8")) {
			playerCoin += 5;
		}
		coinLabelNumber.setText("" + playerCoin);
	}
	
	public void updateMap() {
		if(episode == "episode1")
		{	
			if(position == "EP1screen1")
			{
				ep1s1i = new ImageIcon("map/EP1screen1.gif");
				ep1s1.setIcon(ep1s1i);
				ep1s2i = new ImageIcon("map/EP1screen2.png");
				ep1s2.setIcon(ep1s2i);
			}
			else if(position == "EP1screen2")
			{
				ep1s1i = new ImageIcon("map/EP1screen1.png");
				ep1s1.setIcon(ep1s1i);
				ep1s2i = new ImageIcon("map/EP1screen2.gif");
				ep1s2.setIcon(ep1s2i);
				ep1s3i = new ImageIcon("map/EP1screen3.png");
				ep1s3.setIcon(ep1s3i);
			}
			else if(position == "EP1screen3")
			{
				ep1s2i = new ImageIcon("map/EP1screen2.png");
				ep1s2.setIcon(ep1s2i);
				ep1s3i = new ImageIcon("map/EP1screen3.gif");
				ep1s3.setIcon(ep1s3i);
				ep1s4i = new ImageIcon("map/EP1screen4.png");
				ep1s4.setIcon(ep1s4i);
				ep1s9i = new ImageIcon("map/EP1screen9.png");
				ep1s9.setIcon(ep1s9i);
			}
			else if(position == "EP1screen4")
			{
				ep1s3i = new ImageIcon("map/EP1screen3.png");
				ep1s3.setIcon(ep1s3i);
				ep1s4i = new ImageIcon("map/EP1screen4.gif");
				ep1s4.setIcon(ep1s4i);
				ep1s5i = new ImageIcon("map/EP1screen5.png");
				ep1s5.setIcon(ep1s5i);
			}
			else if(position == "EP1screen5")
			{
				ep1s4i = new ImageIcon("map/EP1screen4.png");
				ep1s4.setIcon(ep1s4i);
				ep1s5i = new ImageIcon("map/EP1screen5.gif");
				ep1s5.setIcon(ep1s5i);
				ep1s6i = new ImageIcon("map/EP1screen6.png");
				ep1s6.setIcon(ep1s6i);
				ep1s7i = new ImageIcon("map/EP1screen7.png");
				ep1s7.setIcon(ep1s7i);
			}
			else if(position == "EP1screen6")
			{
				ep1s5i = new ImageIcon("map/EP1screen5.png");
				ep1s5.setIcon(ep1s5i);
				ep1s6i = new ImageIcon("map/EP1screen6.gif");
				ep1s6.setIcon(ep1s6i);
				ep1s7i = new ImageIcon("map/EP1screen7.png");
				ep1s7.setIcon(ep1s7i);
				ep1b3i = new ImageIcon("map/EP1screen7.png");
				ep1b3.setIcon(ep1b3i);
			}
			else if(position == "EP1screen7")
			{
				ep1s5i = new ImageIcon("map/EP1screen5.png");
				ep1s5.setIcon(ep1s5i);
				ep1s7i = new ImageIcon("map/EP1screen7.gif");
				ep1s7.setIcon(ep1s7i);
				ep1s8i = new ImageIcon("map/EP1screen8.png");
				ep1s8.setIcon(ep1s8i);
			}
			else if(position == "EP1screen8")
			{
				ep1s7i = new ImageIcon("map/EP1screen7.png");
				ep1s7.setIcon(ep1s7i);
				ep1s8i = new ImageIcon("map/EP1screen8.gif");
				ep1s8.setIcon(ep1s8i);
			}
			else if(position == "EP1screen9")
			{
				ep1s3i = new ImageIcon("map/EP1screen3.png");
				ep1s3.setIcon(ep1s3i);
				ep1s9i = new ImageIcon("map/EP1screen9.gif");
				ep1s9.setIcon(ep1s9i);
				ep1s10i = new ImageIcon("map/EP1screen10.png");
				ep1s10.setIcon(ep1s10i);
			}
			else if(position == "EP1screen10")
			{
				ep1s9i = new ImageIcon("map/EP1screen9.png");
				ep1s9.setIcon(ep1s9i);
				ep1s10i = new ImageIcon("map/EP1screen10.gif");
				ep1s10.setIcon(ep1s10i);
				ep1s11i = new ImageIcon("map/EP1screen11.png");
				ep1s11.setIcon(ep1s11i);
			}
			else if(position == "EP1screen11")
			{
				ep1s10i = new ImageIcon("map/EP1screen10.png");
				ep1s10.setIcon(ep1s10i);
				ep1s11i = new ImageIcon("map/EP1screen11.gif");
				ep1s11.setIcon(ep1s11i);;
				ep1s12i = new ImageIcon("map/EP1screen12.png");
				ep1s12.setIcon(ep1s12i);
			}
			else if(position == "EP1screen12")
			{
				ep1s11i = new ImageIcon("map/EP1screen11.png");
				ep1s11.setIcon(ep1s11i);
				ep1s12i = new ImageIcon("map/EP1screen12.gif");
				ep1s12.setIcon(ep1s12i);
				ep1s13i = new ImageIcon("map/EP1screen13.png");
				ep1s13.setIcon(ep1s13i);
				ep1s14i = new ImageIcon("map/EP1screen14.png");
				ep1s14.setIcon(ep1s14i);
			}
			else if(position == "EP1screen13")
			{
				ep1s12i = new ImageIcon("map/EP1screen12.png");
				ep1s12.setIcon(ep1s12i);
				ep1s13i = new ImageIcon("map/EP1screen13.gif");
				ep1s13.setIcon(ep1s13i);
			}
			else if(position == "EP1screen14")
			{
				ep1s12i = new ImageIcon("map/EP1screen12.png");
				ep1s12.setIcon(ep1s12i);
				ep1s14i = new ImageIcon("map/EP1screen14.gif");
				ep1s14.setIcon(ep1s14i);
				ep1s15i = new ImageIcon("map/EP1screen15.png");
				ep1s15.setIcon(ep1s15i);
			}
			else if(position == "EP1screen15")
			{
				ep1s14i = new ImageIcon("map/EP1screen14.png");
				ep1s14.setIcon(ep1s14i);
				ep1s15i = new ImageIcon("map/EP1screen15.gif");
				ep1s15.setIcon(ep1s15i);
				ep1s16i = new ImageIcon("map/EP1screen16.png");
				ep1s16.setIcon(ep1s16i);
			}
			else if(position == "EP1screen16")
			{
				ep1s15i = new ImageIcon("map/EP1screen15.png");
				ep1s15.setIcon(ep1s15i);
				ep1s16i = new ImageIcon("map/EP1screen16.gif");
				ep1s16.setIcon(ep1s16i);
				ep1s17i = new ImageIcon("map/EP1screen17.png");
				ep1s17.setIcon(ep1s17i);
			}
			else if(position == "EP1screen17")
			{
				ep1s16i = new ImageIcon("map/EP1screen16.png");
				ep1s16.setIcon(ep1s16i);
				ep1s17i = new ImageIcon("map/EP1screen17.gif");
				ep1s17.setIcon(ep1s17i);
				ep1b1.setText("ep1b1");
				ep1b1i = new ImageIcon("map/EP1screen17.png");
				ep1b1.setIcon(ep1b1i);
				ep1s18i = new ImageIcon("map/EP1screen18.png");
				ep1s18.setIcon(ep1s18i);
			}
			else if(position == "EP1screen18")
			{
				ep1s17.setText("ep1s17");
				ep1s17i = new ImageIcon("map/EP1screen17.png");
				ep1s17.setIcon(ep1s17i);
				ep1s18i = new ImageIcon("map/EP1screen18.gif");
				ep1s18.setIcon(ep1s18i);
				ep1s19i = new ImageIcon("map/EP1screen19.png");
				ep1s19.setIcon(ep1s19i);
			}
			else if(position == "EP1screen19")
			{
				ep1s18i = new ImageIcon("map/EP1screen18.png");
				ep1s18.setIcon(ep1s18i);
				ep1s19i = new ImageIcon("map/EP1screen19.gif");
				ep1s19.setIcon(ep1s19i);
				ep1s20i = new ImageIcon("map/EP1screen20.png");
				ep1s20.setIcon(ep1s20i);
			}
			else if(position == "EP1screen20")
			{
				ep1s19i = new ImageIcon("map/EP1screen19.png");
				ep1s19.setIcon(ep1s19i);
				ep1s20i = new ImageIcon("map/EP1screen20.gif");
				ep1s20.setIcon(ep1s20i);
				ep1s21i = new ImageIcon("map/EP1screen21.png");
				ep1s21.setIcon(ep1s21i);
			}
			else if(position == "EP1screen21")
			{
				ep1s20i = new ImageIcon("map/EP1screen20.png");
				ep1s20.setIcon(ep1s20i);
				ep1s21i = new ImageIcon("map/EP1screen21.gif");
				ep1s21.setIcon(ep1s21i);
				ep1s22i = new ImageIcon("map/EP1screen22.png");
				ep1s22.setIcon(ep1s22i);
			}
			else if(position == "EP1screen22")
			{
				ep1s21i = new ImageIcon("map/EP1screen21.png");
				ep1s21.setIcon(ep1s21i);
				ep1s22i = new ImageIcon("map/EP1screen22.gif");
				ep1s22.setIcon(ep1s22i);
				ep1s23i = new ImageIcon("map/EP1screen23.png");
				ep1s23.setIcon(ep1s23i);
				ep1s24i = new ImageIcon("map/EP1screen24.png");
				ep1s24.setIcon(ep1s24i);
			}
			else if(position == "EP1screen23")
			{
				ep1s22i = new ImageIcon("map/EP1screen22.png");
				ep1s22.setIcon(ep1s22i);
				ep1s23i = new ImageIcon("map/EP1screen23.gif");
				ep1s23.setIcon(ep1s23i);
				ep1b4i = new ImageIcon("map/EP1screen22.png");
				ep1b4.setIcon(ep1b4i);
			}
			else if(position == "EP1screen24")
			{
				ep1s22i = new ImageIcon("map/EP1screen22.png");
				ep1s22.setIcon(ep1s22i);
				ep1s24i = new ImageIcon("map/EP1screen24.gif");
				ep1s24.setIcon(ep1s24i);
				ep1s25i = new ImageIcon("map/EP1screen25.png");
				ep1s25.setIcon(ep1s25i);
			}
			else if(position == "EP1screen25")
			{
				ep1s24i = new ImageIcon("map/EP1screen24.png");
				ep1s24.setIcon(ep1s24i);
				ep1s25i = new ImageIcon("map/EP1screen25.gif");
				ep1s25.setIcon(ep1s25i);
				ep1b3i = new ImageIcon("map/EP1screen25.png");
				ep1b3.setIcon(ep1b3i);
			}
			else if(position == "EP1boss1")
			{
				ep1s17i = new ImageIcon("map/EP1screen17.png");
				ep1s17.setIcon(ep1s17i);
				ep1b1i = new ImageIcon("map/EP1boss1.gif");
				ep1b1.setIcon(ep1b1i);
			}
			else if(position == "EP1boss2")
			{
				ep1s25i = new ImageIcon("map/EP1screen25.png");
				ep1s25.setIcon(ep1s25i);
				ep1b2i = new ImageIcon("map/EP1boss2.gif");
				ep1b2.setIcon(ep1b2i);
			}
			else if(position == "EP1boss3")
			{
				ep1s6i = new ImageIcon("map/EP1screen6.png");
				ep1s6.setIcon(ep1s6i);
				ep1b3i = new ImageIcon("map/EP1boss3.gif");
				ep1b3.setIcon(ep1b3i);
			}
			else if(position == "EP1boss4")
			{
				ep1s23i = new ImageIcon("map/EP1screen23.png");
				ep1s23.setIcon(ep1s23i);
				ep1b4i = new ImageIcon("map/EP1boss4.gif");
				ep1b4.setIcon(ep1b4i);
			}
			
		}
		else if(episode == "episode2")
		{
			ep1s1.setVisible(false);
			ep1s2.setVisible(false);
			ep1s3.setVisible(false);
			ep1s4.setVisible(false);
			ep1s5.setVisible(false);
			ep1s6.setVisible(false);
			ep1s7.setVisible(false);
			ep1s8.setVisible(false);
			ep1s9.setVisible(false);
			ep1s10.setVisible(false);
			ep1s11.setVisible(false);
			ep1s12.setVisible(false);
			ep1s13.setVisible(false);
			ep1s14.setVisible(false);
			ep1s15.setVisible(false);
			ep1s16.setVisible(false);
			ep1s17.setVisible(false);
			ep1s18.setVisible(false);
			ep1s19.setVisible(false);
			ep1s20.setVisible(false);
			ep1s21.setVisible(false);
			ep1s22.setVisible(false);
			ep1s23.setVisible(false);
			ep1s24.setVisible(false);
			ep1s25.setVisible(false);
			ep1b1.setVisible(false);
			ep1b2.setVisible(false);
			ep1b3.setVisible(false);
			ep1b4.setVisible(false);
			
			if(position == "EP2screen1")
			{
				ep2s1i = new ImageIcon("map/EP2screen1.gif");
				ep2s1.setIcon(ep2s1i);
				ep2s2i = new ImageIcon("map/EP2screen2.png");
				ep2s2.setIcon(ep2s2i);
			}
			else if(position == "EP2screen2")
			{
				ep2s1i = new ImageIcon("map/EP2screen1.png");
				ep2s1.setIcon(ep2s1i);
				ep2s2i = new ImageIcon("map/EP2screen2.gif");
				ep2s2.setIcon(ep2s2i);
				ep2s3i = new ImageIcon("map/EP2screen3.png");
				ep2s3.setIcon(ep2s3i);
			}
			else if(position == "EP2screen3")
			{
				ep2s2i = new ImageIcon("map/EP2screen2.png");
				ep2s2.setIcon(ep2s2i);
				ep2s3i = new ImageIcon("map/EP2screen3.gif");
				ep2s3.setIcon(ep2s3i);
				ep2s4i = new ImageIcon("map/EP2screen4.png");
				ep2s4.setIcon(ep2s4i);
			}
			else if(position == "EP2screen4")
			{
				ep2s3i = new ImageIcon("map/EP2screen3.png");
				ep2s3.setIcon(ep2s3i);
				ep2s4i = new ImageIcon("map/EP2screen4.gif");
				ep2s4.setIcon(ep2s4i);
				ep2s5i = new ImageIcon("map/EP2screen5.png");
				ep2s5.setIcon(ep2s5i);
			}
			else if(position == "EP2screen5")
			{
				ep2s4i = new ImageIcon("map/EP2screen4.png");
				ep2s4.setIcon(ep2s4i);
				ep2s5i = new ImageIcon("map/EP2screen5.gif");
				ep2s5.setIcon(ep2s5i);
				ep2s6i = new ImageIcon("map/EP2screen6.png");
				ep2s6.setIcon(ep2s6i);
			}
			else if(position == "EP2screen6")
			{
				ep2s5i = new ImageIcon("map/EP2screen5.png");
				ep2s5.setIcon(ep2s5i);
				ep2s6i = new ImageIcon("map/EP2screen6.gif");
				ep2s6.setIcon(ep2s6i);
				ep2s7i = new ImageIcon("map/EP2screen7.png");
				ep2s7.setIcon(ep2s7i);
				ep2s8i = new ImageIcon("map/EP2screen8.png");
				ep2s8.setIcon(ep2s8i);
			}
			else if(position == "EP2screen7")
			{
				ep2s6i = new ImageIcon("map/EP2screen6.png");
				ep2s6.setIcon(ep2s6i);
				ep2s7i = new ImageIcon("map/EP2screen7.gif");
				ep2s7.setIcon(ep2s7i);
				ep2b1.setText("ep2b1");
				ep2b1i = new ImageIcon("map/EP2screen7.png");
				ep2b1.setIcon(ep2b1i);
			}
			else if(position == "EP2screen8")
			{
				ep2s6i = new ImageIcon("map/EP2screen6.png");
				ep2s6.setIcon(ep2s6i);
				ep2s8i = new ImageIcon("map/EP2screen8.gif");
				ep2s8.setIcon(ep2s8i);
				ep2s9i = new ImageIcon("map/EP2screen9.png");
				ep2s9.setIcon(ep2s9i);
			}
			else if(position == "EP2screen9")
			{
				ep2s8i = new ImageIcon("map/EP2screen8.png");
				ep2s8.setIcon(ep2s8i);
				ep2s9i = new ImageIcon("map/EP2screen9.gif");
				ep2s9.setIcon(ep2s9i);
				ep2s10i = new ImageIcon("map/EP2screen10.png");
				ep2s10.setIcon(ep2s10i);
			}
			else if(position == "EP2screen10")
			{
				ep2s9i = new ImageIcon("map/EP2screen9.png");
				ep2s9.setIcon(ep2s9i);
				ep2s10i = new ImageIcon("map/EP2screen10.gif");
				ep2s10.setIcon(ep2s10i);
				ep2b2i = new ImageIcon("map/EP2screen10.png");
				ep2b2.setIcon(ep2b2i);
				ep2b3i = new ImageIcon("map/EP2screen10.png");
				ep2b3.setIcon(ep2b3i);
			}
			else if(position == "EP2screen11")
			{
				ep2s10i = new ImageIcon("map/EP2screen10.png");
				ep2s10.setIcon(ep2s10i);
				ep2s11i = new ImageIcon("map/EP2screen11.gif");
				ep2s11.setIcon(ep2s11i);
				ep2s12i = new ImageIcon("map/EP2screen12.png");
				ep2s12.setIcon(ep2s12i);
			}
			else if(position == "EP2screen12")
			{
				ep2s11i = new ImageIcon("map/EP2screen11.png");
				ep2s11.setIcon(ep2s11i);
				ep2s12i = new ImageIcon("map/EP2screen12.gif");
				ep2s12.setIcon(ep2s12i);
				ep2s13i = new ImageIcon("map/EP2screen13.png");
				ep2s13.setIcon(ep2s13i);
			}
			else if(position == "EP2screen13")
			{
				ep2s12i = new ImageIcon("map/EP2screen12.png");
				ep2s12.setIcon(ep2s12i);
				ep2s13i = new ImageIcon("map/EP2screen13.gif");
				ep2s13.setIcon(ep2s13i);
				ep2s14i = new ImageIcon("map/EP2screen14.png");
				ep2s14.setIcon(ep2s14i);
			}
			else if(position == "EP2screen14")
			{
				ep2b4i = new ImageIcon("map/EP2screen14.png");
				ep2b4.setIcon(ep2b4i);
				ep2s13i = new ImageIcon("map/EP2screen13.png");
				ep2s13.setIcon(ep2s13i);
				ep2s14i = new ImageIcon("map/EP2screen14.gif");
				ep2s14.setIcon(ep2s14i);
				ep2s15i = new ImageIcon("map/EP2screen15.png");
				ep2s15.setIcon(ep2s15i);
			}
			else if(position == "EP2screen15")
			{
				ep2s14i = new ImageIcon("map/EP2screen14.png");
				ep2s14.setIcon(ep2s14i);
				ep2s15i = new ImageIcon("map/EP2screen15.gif");
				ep2s15.setIcon(ep2s15i);
				ep2s16i = new ImageIcon("map/EP2screen16.png");
				ep2s16.setIcon(ep2s16i);
			}
			else if(position == "EP2screen16")
			{
				ep2s15i = new ImageIcon("map/EP2screen15.png");
				ep2s15.setIcon(ep2s15i);
				ep2s16i = new ImageIcon("map/EP2screen16.gif");
				ep2s16.setIcon(ep2s16i);
				ep2s17i = new ImageIcon("map/EP2screen17.png");
				ep2s17.setIcon(ep2s17i);
			}
			else if(position == "EP2screen17")
			{
				ep2s16i = new ImageIcon("map/EP2screen16.png");
				ep2s16.setIcon(ep2s16i);
				ep2s17i = new ImageIcon("map/EP2screen17.gif");
				ep2s17.setIcon(ep2s17i);
				ep2s18i = new ImageIcon("map/EP2screen18.png");
				ep2s18.setIcon(ep2s18i);
			}
			else if(position == "EP2screen18")
			{
				ep2s17i = new ImageIcon("map/EP2screen17.png");
				ep2s17.setIcon(ep2s17i);
				ep2s18i = new ImageIcon("map/EP2screen18.gif");
				ep2s18.setIcon(ep2s18i);
				ep2b5i = new ImageIcon("map/EP2screen18.png");
				ep2b5.setIcon(ep2b5i);
			}
			else if(position == "EP2boss1")
			{
				ep2b1i = new ImageIcon("map/EP2boss1.gif");
				ep2b1.setIcon(ep2b1i);
				ep2s7i = new ImageIcon("map/EP2screen7.png");
				ep2s7.setIcon(ep2s7i);
			}
			else if(position == "EP2boss2")
			{
				ep2s10i = new ImageIcon("map/EP2screen10.png");
				ep2s10.setIcon(ep2s10i);
				ep2b2i = new ImageIcon("map/EP2boss2.gif");
				ep2b2.setIcon(ep2b2i);
			}
			else if(position == "EP2boss3")
			{
				ep2s10i = new ImageIcon("map/EP2screen10.png");
				ep2s10.setIcon(ep2s10i);
				ep2b3i = new ImageIcon("map/EP2boss3.gif");
				ep2b3.setIcon(ep2b3i);
			}
			else if(position == "EP2boss4")
			{
				ep2s14i = new ImageIcon("map/EP2screen14.png");
				ep2s14.setIcon(ep2s14i);
				ep2b4i = new ImageIcon("map/EP2boss4.gif");
				ep2b4.setIcon(ep2b4i);
			}
			else if(position == "EP2boss5")
			{
				ep2s18i = new ImageIcon("map/EP2screen18.png");
				ep2s18.setIcon(ep2s18i);
				ep2b5i = new ImageIcon("map/EP2boss5.gif");
				ep2b5.setIcon(ep2b5i);
			}
			
		}
		else if(episode == "episode3")
		{
			ep2s1.setVisible(false);
			ep2s2.setVisible(false);
			ep2s3.setVisible(false);
			ep2s4.setVisible(false);
			ep2s5.setVisible(false);
			ep2s6.setVisible(false);
			ep2s7.setVisible(false);
			ep2s8.setVisible(false);
			ep2s9.setVisible(false);
			ep2s10.setVisible(false);
			ep2s11.setVisible(false);
			ep2s12.setVisible(false);
			ep2s13.setVisible(false);
			ep2s14.setVisible(false);
			ep2s15.setVisible(false);
			ep2s16.setVisible(false);
			ep2s17.setVisible(false);
			ep2s18.setVisible(false);
			ep2b1.setVisible(false);
			ep2b2.setVisible(false);
			ep2b3.setVisible(false);
			ep2b4.setVisible(false);
			ep2b5.setVisible(false);
			
			if(position == "EP3screen1")
			{
				ep3s1i = new ImageIcon("map/EP3screen1.gif");
				ep3s1.setIcon(ep3s1i);
				ep3s2i = new ImageIcon("map/EP3screen2.png");
				ep3s2.setIcon(ep3s2i);
			}
			else if(position == "EP3screen2")
			{
				ep3s1i = new ImageIcon("map/EP3screen1.png");
				ep3s1.setIcon(ep3s1i);
				ep3s2i = new ImageIcon("map/EP3screen2.gif");
				ep3s2.setIcon(ep3s2i);
				ep3s3i = new ImageIcon("map/EP3screen3.png");
				ep3s3.setIcon(ep3s3i);
			}
			else if(position == "EP3screen3")
			{
				ep3s2i = new ImageIcon("map/EP3screen2.png");
				ep3s2.setIcon(ep3s2i);
				ep3s3i = new ImageIcon("map/EP3screen3.gif");
				ep3s3.setIcon(ep3s3i);
				ep3s4i = new ImageIcon("map/EP3screen4.png");
				ep3s4.setIcon(ep3s4i);
			}
			else if(position == "EP3screen4")
			{
				ep3s3i = new ImageIcon("map/EP3screen3.png");
				ep3s3.setIcon(ep3s3i);
				ep3s4i = new ImageIcon("map/EP3screen4.gif");
				ep3s4.setIcon(ep3s4i);
				ep3b1i = new ImageIcon("map/EP3screen4.png");
				ep3b1.setIcon(ep3b1i);
			}
			else if(position == "EP3screen5")
			{
				ep3b1i = new ImageIcon("map/EP3screen4.png");
				ep3b1.setIcon(ep3b1i);
				ep3s5i = new ImageIcon("map/EP3screen5.gif");
				ep3s5.setIcon(ep3s5i);
				ep3s6i = new ImageIcon("map/EP3screen6.png");
				ep3s6.setIcon(ep3s6i);
			}
			else if(position == "EP3screen6")
			{
				ep3s5i = new ImageIcon("map/EP3screen5.png");
				ep3s5.setIcon(ep3s5i);
				ep3s6i = new ImageIcon("map/EP3screen6.gif");
				ep3s6.setIcon(ep3s6i);
				ep3s7i = new ImageIcon("map/EP3screen7.png");
				ep3s7.setIcon(ep3s7i);
			}
			else if(position == "EP3screen7")
			{
				ep3s6i = new ImageIcon("map/EP3screen6.png");
				ep3s6.setIcon(ep3s6i);
				ep3s7i = new ImageIcon("map/EP3screen7.gif");
				ep3s7.setIcon(ep3s7i);
				ep3b2i = new ImageIcon("map/EP3screen7.png");
				ep3b2.setIcon(ep3b2i);
			}
			else if(position == "EP3screen8")
			{
				ep3b2.setText("ep3b2");
				ep3b2i = new ImageIcon("map/EP3screen7.png");
				ep3b2.setIcon(ep3b2i);
				ep3s8i = new ImageIcon("map/EP3screen8.gif");
				ep3s8.setIcon(ep3s8i);
				ep3s9i = new ImageIcon("map/EP3screen9.png");
				ep3s9.setIcon(ep3s9i);
			}
			else if(position == "EP3screen9")
			{
				ep3s8i = new ImageIcon("map/EP3screen8.png");
				ep3s8.setIcon(ep3s8i);
				ep3s9i = new ImageIcon("map/EP3screen9.gif");
				ep3s9.setIcon(ep3s9i);
				ep3s10i = new ImageIcon("map/EP3screen10.png");
				ep3s10.setIcon(ep3s10i);
			}
			else if(position == "EP3screen10")
			{
				ep3s9i = new ImageIcon("map/EP3screen9.png");
				ep3s9.setIcon(ep3s9i);
				ep3s10i = new ImageIcon("map/EP3screen10.gif");
				ep3s10.setIcon(ep3s10i);
				ep3b3i = new ImageIcon("map/EP3screen10.png");
				ep3b3.setIcon(ep3b3i);
			}
			else if(position == "EP3screen11")
			{
				ep3b3i = new ImageIcon("map/EP3screen10.png");
				ep3b3.setIcon(ep3b3i);
				ep3s11i = new ImageIcon("map/EP3screen11.gif");
				ep3s11.setIcon(ep3s11i);
				ep3s12i = new ImageIcon("map/EP3screen12.png");
				ep3s12.setIcon(ep3s12i);
			}
			else if(position == "EP3screen12")
			{
				ep3s11i = new ImageIcon("map/EP3screen11.png");
				ep3s11.setIcon(ep3s11i);
				ep3s12i = new ImageIcon("map/EP3screen12.gif");
				ep3s12.setIcon(ep3s12i);
				ep3b4i = new ImageIcon("map/EP3screen12.png");
				ep3b4.setIcon(ep3b4i);
			}
			else if(position == "EP3screen13")
			{
				ep3s12i = new ImageIcon("map/EP3screen12.png");
				ep3s12.setIcon(ep3s12i);
				ep3s13i = new ImageIcon("map/EP3screen13.gif");
				ep3s13.setIcon(ep3s13i);
				ep3b4i = new ImageIcon("map/EP3screen13.png");
				ep3b4.setIcon(ep3b4i);
			}
			else if(position == "EP3screen14")
			{
				ep3s13i = new ImageIcon("map/EP3screen13.png");
				ep3s13.setIcon(ep3s13i);
				ep3s14i = new ImageIcon("map/EP3screen14.gif");
				ep3s14.setIcon(ep3s14i);
				ep3b5i = new ImageIcon("map/EP3screen14.png");
				ep3b5.setIcon(ep3b5i);
			}
			else if(position == "EP3screen15")
			{
				ep3b5i = new ImageIcon("map/EP3screen14.png");
				ep3b5.setIcon(ep3b5i);
				ep3s15i = new ImageIcon("map/EP3screen15.gif");
				ep3s15.setIcon(ep3s15i);
				ep3b6i = new ImageIcon("map/EP3screen15.png");
				ep3b6.setIcon(ep3b6i);
			}
			else if(position == "EP3screen16")
			{
				ep3b6i = new ImageIcon("map/EP3screen15.png");
				ep3b6.setIcon(ep3b6i);
				ep3s16i = new ImageIcon("map/EP3screen16.gif");
				ep3s16.setIcon(ep3s16i);
				ep3b7i = new ImageIcon("map/EP3screen16.png");
				ep3b7.setIcon(ep3b7i);
			}
			else if(position == "EP3screen17")
			{
				ep3b7i = new ImageIcon("map/EP3screen16.png");
				ep3b7.setIcon(ep3b7i);
				ep3s17i = new ImageIcon("map/EP3screen17.gif");
				ep3s17.setIcon(ep3s17i);
				ep3b8i = new ImageIcon("map/EP3screen17.png");
				ep3b8.setIcon(ep3b8i);
			}
			else if(position == "EP3boss1")
			{
				ep3s4i = new ImageIcon("map/EP3screen4.png");
				ep3s4.setIcon(ep3s4i);
				ep3b1i = new ImageIcon("map/EP3boss1.gif");
				ep3b1.setIcon(ep3b1i);
			}
			else if(position == "EP3boss2")
			{
				ep3s7i = new ImageIcon("map/EP3screen7.png");
				ep3s7.setIcon(ep3s7i);
				ep3b2i = new ImageIcon("map/EP3boss2.gif");
				ep3b2.setIcon(ep3b2i);
			}
			else if(position == "EP3boss3")
			{
				ep3s10i = new ImageIcon("map/EP3screen10.png");
				ep3s10.setIcon(ep3s10i);
				ep3b3i = new ImageIcon("map/EP3boss3.gif");
				ep3b3.setIcon(ep3b3i);
			}
			else if(position == "EP3boss4")
			{
				ep3s12i = new ImageIcon("map/EP3screen12.png");
				ep3s12.setIcon(ep3s12i);
				ep3b4i = new ImageIcon("map/EP3boss4.gif");
				ep3b4.setIcon(ep3b4i);
			}
			else if(position == "EP3boss5")
			{
				ep3s14i = new ImageIcon("map/EP3screen14.png");
				ep3s14.setIcon(ep3s14i);
				ep3b5i = new ImageIcon("map/EP3boss5.gif");
				ep3b5.setIcon(ep3b5i);
			}
			else if(position == "EP3boss6")
			{
				ep3s15i = new ImageIcon("map/EP3screen15.png");
				ep3s15.setIcon(ep3s15i);
				ep3b6i = new ImageIcon("map/EP3boss6.gif");
				ep3b6.setIcon(ep3b6i);
			}
			else if(position == "EP3boss7")
			{
				ep3s16i = new ImageIcon("map/EP3screen16.png");
				ep3s16.setIcon(ep3s16i);
				ep3b7i = new ImageIcon("map/EP3boss7.gif");
				ep3b7.setIcon(ep3b7i);
			}
			else if(position == "EP3boss8")
			{
				ep3s17i = new ImageIcon("map/EP3screen17.png");
				ep3s17.setIcon(ep3s17i);
				ep3b8i = new ImageIcon("map/EP3boss8.gif");
				ep3b8.setIcon(ep3b8i);
			}
			
		}
	}
	
	public void itemUsed(int slotNumber) {
		switch(playerItem[slotNumber])
		{
		case "Potion":
			playerHP = playerHP + 10;
			if(playerHP >= 100) {
				playerHP = 100;
			}
			hpLabelNumber.setText("" + playerHP);
			healthBar.setValue(playerHP);
			playerItem[slotNumber] = "";
			
			break;
		case "Orange":
			playerHP = playerHP + 5;
			if(playerHP >= 100) {
				playerHP = 100;
			}
			hpLabelNumber.setText("" + playerHP);
			healthBar.setValue(playerHP);
			playerItem[slotNumber] = "";
			break;
		case "Big Potion":
			playerHP = playerHP + 25;
			if(playerHP >= 100) {
				playerHP = 100;
			}
			hpLabelNumber.setText("" + playerHP);
			healthBar.setValue(playerHP);
			playerItem[slotNumber] = "";
			break;
		case "":
			break;
		}
	}
	
	public void itemAdded(String itemName) {
		boolean added = false;
		if(added != true)
		{
			for(int i=0; i<5; i++) {
				if(playerItem[i] == "") {
					playerItem[i] = itemName;
					added = true;
					break;
				}
			}
		}
	}

	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){		
			window.requestFocus();
			PlayerSelection();
		}
	}
	

	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "EP1screen1":
				switch(yourChoice) {
				case "c1":
					EP1screen2();
					screen = new ImageIcon("images/EP1screen2.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen2":
				switch(yourChoice) {
				case "c1":
					EP1screen3();
					screen = new ImageIcon("images/EP1screen3.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen1();
					screen = new ImageIcon("images/EP1screen1back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen3":
				switch(yourChoice) {
				case "c1":
					EP1screen9();
					screen = new ImageIcon("images/EP1screen9.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen4();
					screen = new ImageIcon("images/EP1screen4.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c3":
					EP1screen2();
					screen = new ImageIcon("images/EP1screen2back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen4":
				switch(yourChoice) {
				case "c1":
					EP1screen5();
					screen = new ImageIcon("images/EP1screen5.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen3();
					screen = new ImageIcon("images/EP1screen3back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen5":
				switch(yourChoice) {
				case "c1":
					EP1screen6();
					screen = new ImageIcon("images/EP1screen6.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen7();
					screen = new ImageIcon("images/EP1screen7.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c3":
					EP1screen4();
					screen = new ImageIcon("images/EP1screen4back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen6":
				switch(yourChoice) {
				case "c1":
					EP1boss3();
					screen = new ImageIcon("images/EP1boss3.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen5();
					screen = new ImageIcon("images/EP1screen5back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen7":
				switch(yourChoice) {
				case "c1":
					EP1screen8();
					screen = new ImageIcon("images/EP1screen8.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen5();
					screen = new ImageIcon("images/EP1screen5back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen8":
				switch(yourChoice) {
				case "c1":
					EP1screen7();
					screen = new ImageIcon("images/EP1screen7back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen9":
				switch(yourChoice) {
				case "c1":
					EP1screen10();
					screen = new ImageIcon("images/EP1screen10.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen3();
					screen = new ImageIcon("images/EP1screen3back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen10":
				switch(yourChoice) {
				case "c1":
					EP1screen11();
					screen = new ImageIcon("images/EP1screen11.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen9();
					screen = new ImageIcon("images/EP1screen9back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen11":
				switch(yourChoice) {
				case "c1":
					EP1screen12();
					screen = new ImageIcon("images/EP1screen12.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen10();
					screen = new ImageIcon("images/EP1screen10back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen12":
				switch(yourChoice) {
				case "c1":
					EP1screen14();
					screen = new ImageIcon("images/EP1screen14.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen13();
					screen = new ImageIcon("images/EP1screen13.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c3":
					EP1screen11();
					screen = new ImageIcon("images/EP1screen11back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen13":
				switch(yourChoice) {
				case "c1":
					EP1screen12();
					screen = new ImageIcon("images/EP1screen12back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen14":
				switch(yourChoice) {
				case "c1":
					EP1screen15();
					screen = new ImageIcon("images/EP1screen15.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen12();
					screen = new ImageIcon("images/EP1screen12back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen15":
				switch(yourChoice) {
				case "c1":
					EP1screen16();
					screen = new ImageIcon("images/EP1screen16.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen14();
					screen = new ImageIcon("images/EP1screen14back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen16":
				switch(yourChoice) {
				case "c1":
					EP1screen17();
					screen = new ImageIcon("images/EP1screen17.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen15();
					screen = new ImageIcon("images/EP1screen15back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen17":
				switch(yourChoice) {
				case "c1":
					EP1boss1();
					screen = new ImageIcon("images/EP1boss1.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen18();
					screen = new ImageIcon("images/EP1screen18.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c3":
					EP1screen16();
					screen = new ImageIcon("images/EP1screen16back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen18":
				switch(yourChoice) {
				case "c1":
					EP1screen19();
					screen = new ImageIcon("images/EP1screen19.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen17();
					screen = new ImageIcon("images/EP1screen17back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen19":
				switch(yourChoice) {
				case "c1":
					EP1screen20();
					screen = new ImageIcon("images/EP1screen20.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen18();
					screen = new ImageIcon("images/EP1screen18back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen20":
				switch(yourChoice) {
				case "c1":
					EP1screen21();
					screen = new ImageIcon("images/EP1screen21.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen19();
					screen = new ImageIcon("images/EP1screen19back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen21":
				switch(yourChoice) {
				case "c1":
					EP1screen22();
					screen = new ImageIcon("images/EP1screen22.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen20();
					screen = new ImageIcon("images/EP1screen20back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen22":
				switch(yourChoice) {
				case "c1":
					EP1screen23();
					screen = new ImageIcon("images/EP1screen23.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen24();
					screen = new ImageIcon("images/EP1screen24.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c3":
					EP1screen21();
					screen = new ImageIcon("images/EP1screen21back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen23":
				switch(yourChoice) {
				case "c1":
					EP1boss4();
					screen = new ImageIcon("images/EP1boss4.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen22();
					screen = new ImageIcon("images/EP1screen22back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen24":
				switch(yourChoice) {
				case "c1":
					EP1screen25();
					screen = new ImageIcon("images/EP1screen25.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen23();
					screen = new ImageIcon("images/EP1screen23back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1screen25":
				switch(yourChoice) {
				case "c1":
					EP1boss2();
					screen = new ImageIcon("images/EP1boss2.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP1screen24();
					screen = new ImageIcon("images/EP1screen24back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP1boss1":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP1screen17();
					screen = new ImageIcon("images/EP1screen17back.gif");
					backgroundLabel.setIcon(screen);
				}
				break;
				
			case "EP1boss2":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP1screen25();
					screen = new ImageIcon("images/EP1screen25back.gif");
					backgroundLabel.setIcon(screen);
					choice1.setVisible(true);
				}
				break;
				
			case "EP1boss3":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP1screen6();
					screen = new ImageIcon("images/EP1screen6back.gif");
					backgroundLabel.setIcon(screen);
					choice1.setVisible(true);
				}
				break;

			case "EP1boss4":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP1screen23();
					screen = new ImageIcon("images/EP1screen23back.gif");
					backgroundLabel.setIcon(screen);
					choice1.setVisible(true);
				}
				break;
				
			case "EP2screen1":
				switch(yourChoice) {
				case "c1":
					EP2screen2();
					screen = new ImageIcon("images/EP2screen2.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen2":
				switch(yourChoice) {
				case "c1":
					EP2screen3();
					screen = new ImageIcon("images/EP2screen3.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen1();
					screen = new ImageIcon("images/EP2screen1back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;

			case "EP2screen3":
				switch(yourChoice) {
				case "c1":
					EP2screen4();
					screen = new ImageIcon("images/EP2screen4.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen2();
					screen = new ImageIcon("images/EP2screen2back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen4":
				switch(yourChoice) {
				case "c1":
					EP2screen5();
					screen = new ImageIcon("images/EP2screen5.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen3();
					screen = new ImageIcon("images/EP2screen3back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen5":
				switch(yourChoice) {
				case "c1":
					EP2screen6();
					screen = new ImageIcon("images/EP2screen6.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen4();
					screen = new ImageIcon("images/EP2screen4back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen6":
				switch(yourChoice) {
				case "c1":
					EP2screen7();
					screen = new ImageIcon("images/EP2screen7.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen8();
					screen = new ImageIcon("images/EP2screen8.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c3":
					EP2screen5();
					screen = new ImageIcon("images/EP2screen5back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen7":
				switch(yourChoice) {
				case "c1":
					EP2boss1();
					screen = new ImageIcon("images/EP2boss1.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen6();
					screen = new ImageIcon("images/EP2screen6back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen8":
				switch(yourChoice) {
				case "c1":
					EP2screen9();
					screen = new ImageIcon("images/EP2screen9.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen6();
					screen = new ImageIcon("images/EP2screen6back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen9":
				switch(yourChoice) {
				case "c1":
					EP2screen10();
					screen = new ImageIcon("images/EP2screen10.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen8();
					screen = new ImageIcon("images/EP2screen8back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen10":
				switch(yourChoice) {
				case "c1":
					EP2boss2();
					screen = new ImageIcon("images/EP2boss2.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2boss3();
					screen = new ImageIcon("images/EP2boss3.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c3":
					EP2screen11();
					screen = new ImageIcon("images/EP2screen11.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c4":
					EP2screen9();
					screen = new ImageIcon("images/EP2screen9back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
					
			case "EP2screen11":
				switch(yourChoice) {
				case "c1":
					EP2screen12();
					screen = new ImageIcon("images/EP2screen12.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen10();
					screen = new ImageIcon("images/EP2screen10back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen12":
				switch(yourChoice) {
				case "c1":
					EP2screen13();
					screen = new ImageIcon("images/EP2screen13.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen11();
					screen = new ImageIcon("images/EP2screen11back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen13":
				switch(yourChoice) {
				case "c1":
					EP2screen14();
					screen = new ImageIcon("images/EP2screen14.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen12();
					screen = new ImageIcon("images/EP2screen12back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen14":
				switch(yourChoice) {
				case "c1":
					EP2boss4();
					screen = new ImageIcon("images/EP2boss4.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen15();
					screen = new ImageIcon("images/EP2screen15.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c3":
					EP2screen13();
					screen = new ImageIcon("images/EP2screen13back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen15":
				switch(yourChoice) {
				case "c1":
					EP2screen16();
					screen = new ImageIcon("images/EP2screen16.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen14();
					screen = new ImageIcon("images/EP2screen14back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen16":
				switch(yourChoice) {
				case "c1":
					EP2screen17();
					screen = new ImageIcon("images/EP2screen17.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen15();
					screen = new ImageIcon("images/EP2screen15back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen17":
				switch(yourChoice) {
				case "c1":
					EP2screen18();
					screen = new ImageIcon("images/EP2screen18.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen16();
					screen = new ImageIcon("images/EP2screen16back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2screen18":
				switch(yourChoice) {
				case "c1":
					EP2boss5();
					screen = new ImageIcon("images/EP2boss5.gif");
					backgroundLabel.setIcon(screen);
					break;
				case "c2":
					EP2screen17();
					screen = new ImageIcon("images/EP2screen17back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP2boss1":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP2screen7();
					screen = new ImageIcon("images/EP2screen7back.gif");
					backgroundLabel.setIcon(screen);
				}
			break;
			
			case "EP2boss2":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP2screen10();
					screen = new ImageIcon("images/EP2screen10back.gif");
					backgroundLabel.setIcon(screen);
					choice1.setVisible(true);
				}
				break;
			
			case "EP2boss3":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP2screen10();
					screen = new ImageIcon("images/EP2screen10back.gif");
					backgroundLabel.setIcon(screen);
					choice1.setVisible(true);
				}
				break;

			case "EP2boss4":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP2screen14();
					screen = new ImageIcon("images/EP2screen14back.gif");
					backgroundLabel.setIcon(screen);
					choice1.setVisible(true);
				}
				break;
				
			case "EP2boss5":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP2screen18();
					screen = new ImageIcon("images/EP2screen18back.gif");
					backgroundLabel.setIcon(screen);
					choice1.setVisible(true);
				}
				break;
				
			case "EP3screen1":
				switch(yourChoice) {
				case "c1":
					EP3screen2();
					screen = new ImageIcon("images/EP3screen2.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen2":
				switch(yourChoice) {
				case "c1":
					EP3screen3();
					screen = new ImageIcon("images/EP3screen3.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen3":
				switch(yourChoice) {
				case "c1":
					EP3screen4();
					screen = new ImageIcon("images/EP3screen4.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen4":
				switch(yourChoice) {
				case "c1":
					EP3boss1();
					screen = new ImageIcon("images/EP3boss1.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen5":
				switch(yourChoice) {
				case "c1":
					EP3screen6();
					screen = new ImageIcon("images/EP3screen6.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen6":
				switch(yourChoice) {
				case "c1":
					EP3screen7();
					screen = new ImageIcon("images/EP3screen7.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen7":
				switch(yourChoice) {
				case "c1":
					EP3boss2();
					screen = new ImageIcon("images/EP3boss2.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen8":
				switch(yourChoice) {
				case "c1":
					EP3screen9();
					screen = new ImageIcon("images/EP3screen9.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen9":
				switch(yourChoice) {
				case "c1":
					EP3screen10();
					screen = new ImageIcon("images/EP3screen10.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen10":
				switch(yourChoice) {
				case "c1":
					EP3boss3();
					screen = new ImageIcon("images/EP3boss3.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen11":
				switch(yourChoice) {
				case "c1":
					EP3screen12();
					screen = new ImageIcon("images/EP3screen12.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen12":
				switch(yourChoice) {
				case "c1":
					EP3boss4();
					screen = new ImageIcon("images/EP3boss4.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen13":
				switch(yourChoice) {
				case "c1":
					EP3screen14();
					screen = new ImageIcon("images/EP3screen14.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen14":
				switch(yourChoice) {
				case "c1":
					EP3boss5();
					screen = new ImageIcon("images/EP3boss5.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen15":
				switch(yourChoice) {
				case "c1":
					EP3boss6();
					screen = new ImageIcon("images/EP3boss6.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen16":
				switch(yourChoice) {
				case "c1":
					EP3boss7();
					screen = new ImageIcon("images/EP3boss7.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3screen17":
				switch(yourChoice) {
				case "c1":
					EP3boss8();
					screen = new ImageIcon("images/EP3boss8.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
				
			case "EP3boss1":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP3screen4();
					screen = new ImageIcon("images/EP3screen4back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
			
			case "EP3boss2":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP3screen7();
					screen = new ImageIcon("images/EP3screen7back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
			
			case "EP3boss3":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP3screen10();
					screen = new ImageIcon("images/EP3screen10back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
			
			case "EP3boss4":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP3screen12();
					screen = new ImageIcon("images/EP3screen12back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
			
			case "EP3boss5":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP3screen14();
					screen = new ImageIcon("images/EP3screen14back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
				break;
			
			case "EP3boss6":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP3screen15();
					screen = new ImageIcon("images/EP3screen15back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
			break;
			
			case "EP3boss7":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP3screen16();
					screen = new ImageIcon("images/EP3screen16back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
			break;
			
			case "EP3boss8":
				switch(yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					EP3screen17();
					screen = new ImageIcon("images/EP3screen17back.gif");
					backgroundLabel.setIcon(screen);
					break;
				}
			break;
				
				
			case "fight":
				switch(yourChoice) {
				case "c1":
					if(EP1boss1key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP1boss1playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP1boss2key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP1boss2playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP1boss3key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP1boss3playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP1boss4key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP1boss4playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP2boss1key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP2boss1playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP2boss2key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP2boss2playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP2boss3key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP2boss3playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP2boss4key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP2boss4playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP2boss5key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP2boss5playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP3boss1key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP3boss1playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP3boss2key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP3boss2playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP3boss3key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP3boss3playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP3boss4key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP3boss4playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP3boss5key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP3boss5playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP3boss6key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP3boss6playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP3boss7key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP3boss7playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					else if(EP3boss8key == false)
					{
						screen.getImage().flush();
						screen = new ImageIcon("images/EP3boss8playerattack.gif");
						se.setFile(playerAttack);
						se.play();
						backgroundLabel.setIcon(screen);
					}
					playerAttack();
					break;
				}
				break;
				
				
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP <= 0 ){
						if(EP1boss1key == false)
						{
							EP1boss1key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP1boss1death.gif");
							se.setFile(ep1b1ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP1boss2key == false)
						{
							EP1boss2key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP1boss2.gif");
							se.setFile(ep1b2ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP1boss3key == false)
						{
							EP1boss3key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP1boss3death.gif");
							se.setFile(ep1b3ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP1boss4key == false)
						{
							EP1boss4key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP1boss4death.gif");
							se.setFile(ep1b4ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss1key == false)
						{
							EP2boss1key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss1death.gif");
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss2key == false)
						{
							EP2boss2key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss2death.gif");
							se.setFile(ep2b2ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss3key == false)
						{
							EP2boss3key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss3death.gif");
							se.setFile(ep2b3ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss4key == false)
						{
							EP2boss4key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss4death.gif");
							se.setFile(ep2b4ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss5key == false)
						{
							EP2boss5key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss5death.gif");
							se.setFile(ep2b5ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss1key == false)
						{
							EP3boss1key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss1death.gif");
							se.setFile(ep3b1ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss2key == false)
						{
							EP3boss2key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss2death.gif");
							se.setFile(ep3b2ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss3key == false)
						{
							EP3boss3key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss3death.gif");
							se.setFile(ep3b3ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss4key == false)
						{
							EP3boss4key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss4death.gif");
							se.setFile(ep3b4ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss5key == false)
						{
							EP3boss5key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss5death.gif");
							se.setFile(ep3b5ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss6key == false)
						{
							EP3boss6key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss6death.gif");
							se.setFile(ep3b6ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss7key == false)
						{
							EP3boss7key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss7death.gif");
							se.setFile(ep3b6ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss8key == false)
						{
							EP3boss8key = true;
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss8death.gif");
							se.setFile(ep3b6ds);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						win();
					}
					else{
						if(EP1boss1key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP1boss1bossattack.gif");
							se.setFile(ep1b1as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP1boss2key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP1boss2bossattack.gif");
							se.setFile(ep1b2as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP1boss3key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP1boss3bossattack.gif");
							se.setFile(ep1b3as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP1boss4key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP1boss4bossattack.gif");
							se.setFile(ep1b4as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss1key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss1bossattack.gif");
							se.setFile(ep2b1as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss2key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss2bossattack.gif");
							se.setFile(ep2b2as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss3key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss3bossattack.gif");
							se.setFile(ep2b3as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss4key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss4bossattack.gif");
							se.setFile(ep2b4as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP2boss5key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP2boss5bossattack.gif");
							se.setFile(ep2b5as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss1key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss1bossattack.gif");
							se.setFile(ep3b1as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss2key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss2bossattack.gif");
							se.setFile(ep3b2as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss3key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss3bossattack.gif");
							se.setFile(ep3b3as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss4key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss4bossattack.gif");
							se.setFile(ep3b4as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss5key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss5bossattack.gif");
							se.setFile(ep3b5as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss6key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss6bossattack.gif");
							se.setFile(ep3b6as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss7key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss7bossattack.gif");
							se.setFile(ep3b6as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						else if(EP3boss8key == false)
						{
							screen.getImage().flush();
							screen = new ImageIcon("images/EP3boss8bossattack.gif");
							se.setFile(ep3b6as);
							se.play();
							backgroundLabel.setIcon(screen);
						}
						monsterAttack();
					}
					break;
				}
				break;
				
			case "monsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP <= 0 ){
						lose();
						losePanel.setVisible(true);
					}
					else{
						fight();
					}
					break;
				}
				break;
				
			case "win":
				if(monsterName == "EP1boss1")
				{
					switch(yourChoice)
					{
						case "c1":
							EP1screen17();
							screen = new ImageIcon("images/EP1screen17back.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP1boss2")
				{
					switch(yourChoice)
					{
						case "c1":
							EP1screen25();
							screen = new ImageIcon("images/EP1screen25back.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP1boss3")
				{
					switch(yourChoice)
					{
						case "c1":
							EP1screen6();
							screen = new ImageIcon("images/EP1screen6back.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP1boss4")
				{
					switch(yourChoice)
					{
						case "c1":
							backgroundPanel.setVisible(false);
							mainTextPanel.setVisible(false);
							choiceButtonPanel.setVisible(false);
							infoPanel.setVisible(false);
							healthPanel.setVisible(false);
							playerPanel.setVisible(false);
							marketMapPanel.setVisible(false);
							levelErrorLabel.setText("");
							levelSelectionPanel.setVisible(true);
							break;
					}
				}
				else if(monsterName == "EP2boss1")
				{
					switch(yourChoice)
					{
						case "c1":
							EP2screen7();
							screen = new ImageIcon("images/EP2screen7back.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP2boss2")
				{
					switch(yourChoice)
					{
						case "c1":
							EP2screen10();
							screen = new ImageIcon("images/EP2screen10back.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP2boss3")
				{
					switch(yourChoice)
					{
						case "c1":
							EP2screen10();
							screen = new ImageIcon("images/EP2screen10back.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP2boss4")
				{
					switch(yourChoice)
					{
						case "c1":
							EP2screen14();
							screen = new ImageIcon("images/EP2screen14back.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP2boss5")
				{
					switch(yourChoice)
					{
						case "c1":
							backgroundPanel.setVisible(false);
							mainTextPanel.setVisible(false);
							choiceButtonPanel.setVisible(false);
							infoPanel.setVisible(false);
							healthPanel.setVisible(false);
							playerPanel.setVisible(false);
							marketMapPanel.setVisible(false);
							levelErrorLabel.setText("");
							levelSelectionPanel.setVisible(true);
							break;
					}
				}
				else if(monsterName == "EP3boss1")
				{
					switch(yourChoice)
					{
						case "c1":
							EP3screen5();
							screen = new ImageIcon("images/EP3screen5.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP3boss2")
				{
					switch(yourChoice)
					{
						case "c1":
							EP3screen8();
							screen = new ImageIcon("images/EP3screen8.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP3boss3")
				{
					switch(yourChoice)
					{
						case "c1":
							EP3screen11();
							screen = new ImageIcon("images/EP3screen17.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP3boss4")
				{
					switch(yourChoice)
					{
						case "c1":
							EP3screen13();
							screen = new ImageIcon("images/EP3creen13.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP3boss5")
				{
					switch(yourChoice)
					{
						case "c1":
							EP3screen15();
							screen = new ImageIcon("images/EP3screen15.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP3boss6")
				{
					switch(yourChoice)
					{
						case "c1":
							EP3screen16();
							screen = new ImageIcon("images/EP3screen16.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP3boss7")
				{
					switch(yourChoice)
					{
						case "c1":
							EP3screen17();
							screen = new ImageIcon("images/EP3screen17.gif");
							backgroundLabel.setIcon(screen);
							break;
					}
				}
				else if(monsterName == "EP3boss8")
				{
					switch(yourChoice)
					{
						case "c1":
							ending();
							break;
					}
				}
			}
		}
	}
	
	public class InventoryHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String yourChoice = e.getActionCommand();
			switch(yourChoice)
			{
				case "inventoryButton":
					if(inventoryStatus.equals("close"))
					{
						market.setEnabled(false);
						map.setEnabled(false);
						inventoryPanel.setVisible(true);
						itemButton1.setText(playerItem[0]);
						itemButton2.setText(playerItem[1]);
						itemButton3.setText(playerItem[2]);
						itemButton4.setText(playerItem[3]);
						itemButton5.setText(playerItem[4]);
						inventoryStatus = "open";
					}
					else if(inventoryStatus.equals("open"))
					{
						market.setEnabled(true);
						map.setEnabled(true);
						choice1.setVisible(true);
						choice2.setVisible(true);
						choice3.setVisible(true);
						choice4.setVisible(true);
						inventoryPanel.setVisible(false);
						inventoryStatus = "close";
					}
					break;
					
				case "item1":
					itemButton1.setText("");
					itemUsed(0);
					break;
					
				case "item2":
					itemButton2.setText("");
					itemUsed(1);
					break;
					
				case "item3":
					itemButton3.setText("");
					itemUsed(2);
					break;
					
				case "item4":
					itemButton4.setText("");
					itemUsed(3);
					break;
					
				case "item5":
					itemButton5.setText("");
					itemUsed(4);
					break;
					
			}
			
		}
		
	}
	
	public class ShowMarket implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(market.getText().equals("Market")) {
				mainTextPanel.setVisible(false);
				backgroundPanel.setVisible(false);
				choiceButtonPanel.setVisible(false);
				market.setText("Close");
				map.setEnabled(false);
				inventory.setEnabled(false);
				marketPanel.setVisible(true);
			}
			else if(market.getText().equals("Close")) {
				mainTextPanel.setVisible(true);
				backgroundPanel.setVisible(true);
				choiceButtonPanel.setVisible(true);
				marketPanel.setVisible(false);
				buyPanel.setVisible(false);
				map.setEnabled(true);
				inventory.setEnabled(true);
				market.setText("Market");
			}
			
		}
	}
	
	public class ShowMap implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(map.getText().equals("Map")){
				map.setText("Close");
				mainTextPanel.setVisible(false);
				choiceButtonPanel.setVisible(false);
				backgroundPanel.setVisible(false);
				mapPanel.setVisible(true);
				inventory.setEnabled(false);
				market.setEnabled(false);
			}
			else if(map.getText().equals("Close")) {
				mapPanel.setVisible(false);
				mainTextPanel.setVisible(true);
				choiceButtonPanel.setVisible(true);
				backgroundPanel.setVisible(true);
				inventory.setEnabled(true);
				market.setEnabled(true);
				map.setText("Map");
			}
			
		}
		
	}
	
	public class SetPlayer implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(player1.isSelected() == true)
			{
				player2.setSelected(false);
				player3.setSelected(false);
				playerHP = 100;
				playerCoin = 50;
				playerArmor = 5;
				weapon = "Knife";
				inventoryStatus = "close";
			}
			else if(player2.isSelected() == true)
			{
				player1.setSelected(false);
				player3.setSelected(false);
				playerHP = 100;
				playerCoin = 50;
				playerArmor = 6;
				weapon = "Knife";
				inventoryStatus = "close";
			}
			else if(player3.isSelected() == true)
			{	
				player1.setSelected(false);
				player2.setSelected(false);
				playerHP = 100;
				playerCoin = 50;
				playerArmor = 7;
				weapon = "Knife";
				inventoryStatus = "close";
			}
			
		}
		
	}
	
	public class SetterPlayer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(player1.isSelected() == false && player2.isSelected() == false && player3.isSelected() == false)
			{
				selectErrorLabel.setText("Lutfen asagidan bir karakter secin !");
			}
			else if( (player1.isSelected() == true && player2.isSelected() == true && player3.isSelected() == false) || (player1.isSelected() == true && player2.isSelected() == false && player3.isSelected() == true) || (player1.isSelected() == false && player2.isSelected() == true && player3.isSelected() == true) || (player1.isSelected() == true && player2.isSelected() == true && player3.isSelected() == true))
			{
				selectErrorLabel.setText("Lutfen asagidan sadece bir karakter secin !");
			}
			else
			{
				playerSelectionPanel.setVisible(false);
				LevelSelection();
			}
		}
		
	}
	
	public class LevelSelecter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand() == level1action)
			{
				if(EP1boss4key == true)
				{
					levelErrorLabel.setText("Burayi zaten tamamladiniz.");
				}
				else
				{
					createGameScreen();
				}
				
			}
			else if(e.getActionCommand() == level2action)
			{
				if(EP1boss4key != true)
				{
					levelErrorLabel.setText("Once Level 1'i bitirmeniz gerek !");
				}
				else
				{
					levelSelectionPanel.setVisible(false);
					EP2screen1();
					backgroundPanel.setVisible(true);
					mainTextPanel.setVisible(true);
					choiceButtonPanel.setVisible(true);
					infoPanel.setVisible(true);
					healthPanel.setVisible(true);
					playerPanel.setVisible(true);
					marketMapPanel.setVisible(true);
					levelErrorLabel.setText("");
				}
			}
			else if(e.getActionCommand() == level3action)
			{
				if(EP2boss5key != true && EP1boss4key != true)
				{
					levelErrorLabel.setText("Once Level 1 ve Level 2'yi bitirmeniz gerek !");
				}
				else if(EP2boss5key != true)
				{
					levelErrorLabel.setText("Once Level 2'i bitirmeniz gerek !");
				}
				else
				{
					levelSelectionPanel.setVisible(false);
					EP3screen1();
					backgroundPanel.setVisible(true);
					mainTextPanel.setVisible(true);
					choiceButtonPanel.setVisible(true);
					infoPanel.setVisible(true);
					healthPanel.setVisible(true);
					playerPanel.setVisible(true);
					marketMapPanel.setVisible(true);
					levelErrorLabel.setText("");
				}
			}
			
		}
		
	}
	
	public class ShowOptions implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			optionsPanel.setVisible(true);
		}
		
	}
	
	public class LoadGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			loadData();
		}
		
	}
	
	public class ShowAbout implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			aboutPanel.setVisible(true);
		}
		
	}
	
	public class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			timer.stop();
			mainTextArea.setText(text);
			i = 0;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class SoundEffect{
		Clip clip;
		public void setFile(String soundFileName) {
			try {
				File file = new File(soundFileName);
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
			catch(Exception e) {
				
			}
		}
		public void play() {
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public class ButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			se.setFile(clickSound);
			se.play();	
		}
		
	}
	
	public class Walk implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			se.setFile(walkSound);
			se.play();	
		}
		
	}
	
	public class Error implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			se.setFile(errorSound);
			se.play();	
		}
		
	}
	
	public class BuyHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String yourChoice = e.getActionCommand();
			
			switch(yourChoice) {
				case "item1":
					itemName = "item1";
					itemIcon = new ImageIcon("icons/wood-club125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Wood-Club hits 5.");
					buyPanel.setVisible(true);
					break;
				case "item2":
					itemName = "item2";
					itemIcon = new ImageIcon("icons/kusarigama125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Kusarigama hits 6.");
					buyPanel.setVisible(true);
					break;
				case "item3":
					itemName = "item3";
					itemIcon = new ImageIcon("icons/wood-axe125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Wood-Axe hits 7.");
					buyPanel.setVisible(true);
					break;
				case "item4":
					itemName = "item4";
					itemIcon = new ImageIcon("icons/sai125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Sai hits 8.");
					buyPanel.setVisible(true);
					break;
				case "item5":
					itemName = "item5";
					itemIcon = new ImageIcon("icons/katana125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Katana hits 9.");
					buyPanel.setVisible(true);
					break;
				case "item6":
					itemName = "item6";
					itemIcon = new ImageIcon("icons/broadsword125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Broadsword hits 10.");
					buyPanel.setVisible(true);
					break;
				case "item7":
					itemName = "item7";
					itemIcon = new ImageIcon("icons/light-helm125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Light-Helmet upgrade armor 2.");
					buyPanel.setVisible(true);
					break;
				case "item8":
					itemName = "item8";
					itemIcon = new ImageIcon("icons/closed-barbute125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Closed-Barbute upgrade armor 4.");
					buyPanel.setVisible(true);
					break;
				case "item9":
					itemName = "item9";
					itemIcon = new ImageIcon("icons/heavy-helm125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Heavy-Helmet upgrade armor 6.");
					buyPanel.setVisible(true);
					break;
				case "item10":
					itemName = "item10";
					itemIcon = new ImageIcon("icons/leather-armor125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Leather-Armor upgrade armor 2.");
					buyPanel.setVisible(true);
					break;
				case "item11":
					itemName = "item11";
					itemIcon = new ImageIcon("icons/chest-armor125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Chest-Armor upgrade armor 4.");
					buyPanel.setVisible(true);
					break;
				case "item12":
					itemName = "item12";
					itemIcon = new ImageIcon("icons/lamellar125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Lameller upgrade armor 6.");
					buyPanel.setVisible(true);
					break;
				case "item13":
					itemName = "item13";
					itemIcon = new ImageIcon("icons/greaves125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Greaves upgrade armor 2.");
					buyPanel.setVisible(true);
					break;
				case "item14":
					itemName = "item14";
					itemIcon = new ImageIcon("icons/armored-pants125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Armored-Pants upgrade armor 4.");
					buyPanel.setVisible(true);
					break;
				case "item15":
					itemName = "item15";
					itemIcon = new ImageIcon("icons/metal-skirt125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Metal-Skirt upgrade armor 6.");
					buyPanel.setVisible(true);
					break;
				case "item16":
					itemName = "item16";
					itemIcon = new ImageIcon("icons/boots125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Leather-Boots upgrade armor 2.");
					buyPanel.setVisible(true);
					break;
				case "item17":
					itemName = "item17";
					itemIcon = new ImageIcon("icons/leg-armor125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Wood-Boots upgrade armor 4.");
					buyPanel.setVisible(true);
					break;
				case "item18":
					itemName = "item18";
					itemIcon = new ImageIcon("icons/metal-boot125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Metal-Boots upgrade armor 6.");
					buyPanel.setVisible(true);
					break;
				case "item19":
					itemName = "item19";
					itemIcon = new ImageIcon("icons/potion-ball125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("XP-Potion gives 1 XP.");
					buyPanel.setVisible(true);
					break;
				case "item20":
					itemName = "item20";
					itemIcon = new ImageIcon("icons/magic-potion125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Health Potion gives 10 HP.");
					buyPanel.setVisible(true);
					break;
				case "item21":
					itemName = "item21";
					itemIcon = new ImageIcon("icons/health-potion125x.png");
					buyItemLabel.setIcon(itemIcon);
					itemInfoLabel.setText("Big Health Potion gives 25 HP.");
					buyPanel.setVisible(true);
					break;
			}
			
		}
		
	}
	
	public class BuyOption implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(itemName == "item1") {
				itemCost = 10;
				if(item1bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Wood-Club";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						weaponLabelName.setText(weapon);
						item1bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					weapon = "Wood-Club";
					weaponLabelName.setText(weapon);
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item2") {
				itemCost = 10;
				if(item2bought == false) {
					if(itemCost <= playerCoin) {
						btn2.setText("Satin alindi.");
						weapon = "Kusarigama";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						weaponLabelName.setText("Kusarigama");
						item2bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					weapon = "Kusarigama";
					weaponLabelName.setText(weapon);
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item3") {
				itemCost = 10;
				if(item3bought == false) {
					if(itemCost <= playerCoin) {
						btn3.setText("Satin alindi.");
						weapon = "Wood-Axe";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						weaponLabelName.setText("Wood-Axe");
						item3bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					weapon = "Wood-Axe";
					weaponLabelName.setText(weapon);
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item4") {
				itemCost = 10;
				if(item4bought == false) {
					if(itemCost <= playerCoin) {
						btn4.setText("Satin alindi.");
						weapon = "Sai";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						weaponLabelName.setText("Sai");
						item4bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					weapon = "Sai";
					weaponLabelName.setText(weapon);
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item5") {
				itemCost = 10;
				if(item5bought == false) {
					if(itemCost <= playerCoin) {
						btn5.setText("Satin alindi.");
						weapon = "Katana";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						weaponLabelName.setText("Katana");
						item5bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();					
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					weapon = "Katana";
					weaponLabelName.setText(weapon);
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item6") {
				itemCost = 10;
				if(item6bought == false) {
					if(itemCost <= playerCoin) {
						btn6.setText("Satin alindi.");
						weapon = "Broadsword";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						weaponLabelName.setText("Broadsword");
						item6bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					weapon = "Broadsword";
					weaponLabelName.setText(weapon);
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item7") {
				itemCost = 10;
				if(item7bought == false) {
					if(itemCost <= playerCoin) {
						btn7.setText("Satin alindi.");
						weapon = "Light-Helmet";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 2;
						item7bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item8") {
				itemCost = 10;
				if(item8bought == false) {
					if(itemCost <= playerCoin) {
						btn8.setText("Satin alindi.");
						weapon = "Closed-Barbute";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 4;
						item8bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item9") {
				itemCost = 10;
				if(item9bought == false) {
					if(itemCost <= playerCoin) {
						btn9.setText("Satin alindi.");
						weapon = "Heavy-Helmet";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 6;
						item9bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item10") {
				itemCost = 10;
				if(item10bought == false) {
					if(itemCost <= playerCoin) {
						btn10.setText("Satin alindi.");
						weapon = "Leather-Armor";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 2;
						item10bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item11") {
				itemCost = 10;
				if(item11bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Chest-Armor";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 4;
						item11bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item12") {
				itemCost = 10;
				if(item12bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Lamellar";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 6;
						item12bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item13") {
				itemCost = 10;
				if(item13bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Greaved";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 2;
						item13bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item14") {
				itemCost = 10;
				if(item14bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Armored-Pants";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 4;
						item14bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item15") {
				itemCost = 10;
				if(item15bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Metal-Skirt";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 6;
						item15bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item16") {
				itemCost = 10;
				if(item16bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Leather-Boots";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 2;
						item16bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item17") {
				itemCost = 10;
				if(item17bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Wood-Boots";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 4;
						item17bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item18") {
				itemCost = 10;
				if(item18bought == false) {
					if(itemCost <= playerCoin) {
						btn1.setText("Satin alindi.");
						weapon = "Metal-Boots";
						playerCoin = playerCoin - itemCost;
						coinLabelNumber.setText("" + playerCoin);
						playerArmor += 6;
						item18bought = true;
					}
					else {
						se.setFile(errorSound);
						se.play();
					}
				}
				else {
					se.setFile(errorSound);
					se.play();
					itemInfoLabel.setText("Zaten satin alindi.");
				}
			}
			else if(itemName == "item19") {
				itemCost = 1;
				if(itemCost <= playerCoin) {
					btn1.setText("Satin alindi.");
					expBar.setValue(expBar.getValue() + 1);
					if(expBar.getValue() == 10) {
						playerArmor += 5;
						playerDamage += 5;
						playerHP = 100;
						savedXP += 5;
						expBar.setValue(0);
						hpLabelNumber.setText("" + playerHP);
					}
					playerCoin = playerCoin - itemCost;
					coinLabelNumber.setText("" + playerCoin);
				}
				else {
					se.setFile(errorSound);
					se.play();
				}
			}
			else if(itemName == "item20") {
				itemCost = 10;
				if(itemCost <= playerCoin) {
					btn1.setText("Satin alindi.");
					playerCoin = playerCoin - itemCost;
					coinLabelNumber.setText("" + playerCoin);
					itemAdded("Potion");
				}
				else {
					se.setFile(errorSound);
					se.play();
				}
			}
			else if(itemName == "item21") {
				itemCost = 10;
				if(itemCost <= playerCoin) {
					btn1.setText("Satin alindi.");
					playerCoin = playerCoin - itemCost;
					coinLabelNumber.setText("" + playerCoin);
					itemAdded("Big Potion");
				}
				else {
					se.setFile(errorSound);
					se.play();
				}
			}
			
		}
		
	}
	
}
