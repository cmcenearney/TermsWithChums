
//TODO: get this view passing input back to the controller - at that point this code might be modular enough to wire to a different front-end, maybe Android?
public class GameView {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private GameModel model;
    private GameController controller;

    public GameView(GameModel m, GameController c) {
        this.model = m;
        this.controller = c;
    }

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
            for (BoardSpace space : model.board.getRow(i)){
                if (space.isOccupied()){
                    System.out.print(" " + space.getValue() + " ");
                }
                else {
                    String output = model.board.empty_space_values.get(space.getType());
                    System.out.print(output);
                }
            }
            System.out.print("\n");
        }
    }

    public void printLine(String s){
        System.out.println(s);
    }

    public void print(String s){
        System.out.print(s);
    }

}
