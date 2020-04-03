import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {

    //My answer:
    static String twoStrings(String s1, String s2) {
        HashMap<String, Integer> string1 = new HashMap<String, Integer>();
        HashMap<String, Integer> string2 = new HashMap<String, Integer>();

        //add all characters of string 1 to its corresponding hash map
        for(int i = 0; i < s1.length() - 1; i++){
            string1.put(s1.substring(i, i+1), 0);
        }

        //add all characters of string 2 to its corresponding hash map
        for(int i = 0; i < s2.length() - 1; i++){
            string2.put(s2.substring(i, i+1), 0);
        }

        //cross reference the two hash maps and see if there are any characters in common
        for(String s : string1.keySet()){
            if(s2.contains(s)){
                return "YES";
            }
        }
        return "NO";
    }
    /*
    Would've used hash sets as opposed to hash maps with useless values, but didn't
    know how to compare the two or create an intersection using hash sets.
     */


    //Answer:
    static Set<Character> a;
    static Set<Character> b;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < n; i++) {
            a = new HashSet<Character>();
            b = new HashSet<Character>();

            //creating the set of string1
            for(char c : scan.next().toCharArray()) {
                a.add(c);
            }
            //creating the set of string2
            for(char c : scan.next().toCharArray()) {
                b.add(c);
            }

            // store the set intersection in set 'a'
            a.retainAll(b);

            System.out.println( (a.isEmpty()) ? "NO" : "YES" );
        }
        scan.close();
    }
    /*
    Used hash sets which I was going to do, but didn't know how to compare the two. Interesting to know
     */
}
