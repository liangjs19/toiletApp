package toiletApp.ui.MainFrame.NutritionTable;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import toiletApp.dataAccess.QueryDA;
import toiletApp.entity.Ingredient;
import toiletApp.ui.MainFrame.MasterPanel;
import toiletApp.ui.MainFrame.QueryResultsPanel;
import toiletApp.ui.graphics.IngredientTableModel;
import toiletApp.ui.graphics.RoundedJTextField;

import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class IngredientPanel extends MasterPanel {

	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JPanel container, contentContainer, nutritionPanel, relatedStuff, itemsContainer, caloriesSuperContainer;
	private javax.swing.JLabel containerHeader, relatedStuffHdr, contentPaneBg, caloriesCounter, caloriesLbl;
	private javax.swing.JTextPane textPane;
	/**
	 * Create the panel.
	 * 
	 */
	private float size = 14f, 
						subHeader = 20f,
						header = 32f,
						bigHeader = 48f;
	private JPanel descriptionPanel;
	private JLabel descriptionHeader;
	private JPanel nutritionHeader;
	private JLabel label;
	private JLabel lblNewLabel;
	private JTable table;
	private JPanel graphicsPanel;
	private JPanel caloriesContainer;
	private JPanel servingContainer;
	private JLabel servingFieldLbl;
	private JTextField servingsField;
	private int count = 1;
	public IngredientPanel(JFrame mf, int id) {
		super(mf);
		
		Ingredient ingredient = QueryDA.retrieveIngredientsById(id);
		
		JScrollPane scrollPane  = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setBounds(150, 75, 870, 667);
		add(scrollPane, BorderLayout.CENTER);
		
		container = new JPanel();
		container.setBackground(secondaryColor);
		scrollPane.setViewportView(container);
		container.setLayout(new BorderLayout(0, 0));
		
		containerHeader = new JLabel();
		containerHeader.setIcon(new ImageIcon(IngredientPanel.class.getResource(ingredient.getImageLink())));
		containerHeader.setPreferredSize(new Dimension(865, 325));
		containerHeader.setBackground(Color.BLACK);
		container.add(containerHeader, BorderLayout.NORTH );
		
		contentContainer = new JPanel();
		contentContainer.setBackground(secondaryColor); 
		container.add(contentContainer, BorderLayout.CENTER);
		contentContainer.setLayout(new BoxLayout(contentContainer, BoxLayout.Y_AXIS));
		
		descriptionPanel = new JPanel();
		contentContainer.add(descriptionPanel);
		descriptionPanel.setLayout(new BorderLayout(0, 0));
		descriptionPanel.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(15, 15, 0, 15, secondaryColor), 
				new EmptyBorder(10, 20, 10, 20)));
		descriptionPanel.setBackground(CircleBgHvr); 
		
		textPane = new JTextPane();
		textPane.setHighlighter(null);
		textPane.setEditable(false);
		textPane.setBackground(CircleBgHvr); 
		textPane.setText(ingredient.getDescription());
		textPane.setFont(proximaNova(size));
		descriptionPanel.add(textPane, BorderLayout.SOUTH);
		
		descriptionHeader = new JLabel("<html><strong>" + ingredient.getName() + "</strong></html>");
		descriptionHeader.setFont(proximaNova(subHeader));
		descriptionPanel.add(descriptionHeader, BorderLayout.NORTH);
		
		caloriesSuperContainer = new JPanel();
		caloriesSuperContainer.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 15, 10, 15, secondaryColor), 
				new EmptyBorder(10, 20, 10, 20)));
		caloriesSuperContainer.setBackground(primaryColor); 
		contentContainer.add(caloriesSuperContainer);
		caloriesSuperContainer.setLayout(new BorderLayout(0, 0));
		
		caloriesContainer = new JPanel();
		FlowLayout flowLayout = (FlowLayout) caloriesContainer.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		caloriesContainer.setBackground(primaryColor);
		caloriesSuperContainer.add(caloriesContainer, BorderLayout.WEST);
				
				caloriesCounter = new JLabel();
				caloriesContainer.add(caloriesCounter);
				caloriesCounter.setText("<html><strong>" + (ingredient.getEnergy()*count) + "</strong></html>");
				caloriesCounter.setForeground(secondaryColor);
				caloriesCounter.setFont(proximaNova(bigHeader));

				caloriesLbl = new JLabel("<html>calories</html>");
				caloriesContainer.add(caloriesLbl);
				caloriesLbl.setForeground(defaultTextClr);
				caloriesLbl.setFont(proximaNova(header));
				
				servingContainer = new JPanel();
				servingContainer.setBackground(primaryColor);
				servingContainer.setBorder(new EmptyBorder(10, 0, 0, 0));
				caloriesSuperContainer.add(servingContainer, BorderLayout.EAST);
				servingContainer.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				
				servingFieldLbl = new JLabel("<html>Serving Size</html>");
				servingFieldLbl.setFont(proximaNova(size));
				servingFieldLbl.setForeground(defaultTextClr);
				servingContainer.add(servingFieldLbl);
				
				servingsField = new RoundedJTextField(0);
				servingsField.setBorder(
						   javax.swing.BorderFactory.createCompoundBorder(
								      javax.swing.BorderFactory.createTitledBorder(
								         null, "",
								         javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
								         javax.swing.border.TitledBorder.DEFAULT_POSITION,
								         new java.awt.Font("Montserrat", 0, 5)
								      ),
								      javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)
								   )
								);
				servingsField.setOpaque(false);
				servingsField.setFont(proximaNova(size));
				servingsField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_ENTER) {
								count = Integer.parseInt(servingsField.getText());
								caloriesCounter.setText("<html><strong>" + (ingredient.getEnergy()*count) + "</strong></html>");
						}
					}
				});
				servingsField.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						servingsField.setBackground(Color.WHITE);
					}
					@Override
					public void focusLost(FocusEvent e) {
						servingsField.setBackground(searchBarCvr);
					}
				});
				servingContainer.add(servingsField);
				servingsField.setColumns(3);
			
        nutritionPanel = new JPanel();
        nutritionPanel.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(5, 15, 15, 15, secondaryColor), 
        		new EmptyBorder(10, 20, 20, 20)));
        nutritionPanel.setBackground(CircleBgHvr); 
        contentContainer.add(nutritionPanel);
        nutritionPanel.setLayout(new BorderLayout(0, 10));
        
        lblNewLabel = new JLabel("<html>Nutrition Facts <small style=\"font-size: 14px;\">per serving</small></html>");
        nutritionPanel.add(lblNewLabel, BorderLayout.NORTH);
        lblNewLabel.setFont(proximaNova(header));
        
        JPanel valuesContainer = new JPanel();
        valuesContainer.setBackground(CircleBgHvr);
        nutritionPanel.add(valuesContainer, BorderLayout.CENTER);
        valuesContainer.setLayout(new GridLayout(0, 1, 0, 0));
        
        table = new JTable(new IngredientTableModel(id, count));
        table.setRowHeight(35);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        table.setFont(proximaNova(18f));
        table.setTableHeader(new SingleColumnTableHeader());
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setBackground(CircleBgHvr);
        table.setGridColor(secondaryColor);
        table.setDefaultRenderer(Double.class, new IngredientRenderer());
        valuesContainer.add(table);
        
        graphicsPanel = new JPanel();
        graphicsPanel.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(5, 15, 15, 15, secondaryColor), 
        		new EmptyBorder(10, 20, 10, 20)));
        graphicsPanel.setBackground(CircleBgHvr);
        contentContainer.add(graphicsPanel);
		
		relatedStuff = new JPanel();
		relatedStuff.setBackground(secondaryColor);
		container.add(relatedStuff, BorderLayout.SOUTH);
		relatedStuff.setLayout(new BorderLayout(0, 0));
		
		relatedStuffHdr = new JLabel("<html>Related ingredients</html>");
		relatedStuffHdr.setForeground(primaryColor);
		relatedStuffHdr.setFont(header());
		relatedStuffHdr.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(10, 20, 10, 15, secondaryColor), BorderFactory.createMatteBorder(0, 0, 5, 0, CircleBgHvr)));
		relatedStuff.add(relatedStuffHdr, BorderLayout.NORTH);
		
		itemsContainer = new JPanel();
		itemsContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		ArrayList<Ingredient> list = QueryDA.retrieveIngredientsByName(ingredient.getName());
	    for (Ingredient e : list) {
	    	itemsContainer.add(createPanel(e.getName(), e.getImageLink(), e.getId()));
		 }
		itemsContainer.setBackground(secondaryColor);
		itemsContainer.setBorder(new EmptyBorder(0, 15, 10, 20));
		relatedStuff.add(itemsContainer, BorderLayout.CENTER);
	}
	
	public class SingleColumnTableHeader extends JTableHeader {

        private JLabel renderer;

        public SingleColumnTableHeader() {
            setBackground(Color.WHITE);
            renderer = new JLabel("");
            renderer.setBorder(new EmptyBorder(4, 0, 4, 0));
        }

        @Override
        public Dimension getPreferredSize() {
            return renderer.getPreferredSize();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            FontMetrics fm = g2d.getFontMetrics();

            Insets insets = getInsets();
            int width = getWidth() - (insets.left + insets.right);
            int height = getHeight() - (insets.top + insets.bottom);

            renderer.setBounds(insets.left, insets.top, width, height);
            renderer.paint(g2d);

            g2d.setColor(Color.LIGHT_GRAY);
            g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(insets.left, insets.top + height - 1, insets.left + width, insets.top + height - 1);

            g2d.dispose();
        }
	}
	
	public class IngredientRenderer extends DefaultTableCellRenderer {

        private Font boldFont;

        public IngredientRenderer() {
            setHorizontalAlignment(JLabel.RIGHT);
        }
    }
}
