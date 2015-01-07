package toiletApp.ui.LoginFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class loginFrame extends JFrame {

	private JFrame loginFrame;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private Color LoginPanel = new Color(0xFFD393);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginFrame() {
		setTitle("Placeholder");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 600);
        setShape(new RoundRectangle2D.Double(0, 0, 360, 600, 15, 15));
		contentPane_1 = new LoginPanel(this);
		contentPane_1.setBackground(LoginPanel);
		setContentPane(contentPane_1);
		setResizable(false);
		setLocationRelativeTo(null);
	}

}
