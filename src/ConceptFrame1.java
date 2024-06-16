/*
 * This class creates the first Concept Frame out of 3 which displays
 * information with graphics to help the user learn the content
 */

// Import all required classes
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.imageio.ImageIO;
import javax.imageio.ImageIO;
import javax.swing.*;

// Create the class
public class ConceptFrame1 extends JFrame {
	public ConceptFrame1(){
		// Add name for frame
		super("Concepts Frame 1");
		// Set default close opeartion to close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create the main panel as a JLayeredPane what we'll be using
		JLayeredPane mainPanel = new JLayeredPane();
		
		// Create the background image icon and JLabel
		ImageIcon background = new ImageIcon("files/conceptframe1.png");
		JLabel backgroundLabel = new JLabel(background);
		// Set the size of the background label
		backgroundLabel.setSize(background.getIconWidth(),background.getIconHeight());
		
		// Create the "stepCode" image icon and button
		ImageIcon stepCode = new ImageIcon("files/logo.png");
		JButton stepCodeButton = new JButton(stepCode);
		// Make the button transparent using method
		buttonTransparent(stepCodeButton);
		// Give the button a function
		stepCodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound plays
				GUIApplication.playButton();
				// A new Main Frame is created
				new MainFrame();
				// The current frame is closed
				dispose();
			}
		});
		// The size and position of the "stepCode" button is set
		stepCodeButton.setBounds(32, 24, stepCode.getIconWidth(), stepCode.getIconHeight());
		
		// Same comments as above but this is the practice button
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
		
		// Same comments as above but this is the assess button
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
		
		// Same comments as above but this is the assess button
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
		
		// Create the page 1 image icon and button
		ImageIcon page1 = new ImageIcon("files/1button.png");
		JButton page1Button = new JButton(page1);
		// Make button transparent
		buttonTransparent(page1Button);
		// Add function to button
		page1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound plays
				GUIApplication.playButton();
				// A new ConceptFrame1 is created
				new ConceptFrame1();
				// The current frame is closed
				dispose();
			}
		});
		// The size and position of the page 1 button is set
		page1Button.setBounds(52, 195, page1.getIconWidth(), page1.getIconHeight());
		
		// Same comments as above but this button leads to the second concept frame
		ImageIcon page2 = new ImageIcon("files/2button.png");
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
		
		// Same comments as above but this button leads to the third concept frame
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
		
		// Create  the next page image icon and button
		ImageIcon nextPage = new ImageIcon("files/nextpage.png");
		JButton nextPageButton = new JButton(nextPage);
		// Make button transparent using method
		buttonTransparent(nextPageButton);
		// Add function to button
		nextPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound plays
				GUIApplication.playButton();
				// A new ConceptFrame2 is created
				new ConceptFrame2();
				// The current frame is closed
				dispose();
			}
		});
		// The size and position of the next page button is set
		nextPageButton.setBounds(313, 1856, nextPage.getIconWidth(), nextPage.getIconHeight());
		
		// Add all the labels and buttons created above to the main panel
		mainPanel.add(backgroundLabel, Integer.valueOf(0));
		mainPanel.add(practiceButton, Integer.valueOf(1));
		mainPanel.add(assessButton, Integer.valueOf(1));
		mainPanel.add(learningButton, Integer.valueOf(1));
		mainPanel.add(stepCodeButton, Integer.valueOf(1));
		mainPanel.add(page1Button, Integer.valueOf(1));
		mainPanel.add(page2Button, Integer.valueOf(1));
		mainPanel.add(page3Button, Integer.valueOf(1));
		mainPanel.add(nextPageButton, Integer.valueOf(1));
		
		// Create the scroll pane that displays the main panel
		JScrollPane scr = new JScrollPane(mainPanel);
		// Only show the vertical scroll bar
		scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// Make vertical scroll bar speed faster
		scr.getVerticalScrollBar().setUnitIncrement(16);
		// set the size of the main panel to the background image dimensions
		mainPanel.setPreferredSize(new Dimension(background.getIconWidth(), background.getIconHeight()));
		// Add the scroll pane to the content pane
		getContentPane().add(scr);
		// The frame is not resizable
		setResizable(false);
		// Set the size of the frame
		setSize(830, 600);
		// Set the frame to be visible
		setVisible(true);
	}
	
	// Create buttonTransparent method
	public void buttonTransparent(JButton button) {
		// Passed in button has no border
		button.setBorder(null);
		// Passed in button has no painted border
		button.setBorderPainted(false);
		// Passed in button does not have content area filled
		button.setContentAreaFilled(false);
		// Passed in button is made transparent
		button.setOpaque(false);
		// Cursor is changed when mouse hovers on button
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
