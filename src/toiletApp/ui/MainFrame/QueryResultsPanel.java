package toiletApp.ui.MainFrame;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import toiletApp.dataAccess.DBController;
import toiletApp.dataAccess.QueryDA;
import toiletApp.entity.Ingredient;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

public class QueryResultsPanel extends MasterPanel {
	private List<JPanel> panels = new ArrayList<JPanel>();
	
	DBController db = new DBController();
	
	private javax.swing.JPanel container, queryHeader, contentContainer, foodContainer, foodItems, ingredientContainer, ingredientItems;
	private javax.swing.JLabel queryHeaderLbl, foodHeader, ingredientHeader;
	/**
	 * Create the panel.
	 */
	public QueryResultsPanel(JFrame mf, String searchFieldValue) {
		super(mf);
		
		//Scrollpane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(20);
		add(scrollPane);
		
		//Container panel
		container = new JPanel();
		scrollPane.setViewportView(container);
		container.setLayout(new BorderLayout(0, 0));
		
		queryHeader = new JPanel();
		FlowLayout flowLayout = (FlowLayout) queryHeader.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		queryHeader.setBackground(secondaryColor);
		queryHeader.setBorder(new CompoundBorder(new EmptyBorder(10, 15, 15, 25), BorderFactory.createMatteBorder(0, 0, 3, 0, CircleBgHvr)));
		container.add(queryHeader, BorderLayout.NORTH);
		
		queryHeaderLbl = new JLabel("<html>Showing Results for " + searchFieldValue + ".</html>");
		queryHeaderLbl.setFont(proximaNova(subHeader));
		queryHeader.add(queryHeaderLbl);
		
		contentContainer = new JPanel();
		container.add(contentContainer, BorderLayout.CENTER);
		contentContainer.setLayout(new GridLayout(2, 0, 0, 0));
		
		foodContainer = new JPanel();
		foodContainer.setBorder(new EmptyBorder(0, 15, 15, 25));
		foodContainer.setBackground(secondaryColor);
		contentContainer.add(foodContainer);
		foodContainer.setLayout(new BorderLayout(0, 0));
		
		foodHeader = new JLabel("<html>Food</html>");
		foodHeader.setFont(proximaNova(subHeader));
		foodContainer.add(foodHeader, BorderLayout.NORTH);
		
		foodItems = new JPanel();
		foodItems.setBackground(secondaryColor);
		foodContainer.add(foodItems, BorderLayout.CENTER);
		foodItems.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
	    
		ingredientContainer = new JPanel();
		ingredientContainer.setBorder(new EmptyBorder(10, 15, 15, 25));
		ingredientContainer.setBackground(secondaryColor);
		contentContainer.add(ingredientContainer);
		ingredientContainer.setLayout(new BorderLayout(0, 0));
		
		ingredientHeader = new JLabel("<html>Ingredients</html>");
		ingredientHeader.setFont(proximaNova(subHeader));
		ingredientContainer.add(ingredientHeader, BorderLayout.NORTH);
		
		ingredientItems = new JPanel();
		ingredientItems.setBackground(secondaryColor);
		ingredientContainer.add(ingredientItems, BorderLayout.CENTER);
		ingredientItems.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		ArrayList<Ingredient> ingredientList = QueryDA.retrieveIngredientsByName(searchFieldValue);
	    for (Ingredient ingredient : ingredientList) {
	    	ingredientItems.add(createPanel(ingredient.getName(), ingredient.getImageLink(), ingredient.getId()));
		 }
		
	}
}
