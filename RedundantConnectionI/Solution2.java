package RedundantConnectionI;

import java.util.Arrays;

/**
 * Time Complexity: O(edges.length)
 * Space Complexity: O(edges.length)
 * Runtime: 1ms
 * Rank: 99.77%
 */
public class Solution2 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] un = new int[n + 1];
        int[] rank = new int[n + 1];

        Arrays.fill(un, -1);

        for (int[] edge : edges) {
            if (union(un, rank, edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[]{0, 0};
    }

    public boolean union(int[] un, int[] rank, int i, int j) {
        int rooti = find(un, i);
        int rootj = find(un, j);

        if (rooti == rootj) {
            return true;
        }

        if (rank[rooti] > rank[rootj]) {
            un[rootj] = rooti;
        } else {
            un[rooti] = rootj;
            if (rank[rooti] == rank[rootj]) {
                rank[rootj] += 1;
            }
        }
        return false;
    }

    public int find(int[] un, int i) {
        while (un[i] != -1) {
            i = un[i];
        }
        return i;
    }
}
