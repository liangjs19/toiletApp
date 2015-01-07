package toiletApp.Garbage;

import javax.swing.JPanel;
import javax.swing.JLabel;

import toiletApp.entity.Ingredient;
import toiletApp.ui.MainFrame.ColorsPanel;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.xml.transform.Result;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemPanel extends ColorsPanel {

	/**
	 * Create the panel.
	 */
	public ItemPanel() {
		Ingredient ingredient;
		JPanel container = new JPanel();
		container.setBounds(0, 0, 200, 240);
		container.setLayout(new BorderLayout(0, 0));

		JLabel image = new JLabel();
		image.setIcon(new ImageIcon(ItemPanel.class.getResource("/screenDesign/images/englishCuisineClipedMask.png"))); //mysql BLOB datatype for img
		container.add(image, BorderLayout.CENTER);
		
		JLabel itemName = new JLabel("Chicken");
		itemName.setVerticalAlignment(SwingConstants.TOP);
		itemName.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemName.setBackground(Color.BLACK);
		itemName.setForeground(Color.WHITE);
		itemName.setOpaque(true);
		container.add(itemName, BorderLayout.SOUTH);
	}

}
