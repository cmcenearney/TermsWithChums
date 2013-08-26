import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

//import java.nio.file;

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

    @Test
    public void testDisplayBoard(){
        test_game.displayBoard();
    }

    @Test
    public void tileRegex(){
        Pattern p = Pattern.compile("[A-Z]");
        assertTrue(p.matcher("A").matches());
        assertFalse(p.matcher("a").matches());
        assertFalse(p.matcher("[=]").matches());
    }

//    @Test
//    public void testCheck(){
//        Player player = new Player(name);
//        test_game.players.add(i,player);
//        scores.put(player,0);
//        for (int j=0; j < num_tiles; j++){
//            Tile t = tile_bag.randomDraw();
//            player.addTile(t);
//        }
//        assertTrue(test_game.checkMove(1,1,)
//    }

}
