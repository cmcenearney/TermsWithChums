import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TileBagTest {

    public TileBag test_bag = new TileBag();

    @Test
    public void testTileInit(){
        for (Tile tile : test_bag.getTiles()){
            System.out.println(tile.getCharacter());
        }
    }

}
