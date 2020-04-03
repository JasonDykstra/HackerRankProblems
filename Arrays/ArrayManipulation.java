public class ArrayManipulation {

    //My first solution (runtime error on 7/15 test cases):
    static long arrayManipulation(int n, int[][] queries) {
        //let's try this the obvious way and see if i can make it more efficient after
        //sometimes the answer becomes more obvious when you write out a working solution

        //remember the given indexes are 1-indexed
        long[] result = new long[n];

        for(int i = 0; i < queries.length; ++i){
            for(int j = queries[i][0] - 1; j <= queries[i][1] - 1; ++j){
                result[j] += queries[i][2];
            }
        }

        long max = 0L;
        for(int i = 0; i < result.length; ++i){
            max = (result[i] > max) ? result[i] : max;
        }
        return max;

    }

    /*
    I thought giving the obvious solution was worth a shot, time to refine it and get clever somehow...
     */


    //My second solution (worked):
    static long arrayManipulation2(int n, int[][] queries) {

        /*
        Thought process:
        - maybe something to do with tracking an interval of interest,
        then add up the values after you have your narrow down your index of interest?
        - could add "weights" to intervals, but that's just a restatement of the given
        array
        - could possibly do something with adding the interval bounds together?
        - maybe only check to see if the lower bounds are > < = each other?
        - all of these possibilities sound like there's some underlying mathematical
        solution I'm not seeing
        - perhaps if I find a mathematical relationship I can use it to do only
        comparisons and not a nested for loop?
        - I've been trying to think of this represented graphically too, but nothing's
        popping into my head as far as a solution goes
        - Looked at discussions for a hint and saw someone focusing on the difference
        between values rather than the values themselves, might try to work off of this
        approach
        */

        //remember the given indexes are 1-indexed
        //this array will keep track of where the difference in values occurs
        //to elaborate: add the value at the index where the range begins, and subtract
        //the value at the index where the range ends + 1
        long[] result = new long[n];

        //initialize result
        for(int i = 0; i < result.length; ++i) result[i] = 0L;

        //loop over the queries array and add the increase in value to the start index in result,
        //subtract it from the index one after the range ends to show the decrease in value
        for(int i = 0; i < queries.length; ++i){
            int beginIndex = queries[i][0] - 1;
            int endIndex = queries[i][1];
            int value = queries[i][2];
            result[beginIndex] += value;
            if(endIndex < result.length) result[endIndex] -= value;
        }

        //this loop is used to find the maximum value by adding or subtracting to max
        //as you iterate over the difference-array (result)
        long max = 0;
        long currentSum = 0;
        for(int i = 0; i < result.length; ++i){
            currentSum += result[i];
            max = (currentSum > max) ? currentSum : max;
        }

        return max;

    }




    //Answer:
    //same concept as my solution

}
