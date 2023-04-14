package OnesAndZeroes_474;

/**
 * $$ Time Complexity: O(m * n * strs.length)
 * $$ Space Complexity: O(m * n)
 */
public class Solution1 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int[] cnt = count(str);
            if (cnt[0] > m || cnt[1] > n) {
                continue;
            }
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (dp[i][j] == 0) {
                        continue;
                    }
                    int nextZeroes = i + cnt[0];
                    int nextOnes = j + cnt[1];
                    if (nextZeroes > m || nextOnes > n) {
                        continue;
                    }
                    dp[nextZeroes][nextOnes] = Math.max(dp[nextZeroes][nextOnes], dp[i][j]+1);
                }
            }
            dp[cnt[0]][cnt[1]] = Math.max(dp[cnt[0]][cnt[1]], 1);
        }

        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    private int[] count(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c-'0']++;
        }
        return res;
    }
}