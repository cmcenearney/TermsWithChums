import org.junit.Test;
import static org.junit.Assert.*;

public class TileBagTest {

    public TileBag test_bag = new TileBag();

    @Test
    public void testTileInit(){
        for (Tile tile : test_bag.getTiles()){
            System.out.println(tile.getCharacter());
        }
        assertEquals(98, test_bag.getTiles().size());
    }

    @Test
    public void testDraw(){
        System.out.println("tile bag size: " + test_bag.getTiles().size());
        Tile tile = test_bag.randomDraw();
        System.out.println("1 tile drawn : " + tile.getCharacter());
        System.out.println("tile bag size: " + test_bag.getTiles().size());
        Tile tile2 = test_bag.randomDraw();
        System.out.println("2nd tile drawn : " + tile2.getCharacter());
        System.out.println("tile bag size: " + test_bag.getTiles().size());
        assertEquals(96, test_bag.getTiles().size());
    }

}
