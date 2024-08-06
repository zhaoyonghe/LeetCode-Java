package AlienDictionary_269;

import java.util.*;

/**
 * $$ Assume n is the number of characters in words.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    class Solution {
        public String alienOrder(String[] words) {
            // Build the graph.
            Map<Character, List<Character>> g = new HashMap<>();
            for (String w : words) {
                for (char c : w.toCharArray()) {
                    g.putIfAbsent(c, new ArrayList<>());
                }
            }
            for (int i = 1; i < words.length; i++) {
                // edge cases.
                if (words[i - 1].equals(words[i])) {
                    continue;
                }
                if (words[i - 1].startsWith(words[i])) {
                    return "";
                }

                for (int j = 0; j < Math.min(words[i - 1].length(), words[i].length()); j++) {
                    char c1 = words[i - 1].charAt(j);
                    char c2 = words[i].charAt(j);
                    if (c1 == c2) {
                        continue;
                    }
                    // c1 < c2
                    // c1 -> c2 in g
                    g.get(c1).add(c2);
                    break;
                }
            }

            // Put all node without indegree to a queue.
            int[] indegree = new int[128];
            Arrays.fill(indegree, -1);
            for (char c : g.keySet()) {
                indegree[c] = 0;
            }
            for (List<Character> tos : g.values()) {
                tos.forEach(c -> {
                    indegree[c]++;
                });
            }
            Deque<Character> q = new ArrayDeque<>();
            for (int i = 0; i < 128; i++) {
                if (indegree[i] == 0) {
                    q.offer((char) i);
                }
            }

            // While the queue is not empty, remove queue.poll() out of the graph.
            // Put queue.poll() to the result.
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                char from = q.poll();
                sb.append(from);
                g.get(from).forEach(to -> {
                    indegree[to]--;
                    if (indegree[to] == 0) {
                        q.offer(to);
                    }
                });
            }
            if (sb.length() < g.size()) {
                return "";
            }
            return sb.toString();
        }
    }
}
