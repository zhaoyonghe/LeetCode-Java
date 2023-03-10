package KeysAndRooms;

import java.util.List;

/**
 * Assume rooms graph G is (V, E).
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int i) {
        visited[i] = true;
        List<Integer> nei = graph.get(i);

        for (int node : nei) {
            if (!visited[node]) {
                dfs(graph, visited, node);
            }
        }
    }
}
