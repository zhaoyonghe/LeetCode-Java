package BeautifulArrangement_526;

/**
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 * Runtime: 21ms
 * Rank: 91.08%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= n <= 15.
    private final int[][] book = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            {1, 2, 4, 6, 8, 10, 12, 14, 0, 0, 0, 0, 0, 0, 0},
            {1, 3, 6, 9, 12, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 4, 8, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 5, 10, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 3, 6, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 7, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 4, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 3, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 5, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 3, 4, 6, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 7, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 3, 5, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        int[] res = new int[1];
        helper(0, n, res, visited);
        return res[0];
    }

    private void helper(int cur, int n, int[] res, boolean[] visited) {
        if (cur == n) {
            res[0]++;
            return;
        }
        for (int num : book[cur]) {
            if (num == 0 || num > n) {
                break;
            }
            if (visited[num]) {
                continue;
            }
            visited[num] = true;
            helper(cur + 1, n, res, visited);
            visited[num] = false;
        }
    }
}