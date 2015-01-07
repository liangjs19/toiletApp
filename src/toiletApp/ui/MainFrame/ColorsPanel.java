package toiletApp.ui.MainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5758392775883588537L;

	public Color CircleBgClr = new Color(0xFFD393);
	public Color profilePanelTxtClr = new Color(0x000000);
	public Color contentTextClr = new Color(0x454545);
	public Color searchBarCvr = new Color(0xE5E5E5);
	public Color vibrantOrange = new Color(0xFF974F);
	public Color defaultTextClr = new Color(0xFFFFFF);
	public Color btnHover = new Color(0xFF7A23);
	public Color btnTextHover = new Color(0x76582B);
	public Color secondaryColor = new Color(0xFFD393);
	public Color CircleBgHvr = new Color(0xE3BC82);
	public Color sideBar = new Color(0x9C9B7A);
	public Color primaryColor = new Color(0x405952);
	public Font contentFont = new Font("Verdena", Font.PLAIN, 14);
	
	protected float size = 14f, 
			subHeader = 20f,
			header = 32f,
			superHeader = 48f;
	/**
	 * Create the panel.
	 */
	public ColorsPanel() {
	}

	public static Font proximaNova(Float size) {
		Font font = null;

		InputStream is = ColorsPanel.class.getResourceAsStream("/toiletApp/font/ProximaNova-Regular.otf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Font proximaNova = font.deriveFont(size);
		return proximaNova;
	}
	
	public static Font fontAwesome(Float size) {
		Font font = null;

		InputStream is = ColorsPanel.class.getResourceAsStream("/toiletApp/font/FontAwesome.otf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Font fontAwesome = font.deriveFont(size);
		return fontAwesome;
	}
	
	public static Font header() {
		
		Font font = null;
		InputStream is = ColorsPanel.class.getResourceAsStream("/toiletApp/font/ProximaNova-Regular.otf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Font header = font.deriveFont(32f);
		return header;
	}
}
