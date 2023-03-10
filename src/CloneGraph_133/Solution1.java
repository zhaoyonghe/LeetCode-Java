package CloneGraph_133;

import java.util.*;

/**
 * Time Complexity: O(|E| + |V|)
 * Auxiliary Space Complexity: O(|V|)
 * Runtime: 26ms
 * Rank: 79.49%
 */
public class Solution1 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);
        Node nodeClone = new Node(node.val, new ArrayList<>());
        map.put(node, nodeClone);
        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                Node curClone = map.get(cur);
                for (Node next: cur.neighbors) {
                    if (!map.containsKey(next)) {
                        // next is not visited.
                        Node nextClone = new Node(next.val, new ArrayList<>());
                        map.put(next, nextClone);
                        curClone.neighbors.add(nextClone);
                        q.offer(next);
                    } else {
                        curClone.neighbors.add(map.get(next));
                    }
                }
            }
        }
        return nodeClone;
    }
}
