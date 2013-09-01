import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GameController {

    private GameModel model;
    protected GameView view;
    private Scanner scanner;

    public GameController(GameModel m) {
        this.model = m;
        this.view = new GameView(this.model, this);
        scanner = new Scanner(System.in);
        //preGame();
    }

    //move control - parsing, validation, routing, etc
    public boolean moveController(String move_str,Player current_player){
        move_str = move_str.toUpperCase();
        if (move_str.equals("PASS")  || move_str.equals("P")){
            view.printLine("Ok, you are passing. Better luck next time.");
            return true;
        }
        if (move_str.equals("SHUFFLE") || move_str.equals("S")){
            current_player.shuffleTiles();
            //view.printLine(current_player.getName() + ", it's your move. Tiles: " + current_player.listTiles() );
            return false;
        }
        String[] args = move_str.split(",");

        if (args[0].equals("EXCHANGE")  || args[0].equals("EX")){
            //TODO: validate tiles (player can only exchange tiles that she has)
            ArrayList<String> exchanges = new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
            view.printLine("Exchanging: " + exchanges.toString());
            current_player.exchangeTiles(exchanges);
            return true;
        }
        //TODO: validate move args
        int row = ( (int) args[0].charAt(0)) - 65;
        int column = Integer.parseInt(args[1]) - 1;
        boolean across = (args[2].equals(">"));
        String word = args[3];

        Move move = new Move(model, row, column, word, across, current_player);

        if ( move.checkMove() )  {
            int score = move.makeMove();
            view.printLine("Well done, that move scored " + score + " points.");
            int new_total_score = current_player.getScore() + score;
            current_player.setScore( new_total_score );
            while (current_player.getTiles().size() < model.num_tiles){
                current_player.addTile(model.tile_bag.randomDraw());
            }
            return true;
        }
        else {
            //print message? Move will print its own details about why not valid?
            //view.printLine("invalid move");
            return false;
        }
    }


    //ask num players, names
    public void preGame(){
        view.printLine("WELCOME TO TERMS WITH CHUMS!");
        view.printLine("How many players? (1-4)");
        int num = scanner.nextInt();
        model.num_players = num;
        for (int i = 0; i < model.num_players; i++){
            view.printLine("Enter name for player " + (i+1) + ":");
            String name = scanner.next();
            Player player = new Player(name, model);
            model.players.add(i,player);

            for (int j=0; j < model.num_tiles; j++){
                Tile t = model.tile_bag.randomDraw();
                player.addTile(t);
            }
        }
        view.printLine("OK, let's play.");
        view.printLine("");
        playGame();
    }

    // basic game-play loop
    public void playGame(){
        while (model.tile_bag.getTiles().size() > 0){
            Player current_player = model.players.get(model.current_turn);
            view.displayBoard();
            view.printLine(current_player.getName() + ", it's your move. Score: " + current_player.getScore() + ". Tiles: " + current_player.listTiles() );
            String move = scanner.next();
            if (moveController(move, current_player) ) {
                model.current_turn = (model.current_turn + 1) % model.num_players;
            }
        }
        endGame();
    }

    // when the tilebag is empty
    public void endGame() {
        Collections.sort(model.players);
        view.printLine("There are no more tiles in the bag. Gme over!");
        view.printLine("The winner is " + model.players.get(0).getName());
        for (Player p : model.players){
            view.printLine(p.getName() + " finished with " + p.getScore() + " points.");
        }
        System.exit(0);
    }
}
