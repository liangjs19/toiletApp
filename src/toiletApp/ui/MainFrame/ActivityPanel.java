package toiletApp.ui.MainFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ActivityPanel extends MasterPanel {

	/**
	 * Create the panel.
	 */
	public ActivityPanel(JFrame mf) {
		super(mf);
		setLayout(null);
		
		JLabel contentPaneBg = new JLabel();
		contentPaneBg.setBackground(secondaryColor);
		contentPaneBg.setOpaque(true);
		contentPaneBg.setBounds(150, 75, 874, 682);
		add(contentPaneBg);
	}

}
