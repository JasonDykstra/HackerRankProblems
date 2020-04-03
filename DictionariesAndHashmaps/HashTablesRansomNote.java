import java.util.HashMap;
import java.util.Map;

public class HashTablesRansomNote {

    //My Answer:
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magMap = new HashMap<String, Integer>();
        HashMap<String, Integer> noteMap = new HashMap<String, Integer>();

        //initialize magMap
        for(int i = 0; i < magazine.length; i++){
            //if you come across a duplicate word, add one to the value
            if(magMap.containsKey(magazine[i])){
                magMap.replace(magazine[i], magMap.get(magazine[i]) + 1);
                //otherwise, create a new key and give it a value of 1
            } else {
                magMap.put(magazine[i], 1);
            }
        }

        //initialize noteMap
        for(int i = 0; i < note.length; i++){
            if(noteMap.containsKey(note[i])){
                noteMap.replace(note[i], noteMap.get(note[i]) + 1);
            } else {
                noteMap.put(note[i], 1);
            }
        }

        //cross-reference the note and the magazine
        for(String s : noteMap.keySet()){
            if(!magMap.containsKey(s) || (magMap.get(s) < noteMap.get(s))){
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }





    //Answer (A little different input):
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public void Solution(String magazine, String note) {
        this.noteMap = new HashMap<String, Integer>();
        this.magazineMap = new HashMap<String, Integer>();

        // Must use an object instead of a primitive because it may be assigned a null reference.
        Integer occurrences;

        for(String s : magazine.split("[^a-zA-Z]+")) {
            occurrences = magazineMap.get(s);

            if(occurrences == null) {
                magazineMap.put(s, 1);
            }
            else {
                magazineMap.put(s, occurrences + 1);
            }
        }

        for(String s : note.split("[^a-zA-Z]+")) {
            occurrences = noteMap.get(s);

            if(occurrences == null) {
                noteMap.put(s, 1);
            }
            else {
                noteMap.put(s, occurrences + 1);
            }
        }

    }

    public void solve() {
        boolean canReplicate = true;
        for(String s : noteMap.keySet()) {
            if(!magazineMap.containsKey(s) || (magazineMap.get(s) < noteMap.get(s)) ) {
                canReplicate = false;
                break;
            }
        }

        System.out.println( (canReplicate) ? "Yes" : "No" );
    }
}
