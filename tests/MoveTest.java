import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoveTest {

    GameModel test_game = new GameModel();
    GameController test_cntrl = new GameController(test_game, true);
    Player player = new Player(test_game);

    @Before
    public void setUp() throws Exception {
        test_game.num_players = 1;
        test_game.players.add(player);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("E",1));
        test_cntrl.moveController("h,3,>,MERGE",player);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));player.addTile(new Tile("E",1));
    }

    @Test
    public void upperCaseDoesntMessUpNumsAndPunc(){
        assertTrue( ("<,8,>,REED").toUpperCase().equals("<,8,>,REED") );
//        assertTrue( ("f,8,>,reed").toUpperCase().equals("E,7,>,REED") );
//        assertTrue( ("f,8,^,reed").toUpperCase().equals("E,7,^,REED") );
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
        Move move = new Move(test_game, 5, 7 ,"MERGER", false, player );
        assertTrue(move.checkMove());
        assertEquals(36, move.makeMove());
        test_cntrl.view.displayBoard();
        System.out.println(move.makeMove());
        assertEquals(27, move.makeMove());
        assertEquals(false, move.checkMove());
    }

    @Test
    public void wordMustIntersect(){
        Move move = new Move(test_game, 1, 1, "TEST", true, player);
        assertEquals(false, move.checkMove());
    }

    @Test
    public void displayBoard(){
        test_cntrl.view.displayBoard();
    }

 /*
    @After
    public void tearDown() throws Exception {

    }
    */
}
