package R.RedundantConnectionII;

import java.util.Arrays;

/**
 * Time Complexity: O(edges.length)
 * Space Complexity: O(edges.length)
 * Runtime: 1ms
 * Rank: 99.70%
 */

class Solution2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[][] pointTo = new int[n + 1][3];
        int[] candidateEdgeA = null, candidateEdgeB = null;
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            pointTo[edge[1]][pointTo[edge[1]][2]] = i;
            pointTo[edge[1]][2]++;
            if (pointTo[edge[1]][2] == 2) {
                candidateEdgeA = edges[pointTo[edge[1]][0]];
                candidateEdgeB = edges[pointTo[edge[1]][1]];
                break;
            }
        }

        int[] heights = new int[n + 1];
        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);

        if (candidateEdgeA == null) {
            for (int[] edge : edges) {
                if (union(parents, heights, edge[0], edge[1])) {
                    return edge;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == candidateEdgeB[0] && edge[1] == candidateEdgeB[1]) {
                continue;
            }
            if (union(parents, heights, edge[0], edge[1])) {
                return candidateEdgeA;
            }
        }

        return candidateEdgeB;
    }

    private int find(int[] parents, int node) {
        while (parents[node] != -1) {
            node = parents[node];
        }
        return node;
    }

    private boolean union(int[] parents, int[] heights, int a, int b) {
        int ra = find(parents, a);
        int rb = find(parents, b);

        if (ra == rb) {
            return true;
        }

        if (heights[ra] > heights[rb]) {
            parents[rb] = ra;
        } else {
            parents[ra] = rb;
            if (heights[ra] == heights[rb]) {
                heights[rb]++;
            }
        }

        return false;
    }
}