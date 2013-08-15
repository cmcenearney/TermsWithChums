import org.junit.Test;
//import java.nio.file;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GameTest {

    Game test_game = new Game();

    @Test
    public void dictionaryIsLoading(){
        assertTrue(test_game.getDictionary().size() > 0);
    }
    @Test
    public void wordCheck(){
        assertTrue(test_game.validWord("Abadite"));
    }
}
