/*
TODO: store this as config data somewhere!
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class BoardConfig {

    public List<ArrayList<String>> scrabble_style = new ArrayList<ArrayList<String>>(15);

    public BoardConfig() {

        String[] row1 = { "triple_word",  "normal",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "triple_word",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "normal",  "triple_word"};
        String[] row2 = { "normal",  "double_word",  "normal",  "normal",  "normal",  "triple_letter",  "normal",  "normal",  "normal",  "triple_letter",  "normal",  "normal",  "normal",  "double_word",  "normal"};
        String[] row3 = { "normal",  "normal",  "double_word",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal"};
        String[] row4 = { "double_letter",  "normal",  "normal",  "double_word",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal",  "double_letter"};
        String[] row5 = { "normal",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal",  "triple_letter",  "normal"};
        String[] row6 = { "normal",  "triple_letter",  "normal",  "normal",  "normal",  "triple_letter",  "normal",  "normal",  "normal",  "triple_letter",  "normal",  "normal",  "normal",  "normal",  "normal"};
        String[] row7 = { "normal",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "normal"};
        String[] row8 = { "triple_word",  "normal",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "normal",  "triple_word"};
        String[] row9 = { "normal",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "normal"};
        String[] row10 = { "normal",  "triple_letter",  "normal",  "normal",  "normal",  "triple_letter",  "normal",  "normal",  "normal",  "triple_letter",  "normal",  "normal",  "normal",  "triple_letter",  "normal"};
        String[] row11 = { "normal",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal",  "normal",  "normal"};
        String[] row12 = { "double_letter",  "normal",  "normal",  "double_word",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal",  "double_letter"};
        String[] row13 = { "normal",  "normal",  "double_word",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "double_word",  "normal",  "normal"};
        String[] row14 = { "normal",  "double_word",  "normal",  "normal",  "normal",  "triple_letter",  "normal",  "normal",  "normal",  "triple_letter",  "normal",  "normal",  "normal",  "double_word",  "normal" };
        String[] row15 = { "triple_word",  "normal",  "normal",  "double_letter",  "normal",  "normal",  "normal",  "triple_word",  "normal",  "normal",  "normal",  "double_letter",  "normal",  "normal",  "triple_word"};

        scrabble_style.add(new ArrayList<String>(Arrays.asList(row1)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row2)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row3)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row4)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row5)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row6)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row7)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row8)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row9)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row10)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row11)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row12)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row13)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row14)));
        scrabble_style.add(new ArrayList<String>(Arrays.asList(row15)));


    }

}
