package toiletApp.ui.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JApplet;

public class RoundedButton {

	public RoundedButton(int x, int y, int width, int height, int roundedCorners, int nextRoundedCorners, Color primaryColor) {
		Graphics g = null;
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setPaint(primaryColor);
        g2.setStroke(new BasicStroke(2.0f));
        
        g2.draw(new RoundRectangle2D.Double(x, y, width, height, roundedCorners, nextRoundedCorners));
	}
}
