public class MinimumSwapsTwo {

    //My first solution (runtime error for 4/14 test cases):
    static int minimumSwaps(int[] arr) {
        int numSwaps = 0;
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            if (arr[min_idx] < arr[i]) {
                ++numSwaps;
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        return numSwaps;

    }

    /*
    Tried to see if a simple selection sort would work, but of course I got a runtime error since
    there is probably an O(n) solution. Didn't really expect this to work but was worth a shot!
     */


    //My second solution (worked):
    static int minimumSwaps2(int[] arr) {
        //go through the array and look at each index.
        //if the current index is not the correct number,
        //swap it with the number in the index it is supposed to be in
        //repeat until current index has proper value, then continue in the list
        int numSwaps = 0;

        for (int i = 0; i < arr.length; ++i) {
            while (arr[i] != (i + 1)) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                ++numSwaps;
            }
        }

        return numSwaps;

    }


    //Answer (no idea how to interpret this):

    /*
    #include<bits/stdc++.h>
    using namespace
    std;

    int a[100005];
    bool visited[100005];

    int solve(int n) {
        pair<int, int> p[ n];

        for (int i = 0; i < n; i++) {
            p[i].first = a[i];

            // Storing the original position of a[i]
            p[i].second = i;
        }

        sort(p, p + n);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            //visited[i]=true indicates that index i belongs to a cycle that is already counted

            //p[i].second = i denotes that the ith element was at its correct position

            if (visited[i] || p[i].second == i)
                continue;

            int cycle_size = 0;
            int j = i;

            //Counting the size of the cycle
            while (!visited[j]) {
                visited[j] = 1;
                j = p[j].second;
                cycle_size++;
            }

            ans += (cycle_size - 1);
        }

        return ans;

    }

    int main() {

        int n;
        scanf("%d", & n);

        for (int i = 0; i < n; i++) {
            scanf("%d", & a[i]);
        }

        int ans = solve(n);
        printf("%d\n", ans);
        return 0;

    }
    */
}
