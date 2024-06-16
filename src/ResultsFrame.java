/*
 * This class creates the Results Frame which is a frame that displays when the
 * user gets more than 3 questions right. It is a certificate designed to congratulate
 * the user upon the successful completion of their learning
 */

// Import required classes
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.*;

//Create the class
public class ResultsFrame extends JFrame {
	
	// Create the variable for the new font
	private Font alexBrush;
	
	public ResultsFrame(){
		// Add title for frame
		super("Results Frame");
		
		// Import font and store in created font variable
		try {
			alexBrush = Font.createFont(Font.TRUETYPE_FONT, new File("files/AlexBrush-Regular.ttf")).deriveFont(70f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("files/AlexBrush-Regular.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		// Create a second font that has the same font but is set to a smaller size
		Font alexBrush2 = alexBrush.deriveFont(40f);
		
		// Create the background image icon and label (picture of the certificate)
		ImageIcon background = new ImageIcon("files/resultsframe.png");
		JLabel backgroundLabel = new JLabel(background);
		// Set the size of the background label
		backgroundLabel.setSize(background.getIconWidth(),background.getIconHeight());
		
		// Create the name label where the name of the user will print
		// The userName variable is passed in from the TestFrame and the label positioning is centered
		JLabel nameLabel = new JLabel(TestFrame.userName, JLabel.CENTER);
		// The font is set to the imported calligraphy font
		nameLabel.setFont(alexBrush);
		// The text color is set to black
		nameLabel.setForeground(Color.BLACK);
		// The size and position of the name label is set to align in the center
		nameLabel.setBounds(25,280,800,100);
		
		// Create the score label where the number of questions that the user got right out of 5 is displayed
		JLabel scoreLabel = new JLabel(Integer.toString(TestFrame.score), JLabel.CENTER);
		// Font is set to imported calligraphy font
		scoreLabel.setFont(alexBrush2);
		// The color of the text is set to black
		scoreLabel.setForeground(Color.BLACK);
		// The size and position of the score label is set
		scoreLabel.setBounds(378,465,50,50);
		
		// Layout of the frame is set to null
		setLayout(null);
		// The labels created above are added
		add(nameLabel);
		add(scoreLabel);
		add(backgroundLabel);
		// The frame is not resizable
		setResizable(false);
		// The size of the frame is set to the dimensions of the background image with
		// additions to properly fit the background image
		setSize(new Dimension(background.getIconWidth()+10, background.getIconHeight()+38));
		// The frame is set to visible
		setVisible(true);
	}
	
	// The buttonTransparent method is created
	public void buttonTransparent(JButton button) {
		// Passed in button is made transparent
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		// Cursor when hovered over is changed to a hand cursor
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
