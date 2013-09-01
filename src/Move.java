import java.util.ArrayList;

public class Move {

    public class SideWord {
        public final String word;
        public final int points;
        public SideWord(String s, int y) {
            this.word = s;
            this.points = y;
        }
    }

    //attributes
    private Game game;
    private ArrayList<SideWord> side_words = new ArrayList<SideWord>();
    private int row;
    private int column;
    private String word;
    private boolean across;
    private Player player;
    protected Board board;

    //constructor(s)
    public Move (Game game, int row, int column, String word, boolean across, Player player){
        this.game = game; this.row = row; this.column = column; this.word = word; this.across = across; this.player = player; this.board = game.board;
    }

    //methods
    public boolean sideWord(boolean across, String character, int row, int column){
        String side_word = character;
        int points = 0;

        // look in the positive direction starting one tile over, if occupied, append to side-word, continue
        int pos_ind;   if (across) {pos_ind = row+1;} else {pos_ind = column+1;}
        BoardSpace next_space;
        while(pos_ind < Board.board_size) {
            if (across) { next_space = board.getSpace(pos_ind, column);} else {next_space = board.getSpace(row,pos_ind);}
            if (next_space.isOccupied()){
                side_word += next_space.getValue();
                points += TileConfig.tile_config.get(next_space.getValue()).points;
                pos_ind++;
            } else {
                break;
            }
        }
        // look in the negative direction starting one tile over, if occupied, prepend to side-word, continue
        int neg_ind;   if (across) {neg_ind = row-1;} else {neg_ind = column-1;}
        while(neg_ind >= 0) {
            if (across) { next_space = board.getSpace(neg_ind, column);} else {next_space = board.getSpace(row,neg_ind);}
            if (next_space.isOccupied()){
                side_word = next_space.getValue() + side_word;
                neg_ind--;
                points += TileConfig.tile_config.get(next_space.getValue()).points;
            } else {
                break;
            }
        }

        if (side_word.length() == 1) {
            return true;
        }
        else if (side_word.length() > 1 && !game.validWord(side_word)){
            return false;
        }
        else if (side_word.length() > 1 && game.validWord(side_word)){
            //score the word
            String type = board.getSpace(row, column).getType();
            int multiplicative_factor = 1;
            if (type.equals("triple_word")) { multiplicative_factor = 3;}
            else if (type.equals("double_word")) { multiplicative_factor = 2;}
            int placed_tile_score = TileConfig.tile_config.get(board.getSpace(row, column).getValue()).points;
            if (type.equals("triple_letter")) { placed_tile_score *= 3;}
            else if (type.equals("double_letter")) { placed_tile_score *= 2;}
            points += placed_tile_score;
            points *= multiplicative_factor;
            side_words.add(new SideWord(side_word, points));
            return true;
        }
        return false;
    }

    public boolean checkMove(int row, int column, String word, boolean across, Player player) {

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

        //then check that it will work
        boolean is_first_word = board.isEmpty();
        boolean intersects_existing_word = false;
        ArrayList<String> tile_values = player.getTileValues();

        //iterate over the proposed word / board spaces and check at each space/letter that it is possible
        for (int i = 0; i < word.length(); i++) {
            int x = row; int y = column;
            String current_letter = Character.toString(word.charAt(i));
            if (across) { y = column + i; } else {  x = row + i; }
            BoardSpace current_space = board.getSpace(x,y);
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

            // the space is empty and player has a tile for the letter
            else if (!space_occupied && tile_values.contains(current_letter)) {
                if ( sideWord(across, current_letter, x,y)) {
                    tile_values.remove(current_letter);
                    intersects_existing_word = true;
                }
                else {
                    return false;
                }
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
        score *= multiplicative_factor;
        for (SideWord s : side_words){
            score += s.points;
        }
        return score;
    }


}
