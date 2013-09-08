import org.junit.Test;

public class GameViewTest {

    GameModel test_game = new GameModel();
    GameController test_cntrl = new GameController(test_game, true);

    @Test
    public void colors(){
        test_cntrl.view.printLine(GameView.ANSI_BLUE + "testing colors!" + GameView.ANSI_RESET);
    }
}
