import java.util.ArrayList;

public class Move {

    //attributes
    private Game game;
    private ArrayList<String> side_words = new ArrayList<String>();
    private int row;
    private int column;
    private String word;
    private boolean across;

    //constructor(s)
    public Move (Game game, int row, int column, String word, boolean across){
        this.game = game; this.row = row; this.column = column; this.word = word; this.across = across;
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

        return true;

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
