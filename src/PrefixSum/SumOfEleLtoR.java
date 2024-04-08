package PrefixSum;

import java.util.Arrays;

public class SumOfEleLtoR {
    public static void main(String[] args) {
        int[] arr = {-3,6,2,4,3,2,8,-9,3,1};
        int[][] queries = {
            {4,8},{3,7},{1,3},{0,4}
        };

        int N = arr.length; int q_length = queries.length;
        int[] output = new int[q_length];

        int[] PrefixSumArr = new int[N];
        for(int i = 0; i < N; i++){
            if (i == 0){
                PrefixSumArr[i] = arr[i];
            }
            else{
                PrefixSumArr[i] = arr[i]+PrefixSumArr[i-1];
            }
        }
        System.out.println(Arrays.toString(PrefixSumArr));
        int ans = 0;
        int i = 0;
        while (i < q_length) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (left != 0){ans = PrefixSumArr[right] - PrefixSumArr[left-1];}
            else {ans = PrefixSumArr[right-1];}
            output[i] = ans;
            i++;
        }
        System.out.printf("Here is the output with TC: O(N+Q) and SC: O(N+Q) "+Arrays.toString(output));
    }
}
