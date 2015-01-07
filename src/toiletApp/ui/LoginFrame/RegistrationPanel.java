package toiletApp.ui.LoginFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

import toiletApp.ui.graphics.RoundedJPasswordField;
import toiletApp.ui.graphics.RoundedJTextField;

public class RegistrationPanel extends LoginUiPanel {

	private Color LoginPanel = new Color(0xFFD393);
	private int xMouse, yMouse;
	/**
	 * Create the panel.
	 */
	public RegistrationPanel(JFrame loginFrame) {
		super(loginFrame);
		setLayout(null);
		
		//Heading
		JLabel lblRegistration = new JLabel("<html>Registration</html>");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setForeground(secondaryColor);
		lblRegistration.setFont(proximaNova(42f));
		lblRegistration.setBounds(0, 21, 360, 56);
		add(lblRegistration);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, dullPeach));
		separator.setBounds(0, 75, 360, 5);
		add(separator);
		
		//User name label
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(0, 88, 360, 23);
		lblUserName.setFont(loginDefaultFont);
		add(lblUserName);
				
		//User name text field
		JTextField usernameField = new RoundedJTextField(0);
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				usernameField.setBackground(Color.WHITE);
			}
			@Override
			public void focusLost(FocusEvent e) {
				usernameField.setBackground(TxtFCvr);
			}
		});
		usernameField.setBackground(TxtFCvr);
		usernameField.setBorder(
				   javax.swing.BorderFactory.createCompoundBorder(
						      javax.swing.BorderFactory.createTitledBorder(
						         null, "Border Title",
						         javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						         javax.swing.border.TitledBorder.DEFAULT_POSITION,
						         new java.awt.Font("Montserrat", 0, 5)
						      ),
						      javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 40)
						   )
						);
		usernameField.setBounds(30, 122, 300, 40);
		usernameField.setPreferredSize(new Dimension(100, 30));
		usernameField.setFont(loginDefaultFont);
		add(usernameField);
		
		//Password label
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(0, 173, 360, 23);
		lblPassword.setFont(loginDefaultFont);
		add(lblPassword);
	
		//Password text field
		JPasswordField passwordField = new RoundedJPasswordField(0);
		passwordField.setBackground(TxtFCvr);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				passwordField.setBackground(Color.WHITE);
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordField.setBackground(TxtFCvr);
			}
		});
		passwordField.setBorder(
				   javax.swing.BorderFactory.createCompoundBorder(
						      javax.swing.BorderFactory.createTitledBorder(
						         null, "Border Title",
						         javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						         javax.swing.border.TitledBorder.DEFAULT_POSITION,
						         new java.awt.Font("Montserrat", 0, 5)
						      ),
						      javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 40)
						   )
						);
		passwordField.setBounds(30, 207, 300, 40);
		passwordField.setPreferredSize(new Dimension(150, 30));
		passwordField.setFont(loginDefaultFont);
		add(passwordField);
		
		
		//Confirm Password text field
		JPasswordField cfmPasswordField = new RoundedJPasswordField(0);
		cfmPasswordField.setBackground(TxtFCvr);
		cfmPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				cfmPasswordField.setBackground(Color.WHITE);
			}
			@Override
			public void focusLost(FocusEvent e) {
				cfmPasswordField.setBackground(TxtFCvr);
			}
		});
		cfmPasswordField.setBorder(
				   javax.swing.BorderFactory.createCompoundBorder(
						      javax.swing.BorderFactory.createTitledBorder(
						         null, "Border Title",
						         javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						         javax.swing.border.TitledBorder.DEFAULT_POSITION,
						         new java.awt.Font("Montserrat", 0, 5)
						      ),
						      javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 40)
						   )
						);
		cfmPasswordField.setBounds(30, 292, 300, 40);
		cfmPasswordField.setPreferredSize(new Dimension(150, 30));
		cfmPasswordField.setFont(loginDefaultFont);
		add(cfmPasswordField);
		
		//OSK
		/**JLabel triggerOSK = new JLabel("<html><font face=\"FontAwesome\" style=\"text-align: center; font-size: 18px;\">\uf11c</font> On Screen Keyboard</html>");
		triggerOSK.setToolTipText("On Screen Keyboard");
		triggerOSK.setFont(loginDefaultFont);
		triggerOSK.setHorizontalAlignment(SwingConstants.CENTER);
		triggerOSK.setForeground(oskLabel);
		triggerOSK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("cmd /c C:\\Windows\\System32\\osk.exe");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				triggerOSK.setForeground(oskLabel);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				triggerOSK.setForeground(Color.BLACK);
			}
			triggerOSK.setBounds(30, 549, 300, 40);
			add(triggerOSK);
		});*/
		
		JLabel submitBtn = new JLabel();
		submitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				submitBtn.setIcon(new ImageIcon(RegistrationPanel.class.getResource("/screenDesign/images/submitBtnHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				submitBtn.setIcon(new ImageIcon(RegistrationPanel.class.getResource("/screenDesign/images/submitBtn.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
					
				}
			}
		});
		submitBtn.setIcon(new ImageIcon(RegistrationPanel.class.getResource("/screenDesign/images/submitBtn.png")));
		submitBtn.setBounds(105, 488, 150, 50);
		add(submitBtn);
		
		JLabel lblConfirmYourPassword = new JLabel("Confirm your password");
		lblConfirmYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmYourPassword.setFont(loginDefaultFont);
		lblConfirmYourPassword.setBounds(0, 258, 360, 23);
		add(lblConfirmYourPassword);
		
		//Background
		JLabel background = new JLabel();
		background.setBackground(LoginPanel);
		background.setOpaque(true);
		background.setBounds(0, 0, 360, 600);
		add(background);
	
	}
}
