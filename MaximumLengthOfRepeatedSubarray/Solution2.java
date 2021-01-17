package MaximumLengthOfRepeatedSubarray;

/**
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 * Runtime: 43ms
 * Rank: 94.93%
 */

public class Solution2 {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (A[0] == B[j]) {
                dp1[j] = 1;
                res = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            dp2[0] = (A[i] == B[0]) ? 1 : 0;
            res = Math.max(res, dp2[0]);
            for (int j = 1; j < n; j++) {
                if (A[i] != B[j]) {
                    continue;
                }
                // A[i] == B[j] && A[i- 1] == B[j-1]
                if (A[i - 1] == B[j - 1]) {
                    dp2[j] = dp1[j - 1] + 1;
                    res = Math.max(res, dp2[j]);
                    continue;
                }
                // A[i] == B[j] && A[i- 1] != B[j-1]
                dp2[j] = 1;
                res = Math.max(res, dp2[j]);
            }
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
        }

        return res;
    }
}
