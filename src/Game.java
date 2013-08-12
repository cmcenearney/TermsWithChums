import java.io.*;
import java.util.ArrayList;


public class Game {

    private ArrayList<String> dictionary;

    public Game(){
        //TODO: get this working!
        File file = new File("/Users/c.mcenearney/TermsWithChums/resources/words.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                dictionary.add(line);
                }
            }
        }
        catch (IOException e){
            System.out.println("problem reading dictionary file:" + e);
        }


        /*   - this should work in Java 7
        Path file = "/Users/c.mcenearney/TermsWithChums/resources/words.txt";
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        */
    }

    // TODO this is just a placeholder, replace with more performant lookup
    public boolean validWord(String word){
        for (String s : dictionary){
            if (s == word){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getDictionary() {
        return dictionary;
    }

}
