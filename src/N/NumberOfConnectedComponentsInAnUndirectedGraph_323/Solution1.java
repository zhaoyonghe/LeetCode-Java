package N.NumberOfConnectedComponentsInAnUndirectedGraph_323;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(g, i, visited);
            count++;
        }

        return count;
    }

    private void dfs(List<List<Integer>> g, int cur, boolean[] visited) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        for (int next : g.get(cur)) {
            dfs(g, next, visited);
        }
    }
}