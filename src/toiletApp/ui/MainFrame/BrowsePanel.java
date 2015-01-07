package toiletApp.ui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.text.WordUtils;
import org.jdesktop.swingx.border.DropShadowBorder;

import toiletApp.dataAccess.QueryDA;
import toiletApp.entity.FoodType;
import toiletApp.ui.MainFrame.NutritionTable.IngredientPanel;

public class BrowsePanel extends MasterPanel {

	private JPanel typeList;
	protected String theme = "";
	/**
	 * Create the panel.
	 */
	public BrowsePanel(JFrame mf) {
		super(mf);
		
		DropShadowBorder shadow = new DropShadowBorder();
        shadow.setShadowColor(Color.BLACK);
        shadow.setShowLeftShadow(true);
        shadow.setShowRightShadow(true);
        shadow.setShowBottomShadow(true);
        shadow.setShowTopShadow(true);
        
		JPanel superContainer = new JPanel();
		superContainer.setBackground(secondaryColor);
		superContainer.setBorder(new EmptyBorder(10, 15, 10, 15));
		add(superContainer, BorderLayout.CENTER);
		superContainer.setLayout(new BoxLayout(superContainer, BoxLayout.Y_AXIS));
		
		JPanel headerContainer = new JPanel();
		headerContainer.setBackground(secondaryColor);
		superContainer.add(headerContainer);
		headerContainer.setLayout(new BoxLayout(headerContainer, BoxLayout.Y_AXIS));
		
		JPanel browseLblContainer = new JPanel();
		browseLblContainer.setBackground(secondaryColor);
		FlowLayout fl_browseLblContainer = (FlowLayout) browseLblContainer.getLayout();
		fl_browseLblContainer.setAlignment(FlowLayout.LEFT);
		headerContainer.add(browseLblContainer);
		
		JLabel browseLbl = new JLabel("<html>Browse</html>");
		browseLbl.setFont(proximaNova(header));
		browseLbl.setHorizontalAlignment(SwingConstants.LEFT);
		browseLblContainer.add(browseLbl);
		
		JPanel tabsContainer = new JPanel();
		tabsContainer.setBackground(secondaryColor);
		headerContainer.add(tabsContainer);
		
		JPanel listContainer = new JPanel();
		listContainer.setBackground(secondaryColor);
		superContainer.add(listContainer);
		
		JPanel topLists = new JPanel();
		topLists.setBackground(secondaryColor);
		topLists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		listContainer.setLayout(new GridLayout(0, 2, 10, 20));
		topLists.setBorder(shadow);
		listContainer.add(topLists);
		topLists.setLayout(new BorderLayout(0, 0));
		
		JLabel topListsImage = new JLabel();
		topListsImage.setIcon(new ImageIcon(BrowsePanel.class.getResource("")));
		topLists.add(topListsImage, BorderLayout.CENTER);
		
		JLabel topListLbl = new JLabel("<html>Top Lists</html>");
		topListLbl.setOpaque(true);
		topListLbl.setForeground(defaultTextClr);
		topListLbl.setBackground(primaryColor);
		topListLbl.setFont(proximaNova(subHeader));
		topListLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
		topListLbl.setHorizontalAlignment(SwingConstants.CENTER);
		topLists.add(topListLbl, BorderLayout.SOUTH);
		
		JPanel newReleases = new JPanel();
		newReleases.setBackground(secondaryColor);
		newReleases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		newReleases.setBorder(shadow);
		listContainer.add(newReleases);
		newReleases.setLayout(new BorderLayout(0, 0));
		
		JLabel newReleasesImage = new JLabel();
		newReleasesImage.setIcon(new ImageIcon(BrowsePanel.class.getResource("")));
		newReleases.add(newReleasesImage, BorderLayout.CENTER);
		
		JLabel newReleasesLbl = new JLabel("<html>New Releases</html>");
		newReleasesLbl.setOpaque(true);
		newReleasesLbl.setForeground(defaultTextClr);
		newReleasesLbl.setBackground(primaryColor);
		newReleasesLbl.setFont(proximaNova(subHeader));
		newReleasesLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
		newReleasesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		newReleases.add(newReleasesLbl, BorderLayout.SOUTH);
		
		JPanel foodTypeContainer = new JPanel();
		foodTypeContainer.setBackground(secondaryColor);
		superContainer.add(foodTypeContainer);
		foodTypeContainer.setLayout(new BorderLayout(0, 0));
		
		JPanel foodTypeHeader = new JPanel();
		foodTypeHeader.setBackground(secondaryColor);
		FlowLayout flowLayout = (FlowLayout) foodTypeHeader.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		foodTypeContainer.add(foodTypeHeader, BorderLayout.NORTH);
		
		JLabel typeHeader = new JLabel("<html>Food Types</html>");
		typeHeader.setFont(proximaNova(subHeader));
		foodTypeHeader.add(typeHeader);
		
		typeList = new JPanel();
		typeList.setBackground(secondaryColor);
		foodTypeContainer.add(typeList);
		typeList.setLayout(new GridLayout(4, 3, 15, 15));
		
		ArrayList<FoodType> foodTypeList = QueryDA.retrieveAllFoodType();
	    for (FoodType foodType : foodTypeList) {
	    	typeList.add(createFoodTypePanel(foodType.getFoodTypeName(), foodType.getImageLink()));
		 }
	  //Problem is with the method below
	}
	
	protected JPanel createFoodTypePanel(String name, String imageLink) {
		JPanel wrapper = new JPanel();
		wrapper.setBackground(CircleBgHvr);
		wrapper.setLayout(new BorderLayout(0, 0));
		
		JLabel typeImage = new JLabel();
		typeImage.setBorder(new EmptyBorder(10, 10, 10, 10));
		typeImage.setHorizontalAlignment(SwingConstants.CENTER);
		typeImage.setIcon(new ImageIcon(BrowsePanel.class.getResource(imageLink)));
		wrapper.add(typeImage, BorderLayout.CENTER);
			
		JLabel foodType = new JLabel(WordUtils.capitalize("<html>" + name + "</html>"));
		foodType.setFont(proximaNova(16f));
		foodType.setMaximumSize(new Dimension(200, 200));
		foodType.setBorder(new EmptyBorder(0, 0, 20, 0));
		foodType.setVerticalAlignment(SwingConstants.TOP);
		foodType.setHorizontalAlignment(SwingConstants.CENTER);
		wrapper.add(foodType, BorderLayout.SOUTH);
		
		wrapper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				foodType.setText(WordUtils.capitalize("<html><u>" + name + "</u></html>"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				foodType.setText(WordUtils.capitalize("<html>" + name + "</html>"));
			}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(checkClick(arg0) == true) {
//				JPanel contentPane = new IngredientPanel(myFrame, id);
//				myFrame.setContentPane(contentPane);
//				myFrame.setVisible(true);
			}
		}
	});
		
		return wrapper;
	}
}
