package toiletApp.Garbage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.text.WordUtils;

import toiletApp.ui.MainFrame.BrowsePanel;
import toiletApp.ui.MainFrame.ColorsPanel;

public class testdb extends ColorsPanel {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testdb frame = new testdb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public testdb() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel wrapper = new JPanel();
		wrapper.setBackground(CircleBgHvr);
		add(wrapper, BorderLayout.CENTER);
		wrapper.setLayout(new BorderLayout(0, 0));
		
		JLabel typeImage = new JLabel();
		typeImage.setHorizontalAlignment(SwingConstants.CENTER);
		typeImage.setIcon(new ImageIcon(testdb.class.getResource("/screenDesign/images/FoodType/dark/bread.png")));
		wrapper.add(typeImage, BorderLayout.CENTER);
			
		JLabel foodType = new JLabel(WordUtils.capitalize("Lmao"));
		foodType.setVerticalAlignment(SwingConstants.TOP);
		foodType.setBorder(new EmptyBorder(0, 0, 80, 0));
		foodType.setHorizontalAlignment(SwingConstants.CENTER);
		wrapper.add(foodType, BorderLayout.SOUTH);

	}
}

//		public void paint(Graphics g) {
//			 
//	        Graphics2D g2d = (Graphics2D)g;
//	 
//	        String text = "The quick brown fox jumped over the lazy dog";
//	        Font font = ColorsPanel.proximaNova(28f);
//	        g2d.setFont(font);
//	 
//	        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//	                             RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
//	        g2d.drawString(text, 20, 30);
//	 
//	        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//	                             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//	        g2d.drawString(text, 20, 50);
//	 
//	        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//	                             RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
//	        g2d.drawString(text, 20, 70);
//	 
//	        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//	                             RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
//	        g2d.drawString(text, 20, 90);
//	    }
	 
//	    public static void main(String[] args) {
	 
//	        Frame f = new Frame("Antialiased Text Sample");
//	             
//	        f.addWindowListener(new WindowAdapter(){
//	                public void windowClosing(WindowEvent e) {
//	                    System.exit(0);
//	                }
//	            });
//	 
//	        f.add(new testdb());
//	        f.setSize(new Dimension(300, 180));
//	        f.setVisible(true);
//	    }
    
//	public Color CircleBgClr = new Color(0xFFD393);
//	public Color profilePanelTxtClr = new Color(0x000000);
//	public Color contentTextClr = new Color(0x454545);
//	public Color searchBarCvr = new Color(0xE5E5E5);
//	public Color vibrantOrange = new Color(0xFF974F);
//	public Color defaultTextClr = new Color(0xFFFFFF);
//	public Color btnHover = new Color(0xFF7A23);
//	public Color btnTextHover = new Color(0x76582B);
//	public Color secondaryColor = new Color(0xFFD393);
//	public Color CircleBgHvr = new Color(0xE3BC82);
//	public Color sideBar = new Color(0x9C9B7A);
//	public Color primaryColor = new Color(0x405952);
//	public Font contentFont = new Font("Verdena", Font.PLAIN, 14);
//	public Font header = new Font("Gotham Rounded Light", Font.PLAIN, 32);
//	protected JTextField searchField;
//	private boolean check = false;
//	 private BufferedImage image;
//    /**
//     * Creates new form DynamicTextboxes
//     */
//    public testdb() {
//    	try {
//            image = ImageIO.read(new URL(
//                    "http://sstatic.net/stackoverflow/img/logo.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        image = process(image);
//    }
//
//    private BufferedImage process(BufferedImage old) {
//        int w = old.getWidth();
//        int h = old.getHeight();
//        BufferedImage img = new BufferedImage(
//                w, h, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2d = img.createGraphics();
//        g2d.drawImage(old, 0, 0, null);
//        g2d.setPaint(Color.red);
//        g2d.setFont(new Font("Serif", Font.BOLD, 20));
//        String s = "Hello, world!";
//        FontMetrics fm = g2d.getFontMetrics();
//        int x = img.getWidth() - fm.stringWidth(s) - 5;
//        int y = fm.getHeight();
//        g2d.drawString(s, x, y);
//        g2d.dispose();
//        return img;
//    }
//    
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(image, 0, 0, null);
//    }
//
//    private static void create() {
//        JFrame f = new JFrame();
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(new testdb());
//        f.pack();
//        f.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                create();
//            }
//        });
//    }
//    
//    private void initComponents() {
//    	
//        
//        
//    	
//    	//Search Bar 
//    			JLabel searchIcon = new JLabel();
//    			searchIcon.setHorizontalAlignment(SwingConstants.CENTER);
//    			searchIcon.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/search.png")));
//    			searchIcon.setBounds(105, 30, 30, 30);
//    			getContentPane().add(searchIcon);
//    			
//    			JLabel clearTextBtn = new JLabel();
//    			clearTextBtn.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/clear.png")));
//    			clearTextBtn.setToolTipText("Clear Search Bar text");
//    			clearTextBtn.addMouseListener(new MouseAdapter() {
//    				@Override
//    				public void mouseEntered(MouseEvent arg0) {
//    					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//    					clearTextBtn.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/clear_rollover.png")));
//    				}
//    				@Override
//    				public void mouseExited(MouseEvent e) {
//    					setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//    					clearTextBtn.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/clear.png")));
//    				}
//    				@Override
//    				public void mousePressed(MouseEvent e) {
//    					if (e.getModifiers() == MouseEvent.BUTTON1_MASK && e.getClickCount() == 1) {
//    						searchField.setText("");
//    						clearTextBtn.setIcon(new ImageIcon(MasterPanel.class.getResource("/java/org/jdesktop/xswingx/plaf/macosx/resources/clear_pressed.png")));
//    					}
//    				}
//    			});
//    			clearTextBtn.setVisible(false);
//    			clearTextBtn.setForeground(new Color(0x999999));
//    			clearTextBtn.setBounds(312, 30, 15, 30);
//    			getContentPane().add(clearTextBtn);
//    			
//    			searchField = new RoundedJTextField(0);
//    			//PromptSupport.setPrompt("Search", searchField);
//    			searchField.setOpaque(false);
//    			searchField.addKeyListener(new KeyAdapter() {
//    				@Override
//    				public void keyPressed(KeyEvent e) {
//    					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
////    						JPanel contentPane = new QueryResultsPanel(myFrame);// Change codes when database has been coded
////    						myFrame.setContentPane(contentPane);
////    						myFrame.setVisible(true);
//    						check = true;
//    					}
//    				}
//    			});
//    			searchField.addActionListener(new ActionListener() {
//    				public void actionPerformed(ActionEvent e) {
//    					String searchFieldValue = searchField.getText();
//    				}
//    			});
//    			searchField.addFocusListener(new FocusAdapter() {
//    				@Override
//    				public void focusGained(FocusEvent arg0) {
//    					searchField.setBackground(Color.WHITE);
//    					clearTextBtn.setVisible(true);
//    				}
//    				@Override
//    				public void focusLost(FocusEvent e) {
//    					searchField.setBackground(searchBarCvr);
//    					clearTextBtn.setVisible(false);
//    				}
//    			});
//    			searchField.setBackground(searchBarCvr);
//    			searchField.setBorder(
//    					   javax.swing.BorderFactory.createCompoundBorder(
//    							      javax.swing.BorderFactory.createTitledBorder(
//    							         null, "",
//    							         javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
//    							         javax.swing.border.TitledBorder.DEFAULT_POSITION,
//    							         new java.awt.Font("Montserrat", 0, 5)
//    							      ),
//    							      javax.swing.BorderFactory.createEmptyBorder(0, 25, 0, 20)
//    							   )
//    							);
//    			searchField.setBounds(104, 30, 230, 30);
//    			searchField.setPreferredSize(new Dimension(100, 40));
//    			getContentPane().add(searchField);
//    			
//    	//Scrollpan
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.getHorizontalScrollBar().setUnitIncrement(20);
//		scrollPane.setBounds(150, 75, 870, 667);
//		getContentPane().add(scrollPane);
//    			
//    	//Container panel
//		JPanel container = new JPanel();
//		container.setPreferredSize(new Dimension(width, height));
//		scrollPane.setViewportView(container);
//		container.setLayout(null);
//		
//		//Query Ingredient
//		JLabel ingredientHeader = new JLabel("Ingredients");
//		ingredientHeader.setFont(header);
//		ingredientHeader.setForeground(contentTextClr);
//		ingredientHeader.setBounds(60, 330, 200, 30);
//		container.add(ingredientHeader);
//		
//		JSeparator ingredientHeaderrHr = new JSeparator();
//		ingredientHeaderrHr.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, CircleBgHvr));
//		ingredientHeaderrHr.setBounds(60, 370, (width-120), 3);
//		container.add(ingredientHeaderrHr);
//		
//		JPanel ingredientsContainer = new JPanel();
//		ingredientsContainer.setBackground(secondaryColor);
//		ingredientsContainer.setBounds(60, 385, (width-120), 240);
//		container.add(ingredientsContainer);
//		ingredientsContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//			}
//		});
//		lblNewLabel.setIcon(new ImageIcon(testdb.class.getResource("/screenDesign/images/westernCuisineClippedMask.png")));
//		ingredientsContainer.add(lblNewLabel);
//		
//		ArrayList<Ingredient>list = QueryDA.retrieveIngredientsByName("chicken");
//	    for (Ingredient ingredient : list) {
//	    	if(check = true) {
//	    		ingredientsContainer.add(createPanel(ingredient.getName()));
//	    	}
//		 }
//		
//		//Background
//		JLabel contentPaneBg = new JLabel();
//		contentPaneBg.setBounds(0, 0, width, height);
//		container.add(contentPaneBg);
//		contentPaneBg.setBackground(secondaryColor);
//		contentPaneBg.setOpaque(true);
//		
//		JSeparator separator = new JSeparator();
//		separator.setBounds(60, 326, 813, 2);
//		container.add(separator);
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setIcon(new ImageIcon(testdb.class.getResource("/screenDesign/images/chicken.jpg")));
//		btnNewButton.setBounds(77, 268, 89, 23);
//		container.add(btnNewButton);
//				
//		}
//		
//    private JPanel createPanel(String name) {
//        JPanel container = new JPanel();
//		container.setPreferredSize(new Dimension(200, 240));
//		container.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, secondaryColor));
//		container.setLayout(new BorderLayout(0, 0));
//
//		JLabel image = new JLabel();
//		image.setPreferredSize(new Dimension(200,180));
//		image.setIcon(new ImageIcon(ItemPanel.class.getResource("/screenDesign/images/englishCuisineClipedMask.png"))); //mysql BLOB datatype for img
//		container.add(image, BorderLayout.CENTER);
//		
//		JLabel itemName = new JLabel(name);
//		itemName.setPreferredSize(new Dimension(200,50));
//		itemName.setVerticalAlignment(SwingConstants.TOP);
//		itemName.setBorder(new EmptyBorder(10, 10, 10, 10));
//		itemName.setBackground(primaryColor);
//		itemName.setForeground(defaultTextClr);
//		itemName.setOpaque(true);
//		container.add(itemName, BorderLayout.SOUTH);
//        return container;
//    }
//    private int width =1500;
//	private int height = 649;
//
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new testdb().setVisible(true);
//            }
//        });
//    }
//    public String getSearchFieldString() {
//        return searchField.getText();
//    }
//    // Variables declaration - do not modify
//    private javax.swing.JButton jButton1;
//    private javax.swing.JPanel jPanel1;
//    private javax.swing.JTabbedPane jTabbedPane1;


