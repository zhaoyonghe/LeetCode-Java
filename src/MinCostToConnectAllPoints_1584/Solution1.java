package MinCostToConnectAllPoints_1584;

import java.util.Arrays;

/**
 * $$ Assume points.length is n.
 * $$ Time Complexity: O(n^2logn)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[(n * n - n) / 2][3];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                edges[k++] = new int[]{i, j, Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])};
            }
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[] uf = new int[n];
        int[] ranks = new int[n];
        Arrays.fill(uf, -1);
        int res = 0;
        int count = 0;
        for (int[] edge : edges) {
            if (unionIfNot(uf, ranks, edge[0], edge[1])) {
                res += edge[2];
                count++;
                if (count == n - 1) {
                    break;
                }
            }
        }
        return res;
    }

    private int root(int[] uf, int i) {
        while (uf[i] != -1) {
            i = uf[i];
        }
        return i;
    }

    private boolean unionIfNot(int[] uf, int[] ranks, int i, int j) {
        int ri = root(uf, i);
        int rj = root(uf, j);
        if (ri == rj && ri != -1) {
            return false;
        }

        if (ranks[ri] < ranks[rj]) {
            uf[ri] = rj;
        } else if (ranks[ri] > ranks[rj]) {
            uf[rj] = ri;
        } else {
            uf[ri] = rj;
            ranks[rj]++;
        }

        return true;
    }
}