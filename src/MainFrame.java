/*
 * This class creates the main frame which displays all the preliminary information 
 * to get started with the lesson. It also includes buttons that leads to every 
 * other frame of the lesson.
 */

// Import all the required classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.*;

// Create the main class
public class MainFrame extends JFrame {
	public MainFrame(){
		// Add title for the Main Frame
		super("Main Frame");
		// Set default close operation to exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a JLayeredPanel to use as the main panel
		JLayeredPane mainPanel = new JLayeredPane();
		
		// Create the background image icon and label
		ImageIcon background = new ImageIcon("files/mainframe.png");
		JLabel backgroundLabel = new JLabel(background);
		// Set the size of the background label to the dimensions of the image
		backgroundLabel.setSize(background.getIconWidth(),background.getIconHeight());
		
		// Create the practice image icon and button
		ImageIcon practice = new ImageIcon("files/practicebutton.png");
		JButton practiceButton = new JButton(practice);
		// Make the button transparent using a method
		buttonTransparent(practiceButton);
		// Add a function to the button
		practiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound plays
				GUIApplication.playButton();
				// A new Activity Frame is created
				new ActivityFrame();
				// The current frame is closed
				dispose();
			}
		});
		// The practice button's size and position are set
		practiceButton.setBounds(361, 43, practice.getIconWidth(), practice.getIconHeight());
		
		// Same comments as above but this is for the assess button
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
		
		// Same comments as above but this is for the start learning button
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
		
		// Same comments as above but this is for the explore button which leads 
		// to the first Concept Frame
		ImageIcon explore = new ImageIcon("files/explorebutton.png");
		JButton exploreButton = new JButton(explore);
		buttonTransparent(exploreButton);
		exploreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				new ConceptFrame1();
				dispose();
			}
		});
		exploreButton.setBounds(481, 332, explore.getIconWidth(), explore.getIconHeight());
		
		// Create the label and image icon for the typing GIF in the main frame
		ImageIcon mainFrameTypingGif = new ImageIcon("files/mainframetyping.gif");
		JLabel mainTyping = new JLabel(mainFrameTypingGif);
		// The size and position of the GIF is set
		mainTyping.setBounds(422, 444, mainFrameTypingGif.getIconWidth(), mainFrameTypingGif.getIconHeight());
		
		// Create the image icon and button for the play button
		ImageIcon play = new ImageIcon("files/playbutton.png");
		JButton playButton = new JButton(play);
		// Make the button transparent using method
		buttonTransparent(playButton);
		// Give button a function
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound plays
				GUIApplication.playButton();
				// A new Activity Frame is created
				new ActivityFrame();
				// The current frame is closed
				dispose();
			}
		});
		// The size and position of the play button is set
		playButton.setBounds(151, 1168, play.getIconWidth(), play.getIconHeight());
		
		// The start test image icon and button is created
		ImageIcon startTest = new ImageIcon("files/starttestbutton.png");
		JButton startTestButton = new JButton(startTest);
		// Make the button transparent using method
		buttonTransparent(startTestButton);
		// Give button a function
		startTestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound plays
				GUIApplication.playButton();
				// A new Test Frame is created
				new TestFrame();
				// The current frame is closed
				dispose();
			}
		});
		// The size and position of the start test button is set
		startTestButton.setBounds(538, 1167, startTest.getIconWidth(), startTest.getIconHeight());
		
		// All the created buttons, labels, and GIFs are added to the main panel
		mainPanel.add(backgroundLabel, Integer.valueOf(0));
		mainPanel.add(practiceButton, Integer.valueOf(1));
		mainPanel.add(assessButton, Integer.valueOf(1));
		mainPanel.add(learningButton, Integer.valueOf(1));
		mainPanel.add(exploreButton, Integer.valueOf(1));
		mainPanel.add(mainTyping, Integer.valueOf(1));
		mainPanel.add(playButton, Integer.valueOf(1));
		mainPanel.add(startTestButton, Integer.valueOf(1));
		
		// A scroll pane is created to display panel
		JScrollPane scr = new JScrollPane(mainPanel);
		// Make only the vertical scroll bar visible
		scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// Increase the speed of the vertical scroll bar
		scr.getVerticalScrollBar().setUnitIncrement(16);
		// Set the size of the main panel to the size of the background image
		mainPanel.setPreferredSize(new Dimension(background.getIconWidth(), background.getIconHeight()));
		// Add the scroll pane to the content pane of the frame
		getContentPane().add(scr);
		// Frame is not resizable
		setResizable(false);
		// Set the size of the frame
		setSize(830, 600);
		// The frame is set to visible
		setVisible(true);
	}
	
	// Create the buttonTransparent method
	public void buttonTransparent(JButton button) {
		// Passed in button is made transparent
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		// Cursor changes to hand cursor when hovering over the button
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
