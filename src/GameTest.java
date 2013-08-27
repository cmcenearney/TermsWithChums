import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
    public void setUpTest(){
        //set up board to test for side words
        test_game.num_players = 1;
        Player player = new Player();
        test_game.players.add(player);
        test_game.scores.put(player,0);
        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));
        player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("E",1));
        int move1 = test_game.makeMove(2,2,"MERGE",true,player);

        player.addTile(new Tile("M",1));player.addTile(new Tile("E",1));player.addTile(new Tile("R",1));player.addTile(new Tile("G",1));
        player.addTile(new Tile("E",1));
        boolean move2 = test_game.implementMove("A,8,^,MERGE",player);
        assertTrue(move2);
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
