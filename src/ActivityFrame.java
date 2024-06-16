/*
 * This class creates the Activity Frame which will be called
 * in the Main Frame. The Activity Frame displays a Fill-in-the
 * -blanks game, study cards, and a checklist that only allows
 * the user to move on to the next stage once they have checked
 * off all boxes.
 */

// Import all the required classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.*;

// Create the main class
public class ActivityFrame extends JFrame {
	// Create the boolean variables for the reveal answer buttons
	// We will use this to stop the button from creating overlapping JLabels
	private boolean button1Pressed = false;
	private boolean button2Pressed = false;
	
	// Create the colors that will be used throughout using RGB numbers
	Color c = new Color(220,220,220);
	Color correct = new Color(115,212,107);
	Color wrong = new Color(212,107,107);
	
	// Initialize the font variable to create the font
	private Font inter;
	
	// Create the image icon for the answer label for the first
	// fill-in-the-blank
	ImageIcon answer1 = new ImageIcon("files/answer1.png");
	// Create a label that incorporates the image icon
	JLabel answer1Label = new JLabel(answer1);
	
	// Same as answer 1
	ImageIcon answer2 = new ImageIcon("files/answer2.png");
	JLabel answer2Label = new JLabel(answer2);
	
	// Create the JLayeredPane where we will fit all of our GUI
	// components on
	JLayeredPane mainPanel = new JLayeredPane();
	
	// Create a boolean that stores the boolean for if all the 
	// JCheckBoxes are checked
	private boolean allSelected = false;
	
	// Create the main method
	public ActivityFrame(){
		// Add a title for the frame
		super("Activity Frame");
		// Set the Default Close Operation to exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Use a try-catch method to import the font
		try {
			// Use the font class to import the TTF font file
			inter = Font.createFont(Font.TRUETYPE_FONT, new File("files/Inter-Bold.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("files/Inter-Bold.ttf")));
		}
		catch(IOException | FontFormatException e) {
		}
		
		// Create the image icon and label for the background 
		// where every non-interactable GUI component will be placed on
		ImageIcon background = new ImageIcon("files/activityframe.png");
		JLabel backgroundLabel = new JLabel(background);
		// Set the size of the label to the image's dimensions
		backgroundLabel.setSize(background.getIconWidth(),background.getIconHeight());
		
		// Create the "stepCode" image icon and button
		ImageIcon stepCode = new ImageIcon("files/logo.png");
		JButton stepCodeButton = new JButton(stepCode);
		// Make the button transparent using a method
		buttonTransparent(stepCodeButton);
		// Create the function for the button
		stepCodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				// A new main frame is created
				new MainFrame();
				// The current frame is closed
				dispose();
			}
		});
		// The buttons bounds is set to the correct position and size set to
		// it's images dimensions
		stepCodeButton.setBounds(32, 24, stepCode.getIconWidth(), stepCode.getIconHeight());
		
		// Same comments as above but this button will open an Activity Frame
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
		
		// Same comments as above but this will open a Test Frame
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
		
		// Same comments as above but this will open a Concept Frame
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
		
		// Create the text areas for the first fill-in-the-blank activity
		// and set their bounds to the correct position
		JTextArea text1 = new JTextArea();
		text1.setBounds(71,368,79,29);
		// The font and background color is set using a method
		fixTextArea(text1);
		JTextArea text2 = new JTextArea();
		text2.setBounds(188,368,218,29);
		fixTextArea(text2);
		JTextArea text3 = new JTextArea();
		text3.setBounds(525,368,83,29);
		fixTextArea(text3);
		JTextArea text4 = new JTextArea();
		text4.setBounds(395,403,101,29);
		fixTextArea(text4);
		JTextArea text5 = new JTextArea();
		text5.setBounds(541,403,192,29);
		fixTextArea(text5);
		JTextArea text6 = new JTextArea();
		text6.setBounds(325,438,53,29);
		fixTextArea(text6);
		JTextArea text7 = new JTextArea();
		text7.setBounds(177,473,53,29);
		fixTextArea(text7);
		JTextArea text8 = new JTextArea();
		text8.setBounds(415,473,88,29);
		fixTextArea(text8);
		
		// Create the text areas for the second fill-in-the-blank activity
		// and set their bounds to the correct position
		JTextArea text9 = new JTextArea();
		text9.setBounds(113,831,55,29);
		fixTextArea(text9);
		JTextArea text10 = new JTextArea();
		text10.setBounds(419,831,274,29);
		fixTextArea(text10);
		JTextArea text11 = new JTextArea();
		text11.setBounds(547,866,89,29);
		fixTextArea(text11);
		JTextArea text12 = new JTextArea();
		text12.setBounds(366,901,63,29);
		fixTextArea(text12);
		JTextArea text13 = new JTextArea();
		text13.setBounds(72,936,90,29);
		fixTextArea(text13);
		JTextArea text14 = new JTextArea();
		text14.setBounds(71,972,93,29);
		fixTextArea(text14);
		JTextArea text15 = new JTextArea();
		text15.setBounds(681,972,26,29);
		fixTextArea(text15);
		
		// The first reveal answer button is created using an image and a 
		// JButton
		ImageIcon revealAnswer = new ImageIcon("files/revealanswer.png");
		JButton revealAnswerButton = new JButton(revealAnswer);
		// Button is made transparent using method
		buttonTransparent(revealAnswerButton);
		// Button is given a function
		revealAnswerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound plays
				GUIApplication.playButton();
				// If the button has not been pressed before:
				if (button1Pressed == false) {
					// The status of the button is set to "true" meaning it 
					// has been pressed
					button1Pressed = true;
					// If the inputed answer matches the correct answer:
					if (text1.getText().equalsIgnoreCase("objects")) {
						// The background of the text area is set to green
						text1.setBackground(correct);
					}
					// In all other cases:
					else
						// The background of the text area is set to red
						text1.setBackground(wrong);
					// Do the same process for the rest of the text areas
					if (text2.getText().equalsIgnoreCase("software components")) {
						text2.setBackground(correct);
					}
					else
						text2.setBackground(wrong);
					
					if (text3.getText().equalsIgnoreCase("memory")) {
						text3.setBackground(correct);
					}
					else
						text3.setBackground(wrong);
					
					if (text4.getText().equalsIgnoreCase("store data")) {
						text4.setBackground(correct);
					}
					else
						text4.setBackground(wrong);
					
					if (text5.getText().equalsIgnoreCase("perform operations")) {
						text5.setBackground(correct);
					}
					else
						text5.setBackground(wrong);
					
					if (text6.getText().equalsIgnoreCase("class")) {
						text6.setBackground(correct);
					}
					else
						text6.setBackground(wrong);
					
					if (text7.getText().equalsIgnoreCase("class")) {
						text7.setBackground(correct);
					}
					else
						text7.setBackground(wrong);
					
					if (text8.getText().equalsIgnoreCase("instance")) {
						text8.setBackground(correct);
					}
					else
						text8.setBackground(wrong);
					
					// Create the label that displays the answers to the fill in the blank
					answer1Label.setBounds(71, 598, answer1.getIconWidth(), answer1.getIconHeight());
					// Add it to the main panel
					mainPanel.add(answer1Label, Integer.valueOf(1));
				}
				// else:
				else {}
				
			}
		});
		// Set the size and position of the reveal answer button
		revealAnswerButton.setBounds(71, 525, revealAnswer.getIconWidth(), revealAnswer.getIconHeight());
		
		// Repeat the same process for the revealAnswer1 button
		ImageIcon revealAnswer2 = new ImageIcon("files/revealanswer.png");
		JButton revealAnswerButton2 = new JButton(revealAnswer2);
		buttonTransparent(revealAnswerButton2);
		revealAnswerButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				if (button2Pressed == false) {
					button2Pressed = true;
					if (text9.getText().equalsIgnoreCase("class")) {
						text9.setBackground(correct);
					}
					else
						text9.setBackground(wrong);
					
					if (text10.getText().equalsIgnoreCase("java virtual machine {jvm)") || 
							text10.getText().equalsIgnoreCase("java virtual machine") ||
							text10.getText().equalsIgnoreCase("jvm")) {
						text10.setBackground(correct);
					}
					else
						text10.setBackground(wrong);
					
					if (text11.getText().equalsIgnoreCase("methods")) {
						text11.setBackground(correct);
					}
					else
						text11.setBackground(wrong);
					
					if (text12.getText().equalsIgnoreCase("public")) {
						text12.setBackground(correct);
					}
					else
						text12.setBackground(wrong);
					
					if (text13.getText().equalsIgnoreCase("methods")) {
						text13.setBackground(correct);
					}
					else
						text13.setBackground(wrong);
					
					if (text14.getText().equalsIgnoreCase("explicitly")) {
						text14.setBackground(correct);
					}
					else
						text14.setBackground(wrong);
					
					if (text15.getText().equalsIgnoreCase("all")) {
						text15.setBackground(correct);
					}
					else
						text15.setBackground(wrong);
					
					answer2Label.setBounds(71, 1135, answer2.getIconWidth(), answer2.getIconHeight());
					mainPanel.add(answer2Label, Integer.valueOf(1));
				}
				else {}
				
			}
		});
		revealAnswerButton2.setBounds(71, 1059, revealAnswer2.getIconWidth(), revealAnswer2.getIconHeight());
		
		// Create the first study card by creating its image icon and JButton
		// that displays the image
		ImageIcon card1 = new ImageIcon("files/card1.png");
		JButton card1Button = new JButton(card1);
		// Make the button transparent using method
		buttonTransparent(card1Button);
		// Give the button a function
		card1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound is played
				GUIApplication.playButton();
				// Create the image icon and JButton for when the card is "flipped over"
				ImageIcon card1Green = new ImageIcon("files/card1green.png");
				JButton card1ButtonGreen = new JButton(card1Green);
				// Make the reverse study card button transparent using method
				buttonTransparent(card1ButtonGreen);
				// Now give the flipped study card button a function
				card1ButtonGreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Button sound is played
						GUIApplication.playButton();
						// The flipped card is now invisible and the unflipped card
						// is now visible
						card1ButtonGreen.setVisible(false);
						card1Button.setVisible(true);
					}
				});
				// Set the size and position of the flipped card button
				card1ButtonGreen.setBounds(72, 1450, card1Green.getIconWidth(), card1Green.getIconHeight());
				// Add the study card to the main panel
				mainPanel.add(card1ButtonGreen, Integer.valueOf(1));
				// Make the unflipped button visible
				card1Button.setVisible(false);
			}
		});
		// Set the size and position of the unflipped study card button
		card1Button.setBounds(72, 1450, card1.getIconWidth(), card1.getIconHeight());
		
		// Repeat steps above for the next 5 study cards
		ImageIcon card2 = new ImageIcon("files/card2.png");
		JButton card2Button = new JButton(card2);
		buttonTransparent(card2Button);
		card2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				ImageIcon card2Green = new ImageIcon("files/card2green.png");
				JButton card2ButtonGreen = new JButton(card2Green);
				buttonTransparent(card2ButtonGreen);
				card2ButtonGreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUIApplication.playButton();
						card2ButtonGreen.setVisible(false);
						card2Button.setVisible(true);
					}
				});
				card2ButtonGreen.setBounds(428, 1450, card2Green.getIconWidth(), card2Green.getIconHeight());
				mainPanel.add(card2ButtonGreen, Integer.valueOf(1));
				card2Button.setVisible(false);
			}
		});
		card2Button.setBounds(428, 1450, card2.getIconWidth(), card2.getIconHeight());
		
		ImageIcon card3 = new ImageIcon("files/card3.png");
		JButton card3Button = new JButton(card3);
		buttonTransparent(card3Button);
		card3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				ImageIcon card3Green = new ImageIcon("files/card1green.png");
				JButton card3ButtonGreen = new JButton(card3Green);
				buttonTransparent(card3ButtonGreen);
				card3ButtonGreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUIApplication.playButton();
						card3ButtonGreen.setVisible(false);
						card3Button.setVisible(true);
					}
				});
				card3ButtonGreen.setBounds(72, 1684, card3Green.getIconWidth(), card3Green.getIconHeight());
				mainPanel.add(card3ButtonGreen, Integer.valueOf(1));
				card3Button.setVisible(false);
			}
		});
		card3Button.setBounds(72, 1684, card3.getIconWidth(), card3.getIconHeight());
		
		ImageIcon card4 = new ImageIcon("files/card4.png");
		JButton card4Button = new JButton(card4);
		buttonTransparent(card4Button);
		card4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				ImageIcon card4Green = new ImageIcon("files/card4green.png");
				JButton card4ButtonGreen = new JButton(card4Green);
				buttonTransparent(card4ButtonGreen);
				card4ButtonGreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUIApplication.playButton();
						card4ButtonGreen.setVisible(false);
						card4Button.setVisible(true);
					}
				});
				card4ButtonGreen.setBounds(428, 1684, card4Green.getIconWidth(), card4Green.getIconHeight());
				mainPanel.add(card4ButtonGreen, Integer.valueOf(1));
				card4Button.setVisible(false);
			}
		});
		card4Button.setBounds(428, 1684, card4.getIconWidth(), card4.getIconHeight());
		
		ImageIcon card5 = new ImageIcon("files/card5.png");
		JButton card5Button = new JButton(card5);
		buttonTransparent(card5Button);
		card5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				ImageIcon card5Green = new ImageIcon("files/card5Green.png");
				JButton card5ButtonGreen = new JButton(card5Green);
				buttonTransparent(card5ButtonGreen);
				card5ButtonGreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUIApplication.playButton();
						card5ButtonGreen.setVisible(false);
						card5Button.setVisible(true);
					}
				});
				card5ButtonGreen.setBounds(72, 1918, card5Green.getIconWidth(), card5Green.getIconHeight());
				mainPanel.add(card5ButtonGreen, Integer.valueOf(1));
				card5Button.setVisible(false);
			}
		});
		card5Button.setBounds(72, 1918, card5.getIconWidth(), card5.getIconHeight());
		
		ImageIcon card6 = new ImageIcon("files/card6.png");
		JButton card6Button = new JButton(card6);
		buttonTransparent(card6Button);
		card6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				ImageIcon card6Green = new ImageIcon("files/card6Green.png");
				JButton card6ButtonGreen = new JButton(card6Green);
				buttonTransparent(card6ButtonGreen);
				card6ButtonGreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUIApplication.playButton();
						card6ButtonGreen.setVisible(false);
						card6Button.setVisible(true);
					}
				});
				card6ButtonGreen.setBounds(428, 1918, card6Green.getIconWidth(), card6Green.getIconHeight());
				mainPanel.add(card6ButtonGreen, Integer.valueOf(1));
				card6Button.setVisible(false);
			}
		});
		card6Button.setBounds(428, 1918, card6.getIconWidth(), card6.getIconHeight());
		
		// Create the checkboxes for the learning check and position them correctly
		JCheckBox box1 = new JCheckBox();
		box1.setBounds(76,2226,35,35);
		// Set the icon of the unselected and selected checkbox using method
		fixBox(box1);
		// Repeat for the rest of the check boxes
		JCheckBox box2 = new JCheckBox();
		box2.setBounds(76,2287,35,35);
		fixBox(box2);
		JCheckBox box3 = new JCheckBox();
		box3.setBounds(76,2348,35,35);
		fixBox(box3);
		JCheckBox box4 = new JCheckBox();
		box4.setBounds(76,2409,35,35);
		fixBox(box4);
		JCheckBox box5 = new JCheckBox();
		box5.setBounds(76,2470,35,35);
		fixBox(box5);
		JCheckBox box6 = new JCheckBox();
		box6.setBounds(76,2531,35,35);
		fixBox(box6);
		
		// Add a function to the first checkbox
		box1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Button sound is played
				GUIApplication.playButton();
				// Checks if all checkboxes have been selected using method
				addBoxFunction(box1, box2, box3, box4, box5, box6);
			}
		});
		// Repeat above for all the other checkboxes
		box2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				addBoxFunction(box1, box2, box3, box4, box5, box6);
			}
		});
		box3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				addBoxFunction(box1, box2, box3, box4, box5, box6);
			}
		});
		box4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				addBoxFunction(box1, box2, box3, box4, box5, box6);
			}
		});
		box5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				addBoxFunction(box1, box2, box3, box4, box5, box6);
			}
		});
		box6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplication.playButton();
				addBoxFunction(box1, box2, box3, box4, box5, box6);
			}
		});
		
		// Add all the labels and buttons created above to the main panel
		mainPanel.add(backgroundLabel, Integer.valueOf(0));
		mainPanel.add(practiceButton, Integer.valueOf(1));
		mainPanel.add(assessButton, Integer.valueOf(1));
		mainPanel.add(learningButton, Integer.valueOf(1));
		mainPanel.add(stepCodeButton, Integer.valueOf(1));
		mainPanel.add(revealAnswerButton, Integer.valueOf(1));
		mainPanel.add(revealAnswerButton2, Integer.valueOf(1));
		
		// Add the text areas to the main panel
		// Part 1
		mainPanel.add(text1, Integer.valueOf(1));
		mainPanel.add(text2, Integer.valueOf(1));
		mainPanel.add(text3, Integer.valueOf(1));
		mainPanel.add(text4, Integer.valueOf(1));
		mainPanel.add(text5, Integer.valueOf(1));
		mainPanel.add(text6, Integer.valueOf(1));
		mainPanel.add(text7, Integer.valueOf(1));
		mainPanel.add(text8, Integer.valueOf(1));
		// Part 2
		mainPanel.add(text9, Integer.valueOf(1));
		mainPanel.add(text10, Integer.valueOf(1));
		mainPanel.add(text11, Integer.valueOf(1));
		mainPanel.add(text12, Integer.valueOf(1));
		mainPanel.add(text13, Integer.valueOf(1));
		mainPanel.add(text14, Integer.valueOf(1));
		mainPanel.add(text15, Integer.valueOf(1));
		
		// Add all the study cards to the main panel
		mainPanel.add(card1Button, Integer.valueOf(1));
		mainPanel.add(card2Button, Integer.valueOf(1));
		mainPanel.add(card3Button, Integer.valueOf(1));
		mainPanel.add(card4Button, Integer.valueOf(1));
		mainPanel.add(card5Button, Integer.valueOf(1));
		mainPanel.add(card6Button, Integer.valueOf(1));
		
		// Add all the checkboxes to the main panel
		mainPanel.add(box1, Integer.valueOf(1));
		mainPanel.add(box2, Integer.valueOf(1));
		mainPanel.add(box3, Integer.valueOf(1));
		mainPanel.add(box4, Integer.valueOf(1));
		mainPanel.add(box5, Integer.valueOf(1));
		mainPanel.add(box6, Integer.valueOf(1));
		
		// Create the scroll panel that holds the main panel
		JScrollPane scr = new JScrollPane(mainPanel);
		// Hide the horizontal scroll bar
		scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// Make scrolling faster on the vertical scroll bar
		scr.getVerticalScrollBar().setUnitIncrement(16);
		
		// Set the size of the main panel to the size of the background image
		mainPanel.setPreferredSize(new Dimension(background.getIconWidth(), background.getIconHeight()));
		// Add the scroll panel to the content pane
		getContentPane().add(scr);
		// Make the frame not resizable
		setResizable(false);
		// Set the size of the frame
		setSize(830, 600);
		// Set the frame to be visible
		setVisible(true);
	}
	
	// Create the buttonTransparent method
	public void buttonTransparent(JButton button) {
		// This method will make the button that is passed in transparent
		// Border is removed
		button.setBorder(null);
		// Border paint is removed
		button.setBorderPainted(false);
		// The content area is not filled
		button.setContentAreaFilled(false);
		// The button is not opaque (transparent)
		button.setOpaque(false);
		// When a cursor is hovering over, it changes to a hand cursor
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	// Create the fixBox method
	public void fixBox(JCheckBox box) {
		// Passed in box is made transparent like the button method
		box.setBorder(null);
		box.setBorderPainted(false);
		box.setContentAreaFilled(false);
		box.setOpaque(false);
		// Cursor changes when hovering box
		box.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// Set the unselected icon of the checkbox
		box.setIcon(new ImageIcon("files/checkbox.png"));
		// Set the selected icon of the checkbox
		box.setSelectedIcon(new ImageIcon("files/checkedbox.png"));
	}
	
	// Create the fixTextArea method
	public void fixTextArea(JTextArea text) {
		// Set the background of the text area to pre-created color
		text.setBackground(c);
		// Set the font of the text area to inter
		text.setFont(inter);
	}
	
	// Create addBoxFunction method and pass in every checkbox
	public void addBoxFunction(JCheckBox check1, JCheckBox check2, JCheckBox check3, JCheckBox check4,
			JCheckBox check5, JCheckBox check6) {
		// If all the checkboxes are selected:
		if (check1.isSelected()&& check2.isSelected() && check3.isSelected()
				&& check4.isSelected() && check5.isSelected()&& check6.isSelected() && allSelected == false) {
			// The boolean that stores whether they are all selected is set to true
			allSelected = true;
			// Create the image icon and JButton for the start test button
			ImageIcon startTest = new ImageIcon("files/starttest.png");
			JButton startTestButton = new JButton(startTest);
			// Make the button transparent using method
			buttonTransparent(startTestButton);
			// Add function to the start test button
			startTestButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Button sound plays
					GUIApplication.playButton();
					// A new test frame is created
					new TestFrame();
					// The current frame is closed
					dispose();
				}
			});
			// The size and position of the start test button is set
			startTestButton.setBounds(287, 2603, startTest.getIconWidth(), startTest.getIconHeight());
			// The start test button is added to the main panel
			mainPanel.add(startTestButton, Integer.valueOf(2));
		}
	}
}
