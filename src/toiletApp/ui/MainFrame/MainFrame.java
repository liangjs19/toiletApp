package toiletApp.ui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame myFrame;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				}  catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		Color dullPeach = new Color(0xFFD393);
		
		myFrame = this;
		this.setTitle("Placeholder");
		//this.setIconImage(new ImageIcon(""));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new BrowsePanel(this);
		this.setContentPane(contentPane);
		this.setBounds(0, 0, 1024, 768);
		this.setMinimumSize(new Dimension(1024, 768));
		//contentPane.setBackground(dullPeach);
		this.setResizable(true);
		//this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.pack();
		//setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		//Toolkit fullScreen = Toolkit.getDefaultToolkit();
			//int xsize = (int) fullScreen.getScreenSize().getWidth();
			//int ysize = (int) fullScreen.getScreenSize().getHeight();
		//this.setSize(xsize, ysize);
	}
	
}

class MyComponent extends JComponent {

	  public void paint(Graphics g) {
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
	 }
}
