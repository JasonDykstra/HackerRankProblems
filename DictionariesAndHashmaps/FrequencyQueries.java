import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {

    //My answer (runtime error on one test case):
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> answer = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < queries.size(); i++){

            int type = queries.get(i).get(0);
            int value = queries.get(i).get(1);

            //add to the hashmap
            if(type == 1){
                map.put(value, (map.get(value) == null ? 1 : map.get(value) + 1));

                //remove an item
            } else if(type == 2){
                if(map.containsKey(value) && map.get(value) > 0){
                    map.replace(value, map.get(value) - 1);
                }

                //check map
            } else if(type == 3){
                answer.add(map.containsValue(value) && !map.isEmpty() ? 1 : 0);
            }
        }
        return answer;
    }




}
