import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        int maxProfit = solution.jobScheduling(startTime, endTime, profit);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        // Combine startTime, endTime, and profit into Job objects
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // Sort jobs based on end times
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        // Iterate through each job
        for (int i = 1; i < n; i++) {
            // Include the current job's profit
            int inclProf = jobs[i].profit;
            int idx = binarySearch(jobs, i);
            if (idx != -1) {
                inclProf += dp[idx];
            }

            // Get the maximum profit by either including or excluding the current job
            dp[i] = Math.max(inclProf, dp[i - 1]);
        }

        return dp[n - 1];
    }

    // Binary search to find the latest non-overlapping job index
    private int binarySearch(Job[] jobs, int i) {
        int low = 0, high = i - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[i].start) {
                if (jobs[mid + 1].end <= jobs[i].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1; // If no such non-overlapping job is found
    }
}
class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}