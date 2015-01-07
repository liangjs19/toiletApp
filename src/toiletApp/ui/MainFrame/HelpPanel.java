package toiletApp.ui.MainFrame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import toiletApp.ui.MainFrame.MasterPanel;

public class HelpPanel extends MasterPanel {

	/**
	 * Create the panel.
	 */
	public HelpPanel(JFrame mf) {
		super(mf);
		
		JLabel cuisineHeader = new JLabel("<html><font face=\"FontAwesome\" style=\"text-align: center; font-size: 32px;\">\uf059</font> Help</html>");
		cuisineHeader.setFont(header());
		cuisineHeader.setForeground(contentTextClr);
		cuisineHeader.setBounds(210, 100, 156, 62);
		add(cuisineHeader);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, CircleBgHvr));
		separator.setBounds(210, 159, 750, 3);
		add(separator);
		
		JLabel helpText = new JLabel("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "<br></br>Nullam maximus pellentesque tortor sit amet dapibus. "
				+ "<br></br>Sed tempor, quam eu interdum aliquam, libero enim ultrices est, vitae dapibus felis leo in ligula. "
				+ "<br></br>Ut malesuada nulla eget nisl maximus mattis. Nam quis purus est. Maecenas sit amet dignissim velit. "
				+ "<br></br>Quisque arcu sapien, consectetur eu dui at, vulputate tincidunt purus. "
				+ "<br></br>Etiam malesuada quis lacus non suscipit. Nulla facilisi.</html>");
		helpText.setVerticalAlignment(SwingConstants.TOP);
		helpText.setFont(proximaNova(12f));
		helpText.setBounds(210, 190, 750, 543);
		add(helpText);
		
		//Background
		JLabel contentPaneBg = new JLabel();
		contentPaneBg.setBackground(secondaryColor);
		contentPaneBg.setOpaque(true);
		contentPaneBg.setBounds(150, 75, 874, 695);
		add(contentPaneBg);
	}
}
