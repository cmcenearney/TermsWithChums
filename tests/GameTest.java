import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    GameModel test_game = new GameModel();
    GameController test_cntrl = new GameController(test_game, true);
    Player player = new Player(test_game);

    @Before
    public void setUpTest(){
        test_game.num_players = 1;
        test_game.players.add(player);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1)); player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("E",1));
        boolean move1 = test_cntrl.moveController("h,3,>,MERGE", player);
        //test_game.displayBoard();
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1)); player.addTile(new Tile("E",1));
    }

    @Test
    public void setUpWorked(){
        assertEquals("M",test_game.board.getSpace(7,2).getValue());
    }

    @Test
    public void dictionaryIsLoading(){
        assertTrue(test_game.getDictionary().size() > 0);
    }

    @Test
    public void wordCheck1(){
        assertTrue(test_game.validWord("hang"));
    }

    @Test
    public void wordCheck(){
        assertTrue(test_game.validWord("Abadite"));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testOutOfBounds(){
        test_game.board.getSpace(1, 15);
    }

    // TODO: refactor these tests for mvc
    /*
    @Test
    public void testSideWordWest(){
        assertEquals("MERGER", test_game.getSideWord(false, "R", 2, 7));
        assertTrue(test_game.validWord("MERGER"));
    }


    @Test
    public void indirectIntersect(){
        assertTrue(test_game.checkMove(0, 7, "MERGER", false,  player));
        assertTrue(test_game.moveController("a,8,^,merger", player));
        //assertEquals("ME", test_game.getSideWord(true, "M", 1, 6));
        test_game.displayBoard();
    }
    @Test
    public void testSideWordSouth(){

        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1)); player.addTile(new Tile("E",1)); player.addTile(new Tile("R",1));
        assertTrue(test_game.moveController("a,8,^,merger", player));
        test_game.displayBoard();

        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1)); player.addTile(new Tile("E",1)); player.addTile(new Tile("R",1));
        assertEquals("ME", test_game.getSideWord(true, "M", 1, 6));
        assertEquals("ME", test_game.getSideWord(false, "M", 1, 6));
        assertEquals(true, test_game.checkMove(1, 6, "ME", false,  player));
        assertEquals(true, test_game.checkMove(1, 6, "ME", true,  player));
        assertTrue(test_game.moveController("b,7,^,me", player));
        test_game.displayBoard();
    }

    @Test
    public void testDisplayBoard(){
        test_game.displayBoard();
    }
    */
    /*
    @Test
    public void testSideWordWest(){
        //set up board to test for
        test_game.setNum_players(1);
        Player player = new Player("test_player", test_game);
        test_game.getPlayers().add(player);
        test_game.getScores().put(player,0);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));
        player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("E",1));
        int move1 = test_game.makeMove(2,2,"MERGE",true,player);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));
        player.addTile(new Tile("E",1));
        boolean move2 = test_game.moveController("A,8,^,MERGE",player);
        assertTrue(move2);
        //test_game.displayBoard();
    }


    @Test
    public void testSideWordWest2(){

        test_game.setNum_players(1);
        Player player = new Player("test_player", test_game);
        test_game.getPlayers().add(player);
        test_game.getScores().put(player,0);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));
        player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("E",1));
        int move1 = test_game.makeMove(2,2,"MERGE",true,player);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));
        player.addTile(new Tile("E",1));
        boolean move2 = test_game.implementMove("B,8,^,MERGE",player);
        test_game.displayBoard();
        assertFalse(move2);

    }
    */

}
