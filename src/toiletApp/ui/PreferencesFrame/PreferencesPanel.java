package toiletApp.ui.PreferencesFrame;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toiletApp.ui.MainFrame.ColorsPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PreferencesPanel extends ColorsPanel {
	
	public Color primaryColorHighLight = new Color(0xBD9C6D);
	
	public Font gthRndLight = new Font("Gotham Rounded Light", Font.PLAIN, 12);
	private String iconFontSize = "font-size: 18px;";
	/**
	 * Create the panel.
	 */
	
	
	//Let user make their own color scheme as well
	public PreferencesPanel(JFrame pFrame) {
		setLayout(null);
		
		JPanel preferenceBtn = new JPanel();
		preferenceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				preferenceBtn.setBackground(primaryColorHighLight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				preferenceBtn.setBackground(primaryColor);
			}
		});
		preferenceBtn.setBounds(10, 10, 180, 40);
		preferenceBtn.setBackground(primaryColor);
		add(preferenceBtn);
			preferenceBtn.setLayout(null);
		
			JLabel preferenceBtnIcon = new JLabel();
			preferenceBtnIcon.setBounds(11, 5, 29, 30);
			preferenceBtn.add(preferenceBtnIcon);
			preferenceBtnIcon.setForeground(defaultTextClr);
			preferenceBtnIcon.setHorizontalAlignment(SwingConstants.LEFT);
			preferenceBtnIcon.setText("<html><font face=\"FontAwesome\"><p style=\"text-align: center;" + iconFontSize + "\"> \uf1fc</p></font></html>");
			
			JLabel preferenceBtnText = new JLabel("Preference Settings");
			preferenceBtnText.setBounds(45, 15, 126, 13);
			preferenceBtn.add(preferenceBtnText);
			preferenceBtnText.setFont(gthRndLight);
			preferenceBtnText.setForeground(defaultTextClr);
			preferenceBtnText.setHorizontalAlignment(SwingConstants.LEFT);
			
		JPanel searchBtn = new JPanel();
		searchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				searchBtn.setBackground(primaryColorHighLight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchBtn.setBackground(primaryColor);
			}
		});
		searchBtn.setBounds(10, 55, 180, 40);
		searchBtn.setBackground(primaryColor);
		add(searchBtn);
			searchBtn.setLayout(null);
		
			JLabel searchBtnIcon = new JLabel();
			searchBtnIcon.setBounds(10, 5, 27, 30);
			searchBtn.add(searchBtnIcon);
			searchBtnIcon.setForeground(defaultTextClr);
			searchBtnIcon.setHorizontalAlignment(SwingConstants.LEFT);
			searchBtnIcon.setText("<html><font face=\"FontAwesome\"><p style=\"text-align: center;" + iconFontSize + "\"> \uf002</p></font></html>");
			
			JLabel searchBtnText = new JLabel("Search Settings");
			searchBtnText.setBounds(45, 15, 99, 13);
			searchBtn.add(searchBtnText);
			searchBtnText.setFont(gthRndLight);
			searchBtnText.setForeground(defaultTextClr);
			searchBtnText.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel container = new JPanel();
		container.setBounds(195, 10, 580, 565);
		add(container);
		container.setLayout(null);
		
		JLabel containerBg = new JLabel();
		containerBg.setBackground(primaryColor);
		containerBg.setOpaque(true);
		containerBg.setBounds(0, 0, 585, 590);
		container.add(containerBg);
			
		JLabel contentPaneBg = new JLabel();
		contentPaneBg.setBounds(0, 0, 790, 586);
		contentPaneBg.setOpaque(true);
		contentPaneBg.setBackground(secondaryColor);
		add(contentPaneBg);
	}
}
