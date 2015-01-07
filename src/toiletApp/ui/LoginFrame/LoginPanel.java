package toiletApp.ui.LoginFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import toiletApp.ui.MainFrame.MainFrame;
import toiletApp.ui.graphics.RoundedJPasswordField;
import toiletApp.ui.graphics.RoundedJTextField;

public class LoginPanel extends LoginUiPanel {

	protected float size = 14f, 
			subHeader = 20f,
			header = 32f,
			bigHeader = 48f;
	/**
	 * Create the panel.
	 */
	public LoginPanel(JFrame loginFrame) {
		super(loginFrame);
		setOpaque(false);
		JLabel triggerOSK = new JLabel("<html>\uf11c</html>");
		triggerOSK.setFont(fontAwesome(24f));
		triggerOSK.setToolTipText("On Screen Keyboard");
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
				triggerOSK.setForeground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				triggerOSK.setForeground(oskLabel);
			}
		});
		triggerOSK.setVisible(false);
		triggerOSK.setBounds(280, 230, 50, 40);
		add(triggerOSK);
		
		JLabel triggerOSK2 = new JLabel("<html>\uf11c</html>");
		triggerOSK2.setFont(fontAwesome(24f));
		triggerOSK2.setToolTipText("On Screen Keyboard");
		triggerOSK2.addMouseListener(new MouseAdapter() {
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
				triggerOSK2.setForeground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				triggerOSK2.setForeground(oskLabel);
			}
		});
		triggerOSK2.setVisible(false);
		triggerOSK2.setForeground(oskLabel);
		triggerOSK2.setHorizontalAlignment(SwingConstants.CENTER);
		triggerOSK2.setBounds(280, 315, 50, 40);
		add(triggerOSK2);
		
		JLabel lblPlaceholder = new JLabel();
		lblPlaceholder.setIcon(new ImageIcon(LoginUiPanel.class.getResource("/screenDesign/images/loginAppName.png")));
		lblPlaceholder.setBounds(0, 75, 360, 125);
		add(lblPlaceholder);
		
		//User name label
		JLabel lblUserName = new JLabel("<html>Username</html>");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(0, 205, 360, 23);
		lblUserName.setFont(proximaNova(subHeader));
		add(lblUserName);
	
		//User name text field
		JTextField usernameField = new RoundedJTextField(0);
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				usernameField.setBackground(Color.WHITE);
				triggerOSK.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				usernameField.setBackground(TxtFCvr);
				triggerOSK.setVisible(false);
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
		usernameField.setBounds(30, 230, 300, 40);
		usernameField.setPreferredSize(new Dimension(100, 30));
		usernameField.setFont(proximaNova(subHeader));
		add(usernameField);
		
		//Password label
		JLabel lblPassword = new JLabel("<html>Password</html>");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(0, 290, 360, 23);
		lblPassword.setFont(proximaNova(subHeader));
		add(lblPassword);
		
		//Password text field
		JPasswordField passwordField = new RoundedJPasswordField(0);
		passwordField.setBackground(TxtFCvr);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				passwordField.setBackground(Color.WHITE);
				triggerOSK2.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordField.setBackground(TxtFCvr);
				triggerOSK2.setVisible(false);
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
		passwordField.setBounds(30, 315, 300, 40);
		passwordField.setPreferredSize(new Dimension(150, 30));
		passwordField.setFont(proximaNova(subHeader));
		add(passwordField);
		
		//Login Button
		JLabel lblLogin = new JLabel();
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLogin.setIcon(new ImageIcon(LoginUiPanel.class.getResource("/screenDesign/images/loginBtnHover.png")));
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogin.setIcon(new ImageIcon(LoginUiPanel.class.getResource("/screenDesign/images/loginBtn.png")));
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		    public void mouseClicked(MouseEvent e) {
		    	if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
		    		loginFrame.setVisible(false);
		    		loginFrame.dispose();
		    		JFrame MainFrame = new JFrame();
		    		new MainFrame();
		    	}
		    }  
		});
		lblLogin.setIcon(new ImageIcon(LoginUiPanel.class.getResource("/screenDesign/images/loginBtn.png")));
		lblLogin.setBounds(100, 420, 150, 50);
		setOpaque(true);
		lblLogin.setBackground(dullPeach);
		add(lblLogin);
		
		//Separators
		JSeparator fieldSeparator = new JSeparator();
		fieldSeparator.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, dullPeach));
		fieldSeparator.setBounds(0, 170, 360, 5);
		add(fieldSeparator);
		
		//Forgot password
		JLabel lblForgotYourPassword = new JLabel("<html>Forgot your password?</html>");
		lblForgotYourPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblForgotYourPassword.setText("<html><u>Forgot your password?</u></html>");
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblForgotYourPassword.setText("<html>Forgot your password?</html>");
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblForgotYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotYourPassword.setFont(footerFont);
		lblForgotYourPassword.setBounds(90, 525, 170, 15);
		add(lblForgotYourPassword);
		
		JLabel lblNotAUser = new JLabel("<html>Not a user?</html>");
		lblNotAUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotAUser.setBounds(95, 545, 90, 14);
		lblNotAUser.setFont(footerFont);
		add(lblNotAUser);
		
		JLabel lblSignUp = new JLabel("<html>Sign up</html>");
		lblSignUp.setHorizontalAlignment(SwingConstants.LEFT);
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblSignUp.setText("<html><u>Sign up</u></html>");
				setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignUp.setText("<html>Sign up</html>");
				setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
					JPanel contentPane = new RegistrationPanel(loginFrame);
					loginFrame.setContentPane(contentPane);
					loginFrame.setVisible(true);
				}
			}
		});
		lblSignUp.setBounds(190, 545, 60, 15);
		lblSignUp.setFont(footerFont);
		add(lblSignUp);
		
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(LoginUiPanel.class.getResource("/screenDesign/images/Logo.png")));
		label.setBounds(100, 21, 150, 80);
		add(label);
	}

}
