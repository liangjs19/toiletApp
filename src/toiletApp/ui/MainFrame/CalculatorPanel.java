package toiletApp.ui.MainFrame;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.JPanel;

import org.jdesktop.swingx.border.DropShadowBorder;

import java.awt.BorderLayout;
import java.awt.Color;

public class CalculatorPanel extends JWindow {

	/**
	 * Create the panel.
	 */
	public CalculatorPanel() {
		setBounds(60, 60, 100, 100);
		setVisible(true);
		((JComponent) getContentPane()).setOpaque(false);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		 DropShadowBorder shadow = new DropShadowBorder();
	        shadow.setShadowColor(Color.BLACK);
	        shadow.setShowLeftShadow(true);
	        shadow.setShowRightShadow(true);
	        shadow.setShowBottomShadow(true);
	        shadow.setShowTopShadow(true);
	        panel.setBorder(shadow);
	}

	public static void main(String[] args) {
		new CalculatorPanel();
	}
}
