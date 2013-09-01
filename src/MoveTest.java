import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoveTest {

    Game test_game = new Game();
    Player player = new Player();

    @Before
    public void setUp() throws Exception {
        test_game.num_players = 1;
        test_game.players.add(player);
        test_game.scores.put(player,0);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("E",1));
        test_game.moveController("C,3,>,MERGE",player);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));player.addTile(new Tile("E",1));
    }

    @Test
    public void upperCaseDoesntMessUpNumsAndPunc(){
        assertTrue( ("E,7,>,REED").toUpperCase().equals("E,7,>,REED") );
        assertTrue( ("e,7,>,reed").toUpperCase().equals("E,7,>,REED") );
        assertTrue( ("e,7,^,reed").toUpperCase().equals("E,7,^,REED") );
    }

    @Test
    public void testWordsForThisTest(){
        assertTrue(test_game.validWord("MERGE"));
        assertTrue(test_game.validWord("MERGER"));
        assertTrue(test_game.validWord("DEED"));
        assertTrue(test_game.validWord("REED"));
    }

    @Test
    public void testSideWordEast(){
        assertTrue(test_game.moveController("A,8,^,MERGE",player));
        test_game.displayBoard();
//        player.addTile(new Tile("D",1));player.addTile(new Tile("E",1));player.addTile(new Tile("E",1));player.addTile(new Tile("D",1));player.addTile(new Tile("R",1));
//        assertFalse(test_game.moveController("E,7,^,DEED",player));
    }
    /*
    @Test
    public void testSideWordNorth(){
        assertTrue(test_game.moveController("E,7,>,REED",player));
        test_game.displayBoard();
    }
      */

 /*
    @After
    public void tearDown() throws Exception {

    }
    */
}
