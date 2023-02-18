
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Player {

    int[][] nextMove(int[][] positions, boolean white) throws IOException, UnsupportedAudioFileException, LineUnavailableException;
}
