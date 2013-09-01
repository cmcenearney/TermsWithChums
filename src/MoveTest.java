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
    public void testMove(){
        Move move = new Move(test_game, 0, 7 ,"MERGER", false, player );
        assertTrue(move.checkMove());
        assertEquals(42, move.makeMove());
        test_game.displayBoard();
        System.out.println(move.makeMove());
    }

 /*
    @After
    public void tearDown() throws Exception {

    }
    */
}
