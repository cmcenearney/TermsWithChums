/**
 * Created with IntelliJ IDEA.
 * User: strivedi
 * Date: 9/4/13
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ScoreSaver {

    public static HashMap<String, int[]> allScores = new HashMap<String, int[]>();

    public ScoreSaver(String username, boolean isWinner) {

        ScoreSaver.getAllScores();
        ScoreSaver.addScore(username, isWinner);
        ScoreSaver.saveToFile(username, isWinner);

    }

    public static void getAllScores() {

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("resources/scores.txt"));

            while ((sCurrentLine = br.readLine()) != null) {

                String[] stringScore = sCurrentLine.split(",");
                int score[] = new int[2];
                String username = stringScore[0];
                int wins = Integer.parseInt(stringScore[1]);
                int losses = Integer.parseInt(stringScore[2]);
                score[0] = wins;
                score[1] = losses;
                allScores.put(username, score);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void addScore (String username, boolean win) {
        if (allScores.containsKey(username)) {
            int scores[] = allScores.get(username);
            if (win == true) {
                scores[0] += 1;
            } else {
                scores[1] += 1;
            }
            allScores.put(username, scores);
        } else {
            int scores[] = new int[2];
            if (win == true) {
                scores[0] = 1;
                scores[1] = 0;
            } else {
                scores[0] = 0;
                scores[1] = 1;
            }
            allScores.put(username, scores);
        }
    }

    public static void saveToFile(String username, boolean win) {

        try
        {
            File file = new File("resources/scores.txt");

            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            Map<String, int[]> map = allScores;

            for (Map.Entry<String, int[]> entry : map.entrySet()) {
                String printUsername = entry.getKey();
                int[] printScores = entry.getValue();
                int printWins = printScores[0];
                int printLosses = printScores[1];
                bw.append(printUsername);
                bw.append(',');
                String printWinsToString = Integer.toString(printWins);
                bw.append(printWinsToString);
                bw.append(',');
                String printLossesToString = Integer.toString(printLosses);
                bw.append(printLossesToString);
                bw.append('\n');
            }
            bw.flush();
            bw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
