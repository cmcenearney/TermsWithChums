import java.util.ArrayList;
import java.util.List;

public class Player {

    //attributes
    private List<Tile> tiles = new ArrayList<Tile>();
    private String name;
    private Game game;

    //constructors
    public Player() {}

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    //getters + setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Tile> getTiles(){
        return this.tiles;
    }

    //methods
    public void addTile(Tile tile){
        tiles.add(tile);
    }

    public String listTiles(){
        String output = "[ ";
        for (Tile t : tiles){
            output += t.getCharacter();
            output += " ";
        }
        output += "]";
        return output;
    }

    public ArrayList<String> getTileValues(){
        ArrayList<String> tile_values = new ArrayList<String>();
        for (Tile t : tiles){
            tile_values.add(t.getCharacter());
        }
        return tile_values;
    }

    public boolean removeTile(String s){
        for (Tile t : tiles){
            if (t.getCharacter().equals(s)){
                tiles.remove(t);
                return true;
            }
        }
        return false;
    }

    //TODO overhaul this - need to able to exchange "N,N" or "N" - correctly handle multiple tiles with same value
    public ArrayList<String> exchangeTiles(ArrayList<String> exchanges){
        ArrayList<String> ex_s = new ArrayList<String>();
        ArrayList<Tile> ex_tiles = new ArrayList<Tile>();
        for (String s : exchanges){
            for (Tile t : tiles){
               if (t.getCharacter().equals(s)){
                   ex_s.add(s);
                   game.getTile_bag().addTile(t);
                   ex_tiles.add(t);
                   continue;
               }
            }
        }
        for (Tile t : ex_tiles){
            tiles.remove(t);
        }
        for (String s : ex_s){
            tiles.remove(s);
        }
        while (tiles.size() < Game.num_tiles){
            tiles.add(game.getTile_bag().randomDraw());
        }
        return exchanges;
    }

    public void shuffleTiles(){
        int num_swaps = Game.num_tiles / 2;
        for (int i = 0; i < num_swaps; i++){
            int random_index1 = (int)(Math.random() * tiles.size());
            int random_index2 = (int)(Math.random() * tiles.size());
            Tile tmp = tiles.get(random_index1);
            tiles.set(random_index1,tiles.get(random_index2));
            tiles.set(random_index2, tmp);
        }
    }
}
