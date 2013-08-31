import java.util.ArrayList;

public class Move {

    private Game game;
    private ArrayList<String> side_words = new ArrayList<String>();
    private int row;
    private int column;
    private String word;
    private boolean across;

    public Move (Game game, int row, int column, String word, boolean across){
        this.game = game; this.row = row; this.column = column; this.word = word; this.across = across;
    }

    public boolean validateMove() {
        //first check that it's a word
        if (!game.validWord(word)) {
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

        return true;

    }





}
