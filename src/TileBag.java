import java.util.ArrayList;
import java.util.List;

public class TileBag {

    private List<Tile> tiles = new ArrayList<Tile>();

    public TileBag(){
        TileConfig config = new TileConfig();
        for (String key : config.tile_config.keySet()) {
            TileConfig.Tuple tuple = config.tile_config.get(key);
            int num = tuple.number;
            int points = tuple.points;
            for (int i = 1; i <= num; i++){
                tiles.add(new Tile(key, points));
            }
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public Tile randomDraw(){
        int random_index = (int )(Math.random() * tiles.size());
        return tiles.remove(random_index);
    }

}
