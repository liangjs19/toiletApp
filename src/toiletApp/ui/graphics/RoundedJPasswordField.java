package toiletApp.ui.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;

public class RoundedJPasswordField extends JPasswordField {

	private Shape shape;
    public RoundedJPasswordField(int size) {
        super(size);
        setOpaque(false);
    }
    
    //Paints background component
    protected void paintComponent(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
    }
    
    //Paints border 
    protected void paintBorder(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
    
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
         
    }
}
