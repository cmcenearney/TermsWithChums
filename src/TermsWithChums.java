public class TermsWithChums {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameController controller = new GameController(model);
        controller.preGame(); //calling preGame in GameController's constructor is nice, but messes with the tests right now
    }
}
