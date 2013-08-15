import java.io.*;
import java.util.HashSet;

public class Game {

    private HashSet<String> dictionary = new HashSet<String>();

    public Game(){

        this.createDictionary();

        // TODO
        // createPlayers();
        // createBoard();


    }

    public void createDictionary() {

        File file = new File("resources/words.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    this.dictionary.add(line);
                }
            }
        }
        catch (IOException e){
            System.out.println("problem reading dictionary file:" + e);
        }

    }

    public boolean validWord(String word){
        return this.dictionary.contains(word);
    }

    public HashSet<String> getDictionary() {
        return dictionary;
    }

}
