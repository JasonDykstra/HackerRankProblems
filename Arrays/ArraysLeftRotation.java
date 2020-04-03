public class ArraysLeftRotation {

    //My solution:
    static int[] rotLeft(int[] a, int d) {
        int rotationsRemaining = d;
        int[] answer = new int[a.length];
        int[] rotatedNums = new int[d];
        for(int i = 0; i < d; i++){
            rotatedNums[i] = a[i];
        }

        for(int i = 0; i < a.length - d; i++){
            answer[i] = a[i + d];
        }

        for(int i = 0; i < rotatedNums.length; i++){
            answer[answer.length - rotatedNums.length + i] = rotatedNums[i];
        }

        return answer;
    }
    /*
    Create a sub-array with the elements that will be moved to the opposite end
    Create another sub-array with the elements that will be shifted to the start
    Iterate over the array with the elements that should be moved, and add them to the end of the shifted array
     */





    //Answer:
    public static int[] rotateArray(int[] arr, int d){
        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = arr.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Copy segments of shifted elements to rotated array:
        System.arraycopy(arr, d, rotated, 0, n - d);
        System.arraycopy(arr, 0, rotated, n - d, d);

        return rotated;
    }
    /*
    Same concept as what I did, just used System.arraycopy which I forgot existed
    From intuition it looks like the syntax is: (array1, startIndex, array2, startIndex, numIterations)
     */
}
