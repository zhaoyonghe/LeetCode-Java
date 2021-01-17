package MaximumLengthOfRepeatedSubarray;

/**
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 * Runtime: 69ms
 * Rank: 28.16%
 */
public class Solution1 {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            if (A[0] == B[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
            }
        }

        int res = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A[i] == B[j] && A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (A[i] == B[j] && A[i - 1] != B[j - 1]) {
                    dp[i][j] = 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
