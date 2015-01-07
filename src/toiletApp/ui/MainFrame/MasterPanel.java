package toiletApp.ui.MainFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.text.WordUtils;
import org.jdesktop.swingx.border.DropShadowBorder;
import org.jdesktop.swingx.prompt.PromptSupport;

import toiletApp.Garbage.ItemPanel;
import toiletApp.ui.MainFrame.NutritionTable.IngredientPanel;
import toiletApp.ui.PreferencesFrame.PreferencesFrame;
import toiletApp.ui.graphics.JCirclePanel;
import toiletApp.ui.graphics.RoundedJTextField;

import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;

public class MasterPanel extends ColorsPanel {

	//Work on previous and next button using maybe CardLayout?
	
	protected int maxWidth = 1024;
	protected int maxHeight = 768;
	protected JFrame myFrame = null;

	private static final long serialVersionUID = 1L;
	private int sideBarHeight = maxHeight - 75;
	private int iconBtnHeight = 120;
	private String iconFontSize = "font-size: 22px;";

	public JTextField searchBar;

	
	/**
	 * Create the panel.
	 */
	public MasterPanel(JFrame mf) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel northContainer = new JPanel();
		northContainer.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, secondaryColor));
		northContainer.setBackground(primaryColor);
		add(northContainer, BorderLayout.NORTH);
		northContainer.setLayout(new BoxLayout(northContainer, BoxLayout.X_AXIS));
		
		JPanel searchBarContainer = new JPanel();
		searchBarContainer.setBorder(new EmptyBorder(20, 0, 0, 0));
		searchBarContainer.setBackground(primaryColor);
		FlowLayout fl_searchBarContainer = (FlowLayout) searchBarContainer.getLayout();
		fl_searchBarContainer.setVgap(0);
		fl_searchBarContainer.setAlignment(FlowLayout.LEFT);
		northContainer.add(searchBarContainer);
		
		JPanel cardsControlContainer = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) cardsControlContainer.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(10);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		cardsControlContainer.setBackground(primaryColor);
		searchBarContainer.add(cardsControlContainer);
		
		JCirclePanel previousBtnContainer = new JCirclePanel();
		previousBtnContainer.setPreferredSize(new Dimension(30, 30));
		previousBtnContainer.setOpaque(false);
		previousBtnContainer.setForeground(CircleBgClr);
		cardsControlContainer.add(previousBtnContainer);
		previousBtnContainer.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel previousBtn = new JLabel("<html>\uf053</html>");
		previousBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				previousBtnContainer.setForeground(CircleBgHvr);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				previousBtnContainer.setForeground(CircleBgClr);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				CardLayout cl = (CardLayout) contentPanel.getLayout();
//                cl.previous(contentPanel);
			}
		});
		previousBtn.setHorizontalAlignment(SwingConstants.CENTER);
		previousBtn.setFont(fontAwesome(size));
		previousBtn.setForeground(primaryColor);
		previousBtn.setToolTipText("Go back"); //Set condition if can't go back & disabled btn color
		previousBtnContainer.add(previousBtn);
		
		JCirclePanel nextBtnContainer = new JCirclePanel();
		nextBtnContainer.setPreferredSize(new Dimension(30, 30));
		nextBtnContainer.setOpaque(false);
		nextBtnContainer.setForeground(CircleBgClr);
		cardsControlContainer.add(nextBtnContainer);
		nextBtnContainer.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel nextBtn = new JLabel("<html>\uf054</html>");
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nextBtnContainer.setForeground(CircleBgHvr);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nextBtnContainer.setForeground(CircleBgClr);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				CardLayout cl = (CardLayout) contentPanel.getLayout();
//                cl.next(contentPanel);
			}
		});
		nextBtn.setHorizontalAlignment(SwingConstants.CENTER);
		nextBtn.setFont(fontAwesome(size));
		nextBtn.setForeground(primaryColor);	
		nextBtn.setToolTipText("Go Forward"); //Set condition if can't go back & disabled btn color	
		nextBtnContainer.add(nextBtn);
		
		JPanel searchFieldContainer = new JPanel();
		searchFieldContainer.setPreferredSize(new Dimension(240, 40));
		searchFieldContainer.setBackground(primaryColor);
		searchBarContainer.add(searchFieldContainer);
		searchFieldContainer.setLayout(null);
		
		JLabel searchIcon = new JLabel();
		searchIcon.setBounds(3, 5, 30, 30);
		searchFieldContainer.add(searchIcon);
		searchIcon.setHorizontalAlignment(SwingConstants.CENTER);
		searchIcon.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/search.png")));
		
		JLabel clearTextBtn = new JLabel();
		clearTextBtn.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/clear.png")));
		clearTextBtn.setToolTipText("Clear Search Bar text");
		clearTextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				clearTextBtn.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/clear_rollover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				clearTextBtn.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/clear.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getModifiers() == MouseEvent.BUTTON1_MASK && e.getClickCount() == 1) {
					searchBar.setText("");
					clearTextBtn.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/clear_pressed.png")));
				}
			}
		});
		clearTextBtn.setVisible(false);
		clearTextBtn.setForeground(new Color(0x999999));
		clearTextBtn.setBounds(210, 5, 15, 30);
		searchFieldContainer.add(clearTextBtn);
		
		searchBar = new RoundedJTextField(0);
		searchBar.setBounds(0, 5, 230, 30);
		PromptSupport.setPrompt("Search", searchBar);
		searchBar.setToolTipText("Search for any food or ingredient available locally");
		//PromptSupport.setPrompt("Search", searchField);
		searchBar.setOpaque(false);
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					JPanel contentPane = new QueryResultsPanel(myFrame, searchBar.getText());
					myFrame.setContentPane(contentPane);
					myFrame.setVisible(true);
				}
			}
		});
		searchBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				searchBar.setBackground(Color.WHITE);
				clearTextBtn.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				searchBar.setBackground(searchBarCvr);
				clearTextBtn.setVisible(false);
			}
		});
		searchBar.setBackground(searchBarCvr);
		searchBar.setBorder(
				   javax.swing.BorderFactory.createCompoundBorder(
						      javax.swing.BorderFactory.createTitledBorder(
						         null, "",
						         javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						         javax.swing.border.TitledBorder.DEFAULT_POSITION,
						         new java.awt.Font("", 0, 0)
						      ),
						      javax.swing.BorderFactory.createEmptyBorder(0, 25, 0, 20)
						   )
						);
		searchBar.setPreferredSize(new Dimension(230, 30));
		searchBar.setFont(proximaNova(size));
		searchFieldContainer.add(searchBar);
		
		JPanel appTitleContainer = new JPanel();
		appTitleContainer.setBackground(primaryColor);
		northContainer.add(appTitleContainer);
		appTitleContainer.setLayout(new BoxLayout(appTitleContainer, BoxLayout.X_AXIS));
		
		JLabel appTitle = new JLabel("Placeholder");
		appTitle.setFont(proximaNova(size));
		appTitle.setForeground(defaultTextClr);
		appTitleContainer.add(appTitle);
		
		JPanel flowMenuContainer = new JPanel();
		flowMenuContainer.setBackground(primaryColor);
		FlowLayout flowLayout = (FlowLayout) flowMenuContainer.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		northContainer.add(flowMenuContainer);
		
		JPanel messagesBtn = new JPanel();
		messagesBtn.setBackground(primaryColor);
		messagesBtn.setPreferredSize(new Dimension(100, 75));
		flowMenuContainer.add(messagesBtn);
		messagesBtn.setLayout(new BorderLayout(0, 0));
		
		JLabel messagesIcon = new JLabel("<html>\uf0e0</html>");
		messagesIcon.setForeground(defaultTextClr);
		messagesIcon.setFont(fontAwesome(header));
		messagesIcon.setHorizontalAlignment(SwingConstants.CENTER);
		messagesBtn.add(messagesIcon, BorderLayout.CENTER);
		
		JLabel messagesLbl = new JLabel("<html>Messages</html>");
		messagesLbl.setBorder(new EmptyBorder(0, 0, 10, 0));
		messagesLbl.setForeground(defaultTextClr);
		messagesLbl.setFont(proximaNova(size));
		messagesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		messagesBtn.add(messagesLbl, BorderLayout.SOUTH);
		
		messagesBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				messagesIcon.setForeground(btnTextHover);
				messagesLbl.setForeground(btnTextHover);
				messagesBtn.setBackground(secondaryColor);
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				messagesIcon
				.setForeground(defaultTextClr);
				messagesLbl.setForeground(defaultTextClr);
				messagesBtn.setBackground(primaryColor);
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {  
				if (checkClick(e) == true) {
//		    		JFrame PreferencesFrame = new PreferencesFrame();
//		    		PreferencesFrame.setVisible(true);
				}
			}  
		});
		
		JPanel notificationsBtn = new JPanel();
		notificationsBtn.setBackground(primaryColor);
		notificationsBtn.setPreferredSize(new Dimension(100, 75));
		flowMenuContainer.add(notificationsBtn);
		notificationsBtn.setLayout(new BorderLayout(0, 0));
		
		JLabel notificationsIcon = new JLabel("<html>\uf0ac</html>");
		notificationsIcon.setFont(fontAwesome(header));
		notificationsIcon.setForeground(defaultTextClr);
		notificationsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		notificationsBtn.add(notificationsIcon, BorderLayout.CENTER);
		
		JLabel notificationsLbl = new JLabel("<html>Notifications</html>");
		notificationsLbl.setBorder(new EmptyBorder(0, 0, 10, 0));
		notificationsLbl.setFont(proximaNova(size));
		notificationsLbl.setForeground(defaultTextClr);
		notificationsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		notificationsBtn.add(notificationsLbl, BorderLayout.SOUTH);
		
		notificationsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				notificationsIcon.setForeground(btnTextHover);
				notificationsLbl.setForeground(btnTextHover);
				notificationsBtn.setBackground(secondaryColor);
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				notificationsIcon.setForeground(defaultTextClr);
				notificationsLbl.setForeground(defaultTextClr);
				notificationsBtn.setBackground(primaryColor);
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {  
				if (checkClick(e) == true) {
//		    		JFrame PreferencesFrame = new PreferencesFrame();
//		    		PreferencesFrame.setVisible(true);
				}
			}  
		});
		
		JPanel settingsBtn = new JPanel();
		settingsBtn.setBackground(primaryColor);
		settingsBtn.setPreferredSize(new Dimension(100, 75));
		flowMenuContainer.add(settingsBtn);
		settingsBtn.setLayout(new BorderLayout(0, 0));
		
		JLabel settingsIcon = new JLabel("<html>\uf013</html>");
		settingsIcon.setFont(fontAwesome(header));
		settingsIcon.setForeground(defaultTextClr);
		settingsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		settingsBtn.add(settingsIcon, BorderLayout.CENTER);
		
		JLabel settingsLbl = new JLabel("<html>Settings</html>");
		settingsLbl.setBorder(new EmptyBorder(0, 0, 10, 0));
		settingsLbl.setFont(proximaNova(size));
		settingsLbl.setForeground(defaultTextClr);
		settingsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		settingsBtn.add(settingsLbl, BorderLayout.SOUTH);
		
		settingsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				settingsIcon.setForeground(btnTextHover);
				settingsLbl.setForeground(btnTextHover);
				settingsBtn.setBackground(secondaryColor);
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				settingsIcon.setForeground(defaultTextClr);
				settingsLbl.setForeground(defaultTextClr);
				settingsBtn.setBackground(primaryColor);
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {  
				if (checkClick(e) == true) {
		    		JFrame PreferencesFrame = new PreferencesFrame();
		    		PreferencesFrame.setVisible(true);
				}
			}  
		});
		
		JPanel profileBtn = new JPanel();
		profileBtn.setBackground(primaryColor);
		profileBtn.setOpaque(true);
		profileBtn.setPreferredSize(new Dimension(100, 75));
		flowMenuContainer.add(profileBtn);
		profileBtn.setLayout(new BorderLayout(0, 0));
		
		JLabel profileIcon = new JLabel("<html>\uf007</html>");
		profileIcon.setFont(fontAwesome(header));
		profileIcon.setForeground(defaultTextClr);
		profileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		profileBtn.add(profileIcon, BorderLayout.CENTER);
		
		JLabel profileLbl = new JLabel("<html>" + getName() + "</html>");
		profileLbl.setBorder(new EmptyBorder(0, 0, 10, 0));
		profileLbl.setFont(proximaNova(size));
		profileLbl.setForeground(defaultTextClr);
		profileLbl.setHorizontalAlignment(SwingConstants.CENTER);
		profileBtn.add(profileLbl, BorderLayout.SOUTH);
		
		profileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				profileIcon.setForeground(btnTextHover);
				profileLbl.setForeground(btnTextHover);
				profileBtn.setBackground(secondaryColor);
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				profileIcon.setForeground(defaultTextClr);
				profileLbl.setForeground(defaultTextClr);
				profileBtn.setBackground(primaryColor);
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {  
				if (checkClick(e) == true) {
//		    		JFrame PreferencesFrame = new PreferencesFrame();
//		    		PreferencesFrame.setVisible(true);
				}
			}  
		});
		
		JPanel westContainer = new JPanel();
		westContainer.setBackground(primaryColor);
		add(westContainer, BorderLayout.WEST);
		westContainer.setLayout(new BoxLayout(westContainer, BoxLayout.Y_AXIS));
		
		JPanel westWingHeader = new JPanel();
		westWingHeader.setBackground(primaryColor);
		westContainer.add(westWingHeader);
		westWingHeader.setLayout(new BoxLayout(westWingHeader, BoxLayout.X_AXIS));
		
		JLabel lblMainMenu = new JLabel("<html>MAIN MENU</html>");
		lblMainMenu.setBorder(new EmptyBorder(15, 10, 15, 10));
		lblMainMenu.setForeground(defaultTextClr);
		westWingHeader.add(lblMainMenu);
		lblMainMenu.setFont(proximaNova(24f));
		
		JPanel browseBtn = new JPanel();
		browseBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		browseBtn.setBackground(primaryColor);
		westContainer.add(browseBtn);
		browseBtn.setLayout(new BoxLayout(browseBtn, BoxLayout.X_AXIS));
		
		JLabel browseIcon = new JLabel("<html>\uf187</html>");
		browseIcon.setVerticalAlignment(SwingConstants.BOTTOM);
		browseIcon.setForeground(defaultTextClr);
		browseIcon.setFont(fontAwesome(24f));
		browseBtn.add(browseIcon);
		
		JLabel browseLbl = new JLabel("<html>Browse</html>");
		browseLbl.setBorder(new EmptyBorder(0, 0, 0, 40));
		browseLbl.setForeground(defaultTextClr);
		browseLbl.setFont(proximaNova(size));
		browseBtn.add(browseLbl);
		
		browseBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				browseBtn.setBackground(secondaryColor);
				browseLbl.setForeground(btnTextHover);
				browseIcon.setForeground(btnTextHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				browseBtn.setBackground(primaryColor);
				browseLbl.setForeground(defaultTextClr);
				browseIcon.setForeground(defaultTextClr);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkClick(e) == true) {
					JPanel contentPane = new BrowsePanel(myFrame);
					myFrame.setContentPane(contentPane);
					myFrame.setVisible(true);
				}
			}
		});
		
		JPanel activityBtn = new JPanel();
		activityBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		activityBtn.setForeground(defaultTextClr);
		activityBtn.setBackground(primaryColor);
		westContainer.add(activityBtn);
		activityBtn.setLayout(new BoxLayout(activityBtn, BoxLayout.X_AXIS));
		
		JLabel activityIcon = new JLabel("<html>\uf022</html>");
		activityIcon.setForeground(defaultTextClr);
		activityIcon.setFont(fontAwesome(24f));
		activityBtn.add(activityIcon);
		
		JLabel activityLbl = new JLabel("<html>Activity Planner</html>");
		activityLbl.setBorder(new EmptyBorder(0, 12, 0, 0));
		activityLbl.setForeground(defaultTextClr);
		activityLbl.setFont(proximaNova(size));
		activityBtn.add(activityLbl);
		
		activityBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				activityBtn.setBackground(secondaryColor);
				activityLbl.setForeground(btnTextHover);
				activityIcon.setForeground(btnTextHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				activityBtn.setBackground(primaryColor);
				activityLbl.setForeground(defaultTextClr);
				activityIcon.setForeground(defaultTextClr);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkClick(e) == true) {
					JPanel contentPane = new ActivityPanel(myFrame);
					myFrame.setContentPane(contentPane);
					myFrame.setVisible(true);
				}
			}
		});
		
		JPanel nutritionBtn = new JPanel();
		nutritionBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		nutritionBtn.setForeground(defaultTextClr);
		nutritionBtn.setBackground(primaryColor);
		westContainer.add(nutritionBtn);
		nutritionBtn.setLayout(new BoxLayout(nutritionBtn, BoxLayout.X_AXIS));
		
		JLabel nutritionIcon = new JLabel("<html>\uf0ce</html>");
		nutritionIcon.setForeground(defaultTextClr);
		nutritionIcon.setFont(fontAwesome(24f));
		nutritionBtn.add(nutritionIcon);
		
		JLabel nutritionLbl = new JLabel("<html>Nutrition Table</html>");
		nutritionLbl.setBorder(new EmptyBorder(0, 7, 0, 0));
		nutritionLbl.setForeground(defaultTextClr);
		nutritionLbl.setFont(proximaNova(size));
		nutritionBtn.add(nutritionLbl);
		
		nutritionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nutritionBtn.setBackground(secondaryColor);
				nutritionLbl.setForeground(btnTextHover);
				nutritionIcon.setForeground(btnTextHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nutritionBtn.setBackground(primaryColor);
				nutritionLbl.setForeground(defaultTextClr);
				nutritionIcon.setForeground(defaultTextClr);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkClick(e) == true) {
//					JPanel contentPane = new NutritionPanel(myFrame);
//					myFrame.setContentPane(contentPane);
//					myFrame.setVisible(true);
				}
			}
		});
		
		JPanel tutorialsBtn = new JPanel();
		tutorialsBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		tutorialsBtn.setBackground(primaryColor);
		westContainer.add(tutorialsBtn);
		tutorialsBtn.setLayout(new BoxLayout(tutorialsBtn, BoxLayout.X_AXIS));
		
		JLabel tutorialsIcon = new JLabel("<html>\uf044</html>");
		tutorialsIcon.setForeground(defaultTextClr);
		tutorialsIcon.setFont(fontAwesome(24f));
		tutorialsBtn.add(tutorialsIcon);
		
		JLabel tutorialsLbl = new JLabel("<html>Tutorials</html>");
		tutorialsLbl.setForeground(defaultTextClr);
		tutorialsLbl.setFont(proximaNova(size));
		tutorialsLbl.setBorder(new EmptyBorder(0, 0, 0, 32));
		tutorialsBtn.add(tutorialsLbl);
		
		tutorialsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				tutorialsBtn.setBackground(secondaryColor);
				tutorialsLbl.setForeground(btnTextHover);
				tutorialsIcon.setForeground(btnTextHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				tutorialsBtn.setBackground(primaryColor);
				tutorialsLbl.setForeground(defaultTextClr);
				tutorialsIcon.setForeground(defaultTextClr);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkClick(e) == true) {
					JPanel contentPane = new TutorialsPanel(myFrame);
					myFrame.setContentPane(contentPane);
					myFrame.setVisible(true);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, primaryColor));
		westContainer.add(separator);
		
		JPanel helpBtn = new JPanel();
		helpBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		helpBtn.setBackground(primaryColor);
		westContainer.add(helpBtn);
		helpBtn.setLayout(new BoxLayout(helpBtn, BoxLayout.LINE_AXIS));
		
		JLabel helpIcon = new JLabel("<html>\uf059</html>");
		helpBtn.add(helpIcon);
		helpIcon.setHorizontalAlignment(SwingConstants.LEFT);
		helpIcon.setForeground(defaultTextClr);
		helpIcon.setFont(fontAwesome(24f));
		
		JLabel helpLbl = new JLabel("<html>Help</html>");
		helpLbl.setHorizontalAlignment(SwingConstants.LEFT);
		helpBtn.add(helpLbl);
		helpLbl.setBorder(new EmptyBorder(0, 0, 0, 40));
		helpLbl.setForeground(defaultTextClr);
		helpLbl.setFont(proximaNova(size));
		
		helpBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				helpBtn.setBackground(secondaryColor);
				helpLbl.setForeground(btnTextHover);
				helpIcon.setForeground(btnTextHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpBtn.setBackground(primaryColor);
				helpLbl.setForeground(defaultTextClr);
				helpIcon.setForeground(defaultTextClr);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkClick(e) == true) {
					JPanel contentPane = new HelpPanel(myFrame);
					myFrame.setContentPane(contentPane);
					myFrame.setVisible(true);
				}
			}
		});
		
		JPanel contentContainer = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) contentContainer.getLayout();
		flowLayout_1.setHgap(0);
		flowLayout_1.setVgap(0);
		add(contentContainer, BorderLayout.SOUTH);
		myFrame = mf;
		
	}
	
	//Custom Methods for subclasses
	public boolean checkClick(MouseEvent e) {
		boolean check = false;
		if (e.getModifiers() == MouseEvent.BUTTON1_MASK && e.getClickCount() == 1) {
			check = true;
		}
		
		return check;
	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height) {
	    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, width, height, null);
	    g2d.dispose();
	    return bi;
	}

	protected JPanel createPanel(String name, String imageLink, int id) {
        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(200, 240));
        container.setOpaque(false);
        DropShadowBorder shadow = new DropShadowBorder();
        shadow.setShadowColor(Color.BLACK);
        shadow.setShowLeftShadow(true);
        shadow.setShowRightShadow(true);
        shadow.setShowBottomShadow(true);
        shadow.setShowTopShadow(true);
        container.setBorder(shadow);
		container.setLayout(new BorderLayout(0, 0));
			
		JLabel image = new JLabel();
		image.setPreferredSize(new Dimension(200,180));
		image.setIcon(new ImageIcon(MasterPanel.class.getResource(imageLink))); //Make image fit
		container.add(image, BorderLayout.CENTER);
		
		JLabel itemName = new JLabel("<html>" + WordUtils.capitalize(name) + "</html>");
		itemName.setFont(proximaNova(size));
		itemName.setPreferredSize(new Dimension(200,50));
		itemName.setVerticalAlignment(SwingConstants.TOP);
		itemName.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemName.setBackground(primaryColor);
		itemName.setForeground(defaultTextClr);
		itemName.setOpaque(true);
		container.add(itemName, BorderLayout.SOUTH);
		
		container.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(checkClick(arg0) == true) {
					JPanel contentPane = new IngredientPanel(myFrame, id);
					myFrame.setContentPane(contentPane);
					myFrame.setVisible(true);
				}
			}
		});
		
        return container;
    }
}

