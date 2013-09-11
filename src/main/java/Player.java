import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {

    //attributes
    private List<Tile> tiles = new ArrayList<Tile>();
    private String name;
    private GameModel game;
    private int score = 0;

    //constructors
    public Player(GameModel game) {
        this.game = game;
    }

    public Player(String name, GameModel game) {
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
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    //implement Comparable
    public int compareTo(Player p)
    {
        return(score - p.score);
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

    //doesn't handle user error: if exchanges contains a char not in tiles
    public ArrayList<String> exchangeTiles(ArrayList<String> exchanges){
        ArrayList<Tile> ex_tiles = new ArrayList<Tile>();
        while (exchanges.size() > 0){
            String s = exchanges.get(0);
            for (Tile t : tiles){
               if (t.getCharacter().equals(s)){
                   game.getTile_bag().addTile(t);
                   ex_tiles.add(t);
                   exchanges.remove(s);
               }
            }
        }
        for (Tile t : ex_tiles){
            tiles.remove(t);
        }
        while (tiles.size() < GameModel.num_tiles){
            tiles.add(game.getTile_bag().randomDraw());
        }
        return exchanges;
    }

    public void shuffleTiles(){
        int num_swaps = GameModel.num_tiles / 2;
        for (int i = 0; i < num_swaps; i++){
            int random_index1 = (int)(Math.random() * tiles.size());
            int random_index2 = (int)(Math.random() * tiles.size());
            Tile tmp = tiles.get(random_index1);
            tiles.set(random_index1,tiles.get(random_index2));
            tiles.set(random_index2, tmp);
        }
    }
}
