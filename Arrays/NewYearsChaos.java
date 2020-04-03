public class NewYearsChaos {

    //My first solution (didn't work, runtime error):
    static void minimumBribes(int[] q) {
        //create an array to keep track of how many times a number has moved
        int[] numMoves = new int[q.length + 1];
        int[] answer = q;
        int counter = 0;
        while(checkOrder(answer) == false){
            for(int i = 0; i < answer.length - 1; i++){
                if(answer[i] > answer[i+1]){
                    numMoves[answer[i]] += 1;

                    if(numMoves[answer[i]] > 2){
                        System.out.println("Too chaotic");
                        return;
                    }
                    answer = swap(answer, i, i+1);
                    counter++;
                    break;
                }
            }
        }
        System.out.println(counter);
    }

    static int[] swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        int[] answer = arr;
        answer[index1] = answer[index2];
        answer[index2] = temp;
        return answer;
    }

    static boolean checkOrder(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] != arr[i+1] - 1){
                return false;
            }
        }
        return true;
    }


    //My second solution (worked):
    static void minimumBribes2(int[] q) {
        int expectedFirstNum = 1;
        int expectedSecondNum = 2;
        int expectedThirdNum = 3;
        int counter = 0;

        for(int i = 0; i < q.length; ++i){
            //only 3 possibilities:
            //the current position is the number it's supposed to be
            //the current position is the number it's supposed to be + 1
            //the current position is the number it's supposed to be + 2
            //if anything else occurs, the queue is too chaotic

            //each time you encounter a possibility, set the expected numbers above what you found equal to the next one, and increase the max (3rd) expected number
            if(q[i] == expectedFirstNum){
                expectedFirstNum = expectedSecondNum;
                expectedSecondNum = expectedThirdNum;
                ++expectedThirdNum;
            } else if(q[i] == expectedSecondNum){
                ++counter;
                expectedSecondNum = expectedThirdNum;
                ++expectedThirdNum;
            } else if(q[i] == expectedThirdNum){
                counter += 2;
                ++expectedThirdNum;
            } else {
                System.out.println("Too chaotic");
                return;
            }

        }
        System.out.println(counter);

    }




    //Answer (C++):
    /*
    void minimumBribes(vector<int> A) {
        int n = A.size();
        int cnt = 0;
        for(int i = n - 1; i >= 0; i--){
            if(A[i] != (i + 1)){
                if(((i - 1) >= 0) && A[i - 1] == (i + 1)){
                    cnt++;
                    swap(A[i], A[i-1]);
                } else if(((i - 2) >= 0) && A[i - 2] == (i + 1)){
                    cnt += 2;
                    A[i - 2] = A[i - 1];
                    A[i - 1] = A[i];
                    A[i] = i + 1;
                } else {
                    printf("Too chaotic\n");
                    return;
                }
            }
        }
        printf("%d\n",cnt);
        return;
    }
     */
}
