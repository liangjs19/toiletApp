package toiletApp.ui.PreferencesFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PreferencesFrame extends JFrame {

	private JFrame pFrame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreferencesFrame frame = new PreferencesFrame();
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
	public PreferencesFrame() {
		Color dullPeach = new Color(0xFFD393);
		
		setTitle("PlaceHolder - Preferences");
		//setIconImage(new ImageIcon(""));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 610);
		setMinimumSize(new Dimension(790, 610));
		contentPane = new PreferencesPanel(this);
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);	
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		pack();
	}

}
