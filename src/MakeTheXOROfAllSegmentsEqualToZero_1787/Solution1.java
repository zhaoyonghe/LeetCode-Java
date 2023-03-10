package MakeTheXOROfAllSegmentsEqualToZero_1787;

/**
 * Assume n is nums.length, the biggest number in nums is m.
 * Time Complexity: n+m+k(m+mn/k) = O(mn)
 * Space Complexity: O(k(m+n))
 * Runtime: 83ms
 * Rank: 75.48%
 */

public class Solution1 {
    public int minChanges(int[] nums, int k) {
        int biggest = 1 << 10;
        int[][] count = new int[k][biggest];
        int[] all = new int[k];
        int[] distinctCount = new int[k];
        int[][] distinct = new int[k][nums.length];
        for (int i = 0; i < nums.length; i++) {
            all[i % k]++;
            if (count[i % k][nums[i]] == 0) {
                distinct[i % k][distinctCount[i % k]++] = nums[i];
            }
            count[i % k][nums[i]]++;
        }

        int[] dp = new int[biggest];
        int[] ndp = new int[biggest];
        for (int j = 0; j < biggest; j++) {
            dp[j] = all[0] - count[0][j];
        }

        for (int i = 1; i < k; i++) {
            int prev_min = getMin(dp);
            for (int j = 0; j < biggest; j++) {
                ndp[j] = all[i] + prev_min;
                for (int index = 0; index < distinctCount[i]; index++) {
                    int x = distinct[i][index];
                    ndp[j] = Math.min(ndp[j], dp[j ^ x] + all[i] - count[i][x]);
                }
            }
            int[] tmp = dp;
            dp = ndp;
            ndp = tmp;
        }
        return dp[0];
    }

    private int getMin(int[] arr) {
        int res = arr[0];
        for (int x : arr) {
            res = Math.min(res, x);
        }
        return res;
    }
}
