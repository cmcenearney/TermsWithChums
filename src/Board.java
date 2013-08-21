import java.util.ArrayList;
import java.util.List;

/*
- should the Board be a singleton?
- how best to store/represent the config, ie which spaces are plain, double letter, etc?
 */

public class Board {

    private static final int board_size = 15;

    private List<ArrayList<BoardSpace>> spaces = new ArrayList<ArrayList<BoardSpace>>(board_size);

    public Board(){
        BoardConfig config = new BoardConfig();
        for (int row = 0; row < board_size; row++){
            spaces.add(row, new ArrayList<BoardSpace>(15));
            for (int col = 0; col < board_size; col++){
                String type = config.scrabble_style.get(row).get(col);
                BoardSpace new_space = new BoardSpace(type);
                spaces.get(row).add(col, new_space);
            }
        }
    }

    public BoardSpace getSpace(int row, int column){
        return spaces.get(row).get(column);
    }
}
