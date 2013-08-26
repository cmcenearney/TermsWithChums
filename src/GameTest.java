import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

//import java.nio.file;

public class GameTest {

    Game test_game = new Game();

    @Before
    public void setUpTest(){
        //set up board to test for side words
    }


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
