/*
 * This class creates the second Concept Frame out of 3 which displays
 * information with graphics to help the user learn the content
 * 
 * The comments are the same as the ones in ConceptFrame1
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.*;

public class ConceptFrame2 extends JFrame {
	
	
	public ConceptFrame2(){
		super("Concepts Frame 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLayeredPane mainPanel = new JLayeredPane();
		
		ImageIcon background = new ImageIcon("files/conceptframe2.png");
		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setSize(background.getIconWidth(),background.getIconHeight());
		
		ImageIcon stepCode = new ImageIcon("files/logo.png");
		JButton stepCodeButton = new JButton(stepCode);
		buttonTransparent(stepCodeButton);
		stepCodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new MainFrame();
				dispose();
			}
		});
		stepCodeButton.setBounds(32, 24, stepCode.getIconWidth(), stepCode.getIconHeight());
		
		ImageIcon practice = new ImageIcon("files/practicebutton.png");
		JButton practiceButton = new JButton(practice);
		buttonTransparent(practiceButton);
		practiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new ActivityFrame();
				dispose();
			}
		});
		practiceButton.setBounds(361, 43, practice.getIconWidth(), practice.getIconHeight());
		
		ImageIcon assess = new ImageIcon("files/assessbutton.png");
		JButton assessButton = new JButton(assess);
		buttonTransparent(assessButton);
		assessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new TestFrame();
				dispose();
			}
		});
		assessButton.setBounds(493, 43, assess.getIconWidth(), assess.getIconHeight());
		
		ImageIcon learning = new ImageIcon("files/startlearning.png");
		JButton learningButton = new JButton(learning);
		buttonTransparent(learningButton);
		learningButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new ConceptFrame1();
				dispose();
			}
		});
		learningButton.setBounds(609, 43, learning.getIconWidth(), learning.getIconHeight());
		
		ImageIcon page1 = new ImageIcon("files/1button.png");
		JButton page1Button = new JButton(page1);
		buttonTransparent(page1Button);
		page1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new ConceptFrame1();
				dispose();
			}
		});
		page1Button.setBounds(52, 195, page1.getIconWidth(), page1.getIconHeight());
		
		ImageIcon page2 = new ImageIcon("files/2buttongreen.png");
		JButton page2Button = new JButton(page2);
		buttonTransparent(page2Button);
		page2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new ConceptFrame2();
				dispose();
			}
		});
		page2Button.setBounds(257, 195, page2.getIconWidth(), page2.getIconHeight());
		
		ImageIcon page3 = new ImageIcon("files/3button.png");
		JButton page3Button = new JButton(page3);
		buttonTransparent(page3Button);
		page3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new ConceptFrame3();
				dispose();
			}
		});
		page3Button.setBounds(511, 195, page3.getIconWidth(), page3.getIconHeight());
		
		// Create the image icon and label for the typing GIF in Concept Frame 2
		ImageIcon typing2 = new ImageIcon("files/page2typing.gif");
		JLabel page2Typing = new JLabel(typing2);
		// Size and position of the GIF is set
		page2Typing.setBounds(456, 471, typing2.getIconWidth(), typing2.getIconHeight());
		
		ImageIcon nextPage = new ImageIcon("files/nextpage.png");
		JButton nextPageButton = new JButton(nextPage);
		buttonTransparent(nextPageButton);
		nextPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new ConceptFrame3();
				dispose();
			}
		});
		nextPageButton.setBounds(314, 1785, nextPage.getIconWidth(), nextPage.getIconHeight());
		
		mainPanel.add(backgroundLabel, Integer.valueOf(0));
		mainPanel.add(practiceButton, Integer.valueOf(1));
		mainPanel.add(assessButton, Integer.valueOf(1));
		mainPanel.add(learningButton, Integer.valueOf(1));
		mainPanel.add(stepCodeButton, Integer.valueOf(1));
		mainPanel.add(page1Button, Integer.valueOf(1));
		mainPanel.add(page2Button, Integer.valueOf(1));
		mainPanel.add(page3Button, Integer.valueOf(1));
		mainPanel.add(page2Typing, Integer.valueOf(1));
		mainPanel.add(nextPageButton, Integer.valueOf(1));
		
		JScrollPane scr = new JScrollPane(mainPanel);
		scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scr.getVerticalScrollBar().setUnitIncrement(16);
		
		mainPanel.setPreferredSize(new Dimension(background.getIconWidth(), background.getIconHeight()));
		getContentPane().add(scr);

		setResizable(false);
		setSize(830, 600);
		setVisible(true);
	}
	
	public void buttonTransparent(JButton button) {
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
