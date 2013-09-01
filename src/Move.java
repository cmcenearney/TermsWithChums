import java.util.ArrayList;

public class Move {

    //attributes
    private Game game;
    private ArrayList<String> side_words = new ArrayList<String>();
    private int row;
    private int column;
    private String word;
    private boolean across;
    private Player player;

    //constructor(s)
    public Move (Game game, int row, int column, String word, boolean across, Player player){
        this.game = game; this.row = row; this.column = column; this.word = word; this.across = across; this.player = player;
    }

    //methods
    public boolean validateMove() {

        //first check that it's a word
        if (!game.validWord(word)) {
            System.out.println(word + " is not a valid word (in our dictionary).");
            return false;
        }

        //then check that it isn't too long
        if (across) {
            if (column + word.length() >= Board.board_size) {
                System.out.println(word + " is too big for this space.");
                return false;
            }
        } else {
            if (row + word.length() >= Board.board_size) {
                System.out.println(word + " is too big for this space.");
                return false;
            }
        }

        //then check that it will work
        boolean is_first_word = game.board.isEmpty();
        boolean intersects_existing_word = false;
        ArrayList<String> tile_values = player.getTileValues();

        for (int i = 0; i < word.length(); i++) {
            BoardSpace current_space;
            String current_letter = Character.toString(word.charAt(i));
            if (across) {
                current_space = game.board.getSpace(row, (column + i));
            }
            else {
                current_space = game.board.getSpace((row+i), column);
            }
            boolean space_occupied = current_space.isOccupied();
            String current_space_value = current_space.getValue();

            // there is a letter on the space and it's *not* the right letter of the word we're checking
            if (space_occupied && !current_letter.equals(current_space_value)) {
                return false;
            }
            // there is a letter on the space and it *is* the right letter of the word we're checking
            else if (space_occupied && current_letter.equals(current_space_value)) {
                //intersects_existing_word = true;
                continue;
            }
            // the space is empty and player has a tile for the letter, pop the letter off tile_values
            else if (!space_occupied && tile_values.contains(current_letter)) {
                //tile_values.remove(current_letter);
            }
            // the space is empty and player doesn't have a tile for the letter
            else if (!space_occupied && !tile_values.contains(current_letter)) {
                return false;
            }
        }

        return true;

    }

    //
    public int checkSideWords(boolean across, String character, int row, int column){
        int score = 0;
        // if tiles on both side are empty, return 0
        if (across) {
            if ( !game.board.getSpace(row+1, column).isOccupied() &&  !game.board.getSpace(row-1, column).isOccupied() ) {
                return score;
            }
        }
        else if (!game.board.getSpace(row, column+1).isOccupied() &&  !game.board.getSpace(row, column-1).isOccupied()) {
            return score;
        }
        //if tiles on both sides are occupied get the word, check it, if its valid score it, if not print it out w/error message and return -1
        if ( (across && (game.board.getSpace(row+1, column).isOccupied() &&  game.board.getSpace(row-1, column).isOccupied()) )  ||  (!across && (game.board.getSpace(row, column+1).isOccupied() &&  game.board.getSpace(row, column-1).isOccupied()) )   ) {

        }

        return score;
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


}
