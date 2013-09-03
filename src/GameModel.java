import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameModel {

    //attributes
    public static final int num_tiles = 7;
    private HashSet<String> dictionary = new HashSet<String>();
    protected Board board = new Board();
    protected List<Player> players = new ArrayList<Player>();
    protected Integer num_players = 2;
    protected Integer current_turn = 0;
    protected TileBag tile_bag = new TileBag();
    protected boolean is_first_move = true;

    //constructors
    public GameModel(){
        this.createDictionary();
    }

    //getters + setters
    public List<Player> getPlayers() {
        return players;
    }
    public Integer getNum_players() {
        return num_players;
    }
    public void setNum_players(int n) {
        this.num_players=n;
    }
    public Integer getCurrent_turn() {
        return current_turn;
    }
    public TileBag getTile_bag() {
        return tile_bag;
    }
    public HashSet<String> getDictionary() {
        return dictionary;
    }

    //methods
    public void createDictionary() {
        File file = new File("resources/words.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    this.dictionary.add(line.toUpperCase());
                }
            }
        }
        catch (IOException e){
            System.out.println("problem reading dictionary file:" + e);
        }
    }

    public boolean validWord(String word){
        return this.dictionary.contains(word.toUpperCase());
    }
}
