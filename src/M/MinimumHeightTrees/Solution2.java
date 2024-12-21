package M.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity: O(|E|)
 * Space Complexity: O(|E|)
 * Runtime: 14ms
 * Rank: 98.38%
 */

class Solution2 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            return new ArrayList<Integer>() {
                {
                    add(0);
                }
            };
        }

        // n is |V|

        int[] connect = new int[n];
        int[] degrees = new int[n];

        // O(|E|)
        for (int[] edge : edges) {
            degrees[edge[0]] += 1;
            degrees[edge[1]] += 1;

            connect[edge[0]] ^= edge[1];
            connect[edge[1]] ^= edge[0];
        }

        Queue<Integer> queue = new LinkedList<>();
        // O(|V|)
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.offer(i);
            }
        }

        while (n > 2) {
            // when nodes remain is greater than 2
            int size = queue.size();
            // this loop will delete all nodes which degree are 1
            // and add all nodes which degree are 1 after this round of delete into queue
            for (int i = 0; i < size; i++) {
                int v1 = queue.poll();
                n -= 1;

                // the only vertex that v1 attaches
                int v = connect[v1];

                // remove the connection to v1
                connect[v] ^= v1;

                degrees[v] -= 1;

                if (degrees[v] == 1) {
                    queue.offer(v);
                }
            }
        }

        return new ArrayList<Integer>(queue);
    }
}
