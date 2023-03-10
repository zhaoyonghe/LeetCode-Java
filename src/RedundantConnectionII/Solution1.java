package RedundantConnectionII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(edges.length)
 * Space Complexity: O(edges.length)
 * Runtime: 3ms
 * Rank: 34.27%
 */
public class Solution1 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[][] g = new int[n + 1][3];
        for (int[] edge : edges) {
            g[edge[1]][g[edge[1]][2]] = edge[0];
            g[edge[1]][2] += 1;
        }

        int root = -1;
        int twoparent = -1;

        for (int i = 1; i <= n; i++) {
            if (g[i][2] == 0) {
                root = i;
                continue;
            }
            if (g[i][2] == 2) {
                twoparent = i;
            }
        }

        // System.out.println(root);
        // System.out.println(twoparent);

        if (root == -1) {
            // cannot find the root, solve it like redundant connection I
            int[] un = new int[n + 1];
            int[] rank = new int[n + 1];

            Arrays.fill(un, -1);

            for (int[] edge : edges) {
                if (union(un, rank, edge[0], edge[1])) {
                    return edge;
                }
            }

            return new int[]{0, 0};
        } else {
            // root != -1
            // two candidates: (g[twoparent][1], twoparent) and (g[twoparent][0], twoparent)
            // remove the first candidate, if all nodes are reachable from root, return it
            // otherwise return the second one
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                if (edge[0] != g[twoparent][1] || edge[1] != twoparent) {
                    graph.get(edge[0]).add(edge[1]);
                }
            }
            boolean[] visited = new boolean[n];
            dfs(graph, visited, root);
            for (boolean visit : visited) {
                if (!visit) {
                    return new int[]{g[twoparent][0], twoparent};
                }
            }
            return new int[]{g[twoparent][1], twoparent};
        }
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int i) {
        visited[i - 1] = true;
        List<Integer> nei = graph.get(i);
        for (int node : nei) {
            if (!visited[node - 1]) {
                dfs(graph, visited, node);
            }
        }
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
