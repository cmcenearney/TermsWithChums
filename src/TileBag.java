import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TileBag {

    private List<Tile> tiles = new ArrayList<Tile>();

    public TileBag(){
        TileConfig config = new TileConfig();
        for (String key : config.tile_config.keySet()) {
            int num = config.tile_config.get(key);
            for (int i = 1; i <= num; i++){
                tiles.add(new Tile(key));
            }
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }

}
