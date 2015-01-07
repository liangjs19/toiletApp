package toiletApp.ui.MainFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TutorialsPanel extends MasterPanel {

	/**
	 * Create the panel.
	 */
	public TutorialsPanel(JFrame mf) {
		super(mf);
		setLayout(null);
		
		JLabel contentPaneBg = new JLabel();
		contentPaneBg.setIcon(new ImageIcon(TutorialsPanel.class.getResource("/screenDesign/images/instructions.png")));
		contentPaneBg.setBackground(secondaryColor);
		contentPaneBg.setOpaque(true);
		contentPaneBg.setBounds(150, 75, 874, 693);
		add(contentPaneBg);
		
		JLabel ingredientsBtn = new JLabel();
		ingredientsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPaneBg.setIcon(new ImageIcon(TutorialsPanel.class.getResource("/screenDesign/images/ingredients.jpeg")));
			}
		});
		ingredientsBtn.setBounds(390, 470, 175, 60);
		add(ingredientsBtn);
		
		JLabel instructionsBtn = new JLabel();
		instructionsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPaneBg.setIcon(new ImageIcon(TutorialsPanel.class.getResource("/screenDesign/images/instructions.png")));
			}
		});
		instructionsBtn.setBounds(645, 470, 175, 60);
		add(instructionsBtn);
	}

}
