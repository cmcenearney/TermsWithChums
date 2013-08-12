import org.junit.Test;
//import java.nio.file;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Game test_game = new Game();

    @Test
    public void dictionaryIsLoading(){
        assertTrue(test_game.getDictionary().size() > 0);
    }
    /* java 7 only ?!??!?!?!
    @Test
    public void readFile(){
        Path file = "";

        boolean isRegularExecutableFile = Files.isRegularFile(file) &
                Files.isReadable(file) & Files.isExecutable(file);
    }
    */
}
