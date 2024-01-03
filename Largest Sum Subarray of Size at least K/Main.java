import java.util.*;
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test cases
        long[] arr1 = {1, -2, 2, -3};
        long n1 = 4;
        long k1 = 2;
        System.out.println("Example 1: " + solution.maxSumWithK(arr1, n1, k1));  // Output: 1

        long[] arr2 = {1, 1, 1, 1, 1, 1};
        long n2 = 6;
        long k2 = 2;
        System.out.println("Example 2: " + solution.maxSumWithK(arr2, n2, k2));  // Output: 6

        // Additional test cases
        long[] arr3 = {1, 2, 3, 4, 5};
        long n3 = 5;
        long k3 = 3;
        System.out.println("Additional Test: " + solution.maxSumWithK(arr3, n3, k3));  // Output: 12
    }
}
class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        // maxSum[i] is going to store maximum sum till index i.
        long[] maxSum = new long[(int) n];
        maxSum[0] = a[0];

        // Using Kadane's algorithm to fill maxSum[]
        long currMax = a[0];
        for (int i = 1; i < n; i++) {
            currMax = Math.max(a[i], currMax + a[i]);
            maxSum[i] = currMax;
        }

        // Sum of first k elements
        long sum = 0;
        for (int i = 0; i < k; i++) sum += a[i];

        // Using the concept of sliding window
        long result = sum;
        for (int i = (int) k; i < n; i++) {
            // Compute sum of k elements ending with a[i]
            sum = sum + a[i] - a[i - (int) k];

            // Update result if required
            result = Math.max(result, sum);

            // Include maximum sum till [i-k] also if it increases overall max
            result = Math.max(result, sum + maxSum[i - (int) k]);
        }
        return result;
    }
}
