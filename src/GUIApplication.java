/* Stephen Dong
 * Solo Culminating Project
 * Classes and Objects
 * 
 * DUE DATE: June 14, 2023, 11:59 PM
 * 
 * ICS3U1-04/05 Mrs. Biswas
 * 
 * DESCRIPTION:
 * This is a learning platform created for the purpose of teaching people what
 * Class and Objects are in Java Programming.
 * 
 * The program consists of 9 classes, all of which come together to form a cohesive 
 * lesson plan with an initial reading learning phase which transitions into an
 * activity phase where the user practices what they've learned through fill-in-the
 * -blanks and study cards. Users will then assess themselves and test what they've
 * learned by answering 5 multiple choice questions when, if enough questions are
 * answered correctly, will display a certificate for the user to keep.
 * 
 * In the main frame, if the user decides they want to skip a phase, they can always
 * navigate through each phase through the selection bar at the top of each frame.
 * 
 * SKILLS USED: Classes and objects, GUI, Swing GUI components, 
 * photo editing/resizing, importing custom fonts, reading keyboard input, and 
 * ImageIcon implementation.
 * 
 * AREAS OF CONCERN:
 * - Button sound may become annoying over time...? 
 * 
 * CONTRIBUTION TO ASSIGNMENT:
 * 100% completed by me with help from sources.
 * 
 * SOURCES:
 * https://www.youtube.com/watch?v=wJO_cq5XeSA
 * https://www.youtube.com/watch?v=43duJsYmhxQ
 * Michelle Zhang for teaching me how to use JLayeredPane
*/

// Import all required classes
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Create the GUIApplication class
public class GUIApplication {
	// Create the main method
	public static void main(String [] args) {
		// A new Main Frame is created
		new MainFrame();
	}
	
	// When this method is called, a button press sound effect is played
	public static void playButton() {
		// A music file is imported and played
		try {
			File buttonSound = new File("files/buttonsound.wav");
			AudioInputStream buttonClip = AudioSystem.getAudioInputStream(buttonSound);
			Clip clip1 = AudioSystem.getClip();
			clip1.open(buttonClip);
			clip1.start();
		}
		// If the file is not found, the computer prints "Can't find file."
		catch (Exception e) {
			System.out.println("Can't find file.");
		}
	}
}