package CourseScheduleI;

import java.util.List;
import java.util.ArrayList;

/**
 * Best Time Complexity: O(|E|)
 * Worst Time Complexity: O(|E| ^ 2), when this graph is actually a linked list.
 * Space Complexity: O(|E|)
 * Runtime: 150ms
 * Rank: 14.42%
 */
public class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // edge: [a, b] a <- b
        List<int[]> graph = new ArrayList<>();
        for (int[] edge : prerequisites) {
            graph.add(edge);
        }

        int remainCourses = numCourses;

        while (graph.size() != 0) {
            // true: this node has indegree
            // false: this node has no indegree
            boolean[] classes = new boolean[numCourses];

            // the number of nodes that have indegree
            int count = 0;

            for (int[] edge : graph) {
                if (!classes[edge[0]]) {
                    count += 1;
                    classes[edge[0]] = true;
                }
            }

            if (count == remainCourses) {
                // every node has indegree
                return false;
            }

            remainCourses = count;

            List<int[]> newGraph = new ArrayList<>();

            for (int[] edge : graph) {
                if (classes[edge[1]]) {
                    // if the beginning of the edge has indegree
                    newGraph.add(edge);
                }
            }

            graph = newGraph;
        }

        return true;
    }
}
