import java.util.HashMap;

public class ThisClass {

    String note;
    String magazine;
    HashMap<String, Integer> RuddsNote  = new HashMap<String, Integer>();

    public ThisClass (String n, String m){
        note = n; magazine = m;
    }

    public boolean hasEnoughChars () {
        boolean enough_chars=true;
        for (int i = 0; i <= note.length(); i++) {
            String current =  Character.toString(note.charAt(i));
            if (RuddsNote.get(current)!=null) {
                int tmp = RuddsNote.get(note.charAt(i));
                RuddsNote.put(current, tmp+1);
            }
            else {
                RuddsNote.put(current, 1);
            }
        }
        int counter = 0;
        while (RuddsNote.keySet().size() > 0) {
            String current = Character.toString(magazine.charAt(counter));
            if (RuddsNote.get(current) != null) {
                if (RuddsNote.get(current) == 0 ) {
                    RuddsNote.remove(current);
                }
                else {
                    int tmp = RuddsNote.get(current);
                    RuddsNote.put(current , tmp-1);
                }
            }
            counter++;
            if (counter >= magazine.length()) {
                enough_chars = false;
            }
        }
        return enough_chars;
    }


}
