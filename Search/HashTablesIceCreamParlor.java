import java.util.HashMap;

public class HashTablesIceCreamParlor {

    //My answer (runtime error):
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> flavorCosts = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> duplicateFlavorCosts = new HashMap<Integer, Integer>();

        //initialize flavorCosts and duplicateFlavorCosts hash maps
        for(int i = 0; i < cost.length; i++){
            if(flavorCosts.containsKey(cost[i])){
                if(!duplicateFlavorCosts.containsKey(cost[i])){
                    duplicateFlavorCosts.put(cost[i], i + 1);
                }
            } else {
                flavorCosts.put(cost[i], i + 1);
            }
        }

        //see if each pair of numbers that could add up to money is in the hash map
        for(int i = 1; i < Math.floor(money/2) + 1; i++){
            if((flavorCosts.containsKey(i) && flavorCosts.containsKey(money - i))){
                if((i == money - i && duplicateFlavorCosts.containsKey(i))) {
                    System.out.println(flavorCosts.get(i) + " " + duplicateFlavorCosts.get(i));
                    return;
                } else if(flavorCosts.get(i) < flavorCosts.get(money - i)){
                    System.out.println(flavorCosts.get(i) + " " + flavorCosts.get(money - i));
                    return;
                } else {
                    System.out.println(flavorCosts.get(money - i) + " " + flavorCosts.get(i));
                    return;
                }
            }
        }
    }
    /*
    I attempted to keep track of the duplicate costs and their corresponding indices by creating
    a separate hashmap, but in the end it proved too slow.
     */



    //Answer:
    static void whatFlavors2(int[] cost, int money) {
        HashMap<Integer, Integer> costs = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] < money) {
                if (costs.containsKey(money - cost[i])) {
                    int index = costs.get(money - cost[i]);
                    System.out.println((index + 1) + " " + (i + 1));
                    return;
                }

                if (!costs.containsKey(cost[i])) {
                    costs.put(cost[i], i);
                }
            }
        }
    }
    /*
    This person dealt with duplicates and keeping track of 2 indices by using the for loop index (i)
    as a placeholder for the other index of the duplicate cost.
     */
}
