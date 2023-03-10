package NumberOfIslands_200;

import java.util.Arrays;

/**
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(m * n)
 * Runtime: 6ms
 * Rank: 7.69%
 */

class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[] id = new int[m * n];
        Arrays.fill(id, -1);

        int[] rank = new int[m * n];

        int index = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                index += 1;
                if (grid[i][j] == '1') {
                    // union left
                    if (j > 0 && grid[i][j - 1] == '1') {
                        union(id, rank, index, index - 1);
                    }
                    // union up
                    if (i > 0 && grid[i - 1][j] == '1') {
                        union(id, rank, index, index - n);
                    }
                } else {
                    // grid[i][j] == '0'
                    id[index] = -2;
                }
            }
        }

        int count = 0;
        for (int num : id) {
            if (num == -1) {
                count += 1;
            }
        }

        return count;

    }

    public int find(int[] id, int i) {
        while (id[i] != -1) {
            i = id[i];
        }

        return i;
    }

    public void union(int[] id, int[] rank, int i, int j) {
        int ri = find(id, i);
        int rj = find(id, j);

        if (ri != rj) {
            if (rank[ri] >= rank[rj]) {
                id[rj] = ri;
                if (rank[ri] == rank[rj]) {
                    rank[ri] += 1;
                }
            } else {
                id[ri] = rj;
            }
        }
    }
}