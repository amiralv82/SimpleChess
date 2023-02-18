import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends JFrame {

    public static void main(String[] args) {
	// write your code here

        StartMenu startMenu = new StartMenu();
    }
    public static void start() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Board board = new Board();
    }

}

