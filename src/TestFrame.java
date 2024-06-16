/*
 * This class creates the Test Frame which is the assessment frame for my program.
 * The Test Frame includes 5 multiple choice questions that, when answered correctly,
 * displays a certificate with the user's name and score. If 3 or less questions are 
 * answered correctly, then a fail certificate displays after hitting submit
 */

// Import required classes
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.*;
import javax.swing.border.Border;

// Create the class
public class TestFrame extends JFrame {
	
	// Create the variable to store the imported font in
	private Font inter;
	// Create a public variable that stores the user's name
	public static String userName = "";
	// Create a public variable that stores the user's score
	public static int score = 0;
	// Create a boolean that stores whether the submit button has been pressed or not
	private boolean submitPressed = false;
	// Create a JLayeredPane as the main panel
	JLayeredPane mainPanel = new JLayeredPane();
	
	public TestFrame(){
		// Create title for frame
		super("Test Frame");
		// Set default close operation to exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Import inter font
		try {
			inter = Font.createFont(Font.TRUETYPE_FONT, new File("files/Inter-Bold.ttf")).deriveFont(25f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("files/Inter-Bold.ttf")));
		}
		catch(IOException | FontFormatException e) {
		}
		
		// Create the background image icon and label
		ImageIcon background = new ImageIcon("files/testframe.png");
		JLabel backgroundLabel = new JLabel(background);
		// The size of the background label is set
		backgroundLabel.setSize(background.getIconWidth(),background.getIconHeight());
		
		// Create the "stepCode" image icon and button
		ImageIcon stepCode = new ImageIcon("files/logo.png");
		JButton stepCodeButton = new JButton(stepCode);
		// Button is made transparent using a method
		buttonTransparent(stepCodeButton);
		// Function is given to button
		stepCodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound is played
				GUIApplication.playButton();
				// A new Main Frame is created
				new MainFrame();
				// Current frame is closed
				dispose();
			}
		});
		// "stepCode" button size and position is set
		stepCodeButton.setBounds(32, 24, stepCode.getIconWidth(), stepCode.getIconHeight());
		
		// Same comments as above except this is for the practice button
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
		
		// Same comments as above except this is for the assess button
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
		
		// Same comments as above except this is for the start learning button
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
		
		// Create a JTextArea where the user can enter their name
		JTextArea name = new JTextArea();
		// The size and position of the JTextArea is set
		name.setBounds(160,362,342,53);
		// A border is created inside the JTextArea for aesthetic purposes
		Border border = BorderFactory.createLineBorder(new Color(117,117,117), 2);
		name.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		// The font is set to inter
		name.setFont(inter);
		
		// The submit button for the JTextArea is created with its respective image icon
		ImageIcon submit = new ImageIcon("files/submitbutton.png");
		JButton submitButton = new JButton(submit);
		// Button is made transparent using method
		buttonTransparent(submitButton);
		// Function is given to button
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound plays
				GUIApplication.playButton();
				// The global variable is set to whatever is inside the JTextArea
				userName = name.getText();
				// The background color of the JTextArea is darkened when submit is pressed
				name.setBackground(new Color(222,222,222));
			}
		});
		// The size and position of the submit button is set
		submitButton.setBounds(502, 362, submit.getIconWidth(), submit.getIconHeight());
		
		// Create the radio buttons for the first question and set their size and position
		JRadioButton radio1 = new JRadioButton();
		radio1.setBounds(96,573,15,15);
		JRadioButton radio2 = new JRadioButton();
		radio2.setBounds(96,602,15,15);
		JRadioButton radio3 = new JRadioButton();
		radio3.setBounds(96,631,15,15);
		JRadioButton radio4 = new JRadioButton();
		radio4.setBounds(96,660,15,15);
		// Create a button group for the radio buttons
		ButtonGroup q1 = new ButtonGroup();
		// Add the created buttons to the button group
		q1.add(radio1);
		q1.add(radio2);
		q1.add(radio3);
		q1.add(radio4);
		
		// Create the radio buttons for the second question and set their size and position
		JRadioButton radio5 = new JRadioButton();
		radio5.setBounds(96,764,15,15);
		JRadioButton radio6 = new JRadioButton();
		radio6.setBounds(96,793,15,15);
		JRadioButton radio7 = new JRadioButton();
		radio7.setBounds(96,822,15,15);
		JRadioButton radio8 = new JRadioButton();
		radio8.setBounds(96,851,15,15);
		// Create a button group for the radio buttons
		ButtonGroup q2 = new ButtonGroup();
		// Add the created buttons to the button group
		q2.add(radio5);
		q2.add(radio6);
		q2.add(radio7);
		q2.add(radio8);
		
		// Create the radio buttons for the third question and set their size and position
		JRadioButton radio9 = new JRadioButton();
		radio9.setBounds(96,933,15,15);
		JRadioButton radio10 = new JRadioButton();
		radio10.setBounds(96,963,15,15);
		JRadioButton radio11= new JRadioButton();
		radio11.setBounds(96,992,15,15);
		JRadioButton radio12 = new JRadioButton();
		radio12.setBounds(96,1021,15,15);
		// Create a button group for the radio buttons
		ButtonGroup q3 = new ButtonGroup();
		// Add the created buttons to the button group
		q3.add(radio9);
		q3.add(radio10);
		q3.add(radio11);
		q3.add(radio12);
		
		// Create the radio buttons for the fourth question and set their size and position
		JRadioButton radio13 = new JRadioButton();
		radio13.setBounds(96,1102,15,15);
		JRadioButton radio14 = new JRadioButton();
		radio14.setBounds(96,1132,15,15);
		JRadioButton radio15 = new JRadioButton();
		radio15.setBounds(96,1161,15,15);
		JRadioButton radio16 = new JRadioButton();
		radio16.setBounds(96,1190,15,15);
		// Create a button group for the radio buttons
		ButtonGroup q4 = new ButtonGroup();
		// Add the created buttons to the button group
		q4.add(radio13);
		q4.add(radio14);
		q4.add(radio15);
		q4.add(radio16);
		
		// Create the radio buttons for the fifth question and set their size and position
		JRadioButton radio17 = new JRadioButton();
		radio17.setBounds(96,1271,15,15);
		JRadioButton radio18 = new JRadioButton();
		radio18.setBounds(96,1302,15,15);
		JRadioButton radio19 = new JRadioButton();
		radio19.setBounds(96,1335,15,15);
		JRadioButton radio20 = new JRadioButton();
		radio20.setBounds(96,1366,15,15);
		// Create a button group for the radio buttons
		ButtonGroup q5 = new ButtonGroup();
		// Add the created buttons to the button group
		q5.add(radio17);
		q5.add(radio18);
		q5.add(radio19);
		q5.add(radio20);
		
		// All the radio buttons are made transparent using a method
		fixRadio(radio1);
		fixRadio(radio2);
		fixRadio(radio3);
		fixRadio(radio4);
		fixRadio(radio5);
		fixRadio(radio6);
		fixRadio(radio7);
		fixRadio(radio8);
		fixRadio(radio9);
		fixRadio(radio10);
		fixRadio(radio11);
		fixRadio(radio12);
		fixRadio(radio13);
		fixRadio(radio14);
		fixRadio(radio15);
		fixRadio(radio16);
		fixRadio(radio17);
		fixRadio(radio18);
		fixRadio(radio19);
		fixRadio(radio20);
		
		// Create the submit answer image icon and button
		ImageIcon submit2 = new ImageIcon("files/submitbutton2.png");
		JButton submitButton2 = new JButton(submit2);
		// Button is made transparent using method
		buttonTransparent(submitButton2);
		// Function is given to button
		submitButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound is played
				GUIApplication.playButton();
				
				// If the correct corresponding radio button is selected for each question,
				// the score count increments by 1
				if (radio2.isSelected()) {
					score++;
				}
				if (radio5.isSelected()) {
					score++;
				}
				if (radio12.isSelected()) {
					score++;
				}
				if (radio16.isSelected()) {
					score++;
				}
				if (radio19.isSelected()) {
					score++;
				}
				
				// Create the warn name image icon and label]
				// This label is to tell the user to input their name because they haven't
				ImageIcon warnName = new ImageIcon("files/warnnamelabel.png");
				JLabel warnNameLabel = new JLabel(warnName);
				// The size and position of the warn name label is set
				warnNameLabel.setBounds(187, 1476, warnName.getIconWidth(), warnName.getIconHeight());
				// The warn name label is added to the main panel
				mainPanel.add(warnNameLabel, Integer.valueOf(1));
				// The warn name label is set to not visible
				warnNameLabel.setVisible(false);
				
				// If there is nothing in the name text area, and the submit answers button 
				// has not yet been pressed:
				if (userName == "" && submitPressed == false) {
					// The submit answers button has now been pressed
					submitPressed = true;
					// The warn name label is set to visible because the user has not entered
					// a name in the JTextArea
					warnNameLabel.setVisible(true);
				}
				// If the user has got more than 3 questions right and the userName is not empty:
				else if (score > 3 && userName != ""){
					// Checkmark images beside each of the correct answers is displayed
					addChecks();
					// A new Results Frame is created
					new ResultsFrame();
				}
				// If the user has got 3 or less questions right and the userName is not empty:
				else if (score <= 3 && userName != "") {
					// Checkmark images beside each of the correct answers is displayed
					addChecks();
					// A new Fail Frame is created
					new FailFrame();
				}
				// Score is set to 0 at the end to avoid multiple scores being added and exceeding 5
				score = 0;
				
			}
		});
		// The size and position of the submit answer button is set
		submitButton2.setBounds(314, 1422, submit2.getIconWidth(), submit2.getIconHeight());
		
		// All the label and buttons we made are added to the main panel
		mainPanel.add(backgroundLabel, Integer.valueOf(0));
		mainPanel.add(practiceButton, Integer.valueOf(1));
		mainPanel.add(assessButton, Integer.valueOf(1));
		mainPanel.add(learningButton, Integer.valueOf(1));
		mainPanel.add(stepCodeButton, Integer.valueOf(1)); 
		
		// The name JTextArea and submit name button is added to the main panel
		mainPanel.add(name, Integer.valueOf(1)); 
		mainPanel.add(submitButton, Integer.valueOf(1)); 
		
		// Each radio button is added to the main panel
		mainPanel.add(radio1, Integer.valueOf(1));
		mainPanel.add(radio2, Integer.valueOf(1));
		mainPanel.add(radio3, Integer.valueOf(1));
		mainPanel.add(radio4, Integer.valueOf(1));
		mainPanel.add(radio5, Integer.valueOf(1));
		mainPanel.add(radio6, Integer.valueOf(1));
		mainPanel.add(radio7, Integer.valueOf(1));
		mainPanel.add(radio8, Integer.valueOf(1));
		mainPanel.add(radio9, Integer.valueOf(1));
		mainPanel.add(radio10, Integer.valueOf(1));
		mainPanel.add(radio11, Integer.valueOf(1));
		mainPanel.add(radio12, Integer.valueOf(1));
		mainPanel.add(radio13, Integer.valueOf(1));
		mainPanel.add(radio14, Integer.valueOf(1));
		mainPanel.add(radio15, Integer.valueOf(1));
		mainPanel.add(radio16, Integer.valueOf(1));
		mainPanel.add(radio17, Integer.valueOf(1));
		mainPanel.add(radio18, Integer.valueOf(1));
		mainPanel.add(radio19, Integer.valueOf(1));
		mainPanel.add(radio20, Integer.valueOf(1));
		// The submit answer button is added to the main panel
		mainPanel.add(submitButton2, Integer.valueOf(1));
		
		// A scroll pane is created to display the main panel
		JScrollPane scr = new JScrollPane(mainPanel);
		// Only the vertical scrollbar is used
		scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// The speed of the vertical scrollbar is increased
		scr.getVerticalScrollBar().setUnitIncrement(16);
		// Set the size of the main panel to the dimensions of the background image
		mainPanel.setPreferredSize(new Dimension(background.getIconWidth(), background.getIconHeight()));
		// Set the content pane as the scroll pane
		getContentPane().add(scr);
		// The frame is not resizable
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
		// Cursor changes when being hovered over
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	// Create the fixRadio method
	public void fixRadio (JRadioButton radio) {
		// Passed in radio button is made transparent
		radio.setBorder(null);
		radio.setBorderPainted(false);
		radio.setContentAreaFilled(false);
		radio.setOpaque(false);
		// Cursor changes when being hovered over
		radio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	// Create the addChecks method
	public void addChecks() {
		// A checkmark label for each question is created and their size and position is set correctly
		ImageIcon checkmark = new ImageIcon("files/checkmark.png");
		JLabel checkLabel1 = new JLabel(checkmark);
		checkLabel1.setBounds(308,596,checkmark.getIconWidth(), checkmark.getIconWidth());
		JLabel checkLabel2 = new JLabel(checkmark);
		checkLabel2.setBounds(595,760,checkmark.getIconWidth(), checkmark.getIconWidth());
		JLabel checkLabel3 = new JLabel(checkmark);
		checkLabel3.setBounds(381,1017,checkmark.getIconWidth(), checkmark.getIconWidth());
		JLabel checkLabel4 = new JLabel(checkmark);
		checkLabel4.setBounds(316,1187,checkmark.getIconWidth(), checkmark.getIconWidth());
		JLabel checkLabel5 = new JLabel(checkmark);
		checkLabel5.setBounds(619,1331,checkmark.getIconWidth(), checkmark.getIconWidth());
		// They are all added to the main panel
		mainPanel.add(checkLabel1, Integer.valueOf(1));
		mainPanel.add(checkLabel2, Integer.valueOf(1));
		mainPanel.add(checkLabel3, Integer.valueOf(1));
		mainPanel.add(checkLabel4, Integer.valueOf(1));
		mainPanel.add(checkLabel5, Integer.valueOf(1));
	}
}
