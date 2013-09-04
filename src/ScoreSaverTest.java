import org.junit.Before;
import org.junit.Test;

public class ScoreSaverTest {

    GameModel test_game = new GameModel();
    GameController test_cntrl = new GameController(test_game, true);
    Player player1 = new Player("sandip",test_game);
    Player player2 = new Player("beyonce",test_game);

    @Before
    public void setUp(){
        test_game.num_players = 2;
        test_game.players.add(player1);
        test_game.players.add(player2);
        player1.setScore(250);
        player2.setScore(220);
        while (test_game.tile_bag.getTiles().size() > 0){
            test_game.tile_bag.randomDraw();
        }
    }

    @Test
    public void testScoreSaver(){
        test_cntrl.playGame();
    }
}
