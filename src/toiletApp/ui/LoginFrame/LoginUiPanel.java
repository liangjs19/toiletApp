package toiletApp.ui.LoginFrame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Transparency;

import javax.swing.BorderFactory;
import javax.swing.FocusManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.border.DropShadowBorder;

import toiletApp.ui.MainFrame.ColorsPanel;

import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

// Make rounded corners


public class LoginUiPanel extends ColorsPanel {

	public Color secondaryColor = new Color(0x405952);
	protected Color topPanel = new Color(0xFF974F);
	protected Color defaultTextClr = new Color(0x76582B);
	protected Color TxtFCvr = new Color(0xE5E5E5);
	protected Color btnTextHover = new Color(0xFFFFFF);
	protected Color dullPeach = new Color(0xE3BC82);
	protected Color oskLabel = new Color(0x999999);
	private int xMouse, yMouse;
	
	protected Font header = new Font("Gotham Rounded Medium", Font.PLAIN, 42);
	protected Font loginDefaultFont = new Font("Gotham Rounded Light", Font.PLAIN, 18);
	protected Font footerFont = new Font("Gotham Rounded Light", Font.PLAIN, 14);
	/**
	 * Create the panel.
	 */
	public LoginUiPanel(JFrame loginFrame) {
				setLayout(null);
				setOpaque(false);
				
				JLabel closeBtn = new JLabel();
				closeBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						closeBtn.setIcon(new ImageIcon(LoginUiPanel.class.getResource("/screenDesign/images/closeBtnHover.png")));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						closeBtn.setIcon(new ImageIcon(LoginUiPanel.class.getResource("/screenDesign/images/closeBtn.png")));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
							loginFrame.dispose();
						}
					}
				});
				closeBtn.setIcon(new ImageIcon(LoginUiPanel.class.getResource("/screenDesign/images/closeBtn.png")));
				closeBtn.setBounds(317, 0, 40, 20);
				add(closeBtn);
				
				JLabel topOfFrame = new JLabel();
				topOfFrame.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						xMouse = e.getX();
						yMouse = e.getY();
					}
				});
				topOfFrame.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						int x = e.getXOnScreen();
						int y = e.getYOnScreen();
						
						loginFrame.setLocation(x - xMouse, y - yMouse);
					}
				});
				topOfFrame.setBounds(0, 0, 287, 20);
				add(topOfFrame);
				
				JLabel minizmizeIcon = new JLabel("");
				minizmizeIcon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
							loginFrame.setState(loginFrame.ICONIFIED);
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						minizmizeIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/screenDesign/images/minimizeBtnHover.png")));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						minizmizeIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/screenDesign/images/minimizeBtn.png")));
					}
				});
				minizmizeIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/screenDesign/images/minimizeBtn.png")));
				minizmizeIcon.setBounds(287, 0, 30, 20);
				add(minizmizeIcon);

	}

}
