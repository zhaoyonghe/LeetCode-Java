package RedundantConnectionI;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(edges.length)
 * Space Complexity: O(edges.length)
 * Runtime: 7ms
 * Rank: 23.31%
 */
public class Solution1 {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new HashMap<Integer, Integer>());
            graph.putIfAbsent(edges[i][1], new HashMap<Integer, Integer>());

            graph.get(edges[i][0]).put(edges[i][1], i);
            graph.get(edges[i][1]).put(edges[i][0], i);
        }

        boolean[] visited = new boolean[edges.length + 1];
        Deque<Integer> stack = new ArrayDeque<>();

        // find cycle and its path
        dfs(graph, edges[0][0], visited, stack);

        //System.out.println(stack);

        int a = stack.peek();
        int maxIndex = -1;

        while (true) {
            int t = stack.pop();
            int s = stack.peek();
            maxIndex = Math.max(maxIndex, graph.get(s).get(t));
            if (s == a) {
                break;
            }
        }
        return edges[maxIndex];
    }

    public boolean dfs(HashMap<Integer, HashMap<Integer, Integer>> graph, int s, boolean[] visited, Deque<Integer> stack) {
        visited[s] = true;
        stack.push(s);

        for (Map.Entry<Integer, Integer> entry : graph.get(s).entrySet()) {
            int t = entry.getKey();
            // do not go back
            graph.get(t).remove(s);
            if (visited[t]) {
                stack.push(t);
                return true;
            } else {
                if (dfs(graph, t, visited, stack)) {
                    return true;
                }
            }
        }

        stack.pop();
        return false;
    }
}
