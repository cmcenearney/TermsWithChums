import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Tile> tiles = new ArrayList<Tile>();

    private String name;

    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTile(Tile tile){
        tiles.add(tile);
    }

    public List<Tile> getTiles(){
        return this.tiles;
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
}
