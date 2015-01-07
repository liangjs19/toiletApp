package toiletApp.ui.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class JCirclePanel extends JPanel {

	private double diameterX;
	private double diameterY;

	@Override
	protected void paintComponent(Graphics g) {

		   super.paintComponent(g);
		   Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		   // Assume x, y, and diameter are instance variables.
		   Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, g.getClipBounds().width, g.getClipBounds().height);
		   g2d.fill(circle);
		   ui.update(g, this);
	}
}
