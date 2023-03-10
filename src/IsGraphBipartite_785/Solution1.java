package IsGraphBipartite_785;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n ^ 2)
 * Runtime: 2ms
 * Rank: 56.14%
 */
public class Solution1 {
    // Important constraints:
    // 1. There are no self-edges (graph[u] does not contain u).
    // 2. There are no parallel edges (graph[u] does not contain duplicate values).
    // 3. If v is in graph[u], then u is in graph[v] (the graph is undirected).
    // 4. The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] mark = new int[n];
        boolean[][] visited = new boolean[n][n];
        for (int start = 0; start < n; start++) {
            if (mark[start] != 0) {
                continue;
            }
            if (!dfs(start, mark, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int start, int[] mark, boolean[][] visited, int[][] graph) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        mark[start] = 1;
        // All node in q should be marked.
        while (!q.isEmpty()) {
            // int sz = q.size();
            // for (int i = 0; i < sz; i++) {
            int cur = q.poll();
            int[] nexts = graph[cur];
            int should = 3 - mark[cur];
            for (int next : nexts) {
                if (visited[cur][next]) {
                    continue;
                }
                if (mark[next] != 0 && mark[next] != should) {
                    return false;
                }
                mark[next] = should;
                q.offer(next);
                visited[cur][next] = true;
                visited[next][cur] = true;
            }
            // }
        }
        return true;
    }
}