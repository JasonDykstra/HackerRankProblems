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


}
