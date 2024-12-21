package M.MinimumHeightTrees;

import java.util.*;

/**
 * Best Time Complexity: O(|E|)
 * Worst Time Complexity: O(|E| ^ 2)
 * Space Complexity: O(|E|)
 * Runtime: 429ms
 * Rank: 19.10%
 */
public class Solution1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<int[]> graph = new ArrayList<>();
        Collections.addAll(graph, edges);

        int[] degrees = new int[n];
        for (int[] edge : graph) {
            degrees[edge[0]] += 1;
            degrees[edge[1]] += 1;
        }

        Set<Integer> nodeSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nodeSet.add(i);
        }

        // remove the vertices that have only one degree, until less or equal than two vertices remains
        while (nodeSet.size() > 2) {
            List<int[]> newGraph = new ArrayList<>();

            int[] minusDegree = new int[n];

            for (int[] edge : graph) {
                if (degrees[edge[0]] == 1 || degrees[edge[1]] == 1) {
                    minusDegree[edge[0]] += 1;
                    minusDegree[edge[1]] += 1;
                    if (degrees[edge[0]] == 1) {
                        nodeSet.remove(edge[0]);
                    } else {
                        nodeSet.remove(edge[1]);
                    }
                } else {
                    newGraph.add(edge);
                }
            }

            graph = newGraph;

            for (int i = 0; i < n; i++) {
                degrees[i] -= minusDegree[i];
            }
        }

        List<Integer> result = new ArrayList<>(nodeSet);

        return result;
    }
}
