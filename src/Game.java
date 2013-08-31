import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
TODO: handle side words (in direction other than the main move)
    - scoring - keep track of them during checkMove() somehow?
    - checking - maybe something like  public String checkForSideWord(direction, character, row, column){}

TODO: write more tests:
    - make sure the total set of tiles ( board + players + bag) stays the same
TODO: overall refactor!
 */
public class Game {
    //attribute
    public static final int num_tiles = 7;
    private HashSet<String> dictionary = new HashSet<String>();
    private Board board = new Board();
    protected HashMap<Player, Integer> scores = new HashMap();
    protected List<Player> players = new ArrayList<Player>();
    protected Integer num_players = 2;
    private Integer current_turn = 0;
    protected TileBag tile_bag = new TileBag();

    //constructors
    public Game(){
        this.createDictionary();
    }

    //getters,setters
    public HashMap<Player, Integer> getScores() {
        return scores;
    }
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


    public boolean implementMove(String move,Player current_player){
        if (move.equals("PASS")){
            System.out.println("Ok, you are passing. Better luck next time.");
            return true;
        }
        if (move.equals("SHUFFLE") || move.equals("S")){
            current_player.shuffleTiles();
            //System.out.println(current_player.getName() + ", it's your move. Tiles: " + current_player.listTiles() );
            return false;
        }
        String[] args = move.split(",");

        if (args[0].equals("EXCHANGE")){
            //TODO: implement method to exchange tiles
            ArrayList<String> exchanges = new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
            System.out.println("Exchanging: " + exchanges.toString());
            current_player.exchangeTiles(exchanges);
            return true;
        }

        int row = ( (int) args[0].charAt(0)) - 65;
        int column = Integer.parseInt(args[1]) - 1;
        boolean across = (args[2].equals(">"));
        String word = args[3];
        if ( checkMove(row, column, word, across, current_player) ) {
            int move_score = makeMove(row, column, word, across, current_player);
            System.out.println("Well done, that move scored " + move_score + " points.");
            int new_total_score = scores.get(current_player) + move_score;
            scores.put(current_player,new_total_score);
            while (current_player.getTiles().size() < num_tiles){
                current_player.addTile(tile_bag.randomDraw());
            }
            return true;
        }
        else {
            System.out.println("invalid move");
            return false;
        }
    }
    /*
    public String checkForSideWord(direction, character, row, column){}
    looking along an axis - left<>right or up<>down - there are four possibilities:
    - word to one side
    - word to other side
    - word to neither side
    - placing character connects both sides, creating one huge new word

    */
    /*
    public ArrayList<String> checkForSideWord(boolean across, String character, int row, int column){
        ArrayList<String> side_words = new ArrayList<String>();
        BoardSpace next_space = new BoardSpace();
        if (across){
            //look east
            next_space = board.getSpace(row, column);
            while (next_space.isOccupied() ){

            }
            //look west
            while (next_space.isOccupied()){

            }
        }
        else {
            //look north
            while (next_space.isOccupied()){

            }
            //south
            while (next_space.isOccupied()){

            }
        }
        return side_words;
    }
    */
    public boolean checkMove(int row, int column, String word, boolean across, Player player) {

        //first check that it's a word
        if (!validWord(word)) {
            return false;
        }

        //then check that it isn't too long
        if (across) {
            if (column + word.length() >= Board.board_size) {
                return false;
            }
        } else {
            if (row + word.length() >= Board.board_size) {
                return false;
            }
        }

        //then check that it will work
        boolean is_first_word = board.isEmpty();
        boolean intersects_existing_word = false;
        ArrayList<String> tile_values = player.getTileValues();
        //iterate over the proposed word / board spaces and check at each space/letter that it is possible
        for (int i = 0; i < word.length(); i++) {
            BoardSpace current_space;
            String current_letter = Character.toString(word.charAt(i));
            if (across) {
                current_space = board.getSpace(row, (column + i));
            }
            else {
                current_space = board.getSpace((row+i), column);
            }
            boolean space_occupied = current_space.isOccupied();
            String current_space_value = current_space.getValue();
            // there is a letter on the space and it's *not* the right letter of the word we're checking
            if (space_occupied && !current_letter.equals(current_space_value)) {
                return false;
            }
            // there is a letter on the space and it *is* the right letter of the word we're checking
            else if (space_occupied && current_letter.equals(current_space_value)) {
                intersects_existing_word = true;
                continue;
            }
            // the space is empty and player has a tile for the letter, pop the letter off tile_values
            else if (!space_occupied && tile_values.contains(current_letter)) {
                // this is a stub to check the letter around it
                if (!across) {
                    // TODO: Check it there is a move to the north and the south
                    // Want to check column + i + 1 && column + i - 1
                    // STart with down
                    int next_col = column + 1 + i;
                    BoardSpace next_space = board.getSpace(row, next_col);
                    String new_word = new String();
                    new_word += current_letter; //current_space.getValue();
                    while (next_space.isOccupied()) {
                        new_word += next_space.getValue();
                        next_col++;
                        next_space = board.getSpace(row, next_col);
                    }
                    if (new_word.length() > 1 && !validWord(new_word)) {
                        return false;
                    } else {
                        // TODO: Calculate and return more points
                        intersects_existing_word = true;
                    }
                    // Start with up
                    next_col = column - 1 + i;
                    next_space = board.getSpace(row, next_col);
                    new_word = current_letter;
                    while (next_space.isOccupied()) {
                        new_word = next_space.getValue() + new_word;
                        next_col--;
                        next_space = board.getSpace(row, next_col);
                    }
                    if (new_word.length() > 1 && !validWord(new_word)) {
                        return false;
                    } else {
                        // TODO: Calculate and return more points
                        intersects_existing_word = true;
                    }
                } else {
                    // TODO: Check it there is a move to the east and the west
                    // Want to check row + i + 1 && row + i - 1
                    // Start with west
                    int next_row = row + 1 + i;
                    BoardSpace next_space = board.getSpace(next_row, column);
                    String new_word = current_letter;
                    while (next_space.isOccupied()) {
                        new_word += next_space.getValue();
                        next_row++;
                        next_space = board.getSpace(next_row, column);
                    }
                    if (new_word.length() > 1 && !validWord(new_word)) {
                        return false;
                    } else {
                        // TODO: Calculate and return more points
                        intersects_existing_word = true;
                    }
                    // Start with east
                    next_row = row - 1 + i;
                    next_space = board.getSpace(next_row, column);
                    new_word = current_letter;
                    while (next_space.isOccupied()) {
                        new_word = next_space.getValue() + new_word;
                        next_row--;
                        next_space = board.getSpace(next_row, column);
                    }
                    if (!validWord(new_word)) {
                        continue;
                    } else {
                        // TODO: Calculate and return more points
                        intersects_existing_word = true;
                    }
                }
                tile_values.remove(current_letter);
            }
            // the space is empty and player doesn't have a tile for the letter
            else if (!space_occupied && !tile_values.contains(current_letter)) {
                return false;
            }
        }
        return (is_first_word || intersects_existing_word);
    }

    public int makeMove(int row, int column, String word, boolean across, Player player) {
        int score = 0;
        int multiplicative_factor = 1;
        for (int i = 0; i < word.length(); i++) {
            BoardSpace current_space;
            if (across) {
                current_space  = board.getSpace(row, (column + i));
            }
            else {
                current_space  = board.getSpace((row+i), column);
            }
            String current_space_value = current_space.getValue();
            String current_letter = Character.toString(word.charAt(i));
            boolean space_occupied = current_space.isOccupied();
            if (!space_occupied ) {
                String type = current_space.getType();
                current_space.setValue(current_letter);
                player.removeTile(current_letter);
                int p = TileConfig.tile_config.get(current_letter).points;
                //valid_types = {"double_letter","double_word","triple_letter", "triple_word", "plain"};
                if (type.equals("triple_letter")) {
                    score += (p*3);
                }
                else if (type.equals("double_letter")) {
                    score += (p*2);
                }
                else if (type.equals("triple_word")) {
                    multiplicative_factor *= 3;
                    score += p;
                }
                else if (type.equals("double_word")) {
                    multiplicative_factor *= 2;
                    score += p;
                }
                else if (type.equals("plain")) {
                    score += p;
                }
            }
            else if (space_occupied){
                int p = TileConfig.tile_config.get(current_space_value).points;
                score += p;
            }
        }
        return score*multiplicative_factor;
    }

    //control-flow + output stuff
    public void displayBoard(){
        //top guide row
        System.out.print("   ");
        for (int i = 0; i < Board.board_size; i++){
            if (Integer.toString(i+1).length() == 1) {
                System.out.print(" ");
            }
            System.out.print( (i+1) + " " );
        }
        System.out.print("\n");
        // remaining rows
        for (int i = 0; i < Board.board_size; i++){
            //make the "gutter" - convert row index to char A-O
            System.out.print(" " + Character.toString((char) (i + 65)) + " ");
            for (BoardSpace space : this.board.getRow(i)){
                if (space.isOccupied()){
                    System.out.print(" " + space.getValue() + " ");
                }
                else {
                    String output = this.board.empty_space_values.get(space.getType());
                    System.out.print(output);
                }
            }
            System.out.print("\n");
        }
    }

    public void preGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO TERMS WITH CHUMS!");
        System.out.println("How many players? (1-4)");
        int num = scanner.nextInt();
        this.num_players = num;
        for (int i = 0; i < num_players; i++){
            System.out.println("Enter name for player " + (i+1) + ":");
            String name = scanner.next();
            Player player = new Player(name, this);
            players.add(i,player);
            scores.put(player,0);
            for (int j=0; j < num_tiles; j++){
                Tile t = tile_bag.randomDraw();
                player.addTile(t);
            }
        }
        System.out.println("OK, let's play.");
        System.out.println();
    }


    //TODO: do this for real - atm this is just to get things running
    // move must be of form {row},{colummn},{direction: either '>' or '^'}, {WORD}
    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        while (tile_bag.getTiles().size() > 0){
            Player current_player = players.get(current_turn);
            displayBoard();
            System.out.println(current_player.getName() + ", it's your move. Score: " + scores.get(current_player) + ". Tiles: " + current_player.listTiles() );
            String move = scanner.next();
            if (implementMove(move,current_player) ) {
                current_turn = (current_turn + 1) % num_players;
            }
        }

    }

}
