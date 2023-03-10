package LongestIncreasingPathInAMatrix_329;

import java.util.*;
/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * Runtime: 36ms
 * Rank: 15.77%
 */
public class Solution1 {
    public int longestIncreasingPath(int[][] matrix) {
        // 1 <= m, n <= 200
        int m = matrix.length;
        int n = matrix[0].length;
        Integer[][] dp = new Integer[m][n];
        // up, down, left, right
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int res = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != null) {
                    continue;
                }
                Deque<int[]> st = new ArrayDeque<>();
                st.push(new int[]{i,j,0});
                while (!st.isEmpty()) {
                    int[] cur = st.peek();
                    int cx = cur[0], cy = cur[1];
                    int[] dir = dirs[cur[2]];
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    dp[cx][cy] = dp[cx][cy] == null ? 1 : dp[cx][cy];
                    if (out(nx,ny,m,n) || matrix[nx][ny] <= matrix[cx][cy]){
                        cur[2]++;
                        if (cur[2] == 4) {
                            st.pop();
                        }
                        continue;
                    }
                    if (dp[nx][ny] != null) {
                        dp[cx][cy] = Math.max(dp[cx][cy], 1 + dp[nx][ny]);
                        cur[2]++;
                        if (cur[2] == 4) {
                            st.pop();
                        }
                        continue;
                    }
                    st.push(new int[]{nx, ny, 0});
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    private boolean out(int i, int j, int m, int n) {
        return i < 0 || j < 0 || i >= m || j >= n;
    }
}