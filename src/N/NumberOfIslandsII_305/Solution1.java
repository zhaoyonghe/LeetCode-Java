package N.NumberOfIslandsII_305;

/**
 * Time Complexity: O(m * n + len(positions))
 * Auxiliary Space Complexity: O(m * n)
 * Runtime: 8ms
 * Rank: 86.82%
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int all = m * n;
        int[] roots = new int[all];
        Arrays.fill(roots, -2);
        int[] ranks = new int[all];
        List<Integer> res = new ArrayList<>();

        // down, up, right, left.
        int[][] directions = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        int count = 0;

        for (int[] pos : positions) {
            int i = pos[0] * n + pos[1];
            if (roots[i] != -2) {
                res.add(count);
                continue;
            }
            // Mark (pos[0], pos[1]) as land.
            roots[i] = -1;
            count++;
            for (int[] dir : directions) {
                if (!valid(pos, dir, m, n)) {
                    continue;
                }
                int j = i + dir[0] * n + dir[1];
                if (roots[j] == -2) {
                    continue;
                }
                count += union(roots, ranks, i, j);
            }
            res.add(count);
        }

        return res;
    }

    private boolean valid(int[] pos, int[] dir, int m, int n) {
        int r = pos[0] + dir[0];
        int c = pos[1] + dir[1];
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }

    private int union(int[] roots, int[] ranks, int i, int j) {
        int ri = find(roots, i);
        int rj = find(roots, j);
        if (ri == rj) {
            return 0;
        }

        if (ranks[ri] >= ranks[rj]) {
            roots[rj] = ri;
            if (ranks[ri] == ranks[rj]) {
                ranks[ri]++;
            }
        } else {
            roots[ri] = rj;
        }
        return -1;
    }
}
