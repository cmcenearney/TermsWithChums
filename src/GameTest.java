import org.junit.Test;
import static org.junit.Assert.*;


//import java.nio.file;

public class GameTest {

    Game test_game = new Game();

//    @Before
//    public void setUpTest(){
//        test_game.num_players = 1;
//        Player player = new Player();
//        test_game.players.add(player);
//        test_game.scores.put(player,0);
//        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));
//        player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("E",1));
//        boolean move1 = test_game.implementMove("C,3,>,MERGE",player);
//
//    }


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
        boolean move2 = test_game.implementMove("A,8,^,MERGE",player);
        assertTrue(move2);
        //test_game.displayBoard();
    }

    /*
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
