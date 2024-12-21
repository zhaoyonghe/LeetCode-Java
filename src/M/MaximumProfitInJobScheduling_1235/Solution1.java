package M.MaximumProfitInJobScheduling_1235;

import java.util.Arrays;

/**
 * Time Complexity: O(profit.length)
 * Space Complexity: O(profit.length)
 * Runtime: 33ms
 * Rank: 81.84%
 */
public class Solution1 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Important constraints:
        // 1. 1 <= startTime.length == endTime.length == profit.length (lengths are matched)
        // 2. 1 <= startTime[i] < endTime[i] <= 10^9 (times are valid)
        // 3. 1 <= profit[i] <= 10^4 (profits are positive; dp will never overflow)
        int n = startTime.length;
        Job[] jobs = new Job[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            int j = findFirstNonOverlap(jobs, i);
            if (j == -1) {
                dp[i] = Math.max(dp[i - 1], jobs[i].profit);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[j] + jobs[i].profit);
        }
        return dp[n - 1];
    }

    private int findFirstNonOverlap(Job[] jobs, int cur) {
        int s = 0, e = cur - 1, bound = jobs[cur].start;
        while (s <= e) {
            int mid = (s + e) / 2; // mid <= e < cur <= jobs.length - 1
            if (jobs[mid].end <= bound) {
                if (mid + 1 <= e && jobs[mid + 1].end <= bound) {
                    s = mid + 1;
                    continue;
                }
                return mid;
            } else {
                // jobs[mid].end > bound
                e = mid - 1;
            }
        }
        return -1;
    }

    class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}