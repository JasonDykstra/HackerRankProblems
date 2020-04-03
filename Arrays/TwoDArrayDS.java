public class TwoDArrayDS {

    //My solution:
    static int hourglassSum(int[][] arr) {
        //start the largest sum as the max negative value, which would be 7*(-9) = -63
        int largestSum = -63;

        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                int tempSum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
                largestSum = tempSum > largestSum ? tempSum: largestSum;
            }
        }
        return largestSum;
    }
    /*
    Basically just iterate over the 2d array and sum up the hourglass each time, nothing special;
     */





    //Answer:
    private  static void Sum(int arr[][]){
        //ROw
        int sum=-1000;
        for(int i =0 ; i<4;i++){
            for(int x =0 ; x<4; x++){

                int top = arr[i][x]+arr[i][x+1]+arr[i][x+2];
                int middle = arr[i+1][x+1];
                int bottom = arr[i+2][x]+arr[i+2][x+1]+arr[i+2][x+2];
                if(top+middle+bottom>sum){sum=top+middle+bottom;}
            }
        }
        System.out.println(sum);


    }
    /*
    Same as mine, just using different bounds in the for loops
     */
}
