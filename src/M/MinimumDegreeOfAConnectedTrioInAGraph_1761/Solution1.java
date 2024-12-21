package M.MinimumDegreeOfAConnectedTrioInAGraph_1761;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Time Complexity: O(edges.length * n)
 * Space Complexity: O(edges.length)
 * Runtime: 2071ms
 * Rank: 14.91%
 */
public class Solution1 {
    public int minTrioDegree(int n, int[][] edges) {
        List<Set<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            int a = --edge[0], b = --edge[1];
            g.get(a).add(b);
            g.get(b).add(a);
        }

        int res = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            // ui != vi, so we can safely find trio based on (ui, vi).
            int a = edge[0], b = edge[1];
            Set<Integer> aEdge = g.get(a);
            Set<Integer> bEdge = g.get(b);
            int abEdgeSize = aEdge.size() + bEdge.size();
            if (aEdge.size() > bEdge.size()) {
                Set<Integer> tmp = aEdge;
                aEdge = bEdge;
                bEdge = tmp;
            }
            for (int c : aEdge) {
                if (!bEdge.contains(c)) {
                    continue;
                }
                int abcDegree = abEdgeSize + g.get(c).size() - 6;
                res = Math.min(res, abcDegree);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}